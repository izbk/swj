package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.TypeGroup;
import cn.com.yuanwei.center.web.request.TypeGroupReq;
import cn.com.yuanwei.center.web.response.TypeGroupLtResp;
/**
 * 数据类型定义
 * 
 * @author zbk
 * @email 
 * @date 2017-06-26 17:15:27
 */
public interface TypeGroupService {
   /**
	 * Desc:查询数据类型定义
	 * @param Integer id
	 * @return  TypeGroup
	 * @author zbk
	 * @date 2017-06-26 17:15:27
	 */
	public TypeGroup queryById(Integer id) throws Exception;
   /**
	 * Desc:查询数据类型定义列表
	 * @param TypeGroupReq req
	 * @return TypeGroupLtResp
	 * @author zbk
	 * @date 2017-06-26 17:15:27
	 */
	public TypeGroupLtResp queryList(TypeGroupReq req) throws Exception;
   /**
	 * Desc:新增数据类型定义
	 * @param TypeGroup typeGroup
	 * @return Integer id
	 * @author zbk
	 * @date 2017-06-26 17:15:27
	 */
	public Integer save(TypeGroup typeGroup) throws Exception;
	/**
	 * Desc:更新数据类型定义
	 * @param TypeGroup typeGroup
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-26 17:15:27
	 */
	public Integer update(TypeGroup typeGroup) throws Exception;
	/**
	 * Desc:删除数据类型定义
	 * @param List<Integer> req
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-26 17:15:27
	 */
	public Integer delete(List<Integer> req) throws Exception;
}
