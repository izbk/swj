package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import org.jeecgframework.poi.excel.annotation.Excel;
import java.util.Date;


/**
 * 微信图文消息
 * 
 * @author zbk
 * @date 2017-06-05 11:09:42
 */
public class WeixinNewsitem implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//文章编号
	 @Excel(name = "文章编号",isImportField="true")
	private Integer articleId;
	//标题
	 @Excel(name = "标题",isImportField="true")
	private String title;
	//作者
	 @Excel(name = "作者",isImportField="true")
	private String author;
	//内容
	 @Excel(name = "内容",isImportField="true")
	private String content;
	//摘要
	 @Excel(name = "摘要",isImportField="true")
	private String digest;
	//封面图片素材id
	 @Excel(name = "封面图片素材id",isImportField="true")
	private String thumbMediaId;
	//
	 @Excel(name = "",isImportField="true")
	private Integer showCoverPic;
	//原文地址
	 @Excel(name = "原文地址",isImportField="true")
	private String contentSourceUrl;
	//排序号
	 @Excel(name = "排序号",isImportField="true")
	private Integer orders;
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
	 * 设置：文章编号
	 */
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	/**
	 * 获取：文章编号
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
	 * 设置：作者
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * 获取：作者
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * 设置：内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：摘要
	 */
	public void setDigest(String digest) {
		this.digest = digest;
	}
	/**
	 * 获取：摘要
	 */
	public String getDigest() {
		return digest;
	}
	/**
	 * 设置：封面图片素材id
	 */
	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}
	/**
	 * 获取：封面图片素材id
	 */
	public String getThumbMediaId() {
		return thumbMediaId;
	}
	/**
	 * 设置：
	 */
	public void setShowCoverPic(Integer showCoverPic) {
		this.showCoverPic = showCoverPic;
	}
	/**
	 * 获取：
	 */
	public Integer getShowCoverPic() {
		return showCoverPic;
	}
	/**
	 * 设置：原文地址
	 */
	public void setContentSourceUrl(String contentSourceUrl) {
		this.contentSourceUrl = contentSourceUrl;
	}
	/**
	 * 获取：原文地址
	 */
	public String getContentSourceUrl() {
		return contentSourceUrl;
	}
	/**
	 * 设置：排序号
	 */
	public void setOrders(Integer orders) {
		this.orders = orders;
	}
	/**
	 * 获取：排序号
	 */
	public Integer getOrders() {
		return orders;
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
