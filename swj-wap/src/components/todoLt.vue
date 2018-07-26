<template>
    <div class="vux-1px-t">
        <x-header>代办事项</x-header>
        <tab>
            <tab-item selected @on-item-click="onItemClick(0)">待审核</tab-item>
            <tab-item @on-item-click="onItemClick(1)">已审核</tab-item>
            <tab-item @on-item-click="onItemClick()">全部</tab-item>
        </tab>
        <scroller lock-x scrollbar-y use-pullup height="27em" @on-pullup-loading="loadData" ref="aScroller" :pullup-config="pullupConfig">
            <swipeout id="myswipeout">
                <swipeout-item transition-mode="follow" v-for="item in tableData" :disabled="item.isDeal==1" :key="item.id" @click.native="tipCheck(item)">
                    <div slot="right-menu" style="height:40px;padding:12px 0px">
                        <swipeout-button v-if="item.busiType==3" type="primary" @click.native="clickLt(item)">回复</swipeout-button>
                        <swipeout-button v-if="item.busiType!=3" @click.native="clickLt(item)">查看</swipeout-button>
                        <swipeout-button v-if="item.busiType!=3" @click.native="onButtonClick(1,item)" type="primary">通过</swipeout-button>
                        <swipeout-button v-if="item.busiType!=3" @click.native="onButtonClick(0,item)" type="warn">拒绝</swipeout-button>
                    </div>
                    <div slot="content" class="demo-content vux-1px-t">
                        <i class="fa fa-file-text-o" v-if="item.busiType==0" aria-hidden="true"></i>
                        <i class="fa fa-rocket-o" v-if="item.busiType==1" aria-hidden="true"></i>
                        <i class="fa fa-handshake-o" v-if="item.busiType==2" aria-hidden="true"></i>
                        <i class="fa fa-envelope-o" v-if="item.busiType==3" aria-hidden="true"></i> {{item.busiName}}
                        <span style="float:right" v-if="item.isDeal==1">
                                <i class="fa fa-check" aria-hidden="true" style="color:#00FF00"></i>
                            </span>
                        <div>{{item.createTime|time}}</div>
                    </div>
                </swipeout-item>
            </swipeout>
        </scroller>
    </div>
</template>
<script>
import XHeader from 'vux/src/components/x-header/index.vue'
import Tab from 'vux/src/components/tab/tab.vue'
import TabItem from 'vux/src/components/tab/tab-item.vue'
import Scroller from 'vux/src/components/scroller/index.vue'
import XButton from 'vux/src/components/x-button/index.vue'
import Swipeout from 'vux/src/components/swipeout/swipeout.vue'
import SwipeoutItem from 'vux/src/components/swipeout/swipeout-item.vue'
import SwipeoutButton from 'vux/src/components/swipeout/swipeout-button.vue'
// import {
//     Swipeout, 
//     SwipeoutItem, 
//     SwipeoutButton, 
//     XButton,
//     XHeader,
//     Tab, 
//     TabItem,
//     Scroller
// } from 'vux'
import {
    getToDoListList,
    todoCheck
} from '../api/api';
export default {
    components: {
        Swipeout,
        SwipeoutItem,
        SwipeoutButton,
        XButton,
        XHeader,
        Tab,
        TabItem,
        Scroller
    },
    methods: {
        clickLt(item) {
            let val = item.busiType;
            console.log(item)
            if (val == 0) { //文章articleType
                this.$router.push('/detail/' + item.busiId);
            } else if (val == 1) { //项目
                this.$router.push('/projectDetail/' + item.busiId);
            } else if (val == 2) { //绵竹造
                this.$router.push('/mzDetail/' + item.busiId);
            } else if (val == 3) { //投诉建议
                this.$router.push('/mailDetail/' + item.busiId + '?todoId=' + item.id);
            }
        },
        tipCheck(item) {
            if (this.tipCount == 0) {
                this.$vux.toast.text("请左滑审核项进行操作");
            }
            this.tipCount = 1;
        },
        loadData() {
            this.pageIndex++;
            this.getToDoListList();
        },
        onButtonClick(type, item) {
            this.checkSubmit(item.id, type);
        },
        onItemClick(type) {
            this.isDeal = type;
            this.pageIndex = 1;
            this.getToDoListList(true);
        },
        getToDoListList(isClear) {
            const self = this;
            let params = {
                page: this.pageIndex,
                itemcount: this.pageSize,
                isDeal: this.isDeal
            }
            getToDoListList(params).then((res) => {
                if (res.data.code == '000000') {
                    var result = res.data.data;
                    this.totalCount = res.data.count;
                    if (result.length != 0) {
                        this.$refs.aScroller.enablePullup();
                        if (isClear) {
                            this.tableData = result;
                            this.$nextTick(() => {
                                this.$refs.aScroller.reset({
                                    top: 0
                                })
                            })
                        } else {
                            this.tableData = this.tableData.concat(result);
                            this.$nextTick(() => {
                                this.$refs.aScroller.reset()
                            })
                        }
                    } else {
                        if (isClear) {
                            this.tableData = result;
                        }
                        this.$refs.aScroller.disablePullup();
                    }
                    this.$refs.aScroller.donePullup()


                } else {
                    self.$vux.toast.text(res.data.message);
                }
            }).catch(function(error) {
                self.$vux.toast.text('网络故障，请稍后再试');
            });
        },
        checkSubmit(reqId, type) {
            const self = this;
            let params = {
                id: reqId,
                status: type
            };
            todoCheck(params).then((res) => {
                if (res.data.code == '000000') {
                    self.$vux.toast.text("审核成功");
                    this.pageIndex = 1;
                    this.getToDoListList(true);
                } else {
                    self.$vux.toast.text(res.data.message);
                }
            }).catch(function(error) {
                self.$vux.toast.text('网络故障，请稍后再试');
            });
        },
    },
    computed: {
        swapperDisabled(item) {
            // alert(item.id)
        }
    },
    data() {
        return {
            tipCount: 0,
            tableData: [],
            pageIndex: 1,
            pageSize: 10,
            totalCount: 0,
            isDeal: 0,
            currentType: null,
            pullupConfig: {
                content: '上拉加载更多',
                downContent: '松开进行加载',
                upContent: '上拉加载更多',
                loadingContent: '加载中...',
            }
        }
    },
    mounted: function() {
        this.getToDoListList();
    }
}
</script>
<style lang="less">
@import '~vux/src/styles/1px.less';
.demo-content {
    padding: 20px 10px;
}

._img {
    width: 1.5em;
    height: 1.5em;
    border-radius: 50%;
}
</style>
