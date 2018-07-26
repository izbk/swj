package cn.com.yuanwei.center.web;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.com.yuanwei.center.annotation.Auth;
import cn.com.yuanwei.center.entity.Article;
import cn.com.yuanwei.center.entity.Specialty;
import cn.com.yuanwei.center.enums.ArticleStatusEnum;
import cn.com.yuanwei.center.enums.AuditStatusEnum;
import cn.com.yuanwei.center.enums.IsPublicEnum;
import cn.com.yuanwei.center.service.ArticleService;
import cn.com.yuanwei.center.service.SpecialtyService;
import cn.com.yuanwei.center.util.ExcelUtils;
import cn.com.yuanwei.center.web.request.ArticleReq;
import cn.com.yuanwei.center.web.request.SpecialtyReq;
import cn.com.yuanwei.center.web.response.ArticleLtResp;
import cn.com.yuanwei.center.web.response.SpecialtyLtResp;
import cn.com.yuanwei.center.web.response.base.Result;
import cn.com.yuanwei.center.web.vo.ArticleVo;
import io.swagger.annotations.Api;

@Api(value = "article", description = "文章", produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
@RequestMapping("/articles")
public class ArticleController {
	Log logger = LogFactory.getLog(ArticleController.class);
	@Autowired
	private ArticleService articleService;
	@Autowired
	private SpecialtyService specialtyService;

	/**
	 * Desc: 新增处理
	 * @param req
	 * @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-05-16 11:11:22
	 */
	@Auth
	@PostMapping
	@ResponseBody
	public Result createArticle(@RequestBody Article req) throws Exception{
		Integer[] parents = req.getArticleCategorys();
		if(parents != null){
			Integer categoryId = parents[parents.length-1];
			req.setArticleCategory(categoryId);
		}
		articleService.save(req);
		return new Result();
	}
	/**
	 * Desc:编辑处理
	 * @param req
	 * @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-05-16 11:11:22
	 */
	@Auth
	@PutMapping
	@ResponseBody
	public Result editArticle(@RequestBody Article req) throws Exception{
		Integer[] parents = req.getArticleCategorys();
		if(parents != null){
			Integer categoryId = parents[parents.length-1];
			req.setArticleCategory(categoryId);
		}
		articleService.update(req);
		return new Result();
	}
	/**
	 * Desc:删除处理
	 * @param req
	 * @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-05-16 11:11:22
	 */
	@Auth
	@DeleteMapping
	@ResponseBody
	public Result delArticle(@RequestParam(value="ids") List<Integer> req) throws Exception{
		articleService.delete(req);
		return new Result();
	}
	/**
	 * Desc:查询列表
	 * @param req
	 * @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-05-16 11:11:22
	 */
	@GetMapping
	@ResponseBody
	@Auth
	public Result getArticleList(ArticleReq req,@RequestParam(value="articleCategorys[]",required=false) Integer[] articleCategorys) throws Exception{
		req.setCategorys(articleCategorys);
		ArticleLtResp resp= articleService.queryList(req);
		Result re = new Result(resp.getArticleLt());
		re.setCount(resp.getCount());
		return re;
	}
	/**
	 * Desc:查询详情
	 * @param req
	 * @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-05-16 11:11:22
	 */
	@GetMapping(value="id")
	@ResponseBody
	public Result getArticle(Integer id) throws Exception{
		Article article = articleService.queryById(id);
		Result re = new Result(article);
		re.setCount(1L);
		return re;
	}
	
	/**
	 * Desc:移动端查询列表
	 * @param req
	 * @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-05-16 11:11:22
	 */
	@GetMapping(value="list")
	@ResponseBody
	public Result getArticleVoList(ArticleReq req) throws Exception{
		Integer articleCategory = req.getArticleCategory();
		List<ArticleVo> vos = new ArrayList<ArticleVo>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Long count = 0L;
		//绵竹造列表
		if(articleCategory.compareTo(999)==0){
			SpecialtyReq sReq = new SpecialtyReq();
			sReq.setPage(req.getPage());
			sReq.setStatus(AuditStatusEnum.yishenhe.getCode());
			sReq.setCategory(req.getCategory());
			sReq.setOrigin(req.getOrigin());
			SpecialtyLtResp sResp = specialtyService.queryList(sReq);
			count = sResp.getCount();
			List<Specialty> list = sResp.getSpecialtyLt();
			for (Specialty specialty : list) {
				ArticleVo vo = new ArticleVo();
				vo.setSrc(specialty.getProductPic());
				vo.setTitle(specialty.getProductName());
				vo.setDesc(format.format(specialty.getCreateTime()));
				vo.setUrl("mzDetail/"+specialty.getId());
				vos.add(vo);
			}
		}else{//文章列表
			req.setStatus(ArticleStatusEnum.yishenhe.getCode());
			req.setIsPublic(IsPublicEnum.shi.getCode());
			ArticleLtResp resp= articleService.queryList(req);
			count = resp.getCount();
			List<Article> list = resp.getArticleLt();
			for (Article article : list) {
				ArticleVo vo = new ArticleVo();
				vo.setSrc(article.getPic());
				vo.setTitle(article.getTitle());
				vo.setDesc(format.format(article.getCreateTime()));
				vo.setUrl("detail/"+article.getId());
				vos.add(vo);
			}
		}
		Result re = new Result();
		re.setData(vos);
		re.setCount(count);
		return re;
	}	
	
	/**
	 * Excel文件导入
	 * @param request
	 * @param response
	 * @return Result
	 * @throws Exception
	 * @author zbk
	 * @date 2017-05-16 11:11:22
	 */
	@PostMapping(value="import")
	@ResponseBody
	public Result importExcel(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Result result = new Result();
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setHeadRows(1);
			params.setNeedSave(false);
			try {
				List<Article> articles = ExcelImportUtil.importExcel(file.getInputStream(),Article.class,params);
				for (Article article : articles) {
					articleService.save(article);
				}
			} catch (Exception e) {
				throw new Exception("导入数据错误");
			}finally{
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	/**
	 * 导出excel数据
	 * @param req
	 * @param request
	 * @param response
	 * @return 
	 * @throws Exception
	 * @author zbk
	 * @date 2017-05-16 11:11:22
	 */
	@GetMapping(value="export")
	public void exportXls(ArticleReq req,HttpServletRequest request, HttpServletResponse response) throws Exception {
		//重置分页参数
		req.setPage(1);
		req.setItemcount(Integer.MAX_VALUE);
		//获取数据
		ArticleLtResp resp= articleService.queryList(req);
		Map<String, Object> model = new HashMap<String,Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		model.put(NormalExcelConstants.FILE_NAME,"文章");
		model.put(NormalExcelConstants.CLASS,Article.class);
		model.put(NormalExcelConstants.PARAMS,new ExportParams("文章", "导出时间:"+sdf.format(new Date()),"导出信息"));
		model.put(NormalExcelConstants.DATA_LIST,resp.getArticleLt());
		ExcelUtils.exportDataToSingleExcel(model, request, response);
	}
	
	/**
	 * 导出excel模板
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @author zbk
	 * @date 2017-05-16 11:11:22
	 */
	@GetMapping(value="exportTpl")
	public void exportXlsByT(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> model = new HashMap<String,Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		model.put(NormalExcelConstants.FILE_NAME,"文章模板");
		model.put(NormalExcelConstants.CLASS,Article.class);
		model.put(NormalExcelConstants.PARAMS,new ExportParams("文章模板", "导出时间:"+sdf.format(new Date()),"导出信息"));
		model.put(NormalExcelConstants.DATA_LIST,new ArrayList<Object>());
		ExcelUtils.exportDataToSingleExcel(model, request, response);
	}	
	
	
}
