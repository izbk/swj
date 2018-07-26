package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import org.jeecgframework.poi.excel.annotation.Excel;
import java.util.Date;

/**
 * 会展信息
 * 
 * @author zbk
 * @date 2017-07-04 16:11:03
 */
public class Exhibition implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//会展名称
	@Excel(name = "会展名称",isImportField="true")
	private String exhibitionName;
	//会展地点
	@Excel(name = "会展地点")
	private String address;
	//开始时间
	@Excel(name = "开始时间",format="yyyy-MM-dd")
	private Date startDate;
	//结束时间
	@Excel(name = "结束时间",format="yyyy-MM-dd")
	private Date endDate;
	//会展类别
	@Excel(name = "会展类别",replace={"万企出国门_0","川货全国行_1","惠民购物全川行_2"})
	private Integer exhibitionType;
	//会展介绍
	@Excel(name = "会展介绍")
	private String introduction;
	//是否有效
	@Excel(name = "是否有效",replace={"否_0","是_1"})
	private Integer isValid;
	//创建人
	private Integer createBy;
	//创建时间
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

	public Exhibition() {
		super();
	}

	public Exhibition(
		Integer id,
		String exhibitionName,
		String address,
		Date startDate,
		Date endDate,
		Integer exhibitionType,
		String introduction,
		Integer isValid,
		Integer createBy,
		Date createTime) {
		super();
		this.id = id;
		this.exhibitionName = exhibitionName;
		this.address = address;
		this.startDate = startDate;
		this.endDate = endDate;
		this.exhibitionType = exhibitionType;
		this.introduction = introduction;
		this.isValid = isValid;
		this.createBy = createBy;
		this.createTime = createTime;
	}

	@Override
    public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"id\":").append("\"").append(id).append("\"").append(",");
		sb.append("\"exhibitionName\":").append("\"").append(exhibitionName).append("\"").append(",");
		sb.append("\"address\":").append("\"").append(address).append("\"").append(",");
		sb.append("\"startDate\":").append("\"").append(startDate).append("\"").append(",");
		sb.append("\"endDate\":").append("\"").append(endDate).append("\"").append(",");
		sb.append("\"exhibitionType\":").append("\"").append(exhibitionType).append("\"").append(",");
		sb.append("\"introduction\":").append("\"").append(introduction).append("\"").append(",");
		sb.append("\"isValid\":").append("\"").append(isValid).append("\"").append(",");
		sb.append("\"createBy\":").append("\"").append(createBy).append("\"").append(",");
		sb.append("\"createTime\":").append("\"").append(createTime).append("\"").append("}");
        return sb.toString();
    }
}
