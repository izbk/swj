package cn.com.yuanwei.center.web.request.base;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class IdReq implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@Min(value=1, message="id必须为整数并且大于0")
	@Max(value=99999999, message="id不能大于99999999")
	protected Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
