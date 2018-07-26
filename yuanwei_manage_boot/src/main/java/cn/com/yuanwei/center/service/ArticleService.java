package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.Article;
import cn.com.yuanwei.center.web.request.ArticleReq;
import cn.com.yuanwei.center.web.response.ArticleLtResp;
/**
 * 文章
 * 
 * @author zbk
 * @email 
 * @date 2017-05-16 11:11:22
 */
public interface ArticleService {
   /**
	 * Desc:查询文章
	 * @author zbk
	 * @date 2017-05-16 11:11:22
	 */
	public Article queryById(Integer id) throws Exception;
   /**
	 * Desc:查询文章列表
	 * @author zbk
	 * @date 2017-05-16 11:11:22
	 */
	public ArticleLtResp queryList(ArticleReq req) throws Exception;
   /**
	 * Desc:新增文章
	 * @author zbk
	 * @date 2017-05-16 11:11:22
	 */
	public void save(Article article) throws Exception;
	/**
	 * Desc:更新文章
	 * @author zbk
	 * @date 2017-05-16 11:11:22
	 */
	public void update(Article article) throws Exception;
	/**
	 * Desc:删除文章
	 * @author zbk
	 * @date 2017-05-16 11:11:22
	 */
	public void delete(List<Integer> req) throws Exception;
}
