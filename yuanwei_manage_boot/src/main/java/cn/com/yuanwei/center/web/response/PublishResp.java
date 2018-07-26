package cn.com.yuanwei.center.web.response;

import java.io.Serializable;
import java.util.List;

import cn.com.yuanwei.center.web.vo.ImageVo;
/**
 * 内容发布
 * 
 * @author zbk
 * @email 
 * @date 2017-05-22 10:54:24
 */
public class PublishResp implements Serializable{
	private static final long serialVersionUID = 1L;
    private Integer id;

    private Integer pid;

    private String name;

    private Integer resType;

    private String href;

    private Integer sort;

    private String resValue;
    
    private Integer[] articleCategorys;
    
	private List<PublishResp> children;
	
	private List<ImageVo> images;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getResType() {
		return resType;
	}

	public void setResType(Integer resType) {
		this.resType = resType;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getResValue() {
		return resValue;
	}

	public void setResValue(String resValue) {
		this.resValue = resValue;
	}
	
	public Integer[] getArticleCategorys() {
		return articleCategorys;
	}

	public void setArticleCategorys(Integer[] articleCategorys) {
		this.articleCategorys = articleCategorys;
	}

	public List<PublishResp> getChildren() {
		return children;
	}

	public void setChildren(List<PublishResp> children) {
		this.children = children;
	}

	public List<ImageVo> getImages() {
		return images;
	}

	public void setImages(List<ImageVo> images) {
		this.images = images;
	}

}
