<template>
    <div class="table">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-menu"></i> 系统管理</el-breadcrumb-item>
                <el-breadcrumb-item>入园申请登记表管理</el-breadcrumb-item>
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
                    <el-button type="primary" @click="getSettleRegisterList">查询</el-button>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="handleAdd">新增</el-button>
                </el-form-item>
            </el-form>
        </el-col>
        <el-table :data="tableData" border style="width: 100%" v-loading.body="loading" @selection-change="selsChange">
            <el-table-column type="selection" width="70"></el-table-column>
             <el-table-column prop="id" label="" sortable></el-table-column>
             <el-table-column prop="idNumber" label="身份证号码" sortable></el-table-column>
             <el-table-column prop="name" label="姓名" sortable></el-table-column>
             <el-table-column prop="sex" label="性别" sortable></el-table-column>
             <el-table-column prop="age" label="年龄" sortable></el-table-column>
             <el-table-column prop="political" label="政治面貌" sortable></el-table-column>
             <el-table-column prop="nativePlace" label="籍贯" sortable></el-table-column>
             <el-table-column prop="nation" label="民族" sortable></el-table-column>
             <el-table-column prop="mobile" label="联系电话" sortable></el-table-column>
             <el-table-column prop="email" label="电子邮箱" sortable></el-table-column>
             <el-table-column prop="address" label="现住址" sortable></el-table-column>
             <el-table-column prop="pic" label="照片" sortable></el-table-column>
             <el-table-column prop="businessSubject" label="经营主体全称" sortable></el-table-column>
             <el-table-column prop="legalPerson" label="法人（负责人）" sortable></el-table-column>
             <el-table-column prop="businessLicense" label="营业执照号码" sortable></el-table-column>
             <el-table-column prop="companyType" label="企业类型（0:实体商品交易电商 1:电商服务 2:自营平台 3:代理平台 4:微商 5:新媒体 6:软件开发 7:虚拟产品交易电商）" sortable></el-table-column>
             <el-table-column prop="businessIncome" label="经营收入" sortable></el-table-column>
             <el-table-column prop="businessPlace" label="营业地点" sortable></el-table-column>
             <el-table-column prop="settledPlatform" label="已入驻平台（0:淘宝 1:天猫 2:京东 3:拍拍 4:微商 5:阿里巴巴 6:其他平台 7:未入驻）" sortable></el-table-column>
             <el-table-column prop="shopName" label="平台店铺名称" sortable></el-table-column>
             <el-table-column prop="shopUrl" label="网店地址" sortable></el-table-column>
             <el-table-column prop="creditRating" label="目前信誉等级" sortable></el-table-column>
             <el-table-column prop="companyWebsite" label="公司官网" sortable></el-table-column>
             <el-table-column prop="category" label="经营品类" sortable></el-table-column>
             <el-table-column prop="averageMonthlySales" label="平均月销售额" sortable></el-table-column>
             <el-table-column prop="applicationRoom" label="申请办公室数量" sortable></el-table-column>
             <el-table-column prop="applicationArea" label="申请仓储面积" sortable></el-table-column>
             <el-table-column prop="equipmentSource" label="设备来源（0:自购 1:租赁 3:其它）" sortable></el-table-column>
             <el-table-column prop="businessScope" label="申请经营范围" sortable></el-table-column>
             <el-table-column prop="teamNumber" label="入驻团队人数" sortable></el-table-column>
             <el-table-column prop="joinAssociation" label="是否愿意成为电商协会会员" sortable></el-table-column>
             <el-table-column prop="projectIntroduction" label="" sortable></el-table-column>
             <el-table-column prop="status" label="审核状态（0：未审核 1：审核通过 2：审核不通过）" sortable></el-table-column>
             <el-table-column prop="remark" label="备注" sortable></el-table-column>
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
                        <el-form-item label="" prop="id">
                            <el-input v-model="subform.id" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="身份证号码" prop="idNumber">
                            <el-input v-model="subform.idNumber" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="姓名" prop="name">
                            <el-input v-model="subform.name" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="性别" prop="sex">
                            <el-input v-model="subform.sex" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="年龄" prop="age">
                            <el-input v-model="subform.age" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="政治面貌" prop="political">
                            <el-input v-model="subform.political" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="籍贯" prop="nativePlace">
                            <el-input v-model="subform.nativePlace" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="民族" prop="nation">
                            <el-input v-model="subform.nation" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="联系电话" prop="mobile">
                            <el-input v-model="subform.mobile" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="电子邮箱" prop="email">
                            <el-input v-model="subform.email" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="现住址" prop="address">
                            <el-input v-model="subform.address" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="照片" prop="pic">
                            <el-input v-model="subform.pic" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="经营主体全称" prop="businessSubject">
                            <el-input v-model="subform.businessSubject" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="法人（负责人）" prop="legalPerson">
                            <el-input v-model="subform.legalPerson" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="营业执照号码" prop="businessLicense">
                            <el-input v-model="subform.businessLicense" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="企业类型（0:实体商品交易电商 1:电商服务 2:自营平台 3:代理平台 4:微商 5:新媒体 6:软件开发 7:虚拟产品交易电商）" prop="companyType">
                            <el-input v-model="subform.companyType" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="经营收入" prop="businessIncome">
                            <el-input v-model="subform.businessIncome" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="营业地点" prop="businessPlace">
                            <el-input v-model="subform.businessPlace" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="已入驻平台（0:淘宝 1:天猫 2:京东 3:拍拍 4:微商 5:阿里巴巴 6:其他平台 7:未入驻）" prop="settledPlatform">
                            <el-input v-model="subform.settledPlatform" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="平台店铺名称" prop="shopName">
                            <el-input v-model="subform.shopName" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="网店地址" prop="shopUrl">
                            <el-input v-model="subform.shopUrl" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="目前信誉等级" prop="creditRating">
                            <el-input v-model="subform.creditRating" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="公司官网" prop="companyWebsite">
                            <el-input v-model="subform.companyWebsite" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="经营品类" prop="category">
                            <el-input v-model="subform.category" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="平均月销售额" prop="averageMonthlySales">
                            <el-input v-model="subform.averageMonthlySales" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="申请办公室数量" prop="applicationRoom">
                            <el-input v-model="subform.applicationRoom" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="申请仓储面积" prop="applicationArea">
                            <el-input v-model="subform.applicationArea" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="设备来源（0:自购 1:租赁 3:其它）" prop="equipmentSource">
                            <el-input v-model="subform.equipmentSource" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="申请经营范围" prop="businessScope">
                            <el-input v-model="subform.businessScope" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="入驻团队人数" prop="teamNumber">
                            <el-input v-model="subform.teamNumber" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="是否愿意成为电商协会会员" prop="joinAssociation">
                            <el-input v-model="subform.joinAssociation" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="" prop="projectIntroduction">
                            <el-input v-model="subform.projectIntroduction" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="审核状态（0：未审核 1：审核通过 2：审核不通过）" prop="status">
                            <el-input v-model="subform.status" auto-complete="off"></el-input>
                        </el-form-item>
                    </el-col>
                <el-col :span='12'>
                        <el-form-item label="备注" prop="remark">
                            <el-input v-model="subform.remark" auto-complete="off"></el-input>
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
    createSettleRegister,
    getSettleRegisterList,
    editSettleRegister,
    delSettleRegister,
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
                   idNumber:'',
                   name:'',
                   sex:'0',
                   age:'0',
                   political:'',
                   nativePlace:'',
                   nation:'0',
                   mobile:'',
                   email:'',
                   address:'',
                   pic:'',
                   businessSubject:'',
                   legalPerson:'',
                   businessLicense:'',
                   companyType:'0',
                   businessIncome:'',
                   businessPlace:'',
                   settledPlatform:'0',
                   shopName:'',
                   shopUrl:'',
                   creditRating:'',
                   companyWebsite:'',
                   category:'',
                   averageMonthlySales:'',
                   applicationRoom:'0',
                   applicationArea:'',
                   equipmentSource:'0',
                   businessScope:'',
                   teamNumber:'0',
                   joinAssociation:'0',
                   projectIntroduction:'',
                   status:'0',
                   remark:'',
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
                    idNumber:'',
                    name:'',
                    sex:'0',
                    age:'0',
                    political:'',
                    nativePlace:'',
                    nation:'0',
                    mobile:'',
                    email:'',
                    address:'',
                    pic:'',
                    businessSubject:'',
                    legalPerson:'',
                    businessLicense:'',
                    companyType:'0',
                    businessIncome:'',
                    businessPlace:'',
                    settledPlatform:'0',
                    shopName:'',
                    shopUrl:'',
                    creditRating:'',
                    companyWebsite:'',
                    category:'',
                    averageMonthlySales:'',
                    applicationRoom:'0',
                    applicationArea:'',
                    equipmentSource:'0',
                    businessScope:'',
                    teamNumber:'0',
                    joinAssociation:'0',
                    projectIntroduction:'',
                    status:'0',
                    remark:'',
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
                    delSettleRegister(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.formVisible = false;
                            this.getSettleRegisterList();
                            this.$message.success("删除成功");
                        } else {
                      this.$message.error(res.data.message);
                        }
                    });
                }).catch(() => {

                });
            },
            getSettleRegisterList() {
                this.loading = true;
                const self = this;
                let params = {
                    page: this.pageIndex,
                    itemcount: this.pageSize,
                    id: this.queryParam.id,
                    name: this.queryParam.name
                }
                getSettleRegisterList(params).then((res) => {
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
                this.getSettleRegisterList()
            },
            formSubmit() {
                this.$refs["subform"].validate((valid) => {
                    if (valid) {
                        this.formLoading = true;
                        let param = Object.assign({}, this.subform);
                        if (param.id != "") {
                            editSettleRegister(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getSettleRegisterList();
                                } else {
                                    this.$message.error(res.data.message);
                                }
                            });
                        } else {
                            createSettleRegister(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getSettleRegisterList();
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
                    delSettleRegister(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.getSettleRegisterList();
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
            this.getSettleRegisterList()
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
