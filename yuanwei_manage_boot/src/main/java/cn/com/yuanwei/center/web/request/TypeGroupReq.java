package cn.com.yuanwei.center.web.request;

import cn.com.yuanwei.center.web.request.base.PageReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 数据类型定义
 * 
 * @author zbk
 * @email 
 * @date 2017-04-24 10:29:23
 */
@ApiModel
public class TypeGroupReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//主键ID
	@ApiModelProperty(value = "主键ID",dataType="Integer")
	private Integer id;
	//类型名称
	@ApiModelProperty(value = "类型名称",dataType="String")
	private String groupName;
	//类型编码
	@ApiModelProperty(value = "类型编码",dataType="String")
	private String groupCode;

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
	 * 设置：类型名称
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	/**
	 * 获取：类型名称
	 */
	public String getGroupName() {
		return groupName;
	}
	/**
	 * 设置：类型编码
	 */
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	/**
	 * 获取：类型编码
	 */
	public String getGroupCode() {
		return groupCode;
	}
}
