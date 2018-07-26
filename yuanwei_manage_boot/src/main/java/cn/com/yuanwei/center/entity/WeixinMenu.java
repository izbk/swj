package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import org.jeecgframework.poi.excel.annotation.Excel;


/**
 * 微信菜单
 * 
 * @author zbk
 * @date 2017-06-08 15:01:39
 */
public class WeixinMenu implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//菜单KEY值
	 @Excel(name = "菜单KEY值",isImportField="true")
	private String key;
	//菜单名称
	 @Excel(name = "菜单名称",isImportField="true")
	private String name;
	//序号
	 @Excel(name = "序号",isImportField="true")
	private Integer orders;
	//菜单类型
	 @Excel(name = "菜单类型",isImportField="true")
	private String type;
	//菜单url
	 @Excel(name = "菜单url",isImportField="true")
	private String url;
	//父级菜单
	 @Excel(name = "父级菜单",isImportField="true")
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
