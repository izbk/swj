<template>
    <div class="table">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-menu"></i> 绩效管理</el-breadcrumb-item>
                <el-breadcrumb-item>统计员月报打分</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <!--工具条-->
        <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
            <el-form :inline="true" :rules="queryRules" ref="queryform" :model="queryParam">
                <el-form-item label="编号" prop="id">
                    <el-input v-model="queryParam.id" :maxlength=10 auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="企业">
                    <el-select clearable filterable v-model="queryParam.enterpriseCode" placeholder="选择企业">
                        <v-yvoption tableName="enterprise" label="enterprise_name" value='enterprise_code'></v-yvoption>
                    </el-select>
                </el-form-item>
                <el-form-item label="日期">
                    <el-date-picker v-model="queryParam.queryDate" align="right" :clearable=false :editable=false type="month" placeholder="选择日期">
                    </el-date-picker>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="getStatisticianReportPointList">查询</el-button>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="getExportUrl"><a :href="exportUrl" style="color:#fff" target="_blank">导出</a></el-button>
                </el-form-item>
                <el-form-item>
                    <!-- <el-button type="primary" @click="handleAdd">新增</el-button> -->
                </el-form-item>
            </el-form>
        </el-col>
        <el-table :data="tableData" border style="width: 100%" v-loading.body="loading" @selection-change="selsChange">
            <el-table-column type="selection" width="70"></el-table-column>
            <el-table-column prop="year" label="年度" width="150"></el-table-column>
            <el-table-column prop="month" label="月份" width="150"></el-table-column>
            <el-table-column prop="enterpriseName" label="企业名称" width="260"></el-table-column>
            <el-table-column prop="statisticianName" label="统计员名称" width="150"></el-table-column>
            <el-table-column prop="isMark" label="是否打分" width="150">
                <template scope="scope">
                    <v-yvtableoption groupName="isNo" :trueValue="scope.row.isMark"></v-yvtableoption>
                </template>
            </el-table-column>
            <el-table-column prop="reportPoint" label="总计得分" width="150"></el-table-column>
            <el-table-column label="操作" width="220">
                <template scope="scope">
                    <el-button size="small" @click="handleEdit(scope.$index, scope.row)">打分详情</el-button>
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
                </el-row>
                <el-row>
                    <el-col :span='12'>
                        <el-form-item label="年度" prop="year">
                            <el-input readonly v-model="subform.year" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="月份" prop="month">
                            <el-input readonly v-model="subform.month" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="企业名称" prop="enterpriseName">
                            <el-input readonly v-model="subform.enterpriseName" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="统计员名称" prop="statisticianName">
                            <el-input readonly v-model="subform.statisticianName" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="加分项" prop="increaseRuleId">
                            <el-select placeholder="不选择则无加分" v-model="subform.increaseRuleId" style="width:90%" clearable>
                                <v-yvoption tableName="statistician_scoring_rules" label="rule" value='id' :dataList="increaseCon"></v-yvoption>
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="扣分项" prop="deductRuleId">
                            <el-select placeholder="不选择则无扣分" v-model="subform.deductRuleId" style="width:90%" clearable>
                                <v-yvoption tableName="statistician_scoring_rules" label="rule" value='id' :dataList="deductCon"></v-yvoption>
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="总计得分" prop="reportPoint">
                            <el-input readonly v-model="subform.reportPoint" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span='12'>
                        <el-form-item label="考核人" prop="createBy">
                            <el-select disabled v-model="subform.createBy" style="width:90%" clearable>
                                <v-yvoption tableName="user" label="nick_name" value='id'></v-yvoption>
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="考核时间" prop="createTime">
                            <el-date-picker readonly type="datetime" placeholder="选择日期" v-model="subform.createTime"></el-date-picker>
                        </el-form-item>
                    </el-col>
                </el-row>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click.native="formVisible = false">取消</el-button>
                <el-button type="primary" @click.native="formSubmit" :loading="formLoading">打分</el-button>
            </div>
        </el-dialog>
    </div>
</template>
<script>
import {
    createStatisticianReportPoint,
    getStatisticianReportPointList,
    editStatisticianReportPoint,
    delStatisticianReportPoint,
    base
} from '../../../api/api';
import vYvoption from '../../common/yvoption.vue';
import vYvtableoption from '../../common/yvtableoption.vue';
import {
    validNum
} from '../../../utils/validator.js';
export default {
    data() {
            return {
                exportUrl: base + "/statisticianReportPoints/export",
                increaseCon: '{point_type:1}',
                deductCon: '{point_type:0}',
                tableData: [],
                pageIndex: 1,
                pageSize: 10,
                totalCount: 0,
                loading: false,
                sels: [],
                //form数据
                formTittle: '',
                formVisible: false,
                queryParam: {
                    id: '',
                    enterpriseCode: '',
                    queryDate: new Date()
                },
                subform: {},
                initform: {
                    id: '',
                    year: 0,
                    month: 0,
                    enterpriseCode: '',
                    enterpriseName: '',
                    userId: 0,
                    statisticianName: '',
                    deductPoints: 0,
                    increasePoint: 0,
                    reportPoint: 0,
                    deductRuleId: "",
                    increaseRuleId: "",
                    isMark: "",
                    createTime: '',
                    createBy: 0,
                },
                formRules: {

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
            vYvtableoption
        },
        methods: {
            getExportUrl() {
                this.exportUrl = base + "/statisticianReportPoints/export?id=" + this.queryParam.id + "&enterpriseCode=" + this.queryParam.enterpriseCode + "&queryDate=" + this.queryParam.queryDate;
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
                    this.formTittle = "打分详情"
                })
            },
            handleDelete(index, row) {
                this.$confirm('确认删除该记录吗?', '提示', {
                    type: 'warning'
                }).then(() => {
                    let param = {
                        ids: row.id
                    };
                    delStatisticianReportPoint(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.formVisible = false;
                            this.getStatisticianReportPointList();
                            this.$message.success("删除成功");
                        } else {
                            this.$message.error(res.data.message);
                        }
                    });
                }).catch(() => {

                });
            },
            getStatisticianReportPointList() {
                this.$refs["queryform"].validate((valid) => {
                    if (valid) {
                        this.loading = true;
                        const self = this;
                        let params = {
                            page: this.pageIndex,
                            itemcount: this.pageSize,
                            id: this.queryParam.id,
                            enterpriseCode: this.queryParam.enterpriseCode,
                            queryDate: this.queryParam.queryDate
                        }
                        getStatisticianReportPointList(params).then((res) => {
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
                this.getStatisticianReportPointList()
            },
            formSubmit() {
                this.$refs["subform"].validate((valid) => {
                    if (valid) {
                        this.formLoading = true;
                        let param = Object.assign({}, this.subform);
                        if (param.id != null && param.id != "") {
                            editStatisticianReportPoint(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getStatisticianReportPointList();
                                } else {
                                    this.$message.error(res.data.message);
                                }
                            });
                        } else {
                            createStatisticianReportPoint(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getStatisticianReportPointList();
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
                    delStatisticianReportPoint(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.getStatisticianReportPointList();
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
            this.getStatisticianReportPointList()
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
