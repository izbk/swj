<template>
    <div class="table">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-menu"></i> 系统管理</el-breadcrumb-item>
                <el-breadcrumb-item>用户管理</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <!--工具条-->
        <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
            <el-form :inline="true" :rules="queryRules" ref="queryform" :model="queryParam">
                <el-form-item label="用户id" prop="id">
                    <el-input v-model="queryParam.id" auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="登陆名称">
                    <el-input v-model="queryParam.loginName" :maxlength=10 auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="昵称">
                    <el-input v-model="queryParam.name" :maxlength=10 auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="角色">
                    <el-select v-model="queryParam.roleId" clearable placeholder="请选择角色">
                        <v-yvoption tableName="role" label="name" value='id'></v-yvoption>
                    </el-select>
                </el-form-item>
                <el-form-item label="部门">
                    <el-select v-model="queryParam.departId" clearable placeholder="请选择部门">
                        <v-yvoption tableName="department" label="departname" value='id'></v-yvoption>
                    </el-select>
                </el-form-item>
                <el-form-item label="状态">
                    <el-select v-model="queryParam.status" clearable placeholder="请选择状态">
                        <v-yvoption groupName="userStatus"></v-yvoption>
                    </el-select>
                </el-form-item>
                <el-form-item label="所属乡镇">
                    <el-select v-model="queryParam.townshipId" clearable placeholder="请选择乡镇">
                        <v-yvoption tableName="township" label="name" value='id'></v-yvoption>
                    </el-select>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="getUserList">查询</el-button>
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
            <el-table-column prop="nickName" width='150' label="姓名"></el-table-column>
            <el-table-column prop="roleId" width='180' label="角色">
                <template scope="scope">
                    <v-yvtableoption tableName="role" label="name" value='id' :trueValue="scope.row.roleId"></v-yvtableoption>
                </template>
            </el-table-column>
            <el-table-column prop="pic" width='150' label="头像">
                <template scope="scope">
                    <img :src="scope.row.pic" style="height:3em;margin-left:10px">
                </template>
            </el-table-column>
            <!-- <el-table-column prop="status" width='150' label="状态" :formatter="statusFormatter"></el-table-column> -->
            <el-table-column prop="regTime" label="注册时间" width="260">
                <template scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.regTime|time }}</span>
                </template>
            </el-table-column>
            <el-table-column label="操作" width="280">
                <template scope="scope">
                    <el-button size="small" type="primary" @click="handleReset(scope.$index, scope.row)">重置密码</el-button>
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
                        <el-form-item label="头像" prop="pic">
                            <el-upload class="avatar-uploader" :action="uploadUrl" :show-file-list="false" :on-success="handleAvatarSuccess" :on-progress="handleProgress" :before-upload="beforeAvatarUpload">
                                <img v-if="subform.pic" :src="subform.pic" class="avatar">
                                <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                            </el-upload>
                            <el-progress :percentage="upPercentage" :status="upFlag"></el-progress>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span='12'>
                        <el-form-item label="用户id" prop="id">
                            <el-input v-model="subform.id" auto-complete="off" disabled></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="角色" prop="roleId">
                            <el-select v-model="subform.roleId" placeholder="请选择角色">
                                <v-yvoption tableName="role" label="name" value='id'></v-yvoption>
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="部门" prop="departId">
                            <el-select v-model="subform.departId" placeholder="请选择部门">
                                <v-yvoption tableName="department" label="departname" value='id'></v-yvoption>
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="登陆名称" prop="loginName">
                            <el-input v-model="subform.loginName" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="昵称" prop="nickName">
                            <el-input v-model="subform.nickName" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="手机号" prop="mobilePhone">
                            <el-input v-model="subform.mobilePhone" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="邮箱" prop="email">
                            <el-input v-model="subform.email" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="状态" prop="status">
                            <el-select v-model="subform.status" placeholder="请选择状态">
                                <v-yvoption groupName="userStatus"></v-yvoption>
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="所属乡镇" prop="townshipId">
                            <el-select v-model="subform.townshipId" placeholder="请选择乡镇">
                                <v-yvoption tableName="township" label="name" value='id'></v-yvoption>
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="注册时间" prop="regTime">
                            <el-date-picker type="datetime" placeholder="选择日期" v-model="subform.regTime" disabled></el-date-picker>
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
    createUser,
    getUserList,
    editUser,
    delUser,
    getRoleList,
    resetPwd,
    base
} from '../../../api/api';
import vYvoption from '../../common/yvoption.vue';
import vYvtableoption from '../../common/yvtableoption.vue';
import {validNum} from '../../../utils/validator.js';
export default {
    data() {
            return {
                exportUrl: base + "/users/export",
                uploadUrl: base + "/upload/uploadPic",
                upPercentage: 0,
                upFlag: '',
                tableData: [],
                roleData: [],
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
                    name: '',
                    loginName:'',
                    roleId: '',
                    departId: '',
                    status: '',
                    townshipId: '',
                },
                subform: {},
                initform: {
                    id: '',
                    roleId: '',
                    mobilePhone: '',
                    loginName: '',
                    nickName: '',
                    email: '',
                    pic: '',
                    status: 1,
                    isDel: '0',
                    regTime: '',
                    departId: '',
                    townshipId: ''
                },
                formRules: {
                    loginName: [{
                        required: true,
                        message: '请输入登陆名称',
                        trigger: 'blur'
                    }]
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
                this.exportUrl = base + "/users/export?id=" + this.queryParam.id + "&name=" + this.queryParam.name + "&loginName=" + this.queryParam.loginName+ "&roleId=" + this.queryParam.roleId+ "&departId=" + this.queryParam.departId+ "&status=" + this.queryParam.status+ "&townshipId=" + this.queryParam.townshipId;
            },
            roleFormatter(row, column) {
                return row.roleId == 0 ? '普通会员' : row.roleId == 1 ? '管理员' : row.roleId == 2 ? '企业会员' : '未知';
            },
            statusFormatter(row, column) {
                return row.status == 0 ? '未激活' : row.status == 1 ? '正常' : row.status == 2 ? '冻结' : row.status == 3 ? '注销' : '未知';
            },
            handleAdd(index, row) {
                this.formVisible = true;
                this.upPercentage = 0;
                this.upFlag = '';
                this.$nextTick(function() {
                    this.subform = Object.assign({}, this.initform);
                    this.$refs['subform'].resetFields();
                    this.formTittle = "新增"
                })
            },
            handleEdit(index, row) {
                this.formVisible = true;
                this.upPercentage = 0;
                this.upFlag = '';
                this.$nextTick(function() {
                    this.$refs['subform'].resetFields();
                    this.subform = Object.assign({}, row);
                    this.formTittle = "编辑"
                })
            },
            handleReset(index, row) {
                this.$confirm('确认重置该用户密码为初始密码123456吗?', '提示', {
                    type: 'warning'
                }).then(() => {
                    let param = {
                        id: row.id
                    }
                    resetPwd(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.$message.success("重置成功");
                        } else {
                            this.$message.error(res.data.message);
                        }
                    });
                }).catch(() => {

                });
            },
            handleDelete(index, row) {
                this.$confirm('确认删除该记录吗?', '提示', {
                    type: 'warning'
                }).then(() => {
                    let param = {
                        ids: row.id
                    };
                    delUser(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.formVisible = false;
                            this.getUserList();
                            this.$message.success("删除成功");
                        } else {
                            this.$message.error(res.data.message);
                        }
                    });
                }).catch(() => {

                });
            },
            getUserList() {
                this.$refs["queryform"].validate((valid) => {
                    if (valid) {
                        this.loading = true;
                        const self = this;
                        let params = {
                            page: this.pageIndex,
                            itemcount: this.pageSize,
                            id: this.queryParam.id,
                            loginName: this.queryParam.loginName,
                            nickName: this.queryParam.name,
                            roleId: this.queryParam.roleId,
                            departId: this.queryParam.departId,
                            status: this.queryParam.status,
                            townshipId: this.queryParam.townshipId,
                        }
                        getUserList(params).then((res) => {
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
                this.getUserList()
            },
            formSubmit() {
                this.$refs["subform"].validate((valid) => {
                    if (valid) {
                        this.formLoading = true;
                        let param = Object.assign({}, this.subform);
                        if (param.id != "") {
                            editUser(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getUserList();
                                } else {
                                    this.$message.error(res.data.message);
                                }
                            });
                        } else {
                            createUser(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getUserList();
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
                    delUser(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.getUserList();
                            this.$message.success("删除成功");
                        } else {
                            this.$message.error(res.data.message);
                        }
                    });
                }).catch(() => {

                });
            },
            handleAvatarSuccess(res, file) {
                this.subform.pic = res.url;
            },
            beforeAvatarUpload(file) {
                const picType = "image/pjpeg image/gif image/bmp image/x-png image/tiff image/png image/jpeg";
                const isPIC = picType.indexOf(file.type) != '-1';
                const notNULL = file.type != '';
                const isLt2M = file.size / 1024 / 1024 < 2;

                if (!isPIC || !notNULL) {
                    this.$message.error('上传头像图片只能是图片格式!');
                }
                if (!isLt2M) {
                    this.$message.error('上传头像图片大小不能超过 2MB!');
                }
                return isPIC && isLt2M && notNULL;
            },
            handleProgress(event, file) {
                this.upPercentage = event.percent;
                if (event.percent == 100) {
                    this.upFlag = "success";
                }
            }
        },

        mounted: function() {
            this.getUserList();
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
