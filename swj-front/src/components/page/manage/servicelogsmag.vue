<template>
    <div class="table">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-menu"></i> 系统管理</el-breadcrumb-item>
                <el-breadcrumb-item>系统日志管理</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
		<!--工具条-->
        <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
            <el-form :inline="true" :rules="queryRules" ref="queryform" :model="queryParam">
                <el-form-item label="编号" prop="id">
                    <el-input v-model="queryParam.id" :maxlength=10 auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="操作人名称">
                    <el-input v-model="queryParam.userName" :maxlength=30 auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="日志内容">
                    <el-input v-model="queryParam.logContent" :maxlength=30 auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="getServiceLogsList">查询</el-button>
                </el-form-item>
                <el-form-item>
                    <!-- <el-button type="primary" @click="handleAdd">新增</el-button> -->
                </el-form-item>
            </el-form>
        </el-col>
        <el-table :data="tableData" border style="width: 100%" v-loading.body="loading" @selection-change="selsChange">
            <el-table-column type="selection" width="70"></el-table-column>
             <el-table-column prop="id" label="主键ID" width="150"></el-table-column>
             <el-table-column prop="userId" label="操作人ID" width="150"></el-table-column>
             <el-table-column prop="userName" label="操作人姓名" width="150"></el-table-column>
            <el-table-column prop="operateTime" label="操作时间" width="260">
                <template scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.operateTime|time }}</span>
                </template>
            </el-table-column>
             <el-table-column prop="busiId" label="业务ID" width="150"></el-table-column>
             <el-table-column prop="logContent" label="日志内容" width="150"></el-table-column>
             <el-table-column prop="ip" label="IP地址" width="150"></el-table-column>
            <el-table-column label="操作" width="180">
                <template scope="scope">
                    <!-- <el-button size="small" @click="handleEdit(scope.$index, scope.row)">编辑</el-button> -->
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
                        <el-form-item label="主键ID" prop="id" >
                            <el-input v-model="subform.id" auto-complete="off" disabled></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="操作人ID" prop="userId">
                            <el-input v-model="subform.userId" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="操作人姓名" prop="userName">
                            <el-input v-model="subform.userName" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="操作时间" prop="operateTime">
                            <el-date-picker type="datetime" placeholder="选择日期" v-model="subform.operateTime"></el-date-picker>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="业务ID" prop="busiId">
                            <el-input v-model="subform.busiId" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="日志内容" prop="logContent">
                            <el-input v-model="subform.logContent" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="IP地址" prop="ip">
                            <el-input v-model="subform.ip" auto-complete="off"></el-input>
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
    createServiceLogs,
    getServiceLogsList,
    editServiceLogs,
    delServiceLogs,
    base
} from '../../../api/api';
import vYvoption from '../../common/yvoption.vue';
import vYvtableoption from '../../common/yvtableoption.vue';
import {checkMoney,checkRequire,checkNum,validNum} from '../../../utils/validator.js';
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
                    userName: '',
                    logContent:''
                },
                subform: {},
                initform: {
                   id:'',
				   userId:0,
                   userName:'',
                   operateTime:'',
				   busiId:0,
                   logContent:'',
                   ip:'',
                },
                formRules: {
					id:[{validator:checkRequire, required: true,trigger: 'blur'}],
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
        components:{
            vYvoption,
            vYvtableoption
        },        
        methods: {
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
                    delServiceLogs(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.formVisible = false;
                            this.getServiceLogsList();
                            this.$message.success("删除成功");
                        } else {
                      this.$message.error(res.data.message);
                        }
                    });
                }).catch(() => {

                });
            },
            getServiceLogsList() {
                this.$refs["queryform"].validate((valid) => {
                    if (valid) {
                        this.loading = true;
                        const self = this;
                        let params = {
                            page: this.pageIndex,
                            itemcount: this.pageSize,
                            id: this.queryParam.id,
                            logContent: this.queryParam.logContent,
                            userName: this.queryParam.userName
                        }
                        getServiceLogsList(params).then((res) => {
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
                this.getServiceLogsList()
            },
            formSubmit() {
                this.$refs["subform"].validate((valid) => {
                    if (valid) {
                        this.formLoading = true;
                        let param = Object.assign({}, this.subform);
                        if (param.id != "") {
                            editServiceLogs(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getServiceLogsList();
                                } else {
                                    this.$message.error(res.data.message);
                                }
                            });
                        } else {
                            createServiceLogs(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getServiceLogsList();
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
                    delServiceLogs(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.getServiceLogsList();
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
            this.getServiceLogsList()
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
