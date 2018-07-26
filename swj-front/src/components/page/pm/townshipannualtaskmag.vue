<template>
    <div class="table">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-menu"></i> 绩效管理</el-breadcrumb-item>
                <el-breadcrumb-item>镇乡年度目标任务表管理</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <!--工具条-->
        <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
            <el-form :inline="true" :rules="queryRules" ref="queryform" :model="queryParam">
                <el-form-item label="编号" prop="id">
                    <el-input v-model="queryParam.id" :maxlength=10 auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="镇乡名称">
                    <el-input v-model="queryParam.townshipName" :maxlength=30 auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="年度">
                    <el-date-picker v-model="queryParam.year" align="right" clearable type="year" placeholder="选择年度" @change="queryYearChange">
                    </el-date-picker>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="getTownshipAnnualTaskList">查询</el-button>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="handleAdd">新增</el-button>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="getExportUrl"><a :href="exportUrl" style="color:#fff" target="_blank">导出</a></el-button>
                </el-form-item>
            </el-form>
        </el-col>
        <el-table :data="tableData" border style="width: 100%" v-loading.body="loading" @selection-change="selsChange">
            <el-table-column type="selection" width="70"></el-table-column>
            <el-table-column prop="townshipName" label="镇乡名称" width="220"></el-table-column>
            <el-table-column prop="year" label="年度" width="150"></el-table-column>
            <el-table-column prop="retailSalesTask" label="零售额总量目标" width="220"></el-table-column>
            <el-table-column prop="salesTask" label="销售额总量目标" width="220"></el-table-column>
            <el-table-column prop="totalTask" label="目标总任务" width="150"></el-table-column>
            <el-table-column prop="addTask" label="新增入库目标个数" width="220"></el-table-column>
            <el-table-column prop="createBy" label="创建人" width="160">
                <template scope="scope">
                    <v-yvtableoption tableName="user" label="nick_name" value='id' :trueValue="scope.row.createBy"></v-yvtableoption>
                </template>
            </el-table-column>
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
                        <el-form-item label="乡镇ID" prop="townshipId">
                            <el-select v-model="subform.townshipId" style="width:90%" @change="changeTown" ref="townCode" clearable>
                                <v-yvoption tableName="township" label="name" value='id'></v-yvoption>
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="镇乡名称" prop="townshipName">
                            <el-input disabled v-model="subform.townshipName" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="年度" prop="year">
                            <el-date-picker v-model="yearFormat" align="right" clearable type="year" placeholder="选择年度" @change="subformYearChange">
                            </el-date-picker>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="零售额总量目标" prop="retailSalesTask">
                            <el-input v-model="subform.retailSalesTask" auto-complete="off">
                                <template slot="append">千元</template>
                            </el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="销售额总量目标" prop="salesTask">
                            <el-input v-model="subform.salesTask" auto-complete="off">
                                <template slot="append">千元</template>
                            </el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="目标总任务" prop="totalTask">
                            <el-input disabled v-model="subform.totalTask" auto-complete="off">
                                <template slot="append">千元</template>
                            </el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="新增入库目标个数" prop="addTask">
                            <el-input v-model="subform.addTask" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="实际入库申报数量" prop="totalApply">
                            <el-input v-model="subform.totalApply" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span='12'>
                        <el-form-item label="创建人" prop="createBy">
                            <el-select disabled v-model="subform.createBy" style="width:90%" clearable>
                                <v-yvoption tableName="user" label="nick_name" value='id'></v-yvoption>
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="创建时间" prop="createTime">
                            <el-date-picker disabled type="datetime" placeholder="选择日期" v-model="subform.createTime"></el-date-picker>
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
    createTownshipAnnualTask,
    getTownshipAnnualTaskList,
    editTownshipAnnualTask,
    delTownshipAnnualTask,
    base
} from '../../../api/api';
import vYvoption from '../../common/yvoption.vue';
import vYvtableoption from '../../common/yvtableoption.vue';
import {
    checkMoney,
    checkRequire,
    checkNum,
    validNum
} from '../../../utils/validator.js';
export default {
    data() {
            return {
                exportUrl: base + "/townshipAnnualTasks/export",
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
                    townshipName: '',
                    year: ''
                },
                subform: {},
                initform: {
                    id: '',
                    townshipId: '',
                    townshipName: '',
                    retailSalesTask: '',
                    salesTask: '',
                    totalTask: '',
                    addTask: '',
                    year: '',
                    totalApply: '',
                    createBy: '',
                    createTime: '',
                },
                formRules: {
                    townshipId: [{
                        validator: checkRequire,
                        required: true,
                        trigger: 'blur'
                    }],
                    year: [{
                        validator: checkRequire,
                        required: true,
                        trigger: 'blur'
                    }],
                    retailSalesTask: [{
                        validator: checkMoney,
                        required: true,
                        trigger: 'blur'
                    }],
                    salesTask: [{
                        validator: checkMoney,
                        required: true,
                        trigger: 'blur'
                    }],
                    addTask: [{
                        validator: checkNum,
                        required: true,
                        trigger: 'blur'
                    }],
                    totalApply: [{
                        validator: validNum,
                        trigger: 'blur'
                    }],
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
        computed: {
            yearFormat: {
                get: function() {
                    if (this.subform.year != null && this.subform.year != "") {
                        return new Date(this.subform.year.toString());
                    }
                },
                set: function(newValue) {
                    this.subform.year = newValue;
                }
            }
        },
        methods: {
            getExportUrl() {
                this.exportUrl = base + "/townshipAnnualTasks/export?id=" + this.queryParam.id + "&year=" + this.queryParam.year + "&townshipName=" + this.queryParam.townshipName;
            },
            subformYearChange(val) {
                this.subform.year = val;
            },
            queryYearChange(val) {
                this.queryParam.year = val;
            },
            changeTown(val) {
                if (val != null & val != '') {
                    this.subform.townshipName = this.$refs['townCode'].selectedLabel;
                }

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
                    delTownshipAnnualTask(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.formVisible = false;
                            this.getTownshipAnnualTaskList();
                            this.$message.success("删除成功");
                        } else {
                            this.$message.error(res.data.message);
                        }
                    });
                }).catch(() => {

                });
            },
            getTownshipAnnualTaskList() {
                this.$refs["queryform"].validate((valid) => {
                    if (valid) {
                        this.loading = true;
                        const self = this;
                        let params = {
                            page: this.pageIndex,
                            itemcount: this.pageSize,
                            id: this.queryParam.id,
                            townshipName: this.queryParam.townshipName,
                            year: this.queryParam.year
                        }
                        getTownshipAnnualTaskList(params).then((res) => {
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
                this.getTownshipAnnualTaskList()
            },
            formSubmit() {
                this.$refs["subform"].validate((valid) => {
                    if (valid) {
                        this.formLoading = true;
                        let param = Object.assign({}, this.subform);
                        if (param.id != "") {
                            editTownshipAnnualTask(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getTownshipAnnualTaskList();
                                } else {
                                    this.$message.error(res.data.message);
                                }
                            });
                        } else {
                            createTownshipAnnualTask(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getTownshipAnnualTaskList();
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
                    delTownshipAnnualTask(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.getTownshipAnnualTaskList();
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
            this.getTownshipAnnualTaskList()
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
