package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.Publish;
import cn.com.yuanwei.center.web.request.PublishReq;
import cn.com.yuanwei.center.web.response.PublishLtResp;
import cn.com.yuanwei.center.web.response.PublishResp;
/**
 * 内容发布
 * 
 * @author zbk
 * @email 
 * @date 2017-05-22 10:54:24
 */
public interface PublishService {
   /**
	 * Desc:查询内容发布
	 * @author zbk
	 * @date 2017-05-22 10:54:24
	 */
	public Publish queryById(Integer id) throws Exception;
   /**
	 * Desc:查询内容发布列表
	 * @author zbk
	 * @date 2017-05-22 10:54:24
	 */
	public PublishLtResp queryList(PublishReq req) throws Exception;
	/**
	 * Desc:查询所有内容发布
	 * @author zbk
	 * @date 2017-05-16 11:11:22
	 */
	public List<PublishResp> queryAllList(PublishReq req) throws Exception;	
   /**
	 * Desc:新增内容发布
	 * @author zbk
	 * @date 2017-05-22 10:54:24
	 */
	public void save(Publish publish) throws Exception;
	/**
	 * Desc:更新内容发布
	 * @author zbk
	 * @date 2017-05-22 10:54:24
	 */
	public void update(Publish publish) throws Exception;
	/**
	 * Desc:删除内容发布
	 * @author zbk
	 * @date 2017-05-22 10:54:24
	 */
	public void delete(List<Integer> req) throws Exception;
}
