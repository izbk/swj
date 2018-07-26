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
import cn.com.yuanwei.center.entity.ExhibitionRegister;
import cn.com.yuanwei.center.entity.ExhibitionRegisterVo;
import cn.com.yuanwei.center.service.ExhibitionRegisterService;
import cn.com.yuanwei.center.util.ExcelUtils;
import cn.com.yuanwei.center.web.request.ExhibitionRegisterReq;
import cn.com.yuanwei.center.web.response.ExhibitionRegisterLtResp;
import cn.com.yuanwei.center.web.response.base.Result;
import io.swagger.annotations.Api;

@Api(value = "exhibitionRegister", description = "会展报名信息", produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
@RequestMapping("/exhibitionRegisters")
public class ExhibitionRegisterController {
	@Autowired
	private ExhibitionRegisterService exhibitionRegisterService;

	/**
	 * Desc: 新增处理
	 * @param req
	 * @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-07-04 14:34:16
	 */
	@PostMapping
	@ResponseBody
	public Result createExhibitionRegister(@RequestBody ExhibitionRegister req) throws Exception{
		return new Result(exhibitionRegisterService.save(req));
	}
	/**
	 * Desc:编辑处理
	 * @param req
	 * @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-07-04 14:34:16
	 */
	@PutMapping
	@ResponseBody
	@Auth	
	public Result editExhibitionRegister(@RequestBody ExhibitionRegister req) throws Exception{
		return new Result(exhibitionRegisterService.update(req));
	}
	/**
	 * Desc:删除处理
	 * @param req
	 * @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-07-04 14:34:16
	 */
	@DeleteMapping
	@ResponseBody
	@Auth	
	public Result delExhibitionRegister(@RequestParam(value="ids") List<Integer> ids) throws Exception{
		return new Result(exhibitionRegisterService.delete(ids));
	}
	/**
	 * Desc:查询列表
	 * @param req
	 * @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-07-04 14:34:16
	 */
	@GetMapping
	@ResponseBody
	@Auth	
	public Result getExhibitionRegisterList(ExhibitionRegisterReq req,@RequestParam(value="honors[]",required=false) Integer[] honors) throws Exception{
		req.setHonors(honors);
		ExhibitionRegisterLtResp resp= exhibitionRegisterService.queryList(req);
		Result re = new Result(resp.getExhibitionRegisterLt());
		re.setCount(resp.getCount());
		return re;
	}
	/**
	 * Desc:查询详情
	 * @param id
	 * @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-07-04 14:34:16
	 */
	@GetMapping(value="id")
	@ResponseBody
	@Auth	
	public Result getExhibitionRegister(Integer id) throws Exception{
		ExhibitionRegister exhibitionRegister = exhibitionRegisterService.queryById(id);
		Result re = new Result(exhibitionRegister);
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
	 * @date 2017-07-04 14:34:16
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
				List<ExhibitionRegister> exhibitionRegisters = ExcelImportUtil.importExcel(file.getInputStream(),ExhibitionRegister.class,params);
				for (ExhibitionRegister exhibitionRegister : exhibitionRegisters) {
					exhibitionRegisterService.save(exhibitionRegister);
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
	 * @date 2017-07-04 14:34:16
	 */
	@GetMapping(value="export")
	public void exportXls(ExhibitionRegisterReq req,HttpServletRequest request, HttpServletResponse response) throws Exception {
		//获取数据
		Map<String, Object> model = new HashMap<String,Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		model.put(NormalExcelConstants.FILE_NAME,"会展报名信息");
		model.put(NormalExcelConstants.CLASS,ExhibitionRegisterVo.class);
		model.put(NormalExcelConstants.PARAMS,new ExportParams("会展报名信息", "导出时间:"+sdf.format(new Date()),"导出信息"));
		model.put(NormalExcelConstants.DATA_LIST,exhibitionRegisterService.queryListForExport(req));
		ExcelUtils.exportDataToSingleExcel(model, request, response);
	}
	
	/**
	 * 导出excel模板
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @author zbk
	 * @date 2017-07-04 14:34:16
	 */
	@GetMapping(value="exportTpl")
	public void exportXlsByT(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String,Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		model.put(NormalExcelConstants.FILE_NAME,"会展报名信息模板");
		model.put(NormalExcelConstants.CLASS,ExhibitionRegister.class);
		model.put(NormalExcelConstants.PARAMS,new ExportParams("会展报名信息模板", "导出时间:"+sdf.format(new Date()),"导出信息"));
		model.put(NormalExcelConstants.DATA_LIST,new ArrayList<Object>());
		ExcelUtils.exportDataToSingleExcel(model, request, response);
	}	
	
	
}
