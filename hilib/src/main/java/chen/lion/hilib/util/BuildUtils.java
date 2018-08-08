package chen.lion.hilib.util;

import android.content.Context;

import com.cosfund.library.BuildConfig;

/**
 * 作者 by Chenxiu on 2015/12/29 0029.
 * 描述：
 * Build工具类
 */
public class BuildUtils {

    private BuildUtils() {
    }

    public static boolean isDebug() {
        return BuildConfig.DEBUG;
    }

    public static void throwOrPrint(Throwable throwable) {
        if (BuildConfig.DEBUG) {
            throwRuntimeException(throwable);
        } else {
            throwable.printStackTrace();
        }
    }

    private static void throwRuntimeException(Throwable throwable) {
        if (throwable instanceof RuntimeException) {
            throw (RuntimeException) throwable;
        } else {
            throw new RuntimeException(throwable);
        }
    }

    // NOTE: If in productive build, this method prints stack trace before reporting.
    public static void throwOrPrintAndReport(Throwable throwable, Context context) {
        if (BuildConfig.DEBUG) {
            throwRuntimeException(throwable);
        } else {
            throwable.printStackTrace();
        }
    }
}
