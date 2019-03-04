package com.liushiyu.developer.core.common.view.recyclerview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;

/**
 * created by liushuai on 2018/11/9
 */
public class MLinearLayoutManager extends LinearLayoutManager implements MScrollableLayoutManager {
    private boolean mCanScroll = true;

    public MLinearLayoutManager(Context context) {
        super(context);
    }

    public MLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public MLinearLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
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
