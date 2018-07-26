package cn.com.yuanwei.center.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

import cn.com.yuanwei.center.web.request.base.PageReq;
/**
 * 企业进退库管理表
 * 
 * @author zbk
 * @email 
 * @date 2017-06-16 14:55:57
 */
@ApiModel
public class EnterpriseManageReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//主键ID
	@ApiModelProperty(value = "主键ID",dataType="Integer")
	private Integer id;
	//企业编号
	@ApiModelProperty(value = "企业编号",dataType="String")
	private String enterpriseCode;
	//企业名称
	@ApiModelProperty(value = "企业名称",dataType="String")
	private String enterpriseName;
	//入库时间
	@ApiModelProperty(value = "入库时间",dataType="Date")
	private Date inDate;
	//出库事件
	@ApiModelProperty(value = "出库时间",dataType="Date")
	private Date outDate;
	//入库方式(0:年审入库)
	@ApiModelProperty(value = "入库方式(0:年审入库)",dataType="Integer")
	private Integer inWay;
	//出库方式（0: 正常出库 1:破产吊销）
	@ApiModelProperty(value = "出库方式（0: 正常出库 1:破产吊销）",dataType="Integer")
	private Integer outWay;
	//备注
	@ApiModelProperty(value = "备注",dataType="String")
	private String remark;
	//创建人
	@ApiModelProperty(value = "创建人",dataType="Integer")
	private Integer createBy;
	//创建时间
	@ApiModelProperty(value = "创建时间",dataType="Date")
	private Date createTime;
	
	//开始入库时间
	private Date startInDate;
	//结束入库时间
	private Date endInDate;
	//开始出库时间
	private Date startOutDate;
	//结束出库时间
	private Date endOutDate;

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
	 * 设置：企业编号
	 */
	public void setEnterpriseCode(String enterpriseCode) {
		this.enterpriseCode = enterpriseCode;
	}
	/**
	 * 获取：企业编号
	 */
	public String getEnterpriseCode() {
		return enterpriseCode;
	}
	/**
	 * 设置：企业名称
	 */
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	/**
	 * 获取：企业名称
	 */
	public String getEnterpriseName() {
		return enterpriseName;
	}
	/**
	 * 设置：入库时间
	 */
	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}
	/**
	 * 获取：入库时间
	 */
	public Date getInDate() {
		return inDate;
	}
	/**
	 * 设置：出库事件
	 */
	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}
	/**
	 * 获取：出库事件
	 */
	public Date getOutDate() {
		return outDate;
	}
	/**
	 * 设置：入库方式(0:年审入库)
	 */
	public void setInWay(Integer inWay) {
		this.inWay = inWay;
	}
	/**
	 * 获取：入库方式(0:年审入库)
	 */
	public Integer getInWay() {
		return inWay;
	}
	/**
	 * 设置：出库方式（0: 正常出库 1:破产吊销）
	 */
	public void setOutWay(Integer outWay) {
		this.outWay = outWay;
	}
	/**
	 * 获取：出库方式（0: 正常出库 1:破产吊销）
	 */
	public Integer getOutWay() {
		return outWay;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
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
	public Date getStartInDate() {
		return startInDate;
	}
	public void setStartInDate(Date startInDate) {
		this.startInDate = startInDate;
	}
	public Date getEndInDate() {
		return endInDate;
	}
	public void setEndInDate(Date endInDate) {
		this.endInDate = endInDate;
	}
	public Date getStartOutDate() {
		return startOutDate;
	}
	public void setStartOutDate(Date startOutDate) {
		this.startOutDate = startOutDate;
	}
	public Date getEndOutDate() {
		return endOutDate;
	}
	public void setEndOutDate(Date endOutDate) {
		this.endOutDate = endOutDate;
	}
	
}
