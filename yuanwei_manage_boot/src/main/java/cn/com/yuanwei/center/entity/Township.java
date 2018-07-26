package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import org.jeecgframework.poi.excel.annotation.Excel;


/**
 * 乡镇信息
 * 
 * @author zbk
 * @date 2017-06-01 15:27:39
 */
public class Township implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//乡镇名称
	 @Excel(name = "乡镇名称",isImportField="true")
	private String name;
	//分管领导姓名
	 @Excel(name = "分管领导姓名",isImportField="true")
	private String leaderName;
	//联系电话
	 @Excel(name = "联系电话",isImportField="true")
	private String leaderMobile;

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
	 * 设置：乡镇名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：乡镇名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：分管领导姓名
	 */
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}
	/**
	 * 获取：分管领导姓名
	 */
	public String getLeaderName() {
		return leaderName;
	}
	/**
	 * 设置：联系电话
	 */
	public void setLeaderMobile(String leaderMobile) {
		this.leaderMobile = leaderMobile;
	}
	/**
	 * 获取：联系电话
	 */
	public String getLeaderMobile() {
		return leaderMobile;
	}
}
