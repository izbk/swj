package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import org.jeecgframework.poi.excel.annotation.Excel;
import java.util.Date;


/**
 * 订阅消息
 * 
 * @author zbk
 * @date 2017-06-05 11:09:42
 */
public class WeixinSubscribe implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//欢迎语
	 @Excel(name = "欢迎语",isImportField="true")
	private String welcome;
	//创建时间
     @Excel(name = "创建时间",format="yyyy-MM-dd",isImportField="true")
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
	 * 设置：欢迎语
	 */
	public void setWelcome(String welcome) {
		this.welcome = welcome;
	}
	/**
	 * 获取：欢迎语
	 */
	public String getWelcome() {
		return welcome;
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
