package chen.lion.hilib.util;

import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;

/**
 * 作者 by Chenxiu on 2015/12/29 0029.
 * 描述：
 * 自定义Universal Image Loader缓存图片命名规则
 */
public class ImageNameGenerator implements FileNameGenerator {

        /**
         * 使用图片原名称去掉后缀名，加上".0"命名缓存图片
         * 例如：http://google/photo.png，缓存的文件为test.0
         * @param imageUri
         * @return
         */
        @Override
        public String generate(String imageUri) {
            String image[]=imageUri.split("/");
            return image[image.length-1].split("\\.")[0]+".0";
        }
}