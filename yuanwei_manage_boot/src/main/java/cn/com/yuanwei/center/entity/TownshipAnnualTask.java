package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import org.jeecgframework.poi.excel.annotation.Excel;
import java.util.Date;
import java.math.BigDecimal;


/**
 * 镇乡年度目标任务表
 * 
 * @author zbk
 * @date 2017-06-15 15:17:36
 */
public class TownshipAnnualTask implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//乡镇ID
//	 @Excel(name = "乡镇ID",isImportField="true")
	private Integer townshipId;
	//所属镇乡
	 @Excel(name = "所属镇乡",isImportField="true")
	private String townshipName;
	//零售额总量目标
	 @Excel(name = "零售额总量目标(千元)",isImportField="true")
	private BigDecimal retailSalesTask;
	//销售额总量目标
	 @Excel(name = "销售额总量目标(千元)",isImportField="true")
	private BigDecimal salesTask;
	//目标总任务
	 @Excel(name = "目标总任务(千元)",isImportField="true")
	private BigDecimal totalTask;
	//新增入库目标个数
	 @Excel(name = "新增入库目标个数",isImportField="true")
	private Integer addTask;
	 //实际申报数量
	 @Excel(name = "实际申报数量",isImportField="true")
	 private Integer totalApply;
	//年度
	 @Excel(name = "年度",isImportField="true")
	private Integer year;
	//创建人
//	 @Excel(name = "创建人",isImportField="true")
	private Integer createBy;
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
	 * 设置：零售额总量目标
	 */
	public void setRetailSalesTask(BigDecimal retailSalesTask) {
		this.retailSalesTask = retailSalesTask;
	}
	/**
	 * 获取：零售额总量目标
	 */
	public BigDecimal getRetailSalesTask() {
		return retailSalesTask;
	}
	/**
	 * 设置：销售额总量目标
	 */
	public void setSalesTask(BigDecimal salesTask) {
		this.salesTask = salesTask;
	}
	/**
	 * 获取：销售额总量目标
	 */
	public BigDecimal getSalesTask() {
		return salesTask;
	}
	/**
	 * 设置：目标总任务
	 */
	public void setTotalTask(BigDecimal totalTask) {
		this.totalTask = totalTask;
	}
	/**
	 * 获取：目标总任务
	 */
	public BigDecimal getTotalTask() {
		return totalTask;
	}
	/**
	 * 设置：新增入库目标个数
	 */
	public void setAddTask(Integer addTask) {
		this.addTask = addTask;
	}
	/**
	 * 获取：新增入库目标个数
	 */
	public Integer getAddTask() {
		return addTask;
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
	public Integer getTotalApply() {
		return totalApply;
	}
	public void setTotalApply(Integer totalApply) {
		this.totalApply = totalApply;
	}
	
}
