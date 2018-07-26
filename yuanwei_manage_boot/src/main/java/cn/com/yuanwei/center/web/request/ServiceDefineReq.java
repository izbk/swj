package cn.com.yuanwei.center.web.request;

import cn.com.yuanwei.center.web.request.base.PageReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 服务业企业数据定义
 * 
 * @author zbk
 * @email 
 * @date 2017-04-24 10:29:44
 */
@ApiModel
public class ServiceDefineReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//主键ID
	@ApiModelProperty(value = "主键ID",dataType="Integer")
	private Integer id;
	//数据来源
	@ApiModelProperty(value = "数据来源",dataType="Integer")
	private Integer dataSource;
	//核算行业
	@ApiModelProperty(value = "核算行业",dataType="Integer")
	private Integer calculationIndustry;
	//部门ID
	@ApiModelProperty(value = "部门ID",dataType="Integer")
	private Integer departId;
	//部门名称
	@ApiModelProperty(value = "部门名称",dataType="String")
	private String departName;
	//指标名称
	@ApiModelProperty(value = "指标名称",dataType="String")
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
}
