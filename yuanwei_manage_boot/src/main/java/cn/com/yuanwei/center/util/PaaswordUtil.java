package cn.com.yuanwei.center.util;

import java.util.Random;
/**
 * 字母密码工具类
 * <功能详细描述>
 * 
 * @author  yu
 */
public class PaaswordUtil {
	private static String [] genkey ={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	private static String [] gennum = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	private static String [] genup = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	private static String [] gendown = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	private static String [] num = {"1","2","3","4","5","6","7","8","9","0"};
	public static String genPwd(int length)
	{
		StringBuffer sb = new StringBuffer();
		Random  random = new Random();
		sb.append(gendown[random.nextInt(gendown.length)]);
		sb.append(genup[random.nextInt(genup.length)]);
		sb.append(gennum[random.nextInt(gennum.length)]);
		for (int i = 3; i < length; i++) {
			sb.append(genkey[random.nextInt(genkey.length)]);
		}
		return sb.toString();
	}
	
	
	
	public static String genNumPwd(int length)
	{
		StringBuffer sb = new StringBuffer();
		Random  random = new Random();
		sb.append(num[random.nextInt(num.length)]);
		sb.append(num[random.nextInt(num.length)]);
		sb.append(num[random.nextInt(num.length)]);
		for (int i = 3; i < length; i++) {
			sb.append(num[random.nextInt(num.length)]);
		}
		return sb.toString();
	}
	
	
	
	
/*	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println(genPwd(16));
		}
	}*/
}
