package com.liushiyu.developer.core.common.view.recyclerview;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.util.AttributeSet;

/**
 * created by liushuai on 2018/11/9
 */
public class MGridLayoutManager extends GridLayoutManager implements MScrollableLayoutManager {
    private boolean mCanScroll = true;

    public MGridLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public MGridLayoutManager(Context context, int spanCount) {
        super(context, spanCount);
    }

    public MGridLayoutManager(Context context, int spanCount, int orientation, boolean reverseLayout) {
        super(context, spanCount, orientation, reverseLayout);
    }

    @Override
    public void setScrollable(boolean scrollable) {
        this.mCanScroll = scrollable;
    }

    @Override
    public boolean canScrollHorizontally() {
        return mCanScroll && super.canScrollHorizontally();
    }

    @Override
    public boolean canScrollVertically() {
        return mCanScroll && super.canScrollVertically();
    }
}
