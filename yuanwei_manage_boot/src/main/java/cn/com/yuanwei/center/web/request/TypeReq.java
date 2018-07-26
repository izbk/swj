package cn.com.yuanwei.center.web.request;

import cn.com.yuanwei.center.web.request.base.PageReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 数据类型
 * 
 * @author zbk
 * @email 
 * @date 2017-04-24 10:29:22
 */
@ApiModel
public class TypeReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//主键ID
	@ApiModelProperty(value = "主键ID",dataType="Integer")
	private Integer id;
	//名称
	@ApiModelProperty(value = "名称",dataType="String")
	private String typeName;
	//代码
	@ApiModelProperty(value = "代码",dataType="String")
	private String typeCode;
	//类型组ID
	@ApiModelProperty(value = "类型组ID",dataType="Integer")
	private Integer typeGroupId;
	//
	@ApiModelProperty(value = "",dataType="Integer")
	private Integer status;

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
	 * 设置：名称
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	/**
	 * 获取：名称
	 */
	public String getTypeName() {
		return typeName;
	}
	/**
	 * 设置：代码
	 */
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	/**
	 * 获取：代码
	 */
	public String getTypeCode() {
		return typeCode;
	}
	/**
	 * 设置：类型组ID
	 */
	public void setTypeGroupId(Integer typeGroupId) {
		this.typeGroupId = typeGroupId;
	}
	/**
	 * 获取：类型组ID
	 */
	public Integer getTypeGroupId() {
		return typeGroupId;
	}
	/**
	 * 设置：
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：
	 */
	public Integer getStatus() {
		return status;
	}
}
