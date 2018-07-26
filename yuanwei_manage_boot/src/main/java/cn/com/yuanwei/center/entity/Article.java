package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import org.jeecgframework.poi.excel.annotation.Excel;
import java.util.Date;


/**
 * 文章
 * 
 * @author zbk
 * @date 2017-05-16 11:11:22
 */
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//内容类型
	 @Excel(name = "内容类型",replace={"公告_1","资讯_2"},isImportField="true")
	private Integer articleType;
	//文章种类
	 @Excel(name = "文章种类",replace={"新闻_1","体育新闻_3","NBA_8","娱乐新闻_9","喜剧总动员_10","潮流前线_18","文章_21","文学类_23"},isImportField="true")
	private Integer articleCategory;
	//内容
	 @Excel(name = "内容",isImportField="true")
	private String content;
	//简介
	 @Excel(name = "简介",isImportField="true")
	private String breif;
	//内容来源
	 @Excel(name = "内容来源",isImportField="true")
	private String source;
	//原文链接
	 @Excel(name = "原文链接",isImportField="true")
	private String sourceUrl;
	//内容标题
	 @Excel(name = "内容标题",isImportField="true")
	private String title;
	//内容作者
	 @Excel(name = "内容作者",isImportField="true")
	private String author;
	//封面图片
	 @Excel(name = "封面图片",isImportField="true")
	private String pic;
	//点击量
	 @Excel(name = "点击量",isImportField="true")
	private Integer clickNum;
	//评论数量
	 @Excel(name = "评论数量",isImportField="true")
	private Integer commentNum;
	//内容关键字
	 @Excel(name = "内容关键字",isImportField="true")
	private String contentKeyword;
	//置顶级别
	 @Excel(name = "置顶级别",isImportField="true")
	private Integer topLevel;
	//状态 (0:草稿 1:未审核 2:已审核 3:审核不通过)
	 @Excel(name = "状态",replace={"草稿_0","未审核_1","已审核_2","审核不通过_3"},isImportField="true")
	private Integer status;
	//发表日期
     @Excel(name = "发表日期",format="yyyy-MM-dd",isImportField="true")
	private Date publishTime;
	//部门ID
	 @Excel(name = "部门ID",isImportField="true")
	private String departIds;
	//是否公开
	 @Excel(name = "是否公开",replace={"否_0","是_1"},isImportField="true")
	private Integer isPublic;
	//创建人
	 @Excel(name = "创建人",isImportField="true")
	private Integer createBy;
	//创建时间
     @Excel(name = "创建时间",format="yyyy-MM-dd",isImportField="true")
	private Date createTime;
	//一级审核人
	 @Excel(name = "一级审核人",isImportField="true")
	private Integer audit1By;
	//一级审核时间
     @Excel(name = "一级审核时间",format="yyyy-MM-dd",isImportField="true")
	private Date audit1Time;
	//二级审核人
	 @Excel(name = "二级审核人",isImportField="true")
	private Integer audit2By;
	//二级审核时间
     @Excel(name = "二级审核时间",format="yyyy-MM-dd",isImportField="true")
	private Date audit2Time;
	//三级审核人
	 @Excel(name = "三级审核人",isImportField="true")
	private Integer audit3By;
	//三级审核时间
     @Excel(name = "三级审核时间",format="yyyy-MM-dd",isImportField="true")
	private Date audit3Time;
	//备注
	 @Excel(name = "备注",isImportField="true")
	private String remark;
	 
	private String audit1Opinion;
	private String audit2Opinion;
	private String audit3Opinion;
	 
	private Integer[] articleCategorys;

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
	 * 设置：内容类型
	 */
	public void setArticleType(Integer articleType) {
		this.articleType = articleType;
	}
	/**
	 * 获取：内容类型
	 */
	public Integer getArticleType() {
		return articleType;
	}
	/**
	 * 设置：文章种类
	 */
	public void setArticleCategory(Integer articleCategory) {
		this.articleCategory = articleCategory;
	}
	/**
	 * 获取：文章种类
	 */
	public Integer getArticleCategory() {
		return articleCategory;
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
	 * 设置：简介
	 */
	public void setBreif(String breif) {
		this.breif = breif;
	}
	/**
	 * 获取：简介
	 */
	public String getBreif() {
		return breif;
	}
	/**
	 * 设置：内容来源
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * 获取：内容来源
	 */
	public String getSource() {
		return source;
	}
	/**
	 * 设置：原文链接
	 */
	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}
	/**
	 * 获取：原文链接
	 */
	public String getSourceUrl() {
		return sourceUrl;
	}
	/**
	 * 设置：内容标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：内容标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：内容作者
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * 获取：内容作者
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * 设置：封面图片
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}
	/**
	 * 获取：封面图片
	 */
	public String getPic() {
		return pic;
	}
	/**
	 * 设置：点击量
	 */
	public void setClickNum(Integer clickNum) {
		this.clickNum = clickNum;
	}
	/**
	 * 获取：点击量
	 */
	public Integer getClickNum() {
		return clickNum;
	}
	/**
	 * 设置：评论数量
	 */
	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}
	/**
	 * 获取：评论数量
	 */
	public Integer getCommentNum() {
		return commentNum;
	}
	/**
	 * 设置：内容关键字
	 */
	public void setContentKeyword(String contentKeyword) {
		this.contentKeyword = contentKeyword;
	}
	/**
	 * 获取：内容关键字
	 */
	public String getContentKeyword() {
		return contentKeyword;
	}
	/**
	 * 设置：置顶级别
	 */
	public void setTopLevel(Integer topLevel) {
		this.topLevel = topLevel;
	}
	/**
	 * 获取：置顶级别
	 */
	public Integer getTopLevel() {
		return topLevel;
	}
	/**
	 * 设置：状态 (0:草稿 1:未审核 2:已审核 3:审核不通过)
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态 (0:草稿 1:未审核 2:已审核 3:审核不通过)
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：发表日期
	 */
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	/**
	 * 获取：发表日期
	 */
	public Date getPublishTime() {
		return publishTime;
	}
	/**
	 * 设置：部门ID
	 */
	public void setDepartIds(String departIds) {
		this.departIds = departIds;
	}
	/**
	 * 获取：部门ID
	 */
	public String getDepartIds() {
		return departIds;
	}
	/**
	 * 设置：是否公开
	 */
	public void setIsPublic(Integer isPublic) {
		this.isPublic = isPublic;
	}
	/**
	 * 获取：是否公开
	 */
	public Integer getIsPublic() {
		return isPublic;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}
	/**
	 * 获取：创建人
	 */
	public Integer getCreateBy() {
		return createBy;
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
	/**
	 * 设置：一级审核人
	 */
	public void setAudit1By(Integer audit1By) {
		this.audit1By = audit1By;
	}
	/**
	 * 获取：一级审核人
	 */
	public Integer getAudit1By() {
		return audit1By;
	}
	/**
	 * 设置：一级审核时间
	 */
	public void setAudit1Time(Date audit1Time) {
		this.audit1Time = audit1Time;
	}
	/**
	 * 获取：一级审核时间
	 */
	public Date getAudit1Time() {
		return audit1Time;
	}
	/**
	 * 设置：二级审核人
	 */
	public void setAudit2By(Integer audit2By) {
		this.audit2By = audit2By;
	}
	/**
	 * 获取：二级审核人
	 */
	public Integer getAudit2By() {
		return audit2By;
	}
	/**
	 * 设置：二级审核时间
	 */
	public void setAudit2Time(Date audit2Time) {
		this.audit2Time = audit2Time;
	}
	/**
	 * 获取：二级审核时间
	 */
	public Date getAudit2Time() {
		return audit2Time;
	}
	/**
	 * 设置：三级审核人
	 */
	public void setAudit3By(Integer audit3By) {
		this.audit3By = audit3By;
	}
	/**
	 * 获取：三级审核人
	 */
	public Integer getAudit3By() {
		return audit3By;
	}
	/**
	 * 设置：三级审核时间
	 */
	public void setAudit3Time(Date audit3Time) {
		this.audit3Time = audit3Time;
	}
	/**
	 * 获取：三级审核时间
	 */
	public Date getAudit3Time() {
		return audit3Time;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
	
	public String getAudit1Opinion() {
		return audit1Opinion;
	}
	public void setAudit1Opinion(String audit1Opinion) {
		this.audit1Opinion = audit1Opinion;
	}
	public String getAudit2Opinion() {
		return audit2Opinion;
	}
	public void setAudit2Opinion(String audit2Opinion) {
		this.audit2Opinion = audit2Opinion;
	}
	public String getAudit3Opinion() {
		return audit3Opinion;
	}
	public void setAudit3Opinion(String audit3Opinion) {
		this.audit3Opinion = audit3Opinion;
	}
	public Integer[] getArticleCategorys() {
		return articleCategorys;
	}
	public void setArticleCategorys(Integer[] articleCategorys) {
		this.articleCategorys = articleCategorys;
	}
	
}
