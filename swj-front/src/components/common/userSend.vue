<template>
    <div class="table">
        <el-dialog title="下发通知" v-model="myUserSendVisible" :close-on-click-modal="false" size="big">
            <!--工具条-->
            <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
                <el-form :inline="true" :rules="queryRules" ref="queryform" :model="queryParam">
                    <el-form-item label="用户编号" prop="id">
                        <el-input v-model="queryParam.id" :maxlength=10 auto-complete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="用户名称">
                        <el-input v-model="queryParam.name" :maxlength=50 auto-complete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="角色">
                        <el-select v-model="queryParam.roleId" placeholder="请选择角色" clearable>
                            <v-yvoption tableName="role" label="name" value='id'></v-yvoption>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="部门">
                        <el-select v-model="queryParam.departId" placeholder="请选择部门" clearable>
                            <v-yvoption tableName="department" label="departname" value='id'></v-yvoption>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="状态">
                        <el-select v-model="queryParam.status" placeholder="请选择状态" clearable>
                            <v-yvoption groupName="userStatus"></v-yvoption>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="所属乡镇">
                        <el-select v-model="queryParam.townshipId" placeholder="请选择乡镇" clearable>
                            <v-yvoption tableName="township" label="name" value='id'></v-yvoption>
                        </el-select>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="getUserList">查询</el-button>
                        <el-button type="primary" @click="batchSelect">发送</el-button>
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
                <el-table-column prop="regTime" label="注册时间" width="260">
                    <template scope="scope">
                        <span style="margin-left: 10px">{{ scope.row.regTime|time }}</span>
                    </template>
                </el-table-column>
            </el-table>
        </el-dialog>
    </div>
</template>
<script>
import {
    getUserList,
    base
} from '../../api/api';
import vYvoption from '../common/yvoption.vue';
import vYvtableoption from '../common/yvtableoption.vue';
import {
    validNum
} from '../../utils/validator.js';
export default {
    data() {
            return {
                myUserSendVisible: this.userSendVisible,
                tableData: [],
                pageIndex: 1,
                pageSize: 9,
                totalCount: 0,
                loading: false,
                sels: [],
                queryParam: {
                    id: '',
                    name: '',
                    roleId: '',
                    departId: '',
                    status: '',
                    townshipId: '',
                },
                subform: null,
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
        props: {
            userSendVisible: Boolean,
            tmpId: Number
        },
        watch: {
            userSendVisible(val) {
                this.myUserSendVisible = val;
            },
            myUserSendVisible(val) {
                this.$emit("on-visible-change", val)
            }
        },
        methods: {
            getUserList() {
                this.$refs["queryform"].validate((valid) => {
                    if (valid) {
                         this.loading = true;
                        const self = this;
                        let params = {
                            // page: this.pageIndex,
                            // itemcount: this.pageSize,
                            isSend: true,
                            id: this.queryParam.id,
                            name: this.queryParam.name,
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
            selsChange(sels) {
                this.sels = sels;
            },
            batchSelect() {
                var userIds = this.sels.map(item => item.id);
                if (userIds == "") {
                    this.$message.warning("您还没有选中记录");
                    return false;
                }
                this.$confirm('确认向选中记录发送通知吗？', '提示', {
                    type: 'warning'
                }).then(() => {
                    let params = {
                        userIds: userIds,
                        templateId: this.tmpId
                    }
                    this.$emit("on-select-change", params);
                    this.myUserSendVisible = false;
                }).catch(() => {

                });
            },

        },

        mounted: function() {
            this.getUserList();
        }
}
</script>
<style>
</style>
