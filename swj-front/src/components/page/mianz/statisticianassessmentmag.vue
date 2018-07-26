<template>
    <div class="table">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-menu"></i> 系统管理</el-breadcrumb-item>
                <el-breadcrumb-item>统计人员任务考核管理</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
		<!--工具条-->
        <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
            <el-form :inline="true">
                <el-form-item label="用户id">
                    <el-input v-model="queryParam.id" auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="用户名称">
                    <el-input v-model="queryParam.name" auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="getStatisticianAssessmentList">查询</el-button>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="handleAdd">新增</el-button>
                </el-form-item>
            </el-form>
        </el-col>
        <el-table :data="tableData" border style="width: 100%" v-loading.body="loading" @selection-change="selsChange">
            <el-table-column type="selection" width="70"></el-table-column>
             <el-table-column prop="id" label="主键ID" sortable></el-table-column>
             <el-table-column prop="year" label="年度" sortable></el-table-column>
             <el-table-column prop="month" label="月份" sortable></el-table-column>
             <el-table-column prop="enterpriseCode" label="企业编号" sortable></el-table-column>
             <el-table-column prop="enterpriseName" label="企业名称" sortable></el-table-column>
             <el-table-column prop="statisticianId" label="统计员ID" sortable></el-table-column>
             <el-table-column prop="statisticianName" label="统计员姓名" sortable></el-table-column>
             <el-table-column prop="retailSalesDone" label="零售额总量" sortable></el-table-column>
             <el-table-column prop="salesDone" label="销售额总量" sortable></el-table-column>
             <el-table-column prop="retailSalesPoint" label="零售额排位得分" sortable></el-table-column>
             <el-table-column prop="salesPoint" label="销售额排位得分" sortable></el-table-column>
             <el-table-column prop="qualifyingPoint" label="排位总分" sortable></el-table-column>
             <el-table-column prop="retailCompareRatio" label="零售额同比" sortable></el-table-column>
             <el-table-column prop="saleCompareRatio" label="销售额同比" sortable></el-table-column>
             <el-table-column prop="retailGrowthPoint" label="零售增幅排位得分" sortable></el-table-column>
             <el-table-column prop="salesGrowthPoint" label="销售增幅排位得分" sortable></el-table-column>
             <el-table-column prop="growthPoint" label="增幅排位综合得分" sortable></el-table-column>
             <el-table-column prop="reportPoint" label="上报情况考核得分" sortable></el-table-column>
             <el-table-column prop="totalPoint" label="考核总得分" sortable></el-table-column>
             <el-table-column prop="perPointValue" label="单位分值金额" sortable></el-table-column>
             <el-table-column prop="allowance" label="以奖代补金额" sortable></el-table-column>
             <el-table-column prop="createTime" label="考核时间" sortable></el-table-column>
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
                            <el-input v-model="subform.id" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="年度" prop="year">
                            <el-input v-model="subform.year" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="月份" prop="month">
                            <el-input v-model="subform.month" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="企业编号" prop="enterpriseCode">
                            <el-input v-model="subform.enterpriseCode" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="企业名称" prop="enterpriseName">
                            <el-input v-model="subform.enterpriseName" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="统计员ID" prop="statisticianId">
                            <el-input v-model="subform.statisticianId" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="统计员姓名" prop="statisticianName">
                            <el-input v-model="subform.statisticianName" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="零售额总量" prop="retailSalesDone">
                            <el-input v-model="subform.retailSalesDone" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="销售额总量" prop="salesDone">
                            <el-input v-model="subform.salesDone" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="零售额排位得分" prop="retailSalesPoint">
                            <el-input v-model="subform.retailSalesPoint" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="销售额排位得分" prop="salesPoint">
                            <el-input v-model="subform.salesPoint" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="排位总分" prop="qualifyingPoint">
                            <el-input v-model="subform.qualifyingPoint" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="零售额同比" prop="retailCompareRatio">
                            <el-input v-model="subform.retailCompareRatio" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="销售额同比" prop="saleCompareRatio">
                            <el-input v-model="subform.saleCompareRatio" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="零售增幅排位得分" prop="retailGrowthPoint">
                            <el-input v-model="subform.retailGrowthPoint" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="销售增幅排位得分" prop="salesGrowthPoint">
                            <el-input v-model="subform.salesGrowthPoint" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="增幅排位综合得分" prop="growthPoint">
                            <el-input v-model="subform.growthPoint" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="上报情况考核得分" prop="reportPoint">
                            <el-input v-model="subform.reportPoint" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="考核总得分" prop="totalPoint">
                            <el-input v-model="subform.totalPoint" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="单位分值金额" prop="perPointValue">
                            <el-input v-model="subform.perPointValue" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="以奖代补金额" prop="allowance">
                            <el-input v-model="subform.allowance" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="考核时间" prop="createTime">
                            <el-input v-model="subform.createTime" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
            </el-row>
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
    createStatisticianAssessment,
    getStatisticianAssessmentList,
    editStatisticianAssessment,
    delStatisticianAssessment,
    base
} from '../../../api/api';

