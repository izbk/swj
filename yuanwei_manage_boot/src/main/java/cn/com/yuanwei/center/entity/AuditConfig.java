package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import org.jeecgframework.poi.excel.annotation.Excel;


/**
 * 审核配置
 * 
 * @author zbk
 * @date 2017-05-16 11:11:22
 */
public class AuditConfig implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//部门
	 @Excel(name = "部门",replace={"内贸部_4","外贸部_5","监察部_6"},isImportField="true")
	private Integer departId;
	//一级审核人
	 @Excel(name = "一级审核人",isImportField="true")
	private Integer userId1;
	//二级审核人
	 @Excel(name = "二级审核人",isImportField="true")
	private Integer userId2;
	//三级审核人
	 @Excel(name = "三级审核人",isImportField="true")
	private Integer userId3;
	//业务类型(0:文章 1:项目 2:绵竹造 3:投诉建议)
	 @Excel(name = "业务类型",replace={"文章_0","项目_1","绵竹造_2","投诉建议_3","企业备案_4"},isImportField="true")
	private Integer busiType;
	//子业务类型
	 @Excel(name = "子业务类型",isImportField="true")
	private Integer subBusiType;

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
	 * 设置：部门
	 */
	public void setDepartId(Integer departId) {
		this.departId = departId;
	}
	/**
	 * 获取：部门
	 */
	public Integer getDepartId() {
		return departId;
	}
	/**
	 * 设置：一级审核人
	 */
	public void setUserId1(Integer userId1) {
		this.userId1 = userId1;
	}
	/**
	 * 获取：一级审核人
	 */
	public Integer getUserId1() {
		return userId1;
	}
	/**
	 * 设置：二级审核人
	 */
	public void setUserId2(Integer userId2) {
		this.userId2 = userId2;
	}
	/**
	 * 获取：二级审核人
	 */
	public Integer getUserId2() {
		return userId2;
	}
	/**
	 * 设置：三级审核人
	 */
	public void setUserId3(Integer userId3) {
		this.userId3 = userId3;
	}
	/**
	 * 获取：三级审核人
	 */
	public Integer getUserId3() {
		return userId3;
	}
	/**
	 * 设置：业务类型(0:文章 1:项目 2:绵竹造 3:投诉建议)
	 */
	public void setBusiType(Integer busiType) {
		this.busiType = busiType;
	}
	/**
	 * 获取：业务类型(0:文章 1:项目 2:绵竹造 3:投诉建议)
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
}
