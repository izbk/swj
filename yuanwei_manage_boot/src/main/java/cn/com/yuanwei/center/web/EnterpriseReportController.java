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
import cn.com.yuanwei.center.entity.EnterpriseReport;
import cn.com.yuanwei.center.service.EnterpriseReportService;
import cn.com.yuanwei.center.util.ExcelUtils;
import cn.com.yuanwei.center.web.request.EnterpriseReportReq;
import cn.com.yuanwei.center.web.response.EnterpriseReportLtResp;
import cn.com.yuanwei.center.web.response.base.Result;
import io.swagger.annotations.Api;

@Api(value = "enterpriseReport", description = "企业数据上报", produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
@RequestMapping("/enterpriseReports")
public class EnterpriseReportController {
	Log logger = LogFactory.getLog(EnterpriseReportController.class);
	@Autowired
	private EnterpriseReportService enterpriseReportService;

	/**
	 * Desc: 新增处理
	 * @param req
	 * @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-05-12 21:01:40
	 */
	@PostMapping
	@ResponseBody
	@Auth
	public Result createEnterpriseReport(@RequestBody EnterpriseReport req) throws Exception{
		enterpriseReportService.save(req);
		return new Result();
	}
	/**
	 * Desc:编辑处理
	 * @param req
	 * @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-05-12 21:01:40
	 */
	@PutMapping
	@ResponseBody
	@Auth
	public Result editEnterpriseReport(@RequestBody EnterpriseReport req) throws Exception{
		enterpriseReportService.update(req);
		return new Result();
	}
	/**
	 * Desc:删除处理
	 * @param req
	 * @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-05-12 21:01:40
	 */
	@DeleteMapping
	@ResponseBody
	@Auth
	public Result delEnterpriseReport(@RequestParam(value="ids") List<Integer> req) throws Exception{
		enterpriseReportService.delete(req);
		return new Result();
	}
	/**
	 * Desc:查询列表
	 * @param req
	 * @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-05-12 21:01:40
	 */
	@GetMapping
	@ResponseBody
	@Auth
	public Result getEnterpriseReportList(EnterpriseReportReq req) throws Exception{
		EnterpriseReportLtResp resp= enterpriseReportService.queryList(req);
		Result re = new Result(resp);
		re.setCount(resp.getCount());
		return re;
	}
	
	/**
	 * Desc:查询同期数
	 * @param req
	 * @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-05-12 21:01:40
	 */
	@GetMapping(value="tqs")
	@ResponseBody
	@Auth
	public Result getTqs(EnterpriseReportReq req) throws Exception{
		Result re = new Result(enterpriseReportService.queryTqs(req));
		return re;
	}
	
	/**
	 * Excel文件导入
	 * @param request
	 * @param response
	 * @return Result
	 * @throws Exception
	 * @author zbk
	 * @date 2017-05-12 21:01:40
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
				List<EnterpriseReport> enterpriseReports = ExcelImportUtil.importExcel(file.getInputStream(),EnterpriseReport.class,params);
				for (EnterpriseReport enterpriseReport : enterpriseReports) {
					enterpriseReportService.save(enterpriseReport);
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
	 * @date 2017-05-12 21:01:40
	 */
	@GetMapping(value="export")
	public void exportXls(EnterpriseReportReq req,HttpServletRequest request, HttpServletResponse response) throws Exception {
		//获取数据
		Map<String, Object> model = new HashMap<String,Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		model.put(NormalExcelConstants.FILE_NAME,"企业数据上报");
		model.put(NormalExcelConstants.CLASS,EnterpriseReport.class);
		model.put(NormalExcelConstants.PARAMS,new ExportParams("企业数据上报", "导出时间:"+sdf.format(new Date()),"导出信息"));
		model.put(NormalExcelConstants.DATA_LIST,enterpriseReportService.queryExport(req));
		ExcelUtils.exportDataToSingleExcel(model, request, response);
	}
	
	/**
	 * 导出excel模板
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @author zbk
	 * @date 2017-05-12 21:01:40
	 */
	@GetMapping(value="exportTpl")
	public void exportXlsByT(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String,Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		model.put(NormalExcelConstants.FILE_NAME,"企业数据上报模板");
		model.put(NormalExcelConstants.CLASS,EnterpriseReport.class);
		model.put(NormalExcelConstants.PARAMS,new ExportParams("企业数据上报模板", "导出时间:"+sdf.format(new Date()),"导出信息"));
		model.put(NormalExcelConstants.DATA_LIST,new ArrayList<Object>());
		ExcelUtils.exportDataToSingleExcel(model, request, response);
	}	
	
	
}
