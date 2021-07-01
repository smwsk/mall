<template>
	<view class="product-box">
		<view class="group-name">{{title}}</view>
		<view class="product-list">
			<view class="product-container">
				<view class="product-item" @tap="goToDetail(item)" v-for="(item,index) in leftList" :key="index">
					<image class="product-img" :src="item.imageUrl"></image>
					<view class="product-content">
						<view class="product-title">欧莱雅（LOREAL）奇焕光彩粉嫩透亮修颜霜 30ml（欧莱雅彩妆 BB霜 粉BB 遮瑕疵 隔离）</view>
						<view>
							<view class="product-price">
								<text class="sale-price">￥599</text>
								<text class="factory-price">￥900</text>
								<text class="product-pay">2342人付款</text>
							</view>
						</view>
					</view>
				</view>
			</view>
			<view class="product-container">
				<view class="product-item" @tap="goToDetail(item)" v-for="(item,index) in rightList" :key="index">
					<image class="product-img" :src="item.imageUrl" lazy-load></image>
					<view class="product-content">
						<view class="product-title">欧莱雅（LOREAL）奇焕光彩粉嫩透亮修颜霜 30ml（欧莱雅彩妆 BB霜 粉BB 遮瑕疵 隔离）</view>
						<view>
							<view class="product-price">
								<text class="sale-price">￥599</text>
								<text class="factory-price">￥900</text>
								<text class="product-pay">2342人付款</text>
							</view>
						</view>
					</view>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		props: {
			title: {
				default: '热门推荐'
			},
			dataList: {
				default: () => [],
				type: Array
			}
		},
		name: "grid-list",
		data() {
			return {
				leftList: [],
				rightList: []
			};
		},
		mounted() {
			this.gridList = this.dataList
		},
		created() {
			this.initData()
		},
		methods: {
			goToDetail(item){
				uni.navigateTo({
				    url: '/pages/good-detail/good-detail?productId='+item.productId
				});
			},
			initData() {
				var params = {}
				this.$get('product/listProductPage', params)
					.then((res) => {
						this.gridList = res.data
						if (this.gridList.length > 0) {
							for (let index = 1; index <= this.gridList.length; index++) {
								if (index % 2 === 0) {
									this.rightList.push(this.gridList[index - 1])
								} else {
									this.leftList.push(this.gridList[index - 1])
								}
							}
						}
					})
			}
		}
	}
</script>

<style lang="scss" scoped>
	.product-img>img {
		-webkit-touch-callout: none;
		-webkit-user-select: none;
		-moz-user-select: none;
		display: block;
		position: absolute;
		top: 0;
		left: 0;
		opacity: 0;
	}

	.product-box {
		margin-top: 9px;
		padding: 0 9px;
		box-sizing: border-box;

		.group-name {
			width: 100%;
			font-size: 15px;
			font-weight: bold;
			text-align: center;
			padding: 11px 0;
			display: -webkit-box;
			display: -webkit-flex;
			display: flex;
			-webkit-box-align: center;
			-webkit-align-items: center;
			align-items: center;
			-webkit-box-pack: center;
			-webkit-justify-content: center;
			justify-content: center;
		}

		.product-list {
			display: -webkit-box;
			display: -webkit-flex;
			display: flex;
			-webkit-box-pack: justify;
			-webkit-justify-content: space-between;
			justify-content: space-between;
			-webkit-box-orient: horizontal;
			-webkit-box-direction: normal;
			-webkit-flex-direction: row;
			flex-direction: row;
			-webkit-flex-wrap: wrap;
			flex-wrap: wrap;
			box-sizing: border-box;

			.product-container:last-child {
				margin-right: 0;
			}

			.product-container {
				-webkit-box-flex: 1;
				-webkit-flex: 1;
				flex: 1;
				margin-right: 2%;

				.product-item {
					width: 100%;
					margin-bottom: 4%;
					background: #fff;
					box-sizing: border-box;
					border-radius: 5px;
					overflow: hidden;

					.product-img {
						height: 25vh;
						width: 100%;
						display: block;
					}
				}

				.product-content {
					display: -webkit-box;
					display: -webkit-flex;
					display: flex;
					-webkit-box-orient: vertical;
					-webkit-box-direction: normal;
					-webkit-flex-direction: column;
					flex-direction: column;
					-webkit-box-pack: justify;
					-webkit-justify-content: space-between;
					justify-content: space-between;
					box-sizing: border-box;
					padding: 9px;

					.product-title {
						color: #2e2e2e;
						font-size: 12px;
						word-break: break-all;
						overflow: hidden;
						text-overflow: ellipsis;
						display: -webkit-box;
						-webkit-box-orient: vertical;
						-webkit-line-clamp: 2;
					}

					.product-price {
						padding-top: 8px;
					}

					.sale-price {
						font-size: 16px;
						font-weight: 500;
						color: #e41f19;
					}

					.factory-price {
						font-size: 11px;
						color: #a0a0a0;
						text-decoration: line-through;
						padding-left: 5px;
					}

					.product-pay {
						padding-top: 4px;
						font-size: 11px;
						color: #656565;
						float: right;
					}
				}
			}
		}
	}
</style>
