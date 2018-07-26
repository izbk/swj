<template>
    <div>
        <x-header :left-options="{showBack: true}">详情</x-header>
        <div class="main-wrap content-wrap">
            <article class="question">
                <h2 class="question-title">{{detailInfo.title}}</h2>
                <div class="answer">
                    <div class="meta">
                        <!-- <img class="avatar" src="http://ac-dpeFsmm4.clouddn.com/7c3fe371c2bc535aa23f.jpg"> -->
                        <span class="author">{{detailInfo.author}} {{detailInfo.createTime|time}}</span>
                    </div>
                    <div class="content" v-html="detailInfo.content">
                       
                    </div>
                </div>
            </article>
        </div>
    </div>
</template>
<script>
import Group from 'vux/src/components/group/index.vue'
import XHeader from 'vux/src/components/x-header/index.vue'
// import {
//     Group,
//     XHeader
// } from 'vux'
import {
    getArticleById,
    base
} from '../api/api';
export default {
    data() {
            return {
                id: "0",
                detailInfo: {}
            }
        },
        components: {
            Group,
            XHeader
        },
        methods: {
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
            getArticleById(params).then((res) => {
                if (res.data.code == '000000') {
                    var result = res.data.data;
                    this.detailInfo=result;
                    // this.wxShare(this.detailInfo.title,this.detailInfo.breif,null);
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
            // this.wxConfig();
            this.created();
        }
}
</script>
<style type="text/css">
html {
    font-family: Hiragino Sans GB, Helvetica, Arial, STHeiti, WenQuanYi Micro Hei, sans-serif;
}

.main-wrap {
    max-width: 80rem;
}

.content-wrap {
    overflow: hidden;
    background-color: #fff;
}

.question {
    padding: 0 20px;
    overflow: hidden;
}

.question-title {
    font-size: 19px;
    line-height: 1.4em;
    color: #222;
    font-weight: 700;
    margin: 20px 0;
    text-align: center;
}

.meta {
    white-space: nowrap;
    text-overflow: ellipsis;
    overflow: hidden;
    font-size: 16px;
    color: #b8b8b8;
}

.meta .author {
    color: #444;
}

.meta span {
    vertical-align: middle;
}

.meta .author {
    color: #444;
}

.meta .avatar {
    width: 20px;
    height: 20px;
    border-radius: 2px;
    margin-right: 5px;
}

.meta img.avatar {
    display: inline-block;
}
img {
    vertical-align: middle;
    color: transparent;
    font-size: 0;
}

.content {
    color: #444;
    line-height: 1.9em;
    margin: 10px 0 20px;
    font-size: 17px;
}

.content img {
    max-width: 100%;
    margin: 10px 0;
    display: block;
}
</style>
