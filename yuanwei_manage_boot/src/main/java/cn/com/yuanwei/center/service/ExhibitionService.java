package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.Exhibition;
import cn.com.yuanwei.center.web.request.ExhibitionReq;
import cn.com.yuanwei.center.web.response.ExhibitionLtResp;
/**
 * 会展信息
 * 
 * @author zbk
 * @email 
 * @date 2017-07-04 16:11:03
 */
public interface ExhibitionService {
   /**
	 * Desc:查询会展信息
	 * @param Integer id
	 * @return  Exhibition
	 * @author zbk
	 * @date 2017-07-04 16:11:03
	 */
	public Exhibition queryById(Integer id) throws Exception;
   /**
	 * Desc:查询会展信息列表
	 * @param ExhibitionReq req
	 * @return ExhibitionLtResp
	 * @author zbk
	 * @date 2017-07-04 16:11:03
	 */
	public ExhibitionLtResp queryList(ExhibitionReq req) throws Exception;
   /**
	 * Desc:新增会展信息
	 * @param Exhibition exhibition
	 * @return Integer id
	 * @author zbk
	 * @date 2017-07-04 16:11:03
	 */
	public Integer save(Exhibition exhibition) throws Exception;
	/**
	 * Desc:更新会展信息
	 * @param Exhibition exhibition
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-07-04 16:11:03
	 */
	public Integer update(Exhibition exhibition) throws Exception;
	/**
	 * Desc:删除会展信息
	 * @param List<Integer> req
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-07-04 16:11:03
	 */
	public Integer delete(List<Integer> req) throws Exception;
}
