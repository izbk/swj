package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.Township;
import cn.com.yuanwei.center.web.request.TownshipReq;
import cn.com.yuanwei.center.web.response.TownshipLtResp;
/**
 * 乡镇信息
 * 
 * @author zbk
 * @email 
 * @date 2017-06-26 17:15:27
 */
public interface TownshipService {
   /**
	 * Desc:查询乡镇信息
	 * @param Integer id
	 * @return  Township
	 * @author zbk
	 * @date 2017-06-26 17:15:27
	 */
	public Township queryById(Integer id) throws Exception;
   /**
	 * Desc:查询乡镇信息列表
	 * @param TownshipReq req
	 * @return TownshipLtResp
	 * @author zbk
	 * @date 2017-06-26 17:15:27
	 */
	public TownshipLtResp queryList(TownshipReq req) throws Exception;
   /**
	 * Desc:新增乡镇信息
	 * @param Township township
	 * @return Integer id
	 * @author zbk
	 * @date 2017-06-26 17:15:27
	 */
	public Integer save(Township township) throws Exception;
	/**
	 * Desc:更新乡镇信息
	 * @param Township township
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-26 17:15:27
	 */
	public Integer update(Township township) throws Exception;
	/**
	 * Desc:删除乡镇信息
	 * @param List<Integer> req
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-26 17:15:27
	 */
	public Integer delete(List<Integer> req) throws Exception;
}
