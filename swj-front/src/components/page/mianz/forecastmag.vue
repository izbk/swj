<template>
    <div class="table">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-menu"></i> 数据预测</el-breadcrumb-item>
                <el-breadcrumb-item>总量预测</el-breadcrumb-item>
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
                        clearable
                        type="year"
                        placeholder="选择年度" @change="queryYearChange">
                      </el-date-picker>
                </el-form-item>
                <el-form-item label="月份" prop="month">
                    <el-input v-model="queryParam.month" :maxlength=2 auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="getForecastList">查询</el-button>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="handleAdd">数据预测</el-button>
                </el-form-item>
            </el-form>
        </el-col>
        <el-table :data="tableData" border style="width: 100%" v-loading.body="loading" @selection-change="selsChange">
            <el-table-column type="selection" width="70"></el-table-column>
            <el-table-column prop="year" width="150" label="年度"></el-table-column>
            <el-table-column prop="month" width="130" label="月份"></el-table-column>
            <el-table-column prop="currRise" width="180" label="本期限上增幅"></el-table-column>
            <el-table-column prop="currMonthAmount" width="220" label="本月累计限上预测数"></el-table-column>
            <el-table-column prop="currMonth" width="180" label="本月限上预测数"></el-table-column>
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
                </el-row>
                <el-collapse v-model="activeNames">
                    <el-collapse-item title="预测条件" name="1">
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
                            <el-form-item label="新增限上同期数" prop="lastAdd">
                                <el-input v-model="subform.lastAdd" auto-complete="off">
                                    <template slot="append">千元</template>
                                </el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span='12'>
                            <el-form-item label="本期限上增幅" prop="currRise">
                                <el-input v-model="subform.currRise" auto-complete="off">
                                    <template slot="append">%</template>
                                </el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span='12'>
                            <el-form-item label="本期限下增幅" prop="currUnderRise">
                                <el-input v-model="subform.currUnderRise" auto-complete="off">
                                    <template slot="append">%</template>
                                </el-input>
                            </el-form-item>
                        </el-col>
                        
                    </el-collapse-item>
                    <el-row style="margin-top:10px">
                        <el-col :span='2' :offset="12">
                            <el-button type="primary" @click.native="calcSubmit" :loading="calcLoading" class="el-icon-caret-bottom ">预测</el-button>
                        </el-col>
                    </el-row>
                    <el-collapse-item title="预测结果" name="2">
                        <el-row>
                            <el-col :span='12'>
                                <el-form-item label="同期总量" prop="lastAmount">
                                    <el-input v-model="subform.lastAmount" auto-complete="off" readonly>
                                        <template slot="append">千元</template>
                                    </el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span='12'>
                                <el-form-item label="本月累计限上预测数" prop="currMonthAmount">
                                    <el-input v-model="subform.currMonthAmount" auto-complete="off" readonly>
                                        <template slot="append">千元</template>
                                    </el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span='12'>
                                <el-form-item label="本月限上预测数" prop="currMonth">
                                    <el-input v-model="subform.currMonth" auto-complete="off" readonly>
                                        <template slot="append">千元</template>
                                    </el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span='12'>
                                <el-form-item label="本期总量增幅" prop="currAmountRise">
                                    <el-input v-model="subform.currAmountRise" auto-complete="off" readonly>
                                        <template slot="append">%</template>
                                    </el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span='12'>
                                <el-form-item label="本期累计总量" prop="currAmount">
                                    <el-input v-model="subform.currAmount" auto-complete="off" readonly>
                                        <template slot="append">千元</template>
                                    </el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span='12'>
                                <el-form-item label="同期限上占比" prop="lastRatio">
                                    <el-input v-model="subform.lastRatio" auto-complete="off" readonly>
                                        <template slot="append">%</template>
                                    </el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span='12'>
                                <el-form-item label="同期限下占比" prop="lastUnderRatio">
                                    <el-input v-model="subform.lastUnderRatio" auto-complete="off" readonly>
                                        <template slot="append">%</template>
                                    </el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span='12'>
                                <el-form-item label="同期限上未调整" prop="lastNoAdjust">
                                    <el-input v-model="subform.lastNoAdjust" auto-complete="off" readonly>
                                        <template slot="append">千元</template>
                                    </el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span='12'>
                                <el-form-item label="同期限上已调整" prop="lastAdjusted">
                                    <el-input v-model="subform.lastAdjusted" auto-complete="off" readonly>
                                        <template slot="append">千元</template>
                                    </el-input>
                                </el-form-item>
                            </el-col>
                        </el-row>
                    </el-collapse-item>
                </el-collapse>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click.native="formVisible = false">取消</el-button>
                <el-button type="primary" @click.native="formSubmit" :loading="formLoading">生成预测数据</el-button>
            </div>
        </el-dialog>
    </div>