export default {
    data() {
            return {
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
                    name: ''
                },
                subform: {
                   id:'0',
                   year:'0',
                   month:'0',
                   enterpriseCode:'',
                   enterpriseName:'',
                   statisticianId:'0',
                   statisticianName:'',
                   retailSalesDone:'0',
                   salesDone:'0',
                   retailSalesPoint:'0',
                   salesPoint:'0',
                   qualifyingPoint:'0',
                   retailCompareRatio:'',
                   saleCompareRatio:'',
                   retailGrowthPoint:'',
                   salesGrowthPoint:'',
                   growthPoint:'0',
                   reportPoint:'0',
                   totalPoint:'0',
                   perPointValue:'',
                   allowance:'',
                   createTime:'',
                },
                formRules: {

                },
                formLoading: false
            }
        },
        methods: {

            handleAdd(index, row) {
                this.formVisible = true;
                this.upPercentage = 0;
                this.upFlag = '';
                this.subform = {
                    id:'0',
                    year:'0',
                    month:'0',
                    enterpriseCode:'',
                    enterpriseName:'',
                    statisticianId:'0',
                    statisticianName:'',
                    retailSalesDone:'0',
                    salesDone:'0',
                    retailSalesPoint:'0',
                    salesPoint:'0',
                    qualifyingPoint:'0',
                    retailCompareRatio:'',
                    saleCompareRatio:'',
                    retailGrowthPoint:'',
                    salesGrowthPoint:'',
                    growthPoint:'0',
                    reportPoint:'0',
                    totalPoint:'0',
                    perPointValue:'',
                    allowance:'',
                    createTime:'',
                };
                this.formTittle = "新增"
            },
            handleEdit(index, row) {
                this.formVisible = true;
                //this.$refs['subform'].resetFields();
                this.subform = Object.assign({}, row);
                this.formTittle = "编辑"
            },
            handleDelete(index, row) {
                this.$confirm('确认删除该记录吗?', '提示', {
                    type: 'warning'
                }).then(() => {
                    let param = {
                        ids: row.id
                    };
                    delStatisticianAssessment(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.formVisible = false;
                            this.getStatisticianAssessmentList();
                            this.$message.success("删除成功");
                        } else {
                      this.$message.error(res.data.message);
                        }
                    });
                }).catch(() => {

                });
            },
            getStatisticianAssessmentList() {
                this.loading = true;
                const self = this;
                let params = {
                    page: this.pageIndex,
                    itemcount: this.pageSize,
                    id: this.queryParam.id,
                    name: this.queryParam.name
                }
                getStatisticianAssessmentList(params).then((res) => {
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
            },
            handleCurrentChange(val) {
                this.pageIndex = val;
                this.getStatisticianAssessmentList()
            },
            formSubmit() {
                this.$refs["subform"].validate((valid) => {
                    if (valid) {
                        this.formLoading = true;
                        let param = Object.assign({}, this.subform);
                        if (param.id != "") {
                            editStatisticianAssessment(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getStatisticianAssessmentList();
                                } else {
                                    this.$message.error(res.data.message);
                                }
                            });
                        } else {
                            createStatisticianAssessment(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getStatisticianAssessmentList();
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
                    delStatisticianAssessment(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.getStatisticianAssessmentList();
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
            this.getStatisticianAssessmentList()
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
