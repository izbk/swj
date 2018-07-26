package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.ExhibitionRegister;
/**
 * 会展报名信息
 * 
 * @author zbk
 * @email 
 * @date 2017-07-04 14:34:16
 */
public class ExhibitionRegisterLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<ExhibitionRegister> exhibitionRegisterLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<ExhibitionRegister> getExhibitionRegisterLt() {
		return exhibitionRegisterLt;
	}
	public void setExhibitionRegisterLt(List<ExhibitionRegister> exhibitionRegisterLt) {
		this.exhibitionRegisterLt = exhibitionRegisterLt;
	}
}
