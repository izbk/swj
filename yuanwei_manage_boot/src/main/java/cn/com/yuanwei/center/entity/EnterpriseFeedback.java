package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import org.jeecgframework.poi.excel.annotation.Excel;
import java.util.Date;

/**
 * 样本企业反馈信息
 * 
 * @author zbk
 * @date 2017-08-22 09:19:28
 */
public class EnterpriseFeedback implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	@Excel(name = "编号",isImportField="true")
	private Integer id;
	//样本企业ID
//	@Excel(name = "样本企业ID",isImportField="true")
	private Integer userId;
	//样板企业名称
	@Excel(name = "样板企业名称",isImportField="true")
	private String userName;
	//样本企业类型
	@Excel(name = "样本企业类型",replace={"生活必需品监测_0","生产资料监测_1"},isImportField="true")
	private Integer modelType;
	//上报内容
	@Excel(name = "上报内容",isImportField="true")
	private String content;
	//创建人
	private Integer createBy;
	//创建时间
	@Excel(name = "上报时间",format="yyyy-MM-dd",isImportField="true")
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
	 * 设置：样本企业ID
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：样本企业ID
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置：样板企业名称
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：样板企业名称
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：样本企业类型
	 */
	public void setModelType(Integer modelType) {
		this.modelType = modelType;
	}
	/**
	 * 获取：样本企业类型
	 */
	public Integer getModelType() {
		return modelType;
	}
	/**
	 * 设置：上报内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：上报内容
	 */
	public String getContent() {
		return content;
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

	public EnterpriseFeedback() {
		super();
	}

	public EnterpriseFeedback(
		Integer id,
		Integer userId,
		String userName,
		Integer modelType,
		String content,
		Integer createBy,
		Date createTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.modelType = modelType;
		this.content = content;
		this.createBy = createBy;
		this.createTime = createTime;
	}

	@Override
    public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"id\":").append("\"").append(id).append("\"").append(",");
		sb.append("\"userId\":").append("\"").append(userId).append("\"").append(",");
		sb.append("\"userName\":").append("\"").append(userName).append("\"").append(",");
		sb.append("\"modelType\":").append("\"").append(modelType).append("\"").append(",");
		sb.append("\"content\":").append("\"").append(content).append("\"").append(",");
		sb.append("\"createBy\":").append("\"").append(createBy).append("\"").append(",");
		sb.append("\"createTime\":").append("\"").append(createTime).append("\"").append("}");
        return sb.toString();
    }
}
