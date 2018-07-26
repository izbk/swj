package cn.com.yuanwei.center.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

import cn.com.yuanwei.center.web.request.base.PageReq;
/**
 * 文章
 * 
 * @author zbk
 * @email 
 * @date 2017-05-16 11:11:22
 */
@ApiModel
public class ArticleReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//主键ID
	@ApiModelProperty(value = "主键ID",dataType="Integer")
	private Integer id;
	//内容类型
	@ApiModelProperty(value = "内容类型",dataType="Integer")
	private Integer articleType;
	//文章种类
	@ApiModelProperty(value = "文章种类",dataType="Integer")
	private Integer articleCategory;
	//内容
	@ApiModelProperty(value = "内容",dataType="String")
	private String content;
	//简介
	@ApiModelProperty(value = "简介",dataType="String")
	private String breif;
	//内容来源
	@ApiModelProperty(value = "内容来源",dataType="String")
	private String source;
	//原文链接
	@ApiModelProperty(value = "原文链接",dataType="String")
	private String sourceUrl;
	//内容标题
	@ApiModelProperty(value = "内容标题",dataType="String")
	private String title;
	//内容作者
	@ApiModelProperty(value = "内容作者",dataType="String")
	private String author;
	//封面图片
	@ApiModelProperty(value = "封面图片",dataType="String")
	private String pic;
	//点击量
	@ApiModelProperty(value = "点击量",dataType="Integer")
	private Integer clickNum;
	//评论数量
	@ApiModelProperty(value = "评论数量",dataType="Integer")
	private Integer commentNum;
	//内容关键字
	@ApiModelProperty(value = "内容关键字",dataType="String")
	private String contentKeyword;
	//置顶级别
	@ApiModelProperty(value = "置顶级别",dataType="Integer")
	private Integer topLevel;
	//状态 (0:草稿 1:未审核 2:已审核 3:审核不通过)
	@ApiModelProperty(value = "状态 (0:草稿 1:未审核 2:已审核 3:审核不通过)",dataType="Integer")
	private Integer status;
	//发表日期
	@ApiModelProperty(value = "发表日期",dataType="Date")
	private Date publishTime;
	//部门ID
	@ApiModelProperty(value = "部门ID",dataType="String")
	private String departIds;
	//是否公开
	@ApiModelProperty(value = "是否公开",dataType="Integer")
	private Integer isPublic;
	//创建人
	@ApiModelProperty(value = "创建人",dataType="Integer")
	private Integer createBy;
	//创建时间
	@ApiModelProperty(value = "创建时间",dataType="Date")
	private Date createTime;
	//一级审核人
	@ApiModelProperty(value = "一级审核人",dataType="Integer")
	private Integer audit1By;
	//一级审核时间
	@ApiModelProperty(value = "一级审核时间",dataType="Date")
	private Date audit1Time;
	//二级审核人
	@ApiModelProperty(value = "二级审核人",dataType="Integer")
	private Integer audit2By;
	//二级审核时间
	@ApiModelProperty(value = "二级审核时间",dataType="Date")
	private Date audit2Time;
	//三级审核人
	@ApiModelProperty(value = "三级审核人",dataType="Integer")
	private Integer audit3By;
	//三级审核时间
	@ApiModelProperty(value = "三级审核时间",dataType="Date")
	private Date audit3Time;
	//备注
	@ApiModelProperty(value = "备注",dataType="String")
	private String remark;
	
	private Integer[] categorys;
	
	//所属品类
	private Integer category;
	//原产地
	private String origin;

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
	public Integer[] getCategorys() {
		return categorys;
	}
	public void setCategorys(Integer[] categorys) {
		this.categorys = categorys;
	}
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
}
