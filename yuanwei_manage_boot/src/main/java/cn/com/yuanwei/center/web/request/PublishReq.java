package cn.com.yuanwei.center.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import cn.com.yuanwei.center.web.request.base.PageReq;
/**
 * 内容发布
 * 
 * @author zbk
 * @email 
 * @date 2017-05-22 10:54:24
 */
@ApiModel
public class PublishReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//
	@ApiModelProperty(value = "",dataType="Integer")
	private Integer id;
	//父级ID
	@ApiModelProperty(value = "父级ID",dataType="Integer")
	private Integer pid;
	//栏目名称
	@ApiModelProperty(value = "栏目名称",dataType="String")
	private String name;
	//资源类型（1-栏目 2-文章 3-图片 4-链接）
	@ApiModelProperty(value = "资源类型（1-栏目 2-文章 3-图片 4-链接）",dataType="Integer")
	private Integer resType;
	//资源内容
	@ApiModelProperty(value = "资源内容",dataType="String")
	private String resValue;
	//链接地址
	@ApiModelProperty(value = "链接地址",dataType="String")
	private String href;

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
	 * 设置：父级ID
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	/**
	 * 获取：父级ID
	 */
	public Integer getPid() {
		return pid;
	}
	/**
	 * 设置：栏目名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：栏目名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：资源类型（1-栏目 2-文章 3-图片 4-链接）
	 */
	public void setResType(Integer resType) {
		this.resType = resType;
	}
	/**
	 * 获取：资源类型（1-栏目 2-文章 3-图片 4-链接）
	 */
	public Integer getResType() {
		return resType;
	}
	/**
	 * 设置：资源内容
	 */
	public void setResValue(String resValue) {
		this.resValue = resValue;
	}
	/**
	 * 获取：资源内容
	 */
	public String getResValue() {
		return resValue;
	}
	/**
	 * 设置：链接地址
	 */
	public void setHref(String href) {
		this.href = href;
	}
	/**
	 * 获取：链接地址
	 */
	public String getHref() {
		return href;
	}
}
