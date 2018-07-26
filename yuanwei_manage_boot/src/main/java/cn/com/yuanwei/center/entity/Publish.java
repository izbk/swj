package cn.com.yuanwei.center.entity;

import java.io.Serializable;

import org.jeecgframework.poi.excel.annotation.Excel;


/**
 * 内容发布
 * 
 * @author zbk
 * @date 2017-05-22 11:54:20
 */
public class Publish implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// ID
	private Integer id;
	// 父级ID
	@Excel(name = "父级ID", isImportField = "true")
	private Integer pid;
	// 栏目名称
	@Excel(name = "栏目名称", isImportField = "true")
	private String name;
	// 资源类型（1-栏目 2-文章 3-图片 4-链接）
	@Excel(name = "资源类型", replace = { "栏目_1", "文章_2", "图片_3", "链接_4","富文本_5","绵竹造_6" }, isImportField = "true")
	private Integer resType;
	// 资源内容
	@Excel(name = "资源内容", isImportField = "true")
	private String resValue;
	// 链接地址
	@Excel(name = "链接地址", isImportField = "true")
	private String href;
	// 序号
	@Excel(name = "序号", isImportField = "true")
	private Integer sort;
	// 序号
	@Excel(name = "索引位", isImportField = "true")
	private String indexId;
	
	private Integer[] articleCategorys;

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
	/**
	 * 设置：序号
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：序号
	 */
	public Integer getSort() {
		return sort;
	}
	
	public String getIndexId() {
		return indexId;
	}
	public void setIndexId(String indexId) {
		this.indexId = indexId;
	}
	public Integer[] getArticleCategorys() {
		return articleCategorys;
	}
	public void setArticleCategorys(Integer[] articleCategorys) {
		this.articleCategorys = articleCategorys;
	}
	
}
