<template>
    <div style="width:100%">
        <x-header :left-options="{showBack: true}">详情</x-header>
        <group>
            <x-input title="产品名称" text-align="right" readonly v-model="subform.productName" required :min=2 :max=15 placeholder="请输入项目名称" ref="input1"></x-input>

            <v-yvselect title="所属品类"  v-model="projectTypeFormat" readonly groupName="tradeType" placeholder="请选择项目类型" @on-change="projectTypeChange" show-name></v-yvselect>

            <x-input title="产品所属主体名称" text-align="right" readonly ref="input2" v-model="subform.subject" required :min=2 :max=15></x-input>

            <v-yvselect title="主体类型" v-model="subjectTypeFormat" groupName="enterpriseType" placeholder="请选择项目类型" @on-change="subjectTypeChange" show-name></v-yvselect>
            
            <x-input title="联系人" text-align="right" v-model="subform.linkman" readonly ref="input4" :min=2 :max=15></x-input>
            <x-input title="联系电话" text-align="right" readonly v-model="subform.contact" ref="input3" required :min=8 :max=11></x-input>

            <v-yvselect title="原产地"  v-model="originFormat" tableName="township" label="name" labelValue="id" show-name></v-yvselect>

            <x-input title="价格区间" text-align="right" readonly v-model="subform.priceRange" :min=2 :max=15></x-input>
            <x-textarea :max="200" readonly title="年生产或种植规模" v-model="subform.scale"></x-textarea>
            <!-- <x-input title="年生产或种植规模" text-align="right" readonly v-model="subform.scale" :min=2 :max=15></x-input> -->
            <x-textarea :max="200" readonly title="产品季节性情况" v-model="subform.seasonal"></x-textarea>
            <!-- <x-input title="产品季节性情况" text-align="right" readonly v-model="subform.seasonal" :min=2 :max=15></x-input> -->
            <x-textarea :max="200" readonly title="销售渠道" v-model="subform.saleChannel"></x-textarea>
            <!-- <x-input title="销售渠道" text-align="right" readonly v-model="subform.saleChannel" :min=2 :max=15></x-input> -->
            <x-textarea :max="200" readonly title="销售情况评价" v-model="subform.salesStatus"></x-textarea>
            <!-- <x-input title="销售情况评价" text-align="right" readonly v-model="subform.salesStatus" :min=2 :max=15></x-input> -->
            <x-textarea :max="200" readonly title="产品认证情况" v-model="subform.accreditation"></x-textarea>
            <!-- <x-input title="产品认证情况" text-align="right" readonly v-model="subform.accreditation" :min=2 :max=15></x-input> -->
            <x-textarea :max="200" readonly title="商标注册情况" v-model="subform.trademark"></x-textarea>
            <!-- <x-input title="商标注册情况" text-align="right" readonly v-model="subform.trademark" :min=2 :max=15></x-input> -->
            <x-textarea :max="200" readonly title="电商销售情况" v-model="subform.onlineSale"></x-textarea>
            <!-- <x-input title="电商销售情况" text-align="right" readonly v-model="subform.onlineSale" :min=2 :max=15></x-input> -->

            <x-textarea :max="500" title="产品描述" readonly v-model="subform.intro"></x-textarea>

            <x-textarea :max="200" title="产品销售的意见及建议" readonly v-model="subform.proposal"></x-textarea>
            <div style="padding:10px">
            <span style="display:block">产品展示形象</span>
            <img class="weui-uploader__input-box previewer-demo-img" style="margin-top:1em" :src="item.src" v-for="(item, index) in imgs" @click="show(index)">
            <previewer :list="imgs" ref="previewer" :options="options"></previewer>
            </div>
        </group>
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
    getSpecialtyById,
    base
} from '../api/api';
import vYvselect from '../common/yvselect.vue';
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
    },
    computed: {

    },
    methods: {
        projectTypeChange(val) {
            this.subform.projectType = val.toString();
        },
        subjectTypeChange(val) {
            this.subform.subjectType = val.toString();
        },
        show (index) {
          this.$refs.previewer.show(index)
        },
        created() {
                var id = this.$route.params.id;
                this.id = id;
                this.getDetailData()
            },
          getDetailData() {
            let self = this;
            let params = {
                id: this.id
            };
            getSpecialtyById(params).then((res) => {
                if (res.data.code == '000000') {
                    var result = res.data.data;
                    this.subform=result;
                    if (parseFloat(this.subform.category).toString() != "NaN") {
                      this.projectTypeFormat=[this.subform.category.toString()];
                    }
                    if (parseFloat(this.subform.subjectType).toString() != "NaN") {
                      this.subjectTypeFormat=[this.subform.subjectType.toString()];
                    }
                    if (parseFloat(this.subform.origin).toString() != "NaN") {
                      this.originFormat=[this.subform.origin.toString()];
                    }
                    
                    if(this.subform.productPic){
                      this.imgs=JSON.parse(this.subform.productPic);
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
    },
    mounted: function() {
      this.created();
    },
    data() {
        return {
            uploadUrl: base + "/upload/uploadPic",
            formDisabled: true,
            projectTypeFormat: [{}],
            subjectTypeFormat:[{}],
            originFormat:[{}],
            subform: {
                id:'',
               subject:'',
               subjectType:'',
               projectType:'',
               productName:'',
               linkman:'',
               scale:'',
               category:'',
               origin:'',
               seasonal:'',
               saleChannel:'',
               salesStatus:'',
               priceRange:'',
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
