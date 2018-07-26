<template>
    <div class="table">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-menu"></i> 表格</el-breadcrumb-item>
                <el-breadcrumb-item>用户管理</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <!--工具条-->
        <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
            <el-form :inline="true">
                <el-form-item>
                    <el-button type="primary" @click="getUserList">查询</el-button>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="handleAdd">新增</el-button>
                </el-form-item>
            </el-form>
        </el-col>
        <el-table :data="tableData" border style="width: 100%" v-loading.body="loading" @selection-change="selsChange">
            <el-table-column type="selection" width="70"></el-table-column>
            <el-table-column prop="name" label="姓名" sortable></el-table-column>
            <el-table-column prop="sex" label="性别" :formatter="sexFormatter"></el-table-column>
            <el-table-column prop="age" label="年龄"></el-table-column>
            <el-table-column prop="createtime" label="注册日期">
                <template scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.createtime|time }}</span>
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
        <el-dialog :title="formTittle" v-model="formVisible" :close-on-click-modal="false" size="tiny">
            <el-form :model="subform" label-width="80px" :rules="formRules" ref="subform">
                <el-row>
                    <el-col :span='12'>
                        <el-form-item label="姓名" prop="name">
                            <el-input v-model="subform.name" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="性别" prop="sex">
                            <el-radio-group v-model="subform.sex">
                                <el-radio class="radio" :label="1">男</el-radio>
                                <el-radio class="radio" :label="2">女</el-radio>
                            </el-radio-group>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="年龄" prop="age">
                            <el-input-number v-model="subform.age" :min="0" :max="200"></el-input-number>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="生日" prop="createtime">
                            <el-date-picker type="date" placeholder="选择日期" v-model="subform.createtime"></el-date-picker>
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
import {getUserList,editUserSubmit} from '../../../api/api';
export default {
    data() {
            return {
                tableData: [],
                pageIndex: 1,
                pageSize: 10,
                totalCount: 0,
                loading: true,
                sels:[],
                //form数据
                formTittle: '',
                formVisible: false,
                subform: {
                    name: '',
                    sex: 1,
                    age: '',
                    createtime: ''
                },
                formRules: {
                    name: [{
                        required: true,
                        message: '请输入姓名',
                        trigger: 'blur'
                    }]
                },
                formLoading: false
            }
        },
        methods: {
            sexFormatter(row, column) {
                return row.sex == 1 ? '男' : row.sex == 2 ? '女' : '未知';
            },
            handleAdd(index, row) {
                this.formVisible = true;
                this.subform = {
                    name: '',
                    sex: 1,
                    age: '',
                    createtime: ''
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
                    this.$message.success("删除成功");
                }).catch(() => {

                });
            },
            getUserList() {
                this.loading = true;
                const self=this;
                let params= {
                        page: this.pageIndex,
                        itemcount: this.pageSize
                    }
                getUserList(params).then((res) => {
                    this.loading = false;
                    if (res.data.code == '000000') {
                        this.tableData = res.data.data;
                        this.totalCount = res.data.count;
                    } else {
                        this.$message.error(res.data.message);
                    }
                }).catch(function (error) {
                        self.loading=false;
                        self.$message.error('网络故障，请稍后再试');
                });
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
                        editUserSubmit(param).then((res) => {
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
                        return false;
                    }
                })

            },
            selsChange(sels) {
            this.sels = sels;
        },
        batchRemove() {
            var ids = this.sels.map(item => item.id).toString();
            if(ids==""){
                this.$message.warning("您还没有选中记录");
                return false;
            }
            this.$confirm('确认删除选中记录吗？', '提示', {
                type: 'warning'
            }).then(() => {
                this.$message.success("删除成功");
                this.getUserList()
            }).catch(() => {

            });
        }
        },
        
        mounted: function() {
            this.getUserList()
        }
}
</script>
