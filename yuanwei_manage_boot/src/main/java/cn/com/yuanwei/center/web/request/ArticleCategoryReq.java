package cn.com.yuanwei.center.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import cn.com.yuanwei.center.web.request.base.PageReq;
/**
 * 文章类别
 * 
 * @author zbk
 * @email 
 * @date 2017-05-16 11:11:22
 */
@ApiModel
public class ArticleCategoryReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//主键ID
	@ApiModelProperty(value = "主键ID",dataType="Integer")
	private Integer id;
	//父级id
	@ApiModelProperty(value = "父级id",dataType="Integer")
	private Integer pid;
	//名称
	@ApiModelProperty(value = "名称",dataType="String")
	private String name;
	//索引位
	@ApiModelProperty(value = "索引位",dataType="String")
	private String indexId;

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
	 * 设置：父级id
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	/**
	 * 获取：父级id
	 */
	public Integer getPid() {
		return pid;
	}
	/**
	 * 设置：名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：名称
	 */
	public String getName() {
		return name;
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