</template>
<script>
import {
    createForecast,
    getForecastList,
    editForecast,
    delForecast,
    calcForecast,
    base
} from '../../../api/api';
import vYvoption from '../../common/yvoption.vue';
import vYvtableoption from '../../common/yvtableoption.vue';
import {checkMoneyNull,checkPersent,checkMonth,checkRequire,validNum} from '../../../utils/validator.js'
export default {
    data() {
            return {
                calcLoading:false,
                activeNames: ['1', '2'],
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
                    year: '',
                    month:''
                },
                subform:{},
                initform: {
                    id: '',
                    year: '',
                    month: '',
                    lastAdd: "",
                    lastAmount: '',
                    currRise: "",
                    currUnderRise: "",
                    currMonthAmount: '',
                    currMonth: '',
                    currAmountRise: '',
                    currAmount: '',
                    lastRatio: '',
                    lastUnderRatio: '',
                    lastNoAdjust: '',
                    lastAdjusted: '',
                },
                formRules: {
                    year:[{validator:checkRequire, required: true,trigger: 'blur'}],
                    month:[{ validator: checkMonth, required: true,trigger: 'blur' }],
                    lastAdd:[{validator:checkMoneyNull, trigger: 'blur'}],
                    currRise:[{validator:checkPersent, required: true,trigger: 'blur'}],
                    currUnderRise:[{validator:checkPersent, required: true,trigger: 'blur'}],
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
        components: {
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
                this.$nextTick(function () {
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
                    delForecast(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.formVisible = false;
                            this.getForecastList();
                            this.$message.success("删除成功");
                        } else {
                            this.$message.error(res.data.message);
                        }
                    });
                }).catch(() => {

                });
            },
            getForecastList() {
                this.$refs["queryform"].validate((valid) => {
                    if (valid) {
                        this.loading = true;
                        const self = this;
                        let params = {
                            page: this.pageIndex,
                            itemcount: this.pageSize,
                            id: this.queryParam.id,
                            name: this.queryParam.name
                        }
                        getForecastList(params).then((res) => {
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
                this.getForecastList()
            },
            calcSubmit(){
                this.$refs["subform"].validate((valid) => {
                    if (valid) {
                        this.calcLoading = true;
                        let param = Object.assign({}, this.subform);
                        calcForecast(param).then((res) => {
                            this.calcLoading = false;
                            if (res.data.code == '000000') {
                                this.$message.success("预测成功");
                                this.subform = res.data.data[0];
                            } else {
                                this.$message.error(res.data.message);
                            }
                        });
                    } else {
                        return false;
                    }
                })
            },
            formSubmit() {
                this.$refs["subform"].validate((valid) => {
                    if (valid) {
                        this.formLoading = true;
                        let param = Object.assign({}, this.subform);
                        if (param.id != "" & param.id != null) {
                            editForecast(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getForecastList();
                                } else {
                                    this.$message.error(res.data.message);
                                }
                            });
                        } else {
                            createForecast(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getForecastList();
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
                    delForecast(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.getForecastList();
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
            this.getForecastList()
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
