<template>
    <div class="table">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-menu"></i> 微信</el-breadcrumb-item>
                <el-breadcrumb-item>下发记录管理</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
		<!--工具条-->
        <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
            <el-form :inline="true">
                <!-- <el-form-item label="编号">
                    <el-input v-model="queryParam.id" auto-complete="off"></el-input>
                </el-form-item> -->
                <el-form-item label="通知类型">
                            <el-select v-model="queryParam.noticeType" clearable placeholder="请选择通知类型">
                                <v-yvoption groupName="noticeType"></v-yvoption>
                            </el-select>
                        </el-form-item>
                        <!-- <el-form-item label="创建时间">
                            <el-date-picker type="daterange" placeholder="选择日期范围" v-model="queryParam.createTime"></el-date-picker>
                        </el-form-item> -->
                <el-form-item>
                    <el-button type="primary" @click="getWeixinTemplateRecordList">查询</el-button>
                </el-form-item>
                <!-- <el-form-item>
                    <el-button type="primary" @click="handleAdd">新增</el-button>
                </el-form-item> -->
            </el-form>
        </el-col>
        <el-table :data="tableData" border style="width: 100%" v-loading.body="loading" @selection-change="selsChange">
            <el-table-column type="selection" width="70"></el-table-column>
            <el-table-column prop="noticeType" label="通知类型">
                <template scope="scope">
                    <v-yvtableoption groupName="noticeType" :trueValue="scope.row.noticeType"></v-yvtableoption>
                </template>
            </el-table-column>
             <el-table-column prop="nickName" label="用户名称"></el-table-column>
             <el-table-column prop="createName" label="创建人"></el-table-column>
            <el-table-column prop="createTime" label="创建时间" width="260">
                <template scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.createTime|time }}</span>
                </template>
            </el-table-column>
            <el-table-column label="操作" width="180">
                <template scope="scope">
                    <el-button size="small" type="primary" @click="handleEdit(scope.$index, scope.row)">查看</el-button>
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
                        <el-form-item label="模板ID" prop="templateId">
                            <el-input readonly v-model="subform.templateId" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="通知类型" prop="noticeType">
                            <el-select disabled v-model="subform.noticeType" placeholder="请选择通知类型">
                                <v-yvoption groupName="noticeType"></v-yvoption>
                            </el-select>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="用户ID" prop="userId">
                            <el-input readonly v-model="subform.userId" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="OPENID" prop="openId">
                            <el-input readonly v-model="subform.openId" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="用户名称" prop="nickName">
                            <el-input readonly v-model="subform.nickName" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="创建人" prop="createBy">
                            <el-input readonly v-model="subform.createBy" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                 <el-col :span='12'>
                        <el-form-item label="创建人名称" prop="createName">
                            <el-input readonly v-model="subform.createName" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="创建时间" prop="createTime">
                            <el-date-picker type="datetime" placeholder="选择日期" readonly v-model="subform.createTime"></el-date-picker>
                        </el-form-item>
                    </el-col>
                    <el-col :span='24'>
                        <el-form-item label="发送内容" prop="content">
                            <el-input type="textarea" readonly v-model="subform.content" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
            </el-row>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click.native="formVisible = false">取消</el-button>
                <!-- <el-button type="primary" @click.native="formSubmit" :loading="formLoading">提交</el-button> -->
            </div>
        </el-dialog>
    </div>
</template>
<script>
import {
    createWeixinTemplateRecord,
    getWeixinTemplateRecordList,
    editWeixinTemplateRecord,
    delWeixinTemplateRecord,
    base
} from '../../../api/api';
import vYvoption from '../../common/yvoption.vue';
import vYvtableoption from '../../common/yvtableoption.vue';
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
                    noticeType:null,
                    createTime:[],
                },
                subform: {
                   id:'',
				   templateId:0,
				   noticeType:0,
				   userId:0,
                   openId:'',
                   nickName:'',
				   createBy:0,
                   createName:'',
                   content:'',
                   createTime:'',
                },
                formRules: {

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
                this.upPercentage = 0;
                this.upFlag = '';
                this.subform={
                   id:'',
				   templateId:0,
				   noticeType:0,
				   userId:0,
                   openId:'',
                   nickName:'',
				   createBy:0,
                   createTime:'',
                   createName:'',
                   content:'',
                };
				this.$refs['subform'].resetFields();
                this.formTittle = "新增"
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
                    delWeixinTemplateRecord(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.formVisible = false;
                            this.getWeixinTemplateRecordList();
                            this.$message.success("删除成功");
                        } else {
                      this.$message.error(res.data.message);
                        }
                    });
                }).catch(() => {

                });
            },
            getWeixinTemplateRecordList() {
                this.loading = true;
                const self = this;
                let params = {
                    page: this.pageIndex,
                    itemcount: this.pageSize,
                    noticeType:this.queryParam.noticeType,
                    range:this.queryParam.createTime,
                }
                getWeixinTemplateRecordList(params).then((res) => {
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
            },
            handleCurrentChange(val) {
                this.pageIndex = val;
                this.getWeixinTemplateRecordList()
            },
            formSubmit() {
                this.$refs["subform"].validate((valid) => {
                    if (valid) {
                        this.formLoading = true;
                        let param = Object.assign({}, this.subform);
                        if (param.id != "") {
                            editWeixinTemplateRecord(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getWeixinTemplateRecordList();
                                } else {
                                    this.$message.error(res.data.message);
                                }
                            });
                        } else {
                            createWeixinTemplateRecord(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getWeixinTemplateRecordList();
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
                    delWeixinTemplateRecord(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.getWeixinTemplateRecordList();
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
            this.getWeixinTemplateRecordList()
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
