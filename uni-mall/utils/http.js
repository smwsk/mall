import axios from './uni-axios'
import {baseUrl} from "@/api/params";

// 创建自定义接口服务实例
const http = axios.create({
    baseURL: baseUrl, // baseUrl 公共前缀
    timeout: 60 * 1000,  // 不可超过 manifest.json 中配置 networkTimeout的超时时间
    // #ifdef H5
    withCredentials: true,
    // #endif
    headers: {
        'Content-Type': 'application/json'
    },
});

// 创建自定义接口服务实例
const formDataHttp = axios.create({
    baseURL: baseUrl, // baseUrl 公共前缀
    timeout: 60 * 1000,  // 不可超过 manifest.json 中配置 networkTimeout的超时时间
    // #ifdef H5
    withCredentials: true,
    // #endif
    headers: {
    },
});

// 拦截器 在请求之前拦截
http.interceptors.request.use(async config => {
    const token = uni.getStorageSync('token');
    const userInfo = uni.getStorageSync('user');
    let commonHeader = {};

    if (token && userInfo) {
        commonHeader = {
            "token": token,
            "uid": userInfo.id
        };
    }
    config.headers = {...config.headers, ...commonHeader,};
	return config
}, (error) => {
    // 对请求错误做些什么
    return Promise.reject(error);
});


// 拦截器 在请求之后拦截
http.interceptors.response.use(async response => {
	switch (response.data.code) {
        case 1000:
            return response.data.data;
            break;
        case 1:
            uni.showToast({title: response.data.msg, icon: 'none'});
            throw response.data.msg;
            break;
        case 600:
			let params = {}
			// 登录过期重新获取code 进行登录
			var that = this
			let code  = ''
			uni.getProvider({
			    service: 'oauth',
			    success: function (res) {
					let provider = res.provider
					uni.login({
					    provider: provider,
					    success: function (loginRes) {
							code = loginRes.code
							http.post('wechat/refreshTokenByCode', {
							    'jsCode': code,
								...params,
							}).then(r => {
								let token = r.data.token
								// 更新token 下一次加载数据就不会失效
								uni.setStorageSync('token',token);
								uni.setStorageSync('user',r.data.user)
							})
						}
					});
			    },fail: function(error){
					console.log(error)
			    }
			})
			throw response.data.msg;
            break;
        default:
            uni.showToast({ title: response.data.msg, icon: "none" });
            throw response.data.msg;
            break;
    }
}, error => {
    uni.hideLoading();
    return Promise.reject(error.message)
});

export default http;
export function postFormData(url, data, headers){
	return new Promise((resolve, reject) => {
	    formDataHttp.post(url, data, headers)
	        .then(response => {
	            resolve(response);
	        })
	        .catch(err => {
	            reject(err);
	        });
	});
}

export function get(url, params = {}) {
    return new Promise((resolve, reject) => {
        http.get(url, {
                params,
            })
            .then(response => {
                resolve(response);
            })
            .catch(err => {
                reject(err);
            });
    });
}


export function post(url, params = {},headers={}) {
    return new Promise((resolve, reject) => {
        http.post(url, {
                params,
            },headers)
            .then(response => {
                resolve(response);
            })
            .catch(err => {
                reject(err);
            });
    });
}
