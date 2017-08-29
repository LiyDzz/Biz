package test.chat.com.biz.view.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import test.chat.com.biz.App;

/**
 * Created by 李艳东 on 2017/8/28  17:50
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.activity = this;
        ButterKnife.bind(this);
        initView();
        initData();
        initListener();
    }

    protected abstract void initView();

    @Override
    protected void onResume() {
        super.onResume();
        //判断网络连接是否可用
        loadData();
    }

    /**
     * 为view加载数据
     *
     * @return
     */
    protected abstract void loadData();

    /**
     * 初始化监听
     *
     * @return
     */
    protected abstract void initListener();

    /**
     * 初始化数据
     *
     * @return
     */
    protected abstract void initData();

    /**
     * 返回该Activity布局的ID
     *
     * @return
     */
    protected abstract int getLayoutId();
}
