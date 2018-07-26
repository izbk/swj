package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import org.jeecgframework.poi.excel.annotation.Excel;
import java.util.Date;


/**
 * 待办事项
 * 
 * @author zbk
 * @date 2017-06-07 12:24:18
 */
public class ToDoList implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//处理人
	 @Excel(name = "处理人",isImportField="true")
	private Integer userId;
	//审核配置ID
	 @Excel(name = "审核配置ID",isImportField="true")
	private Integer auditConfigId;
	//业务名称
	 @Excel(name = "业务名称",isImportField="true")
	private String busiName;
	//业务ID
	 @Excel(name = "业务ID",isImportField="true")
	private Integer busiId;
	//业务类型
	 @Excel(name = "业务类型",replace={"文章_0","项目_1","绵竹造_2","投诉建议_3","企业备案_4"},isImportField="true")
	private Integer busiType;
	//子业务类型
	 @Excel(name = "子业务类型",isImportField="true")
	private Integer subBusiType;
	//创建时间
    @Excel(name = "创建时间",format="yyyy-MM-dd",isImportField="true")
	private Date createTime;
	//是否处理
	 @Excel(name = "是否处理",replace={"否_0","是_1"},isImportField="true")
	private Integer isDeal;
	//处理时间
     @Excel(name = "处理时间",format="yyyy-MM-dd",isImportField="true")
	private Date dealTime;

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
	 * 设置：处理人
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：处理人
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置：审核配置ID
	 */
	public void setAuditConfigId(Integer auditConfigId) {
		this.auditConfigId = auditConfigId;
	}
	/**
	 * 获取：审核配置ID
	 */
	public Integer getAuditConfigId() {
		return auditConfigId;
	}
	/**
	 * 设置：业务名称
	 */
	public void setBusiName(String busiName) {
		this.busiName = busiName;
	}
	/**
	 * 获取：业务名称
	 */
	public String getBusiName() {
		return busiName;
	}
	/**
	 * 设置：业务ID
	 */
	public void setBusiId(Integer busiId) {
		this.busiId = busiId;
	}
	/**
	 * 获取：业务ID
	 */
	public Integer getBusiId() {
		return busiId;
	}
	/**
	 * 设置：业务类型
	 */
	public void setBusiType(Integer busiType) {
		this.busiType = busiType;
	}
	/**
	 * 获取：业务类型
	 */
	public Integer getBusiType() {
		return busiType;
	}
	/**
	 * 设置：子业务类型
	 */
	public void setSubBusiType(Integer subBusiType) {
		this.subBusiType = subBusiType;
	}
	/**
	 * 获取：子业务类型
	 */
	public Integer getSubBusiType() {
		return subBusiType;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 设置：是否处理
	 */
	public void setIsDeal(Integer isDeal) {
		this.isDeal = isDeal;
	}
	/**
	 * 获取：是否处理
	 */
	public Integer getIsDeal() {
		return isDeal;
	}
	/**
	 * 设置：处理时间
	 */
	public void setDealTime(Date dealTime) {
		this.dealTime = dealTime;
	}
	/**
	 * 获取：处理时间
	 */
	public Date getDealTime() {
		return dealTime;
	}
}
