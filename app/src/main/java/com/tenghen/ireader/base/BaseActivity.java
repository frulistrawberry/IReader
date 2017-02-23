package com.tenghen.ireader.base;

import com.chengx.mvp.base.IPresent;
import com.chengx.mvp.base.XActivity;

/**
 * 作者：chengx
 * 日期：2017/2/22
 * 描述：
 */

public abstract   class  BaseActivity<T extends IPresent> extends XActivity<T> {


    @Override
    public void showProgress() {
        showDialog();
    }

    @Override
    public void hideProgress() {
        dismissDialog();
    }

    @Override
    public void showTip(String msg) {
        showToast(msg);
    }

}
