package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.ArticleCategory;
import cn.com.yuanwei.center.web.request.ArticleCategoryReq;
import cn.com.yuanwei.center.web.response.ArticleCategoryLtResp;
import cn.com.yuanwei.center.web.response.ArticleCategoryResp;
/**
 * 文章类别
 * 
 * @author zbk
 * @email 
 * @date 2017-05-16 11:11:22
 */
public interface ArticleCategoryService {
   /**
	 * Desc:查询文章类别
	 * @author zbk
	 * @date 2017-05-16 11:11:22
	 */
	public ArticleCategory queryById(Integer id) throws Exception;
   /**
	 * Desc:查询文章类别列表
	 * @author zbk
	 * @date 2017-05-16 11:11:22
	 */
	public ArticleCategoryLtResp queryList(ArticleCategoryReq req) throws Exception;
	/**
	 * Desc:查询所有文章类别
	 * @author zbk
	 * @date 2017-05-16 11:11:22
	 */
	public List<ArticleCategoryResp> queryAllList() throws Exception;
   /**
	 * Desc:新增文章类别
	 * @author zbk
	 * @date 2017-05-16 11:11:22
	 */
	public void save(ArticleCategory articleCategory) throws Exception;
	/**
	 * Desc:更新文章类别
	 * @author zbk
	 * @date 2017-05-16 11:11:22
	 */
	public void update(ArticleCategory articleCategory) throws Exception;
	/**
	 * Desc:删除文章类别
	 * @author zbk
	 * @date 2017-05-16 11:11:22
	 */
	public void delete(List<Integer> ids) throws Exception;
}
