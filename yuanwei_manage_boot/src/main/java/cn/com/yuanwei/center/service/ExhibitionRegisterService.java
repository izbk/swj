package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.ExhibitionRegister;
import cn.com.yuanwei.center.entity.ExhibitionRegisterVo;
import cn.com.yuanwei.center.web.request.ExhibitionRegisterReq;
import cn.com.yuanwei.center.web.response.ExhibitionRegisterLtResp;
/**
 * 会展报名信息
 * 
 * @author zbk
 * @email 
 * @date 2017-07-03 15:37:10
 */
public interface ExhibitionRegisterService {
   /**
	 * Desc:查询会展报名信息
	 * @param Integer id
	 * @return  ExhibitionRegister
	 * @author zbk
	 * @date 2017-07-03 15:37:10
	 */
	public ExhibitionRegister queryById(Integer id) throws Exception;
   /**
	 * Desc:查询会展报名信息列表
	 * @param ExhibitionRegisterReq req
	 * @return ExhibitionRegisterLtResp
	 * @author zbk
	 * @date 2017-07-03 15:37:10
	 */
	public ExhibitionRegisterLtResp queryList(ExhibitionRegisterReq req) throws Exception;
	public List<ExhibitionRegisterVo> queryListForExport(ExhibitionRegisterReq req) throws Exception;
   /**
	 * Desc:新增会展报名信息
	 * @param ExhibitionRegister exhibitionRegister
	 * @return Integer id
	 * @author zbk
	 * @date 2017-07-03 15:37:10
	 */
	public Integer save(ExhibitionRegister exhibitionRegister) throws Exception;
	/**
	 * Desc:更新会展报名信息
	 * @param ExhibitionRegister exhibitionRegister
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-07-03 15:37:10
	 */
	public Integer update(ExhibitionRegister exhibitionRegister) throws Exception;
	/**
	 * Desc:删除会展报名信息
	 * @param List<Integer> req
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-07-03 15:37:10
	 */
	public Integer delete(List<Integer> req) throws Exception;
}
