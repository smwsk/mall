<template>
	<view>
		<!--标题栏-->
		<cu-custom bgColor="bg-gradual-blue" :isBack="true">
			<block slot="content">商品详情</block>
		</cu-custom>
		<!--轮播图-->
		<view class="banner-swiper-box">
			<swiper class="screen-swiper" circular autoplay @change="bannerSwiper">
				<swiper-item v-for="(item,index) in bannerList" :key="index">
					<image :src="item.url" mode="aspectFill" />
				</swiper-item>
			</swiper>
			<!--页码-->
			<text class="cu-tag bg-grey round sm banner-page">{{bannerCur + 1}} / {{bannerList.length}}</text>
		</view>

		<!--限时秒杀-->
		<view class="limited-seckill-box">
			<text class="text-price text-xxl">2999</text>
			<view class="text-xs cost-price-num price-4">
				<view class="text-through">原价￥6999</view>
				<view>剩余79件</view>
			</view>
			<view class="text-right time-right">
				<view>自营限时秒杀</view>
				<view class="text-xs">距结束剩余10时07分50秒</view>
			</view>
		</view>

		<!--标题-->
		<view class="bg-white view-box title-view-box">
			<view class="title-view">
				<text class="cu-tag bg-red radius sm">自营</text>
				<text class="text-black text-lg text-bold">99新苹果iPhoneX 64G深空灰色国行</text>
			</view>
			<view class="light bg-red radius margin-top-sm title-tip-box">
				<view class="text-cut">
					<text class="margin-right-sm">官方自营</text>
					<text class="text-sm">官方自营正品保障新品体验售后无忧</text>
				</view>
				<text class="cuIcon-right icon"/>
			</view>
		</view>

		<!--服务-->
		<view class="margin-top bg-white view-box service-view-box" @tap="serviceTap">
			<view class="flex flex-wrap text-sm">
				<view class="basis-1">
					<text class="text-gray">服务</text>
				</view>
				<view class="basis-7">
					<view>
						<text class="tag-view">
							<text class="cuIcon-title text-red"/>
							<text>已验机</text>
						</text>
						
						<text class="tag-view">
							<text class="cuIcon-title text-red"/>
							<text>7天无理由</text>
						</text>
						
						<text class="tag-view">
							<text class="cuIcon-title text-red"/>
							<text>180天质保</text>
						</text>
					</view>
					<view class="margin-top-xs">
						<text class="tag-view">
							<text class="cuIcon-title text-red"/>
							<text>顺丰包邮</text>
						</text>
						
						<text class="tag-view">
							<text class="cuIcon-title text-red"/>
							<text>半年电池免费换新</text>
						</text>
					</view>
				</view>
				<view class="basis-2">
					<view class="text-gray text-right icon-view">
						<text class="cuIcon-right icon"/>
					</view>
				</view>
			</view>
		</view>

		<!--促销-->
		<view class="margin-top bg-white view-box promotion-view-box">
			<view class="flex flex-wrap text-sm" @tap="promotionTap">
				<view class="basis-1">
					<text class="text-gray">促销</text>
				</view>
				<view class="basis-7">
					<view>
						<text class="cu-tag line-orange sm radius">赠品</text>
						<text class="text-view">品胜充电器套装</text>
					</view>
					<view class="margin-top-xs">
						<text class="cu-tag line-orange sm radius">分期</text>
						<text class="text-view">￥318元/月花呗/京东/微信组合支付</text>
					</view>
				</view>
				<view class="basis-2">
					<view class="text-gray text-right icon-view">
						<text class="cuIcon-right icon"/>
					</view>
				</view>
			</view>
		</view>

		<!--图片详情-->
		<view class="margin-top goods-details-box">
			<image src="/static/img/goods/goods-1.png" mode="widthFix"/>
			<image src="/static/img/goods/goods-2.png" mode="widthFix"/>
		</view>
		

		<!--占位底部距离-->
		<view class="cu-tabbar-height"/>

		<!--底部操作-->
		<view class="footer-fixed">
			<view class="cu-bar bg-white tabbar border shop">
				<button class="action">
					<view class="cuIcon-service" />
					<view>客服</view>
				</button>
				<view class="action" @tap="myCartTap">
					<view class="cuIcon-cart">
						<view class="cu-tag badge">9</view>
					</view>
					<text>购物车</text>
				</view>
				<view class="btn-group">
					<button class="cu-btn bg-orange radius shadow-blur" @tap="selectTap('add')">加入购物车</button>
					<button class="cu-btn bg-red radius shadow-blur" @tap="selectTap('sell')">立即购买</button>
				</view>
			</view>
		</view>
		
		<!--弹出框-->
		<view class="cu-modal bottom-modal bottom-modal-box" :class="bottomModal?'show':''">
			<view class="cu-dialog bg-white">
				<!--标题-->
				<view class="text-black text-center margin-tb text-lg title-bar">
					<text>{{modalTitle}}</text>
					<text class="cuIcon-close close-icon" @tap="hideModal"></text>
				</view>
				
				<!--内容区域-->
				<view class="modal-content">
					
					<!--服务区域-->
					<view class="view-box service" v-if="modalType=='service'">
						<view class="text-view">
							<text class="cuIcon-title text-red"/>
							<text class="text-cut text-black">已验机</text>
						</view>
						<view class="text-sm text-list-view">
							<view class="margin-left text-cut text-gray">转转&富士康联合制定验机标准，对设备进行专业质检</view>
						</view>
						<view class="text-view">
							<text class="cuIcon-title text-red"/>
							<text class="text-cut text-black">7天无理由</text>
						</view>
						<view class="text-sm text-list-view">
							<view class="margin-left text-cut text-gray">自收到商品7天内，不喜欢可以申请退货，并自付邮费寄回</view>
						</view>
						<view class="text-view">
							<text class="cuIcon-title text-red"/>
							<text class="text-cut text-black">180天质保</text>
						</view>
						<view class="text-sm text-list-view">
							<view class="margin-left text-cut text-gray">自订单确认收货起180天,提供免费质保</view>
						</view>
						<view class="text-view">
							<text class="cuIcon-title text-red"/>
							<text class="text-cut text-black">顺丰包邮</text>
						</view>
						<view class="text-sm text-list-view">
							<view class="margin-left text-cut text-gray">16:00前下单，今日发货，顺丰包邮(偏远地区邮政包邮)</view>
						</view>
						<view class="text-view">
							<text class="cuIcon-title text-red"/>
							<text class="text-cut text-black">半年电池免费换新</text>
						</view>
						<view class="text-sm text-list-view">
							<view class="margin-left text-cut text-gray">自订单确认收货起半年，如果电池电量低于60%，可申请免费更换原厂品质电池</view>
						</view>
					</view>
					
					<!--促销区域-->
					<view class="view-box promotion" v-if="modalType=='promotion'">
						<view class="text-view">
							<text class="cu-tag line-orange radius sm">赠品</text>
							<text class="margin-left-xs text-cut text-black">品胜充电器套装</text>
						</view>
						
						<view class="text-sm text-list-view">
							<view class="text-cut">充电头+数据线</view>
							<text class="text-right-view">价值￥99</text>
						</view>
						
						<view class="text-view">
							<text class="cu-tag line-orange radius sm">分期</text>
							<text class="margin-left-xs text-cut text-black">￥318元/月花呗/京东/微信组合支付</text>
						</view>
					</view>
					
					<!--选择规格-->
					<view class="view-box select" v-if="modalType=='select'">
						<!--商品信息-->
						<view class="cu-list menu-avatar">
							<view class="cu-item">
								<view class="cu-avatar radius lg" style="background-image:url(/static/img/goods/1.png);"/>
								<view class="content">
									<view class="text-price-view">
										<text class="text-price text-red margin-right-xs">2699</text>
										<text class="text-sm text-gray text-through">￥6999</text>
										<text class="cu-tag bg-gradual-red radius sm">
											<text class="cuIcon-hotfill"/>
											<text>秒杀中</text>
										</text>
									</view>
									<view class="text-black text-sm flex">
										<view class="text-cut">已选: 99新深空灰色64G国行三网通</view>
									</view>
								</view>
							</view>
						</view>
						
						<!--规格数据-->
						<view class="select-btn-list-boox">
							<view class="select-item">
								<view class="text-black">成色</view>
								<view class="select-btn">
									<button class="cu-btn">95新</button>
									<button class="cu-btn">9成新</button>
									<button class="cu-btn light bg-red">99新</button>
								</view>
							</view>
							
							<view class="select-item">
								<view class="text-black">颜色</view>
								<view class="select-btn">
									<button class="cu-btn light bg-red">深空灰色</button>
									<button class="cu-btn" disabled>银色</button>
								</view>
							</view>
							
							<view class="select-item">
								<view class="text-black">容量</view>
								<view class="select-btn">
									<button class="cu-btn" disabled>256G</button>
									<button class="cu-btn light bg-red">64G</button>
								</view>
							</view>
							
							<view class="select-item">
								<view class="text-black">版本</view>
								<view class="select-btn">
									<button class="cu-btn">港澳版移动4G/联通4G</button>
									<button class="cu-btn">其他版本移动4G/联通4G</button>
									<button class="cu-btn">其他版本三网通</button>
									<button class="cu-btn light bg-red">国行三网通</button>
								</view>
							</view>
							
						</view>
						
					</view>
					
					<!--公共按钮-->
					<view class="footer-fixed">
						<view class="flex flex-direction">
							<button class="cu-btn bg-red lg" @tap="hideModal">确定</button>
						</view>
					</view>
					
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	import _goods_data from '@/static/data/goods.js'; //虚拟数据
	export default {
		onLoad: function(option) { //option为object类型，会序列化上个页面传递的参数
			this.productId = option.productId
			console.log(option); //打印出上个页面传递的参数。
		},
		data() {
			return {
				bannerCur: 0,
				bannerList: [],
				bottomModal: false,modalTitle: '', modalType: 'promotion', selectType: '',
				productId: ''
			}
		},
		created() {
			this.bannerList = _goods_data.bannerListData();
		},
		methods: {
			serviceTap() {
				this.modalTitle = "服务";
				this.modalType = 'service';
				this.showModal();
			},
			promotionTap() {
				this.modalTitle = "促销优惠";
				this.modalType = 'promotion';
				this.showModal();
			},
			showModal() {
				this.bottomModal = true;
			},
			hideModal(e) {
				this.bottomModal = false;
				this.modalTitle = "";
				this.modalType = '';
			},
			bannerSwiper(e) {
				this.bannerCur = e.detail.current;
			},
			selectTap(type) {
				this.selectType = type;
				this.modalTitle = "选择规格";
				this.modalType = 'select';
				this.showModal();
			},
			myCartTap(){
				uni.navigateTo({
					url: '/pages/cart/cart'
				});
			}
		}
	}
