<template>
    <div style="width:100%">
        <x-header :left-options="{showBack: false}">进度查询</x-header>
        <group>
            <x-input placeholder="查询编号" ref="input1" v-model="subform.seq" required :min=2 :max=15></x-input>
            <x-button :show-loading="formLoading" :disabled="!$refs.input1||!$refs.input1.valid" text="查询" type="primary" @click.native="formSubmit" style="margin-top:1em"></x-button>
            <card :header="{title:'查询明细'}" v-show="isShow">
              <div slot="content">
                <div class="card-demo-flex card-demo-content01">
                <div class="vux-1px-l vux-1px-r">
                  {{detail.busiType}}
                </div>
                <div class="vux-1px-r">
                  {{detail.name}}
                </div>
                <div class="vux-1px-r">
                  <span>{{detail.status}}</span>
                </div>
                </div>
                <div style="margin:20px" v-if="detail.content">
                <x-textarea title="内容"  v-model="detail.content" readonly></x-textarea>
                <x-textarea title="回复"  v-model="detail.resContent" readonly></x-textarea>
                </div>
              </div>
            </card>
        </group>
    </div>
</template>
<script>
import Group from 'vux/src/components/group/index.vue'
import XInput from 'vux/src/components/x-input/index.vue'
import XButton from 'vux/src/components/x-button/index.vue'
import XHeader from 'vux/src/components/x-header/index.vue'
import Card from 'vux/src/components/card/index.vue'
import XTextarea from 'vux/src/components/x-textarea/index.vue'

import {
    seqQuery,
    base
} from '../api/api';
export default {
    components: {
        XHeader,
        XButton,
        Group,
        XInput,
        Card,
        XTextarea
    },
    computed: {

    },
    methods: {
        formSubmit() {
            const self = this;
            this.formLoading = true;
            let param = Object.assign({}, this.subform);

            seqQuery(param).then((res) => {
                this.formLoading = false;
                if (res.data.code == '000000') {
                    this.detail=res.data.data;
                    this.isShow=true;
                    self.$vux.toast.text('查询成功');
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
            isShow:false,
            formDisabled: true,
            subform: {
                seq:''
            },
            detail:{
                busiType:'',
                name:'',
                status:'',
                content:'',
                resContent:''
            },
            formLoading: false,
        }
    }
}
</script>
<style lang="less" scoped>
@import '~vux/src/styles/1px.less';
.card-demo-flex {
  display: flex;
}
.card-demo-content01 {
  padding: 10px 0;
}
.card-padding {
  padding: 15px;
}
.card-demo-flex > div {
  flex: 1;
  text-align: center;
  font-size: 12px;
}
.card-demo-flex span {
  color: #f74c31;
}
</style>
