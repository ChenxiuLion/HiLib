package chen.lion.hilib.view.bind;

import android.app.Activity;

import java.lang.reflect.Field;

import chen.lion.hilib.base.HiBaseFragment;

/**
 * 注解绑定
 * 下午12:14
 * by chenxiu
 **/
public class HiViewUtil {

    public static void  initActivity(Activity activity){
        Class< ? extends Activity> recfClass=activity.getClass();
        Field[] fields=recfClass.getDeclaredFields();
       for(Field field:fields){
            if(field.isAnnotationPresent(HiView.class)){
                HiView injectView= field.getAnnotation(HiView.class);
                int id= injectView.value();
                field.setAccessible(true);
                try {
                    field.set(activity,activity.findViewById(id));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void  initFragment(HiBaseFragment activity){
        Class< ? extends HiBaseFragment> recfClass=activity.getClass();
        Field[] fields=recfClass.getDeclaredFields();
        for(Field field:fields){
            if(field.isAnnotationPresent(HiView.class)){
                HiView injectView= field.getAnnotation(HiView.class);
                int id= injectView.value();
                field.setAccessible(true);
                try {
                    field.set(activity,activity.findViewById(id));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
