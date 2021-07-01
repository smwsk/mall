<template>
	<view class="index">
		<home v-if="PageCur=='home'"></home>
		<cart v-if="PageCur=='cart'"></cart>
		<user v-if="PageCur=='user'"></user>
		<view class="cu-bar tabbar bg-white shadow foot">
			<view class="action" @click="NavChange" data-cur="home">
				<view class='cuIcon-cu-image'>
					<image :src="'/static/tabbar/home' + [PageCur == 'home'?'_show':'_default'] + '.png'"></image>
				</view>
				<view :class="PageCur=='home'?'text-blue':'text-gray'">主页</view>
			</view>
			<view class="action" @click="NavChange" data-cur="cart">
				<view class='cuIcon-cu-image'>
					<image :src="'/static/tabbar/cart' + [PageCur == 'cart'?'_show':'_default'] + '.png'"></image>
				</view>
				<view :class="PageCur=='cart'?'text-blue':'text-gray'">购物车</view>
			</view>
			<view class="action" @click="NavChange" data-cur="user">
				<view class='cuIcon-cu-image'>
					<image :src="'/static/tabbar/user' + [PageCur == 'user'?'_show':'_default'] + '.png'"></image>
				</view>
				<view :class="PageCur=='user'?'text-blue':'text-gray'">我的</view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				PageCur: 'home',
				uid: '',
				path: ''
			}
		},
		onLoad: function(options) {

		},
		methods: {	
			NavChange: function(e) {
				this.PageCur = e.currentTarget.dataset.cur
			},
			onShareAppMessage(res) {
				withShareTicket: true
			    return {
			      title: '王者荣耀战绩P图工具,轻松生成您的游戏战绩截图和专属头像.',
			      path: this.path,
				  imageUrl: 'https://oss.123tool.cn/background/ten_KILL.png'
			    }
			},
			// 分享朋友圈
			onShareTimeline(){
				return {
					title: '王者荣耀战绩P图工具,轻松生成您的游戏战绩截图和专属头像!',
					query: 'pages/index/index',
					mageUrl: 'https://oss.123tool.cn/background/ten_KILL.png'
				}
			}
		}
	}
</script>

<style scoped>
.text-blue{
	color: #167cf9;
}
</style>
