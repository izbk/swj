<template>
    <div style="width:100%">
        <x-header>绵竹造上报</x-header>
        <group>
            <x-input title="产品名称" text-align="right" v-model="subform.productName" required :min=2 :max=15 placeholder="请输入项目名称" ref="input1">
              <span slot="label" style="color:black"><span style="color:red">*</span>产品名称</span>
            </x-input>

            <v-yvselect title="<span style='color:red'>*</span>所属品类"  v-model="projectTypeFormat" groupName="tradeType" placeholder="请选择所属品类" @on-change="projectTypeChange" show-name></v-yvselect>

            <x-input title="产品所属主体名称" text-align="right" ref="input2" v-model="subform.subject" required :min=2 :max=15>
              <span slot="label" style="color:black"><span style="color:red">*</span>产品所属主体名称</span>
            </x-input>

            <v-yvselect title="<span style='color:red'>*</span>主体类型"  v-model="subjectTypeFormat" groupName="enterpriseType" placeholder="请选择主体类型" @on-change="subjectTypeChange" show-name>
            </v-yvselect>
            <x-input title="联系人" text-align="right" v-model="subform.linkman" ref="input4" required :min=2 :max=15>
              <span slot="label" style="color:black"><span style="color:red">*</span>联系人</span>
            </x-input>
            <x-input title="联系电话" text-align="right" v-model="subform.contact" ref="input3" required :min=8 :max=11>
              <span slot="label" style="color:black"><span style="color:red">*</span>联系电话</span>
            </x-input>

            <v-yvselect title="<span style='color:red'>*</span>原产地"  v-model="originFormat" tableName="township" label="name" labelValue="id" placeholder="请选择产地" @on-change="originChange" show-name></v-yvselect>
            <x-input title="价格区间" text-align="right" v-model="subform.priceRange" :min=2 :max=15></x-input>
            <x-textarea :max="200" title="年生产或种植规模" v-model="subform.scale"></x-textarea>
            <!-- <x-input title="年生产或种植规模" text-align="right" v-model="subform.scale" :min=2 :max=15></x-input> -->

            <x-textarea :max="200" title="产品季节性情况" v-model="subform.seasonal"></x-textarea>
            <!-- <x-input title="产品季节性情况" text-align="right"  v-model="subform.seasonal" :min=2 :max=15></x-input> -->
             <x-textarea :max="200" title="销售渠道" v-model="subform.saleChannel"></x-textarea>
            <!-- <x-input title="销售渠道" text-align="right" v-model="subform.saleChannel" :min=2 :max=15></x-input> -->
            <x-textarea :max="200" title="销售情况评价" v-model="subform.salesStatus"></x-textarea>
            <!-- <x-input title="销售情况评价" text-align="right" v-model="subform.salesStatus" :min=2 :max=15></x-input> -->
            
            <x-textarea :max="200" title="产品认证情况" v-model="subform.accreditation"></x-textarea>
            <!-- <x-input title="产品认证情况" text-align="right" v-model="subform.accreditation" :min=2 :max=15></x-input> -->
            
            <x-textarea :max="200" title="商标注册情况" v-model="subform.trademark"></x-textarea>
            <!-- <x-input title="商标注册情况" text-align="right" v-model="subform.trademark" :min=2 :max=15></x-input> -->
            <x-textarea :max="200" title="电商销售情况" v-model="subform.onlineSale"></x-textarea>
            <!-- <x-input title="电商销售情况" text-align="right" v-model="subform.onlineSale" :min=2 :max=15></x-input> -->

            <x-textarea :max="500" title="产品描述" v-model="subform.intro"></x-textarea>

            <x-textarea :max="200" title="产品销售的意见及建议" v-model="subform.proposal"></x-textarea>

            <div style="padding:10px">
            <span style="display:block">产品展示形象</span>
            <span style="display:block;color:red;font-size:3px">说明:支持png,gif,jpeg,jpg等格式，大小不能超过5M,最多上传6张图片</span>
            <img class="weui-uploader__input-box previewer-demo-img" style="margin-top:1em" :src="item.src" v-for="(item, index) in imgs" @click="show(index)">
            <previewer :list="imgs" ref="previewer" :options="options"></previewer>
            <vue-core-image-upload v-show="imgs.length<6"
                class="weui-uploader__input-box"
                style="margin-top:1em"
                :crop="false"
                @imageuploaded="imageuploaded"
                @imagechanged="imageuploading"
                @errorhandle="errorhandle"
                :max-file-size="5242880"
                extensions="png,gif,jpeg,jpg"
                text=""
                compress="70"
                inputOfFile="file"
                :url="uploadUrl" >
              </vue-core-image-upload>
            </div>

            <div>
              
              <check-icon :value.sync="isCheck">我同意绵竹造协议<span style="margin-left:3em"><x-button :mini=true text="点击查看协议" @click.native="showCheck"></x-button></span></check-icon>
            </div>
            <x-button :show-loading="formLoading" :disabled="!$refs.input1||!$refs.input1.valid||!$refs.input3.valid||!$refs.input4.valid||subform.category==null||subform.subjectType==null||subform.origin==null||!isCheck" text="提交" type="primary" @click.native="formSubmit" style="margin-top:1em"></x-button>
        </group>

        <div v-transfer-dom-directive>
          <x-dialog v-model="showDialog" hide-on-blur :dialog-style="{'max-width': '100%',width: '100%', height: '100%', 'background-color': 'black',opacity:0.6}">
            <div style="color:#fff;text-align:left" @click="showDialog = false">
              <div style="overflow:auto;height:100%;max-width:86%;position:absolute;margin-left:9%" v-html="mianzContract"></div>
            </div>
          </x-dialog>
        </div>
    </div>
