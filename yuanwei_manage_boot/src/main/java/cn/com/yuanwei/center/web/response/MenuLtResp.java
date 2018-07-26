package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.Menu;
/**
 * 菜单
 * 
 * @author zbk
 * @email 
 * @date 2017-05-17 09:29:29
 */
public class MenuLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<Menu> menuLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<Menu> getMenuLt() {
		return menuLt;
	}
	public void setMenuLt(List<Menu> menuLt) {
		this.menuLt = menuLt;
	}
}
