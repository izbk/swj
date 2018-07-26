<template>
    <div class="table">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-menu"></i> 系统管理</el-breadcrumb-item>
                <el-breadcrumb-item>外贸会展记录信息管理</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
		<!--工具条-->
        <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
            <el-form :inline="true">
                <el-form-item label="用户id">
                    <el-input v-model="queryParam.id" auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="用户名称">
                    <el-input v-model="queryParam.name" auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="getIntlExhibitionRecordList">查询</el-button>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="handleAdd">新增</el-button>
                </el-form-item>
            </el-form>
        </el-col>
        <el-table :data="tableData" border style="width: 100%" v-loading.body="loading" @selection-change="selsChange">
            <el-table-column type="selection" width="70"></el-table-column>
             <el-table-column prop="id" label="主键ID" sortable></el-table-column>
             <el-table-column prop="exhibitionName" label="会展名称" sortable></el-table-column>
             <el-table-column prop="enterpiseName" label="参展企业名称" sortable></el-table-column>
             <el-table-column prop="country" label="国别" sortable></el-table-column>
             <el-table-column prop="area" label="地区" sortable></el-table-column>
             <el-table-column prop="participantNum" label="参展人数" sortable></el-table-column>
             <el-table-column prop="boothFee" label="展位费" sortable></el-table-column>
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
                            <el-input v-model="subform.id" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="会展名称" prop="exhibitionName">
                            <el-input v-model="subform.exhibitionName" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="参展企业名称" prop="enterpiseName">
                            <el-input v-model="subform.enterpiseName" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="国别" prop="country">
                            <el-input v-model="subform.country" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="地区" prop="area">
                            <el-input v-model="subform.area" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="参展人数" prop="participantNum">
                            <el-input v-model="subform.participantNum" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="展位费" prop="boothFee">
                            <el-input v-model="subform.boothFee" auto-complete="off"></el-input>
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
    createIntlExhibitionRecord,
    getIntlExhibitionRecordList,
    editIntlExhibitionRecord,
    delIntlExhibitionRecord,
    base
} from '../../../api/api';

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
                    name: ''
                },
                subform: {
                   id:'0',
                   exhibitionName:'',
                   enterpiseName:'',
                   country:'',
                   area:'',
                   participantNum:'0',
                   boothFee:'',
                },
                formRules: {

                },
                formLoading: false
            }
        },
        methods: {

            handleAdd(index, row) {
                this.formVisible = true;
                this.upPercentage = 0;
                this.upFlag = '';
                this.subform = {
                    id:'0',
                    exhibitionName:'',
                    enterpiseName:'',
                    country:'',
                    area:'',
                    participantNum:'0',
                    boothFee:'',
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
                    let param = {
                        ids: row.id
                    };
                    delIntlExhibitionRecord(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.formVisible = false;
                            this.getIntlExhibitionRecordList();
                            this.$message.success("删除成功");
                        } else {
                      this.$message.error(res.data.message);
                        }
                    });
                }).catch(() => {

                });
            },
            getIntlExhibitionRecordList() {
                this.loading = true;
                const self = this;
                let params = {
                    page: this.pageIndex,
                    itemcount: this.pageSize,
                    id: this.queryParam.id,
                    name: this.queryParam.name
                }
                getIntlExhibitionRecordList(params).then((res) => {
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
                this.getIntlExhibitionRecordList()
            },
            formSubmit() {
                this.$refs["subform"].validate((valid) => {
                    if (valid) {
                        this.formLoading = true;
                        let param = Object.assign({}, this.subform);
                        if (param.id != "") {
                            editIntlExhibitionRecord(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getIntlExhibitionRecordList();
                                } else {
                                    this.$message.error(res.data.message);
                                }
                            });
                        } else {
                            createIntlExhibitionRecord(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getIntlExhibitionRecordList();
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
                    delIntlExhibitionRecord(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.getIntlExhibitionRecordList();
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
            this.getIntlExhibitionRecordList()
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
