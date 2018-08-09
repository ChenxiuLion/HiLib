2018最轻量级快速开发包> HiLib（注解绑定、网络交互、文件下载、持续更新）
===
[![](https://jitpack.io/v/ChenxiuLion/Hi.svg)](https://jitpack.io/#ChenxiuLion/Hi)  [![](https://img.shields.io/badge/%E4%BD%9C%E8%80%85-ChenxiuLion-orange.svg)](https://github.com/ChenxiuLion)   [![](https://img.shields.io/badge/platform-android-brightgreen.svg)](https://developer.android.com/index.html) 
---
**项目的build.gradle 写入**

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

**App的build.gradle依赖**
```
dependencies {
	        implementation 'com.github.ChenxiuLion:Hi:1.0.3'
	}
```

**Application的onCreate中加入：**
```
    @Override
    public void onCreate() {
        super.onCreate();
        HiApp.init(this);

    }
```

1.0.3版本新增：
---
***1.Http类，使用方法：***
```
    HiApp.http.get("https://api.github.com/", new HiCallback.ToString() {
                    @Override
                    public void onFailure(int code, String errorMessage) {

                    }

                    @Override
                    public void onResponse(String response) {

                    }
                });
```
包含get、post、图片下载压缩、文件上传下载等功能：
```
   /**
     * get请求
     * @param url：url
     * @param callBack：回调接口，onFailure方法在请求失败时调用，onResponse方法在请求成功后调用，这两个方法都执行在UI线程。
     */
    public  void get(String url, HiCallback callBack) {
        get(url, null, null, callBack);
    }


```
```
    /**
     * post请求，可以传递参数
     * @param url：url
     * @param jsonStr：json格式的键值对参数
     * @param headerMap：map集合，封装请求头键值对
     * @param callBack：回调接口，onFailure方法在请求失败时调用，onResponse方法在请求成功后调用，这两个方法都执行在UI线程。
     */
    public  void postJson(String url, String jsonStr, Map<String, String> headerMap, HiCallback callBack) {
        new RequestUtil(url,jsonStr,headerMap,callBack).execute();
    }

```
具体请阅读源码Http类 借鉴[https://github.com/guozhengXia/UrlHttpUtils](https://github.com/guozhengXia/UrlHttpUtils)
---
1.0.2版本说明：
---
1.基类HiBaseActivity和HiBaseFragment，使用继承该父类即可。

2.注解@HiView绑定View->组件，已集成至基类。

3.一些自定义View:

OverScrollView ---- 阻尼效果ScrollView

CircleImageView --- 圆形头像

BadgeView      ---- 小红点

4.常用Utils


