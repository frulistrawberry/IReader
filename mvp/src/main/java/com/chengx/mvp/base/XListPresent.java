package com.chengx.mvp.base;

/**
 * 作者：chengx
 * 日期：2017/2/9
 * 描述：
 */

public abstract class XListPresent<V extends IListView> extends XPresent<V> implements IListPresent<V> {
    private int currentPage = 0;

    abstract protected void requestData();

    @Override
    public void refresh() {
        currentPage = 0;
        requestData();
    }

    @Override
    public void loadMore() {
        currentPage++;
        requestData();
    }
}
