<template>
    <div class="table">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-menu"></i> 资金管理</el-breadcrumb-item>
                <el-breadcrumb-item>项目资金信息管理</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
		<!--工具条-->
        <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
            <el-form :inline="true">
                <el-form-item>
                    <el-button type="primary" @click="handleAdd">新增父节点</el-button>
                </el-form-item>
            </el-form>
        </el-col>
        <el-col :span="24">
            <el-tree :data="dataTree" default-expand-all :render-content='renderContent' :expand-on-click-node='false' :highlight-current='true' node-key="id" :props="defaultProps" ref="tree">
            </el-tree>
        </el-col>
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
                        <el-form-item label="父级ID" prop="pid">
                            <el-input disabled v-model="subform.pid" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="资金名称" prop="fundName">
                            <el-input v-model="subform.fundName" :maxlength=50 auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                 <el-col :span='12'>
                        <el-form-item label="部门" prop="departName">
                            <el-input v-model="subform.departName" disabled :maxlength=50 auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="应拨款金额" prop="amount">
                            <el-input v-model="subform.amount" auto-complete="off">
                                <template slot="append">千元</template>
                            </el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="实际拨款金额" prop="realAmount">
                            <el-input v-model="subform.realAmount" auto-complete="off">
                                <template slot="append">千元</template>
                            </el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="拨付时间" prop="approDate">
                            <el-date-picker type="date" placeholder="选择日期" v-model="subform.approDate"></el-date-picker>
                        </el-form-item>
                    </el-col>
                    </el-row>
                    <el-row>
                    <el-col :span='12'>
                        <el-form-item label="实际余额" prop="surplusAmount">
                            <el-input readonly placeholder="提交后系统自动计算" v-model="subform.surplusAmount" auto-complete="off">
                                <template slot="append">千元</template>
                            </el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="凭证号" prop="voucherNo">
                            <el-input v-model="subform.voucherNo" :maxlength=20 auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                 <el-col :span='12'>
                        <el-form-item label="是否有效" prop="isValid">
                            <el-select v-model="subform.isValid">
                                <v-yvoption groupName="isNo"></v-yvoption>
                            </el-select>
                        </el-form-item>
                 </el-col>
                    
                    <el-col :span='12'>
                        <el-form-item label="备注" prop="remark">
                            <el-input type="textarea" :maxlength=300 v-model="subform.remark" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                 </el-row>
                 <el-row>
                    <el-col :span='12'>
                        <el-form-item label="创建人" prop="createBy">
                            <el-select disabled v-model="subform.createBy">
                                <v-yvoption tableName="user" label="nick_name" value='id'></v-yvoption>
                            </el-select>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="创建时间" prop="createTime">
                            <el-date-picker disabled type="datetime" placeholder="选择日期" v-model="subform.createTime"></el-date-picker>
                        </el-form-item>
                    </el-col>
                    <el-col :span='24'>
                        <el-form-item label="政策文件" prop="superiorFile">
                            <el-upload  v-show="imgs.length<6" class="avatar-uploader" :action="uploadUrl" :show-file-list="false" :on-success="handleAvatarSuccess" :on-progress="handleProgress" :before-upload="beforeAvatarUpload" :on-error="handleError">
                                <i v-loading="upLoading" class="el-icon-plus avatar-uploader-icon"></i>
                            </el-upload>
                            <!-- <el-progress style="width:29%" :percentage="upPercentage" :status="upFlag"></el-progress> -->

                            <el-col :span='8' v-for="(item, index) in imgs">
                                <a target="_blank" :href="item.src">
                                 <img  :src="item.src" class="avatar">
                                </a>
                                <el-button @click="delImg(index)">删除</el-button>
                            </el-col>
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
    createFund,
    getFundList,
    editFund,
    getFundTree,
    delFund,
    base
} from '../../../api/api';
import vYvoption from '../../common/yvoption.vue';
import vYvtableoption from '../../common/yvtableoption.vue';
import {checkMoney,checkRequire,checkNum} from '../../../utils/validator.js';
export default {
    data() {
            return {
                uploadUrl: base + "/upload/uploadPic",
                upPercentage: 0,
                upLoading:false,
                upFlag: '',
                dataTree: [],
                defaultProps: {
                    children: 'children',
                    label: 'fundName'
                },
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
                subform: {},
                initform: {
                   id:'',
                   fundName:'',
                   approDate:'',
                   amount:'',
                   departName:'',
                   realAmount:'',
                   noAmount:'',
                   surplusAmount:'',
                   voucherNo:'',
                   isValid:1,
				   pid:0,
                   indexId:'',
                   superiorFile:'',
                   localFile:'',
                   remark:'',
				   createBy:null,
                   createTime:'',
                },
                formRules: {
                    fundName:[{validator:checkRequire, required: true,trigger: 'blur'}],
                    amount:[{validator:checkMoney, required: true,trigger: 'blur'}],
                    realAmount:[{validator:checkMoney, required: true,trigger: 'blur'}],
					isValid:[{validator:checkRequire, required: true,trigger: 'blur'}],
                },
                formLoading: false
            }
        },
        components:{
            vYvoption,
            vYvtableoption
        },
        computed:{
            imgs(){
                if(this.subform.superiorFile==null||this.subform.superiorFile==''){
                    return [];
                }else{
                    return JSON.parse(this.subform.superiorFile);
                }
            }
        },        
        methods: {
            delImg(index){
                let superFile = JSON.parse(this.subform.superiorFile)
                superFile.splice(index,1);
                this.subform.superiorFile=JSON.stringify(superFile);
            },
            handleError(res){
                console.log(res)
            },
            handleAvatarSuccess(res, file) {
                let obj = {}
                obj.src = res.url
                let upImgs=[];
                upImgs.push(obj);
                let superFile = this.subform.superiorFile;
                if(!superFile){
                    this.subform.superiorFile = JSON.stringify(upImgs);
                }else{
                    var old = JSON.parse(superFile);
                    old = old.concat(upImgs)
                    this.subform.superiorFile=JSON.stringify(old);
                }
                this.upLoading= false;
            },
            beforeAvatarUpload(file) {
                const picType = "image/pjpeg image/gif image/bmp image/x-png image/tiff image/png image/jpeg";
                const isPIC = picType.indexOf(file.type) != '-1';
                const notNULL = file.type != '';
                const isLt5M = file.size / 1024 / 1024 < 5;

                if (!isPIC || !notNULL) {
                    this.$message.error('只能上传图片格式!');
                }
                if (!isLt5M) {
                    this.$message.error('上传图片大小不能超过 5MB!');
                }
                return isPIC && isLt5M && notNULL;
            },
            handleProgress(event, file) {
                this.upLoading=true;
                this.upPercentage = event.percent;
                if (event.percent == 100) {
                    this.upFlag = "success";
                }
            },
            renderContent(h, {
                node
            }) {
                let _data = Object.assign({}, node.data);
                let _tag = h("el-tag", {
                    props: {
                        type: "success"
                    },
                    domProps: {
                        innerHTML: "菜单显示"
                    }
                })
                let _bt1 = h("el-button", {
                    props: {
                        size: "mini",
                        type: "info"
                    },
                    domProps: {
                        innerHTML: "新增下级"
                    },
                    on: {
                        click: () => (this.handleAdd(_data))
                    }
                });
                let _bt2 = h("el-button", {
                    props: {
                        size: "mini",
                        type: "info"
                    },
                    domProps: {
                        innerHTML: "编辑"
                    },
                    on: {
                        click: () => (this.handleEdit(_data))
                    }
                });
                let _bt3 = "";
                if (node.isLeaf) {
                    _bt3 = h("el-button", {
                        props: {
                            size: "mini",
                            type: "danger"
                        },
                        domProps: {
                            innerHTML: "删除"
                        },
                        on: {
                            click: () => (this.handleDelete(_data))
                        }
                    });
                }

                let _btns = h("span", {
                    class: 'pull-right'
                }, [_bt1, _bt2, _bt3]);
                return h('span', [_data.fundName+"-实拨:"+_data.realAmount+"千元-余额:"+_data.surplusAmount+"千元", _btns]);
            },
            getTreeData() {
                let params = {
                };
                getFundTree(params).then((res) => {
                    if (res.data.code == '000000') {
                        this.dataTree = res.data.data;
                    } else {
                        this.$message.error(res.data.message);
                    }
                }).catch(function(error) {
                    self.$message.error('网络故障，请稍后再试');
                });
            },
            handleAdd(row) {
                this.formVisible = true;
                this.$nextTick(function() {
                    this.subform = Object.assign({}, this.initform);
                    this.subform.pid = row.id;
                    this.$refs['subform'].resetFields();
                    this.upPercentage = 0;
                    this.upFlag = '';
                    this.formTittle = "新增"
                })
            },
            handleEdit(row) {
                this.formVisible = true;
                this.$nextTick(function() {
                    this.$refs['subform'].resetFields();
                    this.subform = Object.assign({}, row);
                    this.upPercentage = 0;
                    this.upFlag = '';
                    this.formTittle = "编辑"
                })
            },
            handleDelete(row) {
                this.$confirm('确认删除该记录吗?', '提示', {
                    type: 'warning'
                }).then(() => {
                    let param = {
                        ids: row.id
                    };
                    delFund(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.formVisible = false;
                            this.getTreeData();
                            this.$message.success("删除成功");
                        } else {
                      this.$message.error(res.data.message);
                        }
                    });
                }).catch(() => {

                });
            },
            getFundList() {
                this.loading = true;
                const self = this;
                let params = {
                    page: this.pageIndex,
                    itemcount: this.pageSize,
                    id: this.queryParam.id,
                    name: this.queryParam.name
                }
                getFundList(params).then((res) => {
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
                this.getTreeData()
            },
            formSubmit() {
                this.$refs["subform"].validate((valid) => {
                    if (valid) {
                        this.formLoading = true;
                        let param = Object.assign({}, this.subform);
                        if (param.id != "") {
                            editFund(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getTreeData();
                                } else {
                                    this.$message.error(res.data.message);
                                }
                            });
                        } else {
                            createFund(param).then((res) => {
                                this.formLoading = false;
                                if (res.data.code == '000000') {
                                    this.$message.success("保存成功");
                                    this.formVisible = false;
                                    this.getTreeData();
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
                    delFund(param).then((res) => {
                        if (res.data.code == '000000') {
                            this.getFundList();
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
            this.getTreeData()
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
