<template>
    <div class="table">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-menu"></i> 微信</el-breadcrumb-item>
                <el-breadcrumb-item>通知下发管理</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <!--工具条-->
        <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
            <el-form :inline="true" :rules="queryRules" ref="queryform" :model="queryParam">
                <el-form-item label="编号" prop="id">
                    <el-input v-model="queryParam.id" :maxlength=10 auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="通知类型">
                    <el-select v-model="queryParam.noticeType" clearable placeholder="请选择通知类型">
                        <v-yvoption groupName="noticeType"></v-yvoption>
                    </el-select>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="getWeixinTemplateList">查询</el-button>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="handleAdd">新增</el-button>
                </el-form-item>
            </el-form>
        </el-col>
        <el-table :data="tableData" border style="width: 100%" v-loading.body="loading" @selection-change="selsChange">
            <el-table-column type="selection" width="70"></el-table-column>
            <el-table-column prop="noticeType" label="通知类型">
                <template scope="scope">
                    <v-yvtableoption groupName="noticeType" :trueValue="scope.row.noticeType"></v-yvtableoption>
                </template>
            </el-table-column>
            <el-table-column prop="content" label="通知内容"></el-table-column>
            <el-table-column prop="remark" label="备注"></el-table-column>
            <el-table-column label="操作" width="280">
                <template scope="scope">
                    <el-button size="small" type="primary" @click="userSendVisible=true;tmpId=scope.row.id">下发通知</el-button>
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
                        <el-form-item label="通知类型" prop="noticeType">
                            <el-select v-model="subform.noticeType" placeholder="请选择通知类型">
                                <v-yvoption groupName="noticeType"></v-yvoption>
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :span='24'>
                        <el-form-item label="通知内容" prop="content">
                            <el-input type="textarea" :maxlength=200 v-model="subform.content" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='24'>
                        <el-form-item label="备注" prop="remark">
                            <el-input type="textarea" :maxlength=200 v-model="subform.remark" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click.native="formVisible = false">取消</el-button>
                <el-button type="primary" @click.native="formSubmit" :loading="formLoading">提交</el-button>
            </div>
        </el-dialog>
        <!--选择用户下发通知-->
        <v-usersend :userSendVisible="userSendVisible" :tmpId="tmpId" v-if='userSendVisible' @on-select-change="userSelectChange" @on-visible-change='userSendVisibleChange'></v-usersend>
    </div>
</template>
<script>
import {
    createWeixinTemplate,
    getWeixinTemplateList,
    editWeixinTemplate,
    delWeixinTemplate,
    sendWeixinTemplate,
    base
} from '../../../api/api';
import vYvoption from '../../common/yvoption.vue';
import vYvtableoption from '../../common/yvtableoption.vue';
import {
    validNum
} from '../../../utils/validator.js';
import vUsersend from '../../common/userSend.vue';
export default {
    data() {
            return {
                userSendVisible: false,
                tmpId: '',
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
                    noticeType: ''
                },
                subform: {},
                initform: {
                    id: '',
                    noticeType: 0,
                    content: '',
                    remark: '',
                },
                formRules: {
                    content: [{
                        message: "该值不能为空",
                        required: true,
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
            vYvtableoption,
            vUsersend
        },
        methods: {
            userSendVisibleChange(val) {
                this.userSendVisible = val;
            },
            userSelectChange(params) {
                this.sendMsg(params);
            },
            sendMsg(params) {
                sendWeixinTemplate(params).then((res) => {
                    if (res.data.code == '000000') {
                        this.$message.success("发送成功");
                    } else {
                        this.$message.error(res.data.message);
                    }
                });
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
                    delWeixinTemplate(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.formVisible = false;
                            this.getWeixinTemplateList();
                            this.$message.success("删除成功");
                        } else {
                            this.$message.error(res.data.message);
                        }
                    });
                }).catch(() => {

                });
            },
            getWeixinTemplateList() {
                this.$refs["queryform"].validate((valid) => {
                    if (valid) {
                        this.loading = true;
                        const self = this;
                        let params = {
                            page: this.pageIndex,
                            itemcount: this.pageSize,
                            id: this.queryParam.id,
                            noticeType: this.queryParam.noticeType
                        }
                        getWeixinTemplateList(params).then((res) => {
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
                this.getWeixinTemplateList()
            },
            formSubmit() {
                this.$refs["subform"].validate((valid) => {
                    if (valid) {
                        this.formLoading = true;
                        let param = Object.assign({}, this.subform);
                        if (param.id != "") {
                            editWeixinTemplate(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getWeixinTemplateList();
                                } else {
                                    this.$message.error(res.data.message);
                                }
                            });
                        } else {
                            createWeixinTemplate(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getWeixinTemplateList();
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
                    delWeixinTemplate(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.getWeixinTemplateList();
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
            this.getWeixinTemplateList()
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
