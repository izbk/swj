package cn.com.yuanwei.center.component;


import java.io.InputStream;
import java.net.URL;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;

import cn.com.yuanwei.center.config.SysConfig;
/**
 * Title:OssComponent
 * Desc:OSS组件
 * @author zbk
 * @date 2017年7月7日  下午4:15:11
 */
@Component
public class OssComponent {
	 private Log logger =  LogFactory.getLog(this.getClass());
	 @Autowired
	 private SysConfig sysConfig;
	 
	/**
	 * Desc:获取上传凭证
	 * @param @return
	 * @return String
	 * @author sky
	 * @date 2017年3月16日  下午4:14:34
	 */
	public OSSClient init() {
		return new OSSClient(sysConfig.getEndpoint(),sysConfig.getAccessKeyId(), sysConfig.getAccessKeySecret());
	}
	/**
	 * 向阿里云的OSS存储中存储文件  --file也可以用InputStream替代
	 * @param file 上传文件
	 * @param fileName 上传文件
	 * @return String 唯一MD5数字签名
	 * */
	public String uploadObject2OSS(InputStream inputStream, String fileName) {
		String resultStr = null;
		OSSClient client = init();
		try {
			//创建上传Object的Metadata
			ObjectMetadata metadata = new ObjectMetadata();
			metadata.setContentLength(inputStream.available());
			metadata.setCacheControl("no-cache");
			metadata.setHeader("Pragma", "no-cache");
			metadata.setContentEncoding("utf-8");
			metadata.setContentType(getContentType(fileName));
			metadata.setContentDisposition("filename=" + fileName);
			//上传文件 
			PutObjectResult putResult = client.putObject(sysConfig.getBucketName(), sysConfig.getDiskName() +"/"+ fileName, inputStream, metadata);
			//解析结果
			resultStr = putResult.getETag();
		} catch (Exception e) {
			logger.error("上传阿里云OSS服务器异常." + e.getMessage(), e);
		}finally{
			client.shutdown();
		}
		return resultStr;
	}
	 /**
	   * 获得url链接
	   *
	   * @param key
	   * @return
	   */
	  public String getUrl(String key) {
	    // 设置URL过期时间为10年  3600l* 1000*24*365*10
	    Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
	    // 生成URL
	    URL url = init().generatePresignedUrl(sysConfig.getBucketName(), key, expiration);
	    if (url != null) {
	      return url.toString();
	    }
	    return null;
	  }
    /** 
     * 通过文件名判断并获取OSS服务文件上传时文件的contentType 
     * @param fileName 文件名
     * @return 文件的contentType   
     */  
     public String getContentType(String fileName){  
    	String fileExtension = fileName.substring(fileName.lastIndexOf("."));
    	if("bmp".equalsIgnoreCase(fileExtension)) return "image/bmp";
    	if("gif".equalsIgnoreCase(fileExtension)) return "image/gif";
    	if("jpeg".equalsIgnoreCase(fileExtension) || "jpg".equalsIgnoreCase(fileExtension)  || "png".equalsIgnoreCase(fileExtension) ) return "image/jpeg";
    	if("html".equalsIgnoreCase(fileExtension)) return "text/html";
    	if("txt".equalsIgnoreCase(fileExtension)) return "text/plain";
    	if("vsd".equalsIgnoreCase(fileExtension)) return "application/vnd.visio";
    	if("ppt".equalsIgnoreCase(fileExtension) || "pptx".equalsIgnoreCase(fileExtension)) return "application/vnd.ms-powerpoint";
    	if("doc".equalsIgnoreCase(fileExtension) || "docx".equalsIgnoreCase(fileExtension)) return "application/msword";
    	if("xml".equalsIgnoreCase(fileExtension)) return "text/xml";
        return "text/html";  
     }
}
