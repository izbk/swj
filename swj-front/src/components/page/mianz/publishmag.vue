<template>
    <div class="table">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-menu"></i> 栏目</el-breadcrumb-item>
                <el-breadcrumb-item>内容发布管理</el-breadcrumb-item>
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
                        <el-form-item label="主键" prop="id">
                            <el-input v-model="subform.id" auto-complete="off" disabled></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span='12'>
                        <el-form-item label="父级ID" prop="pid">
                            <el-input v-model="subform.pid" auto-complete="off" disabled></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="栏目名称" prop="name">
                            <el-input v-model="subform.name" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="资源类型" prop="resType">
                            <el-select v-model="subform.resType" placeholder="请选择资源类型">
                                <v-yvoption groupName="resType"></v-yvoption>
                            </el-select>
                        </el-form-item>
                 </el-col>
                    
                    <el-col :span='12'>
                        <el-form-item label="链接地址" prop="href">
                            <el-input v-model="subform.href" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                    <el-col :span='12'>
                        <el-form-item label="序号" prop="sort">
                            <el-input v-model="subform.sort" auto-complete="off"></el-input>
                        </el-form-item>
                 </el-col>
                 <el-col :span='24'>
                        <el-form-item label="资源内容" v-if="subform.resType!=6" prop="resValue">
                            <el-input v-model="subform.resValue" auto-complete="off" v-if="subform.resType!=3&subform.resType!=2&subform.resType!=5"></el-input>
                            <div v-if="subform.resType==3">
                                <el-upload class="avatar-uploader" :action="uploadUrl" :show-file-list="false" :on-success="handleAvatarSuccess" :on-progress="handleProgress" :before-upload="beforeAvatarUpload">
                                <img v-if="subform.resValue" :src="subform.resValue" class="avatar">
                                <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                            </el-upload>
                            <el-progress :percentage="upPercentage" :status="upFlag"></el-progress>
                            </div>
                            <div v-if="subform.resType==2">
                                <el-cascader
                              :options="articleTree"
                              :show-all-levels="false" :change-on-select=true :props="articleProps" expand-trigger="hover" v-model="subform.articleCategorys"></el-cascader>
                            </div>
                            <div v-if="subform.resType==5">
                                <v-editor v-model="subform.resValue" :upload-url="uploadEditorUrl" :input-content="inputContent"></v-editor>
                            </div>
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
    createPublish,
    getPublishList,
    getPublishTree,
    editPublish,
    delPublish,
    getArticleCategoryTree,
    base
} from '../../../api/api';
import vYvoption from '../../common/yvoption.vue';
import vYvtableoption from '../../common/yvtableoption.vue';
import vEditor from '../../common/Editor.vue'
import {validNum} from '../../../utils/validator.js'
export default {
    data() {
            return {
                cantDelIds:[12,13,15,26],
                uploadEditorUrl: base + "/upload/uploadEditorPic",
                inputContent:"",
                uploadUrl: base + "/upload/uploadPic",
                upPercentage: 0,
                upFlag: '',
                dataTree: [],
                articleTree:[],
                articleProps: {
                  children: 'children',
                  label: 'name',
                  value:'id'
                },
                defaultProps: {
                  children: 'children',
                  label: 'name'
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
                subform: {
                   id:'',
				   pid:0,
                   name:'',
				   resType:1,
                   resValue:'',
                   articleCategorys:[],
                   href:'',
				   sort:0,
                },
                formRules: {
                    sort: [{
                        validator: validNum,
                        trigger: 'blur'
                    }],
                },
                formLoading: false
            }
        },
        components:{
            vYvoption,
            vYvtableoption,
            vEditor
        },        
        methods: {
            getArticleTreeData(){
                let params = {};
                getArticleCategoryTree(params).then((res) => {
                    if (res.data.code == '000000') {
                        this.articleTree=res.data.data;
                    } else {
                   this.$message.error(res.data.message);
                    }
                }).catch(function(error) {
                    self.$message.error('网络故障，请稍后再试');
                });
            },
            renderContent(h,{node}){
                let _data=Object.assign({},node.data);
                let _tag=h("el-tag",{props:{type:"success"},domProps:{innerHTML:"菜单显示"}})
                let _bt1=h("el-button",{props:{size:"mini",type:"info"},domProps:{innerHTML:"新增下级"},on:{click:()=>(this.handleAdd(_data))}});
                let _bt2=h("el-button",{props:{size:"mini",type:"info"},domProps:{innerHTML:"编辑"},on:{click:()=>(this.handleEdit(_data))}});
                let _bt3="";
                if(node.isLeaf){
                    if(this.cantDelIds.indexOf(node.key) == -1){
                    _bt3=h("el-button",{props:{size:"mini",type:"danger"},domProps:{innerHTML:"删除"},on:{click:()=>(this.handleDelete(_data))}});
                    }
                }
                
                let _btns=h("span",{class:'pull-right'},[_bt1,_bt2,_bt3]);
                return h('span',[_data.name,_btns]);
            },
            getTreeData(){
                let params = {};
                getPublishTree(params).then((res) => {
                    if (res.data.code == '000000') {
                        this.dataTree=res.data.data;
                    } else {
                   this.$message.error(res.data.message);
                    }
                }).catch(function(error) {
                    self.$message.error('网络故障，请稍后再试');
                });
            },
            handleAdd(row) {
                this.formVisible = true;
                this.upPercentage = 0;
                this.upFlag = '';
                this.subform={
                   id:'',
				   pid:0,
                   name:'',
				   resType:1,
                   resValue:'',
                   articleCategorys:[],
                   href:'',
				   sort:0,
                };
				this.subform.pid=row.id;
                this.formTittle = "新增"
            },
            handleEdit(row) {
                this.formVisible = true;
                this.subform = Object.assign({}, row);
                console.log(row)
                this.inputContent = this.subform.resValue;
                this.formTittle = "编辑"
            },
            handleDelete(row) {
                this.$confirm('确认删除该记录吗?', '提示', {
                    type: 'warning'
                }).then(() => {
                    let param = {
                        ids: row.id
                    };
                    delPublish(param).then((res) => {
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
            getPublishList() {
                this.loading = true;
                const self = this;
                let params = {
                    page: this.pageIndex,
                    itemcount: this.pageSize,
                    id: this.queryParam.id,
                    name: this.queryParam.name
                }
                getPublishList(params).then((res) => {
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
                            editPublish(param).then((res) => {
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
                            createPublish(param).then((res) => {
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
            handleAvatarSuccess(res, file) {
                this.subform.resValue = res.url;
            },
            beforeAvatarUpload(file) {
                const picType = "image/pjpeg image/gif image/bmp image/x-png image/tiff image/png image/jpeg";
                const isPIC = picType.indexOf(file.type) != '-1';
                const notNULL = file.type != '';
                const isLt2M = file.size / 1024 / 1024 < 2;

                if (!isPIC || !notNULL) {
                    this.$message.error('上传文件只能是图片格式!');
                }
                if (!isLt2M) {
                    this.$message.error('上传图片大小不能超过 2MB!');
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
            this.getTreeData();
            this.getArticleTreeData();
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
.pull-right{
    float:right;
    margin-right: 15px;
}
</style>
