<template>
	<view class="user-page" :style="{'height': appHeight + 'px'}">
		<view class="bg"></view>
		<view class="head">
			<view class="user-card">
				<view class="bg"></view>
				<view class="user-info">
					<view :class="{headwear: userInfo.is_money_level && userInfo.is_open_member}">
						<!-- 注释这个是加的bnt -->
						<!-- #ifdef H5 -->
						<button class="bntImg" v-if="userInfo.is_complete == 0 && isWeixin" @click="getWechatuserinfo">
							<!-- <button class="bntImg" @click="getWechatuserinfo"> -->
							<image class="avatar" src='/static/images/f.png'></image>
							<view class="avatarName">获取头像</view>
						</button>
						<!-- #endif -->
						<!-- #ifdef MP -->
						<button class="bntImg" v-if="userInfo.is_complete == 0" @tap="getUserProfile">
							<image class="avatar" src='/static/images/f.png'></image>
							<view class="avatarName">获取头像</view>
						</button>
						<!-- #endif -->
						<view v-else>
							<image class="avatar" :src='userInfo.avatar' v-if="userInfo.avatar" @click="goEdit()">
							</image>
							<image v-else class="avatar" src="/static/images/f.png" mode="" @click="goEdit()"></image>
						</view>
					</view>
		
					<view class="info">
						<!-- #ifdef MP -->
						<view class="name" v-if="!userInfo.uid" @tap="openAuto"
							style="display: flex; align-items: center;height: 100%; font-size: 30rpx;">
							请点击授权
						</view>
						<!-- #endif -->
						<view class="name" v-if="userInfo.uid">
							{{userInfo.nickname}}
							<image v-if="userInfo.vip" class="vip" :src="userInfo.vip_icon"></image>
							<image v-if="userInfo.is_money_level && userInfo.is_open_member" class="svip"
								src="/static/images/svip.png"></image>
							<view v-if="userInfo.vip && userInfo.base" class="vip-txt">{{userInfo.vip_name}}</view>
						</view>
						<view class="num" v-if="userInfo.phone" @click="goEdit()">
							<view class="num-txt">ID：{{userInfo.uid}}</view>
							<view class="icon">
								<image src="/static/images/edit.png" mode=""></image>
							</view>
						</view>
						<view class="phone" v-if="!userInfo.phone && isLogin" @tap="bindPhone">绑定手机号</view>
					</view>
				</view>
				<view class="sign" @click="goSignIn">签到</view>
			</view>
			<div>
				<view class="message">
					<navigator url="/pages/users/message_center/index" hover-class="none">
						<view class="iconfont icon-xiaoxi">
							<text class="num" v-if="userInfo.service_num">
								{{userInfo.service_num >= 100 ? '99+' : userInfo.service_num}}
							</text>
						</view>
					</navigator>
				</view>
				<view class="iconfont icon-shezhi" @click="goEdit()"></view>
			</div>
		</view>
		<view class="main">
			<!--  积分 -->
			<view class="num-wrapper">
				<view class="num-item">
					<view class="txt">收藏</view>
					<text class="num">{{userInfo.integral || 0}}</text>
				</view>
				<view class="num-item">
					<view class="txt">积分</view>
					<text class="num">{{userInfo.integral || 0}}</text>
				</view>
				<view class="num-item">
					<view class="txt">优惠券</view>
					<text class="num">{{userInfo.integral || 0}}</text>
				</view>
			</view>
			<!--  订单-->
			<view class="order-wrapper">
				<view class="order-head">
					<view class="left">订单中心</view>
					<navigator class="right flex" hover-class="none" url="/pages/users/order_list/index"
						open-type="navigate">
						查看全部
						<text class="iconfont icon-xiangyou"></text>
					</navigator>
				</view>
				<view class="order-tool">
					<block v-for="(item,index) in orderMenu" :key="index">
						<navigator class="order-item" hover-class="none" :url="item.url">
							<view class="pic">
								<image :src="item.img" mode=""></image>
								<text class="order-status-num" v-if="item.num > 0">{{ item.num }}</text>
							</view>
							<view class="txt">{{item.title}}</view>
						</navigator>
					</block>
				</view>
			</view>
			<!-- 服务 -->
			<view class="service-wrapper">
				<view class="title-box">我的服务</view>
				<view class="user-menus">
					<!-- #ifdef APP-PLUS || H5 -->
					<template v-for="(item, index) in MyMenus">
						<view v-if="item.url !== '#' && item.url !== '/pages/service/index'" class="item" :key="index"
							@click="goMenuPage(item.url, item.name)">
							<image :src="item.pic"></image>
							<text>{{ item.name }}</text>
						</view>
					</template>
					<!-- #endif -->
					<!-- #ifdef MP -->
					<template v-for="(item, index) in MyMenus">
						<view
							v-if="item.url !== '#' && item.url !== '/pages/service/index' && item.url!='/pages/customer_list/chat' || (item.url=='/pages/customer_list/chat' && routineContact == '0')"
							class="item" :key="index" @click="goMenuPage(item.url, item.name)">
							<image :src="item.pic"></image>
							<text>{{ item.name }}</text>
						</view>
					</template>
					<button class="item" open-type='contact' v-if="routineContact == '1'">
						<image src="../../static/images/contact.png"></image>
						<text>联系客服</text>
					</button>
					<!-- #endif -->
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				appHeight: this.appHeight,
				userInfo: {
					uid: 1001,
					phone: '15306035525',
					nickname: '张三',
					avatar: 'http://demo26.crmeb.net/uploads/attach/2021/02/20210205/76ace900cf16790e1070e3265f99f41d.png'
				},
				MyMenus:[],
				orderMenu: [{
						img: '/static/img/user/order1.png',
						title: '待付款',
						url: '/pages/users/order_list/index?status=0'
					},
					{
						img: '/static/img/user/order2.png',
						title: '待发货',
						url: '/pages/users/order_list/index?status=1'
					},
					{
						img: '/static/img/user/order3.png',
						title: '待收货',
						url: '/pages/users/order_list/index?status=2'
					},
					{
						img: '/static/img/user/order4.png',
						title: '待评价',
						url: '/pages/users/order_list/index?status=3'
					},
					{
						img: '/static/img/user/order5.png',
						title: '售后/退款',
						url: '/pages/users/user_return_list/index'
					},
				],
			}
		},
		created() {
			console.log(this.appHeight, this.StatusBar, this.CustomBar)
			this.MyMenus = [{
				"id": 219,
				"name": "积分中心",
				"pic": "https://demo40.crmeb.net/uploads/attach/2020/11/20201117/a4e42131851b34f6177caf633cdb18dd.png",
				"url": "/pages/users/user_integral/index"
			},
			{
				"id": 172,
				"name": "联系客服",
				"pic": "https://demo40.crmeb.net/uploads/attach/2020/11/20201117/0e1afe894c946c459e2f892cc0894afa.png",
				"url": "/pages/customer_list/chat"
			},
			{
				"id": 141,
				"name": "优惠券",
				"pic": "https://demo40.crmeb.net/uploads/attach/2020/11/20201117/1773b3563b5bf6e8980231adf786d6b1.png",
				"url": "/pages/users/user_coupon/index"
			},
			{
				"id": 140,
				"name": "我的收藏",
				"pic": "https://demo40.crmeb.net/uploads/attach/2020/11/20201117/537f9aea67cc6df860ba874044ab6611.png",
				"url": "/pages/users/user_goods_collection/index"
			},{
				"id": 139,
				"name": "地址信息",
				"pic": "https://demo40.crmeb.net/uploads/attach/2020/11/20201117/75d9cd78e50fb23f73c4d24747ec8444.png",
				"url": "/pages/users/user_address_list/index"
			},
			{
				"id": 138,
				"name": "我的余额",
				"pic": "https://demo40.crmeb.net/uploads/attach/2020/11/20201117/af39220228af28e2fa389d2b141ac378.png",
				"url": "/pages/users/user_money/index"
			},
			{
				"id": 137,
				"name": "我的推广",
				"pic": "https://demo40.crmeb.net/uploads/attach/2020/11/20201117/1dfb2b9c571e71c044c5ec60f551b535.png",
				"url": "/pages/users/user_spread_user/index"
			},{
				"id": 135,
				"name": "我的等级",
				"pic": "https://demo40.crmeb.net/uploads/attach/2020/11/20201117/28579c3fa0be9980bd2ac1d4bc802db7.png",
				"url": "/pages/users/user_vip/index"
			}]
		},
		methods: {

		}
	}
