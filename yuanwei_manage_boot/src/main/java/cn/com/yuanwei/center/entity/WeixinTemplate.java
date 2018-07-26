package cn.com.yuanwei.center.entity;

import java.io.Serializable;
import org.jeecgframework.poi.excel.annotation.Excel;


/**
 * 微信模板消息
 * 
 * @author zbk
 * @date 2017-06-05 16:18:41
 */
public class WeixinTemplate implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//通知类型
	 @Excel(name = "通知类型",replace={"限上企业通知_0","服务业企业通知_1","企业政策通知_2"},isImportField="true")
	private Integer noticeType;
	//通知内容
	 @Excel(name = "通知内容",isImportField="true")
	private String content;
	//备注
	 @Excel(name = "备注",isImportField="true")
	private String remark;

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
	 * 设置：通知类型
	 */
	public void setNoticeType(Integer noticeType) {
		this.noticeType = noticeType;
	}
	/**
	 * 获取：通知类型
	 */
	public Integer getNoticeType() {
		return noticeType;
	}
	/**
	 * 设置：通知内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：通知内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
}
