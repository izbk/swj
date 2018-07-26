package cn.com.yuanwei.center.treadLocal;

import cn.com.yuanwei.center.redis.po.UserInfo;

public class LoginUserThread {
	private static ThreadLocal<UserInfo> userTh = new ThreadLocal<UserInfo>();
	private static ThreadLocal<String> voucherTh = new ThreadLocal<String>();
	private static ThreadLocal<Integer> sourceTh = new ThreadLocal<Integer>();
	  
    public static void setUser(UserInfo userInfo) {  
    	userTh.set(userInfo);  
    }  
  
    public static UserInfo getUser() {  
        return userTh.get();  
    }  
    public static void setVoucher(String voucher) {  
    	voucherTh.set(voucher);  
    }  
  
    public static String getVoucher() {  
        return voucherTh.get();  
    }  
    
    public static void setSource(Integer source){
    	sourceTh.set(source);
    }
    
    public static Integer getSource(){
    	return sourceTh.get();
    }
    
}
