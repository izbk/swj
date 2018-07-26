package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.ArticleType;
import cn.com.yuanwei.center.web.request.ArticleTypeReq;
import cn.com.yuanwei.center.web.response.ArticleTypeLtResp;
/**
 * 文章类型
 * 
 * @author zbk
 * @email 
 * @date 2017-06-26 16:48:11
 */
public interface ArticleTypeService {
   /**
	 * Desc:查询文章类型
	 * @param Integer id
	 * @return  ArticleType
	 * @author zbk
	 * @date 2017-06-26 16:48:11
	 */
	public ArticleType queryById(Integer id) throws Exception;
   /**
	 * Desc:查询文章类型列表
	 * @param ArticleTypeReq req
	 * @return ArticleTypeLtResp
	 * @author zbk
	 * @date 2017-06-26 16:48:11
	 */
	public ArticleTypeLtResp queryList(ArticleTypeReq req) throws Exception;
   /**
	 * Desc:新增文章类型
	 * @param ArticleType articleType
	 * @return Integer id
	 * @author zbk
	 * @date 2017-06-26 16:48:11
	 */
	public Integer save(ArticleType articleType) throws Exception;
	/**
	 * Desc:更新文章类型
	 * @param ArticleType articleType
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-26 16:48:11
	 */
	public Integer update(ArticleType articleType) throws Exception;
	/**
	 * Desc:删除文章类型
	 * @param List<Integer> req
	 * @return	 Integer affectRows
	 * @author zbk
	 * @date 2017-06-26 16:48:11
	 */
	public Integer delete(List<Integer> req) throws Exception;
}
