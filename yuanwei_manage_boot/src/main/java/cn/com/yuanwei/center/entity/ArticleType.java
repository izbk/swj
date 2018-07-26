package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import org.jeecgframework.poi.excel.annotation.Excel;


/**
 * 文章类型
 * 
 * @author zbk
 * @date 2017-05-16 11:11:22
 */
public class ArticleType implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//父级id
	 @Excel(name = "父级id",isImportField="true")
	private Integer pid;
	//名称
	 @Excel(name = "名称",isImportField="true")
	private String name;
	//索引位
	 @Excel(name = "索引位",isImportField="true")
	private String indexId;
	//描述
	 @Excel(name = "描述",isImportField="true")
	private String remark;

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
	/**
	 * 设置：描述
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：描述
	 */
	public String getRemark() {
		return remark;
	}
}
