package chen.lion.hilib;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.yanzhenjie.nohttp.InitializationConfig;
import com.yanzhenjie.nohttp.Logger;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.cache.DBCacheStore;
import com.yanzhenjie.nohttp.cookie.DBCookieStore;

import chen.lion.hilib.base.HiBaseFragment;
import chen.lion.hilib.http.Http;
import chen.lion.hilib.image.ImageLoader;
import chen.lion.hilib.view.bind.HiViewUtil;
import chen.lion.hilib.view.photo.Photo;

/**
 * 核心入口类
 * 上午11:41
 * by chenxiu
 **/
public class HiApp {


    public static Http http;
    public static Photo photo;
    public static ImageLoader image;
    private  static Context mApp;

    public static void init(Application application) {
        mApp = application;
        http = new Http();
        photo = new Photo();
        image = ImageLoader.with(mApp);

    }

    public static void initView(Activity activity) {
        HiViewUtil.initActivity(activity);

    }

    public static void initView(HiBaseFragment fragment) {
        HiViewUtil.initFragment(fragment);
    }


}
