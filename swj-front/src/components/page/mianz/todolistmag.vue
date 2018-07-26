<template>
    <div class="table">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-menu"></i> 系统管理</el-breadcrumb-item>
                <el-breadcrumb-item>待办事项管理</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
		<!--工具条-->
        <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
            <el-form :inline="true">
                <el-form-item>
                    <el-button type="primary" @click="getToDoListList">查询</el-button>
                </el-form-item>
            </el-form>
        </el-col>
        <el-table :data="tableData" border style="width: 100%" v-loading.body="loading" :row-class-name="showcolor">
            <el-table-column prop="userId" width="170" label="处理人">
                <template scope="scope">
                    <v-yvtableoption tableName="user" label="nick_name" value='id' :trueValue="scope.row.userId"></v-yvtableoption>
                </template>
            </el-table-column>
             <el-table-column prop="busiName" label="业务名称"></el-table-column>
             <el-table-column prop="busiId" label="业务ID"></el-table-column>
            <el-table-column prop="busiType" label="业务类型">
                <template scope="scope">
                    <v-yvtableoption groupName="busiType" :trueValue="scope.row.busiType"></v-yvtableoption>
                </template>
            </el-table-column>
            <el-table-column prop="isDeal" label="是否处理">
                <template scope="scope">
                    <v-yvtableoption groupName="isNo" :trueValue="scope.row.isDeal"></v-yvtableoption>
                </template>
            </el-table-column>
            <el-table-column label="操作" width="180">
                <template scope="scope">
                    <el-button size="small" type="primary" @click="pushCheck(scope.$index, scope.row)" v-if="scope.row.isDeal==0">去审核/回复</el-button>
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
		<!--文章审核-->
        <v-articlecheck :articleId='subform.busiId' :todoId='subform.id' v-if='articleVisible' :articleCheckVisible='articleVisible' @on-visible-change='articleVisibleChange'></v-articlecheck>
        <!-- 投诉建议回复 -->
        <v-mailreplay :mailId='subform.busiId' :todoId='subform.id' v-if='mailReplayVisible' :checkVisible='mailReplayVisible' @on-visible-change='mailVisibleChange'></v-mailreplay>
        <!--绵竹造审核-->
        <v-mianzcheck :mianzId='subform.busiId' :todoId='subform.id' v-if='mianzVisible' :mianzCheckVisible='mianzVisible' @on-visible-change='mianzVisibleChange'></v-mianzcheck>
    </div>
</template>
<script>
import {
    createToDoList,
    getToDoListList,
    editToDoList,
    delToDoList,
    base
} from '../../../api/api';
import vYvoption from '../../common/yvoption.vue';
import vArticlecheck from '../../common/articlecheck.vue';
import vMianzcheck from '../../common/mianzcheck.vue';
import vMailreplay from '../../common/mailReplay.vue';
import vYvtableoption from '../../common/yvtableoption.vue';
export default {
    data() {
            return {
                articleVisible:false,
                mailReplayVisible:false,
                mianzVisible:false,
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
				   userId:0,
                   busiName:'',
				   busiId:0,
				   busiType:0,
				   subBusiType:0,
				   isDeal:0,
                   dealTime:'',
                },
                formRules: {

                },
                formLoading: false
            }
        },
        components:{
            vYvoption,
            vYvtableoption,
            vArticlecheck,
            vMailreplay,
            vMianzcheck
        },        
        methods: {
            articleVisibleChange(val){
                this.articleVisible=val;
                this.getToDoListList();
            },
            mailVisibleChange(val){
                this.mailReplayVisible=val;
                this.getToDoListList();
            },
            mianzVisibleChange(val){
                this.mianzVisible=val;
                this.getToDoListList();
            },
            showcolor(row,index){
                if(row.isDeal=='0'){
                    return "cred";
                }
            },

            pushCheck(index, row) {
                this.subform = Object.assign({}, row);
                if(this.subform.busiType==0){//文章
                    this.articleVisible = true;
                }else if(this.subform.busiType==1){//项目
                    // this.articleVisible = true;
                }else if(this.subform.busiType==2){//绵竹造
                     this.mianzVisible = true;
                }else if(this.subform.busiType==3){//投诉建议
                    this.mailReplayVisible = true;
                }else if(this.subform.busiType==4){//企业备案
                    // this.articleVisible = true;
                }
                
            },
            getToDoListList() {
                this.loading = true;
                const self = this;
                let params = {
                    page: this.pageIndex,
                    itemcount: this.pageSize,
                    id: this.queryParam.id,
                    name: this.queryParam.name
                }
                getToDoListList(params).then((res) => {
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
                this.getToDoListList()
            },
            
        },

        mounted: function() {
            this.getToDoListList()
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
.cred{
    color: red;
    font-weight: bold;
}
</style>
