package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.ExhibitionRecord;
/**
 * 会展备案信息
 * 
 * @author zbk
 * @email 
 * @date 2017-07-03 11:39:30
 */
public class ExhibitionRecordLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<ExhibitionRecord> exhibitionRecordLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<ExhibitionRecord> getExhibitionRecordLt() {
		return exhibitionRecordLt;
	}
	public void setExhibitionRecordLt(List<ExhibitionRecord> exhibitionRecordLt) {
		this.exhibitionRecordLt = exhibitionRecordLt;
	}
}
