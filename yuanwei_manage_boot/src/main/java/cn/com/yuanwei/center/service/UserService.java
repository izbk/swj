package cn.com.yuanwei.center.service;

import java.util.List;

import cn.com.yuanwei.center.entity.User;
import cn.com.yuanwei.center.entity.UserVo;
import cn.com.yuanwei.center.web.request.ChangePwdReq;
import cn.com.yuanwei.center.web.request.LoginReq;
import cn.com.yuanwei.center.web.request.UserReq;
import cn.com.yuanwei.center.web.response.GetAuthResp;
import cn.com.yuanwei.center.web.response.MenuResp;
import cn.com.yuanwei.center.web.response.UserLtResp;



public interface UserService {
	public GetAuthResp getAuth(LoginReq req) throws Exception;
	public void deleteAuth(String voucher,String source) throws Exception;
	public UserLtResp getUserLt(UserReq req) throws Exception;
	public void updateUser(User user) throws Exception;
	public void changePasswd(ChangePwdReq req) throws Exception;
	public void resetPasswd(Integer id) throws Exception;
	public void createUser(User user) throws Exception;
	public void delUser(List<Integer> req) throws Exception;
	public List<MenuResp> getUserMenu() throws Exception;
	
	public User bindWechat(String openId,Integer userId) throws Exception;
	public List<UserVo> queryForExport(UserReq req) throws Exception;
}
