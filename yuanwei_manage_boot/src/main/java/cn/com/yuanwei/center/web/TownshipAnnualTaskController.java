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
import cn.com.yuanwei.center.entity.TownshipAnnualTask;
import cn.com.yuanwei.center.service.TownshipAnnualTaskService;
import cn.com.yuanwei.center.util.ExcelUtils;
import cn.com.yuanwei.center.web.request.TownshipAnnualTaskReq;
import cn.com.yuanwei.center.web.response.TownshipAnnualTaskLtResp;
import cn.com.yuanwei.center.web.response.base.Result;
import io.swagger.annotations.Api;

@Api(value = "townshipAnnualTask", description = "镇乡年度目标任务表", produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
@RequestMapping("/townshipAnnualTasks")
public class TownshipAnnualTaskController {
	@Autowired
	private TownshipAnnualTaskService townshipAnnualTaskService;

	/**
	 * Desc: 新增处理
	 * @param req
	 * @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-06-15 15:17:36
	 */
	@PostMapping
	@ResponseBody
	@Auth
	public Result createTownshipAnnualTask(@RequestBody TownshipAnnualTask req) throws Exception{
		return new Result(townshipAnnualTaskService.save(req));
	}
	/**
	 * Desc:编辑处理
	 * @param req
	 * @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-06-15 15:17:36
	 */
	@PutMapping
	@ResponseBody
	@Auth
	public Result editTownshipAnnualTask(@RequestBody TownshipAnnualTask req) throws Exception{
		return new Result(townshipAnnualTaskService.update(req));
	}
	/**
	 * Desc:删除处理
	 * @param req
	 * @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-06-15 15:17:36
	 */
	@DeleteMapping
	@ResponseBody
	@Auth
	public Result delTownshipAnnualTask(@RequestParam(value="ids") List<Integer> ids) throws Exception{
		return new Result(townshipAnnualTaskService.delete(ids));
	}
	/**
	 * Desc:查询列表
	 * @param req
	 * @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-06-15 15:17:36
	 */
	@GetMapping
	@ResponseBody
	@Auth
	public Result getTownshipAnnualTaskList(TownshipAnnualTaskReq req) throws Exception{
		TownshipAnnualTaskLtResp resp= townshipAnnualTaskService.queryList(req);
		Result re = new Result(resp.getTownshipAnnualTaskLt());
		re.setCount(resp.getCount());
		return re;
	}
	/**
	 * Desc:查询详情
	 * @param id
	 * @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-06-15 15:17:36
	 */
	@GetMapping(value="id")
	@ResponseBody
	public Result getTownshipAnnualTask(Integer id) throws Exception{
		TownshipAnnualTask townshipAnnualTask = townshipAnnualTaskService.queryById(id);
		Result re = new Result(townshipAnnualTask);
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
	 * @date 2017-06-15 15:17:36
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
				List<TownshipAnnualTask> townshipAnnualTasks = ExcelImportUtil.importExcel(file.getInputStream(),TownshipAnnualTask.class,params);
				for (TownshipAnnualTask townshipAnnualTask : townshipAnnualTasks) {
					townshipAnnualTaskService.save(townshipAnnualTask);
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
	 * @date 2017-06-15 15:17:36
	 */
	@GetMapping(value="export")
	public void exportXls(TownshipAnnualTaskReq req,HttpServletRequest request, HttpServletResponse response) throws Exception {
		//重置分页参数
		req.setPage(1);
		req.setItemcount(Integer.MAX_VALUE);
		//获取数据
		TownshipAnnualTaskLtResp resp= townshipAnnualTaskService.queryList(req);
		Map<String, Object> model = new HashMap<String,Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		model.put(NormalExcelConstants.FILE_NAME,"镇乡年度目标任务表");
		model.put(NormalExcelConstants.CLASS,TownshipAnnualTask.class);
		model.put(NormalExcelConstants.PARAMS,new ExportParams("镇乡年度目标任务表", "导出时间:"+sdf.format(new Date()),"导出信息"));
		model.put(NormalExcelConstants.DATA_LIST,resp.getTownshipAnnualTaskLt());
		ExcelUtils.exportDataToSingleExcel(model, request, response);
	}
	
	/**
	 * 导出excel模板
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @author zbk
	 * @date 2017-06-15 15:17:36
	 */
	@GetMapping(value="exportTpl")
	public void exportXlsByT(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String,Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		model.put(NormalExcelConstants.FILE_NAME,"镇乡年度目标任务表模板");
		model.put(NormalExcelConstants.CLASS,TownshipAnnualTask.class);
		model.put(NormalExcelConstants.PARAMS,new ExportParams("镇乡年度目标任务表模板", "导出时间:"+sdf.format(new Date()),"导出信息"));
		model.put(NormalExcelConstants.DATA_LIST,new ArrayList<Object>());
		ExcelUtils.exportDataToSingleExcel(model, request, response);
	}	
	
	
}
