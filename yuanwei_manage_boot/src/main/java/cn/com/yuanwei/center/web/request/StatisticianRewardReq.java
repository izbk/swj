package cn.com.yuanwei.center.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;

import cn.com.yuanwei.center.web.request.base.PageReq;
/**
 * 统计员补助金额信息
 * 
 * @author zbk
 * @email 
 * @date 2017-06-16 10:18:43
 */
@ApiModel
public class StatisticianRewardReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//主键ID
	@ApiModelProperty(value = "主键ID",dataType="Integer")
	private Integer id;
	//年度
	@ApiModelProperty(value = "年度",dataType="Integer")
	private Integer year;
	//开始时间
	@ApiModelProperty(value = "开始时间",dataType="Date")
	private Date startDate;
	//结束时间
	@ApiModelProperty(value = "结束时间",dataType="Date")
	private Date endDate;
	//总金额(元)
	@ApiModelProperty(value = "总金额(元)",dataType="BigDecimal")
	private BigDecimal amount;
	//总计得分
	@ApiModelProperty(value = "总计得分",dataType="Integer")
	private Integer totalPoint;
	//单位分值金额
	@ApiModelProperty(value = "单位分值金额",dataType="BigDecimal")
	private BigDecimal perPointValue;
	//创建时间
	@ApiModelProperty(value = "创建时间",dataType="Date")
	private Date createTime;
	//创建人
	@ApiModelProperty(value = "创建人",dataType="Integer")
	private Integer createBy;

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
	 * 设置：年度
	 */
	public void setYear(Integer year) {
		this.year = year;
	}
	/**
	 * 获取：年度
	 */
	public Integer getYear() {
		return year;
	}
	/**
	 * 设置：开始时间
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * 获取：开始时间
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * 设置：结束时间
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * 获取：结束时间
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * 设置：总金额(元)
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	/**
	 * 获取：总金额(元)
	 */
	public BigDecimal getAmount() {
		return amount;
	}
	/**
	 * 设置：总计得分
	 */
	public void setTotalPoint(Integer totalPoint) {
		this.totalPoint = totalPoint;
	}
	/**
	 * 获取：总计得分
	 */
	public Integer getTotalPoint() {
		return totalPoint;
	}
	/**
	 * 设置：单位分值金额
	 */
	public void setPerPointValue(BigDecimal perPointValue) {
		this.perPointValue = perPointValue;
	}
	/**
	 * 获取：单位分值金额
	 */
	public BigDecimal getPerPointValue() {
		return perPointValue;
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
}
