package test.chat.com.biz;

import android.app.Application;

import test.chat.com.biz.view.base.BaseActivity;
import test.chat.com.biz.view.base.BaseFragment;

/**
 * Created by 李艳东 on 2017/8/28  17:56
 */

public class App extends Application {
    public static BaseActivity activity;
    //当前显示的fragment
    public static BaseFragment fragment;
}
