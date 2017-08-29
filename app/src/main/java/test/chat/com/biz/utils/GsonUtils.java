package test.chat.com.biz.utils;

import com.google.gson.Gson;

/**
 * Created by 李艳东 on 2017/8/28  16:56
 */

public class GsonUtils {
    public static Object FromJson(String content, Class o) {
        Gson gson = new Gson();
        Object o1 = null;
        try {
            o1 = gson.fromJson(content, o);

        } catch (IllegalStateException i) {

        }
        return o1;
    }
}
