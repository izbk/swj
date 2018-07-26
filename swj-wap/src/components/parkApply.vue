<template>
    <div style="width:100%">
        <x-header>孵化园入园申请</x-header>
        <group>
            <v-yvselect title="<span style='color:red'>*</span>企业类型"  v-model="companyTypeFormat" groupName="companyType" placeholder="请选择企业类型" @on-change="companyTypeChange" show-name></v-yvselect>

            <x-input title="企业名称" text-align="right" v-model="subform.businessSubject" required :min=2 :max=15 placeholder="请输入企业名称" ref="input1">
                <span slot="label" style="color:black"><span style="color:red">*</span>企业名称</span>
            </x-input>

            <x-input title="法人" text-align="right"  ref="input2" v-model="subform.legalPerson" required :min=2 :max=15>
                <span slot="label" style="color:black"><span style="color:red">*</span>法人</span>
            </x-input>

           <x-input title="联系人" text-align="right" ref="input3" v-model="subform.name" required :min=2 :max=15>
                <span slot="label" style="color:black"><span style="color:red">*</span>联系人</span>
            </x-input>

            <x-input title="联系人电话" text-align="right" is-type="china-mobile" ref="input4" v-model="subform.mobile" required :min=8 :max=11>
                <span slot="label" style="color:black"><span style="color:red">*</span>负责人电话</span>
            </x-input>

            <x-input title="申请办公室数量(间)" type="number" text-align="right"  ref="input5" v-model="subform.applicationRoom" required :max=3>
            <span slot="label" style="color:black"><span style="color:red">*</span>申请办公室数量(间)</span>
            </x-input>

            <x-input title="申请仓储面积(㎡)" type="number" text-align="right" ref="input6" v-model="subform.applicationArea" required :max=8>
            <span slot="label" style="color:black"><span style="color:red">*</span>申请仓储面积(㎡)</span>
            </x-input>

            <x-input title="入住团队人数(人)" type="number" text-align="right" ref="input7" v-model="subform.teamNumber" required :max=7>
                <span slot="label" style="color:black"><span style="color:red">*</span>入住团队人数(人)</span>
            </x-input>
            
            <x-textarea :max="200" title="申请仓经营范围" v-model="subform.businessScope"></x-textarea>

            <x-textarea :max="200" title="项目简介" v-model="subform.projectIntroduction"></x-textarea>

            <x-button :show-loading="formLoading" :disabled="!$refs.input1||!$refs.input1.valid||!$refs.input2.valid||!$refs.input3.valid||!$refs.input4.valid||!$refs.input5.valid||!$refs.input6.valid||!$refs.input7.valid||subform.companyType==null" text="提交" type="primary" @click.native="formSubmit" style="margin-top:1em"></x-button>
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
import {
    createIncubationParkRegister,
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
        vYvselect
    },
    computed: {

    },
    methods: {
        companyTypeChange(val) {
            this.subform.companyType = val.toString();
        },
        formSubmit() {
            const self = this;
            this.formLoading = true;
            let param = Object.assign({}, this.subform);

            createIncubationParkRegister(param).then((res) => {
                this.formLoading = false;
                if (res.data.code == '000000') {
                    this.$vux.alert.show({
                      title: '提示',
                      content: "申请成功，最终结果请以商务局电话为准"
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
            companyTypeFormat:[{}],
            subform: {
                 id:'',
                   name:'',
                   mobile:'',
                   businessSubject:'',
                   legalPerson:'',
                   companyType:null,
                   applicationRoom:null,
                   applicationArea:'',
                   businessScope:'',
                   teamNumber:null,
                   projectIntroduction:'',
                   status:0,
                   remark:'',
                   createBy:null,
                   createTime:'',
            },
            formLoading: false,
        }
    }
}
</script>
<style lang="less" scoped>
</style>
