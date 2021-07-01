<template>
	<view class="menu-scroll-view-box">
		<scroll-view class="menu-scroll-view" scroll-x @scroll="navScroll">
			<view class="menu-scroll-view-item" v-for="rootIndex in parseInt(listData.length / 10) + (listData.length % 10 ==0 ? 0 : 1)" :key="rootIndex">
				<view class="cu-list grid col-5 no-border">
					<!-- #ifdef MP -->
					<block v-for="(item,index) in listData" :key="index" v-if="index < parseInt(10 * (rootIndex + 1)) && index >= parseInt(10 * (rootIndex))">
					<!-- #endif -->
					<!-- #ifdef H5 -->
					<block v-for="(item,index) in listData" :key="index" v-if="index < parseInt(10 * (rootIndex)) && index >= parseInt(10 * (rootIndex - 1))">
					<!-- #endif -->
						<view class="cu-item" @tap="listTap(item,index)">
							<view class="grid-icon">
								<image class="icon" :src="item.img" mode="widthFix"/>
							</view>
							<view class="cu-tag badge z" :class="['bg-' + item.color]" v-if="item.badge">{{item.badge}}</view>
							<text class="text-black">{{item.name}}</text>
						</view>
					</block>
				</view>
			</view>
		</scroll-view>
		<view class="menu-scroll-h-view" v-if="listData.length > 10" :style="{width: `${scrollPage * 16}px`}">
			<view class="box">
				<view class="bg-red dot" :style="{left: `${scrollDot}px`}"></view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		name: 'grid-menu-list',
		data() {
			return {
				listData: [], scrollPage: 1, scrollDot: 0,
			};
		},
		props: {
			list_data: {
				type: Array,
				default: () => {
					return []
				}
			}
		},
		created() {
			this.listData = this.list_data;
			this.getScrollPageNum();
		},
		watch: {
			list_data() {
				this.listData = this.list_data;
				this.getScrollPageNum();
			}
		},
		methods: {
			getScrollPageNum() {
				this.scrollPage =  this.listData.length % 10 === 0 ? this.listData.length / 10: this.listData.length / 10 + 1;
			},
			navScroll(e) {
				//计算公式: 移动距离 /（A总 / B总）
				let pageWidth = this.scrollPage * 16;
				let Width = e.detail.scrollWidth / pageWidth;
				this.scrollDot = e.detail.scrollLeft / Width;
			},
			listTap(data,index) {
				this.$emit('listTap', {
					data,
					index
				});
			}
		}
	}
</script>

<style lang="scss" scoped>
	.menu-scroll-view-box {
		background-color: #ffffffba;
		position: relative;
		.menu-scroll-view {
			position: relative;
			height: 388rpx;
			white-space: nowrap;
			width: 100%;
			.menu-scroll-view-item {
				display: inline-block;
				width: 100%;
				.cu-list.grid {
					background-color: inherit;
					.grid-icon {
						margin: 0 30rpx;
						.icon {
							border-radius: 100%;
						}
					}
				}
				.cu-list.grid>.cu-item text {
					color: #333333;
				}
				.cu-list.grid>.cu-item .cu-tag {
				    transform: scale(0.8);
				}
			}
		}
		.menu-scroll-h-view {
			position: absolute;
			height: 10rpx;
			bottom: 2rpx;
			left: 0;
			right: 0;
			width: 32px;
			margin: auto;
			.box {
				position: relative;
				background: #d0cfcf;
				border-radius: 40rpx;
				width: 100%;
				height: 100%;
				.dot {
					position: absolute;
					width: 16px;
					height: 100%;
					border-radius: 40rpx;
					top: 0;
					left: 0;
					right: 0;
					bottom: 0;
				}
			}
		}
	}
</style>
