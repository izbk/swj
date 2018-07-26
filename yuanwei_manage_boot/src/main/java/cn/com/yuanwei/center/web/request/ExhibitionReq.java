package cn.com.yuanwei.center.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

import cn.com.yuanwei.center.web.request.base.PageReq;
/**
 * 会展信息
 * 
 * @author zbk
 * @email 
 * @date 2017-07-04 16:11:03
 */
@ApiModel
public class ExhibitionReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//主键ID
	@ApiModelProperty(value = "主键ID",dataType="Integer")
	private Integer id;
	//会展名称
	@ApiModelProperty(value = "会展名称",dataType="String")
	private String exhibitionName;
	//会展地点
	@ApiModelProperty(value = "会展地点",dataType="String")
	private String address;
	//开始时间
	@ApiModelProperty(value = "开始时间",dataType="Date")
	private Date startDate;
	//结束时间
	@ApiModelProperty(value = "结束时间",dataType="Date")
	private Date endDate;
	//会展类别
	@ApiModelProperty(value = "会展类别",dataType="Integer")
	private Integer exhibitionType;
	//会展介绍
	@ApiModelProperty(value = "会展介绍",dataType="String")
	private String introduction;
	//是否有效
	@ApiModelProperty(value = "是否有效",dataType="Integer")
	private Integer isValid;
	//创建人
	@ApiModelProperty(value = "创建人",dataType="Integer")
	private Integer createBy;
	//创建时间
	@ApiModelProperty(value = "创建时间",dataType="Date")
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
	 * 设置：会展名称
	 */
	public void setExhibitionName(String exhibitionName) {
		this.exhibitionName = exhibitionName;
	}
	/**
	 * 获取：会展名称
	 */
	public String getExhibitionName() {
		return exhibitionName;
	}
	/**
	 * 设置：会展地点
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：会展地点
	 */
	public String getAddress() {
		return address;
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
	 * 设置：会展类别
	 */
	public void setExhibitionType(Integer exhibitionType) {
		this.exhibitionType = exhibitionType;
	}
	/**
	 * 获取：会展类别
	 */
	public Integer getExhibitionType() {
		return exhibitionType;
	}
	/**
	 * 设置：会展介绍
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	/**
	 * 获取：会展介绍
	 */
	public String getIntroduction() {
		return introduction;
	}
	/**
	 * 设置：是否有效
	 */
	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}
	/**
	 * 获取：是否有效
	 */
	public Integer getIsValid() {
		return isValid;
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
