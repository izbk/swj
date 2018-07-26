package cn.com.yuanwei.center.entity;

import java.io.Serializable;

import org.jeecgframework.poi.excel.annotation.Excel;

/**
 * 服务业企业数据定义
 * 
 * @author zbk
 * @date 2017-07-14 14:35:31
 */

public class ServiceDefine implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//数据来源
	@Excel(name = "数据来源",replace={"直报_0","省报_1","直报+省报_2","德阳市_3","直报+德阳分配_4"},isImportField="true")
	private Integer dataSource;
	//核算行业
	@Excel(name = "核算行业",replace={"非营利性服务业_0","营利性服务业_1","金融业_2","房地产业_3","批发零售业_4","住宿餐饮业_5","农业_6","交通运输业_7"},isImportField="true")
	private Integer calculationIndustry;
	//部门ID
//	@Excel(name = "部门ID",isImportField="true")
	private Integer departId;
	//部门名称
	@Excel(name = "部门名称",isImportField="true")
	private String departName;
	//指标名称
	@Excel(name = "指标名称",isImportField="true")
	private String indexName;

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
	 * 设置：数据来源
	 */
	public void setDataSource(Integer dataSource) {
		this.dataSource = dataSource;
	}
	/**
	 * 获取：数据来源
	 */
	public Integer getDataSource() {
		return dataSource;
	}
	/**
	 * 设置：核算行业
	 */
	public void setCalculationIndustry(Integer calculationIndustry) {
		this.calculationIndustry = calculationIndustry;
	}
	/**
	 * 获取：核算行业
	 */
	public Integer getCalculationIndustry() {
		return calculationIndustry;
	}
	/**
	 * 设置：部门ID
	 */
	public void setDepartId(Integer departId) {
		this.departId = departId;
	}
	/**
	 * 获取：部门ID
	 */
	public Integer getDepartId() {
		return departId;
	}
	/**
	 * 设置：部门名称
	 */
	public void setDepartName(String departName) {
		this.departName = departName;
	}
	/**
	 * 获取：部门名称
	 */
	public String getDepartName() {
		return departName;
	}
	/**
	 * 设置：指标名称
	 */
	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}
	/**
	 * 获取：指标名称
	 */
	public String getIndexName() {
		return indexName;
	}

	public ServiceDefine() {
		super();
	}

	public ServiceDefine(
		Integer id,
		Integer dataSource,
		Integer calculationIndustry,
		Integer departId,
		String departName,
		String indexName) {
		super();
		this.id = id;
		this.dataSource = dataSource;
		this.calculationIndustry = calculationIndustry;
		this.departId = departId;
		this.departName = departName;
		this.indexName = indexName;
	}

	@Override
    public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"id\":").append("\"").append(id).append("\"").append(",");
		sb.append("\"dataSource\":").append("\"").append(dataSource).append("\"").append(",");
		sb.append("\"calculationIndustry\":").append("\"").append(calculationIndustry).append("\"").append(",");
		sb.append("\"departId\":").append("\"").append(departId).append("\"").append(",");
		sb.append("\"departName\":").append("\"").append(departName).append("\"").append(",");
		sb.append("\"indexName\":").append("\"").append(indexName).append("\"").append("}");
        return sb.toString();
    }
}
