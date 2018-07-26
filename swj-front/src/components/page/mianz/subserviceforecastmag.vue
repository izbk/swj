<template>
    <div class="table">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-menu"></i> 数据上报</el-breadcrumb-item>
                <el-breadcrumb-item>重点服务业数据管理</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <!--工具条-->
        <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
            <el-form :inline="true" :rules="queryRules" ref="queryform" :model="queryParam">
                <el-form-item label="编号" prop="id">
                    <el-input v-model="queryParam.id" :maxlength=10 auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="企业名称">
                    <el-input v-model="queryParam.enterpriseName" :maxlength=20 auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="年份">
                    <el-date-picker
                        v-model="queryParam.year"
                        align="right"
                        type="year"
                        placeholder="选择年度" @change="queryYearChange">
                    </el-date-picker>   
                </el-form-item>
                <el-form-item label="月份" prop="month">
                    <el-input v-model="queryParam.month" :maxlength=2 auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="getServiceMonthlyReportList">查询</el-button>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="handleAdd">新增</el-button>
                </el-form-item>
            </el-form>
        </el-col>
        <el-table :data="tableData" border style="width: 100%" v-loading.body="loading" @selection-change="selsChange">
            <el-table-column type="selection" width="70"></el-table-column>
             <el-table-column prop="enterpriseName" width="160" label="企业名称"></el-table-column>
             <el-table-column prop="year" width="160" label="年度"></el-table-column>
             <el-table-column prop="month" width="160" label="月份"></el-table-column>
             <el-table-column prop="currMonth" width="180" label="本年本月(千元)"></el-table-column>
             <el-table-column prop="lastMonth" width="180" label="上年同期(千元)"></el-table-column>
             <el-table-column prop="currMonthAmount" width="180" label="本年1-本月(千元)"></el-table-column>
             <el-table-column prop="lastMonthAmount" width="180" label="上年1-本月(千元)"></el-table-column>
            <el-table-column prop="createTime" label="创建时间" width="260">
                <template scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.createTime|time }}</span>
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
                        <el-form-item label="年度" prop="year">
                            <el-date-picker
                                v-model="yearFormat"
                                align="right"
                                type="year"
                                placeholder="选择年度" @change="subformYearChange">
                              </el-date-picker>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="月份" prop="month">
                            <el-input v-model="subform.month" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="本年本月" prop="currMonth">
                            <el-input v-model="subform.currMonth" auto-complete="off">
                                <template slot="append">千元</template>
                            </el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="上年同期" prop="lastMonth">
                            <el-input v-model="subform.lastMonth" auto-complete="off">
                                <template slot="append">千元</template>
                            </el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="本年1-本月" prop="currMonthAmount">
                            <el-input v-model="subform.currMonthAmount" auto-complete="off">
                                <template slot="append">千元</template>
                            </el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="上年1-本月" prop="lastMonthAmount">
                            <el-input v-model="subform.lastMonthAmount" auto-complete="off">
                                <template slot="append">千元</template>
                            </el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="创建时间" prop="createTime">
                            <el-date-picker type="datetime" placeholder="选择日期" v-model="subform.createTime" disabled></el-date-picker>
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
    createServiceMonthlyReport,
    getServiceMonthlyReportList,
    editServiceMonthlyReport,
    delServiceMonthlyReport,
    base
} from '../../../api/api';
import vYvoption from '../../common/yvoption.vue';
import vYvtableoption from '../../common/yvtableoption.vue';
import {checkMonth,checkMoney,checkRequire,checkPersent,validNum} from '../../../utils/validator.js'
export default {
    data() {
            return {
                tableData: [],
                pageIndex: 1,
                pageSize: 9,
                totalCount: 0,
                loading: true,
                sels: [],
                //form数据
                formTittle: '',
                formVisible: false,
                queryParam: {
                    id: '',
                    enterpriseName: '',
                    year:'',
                    month:''
                },
                subform:{},
                initform: {
                   id:'',
                   userId:'',
                   enterpriseName:'',
                   currMonth:'',
                   lastMonth:'',
                   currMonthAmount:'',
                   lastMonthAmount:'',
                   year:'',
                   month:'',
                   createTime:'',
                },
                formRules: {
                    year:[{validator:checkRequire, required: true,trigger: 'blur'}],
                    month:[{ validator: checkMonth, required: true,trigger: 'blur' }],
                    currMonth:[{validator:checkMoney, required: true,trigger: 'blur'}],
                    currMonthAmount:[{validator:checkMoney, required: true,trigger: 'blur'}],
                    lastMonth:[{validator:checkMoney, required: true,trigger: 'blur'}],
                    lastMonthAmount:[{validator:checkMoney, required: true,trigger: 'blur'}],
                },
                queryRules: {
                    id: [{
                        validator: validNum,
                        trigger: 'blur'
                    }],
                    month: [{
                        validator: validNum,
                        trigger: 'blur'
                    }],
                },
                formLoading: false
            }
        },
        components:{
            vYvoption,
            vYvtableoption
        },
        computed:{
            yearFormat:{
                 get: function () {
                  if(this.subform.year!=null &&this.subform.year != ""){
                    return new Date(this.subform.year.toString());
                    }
                },
                set:function(newValue){
                    this.subform.year = newValue;
                }
            }
        },     
        methods: {
            subformYearChange(val){
                this.subform.year = val;
            },
            queryYearChange(val){
                this.queryParam.year = val;
            },
            handleAdd(index, row) {
                this.formVisible = true;
                this.$nextTick(function () {
                    this.subform = Object.assign({}, this.initform);
                    this.$refs['subform'].resetFields();
                    this.formTittle = "新增"
                })
            },
            handleEdit(index, row) {
                this.formVisible = true;
                this.subform = Object.assign({}, row);
                this.$refs['subform'].resetFields();
                this.formTittle = "编辑"
            },
            handleDelete(index, row) {
                this.$confirm('确认删除该记录吗?', '提示', {
                    type: 'warning'
                }).then(() => {
                    let param = {
                        ids: row.id
                    };
                    delServiceMonthlyReport(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.formVisible = false;
                            this.getServiceMonthlyReportList();
                            this.$message.success("删除成功");
                        } else {
                      this.$message.error(res.data.message);
                        }
                    });
                }).catch(() => {

                });
            },
            getServiceMonthlyReportList() {
                this.$refs["queryform"].validate((valid) => {
                    if (valid) {
                        this.loading = true;
                        const self = this;
                        let params = {
                            page: this.pageIndex,
                            itemcount: this.pageSize,
                            id: this.queryParam.id,
                            enterpriseName: this.queryParam.enterpriseName,
                            year: this.queryParam.year,
                            month: this.queryParam.month,
                        }
                        getServiceMonthlyReportList(params).then((res) => {
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
                this.getServiceMonthlyReportList()
            },
            formSubmit() {
                this.$refs["subform"].validate((valid) => {
                    if (valid) {
                        this.formLoading = true;
                        let param = Object.assign({}, this.subform);
                        if (param.id != "") {
                            editServiceMonthlyReport(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getServiceMonthlyReportList();
                                } else {
                                    this.$message.error(res.data.message);
                                }
                            });
                        } else {
                            createServiceMonthlyReport(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getServiceMonthlyReportList();
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
                    delServiceMonthlyReport(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.getServiceMonthlyReportList();
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
            this.getServiceMonthlyReportList()
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
