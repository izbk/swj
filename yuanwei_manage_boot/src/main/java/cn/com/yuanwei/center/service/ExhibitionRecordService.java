package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.ExhibitionRecord;
import cn.com.yuanwei.center.web.request.ExhibitionRecordReq;
import cn.com.yuanwei.center.web.response.ExhibitionRecordLtResp;
/**
 * 会展备案信息
 * 
 * @author zbk
 * @email 
 * @date 2017-07-03 11:39:30
 */
public interface ExhibitionRecordService {
   /**
	 * Desc:查询会展备案信息
	 * @param Integer id
	 * @return  ExhibitionRecord
	 * @author zbk
	 * @date 2017-07-03 11:39:30
	 */
	public ExhibitionRecord queryById(Integer id) throws Exception;
   /**
	 * Desc:查询会展备案信息列表
	 * @param ExhibitionRecordReq req
	 * @return ExhibitionRecordLtResp
	 * @author zbk
	 * @date 2017-07-03 11:39:30
	 */
	public ExhibitionRecordLtResp queryList(ExhibitionRecordReq req) throws Exception;
   /**
	 * Desc:新增会展备案信息
	 * @param ExhibitionRecord exhibitionRecord
	 * @return Integer id
	 * @author zbk
	 * @date 2017-07-03 11:39:30
	 */
	public Integer save(ExhibitionRecord exhibitionRecord) throws Exception;
	/**
	 * Desc:更新会展备案信息
	 * @param ExhibitionRecord exhibitionRecord
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-07-03 11:39:30
	 */
	public Integer update(ExhibitionRecord exhibitionRecord) throws Exception;
	/**
	 * Desc:删除会展备案信息
	 * @param List<Integer> req
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-07-03 11:39:30
	 */
	public Integer delete(List<Integer> req) throws Exception;
}
