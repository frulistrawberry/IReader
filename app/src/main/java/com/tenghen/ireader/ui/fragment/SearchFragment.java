package com.tenghen.ireader.ui.fragment;

import com.tenghen.ireader.R;
import com.tenghen.ireader.base.BaseListFragment;
import com.tenghen.ireader.ui.present.FeaturedPresent;
import com.tenghen.ireader.ui.present.SearchPresent;

/**
 * 作者：chengx
 * 日期：2017/2/23
 * 描述：
 */

public class SearchFragment extends BaseListFragment<SearchPresent> {
    @Override
    public void initToolBar() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_common_list;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initViews() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public SearchPresent newPresent() {
        return new SearchPresent();
    }
}
