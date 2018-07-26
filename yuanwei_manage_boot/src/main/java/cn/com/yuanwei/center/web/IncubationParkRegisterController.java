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
import io.swagger.annotations.Api;
import cn.com.yuanwei.center.annotation.Auth;
import cn.com.yuanwei.center.entity.IncubationParkRegister;
import cn.com.yuanwei.center.service.IncubationParkRegisterService;
import cn.com.yuanwei.center.web.request.IncubationParkRegisterReq;
import cn.com.yuanwei.center.web.response.IncubationParkRegisterLtResp;
import cn.com.yuanwei.center.web.response.base.Result;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import cn.com.yuanwei.center.util.ExcelUtils;

@Api(value = "incubationParkRegister", description = "孵化园申请登记信息", produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
@RequestMapping("/incubationParkRegisters")
public class IncubationParkRegisterController {
	@Autowired
	private IncubationParkRegisterService incubationParkRegisterService;

	/**
	 * Desc: 新增处理
	 * @param req
	 * @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-07-03 17:59:11
	 */
	@PostMapping
	@ResponseBody
	@Auth	
	public Result createIncubationParkRegister(@RequestBody IncubationParkRegister req) throws Exception{
		return new Result(incubationParkRegisterService.save(req));
	}
	/**
	 * Desc:编辑处理
	 * @param req
	 * @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-07-03 17:59:11
	 */
	@PutMapping
	@ResponseBody
	@Auth	
	public Result editIncubationParkRegister(@RequestBody IncubationParkRegister req) throws Exception{
		return new Result(incubationParkRegisterService.update(req));
	}
	/**
	 * Desc:删除处理
	 * @param req
	 * @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-07-03 17:59:11
	 */
	@DeleteMapping
	@ResponseBody
	@Auth	
	public Result delIncubationParkRegister(@RequestParam(value="ids") List<Integer> ids) throws Exception{
		return new Result(incubationParkRegisterService.delete(ids));
	}
	/**
	 * Desc:查询列表
	 * @param req
	 * @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-07-03 17:59:11
	 */
	@GetMapping
	@ResponseBody
	@Auth	
	public Result getIncubationParkRegisterList(IncubationParkRegisterReq req) throws Exception{
		IncubationParkRegisterLtResp resp= incubationParkRegisterService.queryList(req);
		Result re = new Result(resp.getIncubationParkRegisterLt());
		re.setCount(resp.getCount());
		return re;
	}
	/**
	 * Desc:查询详情
	 * @param id
	 * @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-07-03 17:59:11
	 */
	@GetMapping(value="id")
	@ResponseBody
	@Auth	
	public Result getIncubationParkRegister(Integer id) throws Exception{
		IncubationParkRegister incubationParkRegister = incubationParkRegisterService.queryById(id);
		Result re = new Result(incubationParkRegister);
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
	 * @date 2017-07-03 17:59:11
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
				List<IncubationParkRegister> incubationParkRegisters = ExcelImportUtil.importExcel(file.getInputStream(),IncubationParkRegister.class,params);
				for (IncubationParkRegister incubationParkRegister : incubationParkRegisters) {
					incubationParkRegisterService.save(incubationParkRegister);
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
	 * @date 2017-07-03 17:59:11
	 */
	@GetMapping(value="export")
	public void exportXls(IncubationParkRegisterReq req,HttpServletRequest request, HttpServletResponse response) throws Exception {
		//重置分页参数
		req.setPage(1);
		req.setItemcount(Integer.MAX_VALUE);
		//获取数据
		IncubationParkRegisterLtResp resp= incubationParkRegisterService.queryList(req);
		Map<String, Object> model = new HashMap<String,Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		model.put(NormalExcelConstants.FILE_NAME,"孵化园申请登记信息");
		model.put(NormalExcelConstants.CLASS,IncubationParkRegister.class);
		model.put(NormalExcelConstants.PARAMS,new ExportParams("孵化园申请登记信息", "导出时间:"+sdf.format(new Date()),"导出信息"));
		model.put(NormalExcelConstants.DATA_LIST,resp.getIncubationParkRegisterLt());
		ExcelUtils.exportDataToSingleExcel(model, request, response);
	}
	
	/**
	 * 导出excel模板
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @author zbk
	 * @date 2017-07-03 17:59:11
	 */
	@GetMapping(value="exportTpl")
	public void exportXlsByT(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String,Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		model.put(NormalExcelConstants.FILE_NAME,"孵化园申请登记信息模板");
		model.put(NormalExcelConstants.CLASS,IncubationParkRegister.class);
		model.put(NormalExcelConstants.PARAMS,new ExportParams("孵化园申请登记信息模板", "导出时间:"+sdf.format(new Date()),"导出信息"));
		model.put(NormalExcelConstants.DATA_LIST,new ArrayList<Object>());
		ExcelUtils.exportDataToSingleExcel(model, request, response);
	}	
	
	
}
