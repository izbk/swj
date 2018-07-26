package cn.com.yuanwei.center.service.impl;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.com.yuanwei.center.entity.ArticleType;
import cn.com.yuanwei.center.entity.ArticleTypeExample;
import cn.com.yuanwei.center.entity.ArticleTypeExample.Criteria;
import cn.com.yuanwei.center.mapper.ArticleTypeMapper;
import cn.com.yuanwei.center.service.ArticleTypeService;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.ArticleTypeReq;
import cn.com.yuanwei.center.web.response.ArticleTypeLtResp;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;

@Service
@Transactional
public class ArticleTypeServiceImpl implements ArticleTypeService {
	@Autowired
	private ArticleTypeMapper articleTypeMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	
	@Override
	public Integer save(ArticleType articleType) throws Exception {
		articleTypeMapper.insert(articleType);
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),articleType.getId(), "新增文章类型"));		
		return articleType.getId();
	}

	@Override
	public Integer update(ArticleType articleType) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		serviceLogsMapper.insertSelective(new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),articleType.getId(), "更新文章类型"));
		return articleTypeMapper.updateByPrimaryKey(articleType);
	}

	@Override
	public Integer delete(List<Integer> ids) throws Exception {
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		Integer userId = userInfo.getId();
		String userName = userInfo.getNickName();
		Date date = new Date();
		for (Integer id : ids) {
			serviceLogsMapper.insertSelective(new ServiceLogs(userId, userName, date, id, "删除文章类型"));
		}
		ArticleTypeExample example = new ArticleTypeExample();
		example.createCriteria().andIdIn(ids);
		return articleTypeMapper.deleteByExample(example);
	}
	
	@Override
	public ArticleType queryById(Integer id){
		return articleTypeMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public ArticleTypeLtResp queryList(ArticleTypeReq req) throws Exception {
		Integer id = req.getId();
		Integer pid = req.getPid();
		String name = req.getName();
		String indexId = req.getIndexId();
		String remark = req.getRemark();
		ArticleTypeExample example = new ArticleTypeExample();
		Criteria c = example.createCriteria();
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
		if(!ValidateUtil.isEmpty(remark)){
			c.andRemarkEqualTo(remark);
		}
		PageHelper.startPage(req.getPage(),req.getItemcount());
		Page<ArticleType> page = (Page<ArticleType>) articleTypeMapper.selectByExample(example);
		ArticleTypeLtResp resp = new ArticleTypeLtResp();
		resp.setCount(page.getTotal());
		resp.setArticleTypeLt(page.getResult());
		return resp;
	}
	
}
