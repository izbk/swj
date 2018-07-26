package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.Menu;
import cn.com.yuanwei.center.web.request.MenuReq;
import cn.com.yuanwei.center.web.request.SaveRoleMenuReq;
import cn.com.yuanwei.center.web.response.MenuLtResp;
import cn.com.yuanwei.center.web.response.MenuResp;
import cn.com.yuanwei.center.web.response.RoleMenuResp;
public interface MenuService {
	public RoleMenuResp getAllMenu(Integer roleId) throws Exception;
	public void saveRoleMenu(SaveRoleMenuReq req) throws Exception;
	public List<MenuResp> convertMenuLt(List<Menu> menuLt) throws Exception;
	public List<Integer> getRoleMenuIds(Integer roleId) throws Exception;
	public List<Menu> getRoleMenus(Integer roleId) throws Exception;
   /**
	 * Desc:查询菜单
	 * @author zbk
	 * @date 2017-05-17 09:29:29
	 */
	public Menu queryById(Integer id) throws Exception;
   /**
	 * Desc:查询菜单列表
	 * @author zbk
	 * @date 2017-05-17 09:29:29
	 */
	public MenuLtResp queryList(MenuReq req) throws Exception;
   /**
	 * Desc:新增菜单
	 * @author zbk
	 * @date 2017-05-17 09:29:29
	 */
	public void save(Menu menu) throws Exception;
	/**
	 * Desc:更新菜单
	 * @author zbk
	 * @date 2017-05-17 09:29:29
	 */
	public void update(Menu menu) throws Exception;
	/**
	 * Desc:删除菜单
	 * @author zbk
	 * @date 2017-05-17 09:29:29
	 */
	public void delete(List<Integer> req) throws Exception;
}
