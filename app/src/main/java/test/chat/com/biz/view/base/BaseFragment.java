package test.chat.com.biz.view.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.sql.Array;

import butterknife.ButterKnife;
import test.chat.com.biz.App;

/**
 * Created by 李艳东 on 2017/8/28  18:04
 */

public abstract class BaseFragment extends Fragment {

    private Bundle params;
    private boolean isFirst = false;
    public Array getArguments;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        App.fragment = this;
        if (getLayoutId() != 0) {
            return inflater.inflate(getLayoutId(), container, false);
        } else {
            Log.d("BaseFragment", "布局Id不能为0");
        }
        return null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        ButterKnife.bind(this, view);
        isFirst = true;
        initView(view);
        initListener();
        initData();
    }

    /**
     * 获取布局ID
     *
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化控件
     *
     * @param view
     */
    protected abstract void initView(View view);

    /**
     * 设置监听
     */
    protected abstract void initListener();

    /**
     * 加载数据
     */
    protected abstract void loadData();

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            //当前Fragment被隐藏
            onHidden();
        } else {
            //当前Fragment显示
            onShow();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            //相当于Fragment的onResume
            onShow();
        } else {
            //相当于Fragment的onPause
            onHidden();
        }
    }


    public void onShow() {

    }

    public void onHidden() {

    }

    public Bundle getParams() {
        return params;
    }

    /**
     * 设置传过来的参数
     *
     * @param params
     */
    public void setParams(Bundle params) {
        this.params = params;
    }

    //当页面可见时加载数据，仅仅加载一次
    @Override
    public void onResume() {
        super.onResume();
        if (isFirst) {
            loadData();
            isFirst = false;
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);

    }
}
