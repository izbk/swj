package cn.com.yuanwei.center.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.yuanwei.center.entity.Menu;
import cn.com.yuanwei.center.entity.MenuExample;
import cn.com.yuanwei.center.entity.MenuExample.Criteria;
import cn.com.yuanwei.center.entity.RoleMenu;
import cn.com.yuanwei.center.entity.RoleMenuExample;
import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.mapper.MenuMapper;
import cn.com.yuanwei.center.mapper.RoleMenuMapper;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;
import cn.com.yuanwei.center.service.MenuService;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.MenuReq;
import cn.com.yuanwei.center.web.request.SaveRoleMenuReq;
import cn.com.yuanwei.center.web.response.MenuLtResp;
import cn.com.yuanwei.center.web.response.MenuResp;
import cn.com.yuanwei.center.web.response.RoleMenuResp;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {

	@Autowired
	private 
	MenuMapper menuMapper;
	@Autowired
	private 
	RoleMenuMapper roleMenuMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	
	 /**
	  * Desc:查询返回角色权限对象
	  * @author sky
	  * @date 2017年4月13日  下午7:36:23
	  */
	@Override
	public RoleMenuResp getAllMenu(Integer roleId) throws Exception {
		//定义返回选择的menuid
		List<Integer> checkedIds = new ArrayList<Integer>();
		//定义返回展开的menuid
		List<Integer> expandedIds = new ArrayList<Integer>();
		//查询所有菜单
		MenuExample me = new MenuExample();
		List<Menu> menuLt = menuMapper.selectByExample(me);
		
		//转换为父子对象
		List<MenuResp> menuData =this.convertMenuLt(menuLt);
		//查询选择
		checkedIds = this.getRoleMenuIds(roleId);
		//查询展开
		if(!ValidateUtil.isEmpty(checkedIds)){
			MenuExample subMe = new MenuExample();
			subMe.createCriteria().andIdIn(checkedIds);
			List<Menu> subMenu = menuMapper.selectByExample(me);
			for(Menu menu:subMenu){
				if(ValidateUtil.isEmpty(menu.getPid())){
					expandedIds.add(menu.getId());
				}
			}
		}
		//组装返回对象
		RoleMenuResp resp = new RoleMenuResp();
		resp.setMenuData(menuData);
		resp.setCheckedIds(checkedIds);
		resp.setExpandedIds(expandedIds);
		return resp;
	}
	/**
	 * Desc:保存角色权限操作
	 * @author sky
	 * @date 2017年4月13日  下午7:37:16
	 */
	@Override
	public void saveRoleMenu(SaveRoleMenuReq req) throws Exception {
		Integer roleId = req.getRoleId();
		List<Integer> menuIds = req.getIds();
		//先删除所有角色权限
		RoleMenuExample rme = new RoleMenuExample();
		rme.createCriteria().andRoleIdEqualTo(roleId);
		roleMenuMapper.deleteByExample(rme);
		//保存新的角色权限
		if(!ValidateUtil.isEmpty(menuIds)){
			for(Integer menuId:menuIds){
				RoleMenu rm = new RoleMenu();
				rm.setMenuId(menuId);
				rm.setRoleId(roleId);
				roleMenuMapper.insert(rm);
			}
		}
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),roleId, "保存角色权限信息"));
	}
	/**
	 * Desc:把menu对象组装为返回json的父子格式
	 * @author sky
	 * @date 2017年4月13日  下午7:31:12
	 */
	@Override
	public List<MenuResp> convertMenuLt(List<Menu> menuLt) throws Exception {
		List<MenuResp> menuData = new ArrayList<MenuResp>();
		for(Menu menu:menuLt){
			if(ValidateUtil.isEmpty(menu.getPid())){
				MenuResp item = new MenuResp();
				BeanUtils.copyProperties(menu, item);
				List<MenuResp> children = new ArrayList<MenuResp>();
				for(Menu sub:menuLt){
					if(menu.getId().equals(sub.getPid())){
						MenuResp subitem = new MenuResp();
						BeanUtils.copyProperties(sub, subitem);
						children.add(subitem);
					}
				}
				item.setChildren(children);
				menuData.add(item);
			}
		}
		return menuData;
	}
	/**
	 * Desc:获取角色拥有菜单id集合(不带父级别) element的树机制为父级菜单选中则全选，所以不能带父级
	 * @author sky
	 * @date 2017年4月13日  下午7:47:55
	 */
	@Override
	public List<Integer> getRoleMenuIds(Integer roleId) throws Exception {
		List<Integer> menuIds = new ArrayList<Integer>();
		RoleMenuExample rme = new RoleMenuExample();
		rme.createCriteria().andRoleIdEqualTo(roleId);
		List<RoleMenu> roleMenuLt = roleMenuMapper.selectByExample(rme);
		if(ValidateUtil.isEmpty(roleMenuLt)){
			return null;
		}
		for(RoleMenu rm:roleMenuLt){
			menuIds.add(rm.getMenuId());
		}
		return menuIds;
	}
	/**
	 * Desc:获取角色拥有菜单集合(带父级) 左侧菜单需要带父级才能显示
	 * @author sky
	 * @date 2017年4月13日  下午7:48:25
	 */
	@Override
	public List<Menu> getRoleMenus(Integer roleId) throws Exception {
		List<Integer> menuIds = this.getRoleMenuIds(roleId);
		if(ValidateUtil.isEmpty(menuIds)){
			return null;
		}
		MenuExample me = new MenuExample();
		me.createCriteria().andIdIn(menuIds);
		me.setOrderByClause("SORT");
		List<Menu> menuLt = menuMapper.selectByExample(me);
		List<Integer> parentIds = new ArrayList<Integer>();
		for(Menu menu:menuLt){
			Integer parentId = menu.getPid();
			if(!ValidateUtil.isEmpty(parentId)){
				if(!parentIds.contains(parentId) && !menuIds.contains(parentId)){
					parentIds.add(parentId);
				}
			}
		}
		//带上父节点返回
		if(!ValidateUtil.isEmpty(parentIds)){
			MenuExample me2 = new MenuExample();
			me2.createCriteria().andIdIn(parentIds);
			List<Menu> parentMenuLt = menuMapper.selectByExample(me2);
			menuLt.addAll(parentMenuLt);
		}
		//按照sort排序
		Collections.sort(menuLt, new Comparator<Menu>() {
			@Override
			public int compare(Menu o1, Menu o2) {
				return o1.getSort().compareTo(o2.getSort());
			}
		});
		return menuLt;
	}
	
	@Override
	public void save(Menu menu) throws Exception {
		menuMapper.insert(menu);
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),menu.getId(), "新增菜单信息"));
	}

	@Override
	public void update(Menu menu) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),menu.getId(), "更新菜单信息"));
		menuMapper.updateByPrimaryKey(menu);
	}

	@Override
	public void delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除菜单信息"));
		}
		MenuExample de=new MenuExample();
		de.createCriteria().andIdIn(ids);
		menuMapper.deleteByExample(de);
		//删除菜单授权关联表数据
		RoleMenuExample example=new RoleMenuExample();
		example.createCriteria().andMenuIdIn(ids);
		roleMenuMapper.deleteByExample(example);
	}
	
	@Override
	public Menu queryById(Integer id){
		return menuMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public MenuLtResp queryList(MenuReq req) throws Exception {
		Integer id = req.getId();
		Integer pid = req.getPid();
		String menuName = req.getMenuName();
		String path = req.getPath();
		String icon = req.getIcon();
		String indexId = req.getIndexId();
		MenuExample de=new MenuExample();
		Criteria c = de.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(pid)){
			c.andPidEqualTo(pid);
		}
		if(!ValidateUtil.isEmpty(menuName)){
			c.andMenuNameLike("%"+menuName+"%");
		}
		if(!ValidateUtil.isEmpty(path)){
			c.andPathEqualTo(path);
		}
		if(!ValidateUtil.isEmpty(icon)){
			c.andIconEqualTo(icon);
		}
		if(!ValidateUtil.isEmpty(indexId)){
			c.andIndexIdEqualTo(indexId);
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<Menu> page = (Page<Menu>) menuMapper.selectByExample(de);
		MenuLtResp resp = new MenuLtResp();
		resp.setCount(page.getTotal());
		resp.setMenuLt(page.getResult());
		return resp;
	}	
	
}
