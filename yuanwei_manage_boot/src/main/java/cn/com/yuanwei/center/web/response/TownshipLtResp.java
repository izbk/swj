package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.Township;
/**
 * 乡镇信息
 * 
 * @author zbk
 * @email 
 * @date 2017-06-01 15:27:39
 */
public class TownshipLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<Township> townshipLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<Township> getTownshipLt() {
		return townshipLt;
	}
	public void setTownshipLt(List<Township> townshipLt) {
		this.townshipLt = townshipLt;
	}
}
