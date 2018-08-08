package chen.lion.hilib.base;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import chen.lion.hilib.HiApp;

/**
 * Fragment封装父类
 * 所有Fragment继承此类可以重写两个核心方法
 * initData()   所有业务逻辑处理请写在这个方法里
 * initLayout() 页面布局资源id
 * <p>
 * 包含子类可调用方法：
 * goActivity(Class c,Bundle b)   代替startActivity,直接传入类名即可跳转，Bundle参数可不传
 * 上午11:50
 * by chenxiu
 **/
public abstract class HiBaseFragment extends Fragment {

    public View mView;

    protected SharedPreferences mShared;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(initLayout(), container, false);

        } else {
            ViewGroup group = (ViewGroup) mView.getParent();
            if (group != null) {
                group.removeView(mView);
            }
        }
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        HiApp.init(this);
        mShared = getActivity().getSharedPreferences(getActivity().getPackageName(), Context.MODE_PRIVATE);
        initData();
        super.onViewCreated(view, savedInstanceState);
    }

    public void goActivity(Class c) {
        goActivity(c, null);
    }

    public void goActivity(Class c, Bundle bundle) {
        Intent intent = new Intent(getActivity(), c);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);

    }

    public <T extends View> T findViewById(int id){
        return mView.findViewById(id);
    }

    protected abstract int initLayout();

    protected abstract void initData();
}
