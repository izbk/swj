<template>
    <div style="width:100%">
        <x-header>会展活动报名</x-header>
        <group>

        <v-yvselect title="<span style='color:red'>*</span>会展名称"  v-model="exhibitionIdFormat" tableName="exhibition" label="exhibition_name" labelValue='id' placeholder="请选择会展活动" @on-change="exhibitionIdChange" show-name></v-yvselect>

            <x-input title="参展企业名称" text-align="right" v-model="subform.enterpiseName" required :min=2 :max=15 placeholder="请输入企业名称" ref="input1">
                <span slot="label" style="color:black"><span style="color:red">*</span>参展企业名称</span>
            </x-input>
            
            <v-yvselect title="<span style='color:red'>*</span>参展产品类别"  v-model="exhiProductTypeFormat" groupName="exhiProductType" placeholder="请选择参展产品类别" @on-change="exhiProductTypeChange" show-name></v-yvselect>
            
            
            <x-input title="联系人" text-align="right" ref="input2" v-model="subform.linkman" required :min=2 :max=15>
                <span slot="label" style="color:black"><span style="color:red">*</span>联系人</span>
            </x-input>

            <x-input title="联系电话" text-align="right" is-type="china-mobile" ref="input3" v-model="subform.contact" required :min=8 :max=11>
                <span slot="label" style="color:black"><span style="color:red">*</span>联系电话</span>
            </x-input>

            <x-input title="参展人数" type="number" text-align="right" ref="input4" v-model="subform.participantNum" required :max=7>
                <span slot="label" style="color:black"><span style="color:red">*</span>参展人数</span>
            </x-input>

            <x-input title="申请展位数量" type="number" text-align="right" ref="input5" v-model="subform.boothNum" required :max=7>
                <span slot="label" style="color:black"><span style="color:red">*</span>申请展位数量</span>
            </x-input>

            <datetime v-model="subform.enterDate" title="参会时间">
                <span slot="title" style="color:black"><span style="color:red">*</span>参会时间</span>
            </datetime>
            <group title="<span style='font-size:1.2em'>荣誉</span>" titleColor="black">
              <v-yvchecker groupName="honor" v-model="subform.honors">
              </v-yvchecker>
            </group>
            <x-textarea :max="200" placeholder="意见和建议" v-model="subform.feedback"></x-textarea>

            <x-button :show-loading="formLoading" :disabled="!$refs.input1||!$refs.input1.valid||!$refs.input2.valid||!$refs.input3.valid||!$refs.input4.valid||!$refs.input5.valid||subform.exhibitionId==null||subform.exhiProductType==null||subform.enterDate==null" text="提交" type="primary" @click.native="formSubmit" style="margin-top:1em"></x-button>
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
// import Checker from 'vux/src/components/checker/checker.vue'
// import CheckerItem from 'vux/src/components/checker/checker-item.vue'
import {
    createExhibitionRegister,
    base
} from '../api/api';
import vYvselect from '../common/yvselect.vue';
import vYvchecker from '../common/yvchecker.vue';
export default {
    components: {
        XHeader,
        XButton,
        Group,
        XInput,
        Datetime,
        XTextarea,
        vYvselect,
        vYvchecker,
        // Checker,
        // CheckerItem
    },
    computed: {

    },
    methods: {
        exhibitionIdChange(val) {
            this.subform.exhibitionId = val.toString();
        },
        exhiProductTypeChange(val) {
            this.subform.exhiProductType = val.toString();
        },
        formSubmit() {
            const self = this;
            this.formLoading = true;
            let param = Object.assign({}, this.subform);

            createExhibitionRegister(param).then((res) => {
                this.formLoading = false;
                if (res.data.code == '000000') {
                    this.$vux.alert.show({
                      title: '提示',
                      content: "申请报名成功，最终报名结果请以商务局电话为准"
                    })
                    window.history.go(-1);
                } else {
                    self.$vux.toast.text(res.data.message);
                }
            });
        },
    },
    mounted: function() {
    },
    data() {
        return {
            formDisabled: true,
            exhibitionIdFormat: [{}],
            exhiProductTypeFormat: [{}],
            subform: {
                id:'',
               exhibitionId:null,
               exhibitionName:'',
               enterpiseName:'',
               linkman:'',
               contact:'',
               participantNum:'',
               exhiProductType:null,
                boothNum:0,
                honors:[],
               enterDate:null,
               feedback:'',
               regTime:'',
               feedTime:'',
            },
            formLoading: false,
        }
    }
}
</script>
<style scoped>
.item {
  border: 1px solid #ececec;
  padding: 5px 15px;
}
.item-selected {
  border: 2px solid green;
}
</style>
