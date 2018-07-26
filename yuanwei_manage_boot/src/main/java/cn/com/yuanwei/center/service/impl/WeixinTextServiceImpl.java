package cn.com.yuanwei.center.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.riversoft.weixin.mp.message.MpMessages;

import cn.com.yuanwei.center.entity.Article;
import cn.com.yuanwei.center.entity.WeixinText;
import cn.com.yuanwei.center.entity.WeixinTextExample;
import cn.com.yuanwei.center.entity.WeixinTextExample.Criteria;
import cn.com.yuanwei.center.mapper.ArticleMapper;
import cn.com.yuanwei.center.mapper.WeixinTextMapper;
import cn.com.yuanwei.center.service.WeixinTextService;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.WeixinTextReq;
import cn.com.yuanwei.center.web.response.WeixinTextLtResp;

@Service
@Transactional
public class WeixinTextServiceImpl implements WeixinTextService {
	@Autowired
	private 
	 WeixinTextMapper weixinTextMapper;
	@Autowired
	private 
	 ArticleMapper articleMapper;
	 
	@Override
	public Integer save(WeixinText weixinText) throws Exception {
		weixinTextMapper.insert(weixinText);
		return weixinText.getId();
	}

	@Override
	public Integer update(WeixinText weixinText) throws Exception {
		return weixinTextMapper.updateByPrimaryKey(weixinText);
	}

	@Override
	public Integer delete(List<Integer> req) throws Exception {
		WeixinTextExample de=new WeixinTextExample();
		de.createCriteria().andIdIn(req);
		return weixinTextMapper.deleteByExample(de);
	}
	
	@Override
	public WeixinText queryById(Integer id){
		return weixinTextMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public WeixinTextLtResp queryList(WeixinTextReq req) throws Exception {
		Integer id = req.getId();
		Integer articleId = req.getArticleId();
		String title = req.getTitle();
		String content = req.getContent();
		Date createTime = req.getCreateTime();
		WeixinTextExample de=new WeixinTextExample();
		Criteria c = de.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(articleId)){
			c.andArticleIdEqualTo(articleId);
		}
		if(!ValidateUtil.isEmpty(title)){
			c.andTitleEqualTo(title);
		}
		if(!ValidateUtil.isEmpty(content)){
			c.andContentEqualTo(content);
		}
		if(!ValidateUtil.isEmpty(createTime)){
			c.andCreateTimeEqualTo(createTime);
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<WeixinText> page = (Page<WeixinText>) weixinTextMapper.selectByExample(de);
		WeixinTextLtResp resp = new WeixinTextLtResp();
		resp.setCount(page.getTotal());
		resp.setWeixinTextLt(page.getResult());
		return resp;
	}
	
	@Override
	public Long send(Integer id) throws Exception {
		Article article =  articleMapper.selectByPrimaryKey(id);
		if(ValidateUtil.isEmpty(article)){
			throw new Exception("未获取到文章信息");
		}
		String content = article.getContent();
		if(ValidateUtil.isEmpty(content)){
			throw new Exception("文章内容为空");
		}
		return MpMessages.defaultMpMessages().text(content);
	}
	
}
