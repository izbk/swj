package cn.com.yuanwei.center.web;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.com.yuanwei.center.annotation.Auth;
import cn.com.yuanwei.center.entity.ForecastDetail;
import cn.com.yuanwei.center.service.ForecastDetailService;
import cn.com.yuanwei.center.util.ExcelUtils;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.ForecastDetailReq;
import cn.com.yuanwei.center.web.response.ForecastDetailLtResp;
import cn.com.yuanwei.center.web.response.base.Result;
import io.swagger.annotations.Api;

@Api(value = "forecastDetail", description = "企业预测结果表", produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
@RequestMapping("/forecastDetails")
public class ForecastDetailController {
	Log logger = LogFactory.getLog(ForecastDetailController.class);
	@Autowired
	private ForecastDetailService forecastDetailService;

	/**
	 * Desc: 新增处理
	 * @param @param req
	 * @param @return
	 * @param @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-04-24 10:28:06
	 */
	@PostMapping
	@ResponseBody
	@Auth
	public Result createForecastDetail(@RequestBody List<ForecastDetail> list) throws Exception{
		forecastDetailService.batchSave(list);
		return new Result();
	}
	/**
	 * Desc:编辑处理
	 * @param @param req
	 * @param @return
	 * @param @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-04-24 10:28:06
	 */
	@PutMapping
	@ResponseBody
	@Auth
	public Result editForecastDetail(@RequestBody ForecastDetail req) throws Exception{
		forecastDetailService.update(req);
		return new Result();
	}
	/**
	 * Desc:预测处理
	 * @param @param req
	 * @param @return
	 * @param @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-04-24 10:29:45
	 */
	@GetMapping(value="calc")
	@ResponseBody
	@Auth
	public Result calcForecastDetail(ForecastDetailReq req) throws Exception{
		ForecastDetailLtResp resp = forecastDetailService.calc(req);
		Result re = new Result(resp.getForecastDetailLt());
		re.setCount(resp.getCount());
		return re;
	}
	/**
	 * Desc:删除处理
	 * @param @param req
	 * @param @return
	 * @param @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-04-24 10:28:06
	 */
	@DeleteMapping
	@ResponseBody
	@Auth
	public Result delForecastDetail(@RequestParam(value="ids") List<Integer> req) throws Exception{
		forecastDetailService.delete(req);
		return new Result();
	}
	/**
	 * Desc:查询列表
	 * @param @param req
	 * @param @return
	 * @param @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-04-24 10:28:06
	 */
	@GetMapping
	@ResponseBody
	@Auth
	public Result getForecastDetailList(ForecastDetailReq req) throws Exception{
		ForecastDetailLtResp resp= forecastDetailService.queryList(req);
		Result re = new Result(resp.getForecastDetailLt());
		re.setCount(resp.getCount());
		return re;
	}
	/**
	 * Desc:查询详情
	 * @param @param req
	 * @param @return
	 * @param @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-04-24 10:28:06
	 */
	@GetMapping(value="id")
	@ResponseBody
	public Result getForecastDetailById(Integer id) throws Exception{
		ForecastDetail forecastDetail= forecastDetailService.queryById(id);
		Result re = new Result(forecastDetail);
		re.setCount(1L);
		return re;
	}
	/**
	 * Desc:查询一条记录
	 * @param @param req
	 * @param @return
	 * @param @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-04-24 10:28:06
	 */
	@GetMapping(value="single")
	@ResponseBody
	public Result getForecastDetail(ForecastDetailReq req) throws Exception{
		ForecastDetailLtResp resp= forecastDetailService.queryList(req);
		List<ForecastDetail> list = resp.getForecastDetailLt();
		ForecastDetail forecastDetail = null;
		if(!ValidateUtil.isEmpty(list)){
			forecastDetail = list.get(0);
		}
		Result re = new Result(forecastDetail);
		re.setCount(1L);
		return re;
	}
	
	/**
	 * Excel文件导入
	 * @param request
	 * @param response
	 * @return Result
	 * @throws Exception
	 * @author zbk
	 * @date 2017-05-10 10:53:51
	 */
	@PostMapping(value="import")
	@ResponseBody
	public Result importExcel(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Result result = new Result();
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setHeadRows(1);
			params.setNeedSave(false);
			try {
				List<ForecastDetail> forecastDetails = ExcelImportUtil.importExcel(file.getInputStream(),ForecastDetail.class,params);
				for (ForecastDetail forecastDetail : forecastDetails) {
					forecastDetailService.save(forecastDetail);
				}
			} catch (Exception e) {
				throw new Exception("导入数据错误");
			}finally{
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	/**
	 * 导出excel数据
	 * @param req
	 * @param request
	 * @param response
	 * @return 
	 * @throws Exception
	 * @author zbk
	 * @date 2017-05-10 10:53:51
	 */
	@GetMapping(value="export")
	public void exportXls(ForecastDetailReq req,HttpServletRequest request, HttpServletResponse response) throws Exception {
		//重置分页参数
		req.setPage(1);
		req.setItemcount(Integer.MAX_VALUE);
		//获取数据
		ForecastDetailLtResp resp= forecastDetailService.queryList(req);
		Map<String, Object> model = new HashMap<String,Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		model.put(NormalExcelConstants.FILE_NAME,"企业预测结果表");
		model.put(NormalExcelConstants.CLASS,ForecastDetail.class);
		model.put(NormalExcelConstants.PARAMS,new ExportParams("企业预测结果表", "导出时间:"+sdf.format(new Date()),"导出信息"));
		model.put(NormalExcelConstants.DATA_LIST,resp.getForecastDetailLt());
		ExcelUtils.exportDataToSingleExcel(model, request, response);
	}
	
	/**
	 * 导出excel模板
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @author zbk
	 * @date 2017-05-10 10:53:51
	 */
	@GetMapping(value="exportTpl")
	public void exportXlsByT(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String,Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		model.put(NormalExcelConstants.FILE_NAME,"企业预测结果表模板");
		model.put(NormalExcelConstants.CLASS,ForecastDetail.class);
		model.put(NormalExcelConstants.PARAMS,new ExportParams("企业预测结果表模板", "导出时间:"+sdf.format(new Date()),"导出信息"));
		model.put(NormalExcelConstants.DATA_LIST,new ArrayList<Object>());
		ExcelUtils.exportDataToSingleExcel(model, request, response);
	}	
	
	
}
