package cn.com.yuanwei.center.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSONObject;

import cn.com.yuanwei.center.component.OssComponent;
import cn.com.yuanwei.center.component.PathComponent;
import cn.com.yuanwei.center.component.QiniuComponent;
import cn.com.yuanwei.center.util.DateUtils;
import cn.com.yuanwei.center.util.PaaswordUtil;

/** 上传. */
@Controller
@RequestMapping("/upload")
public class UploadController {
	private Log logger =  LogFactory.getLog(this.getClass());
	@Autowired
	private PathComponent pathComponent;
	@Autowired
	private QiniuComponent qiniuComponent;
	@Autowired
	private OssComponent ossComponent;
	/**
	 * ueditor上传图片.
	 * 
	 * @throws IOException
	 */
	@RequestMapping(params = "upimg")
	@ResponseBody
	public JSONObject img(HttpServletRequest request,
			HttpServletResponse response, String action, String noCache,
			String encode) throws IOException {
		JSONObject jsStr = new JSONObject();
		if ("config".equals(action)) {
			InputStream is = UploadController.class
					.getResourceAsStream("/config.json");
			BufferedReader bf = new BufferedReader(new InputStreamReader(is,
					"UTF-8"));
			// 最好在将字节流转换为字符流的时候 进行转码
			StringBuffer buffer = new StringBuffer();
			String line = "";
			while ((line = bf.readLine()) != null) {
				buffer.append(line);
			}
			response.setContentType("application/json");
			response.setHeader("Cache-Control", "no-store");
			jsStr = JSONObject.parseObject(buffer.toString());
			return jsStr;
		}
		if ("uploadimage".equals(action)) {
			// 获取request里的upfile
			MultipartHttpServletRequest uploadRequest = (MultipartHttpServletRequest) request;
			MultiValueMap<String, MultipartFile> map = uploadRequest
					.getMultiFileMap();
			List<MultipartFile> files = map.get("upfile");
			MultipartFile file = files.get(0);
			String suffix = file.getOriginalFilename().substring(
					file.getOriginalFilename().lastIndexOf("."));
			
			String fileName = new StringBuilder("product_pic_")
					.append(DateUtils.getMillis()).append("_")
					.append(PaaswordUtil.genPwd(4)).append(suffix).toString();
			
			String dbFileName = pathComponent.getDbURL(fileName);
			
			try {
				qiniuComponent.upload(file.getBytes(), pathComponent.getUploadURL(dbFileName),
						qiniuComponent.getUpToken());
				String url = pathComponent.getDownloadURL(dbFileName);
				jsStr.put("url", url);
				jsStr.put("state", "SUCCESS");
				jsStr.put("title", url.substring(url.lastIndexOf("/") + 1));
				jsStr.put("size", files.get(0).getBytes().length);
				return jsStr;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			return null;
		}
		return null;
	}

	/**
	 * 上传课程封面图片图.
	 * 
	 * @throws IOException
	 **/
	/*
	 * @RequestMapping("/uploadPic3")
	 * 
	 * @ResponseBody public Map<?, ?> uploadPic3(@CookieValue(required=false)
	 * String ssid, @RequestParam("files[]") MultipartFile files) throws
	 * IOException { Map<String, Object> req = new HashMap<>(); byte[] bytes =
	 * files.getBytes(); //req.put("sid", ssid); req.put("sid",""); if
	 * (bytes.length > 0) { req.put("bytes", bytes); } Map<?, ?> data =
	 * Center.getRsp("user/uploadPic3Cms", req); return data; }
	 */

	/**
	 * 上传图片.
	 * 
	 * @throws Exception
	 **/
	@PostMapping(value = "/uploadPic")
	@ResponseBody
	public JSONObject uploadPic(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "file") MultipartFile file) {
		JSONObject jsStr = new JSONObject();
		
		String suffix = file.getOriginalFilename().substring(
				file.getOriginalFilename().lastIndexOf("."));
		
		String fileName = new StringBuilder("product_pic_")
				.append(DateUtils.getMillis()).append("_")
				.append(PaaswordUtil.genPwd(4)).append(suffix).toString();
		
		String dbFileName = pathComponent.getDbURL(fileName);
		try {
//			qiniuComponent.upload(file.getBytes(), pathComponent.getUploadURL(dbFileName),
//					qiniuComponent.getUpToken());
			ossComponent.uploadObject2OSS(file.getInputStream(), dbFileName);
			System.out.println(ossComponent.getUrl(dbFileName));
			jsStr.put("success", true);
			jsStr.put("msg",   "成功上传！");
		} catch (Exception e) {
			logger.error("上传第三方出现异常！", e);
			jsStr.put("success", false);
			jsStr.put("msg", "上传失败！");
		}
		jsStr.put("url", pathComponent.getDownloadURL(dbFileName));
		jsStr.put("path", dbFileName);
		return jsStr;
	}
	
	/**
	 * 上传编辑器图片.
	 * @throws ServletException 
	 * @throws IOException 
	 * 
	 * @throws Exception
	 **/
	@PostMapping(value = "/uploadEditorPic")
	public void uploadEditorPic(HttpServletRequest request,
			HttpServletResponse response,@RequestParam(value = "wangEditorH5File") MultipartFile file) throws IOException, ServletException {
		String suffix = file.getOriginalFilename().substring(
				file.getOriginalFilename().lastIndexOf("."));
		// 文件类型限制
        String[] allowedType = { "image/bmp", "image/gif", "image/jpeg", "image/png" };
        boolean allowed = Arrays.asList(allowedType).contains(file.getContentType());
        if (!allowed) {
            response.getWriter().write("error|不支持的类型");
            return;
        }
     // 图片大小限制
        if (file.getSize() > 5 * 1024 * 1024) {
            response.getWriter().write("error|图片大小不能超过5M");
            return;
        }
        String fileName = new StringBuilder("editor_pic_")
		.append(DateUtils.getMillis()).append("_")
		.append(PaaswordUtil.genPwd(4)).append(suffix).toString();
        String dbFileName = pathComponent.getDbURL(fileName);
        try {
//			qiniuComponent.upload(file.getBytes(), pathComponent.getUploadURL(dbFileName),
//					qiniuComponent.getUpToken());
        	ossComponent.uploadObject2OSS(file.getInputStream(), dbFileName);
		} catch (Exception e) {
			logger.error("上传第三方出现异常！", e);
		}
        
        response.getWriter().write(pathComponent.getDownloadURL(dbFileName));

	}
}
