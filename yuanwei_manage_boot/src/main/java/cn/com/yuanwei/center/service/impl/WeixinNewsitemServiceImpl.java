package cn.com.yuanwei.center.service.impl;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.riversoft.weixin.common.media.MpArticle;
import com.riversoft.weixin.common.media.MpNews;
import com.riversoft.weixin.mp.media.Materials;
import com.riversoft.weixin.mp.media.bean.Material;
import com.riversoft.weixin.mp.message.MpMessages;

import cn.com.yuanwei.center.config.SysConfig;
import cn.com.yuanwei.center.entity.Article;
import cn.com.yuanwei.center.entity.ArticleExample;
import cn.com.yuanwei.center.entity.WeixinNewsitem;
import cn.com.yuanwei.center.entity.WeixinNewsitemExample;
import cn.com.yuanwei.center.entity.WeixinNewsitemExample.Criteria;
import cn.com.yuanwei.center.enums.IsEnum;
import cn.com.yuanwei.center.mapper.ArticleMapper;
import cn.com.yuanwei.center.mapper.WeixinNewsitemMapper;
import cn.com.yuanwei.center.service.WeixinNewsitemService;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.WeixinNewsitemReq;
import cn.com.yuanwei.center.web.response.WeixinNewsitemLtResp;

@Service
@Transactional
public class WeixinNewsitemServiceImpl implements WeixinNewsitemService {
	@Autowired
	private WeixinNewsitemMapper weixinNewsitemMapper;
	@Autowired
	private ArticleMapper articleMapper;
	@Autowired
	SysConfig sysConfig;
	 
	@Override
	public Integer save(WeixinNewsitem weixinNewsitem) throws Exception {
		weixinNewsitemMapper.insert(weixinNewsitem);
		return weixinNewsitem.getId();
	}

	@Override
	public Integer update(WeixinNewsitem weixinNewsitem) throws Exception {
		return weixinNewsitemMapper.updateByPrimaryKey(weixinNewsitem);
	}

	@Override
	public Integer delete(List<Integer> req) throws Exception {
		WeixinNewsitemExample de=new WeixinNewsitemExample();
		de.createCriteria().andIdIn(req);
		return weixinNewsitemMapper.deleteByExample(de);
	}
	
	@Override
	public WeixinNewsitem queryById(Integer id){
		return weixinNewsitemMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public WeixinNewsitemLtResp queryList(WeixinNewsitemReq req) throws Exception {
		Integer id = req.getId();
		Integer articleId = req.getArticleId();
		String title = req.getTitle();
		String author = req.getAuthor();
		String digest = req.getDigest();
		String thumbMediaId = req.getThumbMediaId();
		Integer showCoverPic = req.getShowCoverPic();
		String contentSourceUrl = req.getContentSourceUrl();
		Integer orders = req.getOrders();
		Date createTime = req.getCreateTime();
		WeixinNewsitemExample de=new WeixinNewsitemExample();
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
		if(!ValidateUtil.isEmpty(author)){
			c.andAuthorEqualTo(author);
		}
		if(!ValidateUtil.isEmpty(digest)){
			c.andDigestEqualTo(digest);
		}
		if(!ValidateUtil.isEmpty(thumbMediaId)){
			c.andThumbMediaIdEqualTo(thumbMediaId);
		}
		if(!ValidateUtil.isEmpty(showCoverPic)){
			c.andShowCoverPicEqualTo(showCoverPic);
		}
		if(!ValidateUtil.isEmpty(contentSourceUrl)){
			c.andContentSourceUrlEqualTo(contentSourceUrl);
		}
		if(!ValidateUtil.isEmpty(orders)){
			c.andOrdersEqualTo(orders);
		}
		if(!ValidateUtil.isEmpty(createTime)){
			c.andCreateTimeEqualTo(createTime);
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<WeixinNewsitem> page = (Page<WeixinNewsitem>) weixinNewsitemMapper.selectByExample(de);
		WeixinNewsitemLtResp resp = new WeixinNewsitemLtResp();
		resp.setCount(page.getTotal());
		resp.setWeixinNewsitemLt(page.getResult());
		return resp;
	}
	
	@Override
	public Long send(List<Integer> req) throws Exception {
		ArticleExample de = new ArticleExample();
		de.createCriteria().andIdIn(req);
		List<Article> articles = articleMapper.selectByExample(de);
		Materials materials = Materials.defaultMaterials();
		Date date = Calendar.getInstance().getTime();
		MpNews mpNews = new MpNews();
		for (Article article : articles) {
			WeixinNewsitem newsitem = new WeixinNewsitem();
			newsitem.setArticleId(article.getId());
			newsitem.setTitle(article.getTitle());
			newsitem.setAuthor(article.getAuthor());
			newsitem.setDigest(article.getBreif());
			newsitem.setShowCoverPic(IsEnum.yes.getCode());
			newsitem.setContentSourceUrl(sysConfig.getFrontServer()+"/detail/"+article.getId());
			//获取图文内容
			String content = article.getContent();
			List<String> contentPics = getImgStr(content);
			//获取封面图片素材id
			String pic = article.getPic();
			if(ValidateUtil.isEmpty(pic)){
				if(ValidateUtil.isEmpty(contentPics)){
					throw new Exception("文章《"+article.getTitle()+"》没有获取到封面图片");
				}else{
					pic = contentPics.get(0);
				}
			}
			String picFileName = pic.substring(pic.lastIndexOf("/")+1);
			InputStream in = getImageFromNetByUrl(pic);
			if(in == null){
				throw new Exception("文章《"+article.getTitle()+"》封面图片地址无效");
			}
			Material imgMaterial = materials.addImage(in, picFileName);
			//设置封面图片素材id
			newsitem.setThumbMediaId(imgMaterial.getMediaId());
			for (String contentPic : contentPics) {
				String weixinUrl = materials.addMpNewsImage(getImageFromNetByUrl(contentPic), contentPic.substring(contentPic.lastIndexOf("/")+1));
				content = content.replace(contentPic, weixinUrl);
			}
			//设置替换图片链接后的content
			newsitem.setContent(content);
			newsitem.setCreateTime(date);
			weixinNewsitemMapper.insertSelective(newsitem);
			
			MpArticle mpArticle = new MpArticle();
			BeanUtils.copyProperties(newsitem, mpArticle);
			mpNews.add(mpArticle);
		}
		//上传图文素材
		String mpNewsMediaId = materials.addMpNews(mpNews);
		return MpMessages.defaultMpMessages().mpNews(mpNewsMediaId);
	}
	
	/**
	 * 获取富文本HTML中的img src
	 * @param htmlStr
	 * @return
	 */
	private static List<String> getImgStr(String htmlStr) {
		String img = "";
		Pattern p_image;
		Matcher m_image;
		List<String> pics = new ArrayList<String>();
		String regEx_img = "]*?>"; // 图片链接地址
		p_image = Pattern.compile(regEx_img, Pattern.CASE_INSENSITIVE);
		m_image = p_image.matcher(htmlStr);
		while (m_image.find()) {
			img = img + "," + m_image.group();
			Matcher m = Pattern.compile("src=\"?(.*?)(\"|>|\\s+)").matcher(img);
			while (m.find()) {
				pics.add(m.group(1));
			}
		}
		return pics;
	}
	/**
	 * 根据网络图片地址获取输入流
	 * @param strUrl
	 * @return
	 */
	private static InputStream getImageFromNetByUrl(String strUrl) {
	    try {
	        URL url = new URL(strUrl);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setConnectTimeout(5 * 1000);
	        return conn.getInputStream();// 通过输入流获取图片数据
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
}
