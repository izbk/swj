package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.Type;
/**
 * 数据类型
 * 
 * @author zbk
 * @email 
 * @date 2017-04-24 10:29:22
 */
public class TypeLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<Type> typeLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<Type> getTypeLt() {
		return typeLt;
	}
	public void setTypeLt(List<Type> typeLt) {
		this.typeLt = typeLt;
	}
}
