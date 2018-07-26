package cn.com.yuanwei.center.web;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.yuanwei.center.entity.Advice;
import cn.com.yuanwei.center.entity.Company;
import cn.com.yuanwei.center.entity.Project;
import cn.com.yuanwei.center.entity.Specialty;
import cn.com.yuanwei.center.enums.AuditStatusEnum;
import cn.com.yuanwei.center.enums.BusiTypeEnum;
import cn.com.yuanwei.center.service.AdviceService;
import cn.com.yuanwei.center.service.CompanyService;
import cn.com.yuanwei.center.service.ProjectService;
import cn.com.yuanwei.center.service.SpecialtyService;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.response.base.Result;
import cn.com.yuanwei.center.web.vo.UnifiedQueryVo;
import io.swagger.annotations.Api;

@Api(value = "unifiedQuery", description = "统一查询", produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
@RequestMapping("/unifiedQuerys")
public class UnifiedQueryController {
	Log logger = LogFactory.getLog(UnifiedQueryController.class);
	@Autowired
	private ProjectService projectService;
	@Autowired
	private SpecialtyService specialtyService;
	@Autowired
	private AdviceService adviceService;
	@Autowired
	private CompanyService companyService;

	/**
	 * Desc:查询详情
	 * @param id
	 * @throws Exception
	 * @return Result
	 * @author zbk
	 * @date 2017-06-01 15:58:48
	 */
	@GetMapping
	@ResponseBody
	public Result getDetail(String seq) throws Exception{
		if(ValidateUtil.isEmpty(seq)){
			throw new Exception("查询码为空");
		}
		if(seq.trim().length() < 2){
			throw new Exception("查询码长度至少2位");
		}
		String ids = seq.substring(1);
		Integer id = 0;
		try{
			id = Integer.valueOf(ids);
		}catch(Exception e){
			throw new Exception("查询码含有非法字符");
		}
		Result re = null;
		if(seq.startsWith(BusiTypeEnum.xiangmu.getCode().toString())){
			Project project = projectService.queryById(id);
			if(!ValidateUtil.isEmpty(project)){
				re = new Result(new UnifiedQueryVo(project.getProjectName(),BusiTypeEnum.xiangmu.getDesc(), AuditStatusEnum.getDesc(project.getStatus())));
			}
		}else if(seq.startsWith(BusiTypeEnum.mianzhuzao.getCode().toString())){
			Specialty specialty = specialtyService.queryById(id);
			if(!ValidateUtil.isEmpty(specialty)){
				re = new Result(new UnifiedQueryVo(specialty.getProductName(),BusiTypeEnum.mianzhuzao.getDesc(),AuditStatusEnum.getDesc(specialty.getStatus())));
			}
		}else if(seq.startsWith(BusiTypeEnum.tousujianyi.getCode().toString())){
			Advice advice = adviceService.queryById(id);
			if(!ValidateUtil.isEmpty(advice)){
				re = new Result(new UnifiedQueryVo(advice.getAdviceTitle(),BusiTypeEnum.tousujianyi.getDesc(),AuditStatusEnum.getDesc(advice.getStatus()),advice.getAdviceContent(),advice.getResContent()));
			}
		}else if(seq.startsWith(BusiTypeEnum.qiyebeian.getCode().toString())){
			Company company = companyService.queryById(id);
			if(!ValidateUtil.isEmpty(company)){
				re = new Result(new UnifiedQueryVo(company.getCompanyName(),BusiTypeEnum.qiyebeian.getDesc(),AuditStatusEnum.getDesc(company.getStatus())));
			}
		}
		if(ValidateUtil.isEmpty(re)){
			throw new Exception("未查询到相关信息");
		}
		re.setCount(1L);
		return re;
	}
}
