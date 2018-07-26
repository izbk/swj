<template>
    <div class="table">
    <el-dialog title="文章审核" v-model="myArticleCheckVisible" :close-on-click-modal="false" size="big">
            <div v-if="loading">
                Loading...
            </div>
            <div v-if="subform">
                <h1 style="text-align:center">{{subform.title}}</h1>
                <div v-html="subform.content"></div>
                <div slot="footer" class="dialog-footer" style="float:right;margin-bottom:10px">
                        <el-button @click.native="myArticleCheckVisible = false">取消</el-button>
                        <el-button type="primary" @click.native="checkSubmit(1)">审核通过</el-button>
                        <el-button type="primary" @click.native="checkSubmit(0)">审核不通过</el-button>
                </div>
            </div>
        </el-dialog>
    </div>
</template>
<script>
import {
    getArticleById,
    todoCheck,
    base
} from '../../api/api';
export default {
    data() {
            return {
                subform: null,
                loading:false,
                myArticleCheckVisible: this.articleCheckVisible,
            }
        },
        props: {
            articleId: Number,
            todoId:Number,
            articleCheckVisible: Boolean
        },
        methods: {
            getArticle(){
                let params = {id:this.articleId};
                this.loading=true;
                getArticleById(params).then((res) => {
                    this.loading=false;
                    if (res.data.code == '000000') {

                        this.subform=res.data.data;
                    } else {
                   this.$message.error(res.data.message);
                    }
                }).catch(function(error) {
                    self.$message.error('网络故障，请稍后再试');
                });
            },
            checkSubmit(status){
                let params = {id:this.todoId,status:status};
                todoCheck(params).then((res) => {
                    if (res.data.code == '000000') {
                        this.$message.success("审核成功");
                        this.myArticleCheckVisible=false;
                    } else {
                   this.$message.error(res.data.message);
                    }
                }).catch(function(error) {
                    self.$message.error('网络故障，请稍后再试');
                });
            },
            
        },
        watch: {
            articleId: 'getArticle',
            articleCheckVisible(val) {
                this.myArticleCheckVisible = val;
            },
            myArticleCheckVisible(val) {
                this.$emit("on-visible-change", val)
            }
        },

        mounted: function() {
            this.getArticle()
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
