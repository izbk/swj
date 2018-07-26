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
import cn.com.yuanwei.center.entity.Forecast;
import cn.com.yuanwei.center.service.ForecastService;
import cn.com.yuanwei.center.util.ExcelUtils;
import cn.com.yuanwei.center.web.request.ForecastReq;
import cn.com.yuanwei.center.web.response.ForecastLtResp;
import cn.com.yuanwei.center.web.response.base.Result;
import io.swagger.annotations.Api;

@Api(value = "forecast", description = "总量预测结果表", produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
@RequestMapping("/forecasts")
public class ForecastController {
	Log logger = LogFactory.getLog(ForecastController.class);
	@Autowired
	private ForecastService forecastService;

	/**
	 * Desc: 新增处理
	 * @param @param req
	 * @param @return
	 * @param @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-04-24 10:29:45
	 */
	@PostMapping
	@ResponseBody
	@Auth
	public Result createForecast(@RequestBody Forecast req) throws Exception{
		forecastService.save(req);
		return new Result();
	}
	/**
	 * Desc:编辑处理
	 * @param @param req
	 * @param @return
	 * @param @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-04-24 10:29:45
	 */
	@PutMapping
	@ResponseBody
	@Auth
	public Result editForecast(@RequestBody Forecast req) throws Exception{
		forecastService.update(req);
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
	public Result calcForecast(ForecastReq req) throws Exception{
		ForecastLtResp resp=forecastService.calc(req);
		Result re = new Result(resp.getForecastLt());
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
	 * @date 2017-04-24 10:29:45
	 */
	@DeleteMapping
	@ResponseBody
	@Auth
	public Result delForecast(@RequestParam(value="ids") List<Integer> req) throws Exception{
		forecastService.delete(req);
		return new Result();
	}
	/**
	 * Desc:查询列表
	 * @param @param req
	 * @param @return
	 * @param @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-04-24 10:29:45
	 */
	@GetMapping
	@ResponseBody
	@Auth
	public Result getForecastList(ForecastReq req) throws Exception{
		ForecastLtResp resp= forecastService.queryList(req);
		Result re = new Result(resp.getForecastLt());
		re.setCount(resp.getCount());
		return re;
	}
	
	/**
	 * Excel文件导入
	 * @param request
	 * @param response
	 * @return Result
	 * @throws Exception
	 * @author zbk
	 * @date 2017-05-10 10:53:52
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
				List<Forecast> forecasts = ExcelImportUtil.importExcel(file.getInputStream(),Forecast.class,params);
				for (Forecast forecast : forecasts) {
					forecastService.save(forecast);
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
	 * @date 2017-05-10 10:53:52
	 */
	@GetMapping(value="export")
	public void exportXls(ForecastReq req,HttpServletRequest request, HttpServletResponse response) throws Exception {
		//重置分页参数
		req.setPage(1);
		req.setItemcount(Integer.MAX_VALUE);
		//获取数据
		ForecastLtResp resp= forecastService.queryList(req);
		Map<String, Object> model = new HashMap<String,Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		model.put(NormalExcelConstants.FILE_NAME,"总量预测结果表");
		model.put(NormalExcelConstants.CLASS,Forecast.class);
		model.put(NormalExcelConstants.PARAMS,new ExportParams("总量预测结果表", "导出时间:"+sdf.format(new Date()),"导出信息"));
		model.put(NormalExcelConstants.DATA_LIST,resp.getForecastLt());
		ExcelUtils.exportDataToSingleExcel(model, request, response);
	}
	
	/**
	 * 导出excel模板
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @author zbk
	 * @date 2017-05-10 10:53:52
	 */
	@GetMapping(value="exportTpl")
	public void exportXlsByT(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String,Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		model.put(NormalExcelConstants.FILE_NAME,"总量预测结果表模板");
		model.put(NormalExcelConstants.CLASS,Forecast.class);
		model.put(NormalExcelConstants.PARAMS,new ExportParams("总量预测结果表模板", "导出时间:"+sdf.format(new Date()),"导出信息"));
		model.put(NormalExcelConstants.DATA_LIST,new ArrayList<Object>());
		ExcelUtils.exportDataToSingleExcel(model, request, response);
	}	
	
}
