package cn.com.yuanwei.center.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

import cn.com.yuanwei.center.web.request.base.PageReq;
/**
 * 微信文本消息
 * 
 * @author zbk
 * @email 
 * @date 2017-06-05 11:09:42
 */
@ApiModel
public class WeixinTextReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//主键ID
	@ApiModelProperty(value = "主键ID",dataType="Integer")
	private Integer id;
	//文章ID
	@ApiModelProperty(value = "文章ID",dataType="Integer")
	private Integer articleId;
	//标题
	@ApiModelProperty(value = "标题",dataType="String")
	private String title;
	//消息内容
	@ApiModelProperty(value = "消息内容",dataType="String")
	private String content;
	//创建时间
	@ApiModelProperty(value = "创建时间",dataType="Date")
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
