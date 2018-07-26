package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.TypeGroup;
/**
 * 数据类型定义
 * 
 * @author zbk
 * @email 
 * @date 2017-04-24 10:29:23
 */
public class TypeGroupLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<TypeGroup> typeGroupLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<TypeGroup> getTypeGroupLt() {
		return typeGroupLt;
	}
	public void setTypeGroupLt(List<TypeGroup> typeGroupLt) {
		this.typeGroupLt = typeGroupLt;
	}
}
