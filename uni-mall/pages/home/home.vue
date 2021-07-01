<template>
	<scroll-view scroll-y @scroll="pageScroll" class="home" :style="{'height': appHeight + 'px'}">
		<view class="zaiui-head-search-box" :style="[{backgroundColor:'rgba(17, 139, 255,'+ headInfo.opacity +')'}]">	
			<!--搜索框-->
			<view class="cu-bar search zaiui-search-box">
				<view class="search-form round" @tap="searchTap">
					<text class="cuIcon-search" />
					<text>口罩</text>
				</view>
			</view>
			<!--选项卡-->
			<view class="zaiui-flex-tab">
				<view class="flex text-white">
					<view class="basis-xxl" >
						<scroll-view scroll-x class="nav z" scroll-with-animation :scroll-left="headTab.scrollLeft">
							<block v-for="(item,index) in headTab.list" :key="index">
								<view class="cu-item" :class="index==headTab.TabCur?'select':''" @tap="tabSelect"
									:data-id="index">
									<view class="text-white">{{item}}</view>
									<view class="tab-dot bg-white" />
								</view>
							</block>
						</scroll-view>
					</view>
					<view class="basis-xxs flex-box">
						<view class="sort-icon" @tap="sortVueTap">
							<text class="cuIcon-sort" />
						</view>
					</view>
				</view>
			</view>
		</view>
		<!--banner-->
		<banner></banner>
		<!--滑动菜单-->
		<grid-menu-list :list_data="menuList"></grid-menu-list>
		<!--商品列表-->
		<grid-list></grid-list>
	</scroll-view>
</template>

<script>
	import banner from '@/pages/home/banner/banner'
	import gridList from '@/components/grid-list.vue'
	import gridMenuList from '@/components/grid-menu-list.vue'
	export default {
		data() {
			return {
				appHeight: this.appHeight + this.StatusBar,
				scrollY: 0,
				headInfo:{
					opacity: 0,
				},
				headTab: {
					TabCur: 0,
					scrollLeft: 0,
					list: []
				},
				menuList: [{
					id: 1,
					name: '手机',
					img: '/static/img/grid-icon/16.png',
				}, {
					id: 2,
					name: '平板',
					img: '/static/img/grid-icon/17.png',
				}, {
					id: 3,
					name: '电脑',
					img: '/static/img/grid-icon/18.png',
				}, {
					id: 4,
					name: '数码',
					img: '/static/img/grid-icon/19.png',
				}, {
					id: 5,
					name: '家电',
					img: '/static/img/grid-icon/20.png',
				}, {
					id: 6,
					name: '新人红包',
					img: '/static/img/grid-icon/21.png',
				}, {
					id: 7,
					name: '手机直播',
					img: '/static/img/grid-icon/22.png',
				}, {
					id: 8,
					name: '自营图书',
					img: '/static/img/grid-icon/23.png',
				}, {
					id: 9,
					name: '游戏',
					img: '/static/img/grid-icon/24.png',
				}, {
					id: 9,
					name: '游戏',
					img: '/static/img/grid-icon/24.png',
				}]
			}
		},
		components: {
			banner,
			gridList,
			gridMenuList
		},
		created() {
			this.headTab.list = ['首页', '服装鞋帽', '交通工具', '家电', '家居家具', '珠宝配饰', '美妆个护', '运动户外', '母婴用品', '玩具乐器', '手机', '数码',
				'电脑办公'
			]
		},
		
		methods: {
			// 跳转分类页面
			sortVueTap() {
				uni.navigateTo({
					url: "/pages/sort/sort"
				});
			},
			pageScroll(e){
				this.setPageScroll(e.detail.scrollTop)
			},
			//页面被滚动
			setPageScroll(scrollTop) {
				if(this.headTab.TabCur == 0) {
					if(scrollTop <= 100) {
						let num = scrollTop / 100;
						this.headInfo.opacity = num;
					} else if(scrollTop > 100) {
						this.headInfo.opacity = 1;
					}
				}
			},
			//搜索框下的tab菜单被点击
			tabSelect(e) {
				console.log(e)
				let index = e.currentTarget.dataset.id;
				this.headTab.TabCur = index;
				this.headTab.scrollLeft = (index - 1) * 60;
			},
		}
	}
</script>

<style lang="scss" scoped>
	.home {
		overflow: auto;
	}
	.zaiui-head-search-box {
		position: fixed;
		width: 100%;
		top: 0;
		z-index: 9999;
		background-color: rgba(229, 77, 66,0);
		padding-top: var(--status-bar-height);
		transition: top .25s;
		padding-bottom: 10rpx;
	}
	.cu-item.select {
		font-size: 30rpx;
		.tab-dot {
			position: absolute;
			height: 4rpx;
			border-radius: 20rpx;
			bottom: 2rpx;
			left: 0;
			right: 0;
			width: 50rpx;
			margin: auto;
		}
	}

	.zaiui-flex-tab {
		position: relative;
		transition: opacity .25s;

		.flex {
			.basis-xxl {
				flex-basis: 90%;
				width: 90%;
				z-index: 1;
			}

			.basis-xxs {
				flex-basis: 10%;
				z-index: 1;
				width: 10%;
			}

			.sort-icon {
				font-size: 55rpx;
				height: 64rpx;
				line-height: 64rpx;
				text-align: center;
			}
		}
	}
</style>
