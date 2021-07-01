function checkImgSafe(tempFilePath){
	// 选择图片
	try {
	  const invokeRes = wx.serviceMarket.invokeService({
	    service: 'wxee446d7507c68b11',
	    api: 'OcrAllInOne',
	    data: {
	      // 用 CDN 方法标记要上传并转换成 HTTP URL 的文件
	      img_url: new wx.serviceMarket.CDN({
	        type: 'filePath',
	        filePath: tempFilePath,
	      }),
	      data_type: 3,
	      ocr_type: 1
	    },
	  })
	  console.log('invokeService success', invokeRes)
	  wx.showModal({
	    title: 'success',
	    content: JSON.stringify(invokeRes),
	  })
	} catch (err) {
	  console.error('invokeService fail', err)
	  wx.showModal({
	    title: 'fail',
	    content: err,
	  })
	}
}

function saveImg(tempFilePath){
	console.log(tempFilePath)
	var that = this
	uni.showLoading({title: '保存中...'});
	uni.saveImageToPhotosAlbum({
		filePath: tempFilePath,
		success: function() {
			uni.showToast({
				title: "保存成功",
				icon: "none"
			});
		},
		fail: function(error) {
			uni.hideLoading();
			console.log(error)
			let errMsg = error.errMsg
			if(errMsg.indexOf('cancel') > 0){
				uni.showToast({
					title: '保存失败',
					icon: 'none'
				})
				return
			}else{
				uni.showModal({
					title: '提示',
					content: '保存失败,请允保存到相册后重试',
					success: function (res) {
						if (res.confirm) {
							uni.openSetting({
							    scope: 'scope.writePhotosAlbum',
							    success(resp) {
									console.log(resp)
							    },
								fail(error) {
									uni.showToast({
										title: '保存失败',
											icon: 'none'
									})
								}
							})
						} else if (res.cancel) {
							console.log('用户点击取消');
						}
					}
				});
			}	
		}
	});
}

function getImgInfo(imgUrl){ 
	return new Promise((resolve, reject) => {
		uni.downloadFile({
			url: imgUrl,
			success: (resp) => {
				resolve(resp)
			},
			fail:(error)=>{
				reject(error)
			}
		})
	})
}

/**
* @author zhangxinxu(.com)
* @licence MIT
* @description http://www.zhangxinxu.com/wordpress/?p=7362
*/
function drawTextVertical(context, text, fontSize, x, y) {
  var arrText = text.split('');
  var arrWidth = arrText.map(function (letter) {
    return fontSize;
  });
  
  var align = context.textAlign;
  var baseline = context.textBaseline;
 
  if (align == 'left') {
    x = x + Math.max.apply(null, arrWidth) / 2;
  } else if (align == 'right') {
    x = x - Math.max.apply(null, arrWidth) / 2;
  }
  if (baseline == 'bottom' || baseline == 'alphabetic' || baseline == 'ideographic') {
    y = y - arrWidth[0] / 2;
  } else if (baseline == 'top' || baseline == 'hanging') {
    y = y + arrWidth[0] / 2;
  }
 
  context.textAlign = 'center';
  context.textBaseline = 'middle';
 
  // 开始逐字绘制
  arrText.forEach(function (letter, index) {
    // 确定下一个字符的纵坐标位置
    var letterWidth = arrWidth[index];
    // 是否需要旋转判断
    var code = letter.charCodeAt(0);
    if (code <= 256) {
      context.translate(x, y);
      // 英文字符，旋转90°
      context.rotate(90 * Math.PI / 180);
      context.translate(-x, -y);
    } else if (index > 0 && text.charCodeAt(index - 1) < 256) {
      // y修正 
      y = y + arrWidth[index - 1] / 2;
    }else{
	  y = y + 5
	}
    context.fillText(letter, x, y);
    // 旋转坐标系还原成初始态
    context.setTransform(1, 0, 0, 1, 0, 0);
    // 确定下一个字符的纵坐标位置
    var letterWidth = arrWidth[index];
    y = y + letterWidth;
  });
  // 水平垂直对齐方式还原
  context.textAlign = align;
  context.textBaseline = baseline;
}
 

export { saveImg, getImgInfo, drawTextVertical ,checkImgSafe}