</template>
<script>
import Group from 'vux/src/components/group/index.vue'
import XInput from 'vux/src/components/x-input/index.vue'
import XButton from 'vux/src/components/x-button/index.vue'
import XHeader from 'vux/src/components/x-header/index.vue'
import Datetime from 'vux/src/components/datetime/index.vue'
import XTextarea from 'vux/src/components/x-textarea/index.vue'
import Previewer from 'vux/src/components/previewer/index.vue'
import CheckIcon from 'vux/src/components/check-icon/index.vue'
import TransferDomDirective  from 'vux/src/directives/transfer-dom/index.js'

import XDialog  from 'vux/src/components/x-dialog/index.vue'
// import {
//     XHeader,
//     Group,
//     XButton,
//     XInput,
//     Datetime,
//     XTextarea,
//     Previewer
// } from 'vux'
import {
    createSpecialty,
    getPublishTree,
    base
} from '../api/api';
import vYvselect from '../common/yvselect.vue';
import VueCoreImageUpload from 'vue-core-image-upload';
export default {
    components: {
        XHeader,
        XButton,
        Group,
        XInput,
        Datetime,
        XTextarea,
        vYvselect,
        Previewer,
        XDialog,
        CheckIcon,
         'vue-core-image-upload': VueCoreImageUpload,
    },
    computed: {

    },
    directives: {
      TransferDomDirective
    },
    methods: {
      getPublishData() {
            let self = this;
            let params = {
                id: 26
            };
            getPublishTree(params).then((res) => {
                if (res.data.code == '000000') {
                    var result = res.data.data;
                    if(result != null && result.length > 0){
                      this.mianzContract = result[0].resValue;
                    }                    
                } else {
                    self.$vux.alert.show({
                        content: res.data.message
                    })
                }
            }).catch(function(error) {
                self.$vux.alert.show({
                    content: "网络故障，请稍后再试"
                })
            });
        },
        showCheck(){
          this.showDialog=true
        },
        originChange(val) {
            this.subform.origin = val.toString();
        },
        projectTypeChange(val) {
            this.subform.category = val.toString();
        },
        subjectTypeChange(val) {
            this.subform.subjectType = val.toString();
        },
        formSubmit() {
            const self = this;
            this.formLoading = true;
            this.subform.productPic=JSON.stringify(this.imgs);
            let param = Object.assign({}, this.subform);

            createSpecialty(param).then((res) => {
                this.formLoading = false;
                if (res.data.code == '000000') {
                    this.$vux.alert.show({
                      title: '上传成功,请妥善保存查询码',
                      content: "查询码:"+res.data.data,
                    })
                    this.formVisible = false;
                    window.history.go(-1);
                } else {
                    self.$vux.toast.text(res.data.message);
                }
            });
        },
        errorhandle(res){
         this.$vux.toast.text("文件格式或大小错误");
        },
        imageuploading(){
          this.$vux.loading.show({
           text: '图片上传中'
          })
          return;
        },
        imageuploaded(res) {
          this.$vux.loading.hide()
          if (res.success) {
            let obj = {}
             obj.src = res.url
            let image = document.createElement('img')
              image.src = obj.src
              image.onload = function () {
              obj.h = image.height
              obj.w = image.width
              }
            this.imgs.push(obj);
          }
          this.$vux.toast.text(res.msg);
        },
        show (index) {
          this.$refs.previewer.show(index)
        }
    },
    mounted: function() {
      this.getPublishData();
    },
    data() {
        return {
            uploadUrl: base + "/upload/uploadPic",
            mianzContract:"",
            formDisabled: true,
            isCheck:false,
            showDialog:false,
            originFormat: [{}],
            projectTypeFormat: [{}],
            subjectTypeFormat:[{}],
            subform: {
                id:'',
               subject:'',
               subjectType:null,
               productName:'',
               scale:'',
               category:null,
               origin:null,
               seasonal:'',
               saleChannel:'',
               salesStatus:'',
               priceRange:'',
               linkman:'',
               accreditation:'',
               trademark:'',
               onlineSale:'',
               contact:'',
               proposal:'',
               productPic:'',
               intro:'',
            },
            formLoading: false,
            imgs:[],
            options: {
                getThumbBoundsFn (index) {
                  // find thumbnail element
                  let thumbnail = document.querySelectorAll('.previewer-demo-img')[index]
                  // get window scroll Y
                  let pageYScroll = window.pageYOffset || document.documentElement.scrollTop
                  // optionally get horizontal scroll
                  // get position of element relative to viewport
                  let rect = thumbnail.getBoundingClientRect()
                  // w = width
                  return {x: rect.left, y: rect.top + pageYScroll, w: rect.width}
                  // Good guide on how to get element coordinates:
                  // http://javascript.info/tutorial/coordinates
                }
              }
        }
    }
}
</script>
<style lang="less" scoped>
@import '~vux/src/styles/weui/widget/weui-uploader/index.less';
</style>
