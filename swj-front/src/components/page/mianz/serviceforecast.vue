<template>
    <div class="table">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-menu"></i> 数据上报</el-breadcrumb-item>
                <el-breadcrumb-item>服务业数据上报</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
		<!--工具条-->
        <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
            <el-form :inline="true" :rules="queryRules" ref="queryform" :model="queryParam">
                <el-form-item label="编号" prop="id">
                    <el-input v-model="queryParam.id" :maxlength=10 auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="年度">
                    <el-date-picker
                        v-model="queryParam.year"
                        align="right"
                        type="year"
                        placeholder="选择年度" @change="queryYearChange">
                      </el-date-picker>
                </el-form-item>
                <el-form-item label="月份" prop="month">
                    <el-input v-model="queryParam.month" placeholder="输入月份" :maxlength=2 auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="getServiceForecastList">查询</el-button>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="handleAdd">数据上报</el-button>
                </el-form-item>
            </el-form>
        </el-col>
        <el-table :data="tableData" border style="width: 100%" v-loading.body="loading" @selection-change="selsChange">
            <!-- <el-table-column type="selection" width="70"></el-table-column> -->
             <el-table-column prop="year" width="150" label="年度"></el-table-column>
             <el-table-column prop="month" width="150" label="月份"></el-table-column>
             <el-table-column prop="currMonth" width="150" label="本月金额"></el-table-column>
             <el-table-column prop="currAmount" width="180" label="1至本月累计金额"></el-table-column>
             <el-table-column prop="currAmountRise" width="180" label="1至本月增速"></el-table-column>
            <el-table-column label="操作" width="180">
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
                        <el-form-item label="服务业定义ID" prop="defineId">
                        <el-select v-model="subform.defineId" placeholder="请选择上传指标" :disabled="formReadOnly" @change="changeDefine">
                                <v-yvoption tableName="service_define" label="index_name" value='id' :dataList="dataList"></v-yvoption>
                            </el-select>
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
                            <el-input v-model="subform.month" auto-complete="off" :maxlength=2 :readonly="formReadOnly" :disabled='formDisable'><template slot="append">月</template></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="本月金额" prop="currMonth">
                            <el-input v-model="subform.currMonth" auto-complete="off" :readonly="formReadOnly" :disabled='formDisable'>
                                <template slot="append">千元</template>
                            </el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="1至本月累计金额" prop="currAmount">
                            <el-input v-model="subform.currAmount" auto-complete="off" :readonly="formReadOnly" :disabled='formDisable'>
                                <template slot="append">千元</template>
                            </el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="1至本月增速" prop="currAmountRise">
                            <el-input v-model="subform.currAmountRise" auto-complete="off" :readonly="formReadOnly" :disabled='formDisable'>
                                <template slot="append">%</template>
                            </el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="上年同期金额" prop="lastMonth">
                            <el-input v-model="subform.lastMonth" auto-complete="off" :readonly="formReadOnly" :disabled='formDisable'>
                                <template slot="append">千元</template>
                            </el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="上年同期1至本月金额" prop="lastAmount">
                            <el-input v-model="subform.lastAmount" auto-complete="off" :readonly="formReadOnly" :disabled='formDisable'>
                                <template slot="append">千元</template>
                            </el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="上年同期1至本月增速" prop="lastAmountRise">
                            <el-input v-model="subform.lastAmountRise" auto-complete="off" :readonly="formReadOnly" :disabled='formDisable'>
                                <template slot="append">%</template>
                            </el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="当前主要问题" prop="problem">
                            <el-input type='textarea' :maxlength=200 v-model="subform.problem" auto-complete="off" :readonly="formReadOnly" :disabled='formDisable'></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="拟采取措施" prop="solution">
                            <el-input type='textarea' :maxlength=200 v-model="subform.solution" auto-complete="off" :readonly="formReadOnly" :disabled='formDisable'></el-input>
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
    createServiceForecast,
    getServiceForecastList,
    editServiceForecast,
    delServiceForecast,
    base
} from '../../../api/api';
import vYvoption from '../../common/yvoption.vue';
import {checkMonth,checkMoney,checkRequire,checkPersent,validNum} from '../../../utils/validator.js'
export default {
    data() {
            return {
                dataList:'{depart_id:'+JSON.parse(localStorage.user).departId+'}',
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
                    year: '',
                    month: ''
                },
                subform:{},
                initform: {
                   id:'',
                   defineId:'',
                   year:'',
                   month:'',
                   currMonth:'',
                   currAmount:'',
                   currAmountRise:'',
                   lastMonth:'',
                   lastAmount:'',
                   lastAmountRise:'',
                   problem:'',
                   solution:'',
                },
                formRules: {
                    year:[{validator:checkRequire, required: true,trigger: 'blur'}],
                    month:[{ validator: checkMonth, required: true,trigger: 'blur' }],
                    defineId:[{validator:checkRequire, required: true,trigger: 'blur'}],
                    currMonth:[{validator:checkMoney, required: true,trigger: 'blur'}],
                    currAmount:[{validator:checkMoney, required: true,trigger: 'blur'}],
                    lastMonth:[{validator:checkMoney, required: true,trigger: 'blur'}],
                    lastAmount:[{validator:checkMoney, required: true,trigger: 'blur'}],
                    currAmountRise:[{validator:checkPersent, required: true,trigger: 'blur'}],
                    lastAmountRise:[{validator:checkPersent, required: true,trigger: 'blur'}],
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
                formLoading: false,
                formReadOnly:false,
                formDisable:true
            }
        },
        components:{
            vYvoption,
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
            changeDefine(val){
                if(val != null & val != ''){
                   this.formDisable=false;
                }
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
                    this.formTittle = "查看"
                })
            },
            handleDelete(index, row) {
                this.$confirm('确认删除该记录吗?', '提示', {
                    type: 'warning'
                }).then(() => {
                    let param = {
                        ids: row.id
                    };
                    delServiceForecast(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.formVisible = false;
                            this.getServiceForecastList();
                            this.$message.success("删除成功");
                        } else {
                      this.$message.error(res.data.message);
                        }
                    });
                }).catch(() => {

                });
            },
            getServiceForecastList() {
                this.$refs["queryform"].validate((valid) => {
                    if (valid) {
                        this.loading = true;
                        const self = this;
                        let params = {
                            page: this.pageIndex,
                            itemcount: this.pageSize,
                            id: this.queryParam.id,
                            year: this.queryParam.year,
                            month:this.queryParam.month
                        }
                        getServiceForecastList(params).then((res) => {
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
                this.getServiceForecastList()
            },
            formSubmit() {
                this.$refs["subform"].validate((valid) => {
                    if (valid) {
                        this.formLoading = true;
                        let param = Object.assign({}, this.subform);
                        if (param.id != "") {
                            editServiceForecast(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getServiceForecastList();
                                } else {
                                    this.$message.error(res.data.message);
                                }
                            });
                        } else {
                            createServiceForecast(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getServiceForecastList();
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
                    delServiceForecast(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.getServiceForecastList();
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
            this.getServiceForecastList()
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
