package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.Publish;
/**
 * 内容发布
 * 
 * @author zbk
 * @email 
 * @date 2017-05-22 10:54:24
 */
public class PublishLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<Publish> publishLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<Publish> getPublishLt() {
		return publishLt;
	}
	public void setPublishLt(List<Publish> publishLt) {
		this.publishLt = publishLt;
	}
}
