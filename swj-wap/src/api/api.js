import axios from 'axios';
export const base = 'http://192.168.0.165:8090';
// export const base = 'http://www.yuanv.com.cn:8090';

//基础接口
export const getOptions = params => { return axios.get(`${base}/types/common`, { params: params }); };

//登陆
export const userLogin = params => { return axios.post(`${base}/users/login`, params); };
//绑定微信
export const bindWx = params => { return axios.post(`${base}/users/bind`, params); };
//注销
export const userLoginout = params => { return axios.delete(`${base}/users/login`, { params: params }); };
//编辑用户信息
export const editUser = params => { return axios.put(`${base}/users`, params); };
//修改密码
export const changePwd = params => { return axios.put(`${base}/users/passwd`, params); };
//获取用户菜单
export const getUserMenu = params => { return axios.get(`${base}/users/menu`, { params: params }); };
//获取数据类型定义列表
export const getTypeGroupList = params => { return axios.get(`${base}/typeGroups`, { params: params }); };
//新增数据类型定义信息
export const createTypeGroup = params => { return axios.post(`${base}/typeGroups`, params); };
//获取数据类型列表
export const getTypeList = params => { return axios.get(`${base}/types`, { params: params }); };
//获取统计局导出表列表
export const getRealReportList = params => { return axios.get(`${base}/realReports`, { params: params }); };
//新增统计局导出表信息
export const createRealReport = params => { return axios.post(`${base}/realReports`, params); };
//编辑统计局导出表信息
export const editRealReport = params => { return axios.put(`${base}/realReports`, params); };
//删除统计局导出表信息
export const delRealReport = params => { return axios.delete(`${base}/realReports`, { params: params }); };
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
//新增重点服务业数据
export const createSubServiceData = params => { return axios.post(`${base}/serviceMonthlyReports`, params); };
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
//获取绵竹造产品明细
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
//获取预测值
export const getForecastValue = params => { return axios.get(`${base}/forecastDetails/single`, { params: params }); };
//新增企业预测结果表信息
export const createForecastDetail = params => { return axios.post(`${base}/forecastDetails`, params); };
//编辑企业预测结果表信息
export const editForecastDetail = params => { return axios.put(`${base}/forecastDetails`, params); };
//删除企业预测结果表信息
export const delForecastDetail = params => { return axios.delete(`${base}/forecastDetails`, { params: params }); };
//获取企业数据上报列表
export const getEnterpriseReportList = params => { return axios.get(`${base}/enterpriseReports`, { params: params }); };
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
//获取文章列表wap格式化
export const getArticleListWap = params => { return axios.get(`${base}/articles/list`, { params: params }); };
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
//获取内容发布树
export const getPublishTree = params => { return axios.get(`${base}/publishs/tree`, { params: params }); };
//新增投诉建议
export const createAdvice = params => { return axios.post(`${base}/advices`, params); };
//获取信件详情
export const getAdviceById = params => { return axios.get(`${base}/advices/id`, { params: params }); };
//统一查询编码
export const seqQuery = params => { return axios.get(`${base}/unifiedQuerys`, { params: params }); };
//新增企业备案
export const createCompany = params => { return axios.post(`${base}/companys`, params); };
//获取社消零同期数
export const getEnterpriseReportTqs = params => { return axios.get(`${base}/enterpriseReports/tqs`, { params: params }); };
//获取会展报名信息列表
export const getExhibitionRegisterList = params => { return axios.get(`${base}/exhibitionRegisters`, { params: params }); };
//新增会展报名信息信息
export const createExhibitionRegister = params => { return axios.post(`${base}/exhibitionRegisters`, params); };
//编辑会展报名信息信息
export const editExhibitionRegister = params => { return axios.put(`${base}/exhibitionRegisters`, params); };
//删除会展报名信息信息
export const delExhibitionRegister = params => { return axios.delete(`${base}/exhibitionRegisters`, { params: params }); };
//获取孵化园申请登记信息列表
export const getIncubationParkRegisterList = params => { return axios.get(`${base}/incubationParkRegisters`, { params: params }); };
//新增孵化园申请登记信息信息
export const createIncubationParkRegister = params => { return axios.post(`${base}/incubationParkRegisters`, params); };
//编辑孵化园申请登记信息信息
export const editIncubationParkRegister = params => { return axios.put(`${base}/incubationParkRegisters`, params); };
//删除孵化园申请登记信息信息
export const delIncubationParkRegister = params => { return axios.delete(`${base}/incubationParkRegisters`, { params: params }); };
