package cn.com.yuanwei.center.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import cn.com.yuanwei.center.web.request.base.PageReq;
/**
 * 微信菜单
 * 
 * @author zbk
 * @email 
 * @date 2017-06-08 15:01:39
 */
@ApiModel
public class WeixinMenuReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//主键ID
	@ApiModelProperty(value = "主键ID",dataType="Integer")
	private Integer id;
	//菜单KEY值
	@ApiModelProperty(value = "菜单KEY值",dataType="String")
	private String key;
	//菜单名称
	@ApiModelProperty(value = "菜单名称",dataType="String")
	private String name;
	//序号
	@ApiModelProperty(value = "序号",dataType="Integer")
	private Integer orders;
	//菜单类型
	@ApiModelProperty(value = "菜单类型",dataType="String")
	private String type;
	//菜单url
	@ApiModelProperty(value = "菜单url",dataType="String")
	private String url;
	//父级菜单
	@ApiModelProperty(value = "父级菜单",dataType="Integer")
	private Integer pid;

	/**
	 * 设置：主键ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：主键ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：菜单KEY值
	 */
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 * 获取：菜单KEY值
	 */
	public String getKey() {
		return key;
	}
	/**
	 * 设置：菜单名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：菜单名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：序号
	 */
	public void setOrders(Integer orders) {
		this.orders = orders;
	}
	/**
	 * 获取：序号
	 */
	public Integer getOrders() {
		return orders;
	}
	/**
	 * 设置：菜单类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：菜单类型
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：菜单url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：菜单url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：父级菜单
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	/**
	 * 获取：父级菜单
	 */
	public Integer getPid() {
		return pid;
	}
}
