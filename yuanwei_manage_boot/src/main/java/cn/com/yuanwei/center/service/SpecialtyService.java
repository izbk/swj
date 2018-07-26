package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.Specialty;
import cn.com.yuanwei.center.web.request.SpecialtyReq;
import cn.com.yuanwei.center.web.response.SpecialtyLtResp;
/**
 * 绵竹造产品表
 * 
 * @author zbk
 * @email 
 * @date 2017-06-02 17:44:00
 */
public interface SpecialtyService {
   /**
	 * Desc:查询绵竹造产品表
	 * @param Integer id
	 * @return  Specialty
	 * @author zbk
	 * @date 2017-06-02 17:44:00
	 */
	public Specialty queryById(Integer id) throws Exception;
   /**
	 * Desc:查询绵竹造产品表列表
	 * @param SpecialtyReq req
	 * @return SpecialtyLtResp
	 * @author zbk
	 * @date 2017-06-02 17:44:00
	 */
	public SpecialtyLtResp queryList(SpecialtyReq req) throws Exception;
   /**
	 * Desc:新增绵竹造产品表
	 * @param Specialty specialty
	 * @return Integer id
	 * @author zbk
	 * @date 2017-06-02 17:44:00
	 */
	public Integer save(Specialty specialty) throws Exception;
	/**
	 * Desc:更新绵竹造产品表
	 * @param Specialty specialty
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-02 17:44:00
	 */
	public Integer update(Specialty specialty) throws Exception;
	/**
	 * Desc:删除绵竹造产品表
	 * @param List<Integer> req
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-02 17:44:00
	 */
	public Integer delete(List<Integer> req) throws Exception;
}
