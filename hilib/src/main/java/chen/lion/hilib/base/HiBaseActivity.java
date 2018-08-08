package chen.lion.hilib.base;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

/**
 * Activity封装父类
 * 所有Activity继承此类可以重写两个核心方法
 * initData()   所有业务逻辑处理请写在这个方法里
 * initLayout() 页面布局资源id
 *
 * 包含子类可调用方法：
 * goActivity(Class c,Bundle b)   代替startActivity,直接传入类名即可跳转，Bundle参数可不传
 * 上午11:42
 * by chenxiu
 **/
public abstract class HiBaseActivity extends FragmentActivity {

    protected Context mContext;

    protected SharedPreferences mShare;

    private static  String BASENAME;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BASENAME = getPackageName();
        mShare = getSharedPreferences(BASENAME,MODE_PRIVATE);
        setContentView(initLayout());
        mContext = this;
        initData();
    }


    protected abstract int initLayout();

    protected abstract void initData();


    public void goActivity(Class c){
        goActivity(c,null);
    }

    public void goActivity(Class c,Bundle b){
        Intent i = new Intent(this,c);
        i.putExtras(b);
        startActivity(i);
    }
}
