package cn.com.yuanwei.center.web.request;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 年度任务考核
 * 
 * @author zbk
 * @email 
 * @date 2017-04-24 10:28:06
 */
@ApiModel
public class CalcTownshipAnnualDoneReq implements Serializable {
	private static final long serialVersionUID = 1L;
	//乡镇ID
	@ApiModelProperty(value = "乡镇ID",dataType="Integer")
	private Integer townshipId;
	//年度
	@ApiModelProperty(value = "年度",dataType="Integer")
	private Integer year;
	
	public Integer getTownshipId() {
		return townshipId;
	}
	public void setTownshipId(Integer townshipId) {
		this.townshipId = townshipId;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	
}
