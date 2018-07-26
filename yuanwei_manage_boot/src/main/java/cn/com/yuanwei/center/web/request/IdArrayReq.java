package cn.com.yuanwei.center.web.request;

import java.io.Serializable;
import java.util.List;

public class IdArrayReq implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Integer> ids;

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	
}
