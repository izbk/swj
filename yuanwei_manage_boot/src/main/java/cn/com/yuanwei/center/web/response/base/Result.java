
package cn.com.yuanwei.center.web.response.base;

import java.io.Serializable;

import cn.com.yuanwei.center.enums.ReturnInfoEnum;

/** 返回实体 */
public class Result  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 返回值 */
	private java.lang.String code;
	/** 返回描述 */
	private java.lang.String message;
	/** 数据 */
	private Object data;
	
	private Long count;

	public java.lang.String getCode() {
		return code;
	}

	public void setCode(java.lang.String code) {
		this.code = code;
	}

	public java.lang.String getMessage() {
		return message;
	}

	public void setMessage(java.lang.String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	/**
	 * @param code
	 * @param message
	 * @param data
	 */
	public Result(String code, String message, Object data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public Result() {
		this.setCode(ReturnInfoEnum.Success.getCode());
		this.setMessage(ReturnInfoEnum.Success.getDesc());
	}
	
	public Result(Object data) {
		this.setCode(ReturnInfoEnum.Success.getCode());
		this.setMessage(ReturnInfoEnum.Success.getDesc());
		this.setData(data);
	}
}