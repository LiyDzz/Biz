package test.chat.com.biz.model.http;

import java.util.Map;

import test.chat.com.biz.model.callback.MyHttpCallBack;

/**
 * Created by 李艳东 on 2017/8/28  17:48
 */

public interface IHttp {
    void post(String url, Map<String, String> map, MyHttpCallBack callBack);

    void get(String url, Map<String, String> map, MyHttpCallBack callBack);
}
