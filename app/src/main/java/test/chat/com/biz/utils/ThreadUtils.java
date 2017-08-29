package test.chat.com.biz.utils;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by 李艳东 on 2017/8/28  17:07
 */

public class ThreadUtils {
    private static Handler sHandler = new Handler(Looper.getMainLooper());

    public static void runOnMainThread(Runnable task) {
        sHandler.post(task);
    }

    public static void runSbutThread(Runnable task) {
        new Thread(task);
    }
}
