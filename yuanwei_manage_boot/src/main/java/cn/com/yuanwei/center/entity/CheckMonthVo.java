package cn.com.yuanwei.center.entity;

import java.io.Serializable;

public class CheckMonthVo implements Serializable {

    private Integer months;
    
    private Integer maxMonth;

    private static final long serialVersionUID = 1L;

	public Integer getMonths() {
		return months;
	}

	public void setMonths(Integer months) {
		this.months = months;
	}

	public Integer getMaxMonth() {
		return maxMonth;
	}

	public void setMaxMonth(Integer maxMonth) {
		this.maxMonth = maxMonth;
	}
    
}