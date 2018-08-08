package chen.lion.hilib.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * JSON解析处理工具类
 */
public class JSONUtils {

    /**
     * 获得clazz对象
     *
     * @param json
     * @param clazz
     * @return
     */
    public static <T> T getObject(String json, Class<T> clazz) {
        T parseObject = null;
        try {
            parseObject = JSON.parseObject(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parseObject;

    }

    /**
     * 获得List<clazz>对象
     *
     * @param json
     * @param clazz
     * @return
     */
    public static <T> List<T> getListObject(String json, Class clazz) {
        List<T> parseArray = null;
        try {
            parseArray = JSON.parseArray(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parseArray;
    }


    /**
     * @param jsonObject
     * @return 整形的返回码，默认返回1
     */
    public static int getErrorCode(JSONObject jsonObject) {
        int errorCode = 1;
        try {
            errorCode = jsonObject.getInteger("ERRORCODE");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return errorCode;
    }

    /**
     * 获取错误码
     *
     * @param
     * @return
     */
    public static String error(JSONObject jsonObject) {
        String error = "";
        try {
            error = jsonObject.getString("ERRORCODE");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return error;
    }

    /**
     * 获得返回值
     *
     * @param jsonObject
     * @return
     */
    public static String getResult(JSONObject jsonObject) {
        String src = "";
        try {
            src = jsonObject.getString("Data");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return src;
    }

}
