package cn.com.yuanwei.center.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import cn.com.yuanwei.center.web.request.base.PageReq;
/**
 * 乡镇信息
 * 
 * @author zbk
 * @email 
 * @date 2017-06-01 15:27:39
 */
@ApiModel
public class TownshipReq extends PageReq {
	private static final long serialVersionUID = 1L;
	//主键ID
	@ApiModelProperty(value = "主键ID",dataType="Integer")
	private Integer id;
	//乡镇名称
	@ApiModelProperty(value = "乡镇名称",dataType="String")
	private String name;
	//分管领导姓名
	@ApiModelProperty(value = "分管领导姓名",dataType="String")
	private String leaderName;
	//联系电话
	@ApiModelProperty(value = "联系电话",dataType="String")
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
