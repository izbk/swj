package cn.com.yuanwei.center.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.yuanwei.center.entity.ArticleCategory;
import cn.com.yuanwei.center.entity.ArticleCategoryExample;
import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.entity.ArticleCategoryExample.Criteria;
import cn.com.yuanwei.center.mapper.ArticleCategoryMapper;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;
import cn.com.yuanwei.center.service.ArticleCategoryService;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.ArticleCategoryReq;
import cn.com.yuanwei.center.web.response.ArticleCategoryLtResp;
import cn.com.yuanwei.center.web.response.ArticleCategoryResp;

@Service
@Transactional
public class ArticleCategoryServiceImpl implements ArticleCategoryService {
	@Autowired
	private ArticleCategoryMapper articleCategoryMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;

	@Override
	public void save(ArticleCategory articleCategory) throws Exception {
		//设置indexId
 		if(articleCategory != null && articleCategory.getPid() != null){
 			Integer pId = articleCategory.getPid();
 			String pIndexId = "";
 			if(pId != null){
 				pIndexId = articleCategoryMapper.selectByPrimaryKey(pId).getIndexId();
 			}
 			if(pIndexId== null || pIndexId.isEmpty()){
 				articleCategory.setIndexId(pId.toString());
 			}else{
 				articleCategory.setIndexId(pIndexId+"_"+pId);
 			}
 		}
		articleCategoryMapper.insert(articleCategory);
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),articleCategory.getId(), "新增文章类别"));
	}

	@Override
	public void update(ArticleCategory articleCategory) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),articleCategory.getId(), "更新文章类别"));
		//设置indexId
 		if(articleCategory != null && articleCategory.getPid() != null){
 			Integer pId = articleCategory.getPid();
 			String pIndexId = "";
 			if(pId != null){
 				pIndexId = articleCategoryMapper.selectByPrimaryKey(pId).getIndexId();
 			}
 			if(pIndexId== null || pIndexId.isEmpty()){
 				articleCategory.setIndexId(pId.toString());
 			}else{
 				articleCategory.setIndexId(pIndexId+"_"+pId);
 			}
 		}
		articleCategoryMapper.updateByPrimaryKey(articleCategory);
	}

	@Override
	public void delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除文章类别"));
		}		
		ArticleCategoryExample de=new ArticleCategoryExample();
		de.createCriteria().andIdIn(ids);
		articleCategoryMapper.deleteByExample(de);
	}
	
	@Override
	public ArticleCategory queryById(Integer id){
		return articleCategoryMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public ArticleCategoryLtResp queryList(ArticleCategoryReq req) throws Exception {
		Integer id = req.getId();
		Integer pid = req.getPid();
		String name = req.getName();
		String indexId = req.getIndexId();
		ArticleCategoryExample de=new ArticleCategoryExample();
		Criteria c = de.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(pid)){
			c.andPidEqualTo(pid);
		}
		if(!ValidateUtil.isEmpty(name)){
			c.andNameLike("%"+name+"%");
		}
		if(!ValidateUtil.isEmpty(indexId)){
			c.andIndexIdEqualTo(indexId);
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<ArticleCategory> page = (Page<ArticleCategory>) articleCategoryMapper.selectByExample(de);
		ArticleCategoryLtResp resp = new ArticleCategoryLtResp();
		resp.setCount(page.getTotal());
		resp.setArticleCategoryLt(page.getResult());
		return resp;
	}
	
	@Override
	public List<ArticleCategoryResp> queryAllList() throws Exception {
		ArticleCategoryExample de=new ArticleCategoryExample();
		List<ArticleCategory> list = articleCategoryMapper.selectByExample(de);
		return convertArticleCategoryLt(list);
	}
	
	/**
	 * 转换为树形列表
	 * @param articleCategoryLt
	 * @return
	 * @throws Exception
	 */
	private List<ArticleCategoryResp> convertArticleCategoryLt(List<ArticleCategory> articleCategoryLt) throws Exception {
		List<ArticleCategoryResp> categoryData = new ArrayList<ArticleCategoryResp>();
		for(ArticleCategory category:articleCategoryLt){
			if(ValidateUtil.isEmpty(category.getPid())){
				ArticleCategoryResp item = new ArticleCategoryResp();
				BeanUtils.copyProperties(category, item);
				item.setChildren(this.tree(articleCategoryLt, category.getId()));
				categoryData.add(item);
			}
		}
		return categoryData;
	}
	
	private List<ArticleCategoryResp> tree(List<ArticleCategory> articleCategoryLt,Integer id){
		List<ArticleCategoryResp> resp = new ArrayList<>();
		for(ArticleCategory sub:articleCategoryLt){
			if(id.equals(sub.getPid())){
				ArticleCategoryResp subitem = new ArticleCategoryResp();
				BeanUtils.copyProperties(sub, subitem);
				List<ArticleCategoryResp> respLt = this.tree(articleCategoryLt, sub.getId());
				if(!ValidateUtil.isEmpty(respLt)){
					subitem.setChildren(respLt);
				}
				resp.add(subitem);
			}
		}
		return resp;
	}
	
	
}
