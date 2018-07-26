<template>
    <div class="table">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-menu"></i> 项目</el-breadcrumb-item>
                <el-breadcrumb-item>项目储备表管理</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <!--工具条-->
        <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
            <el-form :inline="true" :rules="queryRules" ref="queryform" :model="queryParam">
                <el-form-item label="编号" prop="id">
                    <el-input v-model="queryParam.id" auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="项目名称">
                    <el-input v-model="queryParam.projectName" auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="计划开工日期">
                    <el-date-picker type="date" placeholder="选择日期" v-model="queryParam.plannedStartDate"></el-date-picker>
                </el-form-item>
                <el-form-item label="计划完工日期">
                    <el-date-picker type="date" placeholder="选择日期" v-model="queryParam.plannedCompletionTime"></el-date-picker>
                </el-form-item>
                <el-form-item label="规划投资">
                    <el-select clearable v-model="queryParam.programInvestment" placeholder="请选择规划投资范围">
                        <v-yvoption groupName="amtRangeW"></v-yvoption>
                    </el-select>
                </el-form-item>
                <el-form-item label="审核状态">
                    <el-select clearable v-model="queryParam.status" placeholder="请选择审核状态">
                        <v-yvoption groupName="auditStatus"></v-yvoption>
                    </el-select>
                </el-form-item>
                <el-form-item label="拨付状态">
                    <el-select clearable v-model="queryParam.payStatus" placeholder="请选择拨付状态">
                        <v-yvoption groupName="payStatus"></v-yvoption>
                    </el-select>
                </el-form-item>
                <el-form-item label="是否投入使用">
                    <el-select clearable v-model="queryParam.isUse" placeholder="请选择是否投入使用">
                        <v-yvoption groupName="isNo"></v-yvoption>
                    </el-select>
                </el-form-item>
                <el-form-item label="是否分期">
                    <el-select clearable v-model="queryParam.isStage" placeholder="请选择是否分期">
                        <v-yvoption groupName="isNo"></v-yvoption>
                    </el-select>
                </el-form-item>
                <el-form-item label="是否跨年度">
                    <el-select clearable v-model="queryParam.isBeyondYear" placeholder="请选择是否分期">
                        <v-yvoption groupName="isNo"></v-yvoption>
                    </el-select>
                </el-form-item>
                <el-form-item label="建设状态">
                    <el-select clearable v-model="queryParam.buildStatus" placeholder="请选择建设状态">
                        <v-yvoption groupName="buildStatus"></v-yvoption>
                    </el-select>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="getProjectList">查询</el-button>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="handleAdd">新增</el-button>
                </el-form-item>
                <el-form-item>
                    <v-yvexcelimport :uploadUrl="uploadUrl"></v-yvexcelimport>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="getExportUrl"><a :href="exportUrl" style="color:#fff" target="_blank">导出</a></el-button>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary"><a :href="templateUrl" style="color:#fff" target="_blank">下载模板</a></el-button>
                </el-form-item>
            </el-form>
        </el-col>
        <el-table :data="tableData" border style="width: 100%" v-loading.body="loading" @selection-change="selsChange">
            <el-table-column type="selection" width="70"></el-table-column>
            <el-table-column prop="projectName" width="150" label="项目名称"></el-table-column>
            <el-table-column prop="projectType" width="170" label="项目类型">
                <template scope="scope">
                    <v-yvtableoption groupName="projectType" :trueValue="scope.row.projectType"></v-yvtableoption>
                </template>
            </el-table-column>
            <el-table-column prop="owner" width="160" label="项目业主名称"></el-table-column>
            <el-table-column prop="legalPerson" width="150" label="法人姓名"></el-table-column>
            <el-table-column prop="programInvestment" width="170" label="规划投资"></el-table-column>
            <el-table-column prop="status" width="170" label="审核状态">
                <template scope="scope">
                    <v-yvtableoption groupName="auditStatus" :trueValue="scope.row.status"></v-yvtableoption>
                </template>
            </el-table-column>
            <el-table-column prop="payStatus" width="170" label="拨付状态">
                <template scope="scope">
                    <v-yvtableoption groupName="payStatus" :trueValue="scope.row.payStatus"></v-yvtableoption>
                </template>
            </el-table-column>
            <el-table-column label="操作" width="180">
                <template scope="scope">
                    <el-button size="small" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                    <el-button size="small" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-row type="flex" justify="space-between" style="margin-top:10px">
            <el-col :span='12'>
                <el-button type="danger" @click="batchRemove">批量删除</el-button>
            </el-col>
            <el-col :span='6'>
                <el-pagination layout="prev, pager, next" :current-page='pageIndex' :page-size='pageSize' @current-change="handleCurrentChange" :total="totalCount" style="float:right;">
                </el-pagination>
            </el-col>
        </el-row>
        <!--新增界面-->
        <el-dialog :title="formTittle" v-model="formVisible" :close-on-click-modal="false" size="small">
            <el-form :model="subform" label-width="90px" :rules="formRules" ref="subform">
                <el-row>
                    <el-col :span='12'>
                        <el-form-item label="主键ID" prop="id">
                            <el-input v-model="subform.id" auto-complete="off" disabled></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="项目名称" prop="projectName">
                            <el-input v-model="subform.projectName" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="项目类型" prop="projectType">
                            <el-select v-model="subform.projectType" placeholder="请选择项目类型">
                                <v-yvoption groupName="projectType"></v-yvoption>
                            </el-select>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-collapse v-model="activeNames">
                    <el-collapse-item title="项目计划" name="1">
                        <el-row>
                            <el-col :span='12'>
                                <el-form-item label="建设地点" prop="address">
                                    <el-input v-model="subform.address" auto-complete="off"></el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span='12'>
                                <el-form-item label="计划开工日期" prop="plannedStartDate">
                                    <el-date-picker type="date" placeholder="选择日期" v-model="subform.plannedStartDate"></el-date-picker>
                                </el-form-item>
                            </el-col>
                            <el-col :span='12'>
                                <el-form-item label="计划完工日期" prop="plannedCompletionTime">
                                    <el-date-picker type="date" placeholder="选择日期" v-model="subform.plannedCompletionTime"></el-date-picker>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <el-row>
                            <el-col :span='12'>
                                <el-form-item label="用地面积" prop="landArea">
                                    <el-input v-model="subform.landArea" auto-complete="off">
                                        <template slot="append">㎡</template>
                                    </el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span='12'>
                                <el-form-item label="建筑面积" prop="buildingArea">
                                    <el-input v-model="subform.buildingArea" auto-complete="off">
                                        <template slot="append">㎡</template>
                                    </el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span='12'>
                                <el-form-item label="营业面积" prop="businessArea">
                                    <el-input v-model="subform.businessArea" auto-complete="off">
                                        <template slot="append">㎡</template>
                                    </el-input>
                                </el-form-item>
                            </el-col>
                        </el-row>
                    </el-collapse-item>
                    <el-collapse-item title="人员情况" name="2">
                        <el-row>
                            <el-col :span='12'>
                                <el-form-item label="项目业主名称" prop="owner">
                                    <el-input v-model="subform.owner" auto-complete="off"></el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span='12'>
                                <el-form-item label="法人姓名" prop="legalPerson">
                                    <el-input v-model="subform.legalPerson" auto-complete="off"></el-input>
                                </el-form-item>
                            </el-col>
                            </el-row>
                            <el-row>
                            <el-col :span='12'>
                                <el-form-item label="通信联系" prop="contact">
                                    <el-input v-model="subform.contact" auto-complete="off"></el-input>
                                </el-form-item>
                            </el-col>
                        </el-row>
                    </el-collapse-item>
                    <el-collapse-item title="资金情况" name="3">
                        <el-row>
                            <el-col :span='12'>
                                <el-form-item label="规划投资" prop="programInvestment">
                                    <el-input v-model="subform.programInvestment" auto-complete="off">
                                        <template slot="append">万元</template>
                                    </el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span='12'>
                                <el-form-item label="计划投资" prop="planInvestment">
                                    <el-input v-model="subform.planInvestment" auto-complete="off">
                                        <template slot="append">万元</template>
                                    </el-input>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <el-row>
                            <el-col :span='12'>
                                <el-form-item label="项目批复为文号" prop="recordNum">
                                    <el-input v-model="subform.recordNum" auto-complete="off"></el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span='12'>
                                <el-form-item label="批复总投资" prop="approveInvestment">
                                    <el-input v-model="subform.approveInvestment" auto-complete="off">
                                        <template slot="append">万元</template>
                                    </el-input>
                                </el-form-item>
                            </el-col>
                            </el-row>
                            <el-row>
                            <el-col :span='12'>
                                <el-form-item label="实际投入" prop="realInvestment">
                                    <el-input v-model="subform.realInvestment" auto-complete="off">
                                        <template slot="append">万元</template>
                                    </el-input>
                                </el-form-item>
                            </el-col>
                        
                            <el-col :span='12'>
                                <el-form-item label="自筹" prop="raise">
                                    <el-input v-model="subform.raise" auto-complete="off">
                                        <template slot="append">万元</template>
                                    </el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span='12'>
                                <el-form-item label="贷款" prop="loan">
                                    <el-input v-model="subform.loan" auto-complete="off">
                                        <template slot="append">万元</template>
                                    </el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span='12'>
                                <el-form-item label="其它" prop="other">
                                    <el-input v-model="subform.other" auto-complete="off">
                                        <template slot="append">万元</template>
                                    </el-input>
                                </el-form-item>
                            </el-col>
                        </el-row>
                    </el-collapse-item>
                    <el-collapse-item title="项目状态" name="4">
                        <el-row>
                            <el-col :span='12'>
                                <el-form-item label="审核状态" prop="status">
                                    <el-select v-model="subform.status" placeholder="请选择项目类型">
                                        <v-yvoption groupName="auditStatus"></v-yvoption>
                                    </el-select>
                                </el-form-item>
                            </el-col>
                            <el-col :span='12'>
                                <el-form-item label="拨付状态" prop="payStatus">
                                    <el-select v-model="subform.payStatus" placeholder="请选择项目类型">
                                        <v-yvoption groupName="payStatus"></v-yvoption>
                                    </el-select>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <el-row>
                            <el-col :span='12'>
                                <el-form-item label="是否投入使用" prop="isUse">
                                    <el-select v-model="subform.isUse" placeholder="请选择是否投入使用">
                                        <v-yvoption groupName="isNo"></v-yvoption>
                                    </el-select>
                                </el-form-item>
                            </el-col>
                            <el-col :span='12'>
                                <el-form-item label="是否分期" prop="isStage">
                                    <el-select v-model="subform.isStage" placeholder="请选择是否分期">
                                        <v-yvoption groupName="isNo"></v-yvoption>
                                    </el-select>
                                </el-form-item>
                            </el-col>
                            </el-row>
                            <el-row>
                            <el-col :span='12'>
                                <el-form-item label="是否跨年度" prop="isBeyondYear">
                                    <el-select v-model="subform.isBeyondYear" placeholder="请选择是否分期">
                                        <v-yvoption groupName="isNo"></v-yvoption>
                                    </el-select>
                                </el-form-item>
                            </el-col>
                            <el-col :span='12'>
                                <el-form-item label="建设状态" prop="buildStatus">
                                    <el-select v-model="subform.buildStatus" placeholder="请选择建设状态">
                                        <v-yvoption groupName="buildStatus"></v-yvoption>
                                    </el-select>
                                </el-form-item>
                            </el-col>
                            <el-col :span='24'>
                                <el-form-item label="建设内容" prop="constructionContent">
                                    <el-input type="textarea" v-model="subform.constructionContent" auto-complete="off"></el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span='24'>
                                <el-form-item label="存在困难及建议" prop="proposal">
                                    <el-input type="textarea" v-model="subform.proposal" auto-complete="off"></el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span='24'>
                                <el-form-item label="项目建设状态评估" prop="assessment">
                                    <el-input type="textarea" v-model="subform.assessment" auto-complete="off"></el-input>
                                </el-form-item>
                            </el-col>
                        </el-row>
                    </el-collapse-item>
                </el-collapse>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click.native="formVisible = false">取消</el-button>
                <el-button type="primary" @click.native="formSubmit" :loading="formLoading">提交</el-button>
            </div>
        </el-dialog>
    </div>
