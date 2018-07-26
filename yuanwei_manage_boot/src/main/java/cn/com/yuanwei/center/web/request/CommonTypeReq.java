package cn.com.yuanwei.center.web.request;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 通用数据字典
 * 
 * @author zbk
 * @email 
 * @date 2017-04-24 10:29:22
 */
@ApiModel
public class CommonTypeReq implements Serializable {
	private static final long serialVersionUID = 1L;
	//表名称
	@ApiModelProperty(value = "表名",dataType="String")
	private String tableName;
	//名称
	@ApiModelProperty(value = "名称",dataType="String")
	private String label;
	//代码
	@ApiModelProperty(value = "代码",dataType="String")
	private String value;
	//类型组ID
	@ApiModelProperty(value = "组名",dataType="String")
	private String groupName;
	@ApiModelProperty(value = "过滤条件")
	private String dataList;
	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getDataList() {
		return dataList;
	}
	public void setDataList(String dataList) {
		this.dataList = dataList;
	}
}
