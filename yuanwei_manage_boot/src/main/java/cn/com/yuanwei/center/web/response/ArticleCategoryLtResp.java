package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.ArticleCategory;
/**
 * 文章类别
 * 
 * @author zbk
 * @email 
 * @date 2017-05-16 11:11:22
 */
public class ArticleCategoryLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<ArticleCategory> articleCategoryLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<ArticleCategory> getArticleCategoryLt() {
		return articleCategoryLt;
	}
	public void setArticleCategoryLt(List<ArticleCategory> articleCategoryLt) {
		this.articleCategoryLt = articleCategoryLt;
	}
}
