package cn.com.yuanwei.center.web;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

import cn.com.yuanwei.center.annotation.Auth;
import cn.com.yuanwei.center.entity.Type;
import cn.com.yuanwei.center.service.TypeService;
import cn.com.yuanwei.center.web.request.CommonTypeReq;
import cn.com.yuanwei.center.web.request.TypeReq;
import cn.com.yuanwei.center.web.response.CommonTypeLtResp;
import cn.com.yuanwei.center.web.response.TypeLtResp;
import cn.com.yuanwei.center.web.response.base.Result;
import io.swagger.annotations.Api;

@Api(value = "type", description = "数据类型", produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
@RequestMapping("/types")
public class TypeController {
	Log logger = LogFactory.getLog(TypeController.class);
	@Autowired
	private TypeService typeService;

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
	public Result createType(@RequestBody Type req) throws Exception{
		typeService.save(req);
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
	public Result editType(@RequestBody Type req) throws Exception{
		typeService.update(req);
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
	public Result delType(@RequestParam(value="ids") List<Integer> req) throws Exception{
		typeService.delete(req);
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
	public Result getTypeList(TypeReq req) throws Exception{
		TypeLtResp resp= typeService.queryList(req);
		Result re = new Result(resp.getTypeLt());
		re.setCount(resp.getCount());
		return re;
	}
	
	/**
	 * Desc:通用查询列表
	 * @param @param req
	 * @param @return
	 * @param @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-04-24 10:29:22
	 */
	@GetMapping(value="common")
	@ResponseBody
	public Result getCommonTypeList(CommonTypeReq req) throws Exception{
		CommonTypeLtResp resp= typeService.queryCommonTypeList(req);
		Result re = new Result(resp.getTypeLt());
		re.setCount(resp.getCount());
		return re;
	}
	
}
