<template>
    <div class="table">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-menu"></i> 数据上报</el-breadcrumb-item>
                <el-breadcrumb-item>企业数据上报管理</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
		<!--工具条-->
        <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
            <el-form :inline="true" :rules="queryRules" ref="queryform" :model="queryParam">
                <el-form-item label="编号" prop="id">
                    <el-input v-model="queryParam.id" :maxlength=10 auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="企业名称">
                    <el-input v-model="queryParam.enterpriseName" :maxlength=50 auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="数据日期">
                    <el-date-picker type="date" v-model="queryParam.createTime" clearable :editable=false></el-date-picker>
                </el-form-item><br>
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
                    <el-button type="primary" @click="getEnterpriseReportList">查询</el-button>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="handleAdd">数据上报</el-button>
                </el-form-item>
            </el-form>
        </el-col>
        <el-table :data="tableData" border style="width: 100%" v-loading.body="loading" @selection-change="selsChange" :row-class-name="showcolor">
            <!-- <el-table-column type="selection" width="70"></el-table-column> -->
             <el-table-column prop="enterpriseCode" width="150" label="企业代码" ></el-table-column>
             <el-table-column prop="enterpriseName" width="240" label="企业名称" ></el-table-column>
             <el-table-column prop="sales" width="150" label="销售额" ></el-table-column>
             <el-table-column prop="retailSales" width="150" label="零售额" ></el-table-column>
             <el-table-column prop="sntqRetailSales" width="180" label="同期数" ></el-table-column>
             <el-table-column prop="year" width="150" label="年度" ></el-table-column>
             <el-table-column prop="month" width="130" label="月份" ></el-table-column>
             <el-table-column prop="createTime" width="170" label="数据日期" >
                 <template scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.createTime|date }}</span>
                </template>
             </el-table-column>
            <el-table-column label="操作" width="180" fixed="right">
                <template scope="scope">
                    <el-button size="small" type="primary" @click="handleEdit(scope.$index, scope.row)">查看</el-button>
                    <!-- <el-button size="small" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button> -->
                </template>
            </el-table-column>
        </el-table>
        <el-row type="flex" justify="space-between" style="margin-top:10px">
            <el-col :span='12'>
                <!-- <el-button type="danger" @click="batchRemove">批量删除</el-button> -->
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
                        <el-form-item label="企业代码" prop="enterpriseCode">
                            <el-select :disabled="formReadOnly" v-model="subform.enterpriseCode" placeholder="请先选择企业代码后继续" @change="changeCom" ref="comCode">
                                <v-yvoption tableName="enterprise" label="enterprise_name" value='enterprise_code' :dataList="dataList"></v-yvoption>
                            </el-select>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="企业名称" prop="enterpriseName">
                            <el-input :readonly="formReadOnly" v-model="subform.enterpriseName" auto-complete="off" disabled></el-input>
                        </el-form-item>
                    </el-col>
                    </el-row>
                    <el-row>
                    <el-col :span='12'>
                        <el-form-item label="年度" prop="year">
                            <el-date-picker
                                v-model="yearFormat"
                                align="right"
                                type="year"
                                placeholder="选择年度" @change="subformYearChange" :readonly="formReadOnly" :disabled='formDisable'>
                              </el-date-picker>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="月份" prop="month">
                            <el-input @blur="getTongqi" :readonly="formReadOnly" v-model="subform.month" auto-complete="off" :disabled='formDisable'></el-input>
                        </el-form-item>
                    </el-col>
                    
                <el-col :span='12'>
                        <el-form-item label="销售额" prop="sales">
                            <el-input :readonly="formReadOnly" v-model="subform.sales" auto-complete="off" :disabled='formDisable'>
                                <template slot="append">千元</template>
                            </el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="零售额" prop="retailSales">
                            <el-input :readonly="formReadOnly" v-model="subform.retailSales" auto-complete="off" :disabled='formDisable'>
                                <template slot="append">千元</template>
                            </el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="同期数" prop="sntqRetailSales">
                            <el-input :readonly="formReadOnly" v-model="subform.sntqRetailSales" auto-complete="off" readonly>
                                <template slot="append">千元</template>
                            </el-input>
                        </el-form-item>
                    </el-col>
                    
                <el-col :span='12'>
                        <el-form-item label="数据日期" prop="createTime">
                            <el-date-picker type="date" v-model="subform.createTime" readonly></el-date-picker>
                        </el-form-item>
                    </el-col>
            </el-row>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click.native="formVisible = false">取消</el-button>
                <el-button type="primary" v-show="!formReadOnly" @click.native="formSubmit" :loading="formLoading">提交</el-button>
            </div>
        </el-dialog>
    </div>
