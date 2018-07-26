package cn.com.yuanwei.center.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.yuanwei.center.component.WebSocketComponent;
import cn.com.yuanwei.center.entity.Article;
import cn.com.yuanwei.center.entity.ArticleCategory;
import cn.com.yuanwei.center.entity.ArticleCategoryExample;
import cn.com.yuanwei.center.entity.ArticleExample;
import cn.com.yuanwei.center.entity.ArticleExample.Criteria;
import cn.com.yuanwei.center.entity.AuditConfig;
import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.entity.ToDoList;
import cn.com.yuanwei.center.entity.ToDoListExample;
import cn.com.yuanwei.center.enums.ArticleStatusEnum;
import cn.com.yuanwei.center.enums.BusiTypeEnum;
import cn.com.yuanwei.center.enums.IsDealEnum;
import cn.com.yuanwei.center.mapper.ArticleCategoryMapper;
import cn.com.yuanwei.center.mapper.ArticleMapper;
import cn.com.yuanwei.center.mapper.AuditConfigMapper;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.mapper.ToDoListMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;
import cn.com.yuanwei.center.service.ArticleService;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.ArticleReq;
import cn.com.yuanwei.center.web.response.ArticleLtResp;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private AuditConfigMapper auditConfigMapper;
	@Autowired
	private ToDoListMapper toDoListMapper;
	@Autowired
	private ArticleMapper articleMapper;
	@Autowired
	private ArticleCategoryMapper articleCategoryMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	 
	@Override
	public void save(Article article) throws Exception {
		UserInfo userInfo = LoginUserThread.getUser();
		Integer departId = userInfo.getDepartId();
		if(!ValidateUtil.isEmpty(departId)){
			article.setDepartIds(departId.toString());
		}
		article.setCreateBy(userInfo.getId());
		article.setCreateTime(new Date());
		articleMapper.insert(article);
		Integer status = article.getStatus();
		if(status != null &&status.compareTo(ArticleStatusEnum.weishenhe.getCode())==0){
			//新增待办事项
			AuditConfig record = new AuditConfig();
			record.setDepartId(userInfo.getDepartId());
			record.setBusiType(BusiTypeEnum.wenzhang.getCode());
			record.setSubBusiType(article.getArticleType());
			List<AuditConfig> list = auditConfigMapper.selectByAuditConfig(record);
			if(list != null && list.size() > 0){
				AuditConfig config = list.get(0);
				if(!ValidateUtil.isEmpty(config.getUserId1())){
					ToDoList toDoList = new ToDoList();
					toDoList.setAuditConfigId(config.getId());
					toDoList.setBusiId(article.getId());
					toDoList.setBusiName(article.getTitle());
					toDoList.setBusiType(BusiTypeEnum.wenzhang.getCode());
					toDoList.setSubBusiType(article.getArticleType());
					toDoList.setCreateTime(new Date());
					toDoList.setUserId(config.getUserId1());
					toDoList.setIsDeal(IsDealEnum.fou.getCode());
					toDoListMapper.insertSelective(toDoList);
					WebSocketComponent.sendMessage("您有新的待办事项", config.getUserId1().toString());
				}
			}
		}
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(), article.getId(), "新增文章:"+article.getTitle()));
	}

	@Override
	public void update(Article article) throws Exception {
		articleMapper.updateByPrimaryKeyWithBLOBs(article);
		Integer status = article.getStatus();
		UserInfo userInfo = LoginUserThread.getUser();
		if(status != null){
			ToDoListExample de = new ToDoListExample();
			de.createCriteria().andBusiIdEqualTo(article.getId());
			toDoListMapper.deleteByExample(de);
			if(status.compareTo(ArticleStatusEnum.weishenhe.getCode())==0){
				//新增待办事项
				AuditConfig record = new AuditConfig();
				record.setDepartId(userInfo.getDepartId());
				record.setBusiType(BusiTypeEnum.wenzhang.getCode());
				record.setSubBusiType(article.getArticleType());
				List<AuditConfig> list = auditConfigMapper.selectByAuditConfig(record);
				if(list != null && list.size() > 0){
					AuditConfig config = list.get(0);
					if(!ValidateUtil.isEmpty(config.getUserId1())){
						ToDoList toDoList = new ToDoList();
						toDoList.setAuditConfigId(config.getId());
						toDoList.setBusiId(article.getId());
						toDoList.setBusiName(article.getTitle());
						toDoList.setBusiType(BusiTypeEnum.wenzhang.getCode());
						toDoList.setSubBusiType(article.getArticleType());
						toDoList.setCreateTime(new Date());
						toDoList.setUserId(config.getUserId1());
						toDoList.setIsDeal(IsDealEnum.fou.getCode());
						toDoListMapper.insertSelective(toDoList);
					}
				}
			}
		}
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(), article.getId(), "修改文章:"+article.getTitle()));
	}

	@Override
	public void delete(List<Integer> req) throws Exception {
		ArticleExample de=new ArticleExample();
		de.createCriteria().andIdIn(req);
		articleMapper.deleteByExample(de);
		//删除待办事项
		ToDoListExample de2 = new ToDoListExample();
		de2.createCriteria().andBusiIdIn(req);
		toDoListMapper.deleteByExample(de2);
		
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : req) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除文章"));
		}
	}
	
	@Override
	public Article queryById(Integer id){
		return articleMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public ArticleLtResp queryList(ArticleReq req) throws Exception {
		Integer id = req.getId();
		Integer articleType = req.getArticleType();
		Integer articleCategory = req.getArticleCategory();
		Integer[] articleCategorys = req.getCategorys();
		String breif = req.getBreif();
		String source = req.getSource();
		String sourceUrl = req.getSourceUrl();
		String title = req.getTitle();
		String author = req.getAuthor();
		String pic = req.getPic();
		Integer clickNum = req.getClickNum();
		Integer commentNum = req.getCommentNum();
		String contentKeyword = req.getContentKeyword();
		Integer topLevel = req.getTopLevel();
		Integer status = req.getStatus();
		Date publishTime = req.getPublishTime();
		String departIds = req.getDepartIds();
		Integer isPublic = req.getIsPublic();
		Integer createBy = req.getCreateBy();
		Date createTime = req.getCreateTime();
		Integer audit1By = req.getAudit1By();
		Date audit1Time = req.getAudit1Time();
		Integer audit2By = req.getAudit2By();
		Date audit2Time = req.getAudit2Time();
		Integer audit3By = req.getAudit3By();
		Date audit3Time = req.getAudit3Time();
		String remark = req.getRemark();
		ArticleExample de=new ArticleExample();
		de.setOrderByClause(" status,id desc");
		Criteria c = de.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(articleType)){
			c.andArticleTypeEqualTo(articleType);
		}
		if(!ValidateUtil.isEmpty(articleCategory)){
			ArticleCategoryExample example = new ArticleCategoryExample();
			example.createCriteria().andPidEqualTo(articleCategory);
			List<ArticleCategory> categorys = articleCategoryMapper.selectByExample(example);
			if(ValidateUtil.isEmpty(categorys)){
				c.andArticleCategoryEqualTo(articleCategory);
			}else{
				//构建文章种类子集合
				List<Integer> categoryIds = new ArrayList<Integer>();
				for (ArticleCategory articleCategory2 : categorys) {
					categoryIds.add(articleCategory2.getId());
				}
				categoryIds.add(articleCategory);
				c.andArticleCategoryIn(categoryIds);
			}
		}
		if(!ValidateUtil.isEmpty(articleCategorys)){
			ArticleCategoryExample example = new ArticleCategoryExample();
			example.createCriteria().andPidEqualTo(articleCategorys[articleCategorys.length-1]);
			List<ArticleCategory> categorys = articleCategoryMapper.selectByExample(example);
			if(ValidateUtil.isEmpty(categorys)){
				c.andArticleCategoryEqualTo(articleCategorys[articleCategorys.length-1]);
			}else{
				//构建文章种类子集合
				List<Integer> categoryIds = new ArrayList<Integer>();
				for (ArticleCategory articleCategory2 : categorys) {
					categoryIds.add(articleCategory2.getId());
				}
				categoryIds.add(articleCategorys[articleCategorys.length-1]);
				c.andArticleCategoryIn(categoryIds);
			}
		}
		if(!ValidateUtil.isEmpty(breif)){
			c.andBreifEqualTo(breif);
		}
		if(!ValidateUtil.isEmpty(source)){
			c.andSourceEqualTo(source);
		}
		if(!ValidateUtil.isEmpty(sourceUrl)){
			c.andSourceUrlEqualTo(sourceUrl);
		}
		if(!ValidateUtil.isEmpty(title)){
			c.andTitleLike("%"+title+"%");
		}
		if(!ValidateUtil.isEmpty(author)){
			c.andAuthorEqualTo(author);
		}
		if(!ValidateUtil.isEmpty(pic)){
			c.andPicEqualTo(pic);
		}
		if(!ValidateUtil.isEmpty(clickNum)){
			c.andClickNumEqualTo(clickNum);
		}
		if(!ValidateUtil.isEmpty(commentNum)){
			c.andCommentNumEqualTo(commentNum);
		}
		if(!ValidateUtil.isEmpty(contentKeyword)){
			c.andContentKeywordEqualTo(contentKeyword);
		}
		if(!ValidateUtil.isEmpty(topLevel)){
			c.andTopLevelEqualTo(topLevel);
		}
		if(!ValidateUtil.isEmpty(status)){
			c.andStatusEqualTo(status);
		}
		if(!ValidateUtil.isEmpty(publishTime)){
			c.andPublishTimeEqualTo(publishTime);
		}
		if(!ValidateUtil.isEmpty(departIds)){
			c.andDepartIdsEqualTo(departIds);
		}
		if(!ValidateUtil.isEmpty(isPublic)){
			c.andIsPublicEqualTo(isPublic);
		}
		if(!ValidateUtil.isEmpty(createBy)){
			c.andCreateByEqualTo(createBy);
		}
		if(!ValidateUtil.isEmpty(createTime)){
			c.andCreateTimeEqualTo(createTime);
		}
		if(!ValidateUtil.isEmpty(audit1By)){
			c.andAudit1ByEqualTo(audit1By);
		}
		if(!ValidateUtil.isEmpty(audit1Time)){
			c.andAudit1TimeEqualTo(audit1Time);
		}
		if(!ValidateUtil.isEmpty(audit2By)){
			c.andAudit2ByEqualTo(audit2By);
		}
		if(!ValidateUtil.isEmpty(audit2Time)){
			c.andAudit2TimeEqualTo(audit2Time);
		}
		if(!ValidateUtil.isEmpty(audit3By)){
			c.andAudit3ByEqualTo(audit3By);
		}
		if(!ValidateUtil.isEmpty(audit3Time)){
			c.andAudit3TimeEqualTo(audit3Time);
		}
		if(!ValidateUtil.isEmpty(remark)){
			c.andRemarkEqualTo(remark);
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<Article> page = (Page<Article>) articleMapper.selectByExampleWithBLOBs(de);
		List<Article> list = page.getResult();
		//构造category数组[祖父id,父id,id]
		for (Article article : list) {
			Integer categoryId = article.getArticleCategory();
			ArticleCategory category = articleCategoryMapper.selectByPrimaryKey(categoryId);
			if(category != null){
				Integer[] categorys = null;
				String indexId = category.getIndexId();
				if(indexId == null || indexId.equals("")){
					categorys = new Integer[1];
					categorys[0] = category.getId();
				}else{
					String[] indexs = indexId.split("_");
					categorys = new Integer[indexs.length+1];
					for (int i = 0; i < indexs.length; i++) {
						categorys[i] = Integer.valueOf(indexs[i]);
					}
					categorys[indexs.length] = category.getId();
				}
				article.setArticleCategorys(categorys);
			}else{
				article.setArticleCategorys(new Integer[0]);
			}
		}
		ArticleLtResp resp = new ArticleLtResp();
		resp.setCount(page.getTotal());
		resp.setArticleLt(list);
		return resp;
	}
	
}
