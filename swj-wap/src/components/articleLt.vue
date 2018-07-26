<template>
    <div style="width:100%">
        <!-- <x-header :left-options="{showBack: false}">首页</x-header> -->
        <swiper :list="imgList" auto style="width:100%;margin:0 auto;" height="180px" dots-class="custom-bottom" dots-position="center"></swiper>
        <scroller lock-y :scrollbar-x=false :prevent-default="false" ref="tScroller">
            <div :style="typeStyle">
                <tab :line-width="1" id="myTab">
                    <template v-for="(item,index) in typeList">
                        <tab-item :selected="index==tabSelected" @on-item-click="onItemClick(item)">{{item.name}}</tab-item>
                    </template>
                </tab>
            </div>
        </scroller>
        <group title="筛选条件" v-show="conditionShow">
            <v-yvselect title="原产地"  v-model="originFormat" tableName="township" label="name" labelValue="id" placeholder="请选择产地" @on-change="originChange" show-name></v-yvselect>
            
            <v-yvselect title="所属品类"  v-model="projectTypeFormat" groupName="tradeType" placeholder="请选择所属品类" @on-change="projectTypeChange" show-name></v-yvselect>
            <x-button style="width:95%" type="primary" @click.native='clearCondition'>清空筛选条件</x-button>
        </group>

        <scroller lock-x scrollbar-y use-pullup height="300px" @on-pullup-loading="loadArticle" ref="aScroller" :pullup-config="pullupConfig">
            <div>
                <panel :list="articleList" :type="listType"></panel>
            </div>
        </scroller>
    </div>
</template>
<script>
import Group from 'vux/src/components/group/index.vue'
import Swiper from 'vux/src/components/swiper/swiper.vue'
import XHeader from 'vux/src/components/x-header/index.vue'
import Tab from 'vux/src/components/tab/tab.vue'
import TabItem from 'vux/src/components/tab/tab-item.vue'
import Scroller from 'vux/src/components/scroller/index.vue'
import Panel from 'vux/src/components/panel/index.vue'
import XButton from 'vux/src/components/x-button/index.vue'
import vYvselect from '../common/yvselect.vue';
// import {
//     Group,
//     Swiper,
//     XHeader,
//     Tab,
//     TabItem,
//     Scroller,
//     Panel,
// } from 'vux';
import {
    getArticleList,
    getArticleCategoryTree,
    getArticleById,
    getPublishTree,
    getArticleListWap,
    base
} from '../api/api';
export default {
    components: {
        XHeader,
        Group,
        Swiper,
        Tab,
        TabItem,
        Scroller,
        Panel,
        XButton,
        vYvselect
    },
    data() {
        return {
            projectTypeFormat: [{}],
            originFormat:[{}],
            origin:'',
            category:'',
            conditionShow:false,
            tabSelected:"0",
            typeWidth:600,
            pageIndex: 1,
            pageSize: 10,
            totalCount: 0,
            currentCa: null,
            oldCa: null,
            listType: "2",
            imgList: [],
            typeList: [],
            articleList: [],
            pullupConfig: {
                content: '上拉加载更多',
                downContent: '松开进行加载',
                upContent: '上拉加载更多',
                loadingContent: '加载中...',
            }
        }
    },
    methods: {
        clearCondition(){
            this.origin='';
            this.category='';
            this.projectTypeFormat=[{}]
            this.originFormat=[{}]
            this.getArticleLt(true);
        },
        originChange(val) {
            this.origin = val.toString();
            this.getArticleLt(true);
        },
        projectTypeChange(val) {
            this.category = val.toString();
            this.getArticleLt(true);
        },
        onItemClick(item) {
            if(item.resValue=="999"){//绵竹造
                this.conditionShow=true;
            }else{
                this.conditionShow=false;
            }
            this.currentCa=item.resValue;
            this.pageIndex=1;
            this.getArticleLt(true);
        },
        loadArticle() {
            this.pageIndex++;
            this.getArticleLt();
        },
        getPublishData() {
            let self = this;
            let params = {
                id: 12
            };
            getPublishTree(params).then((res) => {
                if (res.data.code == '000000') {
                    var result = res.data.data;
                    var items = result[0].children;
                    for (var o in items) {
                        if (items[o].name == "banner") {
                            this.imgList = items[o].images;
                        } else {
                            this.typeList = items[o].children;
                            this.typeWidth=items[o].children.length*85;
                            this.currentCa = this.typeList[0].resValue;
                            this.$nextTick(() => {
                                this.$refs.tScroller.reset({top:0})
                            })
                        }
                    }
                    if(this.$route.query.index){
                        this.tabSelected = this.$route.query.index;
                        this.currentCa=this.typeList[this.tabSelected].resValue;
                    }
                    this.getArticleLt();
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
        getArticleLt(isClear) {
            let self = this;
            let params = {
                articleCategory: this.currentCa,
                page: this.pageIndex,
                itemcount: this.pageSize,
                origin:this.origin,
                category:this.category,
            };
            getArticleListWap(params).then((res) => {
                if (res.data.code == '000000') {
                    var result = res.data.data;
                    if (result.length != 0) {
                        if(result.length<this.pageSize){
                            this.$refs.aScroller.disablePullup();
                        }else{
                            this.$refs.aScroller.enablePullup();
                        }
                        if(isClear){
                            this.articleList=result;
                            this.$nextTick(() => {
                                this.$refs.aScroller.reset({top:0})
                            })
                        }else{
                            this.articleList = this.articleList.concat(result);
                            this.$nextTick(() => {
                                this.$refs.aScroller.reset()
                            })
                        }
                        
                        
                    } else {
                        if(isClear){
                            this.articleList=result;
                        }
                        this.$refs.aScroller.disablePullup();
                    }
                    this.$refs.aScroller.donePullup()

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
        }

    },
    computed: {
        typeStyle: function () {
          return "width:"+this.typeWidth+"px;position: relative;"
        }
      },
    mounted: function() {
        this.getPublishData();
    }
}
</script>
