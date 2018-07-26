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
import cn.com.yuanwei.center.entity.ServiceMonthlyReport;
import cn.com.yuanwei.center.service.ServiceMonthlyReportService;
import cn.com.yuanwei.center.util.ExcelUtils;
import cn.com.yuanwei.center.web.request.ServiceMonthlyReportReq;
import cn.com.yuanwei.center.web.response.ServiceMonthlyReportLtResp;
import cn.com.yuanwei.center.web.response.base.Result;
import io.swagger.annotations.Api;

@Api(value = "serviceMonthlyReport", description = "服务业企业数据月报", produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
@RequestMapping("/serviceMonthlyReports")
public class ServiceMonthlyReportController {
	Log logger = LogFactory.getLog(ServiceMonthlyReportController.class);
	@Autowired
	private ServiceMonthlyReportService serviceMonthlyReportService;

	/**
	 * Desc: 新增处理
	 * @param req
	 * @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-06-07 11:55:52
	 */
	@PostMapping
	@ResponseBody
	@Auth
	public Result createServiceMonthlyReport(@RequestBody ServiceMonthlyReport req) throws Exception{
		return new Result(serviceMonthlyReportService.save(req));
	}
	/**
	 * Desc:编辑处理
	 * @param req
	 * @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-06-07 11:55:52
	 */
	@PutMapping
	@ResponseBody
	@Auth
	public Result editServiceMonthlyReport(@RequestBody ServiceMonthlyReport req) throws Exception{
		return new Result(serviceMonthlyReportService.update(req));
	}
	/**
	 * Desc:删除处理
	 * @param req
	 * @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-06-07 11:55:52
	 */
	@DeleteMapping
	@ResponseBody
	@Auth
	public Result delServiceMonthlyReport(@RequestParam(value="ids") List<Integer> req) throws Exception{
		return new Result(serviceMonthlyReportService.delete(req));
	}
	/**
	 * Desc:查询列表
	 * @param req
	 * @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-06-07 11:55:52
	 */
	@GetMapping
	@ResponseBody
	@Auth
	public Result getServiceMonthlyReportList(ServiceMonthlyReportReq req) throws Exception{
		ServiceMonthlyReportLtResp resp= serviceMonthlyReportService.queryList(req);
		Result re = new Result(resp.getServiceMonthlyReportLt());
		re.setCount(resp.getCount());
		return re;
	}
	/**
	 * Desc:查询详情
	 * @param id
	 * @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-06-07 11:55:52
	 */
	@GetMapping(value="id")
	@ResponseBody
	public Result getServiceMonthlyReport(Integer id) throws Exception{
		ServiceMonthlyReport serviceMonthlyReport = serviceMonthlyReportService.queryById(id);
		Result re = new Result(serviceMonthlyReport);
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
	 * @date 2017-06-07 11:55:52
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
				List<ServiceMonthlyReport> serviceMonthlyReports = ExcelImportUtil.importExcel(file.getInputStream(),ServiceMonthlyReport.class,params);
				for (ServiceMonthlyReport serviceMonthlyReport : serviceMonthlyReports) {
					serviceMonthlyReportService.save(serviceMonthlyReport);
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
	 * @date 2017-06-07 11:55:52
	 */
	@GetMapping(value="export")
	public void exportXls(ServiceMonthlyReportReq req,HttpServletRequest request, HttpServletResponse response) throws Exception {
		//重置分页参数
		req.setPage(1);
		req.setItemcount(Integer.MAX_VALUE);
		//获取数据
		ServiceMonthlyReportLtResp resp= serviceMonthlyReportService.queryList(req);
		Map<String, Object> model = new HashMap<String,Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		model.put(NormalExcelConstants.FILE_NAME,"服务业企业数据月报");
		model.put(NormalExcelConstants.CLASS,ServiceMonthlyReport.class);
		model.put(NormalExcelConstants.PARAMS,new ExportParams("服务业企业数据月报", "导出时间:"+sdf.format(new Date()),"导出信息"));
		model.put(NormalExcelConstants.DATA_LIST,resp.getServiceMonthlyReportLt());
		ExcelUtils.exportDataToSingleExcel(model, request, response);
	}
	
	/**
	 * 导出excel模板
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @author zbk
	 * @date 2017-06-07 11:55:52
	 */
	@GetMapping(value="exportTpl")
	public void exportXlsByT(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String,Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		model.put(NormalExcelConstants.FILE_NAME,"服务业企业数据月报模板");
		model.put(NormalExcelConstants.CLASS,ServiceMonthlyReport.class);
		model.put(NormalExcelConstants.PARAMS,new ExportParams("服务业企业数据月报模板", "导出时间:"+sdf.format(new Date()),"导出信息"));
		model.put(NormalExcelConstants.DATA_LIST,new ArrayList<Object>());
		ExcelUtils.exportDataToSingleExcel(model, request, response);
	}	
	
	
}
