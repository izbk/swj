package cn.com.yuanwei.center.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.riversoft.weixin.common.menu.Menu;
import com.riversoft.weixin.common.menu.MenuItem;
import com.riversoft.weixin.common.menu.MenuType;
import com.riversoft.weixin.mp.menu.Menus;

import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.entity.WeixinMenu;
import cn.com.yuanwei.center.entity.WeixinMenuExample;
import cn.com.yuanwei.center.entity.WeixinMenuExample.Criteria;
import cn.com.yuanwei.center.enums.MenuTypeEnum;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.mapper.WeixinMenuMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;
import cn.com.yuanwei.center.service.WeixinMenuService;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.WeixinMenuReq;
import cn.com.yuanwei.center.web.response.WeixinMenuLtResp;

@Service
@Transactional
public class WeixinMenuServiceImpl implements WeixinMenuService {
	@Autowired
	private WeixinMenuMapper weixinMenuMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	 
	@Override
	public Integer save(WeixinMenu weixinMenu) throws Exception {
		Integer pid = weixinMenu.getPid();
		String url = weixinMenu.getUrl();
		if(!ValidateUtil.isEmpty(pid)&&ValidateUtil.isEmpty(url)){
			throw new Exception("子菜单的菜单url不能为空");
		}
		weixinMenuMapper.insert(weixinMenu);
		createMenu();
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		ServiceLogs log = new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),weixinMenu.getId(), "新增菜单["+weixinMenu.getName()+"]成功");
		serviceLogsMapper.insertSelective(log);
		return weixinMenu.getId();
	}

	@Override
	public Integer update(WeixinMenu weixinMenu) throws Exception {
		Integer pid = weixinMenu.getPid();
		String url = weixinMenu.getUrl();
		if(!ValidateUtil.isEmpty(pid)&&ValidateUtil.isEmpty(url)){
			throw new Exception("子菜单的菜单url不能为空");
		}
		int affect = weixinMenuMapper.updateByPrimaryKey(weixinMenu);
		createMenu();
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		ServiceLogs log = new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),weixinMenu.getId(), "编辑菜单["+weixinMenu.getName()+"]成功");
		serviceLogsMapper.insertSelective(log);
		return affect;
	}

	@Override
	public Integer delete(List<Integer> req) throws Exception {
		WeixinMenuExample de=new WeixinMenuExample();
		de.createCriteria().andIdIn(req);
		int affect = weixinMenuMapper.deleteByExample(de);
		createMenu();
		//记录日志
		String ids = "";
		for (Integer id : req) {
			ids = ids + id + ",";
		}
		UserInfo userInfo = LoginUserThread.getUser();
		ServiceLogs log = new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(), "删除菜单["+ids+"]成功");
		serviceLogsMapper.insertSelective(log);
		return affect;
	}
	
	@Override
	public WeixinMenu queryById(Integer id){
		return weixinMenuMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public void sync(List<Integer> ids) throws Exception {
		WeixinMenuExample de=new WeixinMenuExample();
		de.createCriteria().andIdIn(ids);
		List<WeixinMenu> weixinMenus = weixinMenuMapper.selectByExample(de);
		List<MenuItem> menus = convertMenuLt(weixinMenus);
		Menu menu = new Menu();
		menu.setMenus(menus);
		Menus.defaultMenus().create(menu);
	}
	
	@Override
	public WeixinMenuLtResp queryList(WeixinMenuReq req) throws Exception {
		Integer id = req.getId();
		String menuKey = req.getKey();
		String name = req.getName();
		Integer orders = req.getOrders();
		String menuType = req.getType();
		String url = req.getUrl();
		Integer pid = req.getPid();
		WeixinMenuExample de=new WeixinMenuExample();
		de.setOrderByClause(" pid,orders");
		Criteria c = de.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(menuKey)){
			c.andKeyEqualTo(menuKey);
		}
		if(!ValidateUtil.isEmpty(name)){
			c.andNameLike("%"+name+"%");
		}
		if(!ValidateUtil.isEmpty(orders)){
			c.andOrdersEqualTo(orders);
		}
		if(!ValidateUtil.isEmpty(menuType)){
			c.andTypeEqualTo(menuType);
		}
		if(!ValidateUtil.isEmpty(url)){
			c.andUrlEqualTo(url);
		}
		if(!ValidateUtil.isEmpty(pid)){
			c.andPidEqualTo(pid);
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<WeixinMenu> page = (Page<WeixinMenu>) weixinMenuMapper.selectByExample(de);
		WeixinMenuLtResp resp = new WeixinMenuLtResp();
		resp.setCount(page.getTotal());
		resp.setWeixinMenuLt(page.getResult());
		return resp;
	}
	/**
	 * 创建微信菜单
	 * @throws Exception
	 */
	private void createMenu() throws Exception {
		WeixinMenuExample de = new WeixinMenuExample();
		de.setOrderByClause(" pid,orders");
		List<WeixinMenu> weixinMenus = weixinMenuMapper.selectByExample(de);
		List<MenuItem> menus = convertMenuLt(weixinMenus);
		Menu menu = new Menu();
		menu.setMenus(menus);
		Menus.defaultMenus().create(menu);
	}
	/**
	 * 构建树形列表
	 * @param weixinMenus
	 * @return
	 * @throws Exception
	 */
	private List<MenuItem> convertMenuLt(List<WeixinMenu> weixinMenus) throws Exception {
		List<MenuItem> menuData = new ArrayList<MenuItem>();
		for(WeixinMenu weixinMenunu:weixinMenus){
			if(ValidateUtil.isEmpty(weixinMenunu.getPid())){
				MenuItem item = new MenuItem();
				BeanUtils.copyProperties(weixinMenunu, item);
				if(weixinMenunu.getType().equals(MenuTypeEnum.click.getCode())){
					item.setType(MenuType.click);
				}else{
					item.setType(MenuType.view);
				}
				List<MenuItem> children = new ArrayList<MenuItem>();
				for(WeixinMenu sub:weixinMenus){
					if(weixinMenunu.getId().equals(sub.getPid())){
						MenuItem subitem = new MenuItem();
						BeanUtils.copyProperties(sub, subitem);
						if(weixinMenunu.getType().equals(MenuTypeEnum.click.getCode())){
							subitem.setType(MenuType.click);
						}else{
							subitem.setType(MenuType.view);
						}
						children.add(subitem);
					}
				}
				item.setSubItems(children);
				menuData.add(item);
			}
		}
		return menuData;
	}
	
}
