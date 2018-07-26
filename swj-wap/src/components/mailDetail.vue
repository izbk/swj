<template>
    <div style="width:100%">
        <x-header :left-options="{showBack: true}">局长信箱</x-header>
        <group>
            <group title="用户信息" titleColor="#cccccc">
                <x-input title="姓名" readonly text-align="right" placeholder="请输入真实姓名" ref="input1" v-model="subform.name" required :min=2 :max=15>
                    <span slot="label" style="color:black"><span style="color:red">*</span>姓名</span>
                </x-input>
                <x-input title="联系电话" is-type="china-mobile" readonly text-align="right" placeholder="请输入有效联系方式" ref="input2" v-model="subform.mobile" required :min=8 :max=11>
                    <span slot="label" style="color:black"><span style="color:red">*</span>联系电话</span>
                </x-input>
                <x-input title="邮箱" is-type="email" ref="input4" readonly text-align="right" placeholder="请输入有效电子邮箱" v-model="subform.email" :min=2 :max=30>
                    <span slot="label" style="color:black">邮箱</span>
                </x-input>
            </group>
            <group title="信件内容" titleColor="#cccccc">
                <v-yvselect title="主题类型" v-model="adviceTypeFormat" groupName="adviceType" placeholder="请选择主题类型" @on-change="adviceTypeChange" show-name></v-yvselect>
                <x-input title="主题" readonly text-align="right" placeholder="请输入主题" ref="input3" v-model="subform.adviceTitle" required :min=2 :max=50>
                    <span slot="label" style="color:black"><span style="color:red">*</span>主题</span>
                </x-input>
                <x-textarea :max="500" readonly placeholder="在这里输入内容" v-model="subform.adviceContent"></x-textarea>
            </group>
            <group title="回复" titleColor="#cccccc">
                <x-textarea :max="500" placeholder="在这里输入回复内容" v-model="subform.resContent"></x-textarea>
            </group>
            <x-button :show-loading="formLoading" :disabled="!subform.resContent" text="回复" type="primary" @click.native="formSubmit" style="margin-top:1em"></x-button>
        </group>
    </div>
</template>
<script>
import Group from 'vux/src/components/group/index.vue'
import XInput from 'vux/src/components/x-input/index.vue'
import XButton from 'vux/src/components/x-button/index.vue'
import XHeader from 'vux/src/components/x-header/index.vue'
import XTextarea from 'vux/src/components/x-textarea/index.vue'

import {
    getAdviceById,
    createAdvice,
    todoCheck,
    base
} from '../api/api';
import vYvselect from '../common/yvselect.vue';
export default {
    components: {
        XHeader,
        XButton,
        Group,
        XInput,
        XTextarea,
        vYvselect
    },
    computed: {

    },
    methods: {
        adviceTypeChange(val) {
            this.subform.adviceType = val.toString();
        },

        created() {
            var id = this.$route.params.id;
            var todoId = this.$route.query.todoId;
            this.todoId = todoId;
            this.id = id;
            this.getDetailData()
        },
        getDetailData() {
            let self = this;
            let params = {
                id: this.id
            };
            getAdviceById(params).then((res) => {
                if (res.data.code == '000000') {
                    var result = res.data.data;
                    this.subform = result;
                    this.adviceTypeFormat = [this.subform.adviceType.toString()];

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

        formSubmit() {
            const self = this;
            this.formLoading = true;
            let param = {
                id: this.todoId,
                content: this.subform.resContent
            };
            todoCheck(param).then((res) => {
                this.formLoading = false;
                if (res.data.code == '000000') {
                    self.$vux.toast.text("回复成功");
                    this.formVisible = false;
                    window.history.go(-1);
                } else {
                    self.$vux.toast.text(res.data.message);
                }
            });
        },
    },
    mounted: function() {
        this.created()
    },
    data() {
        return {
            formDisabled: true,
            adviceTypeFormat: [{}],
            id: '',
            todoId: '',
            subform: {
                id: '',
                name: '',
                mobile: '',
                email: '',
                adviceTitle: '',
                adviceContent: '',
                adviceType: '',
                resContent: "",
                status: ''
            },
            formLoading: false,
        }
    }
}
</script>
<style lang="less" scoped>
</style>
