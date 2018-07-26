package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class TownshipAnnualDoneVo implements Serializable {

    private BigDecimal retailSalesDone;

    private BigDecimal salesDone;

    private BigDecimal grossDone;

    private Integer realAdd;
    
    private Integer totalTask;
    
    private Integer addTask;
    
    private Integer totalApply;
    
    private Integer taskId;
    
    private Integer townshipId;

    private static final long serialVersionUID = 1L;

	public BigDecimal getRetailSalesDone() {
		return retailSalesDone;
	}

	public void setRetailSalesDone(BigDecimal retailSalesDone) {
		this.retailSalesDone = retailSalesDone;
	}

	public BigDecimal getSalesDone() {
		return salesDone;
	}

	public void setSalesDone(BigDecimal salesDone) {
		this.salesDone = salesDone;
	}

	public BigDecimal getGrossDone() {
		return grossDone;
	}

	public void setGrossDone(BigDecimal grossDone) {
		this.grossDone = grossDone;
	}

	public Integer getRealAdd() {
		return realAdd;
	}

	public void setRealAdd(Integer realAdd) {
		this.realAdd = realAdd;
	}

	public Integer getTotalTask() {
		return totalTask;
	}

	public void setTotalTask(Integer totalTask) {
		this.totalTask = totalTask;
	}

	public Integer getAddTask() {
		return addTask;
	}

	public void setAddTask(Integer addTask) {
		this.addTask = addTask;
	}
	
	public Integer getTotalApply() {
		return totalApply;
	}

	public void setTotalApply(Integer totalApply) {
		this.totalApply = totalApply;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public Integer getTownshipId() {
		return townshipId;
	}

	public void setTownshipId(Integer townshipId) {
		this.townshipId = townshipId;
	}


}