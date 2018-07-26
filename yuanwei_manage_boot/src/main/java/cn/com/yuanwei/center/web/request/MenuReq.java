package cn.com.yuanwei.center.web.request;

import cn.com.yuanwei.center.web.request.base.PageReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 菜单
 * 
 * @author zbk
 * @email 
 * @date 2017-05-17 09:29:29
 */
@ApiModel
public class MenuReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//
	@ApiModelProperty(value = "",dataType="Integer")
	private Integer id;
	//
	@ApiModelProperty(value = "",dataType="Integer")
	private Integer pid;
	//菜单名称
	@ApiModelProperty(value = "菜单名称",dataType="String")
	private String menuName;
	//路径
	@ApiModelProperty(value = "路径",dataType="String")
	private String path;
	//图标
	@ApiModelProperty(value = "图标",dataType="String")
	private String icon;
	//索引位
	@ApiModelProperty(value = "索引位",dataType="String")
	private String indexId;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	/**
	 * 获取：
	 */
	public Integer getPid() {
		return pid;
	}
	/**
	 * 设置：菜单名称
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	/**
	 * 获取：菜单名称
	 */
	public String getMenuName() {
		return menuName;
	}
	/**
	 * 设置：路径
	 */
	public void setPath(String path) {
		this.path = path;
	}
	/**
	 * 获取：路径
	 */
	public String getPath() {
		return path;
	}
	/**
	 * 设置：图标
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	/**
	 * 获取：图标
	 */
	public String getIcon() {
		return icon;
	}
	/**
	 * 设置：索引位
	 */
	public void setIndexId(String indexId) {
		this.indexId = indexId;
	}
	/**
	 * 获取：索引位
	 */
	public String getIndexId() {
		return indexId;
	}
}
