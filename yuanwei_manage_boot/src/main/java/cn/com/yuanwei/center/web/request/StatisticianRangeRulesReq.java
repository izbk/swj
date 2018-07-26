package cn.com.yuanwei.center.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;

import cn.com.yuanwei.center.web.request.base.PageReq;
/**
 * 统计员排位得分规则
 * 
 * @author zbk
 * @email 
 * @date 2017-06-19 11:58:18
 */
@ApiModel
public class StatisticianRangeRulesReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//主键ID
	@ApiModelProperty(value = "主键ID",dataType="Integer")
	private Integer id;
	//左区间
	@ApiModelProperty(value = "左区间",dataType="BigDecimal")
	private BigDecimal minValue;
	//右区间
	@ApiModelProperty(value = "右区间",dataType="BigDecimal")
	private BigDecimal maxValue;
	//得分
	@ApiModelProperty(value = "得分",dataType="Integer")
	private Integer point;
	//范围类型
	@ApiModelProperty(value = "范围类型",dataType="Integer")
	private Integer rangeType;
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
	 * 设置：左区间
	 */
	public void setMinValue(BigDecimal minValue) {
		this.minValue = minValue;
	}
	/**
	 * 获取：左区间
	 */
	public BigDecimal getMinValue() {
		return minValue;
	}
	/**
	 * 设置：右区间
	 */
	public void setMaxValue(BigDecimal maxValue) {
		this.maxValue = maxValue;
	}
	/**
	 * 获取：右区间
	 */
	public BigDecimal getMaxValue() {
		return maxValue;
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
	 * 设置：范围类型
	 */
	public void setRangeType(Integer rangeType) {
		this.rangeType = rangeType;
	}
	/**
	 * 获取：范围类型
	 */
	public Integer getRangeType() {
		return rangeType;
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