</script>

<style lang="scss" scoped>
	.title-view-box {
		position: relative;
		.cu-tag {
		    margin-top: -9.09rpx;
		    margin-right: 9.09rpx;	
		}
		.title-tip-box {
			position: relative;
			padding: 9.09rpx 18.18rpx;
			width: 100%;
			.text-cut {
				padding-right: 27.27rpx;
			}
			.icon {
				position: absolute;
				right: 18.18rpx;
				top: 16.36rpx;
			}
		}
	}
	.bottom-modal-box {
		.cu-dialog{
			border-radius: 20px 20px 0px 0px;
		}
		.title-bar {
			position: relative;
			width: 100%;
			.close-icon {
			    position: absolute;
			    right: 36.36rpx;	
			}
		}
		.modal-content {
			position: relative;
			width: 100%;
			overflow-y: auto;
			height: calc(100vh - 654.54rpx);
			padding: 0 29.09rpx 29.09rpx;
			margin-bottom: 118.18rpx;
			.view-box {
				position: relative;
				width: 100%;
				padding: 0;
				text-align: left;
			}
			.view-box.service {
				.text-view {
					margin-bottom: 18.18rpx;
				}
				.text-list-view {
					position: relative;
					width: 100%;
					margin-bottom: 18.18rpx;
					.text-cut {
						padding-right: 21rpx;
					}
				}
				.text-list-view + .text-view {
					margin-top: 36.36rpx;
				}
			}
			.view-box.promotion {
				.text-view {
					margin-bottom: 18.18rpx;
					.cu-tag {
						position: relative;
						top: -3.63rpx;
					}
				}
				.text-list-view {
					position: relative;
					width: 100%;
					margin-bottom: 18.18rpx;
					.text-cut {
						padding-right: 218.18rpx;
					}
					.text-right-view {
						position: absolute;
						right: 0;
						top: 2rpx;
					}
				}
				.text-list-view + .text-view {
					margin-top: 36.36rpx;
				}
			}
			.view-box.select {
				.cu-list.menu-avatar>.cu-item {
					.content {
						width: calc(100% - 94.54rpx - 59.99rpx);
					}
				}
				.select-btn-list-boox {
					.select-item {
						padding: 18.18rpx 0;
						border-bottom: 2rpx solid #f3f3f3;
						.select-btn {
							position: relative;
							margin-top: 14.54rpx;
							width: 100%;
							.cu-btn {
								font-size: 23.63rpx;
								margin: 5rpx 16.36rpx 5rpx 0;
							}
							.cu-btn.light {
							    border: 2rpx solid;	
							}
							.cu-btn[disabled] {
							    color: #aaaaaa;
							}
						}
					}
				}
			}
			.footer-fixed {
				padding: 9.09rpx 29.09rpx 29.09rpx;
			}
		}
	}
	.service-view-box,.promotion-view-box{
		position: relative;
		.icon-view{
			display: flex;
			height: 100%;
			align-items: center;
			.icon{
				position: absolute;
				right: 15px;
			}
		}
		.text-view{
			margin-left: 4px;
		}
	}

	.banner-swiper-box {
		position: relative;
		width: 100%;
	}

	.banner-page {
		position: absolute;
		bottom: 14px;
		right: 14px;
		padding: 9px;
	}

	.cu-tag .sm {
		font-size: 10px;
		padding: 0px 6px;
		height: 17px;
	}

	.limited-seckill-box {
		position: relative;
		background-image: url('/static/img/home/price-bg.png');
		background-repeat: no-repeat;
		background-size: 100% 100%;
		padding: 12px 14px;
		color: #ffffff;
		width: 100%;

		.cost-price-num {
			position: absolute;
			font-weight: 200;
			left: 109px;
			top: 11px;
		}

		.time-right {
			position: absolute;
			right: 14px;
			top: 8px;
		}
	}
	.goods-details-box{
		position: relative;
		width: 100%;
		image{
			width: 100%;
		}
	}
	.footer-fixed {
		position: fixed;
		z-index: 999999;
		width: 100%;
		bottom: 0;
		left: 0;
	}
</style>
