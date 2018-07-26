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
import cn.com.yuanwei.center.entity.RealReport;
import cn.com.yuanwei.center.entity.RealReportVo;
import cn.com.yuanwei.center.service.RealReportService;
import cn.com.yuanwei.center.util.ExcelUtils;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.RealReportReq;
import cn.com.yuanwei.center.web.response.RealReportLtResp;
import cn.com.yuanwei.center.web.response.base.Result;
import io.swagger.annotations.Api;

@Api(value = "realReport", description = "统计局导出表", produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
@RequestMapping("/realReports")
public class RealReportController {
	Log logger = LogFactory.getLog(RealReportController.class);
	@Autowired
	private RealReportService realReportService;

	/**
	 * Desc: 新增处理
	 * @param @param req
	 * @param @return
	 * @param @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-04-24 10:29:22
	 */
	@PostMapping
	@ResponseBody
	@Auth
	public Result createRealReport(@RequestBody RealReport req) throws Exception{
		realReportService.save(req);
		return new Result();
	}
	/**
	 * Desc:编辑处理
	 * @param @param req
	 * @param @return
	 * @param @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-04-24 10:29:22
	 */
	@PutMapping
	@ResponseBody
	@Auth
	public Result editRealReport(@RequestBody RealReport req) throws Exception{
		realReportService.update(req);
		return new Result();
	}
	/**
	 * Desc:删除处理
	 * @param @param req
	 * @param @return
	 * @param @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-04-24 10:29:22
	 */
	@DeleteMapping
	@ResponseBody
	@Auth
	public Result delRealReport(@RequestParam(value="ids") List<Integer> req) throws Exception{
		realReportService.delete(req);
		return new Result();
	}
	/**
	 * Desc:查询列表
	 * @param @param req
	 * @param @return
	 * @param @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-04-24 10:29:22
	 */
	@GetMapping
	@ResponseBody
	@Auth
	public Result getRealReportList(RealReportReq req) throws Exception{
		RealReportLtResp resp= realReportService.queryList(req);
		Result re = new Result(resp);
		re.setCount(resp.getCount());
		return re;
	}
	/**
	 * Desc:批量删除
	 * @param @param req
	 * @param @return
	 * @param @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-04-24 10:29:22
	 */
	@DeleteMapping(value="batch")
	@ResponseBody
	@Auth
	public Result deleteReportList(RealReportReq req) throws Exception{
		int affectRows = realReportService.batchDelete(req);
		Result re = new Result();
		re.setCount((long)affectRows);
		return re;
	}
	
	/**
	 * Excel文件导入
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @author zbk
	 * @date 2017-04-24 10:28:06
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
				List<RealReport> reports = ExcelImportUtil.importExcel(file.getInputStream(),RealReport.class,params);
				for (RealReport report : reports) {
					//调整年度yyyyMM的格式
					Integer year = report.getYear();
					Integer calcYear = year/100;
					Integer calcMonth = year%100;
					report.setYear(calcYear);
					report.setMonth(calcMonth);
					String sales = report.getSales();
					String retailSales = report.getRetailSales();
					if(ValidateUtil.isEmpty(sales)){
						report.setSales("0");
					}
					if(ValidateUtil.isEmpty(retailSales)){
						report.setRetailSales("0");
					}
					
				}
				realReportService.batchSave(reports);
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
	 * @throws Exception
	 * @author zbk
	 * @date 2017-04-24 10:28:06
	 */
	@GetMapping(value="export")
	public void exportXls(RealReportReq req,HttpServletRequest request, HttpServletResponse response) throws Exception {
		//重置分页参数
		req.setPage(1);
		req.setItemcount(Integer.MAX_VALUE);
		//获取数据
		RealReportLtResp resp= realReportService.queryList(req);
		Map<String, Object> map = new HashMap<String,Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		map.put(NormalExcelConstants.FILE_NAME,"统计局导出表");
		map.put(NormalExcelConstants.CLASS,RealReportVo.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("统计局导出表", "导出时间:"+sdf.format(new Date()),"导出信息"));
		map.put(NormalExcelConstants.DATA_LIST,resp.getRealReportLt());
		ExcelUtils.exportDataToSingleExcel(map, request, response);
	}
	
	/**
	 * 导出excel模板
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @author zbk
	 * @date 2017-04-24 10:28:06
	 */
	@GetMapping(value="exportTpl")
	public void exportXlsByT(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String,Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		model.put(NormalExcelConstants.FILE_NAME,"统计局导出表模板");
		model.put(NormalExcelConstants.CLASS,RealReport.class);
		model.put(NormalExcelConstants.PARAMS,new ExportParams("统计局导出表", "导出时间:"+sdf.format(new Date()),"导出信息"));
		List<RealReport> data = new ArrayList<RealReport>();
		data.add(new RealReport("123432112", "XXX有限责任公司", "340.45", "500.75", 201701,1, new Date()));
		model.put(NormalExcelConstants.DATA_LIST,data);
		ExcelUtils.exportDataToSingleExcel(model, request, response);
	}
	
}
