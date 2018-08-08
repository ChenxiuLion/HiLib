package chen.lion.hilib;

import android.app.Activity;

import chen.lion.hilib.base.HiBaseFragment;
import chen.lion.hilib.view.bind.HiViewUtil;

/**
 * 核心入口类
 * 上午11:41
 * by chenxiu
 **/
public class HiApp {


    public static void init(Activity activity){
        HiViewUtil.initActivity(activity);

    }
    public static void init(HiBaseFragment fragment){
        HiViewUtil.initFragment(fragment);
    }

}
