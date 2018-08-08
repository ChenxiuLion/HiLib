package chen.lion.hilib.util;

import java.util.Random;

/**
 * 颜色工具
 * by : chenxiu
 * end update : 2016年04月22日 09:38
 * Success is getting what you want
 * happiness is wanting what you get.
 */
public class ColorUtil {

    /**
     * 获取十六进制的颜色代码
     * @param colors
     * @return
     */
    public static String getStringColorCode(int[] colors){
        String r,g,b;
        Random random = new Random();
        r = Integer.toHexString(colors[0]).toUpperCase();
        g = Integer.toHexString(colors[1]).toUpperCase();
        b = Integer.toHexString(colors[2]).toUpperCase();
        r = r.length()==1 ? "0" + r : r ;
        g = g.length()==1 ? "0" + g : g ;
        b = b.length()==1 ? "0" + b : b ;
        return r+g+b;
    }


    /**
     * 获得随机颜色
     * @return
     */
    public static int[] getRanRGB(){
        int [] colors=new int[3];
        for(int i=0;i<colors.length;i++){
            colors[i]=(int)(Math.random()*255);
        }
        if(isShenRGB(colors)){
            return getRanRGB();
        }
        return colors;
    }

    /**
     * 判断是不是深颜色
     * @return
     */
    public static boolean isShenRGB(int[] colors){
        int grayLevel = (int) (colors[0] * 0.299 + colors[1] * 0.587 + colors[2] * 0.114);
        if(grayLevel>=170){
            return true;
        }
        return false;
    }
}
