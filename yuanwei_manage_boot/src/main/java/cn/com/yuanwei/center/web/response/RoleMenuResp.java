package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

public class RoleMenuResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<Integer> expandedIds;
	private List<Integer> checkedIds;
	private List<MenuResp> menuData;
	
	public List<Integer> getExpandedIds() {
		return expandedIds;
	}
	public void setExpandedIds(List<Integer> expandedIds) {
		this.expandedIds = expandedIds;
	}
	public List<Integer> getCheckedIds() {
		return checkedIds;
	}
	public void setCheckedIds(List<Integer> checkedIds) {
		this.checkedIds = checkedIds;
	}
	public List<MenuResp> getMenuData() {
		return menuData;
	}
	public void setMenuData(List<MenuResp> menuData) {
		this.menuData = menuData;
	}
	
}
