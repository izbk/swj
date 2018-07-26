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
import cn.com.yuanwei.center.entity.Role;
import cn.com.yuanwei.center.service.MenuService;
import cn.com.yuanwei.center.service.RoleService;
import cn.com.yuanwei.center.web.request.SaveRoleMenuReq;
import cn.com.yuanwei.center.web.request.UserLtReq;
import cn.com.yuanwei.center.web.response.RoleLtResp;
import cn.com.yuanwei.center.web.response.base.Result;

@Controller
@RequestMapping("/roles")
public class RoleController {
	Log logger = LogFactory.getLog(RoleController.class);
	@Autowired
	private RoleService roleService;
	@Autowired
	private MenuService menuService;
	/**
	 * Desc:新建角色
	 * @param @param req
	 * @param @return
	 * @param @throws Exception
	 * @return Result
	 * @author sky
	 * @date 2017年4月12日  下午4:34:04
	 */
	@PostMapping
	@ResponseBody
	@Auth
	public Result createRole(@RequestBody Role req) throws Exception{
		roleService.createRole(req);
		return  new Result();
	}
	/**
	 * Desc:编辑角色
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
	public Result editRole(@RequestBody Role req) throws Exception{
		roleService.updateRole(req);
		return  new Result();
	}
	/**
	 * Desc:删除角色
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
	public Result delRole(@RequestParam(value="ids") List<Integer> req) throws Exception{
		roleService.delRole(req);
		return  new Result();
	}
	/**
	 * Desc:查询角色列表
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
	public Result getRoleList(UserLtReq req) throws Exception{
		RoleLtResp resp = roleService.getRoleLt(req);
		Result re = new Result(resp.getRoleLt());
		re.setCount(resp.getCount());
		return re;
	}
	/**
	 * Desc:获取角色菜单
	 * @param @param id
	 * @param @return
	 * @param @throws Exception
	 * @return Result
	 * @author sky
	 * @date 2017年4月12日  下午5:49:17
	 */
	@GetMapping(value="/menus")
	@ResponseBody
	public Result getRoleMenu(Integer role) throws Exception{
		return new Result(menuService.getAllMenu(role));
	}
	
	@PostMapping(value="/savemenus")
	@ResponseBody
	public Result saveRoleMenu(@RequestBody SaveRoleMenuReq req) throws Exception{
		menuService.saveRoleMenu(req);
		return new Result();
	}
}
