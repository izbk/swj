package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.WeixinMenu;
import cn.com.yuanwei.center.web.request.WeixinMenuReq;
import cn.com.yuanwei.center.web.response.WeixinMenuLtResp;
/**
 * 微信菜单
 * 
 * @author zbk
 * @email 
 * @date 2017-06-05 11:09:42
 */
public interface WeixinMenuService {
   /**
	 * Desc:查询微信菜单
	 * @param Integer id
	 * @return  WeixinMenu
	 * @author zbk
	 * @date 2017-06-05 11:09:42
	 */
	public WeixinMenu queryById(Integer id) throws Exception;
   /**
	 * Desc:查询微信菜单列表
	 * @param WeixinMenuReq req
	 * @return WeixinMenuLtResp
	 * @author zbk
	 * @date 2017-06-05 11:09:42
	 */
	public WeixinMenuLtResp queryList(WeixinMenuReq req) throws Exception;
   /**
	 * Desc:新增微信菜单
	 * @param WeixinMenu weixinMenu
	 * @return Integer id
	 * @author zbk
	 * @date 2017-06-05 11:09:42
	 */
	public Integer save(WeixinMenu weixinMenu) throws Exception;
	/**
	 * Desc:更新微信菜单
	 * @param WeixinMenu weixinMenu
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-05 11:09:42
	 */
	public Integer update(WeixinMenu weixinMenu) throws Exception;
	/**
	 * Desc:删除微信菜单
	 * @param List<Integer> req
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-05 11:09:42
	 */
	public Integer delete(List<Integer> req) throws Exception;
	/**
	 * Desc:同步微信菜单
	 * @param List<Integer> ids
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-05 11:09:42
	 */
	public void sync(List<Integer> ids) throws Exception;
}
