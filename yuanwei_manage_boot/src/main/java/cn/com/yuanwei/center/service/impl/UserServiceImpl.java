package cn.com.yuanwei.center.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.yuanwei.center.entity.Menu;
import cn.com.yuanwei.center.entity.ServiceLogs;
import cn.com.yuanwei.center.entity.User;
import cn.com.yuanwei.center.entity.UserExample;
import cn.com.yuanwei.center.entity.UserExample.Criteria;
import cn.com.yuanwei.center.entity.UserVo;
import cn.com.yuanwei.center.enums.IsEnum;
import cn.com.yuanwei.center.enums.ReturnInfoEnum;
import cn.com.yuanwei.center.enums.SourceEnum;
import cn.com.yuanwei.center.mapper.ServiceLogsMapper;
import cn.com.yuanwei.center.mapper.UserMapper;
import cn.com.yuanwei.center.redis.po.UserInfo;
import cn.com.yuanwei.center.redis.service.impl.OnLineService;
import cn.com.yuanwei.center.service.MenuService;
import cn.com.yuanwei.center.service.UserService;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.util.MD5Tools;
import cn.com.yuanwei.center.util.UUIDUtils;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.ChangePwdReq;
import cn.com.yuanwei.center.web.request.LoginReq;
import cn.com.yuanwei.center.web.request.UserReq;
import cn.com.yuanwei.center.web.response.GetAuthResp;
import cn.com.yuanwei.center.web.response.MenuResp;
import cn.com.yuanwei.center.web.response.UserLtResp;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private ServiceLogsMapper serviceLogsMapper;
	@Autowired
	private MenuService menuService;
	@Autowired
	private OnLineService onLineService;
	
	/**
	 * Desc:登陆
	 * @author sky
	 * @date 2017年4月13日  下午7:59:39
	 */
	@Override
	public GetAuthResp getAuth(LoginReq req) throws Exception {
		String name = req.getUsername().trim();
		String pwd = req.getPassword().trim();
		Integer source = LoginUserThread.getSource();
		//返回用户对象
		User userInfo = new User();
		//生成密码密文
		String enPwd = MD5Tools.MD5(name+pwd);
		//返回报文
		GetAuthResp resp = new GetAuthResp();
		UserExample ue = new UserExample();
		ue.createCriteria().andLoginNameEqualTo(name).andPwdEqualTo(enPwd).andIsDelEqualTo(IsEnum.no.getCode()).andStatusEqualTo(1);
		List<User> userLt = userMapper.selectByExample(ue);
		//判断用户是否存在
		if(ValidateUtil.isEmpty(userLt)){
			throw new Exception(ReturnInfoEnum.LoginFail.toString());
		}else{
			userInfo = userLt.get(0);
		}

		//登陆
		StringBuffer sbBuffer = new StringBuffer();
		sbBuffer.append(name);
		sbBuffer.append(source);
		sbBuffer.append(UUIDUtils.getUUID());
		//生成登陆凭证
		String voucher = MD5Tools.MD5(sbBuffer.toString());
		UserInfo userRedis = new UserInfo();
		BeanUtils.copyProperties(userInfo, userRedis);
		//redis保存用户信息
		boolean addFlag = onLineService.add(voucher, userRedis, SourceEnum.getDesc(source));
		if (!addFlag) {
			throw new Exception(ReturnInfoEnum.RedisSaveFail.toString());
		}
		//记录日志
		ServiceLogs log = new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(), "登录成功");
		serviceLogsMapper.insertSelective(log);
		
		resp.setVoucher(voucher);
		resp.setUserInfo(userInfo);
		return resp;
	}
	/**
	 * Desc:注销
	 * @author sky
	 * @date 2017年4月13日  下午7:59:50
	 */
	@Override
	public void deleteAuth(String voucher, String source) throws Exception {
		onLineService.remove(voucher, source);
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		ServiceLogs log = new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(), "注销成功");
		serviceLogsMapper.insertSelective(log);
	}
	@Override
	public UserLtResp getUserLt(UserReq req) throws Exception {
		Integer id = req.getId();
		Integer roleId = req.getRoleId();
		Integer pid = req.getPid();
		String mobilePhone = req.getMobilePhone();
		String loginName = req.getLoginName();
		String nickName = req.getNickName();
		String email = req.getEmail();
		String pwd = req.getPwd();
		String pic = req.getPic();
		String indexId = req.getIndexId();
		Integer point = req.getPoint();
		Integer source = req.getSource();
		String levelName = req.getLevelName();
		Integer level = req.getLevel();
		Integer status = req.getStatus();
		Integer isDel = req.getIsDel();
		Date regTime = req.getRegTime();
		Integer townshipId = req.getTownshipId();
		Integer departId = req.getDepartId();
		String openId = req.getOpenId();
		String isSend = req.getIsSend();
		UserExample de=new UserExample();
		Criteria c = de.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(roleId)){
			c.andRoleIdEqualTo(roleId);
		}
		if(!ValidateUtil.isEmpty(pid)){
			c.andPidEqualTo(pid);
		}
		if(!ValidateUtil.isEmpty(mobilePhone)){
			c.andMobilePhoneEqualTo(mobilePhone);
		}
		if(!ValidateUtil.isEmpty(loginName)){
			c.andLoginNameLike("%"+loginName+"%");
		}
		if(!ValidateUtil.isEmpty(nickName)){
			c.andNickNameLike("%"+nickName+"%");
		}
		if(!ValidateUtil.isEmpty(email)){
			c.andEmailEqualTo(email);
		}
		if(!ValidateUtil.isEmpty(pwd)){
			c.andPwdEqualTo(pwd);
		}
		if(!ValidateUtil.isEmpty(pic)){
			c.andPicEqualTo(pic);
		}
		if(!ValidateUtil.isEmpty(indexId)){
			c.andIndexIdEqualTo(indexId);
		}
		if(!ValidateUtil.isEmpty(point)){
			c.andPointEqualTo(point);
		}
		if(!ValidateUtil.isEmpty(source)){
			c.andSourceEqualTo(source);
		}
		if(!ValidateUtil.isEmpty(levelName)){
			c.andLevelNameLike("%"+levelName+"%");
		}
		if(!ValidateUtil.isEmpty(level)){
			c.andLevelEqualTo(level);
		}
		if(!ValidateUtil.isEmpty(status)){
			c.andStatusEqualTo(status);
		}
		if(!ValidateUtil.isEmpty(isDel)){
			c.andIsDelEqualTo(isDel);
		}
		if(!ValidateUtil.isEmpty(regTime)){
			c.andRegTimeEqualTo(regTime);
		}
		if(!ValidateUtil.isEmpty(townshipId)){
			c.andTownshipIdEqualTo(townshipId);
		}
		if(!ValidateUtil.isEmpty(departId)){
			c.andDepartIdEqualTo(departId);
		}
		if(!ValidateUtil.isEmpty(openId)){
			c.andOpenIdEqualTo(openId);
		}
		//排序
		if(ValidateUtil.isEmpty(req.getOrderby())){
			de.setOrderByClause("REG_TIME DESC");
		}else{
			de.setOrderByClause(req.getOrderby()+" "+req.getSort());
		}
		//设置删除标志为"未删除"
		c.andIsDelEqualTo(IsEnum.no.getCode());
		//发送模板消息增加openID不为空条件，返回结果不分页
		if(!ValidateUtil.isEmpty(isSend)){
			c.andOpenIdIsNotNull();
			List<User> users = userMapper.selectByExample(de);
			UserLtResp resp = new UserLtResp();
			resp.setCount(new Long(users.size()));
			resp.setUserLt(users);
			return resp;
		}else{
			PageHelper.startPage(req.getPage(),req.getItemcount());
			Page<User> page = (Page<User>) userMapper.selectByExample(de);
			UserLtResp resp = new UserLtResp();
			resp.setCount(page.getTotal());
			resp.setUserLt(page.getResult());
			return resp;
		}

	}
	/**
	 * Desc:更新用户
	 * @author sky
	 * @date 2017年4月13日  下午8:00:24
	 */
	@Override
	public void updateUser(User user) throws Exception {
		if(!ValidateUtil.isEmpty(user.getLoginName())){
			UserExample ue = new UserExample();
			ue.createCriteria().andLoginNameEqualTo(user.getLoginName().trim()).andIsDelEqualTo(IsEnum.no.getCode());
			List<User> userLoginName = userMapper.selectByExample(ue);
			if(!ValidateUtil.isEmpty(userLoginName)){
				for(User u:userLoginName){
					if(!u.getId().equals(user.getId())){
						throw new Exception("登陆名称重复!");
					}
				}
			}
		}
		userMapper.updateByPrimaryKey(user);
	}
	/**
	 * Desc:新建用户
	 * @author sky
	 * @date 2017年4月13日  下午8:00:34
	 */
	@Override
	public void createUser(User user) throws Exception {
		if(!ValidateUtil.isEmpty(user.getLoginName())){
			UserExample ue = new UserExample();
			ue.createCriteria().andLoginNameEqualTo(user.getLoginName().trim()).andIsDelEqualTo(IsEnum.no.getCode());
			List<User> userLoginName = userMapper.selectByExample(ue);
			if(!ValidateUtil.isEmpty(userLoginName)){
				throw new Exception("登陆名称重复!");
			}
		}
		user.setSource(SourceEnum.manage.getCode());
		user.setRegTime(new Date());
		user.setPwd(MD5Tools.MD5(user.getLoginName()+"123456"));
		userMapper.insert(user);
	}
	
	/**
	 * Desc:删除用户
	 * @author sky
	 * @date 2017年4月13日  下午8:00:43
	 */
	@Override
	public void delUser(List<Integer> req) throws Exception {
		UserExample ue = new UserExample();
		ue.createCriteria().andIdIn(req);
		User delUser = new User();
		delUser.setIsDel(IsEnum.yes.getCode());
		userMapper.updateByExampleSelective(delUser, ue);
	}
	/**
	 * Desc:获取用户菜单权限
	 * @author sky
	 * @date 2017年4月13日  下午8:00:52
	 */
	@Override
	public List<MenuResp> getUserMenu() throws Exception {
		Integer roleId = LoginUserThread.getUser().getRoleId();
		//获取角色菜单
		List<Menu> roleMenus = menuService.getRoleMenus(roleId);
		if(ValidateUtil.isEmpty(roleMenus)){
			throw new Exception("该用户没有权限,请联系管理员！");
		}
		//转换为父子对象
		List<MenuResp> resp = menuService.convertMenuLt(roleMenus);
		return resp;
	}
	
	@Override
	public User bindWechat(String openId,Integer userId) throws Exception {
		User user = userMapper.selectByPrimaryKey(userId);
		user.setOpenId(openId);
		userMapper.updateByPrimaryKey(user);
		return user;
	}
	
	@Override
	public void changePasswd(ChangePwdReq req) throws Exception {
		UserInfo userInfo = LoginUserThread.getUser();
		User user = userMapper.selectByPrimaryKey(userInfo.getId());
		String pwd = user.getPwd();
		String newPwd = req.getNewPwd();
		String confirmPwd = req.getConfirmPwd();
		if(!newPwd.equals(confirmPwd)){
			throw new Exception("新密码与确认密码不一致!!");
		}
		String oldPwd = MD5Tools.MD5(user.getLoginName()+req.getOldPwd());
		if(!pwd.equals(oldPwd)){
			throw new Exception("原密码不正确!");
		}
		//修改密码
		String calcNewPwd = MD5Tools.MD5(user.getLoginName()+confirmPwd);
		user.setPwd(calcNewPwd);
		userMapper.updateByPrimaryKey(user);
		onLineService.remove(LoginUserThread.getVoucher(), SourceEnum.manage.getDesc());
		//记录日志
		ServiceLogs log = new ServiceLogs(user.getId(), user.getNickName(), new Date(), "修改密码成功");
		serviceLogsMapper.insertSelective(log);
	}
	@Override
	public void resetPasswd(Integer id) throws Exception {
		if(ValidateUtil.isEmpty(id)){
			throw new Exception("用户ID为空!");
		}
		User user = userMapper.selectByPrimaryKey(id);
		if(ValidateUtil.isEmpty(user)){
			throw new Exception("未获取到用户相关信息!");
		}
		//重置密码
		String calcNewPwd = MD5Tools.MD5(user.getLoginName()+"123456");
		user.setPwd(calcNewPwd);
		userMapper.updateByPrimaryKey(user);
		//记录日志
		UserInfo userInfo = LoginUserThread.getUser();
		ServiceLogs log = new ServiceLogs(userInfo.getId(), userInfo.getNickName(), new Date(),user.getId(), "重置人员["+user.getLoginName()+"]密码成功");
		serviceLogsMapper.insertSelective(log);
	}
	@Override
	public List<UserVo> queryForExport(UserReq req) throws Exception {
		Integer id = req.getId();
		Integer roleId = req.getRoleId();
		Integer pid = req.getPid();
		String mobilePhone = req.getMobilePhone();
		String loginName = req.getLoginName();
		String nickName = req.getNickName();
		String email = req.getEmail();
		String pwd = req.getPwd();
		String pic = req.getPic();
		String indexId = req.getIndexId();
		Integer point = req.getPoint();
		Integer source = req.getSource();
		String levelName = req.getLevelName();
		Integer level = req.getLevel();
		Integer status = req.getStatus();
		Integer isDel = req.getIsDel();
		Date regTime = req.getRegTime();
		Integer townshipId = req.getTownshipId();
		Integer departId = req.getDepartId();
		String openId = req.getOpenId();
		UserExample de=new UserExample();
		Criteria c = de.createCriteria();
		if(!ValidateUtil.isEmpty(id)){
			c.andIdEqualTo(id);
		}
		if(!ValidateUtil.isEmpty(roleId)){
			c.andRoleIdEqualTo(roleId);
		}
		if(!ValidateUtil.isEmpty(pid)){
			c.andPidEqualTo(pid);
		}
		if(!ValidateUtil.isEmpty(mobilePhone)){
			c.andMobilePhoneEqualTo(mobilePhone);
		}
		if(!ValidateUtil.isEmpty(loginName)){
			c.andLoginNameLike("%"+loginName+"%");
		}
		if(!ValidateUtil.isEmpty(nickName)){
			c.andNickNameLike("%"+nickName+"%");
		}
		if(!ValidateUtil.isEmpty(email)){
			c.andEmailEqualTo(email);
		}
		if(!ValidateUtil.isEmpty(pwd)){
			c.andPwdEqualTo(pwd);
		}
		if(!ValidateUtil.isEmpty(pic)){
			c.andPicEqualTo(pic);
		}
		if(!ValidateUtil.isEmpty(indexId)){
			c.andIndexIdEqualTo(indexId);
		}
		if(!ValidateUtil.isEmpty(point)){
			c.andPointEqualTo(point);
		}
		if(!ValidateUtil.isEmpty(source)){
			c.andSourceEqualTo(source);
		}
		if(!ValidateUtil.isEmpty(levelName)){
			c.andLevelNameLike("%"+levelName+"%");
		}
		if(!ValidateUtil.isEmpty(level)){
			c.andLevelEqualTo(level);
		}
		if(!ValidateUtil.isEmpty(status)){
			c.andStatusEqualTo(status);
		}
		if(!ValidateUtil.isEmpty(isDel)){
			c.andIsDelEqualTo(isDel);
		}
		if(!ValidateUtil.isEmpty(regTime)){
			c.andRegTimeEqualTo(regTime);
		}
		if(!ValidateUtil.isEmpty(townshipId)){
			c.andTownshipIdEqualTo(townshipId);
		}
		if(!ValidateUtil.isEmpty(departId)){
			c.andDepartIdEqualTo(departId);
		}
		if(!ValidateUtil.isEmpty(openId)){
			c.andOpenIdEqualTo(openId);
		}
		//排序
		if(ValidateUtil.isEmpty(req.getOrderby())){
			de.setOrderByClause("REG_TIME DESC");
		}else{
			de.setOrderByClause(req.getOrderby()+" "+req.getSort());
		}
		//设置删除标志为"未删除"
		c.andIsDelEqualTo(IsEnum.no.getCode());
		return userMapper.selectByExampleForExport(de);
	}
	
	
	
}
