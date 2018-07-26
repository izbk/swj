package cn.com.yuanwei.center.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

import cn.com.yuanwei.center.web.request.base.PageReq;
/**
 * 统计员计分细则
 * 
 * @author zbk
 * @email 
 * @date 2017-06-15 15:17:36
 */
@ApiModel
public class StatisticianScoringRulesReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//主键ID
	@ApiModelProperty(value = "主键ID",dataType="Integer")
	private Integer id;
	//规则
	@ApiModelProperty(value = "规则",dataType="String")
	private String rule;
	//得分
	@ApiModelProperty(value = "得分",dataType="Integer")
	private Integer point;
	//得分类型
	@ApiModelProperty(value = "得分类型",dataType="Integer")
	private Integer pointType;
	//创建人
	@ApiModelProperty(value = "创建人",dataType="Integer")
	private Integer createBy;
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
	 * 设置：规则
	 */
	public void setRule(String rule) {
		this.rule = rule;
	}
	/**
	 * 获取：规则
	 */
	public String getRule() {
		return rule;
	}
	/**
	 * 设置：得分
	 */
	public void setPoint(Integer point) {
		this.point = point;
	}
	/**
	 * 获取：得分
	 */
	public Integer getPoint() {
		return point;
	}
	/**
	 * 设置：得分类型
	 */
	public void setPointType(Integer pointType) {
		this.pointType = pointType;
	}
	/**
	 * 获取：得分类型
	 */
	public Integer getPointType() {
		return pointType;
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
}
