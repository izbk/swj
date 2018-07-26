package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.jeecgframework.poi.excel.annotation.Excel;

/**
 * 限上企业信息表
 * 
 * @author zbk
 * @date 2017-07-17 17:56:52
 */
public class Enterprise implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//企业代码
	@Excel(name = "企业代码",isImportField="true")
	private String enterpriseCode;
	//企业名称
	@Excel(name = "企业名称",isImportField="true")
	private String enterpriseName;
	//乡镇ID
	@Excel(name = "乡镇ID",replace={"东北镇_1","西南镇_2","兴隆镇_3","九龙镇_4","遵道镇_5","汉旺镇_6","拱星镇_7","土门镇_8","广济镇_9","金花镇_10","玉泉镇_11","板桥镇_12","新市镇_13","孝德镇_14","富新镇_15","齐天镇_16","什地镇_17","绵远镇_18","清平镇_19","天池乡_20","剑南镇_21"})
	private Integer townshipId;
	//企业类型（0:法人 1:个体）
	@Excel(name = "企业类型（0:法人 1:个体）",replace={"法人_0","个体_1","工商未注册_2"})
	private Integer enterpriseType;
	//业态（0:批发 1:零售 2:餐饮 3:住宿 ）
	@Excel(name = "业态（0:批发 1:零售 2:餐饮 3:住宿 ）",replace={"批发_0","零售_1","餐饮_2","住宿_3"})
	private Integer industry;
	//企业负责人
	@Excel(name = "企业负责人")
	private String chargeName;
	//负责人电话
	@Excel(name = "负责人电话")
	private String chargeMobile;
	//统计员ID
	@Excel(name = "统计员ID",replace={"狗蛋_2"})
	private Integer userId;
	//统计员姓名
	@Excel(name = "统计员姓名")
	private String userName;
	//入库时间
	@Excel(name = "入库时间",format="yyyy-MM-dd")
	private Date inDate;
	//出库时间
	@Excel(name = "出库时间",format="yyyy-MM-dd")
	private Date outDate;
	//入库类型（0:已入库 1:新增入库 2:未入库 3:已出库 4:破产吊销出库）
	@Excel(name = "入库类型（0:已入库 1:新增入库 2:未入库 3:已出库 4:破产吊销出库）",replace={"已入库_0","新增入库_1","未入库_2","已出库_3","破产吊销出库_4"})
	private Integer inType;
	//是否代报
	@Excel(name = "是否代报",replace={"否_0","是_1"})
	private Integer agent;
	@Excel(name = "新增企业同期门槛数（千元）")
	private BigDecimal threshold;
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
	 * 设置：企业代码
	 */
	public void setEnterpriseCode(String enterpriseCode) {
		this.enterpriseCode = enterpriseCode;
	}
	/**
	 * 获取：企业代码
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
	 * 设置：企业类型（0:法人 1:个体）
	 */
	public void setEnterpriseType(Integer enterpriseType) {
		this.enterpriseType = enterpriseType;
	}
	/**
	 * 获取：企业类型（0:法人 1:个体）
	 */
	public Integer getEnterpriseType() {
		return enterpriseType;
	}
	/**
	 * 设置：业态（0:批发 1:零售 2:餐饮 3:住宿 ）
	 */
	public void setIndustry(Integer industry) {
		this.industry = industry;
	}
	/**
	 * 获取：业态（0:批发 1:零售 2:餐饮 3:住宿 ）
	 */
	public Integer getIndustry() {
		return industry;
	}
	/**
	 * 设置：企业负责人
	 */
	public void setChargeName(String chargeName) {
		this.chargeName = chargeName;
	}
	/**
	 * 获取：企业负责人
	 */
	public String getChargeName() {
		return chargeName;
	}
	/**
	 * 设置：负责人电话
	 */
	public void setChargeMobile(String chargeMobile) {
		this.chargeMobile = chargeMobile;
	}
	/**
	 * 获取：负责人电话
	 */
	public String getChargeMobile() {
		return chargeMobile;
	}
	/**
	 * 设置：统计员ID
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：统计员ID
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置：统计员姓名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：统计员姓名
	 */
	public String getUserName() {
		return userName;
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
	 * 设置：出库时间
	 */
	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}
	/**
	 * 获取：出库时间
	 */
	public Date getOutDate() {
		return outDate;
	}
	/**
	 * 设置：入库类型（0:已入库 1:新增入库 2:未入库 3:已出库 4:破产吊销出库）
	 */
	public void setInType(Integer inType) {
		this.inType = inType;
	}
	/**
	 * 获取：入库类型（0:已入库 1:新增入库 2:未入库 3:已出库 4:破产吊销出库）
	 */
	public Integer getInType() {
		return inType;
	}
	/**
	 * 设置：是否代报
	 */
	public void setAgent(Integer agent) {
		this.agent = agent;
	}
	/**
	 * 获取：是否代报
	 */
	public Integer getAgent() {
		return agent;
	}
	public BigDecimal getThreshold() {
		return threshold;
	}
	public void setThreshold(BigDecimal threshold) {
		this.threshold = threshold;
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

	public Enterprise() {
		super();
	}

	public Enterprise(
		Integer id,
		String enterpriseCode,
		String enterpriseName,
		Integer townshipId,
		Integer enterpriseType,
		Integer industry,
		String chargeName,
		String chargeMobile,
		Integer userId,
		String userName,
		Date inDate,
		Date outDate,
		Integer inType,
		Integer agent,
		Integer createBy,
		Date createTime) {
		super();
		this.id = id;
		this.enterpriseCode = enterpriseCode;
		this.enterpriseName = enterpriseName;
		this.townshipId = townshipId;
		this.enterpriseType = enterpriseType;
		this.industry = industry;
		this.chargeName = chargeName;
		this.chargeMobile = chargeMobile;
		this.userId = userId;
		this.userName = userName;
		this.inDate = inDate;
		this.outDate = outDate;
		this.inType = inType;
		this.agent = agent;
		this.createBy = createBy;
		this.createTime = createTime;
	}

	@Override
    public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"id\":").append("\"").append(id).append("\"").append(",");
		sb.append("\"enterpriseCode\":").append("\"").append(enterpriseCode).append("\"").append(",");
		sb.append("\"enterpriseName\":").append("\"").append(enterpriseName).append("\"").append(",");
		sb.append("\"townshipId\":").append("\"").append(townshipId).append("\"").append(",");
		sb.append("\"enterpriseType\":").append("\"").append(enterpriseType).append("\"").append(",");
		sb.append("\"industry\":").append("\"").append(industry).append("\"").append(",");
		sb.append("\"chargeName\":").append("\"").append(chargeName).append("\"").append(",");
		sb.append("\"chargeMobile\":").append("\"").append(chargeMobile).append("\"").append(",");
		sb.append("\"userId\":").append("\"").append(userId).append("\"").append(",");
		sb.append("\"userName\":").append("\"").append(userName).append("\"").append(",");
		sb.append("\"inDate\":").append("\"").append(inDate).append("\"").append(",");
		sb.append("\"outDate\":").append("\"").append(outDate).append("\"").append(",");
		sb.append("\"inType\":").append("\"").append(inType).append("\"").append(",");
		sb.append("\"agent\":").append("\"").append(agent).append("\"").append(",");
		sb.append("\"createBy\":").append("\"").append(createBy).append("\"").append(",");
		sb.append("\"createTime\":").append("\"").append(createTime).append("\"").append("}");
        return sb.toString();
    }
}
