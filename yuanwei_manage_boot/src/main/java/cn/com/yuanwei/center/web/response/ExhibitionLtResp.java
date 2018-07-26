package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.Exhibition;
/**
 * 会展信息
 * 
 * @author zbk
 * @email 
 * @date 2017-07-04 16:11:03
 */
public class ExhibitionLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<Exhibition> exhibitionLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<Exhibition> getExhibitionLt() {
		return exhibitionLt;
	}
	public void setExhibitionLt(List<Exhibition> exhibitionLt) {
		this.exhibitionLt = exhibitionLt;
	}
}
