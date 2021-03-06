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
import cn.com.yuanwei.center.entity.ToDoList;
import cn.com.yuanwei.center.enums.IsEnum;
import cn.com.yuanwei.center.service.ToDoListService;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.util.ExcelUtils;
import cn.com.yuanwei.center.web.request.ToDoListReq;
import cn.com.yuanwei.center.web.response.ToDoListLtResp;
import cn.com.yuanwei.center.web.response.base.Result;
import io.swagger.annotations.Api;

@Api(value = "toDoList", description = "待办事项", produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
@RequestMapping("/toDoLists")
public class ToDoListController {
	@Autowired
	private ToDoListService toDoListService;

	/**
	 * Desc: 新增处理
	 * @param req
	 * @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-06-26 17:05:43
	 */
	@PostMapping
	@ResponseBody
	@Auth	
	public Result createToDoList(@RequestBody ToDoList req) throws Exception{
		return new Result(toDoListService.save(req));
	}
	/**
	 * Desc:编辑处理
	 * @param req
	 * @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-06-26 17:05:43
	 */
	@PutMapping
	@ResponseBody
	@Auth	
	public Result editToDoList(@RequestBody ToDoList req) throws Exception{
		return new Result(toDoListService.update(req));
	}
	/**
	 * Desc:删除处理
	 * @param req
	 * @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-06-26 17:05:43
	 */
	@DeleteMapping
	@ResponseBody
	@Auth	
	public Result delToDoList(@RequestParam(value="ids") List<Integer> ids) throws Exception{
		return new Result(toDoListService.delete(ids));
	}
	/**
	 * Desc:查询列表
	 * @param req
	 * @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-06-26 17:05:43
	 */
	@GetMapping
	@ResponseBody
	@Auth	
	public Result getToDoListList(ToDoListReq req) throws Exception{
		req.setUserId(LoginUserThread.getUser().getId());
		ToDoListLtResp resp= toDoListService.queryList(req);
		Result re = new Result(resp.getToDoListLt());
		re.setCount(resp.getCount());
		return re;
	}
	/**
	 * Desc:查询详情
	 * @param id
	 * @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-06-26 17:05:43
	 */
	@GetMapping(value="id")
	@ResponseBody
	@Auth	
	public Result getToDoList(Integer id) throws Exception{
		ToDoList toDoList = toDoListService.queryById(id);
		Result re = new Result(toDoList);
		re.setCount(1L);
		return re;
	}
	/**
	 * Desc:审核
	 * @param req
	 * @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-05-16 11:11:22
	 */
	@PostMapping(value="audit")
	@ResponseBody
	@Auth
	public Result audit(@RequestBody ToDoListReq req) throws Exception{
		toDoListService.deal(req);
		return new Result();
	}
	/**
	 * Desc:查询总数
	 * @param req
	 * @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-05-16 11:11:22
	 */
	@GetMapping(value="total")
	@ResponseBody
	@Auth
	public Result getToDoListTotal(ToDoListReq req) throws Exception{
		req.setUserId(LoginUserThread.getUser().getId());
		req.setIsDeal(IsEnum.no.getCode());
		ToDoListLtResp resp= toDoListService.queryTotal(req);
		Result re = new Result(resp.getToDoListLt());
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
	 * @date 2017-06-26 17:05:43
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
				List<ToDoList> toDoLists = ExcelImportUtil.importExcel(file.getInputStream(),ToDoList.class,params);
				for (ToDoList toDoList : toDoLists) {
					toDoListService.save(toDoList);
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
	 * @date 2017-06-26 17:05:43
	 */
	@GetMapping(value="export")
	public void exportXls(ToDoListReq req,HttpServletRequest request, HttpServletResponse response) throws Exception {
		//重置分页参数
		req.setPage(1);
		req.setItemcount(Integer.MAX_VALUE);
		//获取数据
		ToDoListLtResp resp= toDoListService.queryList(req);
		Map<String, Object> model = new HashMap<String,Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		model.put(NormalExcelConstants.FILE_NAME,"待办事项");
		model.put(NormalExcelConstants.CLASS,ToDoList.class);
		model.put(NormalExcelConstants.PARAMS,new ExportParams("待办事项", "导出时间:"+sdf.format(new Date()),"导出信息"));
		model.put(NormalExcelConstants.DATA_LIST,resp.getToDoListLt());
		ExcelUtils.exportDataToSingleExcel(model, request, response);
	}
	
	/**
	 * 导出excel模板
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @author zbk
	 * @date 2017-06-26 17:05:43
	 */
	@GetMapping(value="exportTpl")
	public void exportXlsByT(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String,Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		model.put(NormalExcelConstants.FILE_NAME,"待办事项模板");
		model.put(NormalExcelConstants.CLASS,ToDoList.class);
		model.put(NormalExcelConstants.PARAMS,new ExportParams("待办事项模板", "导出时间:"+sdf.format(new Date()),"导出信息"));
		model.put(NormalExcelConstants.DATA_LIST,new ArrayList<Object>());
		ExcelUtils.exportDataToSingleExcel(model, request, response);
	}	
	
	
}
