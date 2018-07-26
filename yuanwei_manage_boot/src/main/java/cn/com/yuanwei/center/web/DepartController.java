package cn.com.yuanwei.center.web;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import cn.com.yuanwei.center.entity.Department;
import cn.com.yuanwei.center.service.DepartService;
import cn.com.yuanwei.center.web.request.UserLtReq;
import cn.com.yuanwei.center.web.response.DepartLtResp;
import cn.com.yuanwei.center.web.response.base.Result;

@Controller
@RequestMapping("/departs")
public class DepartController {
	Log logger = LogFactory.getLog(DepartController.class);
	@Autowired
	private DepartService departService;

	/**
	 * Desc: 创建部门
	 * @param @param req
	 * @param @return
	 * @param @throws Exception
	 * @return Result
	 * @author sky
	 * @date 2017年4月14日  下午2:20:59
	 */
	@PostMapping
	@ResponseBody
	@Auth
	public Result createDepart(@RequestBody Department req) throws Exception{
		departService.createDepart(req);
		return  new Result();
	}
	/**
	 * Desc:编辑部门
	 * @param @param req
	 * @param @return
	 * @param @throws Exception
	 * @return Result
	 * @author sky
	 * @date 2017年4月12日  下午4:34:13
	 */
	@PutMapping
	@ResponseBody
	@Auth
	public Result editDepart(@RequestBody Department req) throws Exception{
		departService.updateDepart(req);
		return  new Result();
	}
	/**
	 * Desc:删除部门
	 * @param @param req
	 * @param @return
	 * @param @throws Exception
	 * @return Result
	 * @author sky
	 * @date 2017年4月12日  下午4:34:26
	 */
	@DeleteMapping
	@ResponseBody
	@Auth
	public Result delDepart(@RequestParam(value="ids") List<Integer> req) throws Exception{
		departService.delDepart(req);
		return  new Result();
	}
	/**
	 * Desc:查询部门列表
	 * @param @param req
	 * @param @return
	 * @param @throws Exception
	 * @return Result
	 * @author sky
	 * @date 2017年4月12日  下午4:34:34
	 */
	@GetMapping
	@ResponseBody
	@Auth
	public Result getDepartList(UserLtReq req) throws Exception{
		DepartLtResp resp= departService.getDepartLt(req);
		Result re = new Result(resp.getDepartLt());
		re.setCount(resp.getCount());
		return re;
	}
	
}
