package cn.com.yuanwei.center.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

import cn.com.yuanwei.center.web.request.base.PageReq;
/**
 * 订阅消息
 * 
 * @author zbk
 * @email 
 * @date 2017-06-05 11:09:42
 */
@ApiModel
public class WeixinSubscribeReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//主键ID
	@ApiModelProperty(value = "主键ID",dataType="Integer")
	private Integer id;
	//欢迎语
	@ApiModelProperty(value = "欢迎语",dataType="String")
	private String welcome;
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
	 * 设置：欢迎语
	 */
	public void setWelcome(String welcome) {
		this.welcome = welcome;
	}
	/**
	 * 获取：欢迎语
	 */
	public String getWelcome() {
		return welcome;
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
