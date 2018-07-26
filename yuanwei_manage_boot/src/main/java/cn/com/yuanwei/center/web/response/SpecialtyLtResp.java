package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.Specialty;
/**
 * 绵竹造产品表
 * 
 * @author zbk
 * @email 
 * @date 2017-06-14 17:57:07
 */
public class SpecialtyLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<Specialty> specialtyLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<Specialty> getSpecialtyLt() {
		return specialtyLt;
	}
	public void setSpecialtyLt(List<Specialty> specialtyLt) {
		this.specialtyLt = specialtyLt;
	}
}
