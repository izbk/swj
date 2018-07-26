package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

public class MenuResp implements Serializable{
	private static final long serialVersionUID = 1L;
		private Integer id;
	    private Integer pid;
	    private String menuName;
	    private String path;
	    private String icon;
	    private Integer sort;
	    private String indexId;
	    private List<MenuResp> children;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getPid() {
			return pid;
		}
		public void setPid(Integer pid) {
			this.pid = pid;
		}
		public String getMenuName() {
			return menuName;
		}
		public void setMenuName(String menuName) {
			this.menuName = menuName;
		}
		public String getPath() {
			return path;
		}
		public void setPath(String path) {
			this.path = path;
		}
		public String getIcon() {
			return icon;
		}
		public void setIcon(String icon) {
			this.icon = icon;
		}
		public Integer getSort() {
			return sort;
		}
		public void setSort(Integer sort) {
			this.sort = sort;
		}
		public String getIndexId() {
			return indexId;
		}
		public void setIndexId(String indexId) {
			this.indexId = indexId;
		}
		public List<MenuResp> getChildren() {
			return children;
		}
		public void setChildren(List<MenuResp> children) {
			this.children = children;
		}
	
	
	
}
