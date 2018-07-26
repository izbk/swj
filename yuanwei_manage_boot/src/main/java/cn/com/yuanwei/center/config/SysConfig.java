package cn.com.yuanwei.center.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="sysConfig")
public class SysConfig {
	private String qiniuAk;
	private String qiniuSk;
	private String qiniuImgBucket;
	private String imgServer;
	private String imgPrefix;
	private String frontServer;
	private String adminServer;
	private String endpoint;
	private String accessKeyId;
	private String accessKeySecret;
	private String bucketName;
	private String diskName;
	
	public String getQiniuAk() {
		return qiniuAk;
	}
	public void setQiniuAk(String qiniuAk) {
		this.qiniuAk = qiniuAk;
	}
	public String getQiniuSk() {
		return qiniuSk;
	}
	public void setQiniuSk(String qiniuSk) {
		this.qiniuSk = qiniuSk;
	}
	public String getQiniuImgBucket() {
		return qiniuImgBucket;
	}
	public void setQiniuImgBucket(String qiniuImgBucket) {
		this.qiniuImgBucket = qiniuImgBucket;
	}
	public String getImgServer() {
		return imgServer;
	}
	public void setImgServer(String imgServer) {
		this.imgServer = imgServer;
	}
	public String getImgPrefix() {
		return imgPrefix;
	}
	public void setImgPrefix(String imgPrefix) {
		this.imgPrefix = imgPrefix;
	}
	public String getFrontServer() {
		return frontServer;
	}
	public void setFrontServer(String frontServer) {
		this.frontServer = frontServer;
	}
	public String getAdminServer() {
		return adminServer;
	}
	public void setAdminServer(String adminServer) {
		this.adminServer = adminServer;
	}
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	public String getAccessKeyId() {
		return accessKeyId;
	}
	public void setAccessKeyId(String accessKeyId) {
		this.accessKeyId = accessKeyId;
	}
	public String getAccessKeySecret() {
		return accessKeySecret;
	}
	public void setAccessKeySecret(String accessKeySecret) {
		this.accessKeySecret = accessKeySecret;
	}
	public String getBucketName() {
		return bucketName;
	}
	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}
	public String getDiskName() {
		return diskName;
	}
	public void setDiskName(String diskName) {
		this.diskName = diskName;
	}
	
}
