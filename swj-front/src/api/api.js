import axios from 'axios';
export const base = 'http://192.168.0.140:8090';
// export const base = 'http://www.yuanv.com.cn:8090';

//基础接口
export const getOptions = params => { return axios.get(`${base}/types/common`, { params: params }); };
//获取系统日志列表
export const getServiceLogsList = params => { return axios.get(`${base}/serviceLogss`, { params: params }); };
//新增系统日志信息
export const createServiceLogs = params => { return axios.post(`${base}/serviceLogss`, params); };
//编辑系统日志信息
export const editServiceLogs = params => { return axios.put(`${base}/serviceLogss`, params); };
//删除系统日志信息
export const delServiceLogs = params => { return axios.delete(`${base}/serviceLogss`, { params: params }); };
//登陆
export const userLogin = params => { return axios.post(`${base}/users/login`, params); };
//注销
export const userLoginout = params => { return axios.delete(`${base}/users/login`, { params: params }); };
//获取用户列表
export const getUserList = params => { return axios.get(`${base}/users`, { params: params }); };
//新增用户信息
export const createUser = params => { return axios.post(`${base}/users`, params); };
//编辑用户信息
export const editUser = params => { return axios.put(`${base}/users`, params); };
//删除用户信息
export const delUser = params => { return axios.delete(`${base}/users`, { params: params }); };
//修改密码
export const changePwd = params => { return axios.put(`${base}/users/passwd`, params); };
//重置密码
export const resetPwd = params => { return axios.put(`${base}/users/resetPwd`, params); };
//获取用户菜单
export const getUserMenu = params => { return axios.get(`${base}/users/menu`, { params: params }); };
//获取角色列表
export const getRoleList = params => { return axios.get(`${base}/roles`, { params: params }); };
//新增角色信息
export const createRole = params => { return axios.post(`${base}/roles`, params); };
//编辑角色信息
export const editRole = params => { return axios.put(`${base}/roles`, params); };
//删除角色信息
export const delRole = params => { return axios.delete(`${base}/roles`, { params: params }); };
//获取角色菜单
export const getRoleMenu = params => { return axios.get(`${base}/roles/menus`, { params: params }); };
//保存角色菜单
export const saveRoleMenu = params => { return axios.post(`${base}/roles/savemenus`, params);};
//获取部门列表
export const getDepartList = params => { return axios.get(`${base}/departs`, { params: params }); };
//新增部门信息
export const createDepart = params => { return axios.post(`${base}/departs`, params); };
//编辑部门信息
export const editDepart = params => { return axios.put(`${base}/departs`, params); };
//删除部门信息
export const delDepart = params => { return axios.delete(`${base}/departs`, { params: params }); };
//获取乡镇信息列表
export const getTownshipList = params => { return axios.get(`${base}/townships`, { params: params }); };
//新增乡镇信息信息
export const createTownship = params => { return axios.post(`${base}/townships`, params); };
//编辑乡镇信息信息
export const editTownship = params => { return axios.put(`${base}/townships`, params); };
//删除乡镇信息信息
export const delTownship = params => { return axios.delete(`${base}/townships`, { params: params }); };
//获取数据类型定义列表
export const getTypeGroupList = params => { return axios.get(`${base}/typeGroups`, { params: params }); };
//新增数据类型定义信息
export const createTypeGroup = params => { return axios.post(`${base}/typeGroups`, params); };
//编辑数据类型定义信息
export const editTypeGroup = params => { return axios.put(`${base}/typeGroups`, params); };
//删除数据类型定义信息
export const delTypeGroup = params => { return axios.delete(`${base}/typeGroups`, { params: params }); };
//获取数据类型列表
export const getTypeList = params => { return axios.get(`${base}/types`, { params: params }); };
//新增数据类型信息
export const createType = params => { return axios.post(`${base}/types`, params); };
//编辑数据类型信息
export const editType = params => { return axios.put(`${base}/types`, params); };
//删除数据类型信息
export const delType = params => { return axios.delete(`${base}/types`, { params: params }); };
//获取统计局导出表列表
export const getRealReportList = params => { return axios.get(`${base}/realReports`, { params: params }); };
//新增统计局导出表信息
export const createRealReport = params => { return axios.post(`${base}/realReports`, params); };
//编辑统计局导出表信息
export const editRealReport = params => { return axios.put(`${base}/realReports`, params); };
//删除统计局导出表信息
export const delRealReport = params => { return axios.delete(`${base}/realReports`, { params: params }); };
//批量删除统计局导出表信息
export const batchDelRealReport = params => { return axios.delete(`${base}/realReports/batch`, { params: params }); };
//获取企业进退库管理表列表
export const getEnterpriseManageList = params => { return axios.get(`${base}/enterpriseManages`, { params: params }); };
//新增企业进退库管理表信息
export const createEnterpriseManage = params => { return axios.post(`${base}/enterpriseManages`, params); };
//编辑企业进退库管理表信息
export const editEnterpriseManage = params => { return axios.put(`${base}/enterpriseManages`, params); };
//删除企业进退库管理表信息
export const delEnterpriseManage = params => { return axios.delete(`${base}/enterpriseManages`, { params: params }); };
//获取服务业企业数据定义列表
export const getServiceDefineList = params => { return axios.get(`${base}/serviceDefines`, { params: params }); };
//新增服务业企业数据定义信息
export const createServiceDefine = params => { return axios.post(`${base}/serviceDefines`, params); };
//编辑服务业企业数据定义信息
export const editServiceDefine = params => { return axios.put(`${base}/serviceDefines`, params); };
//删除服务业企业数据定义信息
export const delServiceDefine = params => { return axios.delete(`${base}/serviceDefines`, { params: params }); };
//获取服务业企业数据预测列表
export const getServiceForecastList = params => { return axios.get(`${base}/serviceForecasts`, { params: params }); };
//新增服务业企业数据预测信息
export const createServiceForecast = params => { return axios.post(`${base}/serviceForecasts`, params); };
//编辑服务业企业数据预测信息
export const editServiceForecast = params => { return axios.put(`${base}/serviceForecasts`, params); };
//删除服务业企业数据预测信息
export const delServiceForecast = params => { return axios.delete(`${base}/serviceForecasts`, { params: params }); };
//获取项目储备表列表
export const getProjectList = params => { return axios.get(`${base}/projects`, { params: params }); };
//新增项目储备表信息
export const createProject = params => { return axios.post(`${base}/projects`, params); };
//编辑项目储备表信息
export const editProject = params => { return axios.put(`${base}/projects`, params); };
//删除项目储备表信息
export const delProject = params => { return axios.delete(`${base}/projects`, { params: params }); };
//获取限上企业信息表列表
export const getEnterpriseList = params => { return axios.get(`${base}/enterprises`, { params: params }); };
//新增限上企业信息表信息
export const createEnterprise = params => { return axios.post(`${base}/enterprises`, params); };
//编辑限上企业信息表信息
export const editEnterprise = params => { return axios.put(`${base}/enterprises`, params); };
//删除限上企业信息表信息
export const delEnterprise = params => { return axios.delete(`${base}/enterprises`, { params: params }); };
//获取绵竹造产品表列表
export const getSpecialtyList = params => { return axios.get(`${base}/specialtys`, { params: params }); };
//获取绵竹造产品详情
export const getSpecialtyById = params => { return axios.get(`${base}/specialtys/id`, { params: params }); };
//新增绵竹造产品表信息
export const createSpecialty = params => { return axios.post(`${base}/specialtys`, params); };
//编辑绵竹造产品表信息
export const editSpecialty = params => { return axios.put(`${base}/specialtys`, params); };
//删除绵竹造产品表信息
export const delSpecialty = params => { return axios.delete(`${base}/specialtys`, { params: params }); };
//获取企业预测增幅设置列表
export const getEnterpriseRiseList = params => { return axios.get(`${base}/enterpriseRises`, { params: params }); };
//新增企业预测增幅设置信息
export const createEnterpriseRise = params => { return axios.post(`${base}/enterpriseRises`, params); };
//编辑企业预测增幅设置信息
export const editEnterpriseRise = params => { return axios.put(`${base}/enterpriseRises`, params); };
//删除企业预测增幅设置信息
export const delEnterpriseRise = params => { return axios.delete(`${base}/enterpriseRises`, { params: params }); };
//获取总量预测结果表列表
export const getForecastList = params => { return axios.get(`${base}/forecasts`, { params: params }); };
//新增总量预测结果表信息
export const createForecast = params => { return axios.post(`${base}/forecasts`, params); };
//编辑总量预测结果表信息
export const editForecast = params => { return axios.put(`${base}/forecasts`, params); };
//删除总量预测结果表信息
export const delForecast = params => { return axios.delete(`${base}/forecasts`, { params: params }); };
//获取总量预测结果表列表
export const calcForecast = params => { return axios.get(`${base}/forecasts/calc`, { params: params }); };
//获取企业预测结果表列表
export const getForecastDetailList = params => { return axios.get(`${base}/forecastDetails`, { params: params }); };
//新增企业预测结果表信息
export const createForecastDetail = params => { return axios.post(`${base}/forecastDetails`, params); };
//编辑企业预测结果表信息
export const editForecastDetail = params => { return axios.put(`${base}/forecastDetails`, params); };
//删除企业预测结果表信息
export const delForecastDetail = params => { return axios.delete(`${base}/forecastDetails`, { params: params }); };
//获取企业数据上报列表
export const getEnterpriseReportList = params => { return axios.get(`${base}/enterpriseReports`, { params: params }); };
//获取社消零同期数
export const getEnterpriseReportTqs = params => { return axios.get(`${base}/enterpriseReports/tqs`, { params: params }); };
//新增企业数据上报信息
export const createEnterpriseReport = params => { return axios.post(`${base}/enterpriseReports`, params); };
//编辑企业数据上报信息
export const editEnterpriseReport = params => { return axios.put(`${base}/enterpriseReports`, params); };
//删除企业数据上报信息
export const delEnterpriseReport = params => { return axios.delete(`${base}/enterpriseReports`, { params: params }); };
//获取待办事项列表
export const getToDoListList = params => { return axios.get(`${base}/toDoLists`, { params: params }); };
//新增待办事项信息
export const createToDoList = params => { return axios.post(`${base}/toDoLists`, params); };
//新增待办事项信息
export const todoCheck = params => { return axios.post(`${base}/toDoLists/audit`, params); };
//编辑待办事项信息
export const editToDoList = params => { return axios.put(`${base}/toDoLists`, params); };
//删除待办事项信息
export const delToDoList = params => { return axios.delete(`${base}/toDoLists`, { params: params }); };
//获取待办事项数量
export const getToDoTotal = params => { return axios.get(`${base}/toDoLists/total`, { params: params }); };
//获取文章列表
export const getArticleList = params => { return axios.get(`${base}/articles`, { params: params }); };
//获取文章详情
export const getArticleById = params => { return axios.get(`${base}/articles/id`, { params: params }); };
//新增文章信息
export const createArticle = params => { return axios.post(`${base}/articles`, params); };
//编辑文章信息
export const editArticle = params => { return axios.put(`${base}/articles`, params); };
//删除文章信息
export const delArticle = params => { return axios.delete(`${base}/articles`, { params: params }); };
//获取文章类别列表
export const getArticleCategoryList = params => { return axios.get(`${base}/articleCategorys`, { params: params }); };
//获取文章类别列表
export const getArticleCategoryTree = params => { return axios.get(`${base}/articleCategorys/tree`, { params: params }); };
//新增文章类别信息
export const createArticleCategory = params => { return axios.post(`${base}/articleCategorys`, params); };
//编辑文章类别信息
export const editArticleCategory = params => { return axios.put(`${base}/articleCategorys`, params); };
//删除文章类别信息
export const delArticleCategory = params => { return axios.delete(`${base}/articleCategorys`, { params: params }); };
//获取审核配置列表
export const getAuditConfigList = params => { return axios.get(`${base}/auditConfigs`, { params: params }); };
//新增审核配置信息
export const createAuditConfig = params => { return axios.post(`${base}/auditConfigs`, params); };
//编辑审核配置信息
export const editAuditConfig = params => { return axios.put(`${base}/auditConfigs`, params); };
//删除审核配置信息
export const delAuditConfig = params => { return axios.delete(`${base}/auditConfigs`, { params: params }); };
//获取菜单列表
export const getMenuList = params => { return axios.get(`${base}/menus`, { params: params }); };
//新增菜单信息
export const createMenu = params => { return axios.post(`${base}/menus`, params); };
//编辑菜单信息
export const editMenu = params => { return axios.put(`${base}/menus`, params); };
//删除菜单信息
export const delMenu = params => { return axios.delete(`${base}/menus`, { params: params }); };
//获取内容发布列表
export const getPublishList = params => { return axios.get(`${base}/publishs`, { params: params }); };
//新增内容发布信息
export const createPublish = params => { return axios.post(`${base}/publishs`, params); };
//编辑内容发布信息
export const editPublish = params => { return axios.put(`${base}/publishs`, params); };
//删除内容发布信息
export const delPublish = params => { return axios.delete(`${base}/publishs`, { params: params }); };
//获取内容发布树
export const getPublishTree = params => { return axios.get(`${base}/publishs/tree`, { params: params }); };
//获取投诉建议列表
export const getAdviceList = params => { return axios.get(`${base}/advices`, { params: params }); };
//新增投诉建议信息
export const createAdvice = params => { return axios.post(`${base}/advices`, params); };
//编辑投诉建议信息
export const editAdvice = params => { return axios.put(`${base}/advices`, params); };
//删除投诉建议信息
export const delAdvice = params => { return axios.delete(`${base}/advices`, { params: params }); };
//获取投诉建议详情
export const getAdviceById = params => { return axios.get(`${base}/advices/id`, { params: params }); };
//获取企业信息表列表
export const getCompanyList = params => { return axios.get(`${base}/companys`, { params: params }); };
//新增企业信息表信息
export const createCompany = params => { return axios.post(`${base}/companys`, params); };
//编辑企业信息表信息
export const editCompany = params => { return axios.put(`${base}/companys`, params); };
//删除企业信息表信息
export const delCompany = params => { return axios.delete(`${base}/companys`, { params: params }); };
//获取服务业企业数据月报列表
export const getServiceMonthlyReportList = params => { return axios.get(`${base}/serviceMonthlyReports`, { params: params }); };
//新增服务业企业数据月报信息
export const createServiceMonthlyReport = params => { return axios.post(`${base}/serviceMonthlyReports`, params); };
//编辑服务业企业数据月报信息
export const editServiceMonthlyReport = params => { return axios.put(`${base}/serviceMonthlyReports`, params); };
//删除服务业企业数据月报信息
export const delServiceMonthlyReport = params => { return axios.delete(`${base}/serviceMonthlyReports`, { params: params }); };
//获取微信模板消息列表
export const getWeixinTemplateList = params => { return axios.get(`${base}/weixinTemplates`, { params: params }); };
//新增微信模板消息信息
export const createWeixinTemplate = params => { return axios.post(`${base}/weixinTemplates`, params); };
//编辑微信模板消息信息
export const editWeixinTemplate = params => { return axios.put(`${base}/weixinTemplates`, params); };
//删除微信模板消息信息
export const delWeixinTemplate = params => { return axios.delete(`${base}/weixinTemplates`, { params: params }); };
//下发通知
export const sendWeixinTemplate = params => { return axios.post(`${base}/weixinTemplates/send`, params); };
//获取微信模板消息发送记录列表
export const getWeixinTemplateRecordList = params => { return axios.get(`${base}/weixinTemplateRecords`, { params: params }); };
//新增微信模板消息发送记录信息
export const createWeixinTemplateRecord = params => { return axios.post(`${base}/weixinTemplateRecords`, params); };
//编辑微信模板消息发送记录信息
export const editWeixinTemplateRecord = params => { return axios.put(`${base}/weixinTemplateRecords`, params); };
//删除微信模板消息发送记录信息
export const delWeixinTemplateRecord = params => { return axios.delete(`${base}/weixinTemplateRecords`, { params: params }); };
//获取微信菜单列表
export const getWeixinMenuList = params => { return axios.get(`${base}/weixinMenus`, { params: params }); };
//新增微信菜单信息
export const createWeixinMenu = params => { return axios.post(`${base}/weixinMenus`, params); };
//编辑微信菜单信息
export const editWeixinMenu = params => { return axios.put(`${base}/weixinMenus`, params); };
//删除微信菜单信息
export const delWeixinMenu = params => { return axios.delete(`${base}/weixinMenus`, { params: params }); };
//获取订阅消息列表
export const getWeixinSubscribeList = params => { return axios.get(`${base}/weixinSubscribes`, { params: params }); };
//新增订阅消息信息
export const createWeixinSubscribe = params => { return axios.post(`${base}/weixinSubscribes`, params); };
//编辑订阅消息信息
export const editWeixinSubscribe = params => { return axios.put(`${base}/weixinSubscribes`, params); };
//删除订阅消息信息
export const delWeixinSubscribe = params => { return axios.delete(`${base}/weixinSubscribes`, { params: params }); };
//获取总量数据表列表
export const getTotalReportList = params => { return axios.get(`${base}/totalReports`, { params: params }); };
//新增总量数据表信息
export const createTotalReport = params => { return axios.post(`${base}/totalReports`, params); };
//编辑总量数据表信息
export const editTotalReport = params => { return axios.put(`${base}/totalReports`, params); };
//删除总量数据表信息
export const delTotalReport = params => { return axios.delete(`${base}/totalReports`, { params: params }); };
//获取统计员排位得分规则列表
export const getStatisticianRangeRulesList = params => { return axios.get(`${base}/statisticianRangeRuless`, { params: params }); };
//新增统计员排位得分规则信息
export const createStatisticianRangeRules = params => { return axios.post(`${base}/statisticianRangeRuless`, params); };
//编辑统计员排位得分规则信息
export const editStatisticianRangeRules = params => { return axios.put(`${base}/statisticianRangeRuless`, params); };
//删除统计员排位得分规则信息
export const delStatisticianRangeRules = params => { return axios.delete(`${base}/statisticianRangeRuless`, { params: params }); };
//获取统计员计分细则列表
export const getStatisticianScoringRulesList = params => { return axios.get(`${base}/statisticianScoringRuless`, { params: params }); };
//新增统计员计分细则信息
export const createStatisticianScoringRules = params => { return axios.post(`${base}/statisticianScoringRuless`, params); };
//编辑统计员计分细则信息
export const editStatisticianScoringRules = params => { return axios.put(`${base}/statisticianScoringRuless`, params); };
//删除统计员计分细则信息
export const delStatisticianScoringRules = params => { return axios.delete(`${base}/statisticianScoringRuless`, { params: params }); };
//获取镇乡年度目标任务表列表
export const getTownshipAnnualTaskList = params => { return axios.get(`${base}/townshipAnnualTasks`, { params: params }); };
//新增镇乡年度目标任务表信息
export const createTownshipAnnualTask = params => { return axios.post(`${base}/townshipAnnualTasks`, params); };
//编辑镇乡年度目标任务表信息
export const editTownshipAnnualTask = params => { return axios.put(`${base}/townshipAnnualTasks`, params); };
//删除镇乡年度目标任务表信息
export const delTownshipAnnualTask = params => { return axios.delete(`${base}/townshipAnnualTasks`, { params: params }); };
//获取镇乡年度任务完成情况列表
export const getTownshipAnnualDoneList = params => { return axios.get(`${base}/townshipAnnualDones`, { params: params }); };
//新增镇乡年度任务完成情况信息
export const createTownshipAnnualDone = params => { return axios.post(`${base}/townshipAnnualDones`, params); };
//编辑镇乡年度任务完成情况信息
export const editTownshipAnnualDone = params => { return axios.put(`${base}/townshipAnnualDones`, params); };
//删除镇乡年度任务完成情况信息
export const delTownshipAnnualDone = params => { return axios.delete(`${base}/townshipAnnualDones`, { params: params }); };
//获取统计员直报考核记录表列表
export const getStatisticianReportPointList = params => { return axios.get(`${base}/statisticianReportPoints`, { params: params }); };
//新增统计员直报考核记录表信息
export const createStatisticianReportPoint = params => { return axios.post(`${base}/statisticianReportPoints`, params); };
//编辑统计员直报考核记录表信息
export const editStatisticianReportPoint = params => { return axios.put(`${base}/statisticianReportPoints`, params); };
//删除统计员直报考核记录表信息
export const delStatisticianReportPoint = params => { return axios.delete(`${base}/statisticianReportPoints`, { params: params }); };
//获取统计员考核记录信息列表
export const getStatisticianRewardList = params => { return axios.get(`${base}/statisticianRewards`, { params: params }); };
//新增统计员考核记录信息信息
export const createStatisticianReward = params => { return axios.post(`${base}/statisticianRewards`, params); };
//编辑统计员考核记录信息信息
export const editStatisticianReward = params => { return axios.put(`${base}/statisticianRewards`, params); };
//删除统计员考核记录信息信息
export const delStatisticianReward = params => { return axios.delete(`${base}/statisticianRewards`, { params: params }); };
//获取会展备案信息列表
export const getExhibitionRecordList = params => { return axios.get(`${base}/exhibitionRecords`, { params: params }); };
//新增会展备案信息信息
export const createExhibitionRecord = params => { return axios.post(`${base}/exhibitionRecords`, params); };
//编辑会展备案信息信息
export const editExhibitionRecord = params => { return axios.put(`${base}/exhibitionRecords`, params); };
//删除会展备案信息信息
export const delExhibitionRecord = params => { return axios.delete(`${base}/exhibitionRecords`, { params: params }); };
//获取会展信息列表
export const getExhibitionList = params => { return axios.get(`${base}/exhibitions`, { params: params }); };
//新增会展信息信息
export const createExhibition = params => { return axios.post(`${base}/exhibitions`, params); };
//编辑会展信息信息
export const editExhibition = params => { return axios.put(`${base}/exhibitions`, params); };
//删除会展信息信息
export const delExhibition = params => { return axios.delete(`${base}/exhibitions`, { params: params }); };
//获取会展报名信息列表
export const getExhibitionRegisterList = params => { return axios.get(`${base}/exhibitionRegisters`, { params: params }); };
//新增会展报名信息信息
export const createExhibitionRegister = params => { return axios.post(`${base}/exhibitionRegisters`, params); };
//编辑会展报名信息信息
export const editExhibitionRegister = params => { return axios.put(`${base}/exhibitionRegisters`, params); };
//删除会展报名信息信息
export const delExhibitionRegister = params => { return axios.delete(`${base}/exhibitionRegisters`, { params: params }); };
//获取孵化园企业考核列表
export const getIncubationParkAssessmentList = params => { return axios.get(`${base}/incubationParkAssessments`, { params: params }); };
//新增孵化园企业考核信息
export const createIncubationParkAssessment = params => { return axios.post(`${base}/incubationParkAssessments`, params); };
//编辑孵化园企业考核信息
export const editIncubationParkAssessment = params => { return axios.put(`${base}/incubationParkAssessments`, params); };
//删除孵化园企业考核信息
export const delIncubationParkAssessment = params => { return axios.delete(`${base}/incubationParkAssessments`, { params: params }); };
//获取孵化园企业信息列表
export const getIncubationParkCompanyList = params => { return axios.get(`${base}/incubationParkCompanys`, { params: params }); };
//新增孵化园企业信息信息
export const createIncubationParkCompany = params => { return axios.post(`${base}/incubationParkCompanys`, params); };
//编辑孵化园企业信息信息
export const editIncubationParkCompany = params => { return axios.put(`${base}/incubationParkCompanys`, params); };
//删除孵化园企业信息信息
export const delIncubationParkCompany = params => { return axios.delete(`${base}/incubationParkCompanys`, { params: params }); };
//获取孵化园申请登记信息列表
export const getIncubationParkRegisterList = params => { return axios.get(`${base}/incubationParkRegisters`, { params: params }); };
//新增孵化园申请登记信息信息
export const createIncubationParkRegister = params => { return axios.post(`${base}/incubationParkRegisters`, params); };
//编辑孵化园申请登记信息信息
export const editIncubationParkRegister = params => { return axios.put(`${base}/incubationParkRegisters`, params); };
//删除孵化园申请登记信息信息
export const delIncubationParkRegister = params => { return axios.delete(`${base}/incubationParkRegisters`, { params: params }); };
//获取项目资金信息列表
export const getFundList = params => { return axios.get(`${base}/funds`, { params: params }); };
//获取项目资金信息树形数据
export const getFundTree = params => { return axios.get(`${base}/funds/tree`, { params: params }); };
//新增项目资金信息信息
export const createFund = params => { return axios.post(`${base}/funds`, params); };
//编辑项目资金信息信息
export const editFund = params => { return axios.put(`${base}/funds`, params); };
//删除项目资金信息信息
export const delFund = params => { return axios.delete(`${base}/funds`, { params: params }); };
//获取项目资金拨付信息列表
export const getFundDetailList = params => { return axios.get(`${base}/fundDetails`, { params: params }); };
//新增项目资金拨付信息信息
export const createFundDetail = params => { return axios.post(`${base}/fundDetails`, params); };
//编辑项目资金拨付信息信息
export const editFundDetail = params => { return axios.put(`${base}/fundDetails`, params); };
//删除项目资金拨付信息信息
export const delFundDetail = params => { return axios.delete(`${base}/fundDetails`, { params: params }); };
