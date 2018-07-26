package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.IncubationParkAssessment;
import cn.com.yuanwei.center.web.request.IncubationParkAssessmentReq;
import cn.com.yuanwei.center.web.response.IncubationParkAssessmentLtResp;
/**
 * 孵化园企业考核
 * 
 * @author zbk
 * @email 
 * @date 2017-07-04 17:42:05
 */
public interface IncubationParkAssessmentService {
   /**
	 * Desc:查询孵化园企业考核
	 * @param Integer id
	 * @return  IncubationParkAssessment
	 * @author zbk
	 * @date 2017-07-04 17:42:05
	 */
	public IncubationParkAssessment queryById(Integer id) throws Exception;
   /**
	 * Desc:查询孵化园企业考核列表
	 * @param IncubationParkAssessmentReq req
	 * @return IncubationParkAssessmentLtResp
	 * @author zbk
	 * @date 2017-07-04 17:42:05
	 */
	public IncubationParkAssessmentLtResp queryList(IncubationParkAssessmentReq req) throws Exception;
   /**
	 * Desc:新增孵化园企业考核
	 * @param IncubationParkAssessment incubationParkAssessment
	 * @return Integer id
	 * @author zbk
	 * @date 2017-07-04 17:42:05
	 */
	public Integer save(IncubationParkAssessment incubationParkAssessment) throws Exception;
	/**
	 * Desc:更新孵化园企业考核
	 * @param IncubationParkAssessment incubationParkAssessment
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-07-04 17:42:05
	 */
	public Integer update(IncubationParkAssessment incubationParkAssessment) throws Exception;
	/**
	 * Desc:删除孵化园企业考核
	 * @param List<Integer> req
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-07-04 17:42:05
	 */
	public Integer delete(List<Integer> req) throws Exception;
}
