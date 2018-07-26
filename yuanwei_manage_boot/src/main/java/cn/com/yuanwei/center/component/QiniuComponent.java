package cn.com.yuanwei.center.component;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.yuanwei.center.config.SysConfig;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
/**
 * Title:QiniuComponent
 * Desc:七牛组件
 * @author sky
 * @date 2017年3月16日  下午4:15:11
 */
@Component
public class QiniuComponent {
	 private Log logger =  LogFactory.getLog(this.getClass());
	 @Autowired
	 private SysConfig sysConfig;
	 
	 private  UploadManager uploadManager;
	
	public QiniuComponent(){
		this.uploadManager = new UploadManager();
	}
	/**
	 * Desc:获取上传凭证
	 * @param @return
	 * @return String
	 * @author sky
	 * @date 2017年3月16日  下午4:14:34
	 */
	public String getUpToken() {
		logger.info("开始获取上传token");
		Auth auth = Auth.create(sysConfig.getQiniuAk(), sysConfig.getQiniuSk());
		String upToken = auth.uploadToken(sysConfig.getQiniuImgBucket());
		logger.info("结束获取上传token,token内容:" + upToken);
		return upToken;
	}
	/**
	 * Desc:上传操作
	 * @param @param data
	 * @param @param key
	 * @param @param upToken
	 * @param @throws Exception
	 * @return void
	 * @author sky
	 * @date 2017年3月16日  下午4:14:47
	 */
	public void upload(byte[] data, String key, String upToken) throws Exception{
		  try {
		        Response res = uploadManager.put(data, key, upToken);
		         logger.info(res);
		        logger.info(res.bodyString());
		        if(res.isOK()){
		            logger.info("上传成功");
		        }else {
		            logger.error("上传失败");
		            throw new Exception("上传失败");
		        }
		    } catch (QiniuException e) {
		        Response r = e.response;
		        // 请求失败时简单状态信息
		        logger.error(r.toString());
		        
		        try {
		            // 响应的文本信息
		        	logger.error(r.bodyString());
		        } catch (QiniuException e1) {
		            //ignore
		        }
		        throw e;
		    }
		}
}
