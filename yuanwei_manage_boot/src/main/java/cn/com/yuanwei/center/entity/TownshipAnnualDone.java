package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.jeecgframework.poi.excel.annotation.Excel;


/**
 * 镇乡年度任务完成情况
 * 
 * @author zbk
 * @date 2017-06-15 15:30:39
 */
public class TownshipAnnualDone implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//乡镇ID
	 @Excel(name = "乡镇ID",isImportField="true")
	private Integer townshipId;
	//所属镇乡
	 @Excel(name = "所属镇乡",isImportField="true")
	private String townshipName;
	//年度
	 @Excel(name = "年度",isImportField="true")
	private Integer year;
	//零售额完成总量
	 @Excel(name = "零售额完成总量(千元)",isImportField="true")
	private BigDecimal retailSalesDone;
	//销售额总量
	 @Excel(name = "销售额总量(千元)",isImportField="true")
	private BigDecimal salesDone;
	//完成总量
	 @Excel(name = "完成总量(千元)",isImportField="true")
	private BigDecimal grossDone;
	//完成进度
	 @Excel(name = "完成进度(%)",isImportField="true")
	private BigDecimal doneRatio;
	//零售额增速
	 @Excel(name = "零售额增速(%)",isImportField="true")
	private BigDecimal retailSalesGrowth;
	//销售额增速
	 @Excel(name = "销售额增速(%)",isImportField="true")
	private BigDecimal salesGrowth;
	//综合增速
	 @Excel(name = "综合增速(%)",isImportField="true")
	private BigDecimal overallGrowth;
	//总申报数
	 @Excel(name = "总申报数",isImportField="true")
	private Integer totalApply;
	//总入库数
	 @Excel(name = "总入库数",isImportField="true")
	private Integer realAdd;
	//超额完成数
	 @Excel(name = "超额完成数",isImportField="true")
	private Integer overfulfilledAdd;
	//入库得分
	 @Excel(name = "入库得分",isImportField="true")
	private Integer addScore;
	//完成总量排位
	 @Excel(name = "完成总量排位",isImportField="true")
	private Integer grossQualifying;
	//完成进度排位
	 @Excel(name = "完成进度排位",isImportField="true")
	private Integer progressQualifying;
	//综合增速排位
	 @Excel(name = "综合增速排位",isImportField="true")
	private Integer growthQualifying;
	//入库得分排位
	 @Excel(name = "入库得分排位",isImportField="true")
	private Integer addQualifying;
	//总量排位得分
	 @Excel(name = "总量排位得分",isImportField="true")
	private Integer grossPoint;
	//增速排位得分
	 @Excel(name = "增速排位得分",isImportField="true")
	private Integer growthPoint;
	//完成任务排位得分
	 @Excel(name = "完成任务排位得分",isImportField="true")
	private Integer taskPoint;
	//单位分值金额
	 @Excel(name = "单位分值金额",isImportField="true")
	private BigDecimal perPointValue;
	//以奖代补金额
	 @Excel(name = "以奖代补金额",isImportField="true")
	private BigDecimal allowance;
	//完成新增限上入库排位得分
	 @Excel(name = "完成新增限上入库排位得分",isImportField="true")
	private Integer addPoint;
	//综合得分
	 @Excel(name = "综合得分",isImportField="true")
	private Integer totalPoint;
	//考核人
