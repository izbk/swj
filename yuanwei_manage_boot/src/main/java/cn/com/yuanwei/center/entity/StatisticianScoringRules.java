package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import org.jeecgframework.poi.excel.annotation.Excel;
import java.util.Date;


/**
 * 统计员计分细则
 * 
 * @author zbk
 * @date 2017-06-15 15:17:36
 */
public class StatisticianScoringRules implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//规则
	 @Excel(name = "规则",isImportField="true")
	private String rule;
	//得分
	 @Excel(name = "得分",isImportField="true")
	private Integer point;
	//得分类型
	 @Excel(name = "得分类型",isImportField="true")
	private Integer pointType;
	//创建人
	 @Excel(name = "创建人",isImportField="true")
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
