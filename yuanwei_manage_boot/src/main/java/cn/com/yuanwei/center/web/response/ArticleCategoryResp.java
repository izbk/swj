package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;


/**
 * 文章类别
 * 
 * @author zbk
 * @date 2017-05-16 11:11:22
 */
public class ArticleCategoryResp implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//父级id
	private Integer pid;
	//名称
	private String name;
	//索引位
	private String indexId;
	//子类列表
	private List<ArticleCategoryResp> children;

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
	
	public List<ArticleCategoryResp> getChildren() {
		return children;
	}
	public void setChildren(List<ArticleCategoryResp> children) {
		this.children = children;
	}
	
}
