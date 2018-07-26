package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import org.jeecgframework.poi.excel.annotation.Excel;
import java.util.Date;


/**
 * 微信文本消息
 * 
 * @author zbk
 * @date 2017-06-05 11:09:42
 */
public class WeixinText implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//文章ID
	 @Excel(name = "文章ID",isImportField="true")
	private Integer articleId;
	//标题
	 @Excel(name = "标题",isImportField="true")
	private String title;
	//消息内容
	 @Excel(name = "消息内容",isImportField="true")
	private String content;
	//创建时间
     @Excel(name = "创建时间",format="yyyy-MM-dd",isImportField="true")
	private Date createTime;

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
	 * 设置：文章ID
	 */
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	/**
	 * 获取：文章ID
	 */
	public Integer getArticleId() {
		return articleId;
	}
	/**
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：消息内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：消息内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
