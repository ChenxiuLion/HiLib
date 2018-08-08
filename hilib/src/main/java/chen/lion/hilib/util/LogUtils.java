package chen.lion.hilib.util;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 作者 by Chenxiu on 2015/12/29 0029.
 * 描述：
 * 日志工具类
 */
public class LogUtils {

    private static final String TAG = "app_name";

    private LogUtils() {
    }

    /**
     * @see Log#d(String, String)
     */
    public static void d(String message) {
        Log.d(TAG, buildMessage(message));
    }

    /**
     * @see Log#e(String, String)
     */
    public static void e(String message) {
        Log.e(TAG, buildMessage(message));
    }

    /**
     * @see Log#i(String, String)
     */
    public static void i(String message) {
        Log.i(TAG, buildMessage(message));
    }

    /**
     * @see Log#v(String, String)
     */
    public static void v(String message) {
        Log.v(TAG, buildMessage(message));
    }

    /**
     * @see Log#w(String, String)
     */
    public static void w(String message) {
        Log.w(TAG, buildMessage(message));
    }

    /**
     * @see Log#wtf(String, String)
     */
    public static void wtf(String message) {
        Log.wtf(TAG, buildMessage(message));
    }

    private static final int JSON_INDENT = 4;

    public static void json(String json){
        if (TextUtils.isEmpty(json)) {
            e("Empty/Null json content");
            return;
        }
        try {
            if (json.startsWith("{")) {
                JSONObject jsonObject = new JSONObject(json);
                String message = jsonObject.toString(JSON_INDENT);
                e(message);
                return;
            }
            if (json.startsWith("[")) {
                JSONArray jsonArray = new JSONArray(json);
                String message = jsonArray.toString(JSON_INDENT);
                e(message);
            }
        } catch (JSONException e) {
            e(e.getCause().getMessage() + "\n" + json);
        }
    }

    /**
     * @see Log#println(int, String, String)
     */
    public static void println(String message) {
        Log.println(Log.INFO, TAG, message);
    }

    private static String buildMessage(String rawMessage) {
        StackTraceElement caller = new Throwable().getStackTrace()[2];
        String fullClassName = caller.getClassName();
        String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
        return className + "." + caller.getMethodName() + "(): " + rawMessage;
    }
}