</template>
<script>
import {
    createEnterpriseReport,
    getEnterpriseReportList,
    editEnterpriseReport,
    delEnterpriseReport,
    getEnterpriseReportTqs,
    base
} from '../../../api/api';
import vYvoption from '../../common/yvoption.vue';
import vYvtableoption from '../../common/yvtableoption.vue';
import vYvexcelimport from '../../common/yvexcelimport.vue';
import {checkMoney,checkRequire,checkMonth,validNum} from '../../../utils/validator.js'
export default {
    data() {
            return {
                formReadOnly:false,
                formDisable:false,
                dataList:'{user_id:'+JSON.parse(localStorage.user).id+'}',
                uploadUrl: base + "/enterpriseReports/import",
                exportUrl: base+"/enterpriseReports/export",
                templateUrl: base + "/enterpriseReports/exportTpl",
                fileLoading:false,
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
                    enterpriseName: '',
                    year:'',
                    month:'',
                    createTime:''
                },
                subform:{},
                initform: {
                   id:'',
                   enterpriseCode:'',
                   enterpriseName:'',
                   sales:'',
                   retailSales:'',
                   forecastRetailSales:'',
                   sntqRetailSales:"",
				   year:'',
				   month:'',
                   createTime:'',
                   flag:''
                },
                formRules: {
                    year:[{validator:checkRequire, required: true,trigger: 'blur'}],
                    month:[{ validator: checkMonth, required: true,trigger: 'blur' }],
                    sales:[{validator:checkMoney, required: true,trigger: 'blur'}],
                    retailSales:[{validator:checkMoney, required: true,trigger: 'blur'}],
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
            vYvtableoption,
            vYvexcelimport
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
                this.getTongqi();
            },
            queryYearChange(val){
                this.queryParam.year = val;
            },
            changeCom(val){
                if(val != null & val != ''){
                   this.formDisable=false;
                    this.subform.enterpriseName=this.$refs['comCode'].selectedLabel; 
                    this.getTongqi();
                }
                
            },
            showcolor(row,index){
                // if(row.flag=='2'){
                //     return "cred";
                // }else if(row.flag=='1'){
                //     return "cblue"
                // }else if(row.flag=='0'){
                //     return "cgreen"
                // }
                return "black"
                
            },
            handleAdd(index, row) {
                this.formVisible = true;
                this.$nextTick(function () {
                    this.formDisable=true;
                    this.formReadOnly=false;
                    this.subform = Object.assign({}, this.initform);
                    this.$refs['subform'].resetFields();
                    this.formTittle = "新增"
                })
            },
            handleEdit(index, row) {
                this.formVisible = true;
                this.$nextTick(function () {
                    this.formReadOnly=true;
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
                    delEnterpriseReport(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.formVisible = false;
                            this.getEnterpriseReportList();
                            this.$message.success("删除成功");
                        } else {
                      this.$message.error(res.data.message);
                        }
                    });
                }).catch(() => {

                });
            },
            getEnterpriseReportList() {
                this.$refs["queryform"].validate((valid) => {
                    if (valid) {
                        this.loading = true;
                        const self = this;
                        let params = {
                            page: this.pageIndex,
                            itemcount: this.pageSize,
                            id: this.queryParam.id,
                            enterpriseName: this.queryParam.enterpriseName,
                            year:this.queryParam.year,
                            month:this.queryParam.month,
                            createTime:this.queryParam.createTime
                        }
                        getEnterpriseReportList(params).then((res) => {
                            this.loading = false;
                            if (res.data.code == '000000') {
                                this.tableData = res.data.data.enterpriseReportLt;
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
                this.getEnterpriseReportList()
            },
            formSubmit() {
                this.$refs["subform"].validate((valid) => {
                    if (valid) {
                        this.formLoading = true;
                        let param = Object.assign({}, this.subform);
                        if (param.id != "") {
                            editEnterpriseReport(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getEnterpriseReportList();
                                } else {
                                    this.$message.error(res.data.message);
                                }
                            });
                        } else {
                            createEnterpriseReport(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getEnterpriseReportList();
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
                this.$confirm('确认删除选中记录吗？', '提示', {
                    type: 'warning'
                }).then(() => {
                    let param = {
                        ids: ids
                    };
                    delEnterpriseReport(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.getEnterpriseReportList();
                            this.$message.success("删除成功");
                        } else {
                            this.$message.error(res.data.message);
                        }
                    });
                }).catch(() => {

                });
            },
            getTongqi() {
                    let param = {
                        enterpriseCode: this.subform.enterpriseCode,
                        year:this.subform.year,
                        month:this.subform.month
                    };
                    if(param.enterpriseCode&&param.year&&param.month){
                            getEnterpriseReportTqs(param).then((res) => {
                            if (res.data.code == '000000') {
                                this.subform.sntqRetailSales = res.data.data;
                            } else {
                                this.$message.error(res.data.message);
                            }
                        });
                    }else{
                        this.subform.sntqRetailSales = "";
                    }
                    
            },
        },
        mounted: function() {
            this.getEnterpriseReportList()
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
.cred{
    color: red;
    font-weight: bold;
}
.cblue{
    color: blue;
    font-weight: bold;
}
.cgreen{
    color:green;
    font-weight: bold;
}
</style>
