package test.chat.com.biz.model.callback;

/**
 * Created by 李艳东 on 2017/8/28  17:41
 */

public interface MyHttpCallBack {

    void onSuccess(String successs);

    void onError(int errorCode, String errorMsg);
}
