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
import cn.com.yuanwei.center.entity.Publish;
import cn.com.yuanwei.center.entity.PublishExample;
import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.entity.PublishExample.Criteria;
import cn.com.yuanwei.center.enums.ResTypeEnum;
import cn.com.yuanwei.center.mapper.ArticleCategoryMapper;
import cn.com.yuanwei.center.mapper.PublishMapper;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;
import cn.com.yuanwei.center.service.PublishService;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.PublishReq;
import cn.com.yuanwei.center.web.response.PublishLtResp;
import cn.com.yuanwei.center.web.response.PublishResp;
import cn.com.yuanwei.center.web.vo.ImageVo;

@Service
@Transactional
public class PublishServiceImpl implements PublishService {

	@Autowired
	private PublishMapper publishMapper;
	@Autowired
	private ArticleCategoryMapper articleCategoryMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	
	@Override
	public void save(Publish publish) throws Exception {
		//设置indexId
 		if(publish != null && publish.getPid() != null){
 			Integer pId = publish.getPid();
 			String pIndexId = "";
 			if(pId != null){
 				pIndexId = publishMapper.selectByPrimaryKey(pId).getIndexId();
 			}
 			if(pIndexId== null || pIndexId.isEmpty()){
 				publish.setIndexId(pId.toString());
 			}else{
 				publish.setIndexId(pIndexId+"_"+pId);
 			}
 		}
 		//绵竹造特殊处理
 		Integer resType = publish.getResType();
 		if(ResTypeEnum.mianzhuzao.getCode().compareTo(resType)==0){
 			publish.setResValue("999");
 		}
		publishMapper.insert(publish);
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Date currDate = new Date();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), currDate,publish.getId(), "新增栏目信息"));		
	}

	@Override
	public void update(Publish publish) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Date currDate = new Date();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), currDate,publish.getId(), "更新栏目信息"));	
		//设置indexId
 		if(publish != null && publish.getPid() != null){
 			Integer pId = publish.getPid();
 			String pIndexId = "";
 			if(pId != null){
 				pIndexId = publishMapper.selectByPrimaryKey(pId).getIndexId();
 			}
 			if(pIndexId== null || pIndexId.isEmpty()){
 				publish.setIndexId(pId.toString());
 			}else{
 				publish.setIndexId(pIndexId+"_"+pId);
 			}
 		}
 		//绵竹造特殊处理
 		Integer resType = publish.getResType();
 		if(ResTypeEnum.mianzhuzao.getCode().compareTo(resType)==0){
 			publish.setResValue("999");
 		}
		publishMapper.updateByPrimaryKeyWithBLOBs(publish);
	}

	@Override
	public void delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除栏目信息"));
		}
		PublishExample de=new PublishExample();
		de.createCriteria().andIdIn(ids);
		publishMapper.deleteByExample(de);
	}
	
	@Override
	public Publish queryById(Integer id){
		return publishMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public PublishLtResp queryList(PublishReq req) throws Exception {
		Integer id = req.getId();
		Integer pid = req.getPid();
		String name = req.getName();
		Integer resType = req.getResType();
		String href = req.getHref();
		PublishExample de=new PublishExample();
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
		if(!ValidateUtil.isEmpty(resType)){
			c.andResTypeEqualTo(resType);
		}
		if(!ValidateUtil.isEmpty(href)){
			c.andHrefEqualTo(href);
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<Publish> page = (Page<Publish>) publishMapper.selectByExampleWithBLOBs(de);
		List<Publish> list = page.getResult();
		//构造category数组[祖父id,父id,id]
		for (Publish publish : list) {
			Integer resType_ = publish.getResType();
			if(ResTypeEnum.wenzhang.getCode().compareTo(resType_) == 0){
				Integer categoryId = Integer.valueOf(publish.getResValue());
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
					publish.setArticleCategorys(categorys);
				}else{
					publish.setArticleCategorys(new Integer[0]);
				}
			}else{
				publish.setArticleCategorys(new Integer[0]);
			}
		}

		PublishLtResp resp = new PublishLtResp();
		resp.setCount(page.getTotal());
		resp.setPublishLt(list);
		return resp;
	}
	
	@Override
	public List<PublishResp> queryAllList(PublishReq req) throws Exception {
		Integer id = req.getId();
		Integer pid = req.getPid();
		String name = req.getName();
		Integer resType = req.getResType();
		String href = req.getHref();
		PublishExample de=new PublishExample();
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
		if(!ValidateUtil.isEmpty(resType)){
			c.andResTypeEqualTo(resType);
		}
		if(!ValidateUtil.isEmpty(href)){
			c.andHrefEqualTo(href);
		}
		List<Publish> list = publishMapper.selectByExampleWithBLOBs(de);
		if(!ValidateUtil.isEmpty(list)){
			PublishExample example = new PublishExample();
			example.createCriteria().andIndexIdLike(id+"%");
			list.addAll(publishMapper.selectByExampleWithBLOBs(example));
		}
		//构造category数组[祖父id,父id,id]
		for (Publish publish : list) {
			Integer resType_ = publish.getResType();
			if(ResTypeEnum.wenzhang.getCode().compareTo(resType_) == 0){
				Integer categoryId = Integer.valueOf(publish.getResValue());
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
					publish.setArticleCategorys(categorys);
				}else{
					publish.setArticleCategorys(new Integer[0]);
				}
			}else{
				publish.setArticleCategorys(new Integer[0]);
			}
		}
		return convertPublishLt(list);
	}
	
	/**
	 * 转换为树形列表
	 * @param publishLt
	 * @return
	 * @throws Exception
	 */
	private List<PublishResp> convertPublishLt(List<Publish> publishLt) throws Exception {
		List<PublishResp> categoryData = new ArrayList<PublishResp>();
		for(Publish publish:publishLt){
			if(ValidateUtil.isEmpty(publish.getPid())){
				PublishResp item = new PublishResp();
				BeanUtils.copyProperties(publish, item);
				item.setChildren(this.tree(publishLt, publish.getId()));
				categoryData.add(item);
			}
		}
		return categoryData;
	}
	
	private List<PublishResp> tree(List<Publish> publishLt,Integer id){
		List<PublishResp> resp = new ArrayList<>();
		for(Publish sub:publishLt){
			if(id.equals(sub.getPid())){
				PublishResp subitem = new PublishResp();
				BeanUtils.copyProperties(sub, subitem);
				List<PublishResp> respLt = this.tree(publishLt, sub.getId());
				//组装图片列表
				List<ImageVo> images = new ArrayList<ImageVo>();
				if(!ValidateUtil.isEmpty(respLt)){
					PublishResp res = respLt.get(0);
					if(ResTypeEnum.tupian.getCode().compareTo(res.getResType())==0){
						for (PublishResp publishResp2 : respLt) {
							ImageVo vo = new ImageVo();
							vo.setUrl(publishResp2.getHref());
							vo.setImg(publishResp2.getResValue());
							images.add(vo);
						}
					}
				}
				if(!ValidateUtil.isEmpty(respLt)){
					subitem.setChildren(respLt);
				}
				if(!ValidateUtil.isEmpty(images)){
					subitem.setImages(images);
				}
				resp.add(subitem);
			}
		}
		return resp;
	}
	
}
