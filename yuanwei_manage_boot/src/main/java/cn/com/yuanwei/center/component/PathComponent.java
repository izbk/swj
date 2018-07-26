package cn.com.yuanwei.center.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.yuanwei.center.config.SysConfig;
import cn.com.yuanwei.center.util.DateUtils;
import cn.com.yuanwei.center.util.ValidateUtil;

/**
 * 路径组装
 * 
 * @author sky
 *
 */
@Component
public class PathComponent {
	@Autowired
	 private SysConfig sysConfig;
	/**
	 * 获取下载全路径
	 * 
	 * @param path
	 * @return
	 */
	public String getDownloadURL(String dbFileName) {
		return ValidateUtil.isEmpty(dbFileName)?null:new StringBuilder(this.getDownloadPrefix()).append(dbFileName).toString();

	}
	
	/**
	 * 获取下载前路径
	 * 
	 * @param path
	 * @return
	 */
	public String getDownloadPrefix() {
		return new StringBuilder(sysConfig.getImgServer())
			.append(sysConfig.getImgPrefix()).toString();

	}
	
	/**
	 * 获取上传文件路径
	 * 
	 * @param path
	 * @return
	 */
	public String getUploadURL(String dbFileName) {
		return new StringBuilder(sysConfig.getImgPrefix()).append(dbFileName).toString();
	}
	
	/**
	 * 获取数据库文件路径
	 * 
	 * @param path
	 * @return
	 */
	public String getDbURL(String fileName) {
		String formatDate = DateUtils.formatDate();
		return new StringBuilder(formatDate).append("/").append(fileName).toString();
	}
	
}