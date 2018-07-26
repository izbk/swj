package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.Type;
import cn.com.yuanwei.center.web.request.CommonTypeReq;
import cn.com.yuanwei.center.web.request.TypeReq;
import cn.com.yuanwei.center.web.response.CommonTypeLtResp;
import cn.com.yuanwei.center.web.response.TypeLtResp;
/**
 * 数据类型
 * 
 * @author zbk
 * @email 
 * @date 2017-04-24 10:29:22
 */
public interface TypeService {
   /**
	 * Desc:查询数据类型
	 * @author zbk
	 * @date 2017-04-24 10:29:22
	 */
	public Type queryById(Integer id) throws Exception;
   /**
	 * Desc:查询数据类型列表
	 * @author zbk
	 * @date 2017-04-24 10:29:22
	 */
	public TypeLtResp queryList(TypeReq req) throws Exception;
	
   /**
	 * Desc:通用查询数据类型列表
	 * @author zbk
	 * @date 2017-04-24 10:29:22
	 */
	public CommonTypeLtResp queryCommonTypeList(CommonTypeReq req) throws Exception;
   /**
	 * Desc:新增数据类型
	 * @author zbk
	 * @date 2017-04-24 10:29:22
	 */
	public Integer save(Type type) throws Exception;
	/**
	 * Desc:更新数据类型
	 * @author zbk
	 * @date 2017-04-24 10:29:22
	 */
	public Integer update(Type type) throws Exception;
	/**
	 * Desc:删除数据类型
	 * @author zbk
	 * @date 2017-04-24 10:29:22
	 */
	public Integer delete(List<Integer> req) throws Exception;
	/**
	 * Desc:获取类型名称
	 * @author zbk
	 * @date 2017-04-24 10:29:22
	 */
	public String getTypeName(String groupCode,String typeCode);
}