//	 @Excel(name = "考核人",isImportField="true")
	private Integer createBy;
	//考核时间
     @Excel(name = "考核时间",format="yyyy-MM-dd",isImportField="true")
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
	 * 设置：乡镇ID
	 */
	public void setTownshipId(Integer townshipId) {
		this.townshipId = townshipId;
	}
	/**
	 * 获取：乡镇ID
	 */
	public Integer getTownshipId() {
		return townshipId;
	}
	/**
	 * 设置：所属镇乡
	 */
	public void setTownshipName(String townshipName) {
		this.townshipName = townshipName;
	}
	/**
	 * 获取：所属镇乡
	 */
	public String getTownshipName() {
		return townshipName;
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
	 * 设置：零售额完成总量
	 */
	public void setRetailSalesDone(BigDecimal retailSalesDone) {
		this.retailSalesDone = retailSalesDone;
	}
	/**
	 * 获取：零售额完成总量
	 */
	public BigDecimal getRetailSalesDone() {
		return retailSalesDone;
	}
	/**
	 * 设置：销售额总量
	 */
	public void setSalesDone(BigDecimal salesDone) {
		this.salesDone = salesDone;
	}
	/**
	 * 获取：销售额总量
	 */
	public BigDecimal getSalesDone() {
		return salesDone;
	}
	/**
	 * 设置：完成总量
	 */
	public void setGrossDone(BigDecimal grossDone) {
		this.grossDone = grossDone;
	}
	/**
	 * 获取：完成总量
	 */
	public BigDecimal getGrossDone() {
		return grossDone;
	}
	/**
	 * 设置：完成进度
	 */
	public void setDoneRatio(BigDecimal doneRatio) {
		this.doneRatio = doneRatio;
	}
	/**
	 * 获取：完成进度
	 */
	public BigDecimal getDoneRatio() {
		return doneRatio;
	}
	/**
	 * 设置：零售额增速
	 */
	public void setRetailSalesGrowth(BigDecimal retailSalesGrowth) {
		this.retailSalesGrowth = retailSalesGrowth;
	}
	/**
	 * 获取：零售额增速
	 */
	public BigDecimal getRetailSalesGrowth() {
		return retailSalesGrowth;
	}
	/**
	 * 设置：销售额增速
	 */
	public void setSalesGrowth(BigDecimal salesGrowth) {
		this.salesGrowth = salesGrowth;
	}
	/**
	 * 获取：销售额增速
	 */
	public BigDecimal getSalesGrowth() {
		return salesGrowth;
	}
	/**
	 * 设置：综合增速
	 */
	public void setOverallGrowth(BigDecimal overallGrowth) {
		this.overallGrowth = overallGrowth;
	}
	/**
	 * 获取：综合增速
	 */
	public BigDecimal getOverallGrowth() {
		return overallGrowth;
	}
	/**
	 * 设置：总申报数
	 */
	public void setTotalApply(Integer totalApply) {
		this.totalApply = totalApply;
	}
	/**
	 * 获取：总申报数
	 */
	public Integer getTotalApply() {
		return totalApply;
	}
	/**
	 * 设置：总入库数
	 */
	public void setRealAdd(Integer realAdd) {
		this.realAdd = realAdd;
	}
	/**
	 * 获取：总入库数
	 */
	public Integer getRealAdd() {
		return realAdd;
	}
	/**
	 * 设置：超额完成数
	 */
	public void setOverfulfilledAdd(Integer overfulfilledAdd) {
		this.overfulfilledAdd = overfulfilledAdd;
	}
	/**
	 * 获取：超额完成数
	 */
	public Integer getOverfulfilledAdd() {
		return overfulfilledAdd;
	}
	/**
	 * 设置：入库得分
	 */
	public void setAddScore(Integer addScore) {
		this.addScore = addScore;
	}
	/**
	 * 获取：入库得分
	 */
	public Integer getAddScore() {
		return addScore;
	}
	/**
	 * 设置：完成总量排位
	 */
	public void setGrossQualifying(Integer grossQualifying) {
		this.grossQualifying = grossQualifying;
	}
	/**
	 * 获取：完成总量排位
	 */
	public Integer getGrossQualifying() {
		return grossQualifying;
	}
	/**
	 * 设置：完成进度排位
	 */
	public void setProgressQualifying(Integer progressQualifying) {
		this.progressQualifying = progressQualifying;
	}
	/**
	 * 获取：完成进度排位
	 */
	public Integer getProgressQualifying() {
		return progressQualifying;
	}
	/**
	 * 设置：综合增速排位
	 */
	public void setGrowthQualifying(Integer growthQualifying) {
		this.growthQualifying = growthQualifying;
	}
	/**
	 * 获取：综合增速排位
	 */
	public Integer getGrowthQualifying() {
		return growthQualifying;
	}
	/**
	 * 设置：入库得分排位
	 */
	public void setAddQualifying(Integer addQualifying) {
		this.addQualifying = addQualifying;
	}
	/**
	 * 获取：入库得分排位
	 */
	public Integer getAddQualifying() {
		return addQualifying;
	}
	/**
	 * 设置：总量排位得分
	 */
	public void setGrossPoint(Integer grossPoint) {
		this.grossPoint = grossPoint;
	}
	/**
	 * 获取：总量排位得分
	 */
	public Integer getGrossPoint() {
		return grossPoint;
	}
	/**
	 * 设置：增速排位得分
	 */
	public void setGrowthPoint(Integer growthPoint) {
		this.growthPoint = growthPoint;
	}
	/**
	 * 获取：增速排位得分
	 */
	public Integer getGrowthPoint() {
		return growthPoint;
	}
	/**
	 * 设置：完成任务排位得分
	 */
	public void setTaskPoint(Integer taskPoint) {
		this.taskPoint = taskPoint;
	}
	/**
	 * 获取：完成任务排位得分
	 */
	public Integer getTaskPoint() {
		return taskPoint;
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
	 * 设置：以奖代补金额
	 */
	public void setAllowance(BigDecimal allowance) {
		this.allowance = allowance;
	}
	/**
	 * 获取：以奖代补金额
	 */
	public BigDecimal getAllowance() {
		return allowance;
	}
	/**
	 * 设置：完成新增限上入库排位得分
	 */
	public void setAddPoint(Integer addPoint) {
		this.addPoint = addPoint;
	}
	/**
	 * 获取：完成新增限上入库排位得分
	 */
	public Integer getAddPoint() {
		return addPoint;
	}
	/**
	 * 设置：综合得分
	 */
	public void setTotalPoint(Integer totalPoint) {
		this.totalPoint = totalPoint;
	}
	/**
	 * 获取：综合得分
	 */
	public Integer getTotalPoint() {
		return totalPoint;
	}
	/**
	 * 设置：考核人
	 */
	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}
	/**
	 * 获取：考核人
	 */
	public Integer getCreateBy() {
		return createBy;
	}
	/**
	 * 设置：考核时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：考核时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	
    public TownshipAnnualDone() {
		super();
	}

	public TownshipAnnualDone(TownshipAnnualDoneVo vo) {
		 this.retailSalesDone = vo.getRetailSalesDone();
		 this.salesDone = vo.getSalesDone();
		 this.grossDone = vo.getGrossDone();
		 this.realAdd = vo.getRealAdd();
	}
}