</script>

<style scoped lang="scss">
	.user-page {
		.bg {
			position: fixed;
			left: 0;
			top: 0;
			width: 100%;
			height: 100%;
			z-index: -1;
			background: #f5f5f5;
		}
		.head {
			.user-card {
				position: relative;
				width: 100%;
				height: 190rpx;
				margin: 0 auto;
				padding: 35rpx 28rpx;
				background: #22aaff;
		
				&::after {
					position: absolute;
					left: 0;
					right: 0;
					bottom: -98rpx;
					content: '';
					height: 100rpx;
					width: 100%;
					border-radius: 0 0 50% 50%;
					background-color: #22aaff;
				}
		
				.user-info {
					z-index: 20;
					position: relative;
					display: flex;
		
					.headwear {
						display: flex;
						align-items: flex-end;
						width: 128rpx;
						height: 138rpx;
						padding: 0 4rpx 4rpx;
						background: url("data:image/png;base64,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") center/cover no-repeat;
					}
		
					.bntImg {
						width: 120rpx;
						height: 120rpx;
						border-radius: 50%;
						text-align: center;
						line-height: 120rpx;
						background-color: unset;
						position: relative;
		
						.avatarName {
							font-size: 16rpx;
							color: #fff;
							text-align: center;
							background-color: rgba(0, 0, 0, 0.6);
							height: 37rpx;
							line-height: 37rpx;
							position: absolute;
							bottom: 0;
							left: 0;
							width: 100%;
						}
					}
		
					.avatar {
						display: block;
						width: 120rpx;
						height: 120rpx;
						border-radius: 50%;
						margin: 0 auto;
					}
		
					.info {
						flex: 1;
						display: flex;
						flex-direction: column;
						justify-content: space-between;
						margin-left: 20rpx;
						padding: 15rpx 0;
		
						.name {
							display: flex;
							align-items: center;
							color: #fff;
							font-size: 31rpx;
		
							.vip-txt {
								margin-left: 10rpx;
								font-size: 20rpx;
								border: 1px solid #fff;
								border-radius: 20rpx;
								padding: 0 10rpx;
							}
		
							.vip {
								width: 28rpx;
								height: 28rpx;
								margin-left: 14rpx;
							}
		
							.svip {
								width: 78rpx;
								height: 30rpx;
								margin-left: 12rpx;
							}
						}
		
						.num {
							display: flex;
							align-items: center;
							font-size: 26rpx;
							color: rgba(255, 255, 255, 0.6);
		
							image {
								width: 22rpx;
								height: 23rpx;
								margin-left: 20rpx;
							}
						}
					}
				}
		
		
		
				.sign {
					z-index: 200;
					position: absolute;
					right: -12rpx;
					top: 80rpx;
					display: flex;
					align-items: center;
					justify-content: center;
					width: 120rpx;
					height: 60rpx;
					background: linear-gradient(90deg, rgba(255, 225, 87, 1) 0%, rgba(238, 193, 15, 1) 100%);
					border-radius: 29rpx 4rpx 4rpx 29rpx;
					color: #282828;
					font-size: 28rpx;
					font-weight: bold;
				}
			}
		}
		.main {
			position: relative;
			padding: 0 10px;

			.num-wrapper {
				z-index: 30;
				position: relative;
				display: -webkit-box;
				display: -webkit-flex;
				display: flex;
				-webkit-box-align: center;
				-webkit-align-items: center;
				align-items: center;
				-webkit-box-pack: justify;
				-webkit-justify-content: space-between;
				justify-content: space-between;
				margin-top: 10px;
				height: 76px;
				border-radius: 3px;
				color: #333;
				background: #fff;

				.num-item {
					width: 33.33%;
					text-align: center;
				}
			}

			.order-wrapper {
				background-color: #fff;
				border-radius: 3px;

				.order-head {
					-webkit-box-pack: justify;
					-webkit-justify-content: space-between;
					justify-content: space-between;
					padding: 10px 15px;
					margin-top: 10px;
					border-bottom: 1px solid #F5F5F5;
					font-size: 16px;
					color: #282828;
					display: -webkit-box;
					display: -webkit-flex;
					display: flex;

					.right {
						align-items: center;
						color: #666666;
						font-size: 26rpx;

						.icon-xiangyou {
							margin-left: 5rpx;
							margin-top: 4rpx;
							font-size: 26rpx;
						}
					}
				}

				.order-tool {
					display: flex;

					.order-item {
						display: flex;
						flex-direction: column;
						justify-content: center;
						align-items: center;
						width: 20%;
						height: 160rpx;

						.pic {
							position: relative;
							text-align: center;

							image {
								width: 49rpx;
								height: 42rpx;
							}
						}

						.txt {
							margin-top: 15rpx;
							font-size: 26rpx;
							color: #454545;
						}
					}
				}
			}

			.service-wrapper {
				margin-top: 10px;
				background-color: #fff;
				border-radius: 3px;
				.title-box{
					height: 80rpx;
					line-height: 80rpx;
					padding: 0 30rpx;
					border-bottom: 1px dashed #eee;
					background-color: #fff;
				}
				.user-menus{
					background-color: #fff;
					display: flex;
					flex-wrap: wrap;
					padding: 20rpx 0;
					.item {
						position: relative;
						display: flex;
						align-items: center;
						justify-content: center;
						flex-direction: column;
						width: 25%;
						height: 120rpx;
						font-size: 24rpx;
					
						image {
							width: 46rpx;
							height: 46rpx;
							margin-bottom: 10rpx;
						}
					
					}
				}
			}
		}
		.message {
			z-index: 99;
			color: #fff;
			font-size: 40rpx;
			position: absolute;
			right: 100rpx;
			top: 60rpx;
		
			.iconfont {
				font-size: 40rpx;
				color: #fff;
				position: relative;
		
				.num {
					position: absolute;
					top: -12rpx;
					left: 24rpx;
					font-size: 10rpx;
					background-color: #fff;
					border-radius: 20rpx;
					color: #ee5a52;
					font-size: 10px;
					padding: 0 5px;
					border: 1px solid #ee1717;
				}
			}
		}
	}

	.flex {
		display: flex;
	}
</style>
