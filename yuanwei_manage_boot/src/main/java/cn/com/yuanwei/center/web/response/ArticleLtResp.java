package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.entity.Article;
/**
 * 文章
 * 
 * @author zbk
 * @email 
 * @date 2017-05-16 11:11:22
 */
public class ArticleLtResp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long count;
	private List<Article> articleLt;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<Article> getArticleLt() {
		return articleLt;
	}
	public void setArticleLt(List<Article> articleLt) {
		this.articleLt = articleLt;
	}
}
