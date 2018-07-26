<template>
    <div class="table">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-menu"></i> 数据预测</el-breadcrumb-item>
                <el-breadcrumb-item>企业预测增幅设置管理</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
		<!--工具条-->
        <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
            <el-form :inline="true">
                <el-form-item>
                    <!-- <el-button type="primary" @click="getEnterpriseRiseList">查询</el-button> -->
                </el-form-item>
                <el-form-item>
                    <!-- <el-button type="primary" @click="handleAdd">新增</el-button> -->
                </el-form-item>
            </el-form>
        </el-col>
        <el-table :data="tableData" border style="width: 100%" v-loading.body="loading" @selection-change="selsChange">
            <!-- <el-table-column type="selection" width="70"></el-table-column> -->
             <el-table-column prop="enterCompareRise" width="200" label="法人同比增幅限额"></el-table-column>
             <el-table-column prop="enterRandomRise" width="200" label="法人增幅浮动范围"></el-table-column>
             <el-table-column prop="personCompareRise" width="200" label="个体同比增幅限额"></el-table-column>
             <el-table-column prop="personRandomRise" width="200" label="个人增幅浮动范围"></el-table-column>
             <el-table-column prop="reportDifference" width="200" label="数据上报误差"></el-table-column>
            <el-table-column label="操作" width="180">
                <template scope="scope">
                    <el-button size="small" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
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
                        <el-form-item label="法人同比增幅限额" prop="enterCompareRise">
                            <el-input v-model="subform.enterCompareRise" auto-complete="off">
                                <template slot="append">%</template>
                            </el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="法人增幅浮动范围" prop="enterRandomRise">
                            <el-input v-model="subform.enterRandomRise" auto-complete="off">
                                <template slot="append">%</template>
                            </el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="个体同比增幅限额" prop="personCompareRise">
                            <el-input v-model="subform.personCompareRise" auto-complete="off">
                                <template slot="append">%</template>
                            </el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="个人增幅浮动范围" prop="personRandomRise">
                            <el-input v-model="subform.personRandomRise" auto-complete="off">
                                <template slot="append">%</template>
                            </el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="数据上报误差" prop="reportDifference">
                            <el-input v-model="subform.reportDifference" auto-complete="off">
                                <template slot="append">千元</template>
                            </el-input>
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
    createEnterpriseRise,
    getEnterpriseRiseList,
    editEnterpriseRise,
    delEnterpriseRise,
    base
} from '../../../api/api';
import vYvoption from '../../common/yvoption.vue';
import vYvtableoption from '../../common/yvtableoption.vue';
import {checkMoney,checkPersent} from '../../../utils/validator.js'
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
                subform:{},
                initform: {
                   id:'',
                   enterCompareRise:'',
                   enterRandomRise:'',
                   personCompareRise:'',
                   personRandomRise:'',
                   reportDifference:'',
                },
                formRules: {
                    enterCompareRise:[{validator:checkPersent, required: true,trigger: 'blur'}],
                    enterRandomRise:[{validator:checkPersent, required: true,trigger: 'blur'}],
                    personCompareRise:[{validator:checkPersent, required: true,trigger: 'blur'}],
                    personRandomRise:[{validator:checkPersent, required: true,trigger: 'blur'}],
                    reportDifference:[{validator:checkMoney, required: true,trigger: 'blur'}],

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
                    delEnterpriseRise(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.formVisible = false;
                            this.getEnterpriseRiseList();
                            this.$message.success("删除成功");
                        } else {
                      this.$message.error(res.data.message);
                        }
                    });
                }).catch(() => {

                });
            },
            getEnterpriseRiseList() {
                this.loading = true;
                const self = this;
                let params = {
                    page: this.pageIndex,
                    itemcount: this.pageSize,
                    id: this.queryParam.id,
                    name: this.queryParam.name
                }
                getEnterpriseRiseList(params).then((res) => {
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
                this.getEnterpriseRiseList()
            },
            formSubmit() {
                this.$refs["subform"].validate((valid) => {
                    if (valid) {
                        this.formLoading = true;
                        let param = Object.assign({}, this.subform);
                        if (param.id != "") {
                            editEnterpriseRise(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getEnterpriseRiseList();
                                } else {
                                    this.$message.error(res.data.message);
                                }
                            });
                        } else {
                            createEnterpriseRise(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getEnterpriseRiseList();
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
                    delEnterpriseRise(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.getEnterpriseRiseList();
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
            this.getEnterpriseRiseList()
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