</template>
<script>
import {
    createProject,
    getProjectList,
    editProject,
    delProject,
    base
} from '../../../api/api';
import vYvoption from '../../common/yvoption.vue';
import vYvtableoption from '../../common/yvtableoption.vue';
import vYvexcelimport from '../../common/yvexcelimport.vue';
import {checkMoney,checkRequire,validNum,checkMoneyNull} from '../../../utils/validator.js'
export default {
    data() {
            return {
                uploadUrl: base + "/projects/import",
                exportUrl: base + "/projects/export",
                templateUrl: base + "/projects/exportTpl",
                tableData: [],
                pageIndex: 1,
                pageSize: 10,
                totalCount: 0,
                loading: true,
                sels: [],
                //form数据
                formTittle: '',
                formVisible: false,
                queryParam: {
                    id: '',
                    projectName: '',
                    projectType: '',
                    plannedStartDate: '',
                    plannedCompletionTime: '',
                    programInvestment: '',
                    status: '',
                    payStatus: '',
                    isUse: '',
                    isStage: '',
                    isBeyondYear: '',
                    buildStatus: '',
                },
                subform: {},
                initform: {
                    id: '',
                    projectName: '',
                    address: '',
                    plannedStartDate: '',
                    plannedCompletionTime: '',
                    landArea: '',
                    buildingArea: '',
                    businessArea: '',
                    isUse: 0,
                    isStage: 0,
                    isBeyondYear: 0,
                    projectType: 0,
                    owner: '',
                    legalPerson: '',
                    contact: '',
                    recordNum: '',
                    approveInvestment: '',
                    programInvestment: '',
                    planInvestment: '',
                    realInvestment: '',
                    raise: '',
                    loan: '',
                    other: '',
                    buildStatus: '',
                    constructionContent: '',
                    proposal: '',
                    assessment: '',
                    status: 0,
                    payStatus: 0,

                },
                activeNames: ['1', '2', '3', '4'],
                formRules: {
                    projectName:[{validator:checkRequire, required: true,trigger: 'blur'}],
                    projectType:[{ validator: checkRequire, required: true,trigger: 'blur' }],
                    owner:[{validator:checkRequire, required: true,trigger: 'blur'}],
                    legalPerson:[{validator:checkRequire, required: true,trigger: 'blur'}],
                    programInvestment:[{validator:checkMoney, required: true,trigger: 'blur'}],
                    approveInvestment:[{validator:checkMoneyNull,trigger: 'blur'}],
                    planInvestment:[{validator:checkMoneyNull,trigger: 'blur'}],
                    realInvestment:[{validator:checkMoneyNull,trigger: 'blur'}],
                    landArea:[{validator:validNum,trigger: 'blur'}],
                    buildingArea:[{validator:validNum,trigger: 'blur'}],
                    businessArea:[{validator:validNum,trigger: 'blur'}],
                    raise:[{validator:checkMoneyNull,trigger: 'blur'}],
                    loan:[{validator:checkMoneyNull,trigger: 'blur'}],
                    other:[{validator:checkMoneyNull,trigger: 'blur'}],
                },
                queryRules: {
                    id: [{
                        validator: validNum,
                        trigger: 'blur'
                    }],
                },
                formLoading: false
            }
        },
        components: {
            vYvoption,
            vYvtableoption,
            vYvexcelimport
        },
        methods: {
            getExportUrl() {
                this.exportUrl = base + "/projects/export?id=" + this.queryParam.id + "&enterpriseName=" + this.queryParam.enterpriseName + "&year=" + this.queryParam.year + "&month=" + this.queryParam.month + "&createTime=" + this.queryParam.createTime;
            },
            handleAdd(index, row) {
                this.formVisible = true;
                this.$nextTick(function() {
                    this.subform = Object.assign({}, this.initform);
                    this.$refs['subform'].resetFields();
                    this.formTittle = "新增"
                })
            },
            handleEdit(index, row) {
                this.formVisible = true;
                this.$nextTick(function() {
                    this.$refs['subform'].resetFields();
                    this.subform = Object.assign({}, row);
                    this.formTittle = "编辑"
                })
            },
            handleDelete(index, row) {
                this.$confirm('确认删除该记录吗?', '提示', {
                    type: 'warning'
                }).then(() => {
                    let param = {
                        ids: row.id
                    };
                    delProject(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.formVisible = false;
                            this.getProjectList();
                            this.$message.success("删除成功");
                        } else {
                            this.$message.error(res.data.message);
                        }
                    });
                }).catch(() => {

                });
            },
            getProjectList() {
                this.$refs["queryform"].validate((valid) => {
                    if (valid) {
                        this.loading = true;
                        const self = this;
                        let params = {
                            page: this.pageIndex,
                            itemcount: this.pageSize,
                            id: this.queryParam.id,
                            projectName: this.queryParam.projectName,
                            projectType: this.queryParam.projectType,
                            plannedStartDate: this.queryParam.plannedStartDate,
                            plannedCompletionTime: this.queryParam.plannedCompletionTime,
                            programInvestment: this.queryParam.programInvestment,
                            status: this.queryParam.status,
                            payStatus: this.queryParam.payStatus,
                            isUse: this.queryParam.isUse,
                            isStage: this.queryParam.isStage,
                            isBeyondYear: this.queryParam.isBeyondYear,
                            buildStatus: this.queryParam.buildStatus,
                        }
                        getProjectList(params).then((res) => {
                            this.loading = false;
                            if (res.data.code == '000000') {
                                this.tableData = res.data.data;
                                this.totalCount = res.data.count;
                            } else {
                                this.$message.error(res.data.message);
                            }
                        }).catch(function(error) {
                            self.loading = false;
                            self.$message.error('网络故障，请稍后再试');
                        });
                    }
                })
            },
            handleCurrentChange(val) {
                this.pageIndex = val;
                this.getProjectList()
            },
            formSubmit() {
                this.$refs["subform"].validate((valid) => {
                    if (valid) {
                        this.formLoading = true;
                        let param = Object.assign({}, this.subform);
                        if (param.id != "") {
                            editProject(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getProjectList();
                                } else {
                                    this.$message.error(res.data.message);
                                }
                            });
                        } else {
                            createProject(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getProjectList();
                                } else {
                                    this.$message.error(res.data.message);
                                }
                            });
                        }

                    } else {
                        return false;
                    }
                })

            },
            selsChange(sels) {
                this.sels = sels;
            },
            batchRemove() {
                var ids = this.sels.map(item => item.id).toString();
                if (ids == "") {
                    this.$message.warning("您还没有选中记录");
                    return false;
                }
                console.log(ids);
                this.$confirm('确认删除选中记录吗？', '提示', {
                    type: 'warning'
                }).then(() => {
                    let param = {
                        ids: ids
                    };
                    delProject(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.getProjectList();
                            this.$message.success("删除成功");
                        } else {
                            this.$message.error(res.data.message);
                        }
                    });
                }).catch(() => {

                });
            },
        },

        mounted: function() {
            this.getProjectList()
        }
}
</script>
<style>
.avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
}

.avatar-uploader .el-upload:hover {
    border-color: #20a0ff;
}

.avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
}

.avatar {
    width: 178px;
    height: 178px;
    display: block;
}
</style>
