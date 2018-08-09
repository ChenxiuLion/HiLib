package chen.lion.hi;

import android.app.Application;

import chen.lion.hilib.HiApp;

/**
 * 下午4:22
 * by chenxiu
 **/
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        HiApp.init(this);

    }
}
