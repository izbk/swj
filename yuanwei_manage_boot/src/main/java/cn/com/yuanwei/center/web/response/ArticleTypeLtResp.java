package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.ArticleType;
/**
 * 文章类型
 * 
 * @author zbk
 * @email 
 * @date 2017-05-16 11:11:22
 */
public class ArticleTypeLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<ArticleType> articleTypeLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<ArticleType> getArticleTypeLt() {
		return articleTypeLt;
	}
	public void setArticleTypeLt(List<ArticleType> articleTypeLt) {
		this.articleTypeLt = articleTypeLt;
	}
}
