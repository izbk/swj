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
import io.swagger.annotations.Api;
import cn.com.yuanwei.center.annotation.Auth;
import cn.com.yuanwei.center.entity.ServiceDefine;
import cn.com.yuanwei.center.service.ServiceDefineService;
import cn.com.yuanwei.center.web.request.ServiceDefineReq;
import cn.com.yuanwei.center.web.response.ServiceDefineLtResp;
import cn.com.yuanwei.center.web.response.base.Result;

@Api(value = "serviceDefine", description = "服务业企业数据定义", produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
@RequestMapping("/serviceDefines")
public class ServiceDefineController {
	Log logger = LogFactory.getLog(ServiceDefineController.class);
	@Autowired
	private ServiceDefineService serviceDefineService;

	/**
	 * Desc: 新增处理
	 * @param @param req
	 * @param @return
	 * @param @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-04-24 10:29:44
	 */
	@PostMapping
	@ResponseBody
	@Auth
	public Result createServiceDefine(@RequestBody ServiceDefine req) throws Exception{
		serviceDefineService.save(req);
		return new Result();
	}
	/**
	 * Desc:编辑处理
	 * @param @param req
	 * @param @return
	 * @param @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-04-24 10:29:44
	 */
	@PutMapping
	@ResponseBody
	@Auth
	public Result editServiceDefine(@RequestBody ServiceDefine req) throws Exception{
		serviceDefineService.update(req);
		return new Result();
	}
	/**
	 * Desc:删除处理
	 * @param @param req
	 * @param @return
	 * @param @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-04-24 10:29:44
	 */
	@DeleteMapping
	@ResponseBody
	@Auth
	public Result delServiceDefine(@RequestParam(value="ids") List<Integer> req) throws Exception{
		serviceDefineService.delete(req);
		return new Result();
	}
	/**
	 * Desc:查询列表
	 * @param @param req
	 * @param @return
	 * @param @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-04-24 10:29:44
	 */
	@GetMapping
	@ResponseBody
	@Auth
	public Result getServiceDefineList(ServiceDefineReq req) throws Exception{
		ServiceDefineLtResp resp= serviceDefineService.queryList(req);
		Result re = new Result(resp.getServiceDefineLt());
		re.setCount(resp.getCount());
		return re;
	}
	
}
