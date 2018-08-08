package chen.lion.hilib.util;

import android.widget.ImageView;

import com.cosfund.library.libdao.ConstantValue;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

/**
 * 封装ImageLoader
 */
public class ImageLoaderUtils {

    /**
     * 显示图片，内部用ImageLoader加载，如果图片本地存在，则加载本地缓存图片，否则从服务器加载
     * @param path 图片路径
     * @param imageView
     * @param options ImageLoader显示配置
     */
    public static void displayImage(String path, final ImageView imageView,DisplayImageOptions options){
        if (path!=null){
            String img[] = path.split("/");//拆分图片地址，获取图片名称
            String name=img[img.length-1].split("\\.")[0];//图片名称，去掉后缀名
            //本地图片缓存路径,".0"见自定义缓存图片命名规则ImageNameGenerator类
            String imageUri = ConstantValue.CACHE_DIR + name+".0";
            if (SDCardUtils.isExistSDFile(imageUri)) {//如果本地有缓存的图片
                path= ConstantValue.CACHE_PATH + name+".0";
            }
            ImageLoader.getInstance().displayImage(path,imageView,options);
        }else {
            ImageLoader.getInstance().displayImage("", imageView, options);
        }
    }

    /**
     * 显示图片，内部用ImageLoader加载，如果图片本地存在，则加载本地缓存图片，否则从服务器加载
     * @param path 图片路径
     * @param imageView
     * @param options ImageLoader显示配置
     */
    public static void displayImage(String path, final ImageView imageView,DisplayImageOptions options,ImageLoadingListener listenr){
        if (path!=null){
            String img[] = path.split("/");//拆分图片地址，获取图片名称
            String name=img[img.length-1].split("\\.")[0];//图片名称，去掉后缀名
            //本地图片缓存路径,".0"见自定义缓存图片命名规则ImageNameGenerator类
            String imageUri = ConstantValue.CACHE_DIR + name+".0";
            if (SDCardUtils.isExistSDFile(imageUri)) {//如果本地有缓存的图片
                path= ConstantValue.CACHE_PATH + name+".0";
            }
            ImageLoader.getInstance().displayImage(path, imageView, options, listenr);
        }else {
            ImageLoader.getInstance().displayImage("", imageView, options,listenr);
        }
    }

    /**
     * 显示图片，内部用ImageLoader加载，如果图片本地存在，则加载本地缓存图片，否则从服务器加载
     * @param path 图片路径
     * @param imageView
     * @param emptyPath 如果是空的path，默认显示的图片
     * @param failPath 如果加载失败，默认显示的图片
     */
    public static void displayImage(String path,ImageView imageView,int emptyPath,int failPath){
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheOnDisk(true)
                .showImageForEmptyUri(emptyPath)//设置图片URI为空时默认显示图片
                .showImageOnFail(failPath)//设置图片加载失败时默认显示图片
                .build();
        if (path!=null){
            String img[] = path.split("/");//拆分图片地址，获取图片名称
            String name=img[img.length-1].split("\\.")[0];//图片名称，去掉后缀名
            //本地图片缓存路径,".0"见自定义缓存图片命名规则ImageNameGenerator类
            String imageUri = ConstantValue.CACHE_DIR + name+".0";
            if (SDCardUtils.isExistSDFile(imageUri)) {//如果本地有缓存的图片
                path= ConstantValue.CACHE_PATH + name+".0";
            }
            ImageLoader.getInstance().displayImage(path,imageView,options);
        }else {
            ImageLoader.getInstance().displayImage("", imageView, options);
        }
    }

}
