package cn.com.yuanwei.center.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import cn.com.yuanwei.center.web.request.base.PageReq;
/**
 * 微信模板消息
 * 
 * @author zbk
 * @email 
 * @date 2017-06-05 16:18:41
 */
@ApiModel
public class WeixinTemplateReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//主键ID
	@ApiModelProperty(value = "主键ID",dataType="Integer")
	private Integer id;
	//通知类型
	@ApiModelProperty(value = "通知类型",dataType="Integer")
	private Integer noticeType;
	//通知内容
	@ApiModelProperty(value = "通知内容",dataType="String")
	private String content;
	//备注
	@ApiModelProperty(value = "备注",dataType="String")
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
	 * 设置：通知类型
	 */
	public void setNoticeType(Integer noticeType) {
		this.noticeType = noticeType;
	}
	/**
	 * 获取：通知类型
	 */
	public Integer getNoticeType() {
		return noticeType;
	}
	/**
	 * 设置：通知内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：通知内容
	 */
	public String getContent() {
		return content;
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
}
