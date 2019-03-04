package com.liushiyu.developer.core.common.view.recyclerview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/**
 * created by liushuai on 2018/11/9
 */
public class MRecyclerView extends RecyclerView implements OnItemTouchDetector.OnItemClickListener,
        OnItemTouchDetector.OnItemDoubleClickListener, OnItemTouchDetector.OnItemLongClickListener {
    public interface OnItemClickListener {
        void onItemClick(RecyclerView viewGroup, View view, int position);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(RecyclerView viewGroup, View view, int position);
    }

    public interface OnItemDoubleClickListener {
        void onItemDoubleClick(RecyclerView viewGroup, View view, int position);
    }

    private class ListenerInfo {
        public MRecyclerView.OnItemClickListener mOnItemClickListener;
        public MRecyclerView.OnItemLongClickListener mOnItemLongClickListener;
        public MRecyclerView.OnItemDoubleClickListener mOnItemDoubleClickListener;
    }

    private AdapterDataObserver emptyObserver = new AdapterDataObserver() {

        @Override
        public void onChanged() {
            Adapter<?> adapter = getAdapter();
            if (adapter != null && emptyView != null) {
                if (adapter.getItemCount() == 0) {
                    emptyView.setVisibility(View.VISIBLE);
                    MRecyclerView.this.setVisibility(View.GONE);
                } else {
                    emptyView.setVisibility(View.GONE);
                    MRecyclerView.this.setVisibility(View.VISIBLE);
                }
            }
        }
    };

    private View emptyView;
    private int touchSlop;

    private OnItemTouchDetector mOnItemTouchDetector;
    private MRecyclerView.ListenerInfo mListenerInfo;

    public MRecyclerView(Context context) {
        this(context, null);
    }

    public MRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initDefaultTouchListener();
        touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    /**
     * set empty view
     *
     * @param view empty view
     */
    public void setEmptyView(View view) {
        this.emptyView = view;
    }

    /**
     * 初始化默认的 ItemTouchListener
     */
    private void initDefaultTouchListener() {
        this.addOnItemTouchListener(mOnItemTouchDetector = new OnItemTouchDetector(this));
    }

    /**
     * 获取 ListenerInfo
     *
     * @return inner ListenerInfo
     */
    private MRecyclerView.ListenerInfo getListenerInfo() {
        if (mListenerInfo != null) {
            return mListenerInfo;
        }
        mListenerInfo = new MRecyclerView.ListenerInfo();
        return mListenerInfo;
    }

    @Override
    public void setAdapter(Adapter adapter) {
        super.setAdapter(adapter);

        if (adapter != null) {
            adapter.registerAdapterDataObserver(emptyObserver);
        }
        emptyObserver.onChanged();
    }

    @Override
    public void onItemClick(RecyclerView viewGroup, View view, int position) {
        if (getListenerInfo().mOnItemClickListener != null) {
            getListenerInfo().mOnItemClickListener.onItemClick(viewGroup, view, position);
        }
    }

    @Override
    public void onItemDoubleClick(RecyclerView viewGroup, View view, int position) {
        if (getListenerInfo().mOnItemDoubleClickListener != null) {
            getListenerInfo().mOnItemDoubleClickListener.onItemDoubleClick(viewGroup, view, position);
        }
    }

    @Override
    public void onItemLongClick(RecyclerView viewGroup, View view, int position) {
        if (getListenerInfo().mOnItemLongClickListener != null) {
            getListenerInfo().mOnItemLongClickListener.onItemLongClick(viewGroup, view, position);
        }
    }

    /**
     * set OnItemClickListener
     *
     * @param listener listener
     */
    public void setOnItemClickListener(MRecyclerView.OnItemClickListener listener) {
        if (mOnItemTouchDetector != null) {
            mOnItemTouchDetector.setOnItemClickListener(this);
        }
        getListenerInfo().mOnItemClickListener = listener;
    }

    /**
     * set OnItemDoubleClickListener
     *
     * @param listener listener
     */
    public void setOnItemDoubleClickListener(MRecyclerView.OnItemDoubleClickListener listener) {
        if (mOnItemTouchDetector != null) {
            mOnItemTouchDetector.setOnItemDoubleClickListener(this);
        }
        getListenerInfo().mOnItemDoubleClickListener = listener;
    }

    /**
     * set OnItemLongClickListener
     *
     * @param listener listener
     */
    public void setOnItemLongClickListener(MRecyclerView.OnItemLongClickListener listener) {
        if (mOnItemTouchDetector != null) {
            mOnItemTouchDetector.setOnItemLongClickListener(this);
        }
        getListenerInfo().mOnItemLongClickListener = listener;
    }

    private boolean mLoadingMore;
    private int mDy;
    private Runnable mLoadMore;

    public void setOnLoadMoreListener(Runnable loadMore) {
        this.mLoadMore = loadMore;
    }

    public void setLoadMore(boolean loadMore) {
        this.mLoadingMore = loadMore;
    }

    private float downY;

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                this.downY = e.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                float delta = e.getY() - this.downY;
                boolean isMove = Math.abs(delta) >= touchSlop;
                if (isMove) {
                    // pull up
                    if (delta < 0) {
                        mDy = (int) Math.abs(delta);
                    }
                }
                break;
        }
        return super.onTouchEvent(e);
    }

    @Override
    public void onScrolled(int dx, int dy) {
        super.onScrolled(dx, dy);
        mDy = dy;
        LayoutManager manager = getLayoutManager();
        int visibleItemCount = manager.getChildCount();
        int totalItemCount = manager.getItemCount();
        if (totalItemCount > 0 && visibleItemCount == totalItemCount && dy == 0) {
            mDy = 1;
            onScrollStateChanged(SCROLL_STATE_IDLE);
        }
    }

    @Override
    public void onScrollStateChanged(int state) {
        super.onScrollStateChanged(state);
        if (state == SCROLL_STATE_IDLE && mDy > 0 && !mLoadingMore) {
            LayoutManager manager = getLayoutManager();
            int position = Utils.findLastVisibleItemPosition(manager);
            int visibleItemCount = manager.getChildCount();
            int totalItemCount = manager.getItemCount();
            if (position > -1 && position == totalItemCount - 1) {
                mDy = 0;
                mLoadingMore = true;
                if (mLoadMore != null) {
                    mLoadMore.run();
                }
            }
        }
    }

    public int findFirstVisibleItemPosition() {
        LayoutManager manager = getLayoutManager();
        return Utils.findFirstVisibleItemPosition(manager);
    }
}
