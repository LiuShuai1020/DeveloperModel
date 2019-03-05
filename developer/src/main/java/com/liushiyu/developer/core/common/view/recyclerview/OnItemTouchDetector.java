package com.liushiyu.developer.core.common.view.recyclerview;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/**
 * created by liushuai on 2018/11/9
 */
public class OnItemTouchDetector implements RecyclerView.OnItemTouchListener, Handler.Callback {
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
        public OnItemClickListener mOnItemClickListener;
        public OnItemLongClickListener mOnItemLongClickListener;
        public OnItemDoubleClickListener mOnItemDoubleClickListener;
    }

    private static final boolean DEBUG = true;
    private static final String TAG = "wcwcwc";

    /**
     * Defines the minimum duration in milliseconds between the first tap's up event and
     * the second tap's down event for an interaction to be considered a
     * double-tap.
     */
    private static final int DOUBLE_TAP_MIN_TIME = 40;
    private static final int DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();
    private static final int LONGPRESS_TIMEOUT = ViewConfiguration.getLongPressTimeout();
    private static final int TAP_TIMEOUT = ViewConfiguration.getTapTimeout();

    private static final int DOUBLE_TAP = 1;
    private static final int LONG_PRESS = 2;
    private static final int TAP = 3;

    private Handler mHandler;
    private MotionEvent mCurrentDownEvent;
    private MotionEvent mPreviousUpEvent;

    private boolean mInLongPress;
    private boolean mIsLongpressEnabled;
    private boolean mIsDoubleTapping;
    private boolean mAlwaysInTapRegion;
    private boolean mAlwaysInBiggerTapRegion;

    private int mDoubleTapSlopSquare;
    private int mTouchSlopSquare;

    private float mDownFocusX;
    private float mDownFocusY;

    private ListenerInfo mListenerInfo;
    protected RecyclerView mRecyclerView;

    @Override
    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case TAP: {
                onClick(mCurrentDownEvent);
            }
            break;

            case DOUBLE_TAP: {
                onDoubleClick(mCurrentDownEvent);
            }
            break;

            case LONG_PRESS: {
                mHandler.removeMessages(TAP);
                mInLongPress = true;
                onLongClick(mCurrentDownEvent);
            }
            break;
        }
        return false;
    }

    public OnItemTouchDetector(RecyclerView recyclerView) {
        this(recyclerView, null);
    }

    public OnItemTouchDetector(RecyclerView recyclerView, Handler handler) {
        this.mRecyclerView = recyclerView;
        if (handler != null) {
            mHandler = new Handler(handler.getLooper(), this);
        } else {
            mHandler = new Handler(this);
        }

        Context context = recyclerView.getContext();
        ViewConfiguration configuration = ViewConfiguration.get(context);

        int touchSlop = configuration.getScaledTouchSlop();
        int doubleTapSlop = configuration.getScaledDoubleTapSlop();

        mIsLongpressEnabled = true;

        mTouchSlopSquare = touchSlop * touchSlop;
        mDoubleTapSlopSquare = doubleTapSlop * doubleTapSlop;
    }

    private ListenerInfo getListenerInfo() {
        if (mListenerInfo != null) {
            return mListenerInfo;
        }
        mListenerInfo = new ListenerInfo();
        return mListenerInfo;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        getListenerInfo().mOnItemClickListener = listener;
    }

    public void setOnItemDoubleClickListener(OnItemDoubleClickListener listener) {
        getListenerInfo().mOnItemDoubleClickListener = listener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener longClickListener) {
        getListenerInfo().mOnItemLongClickListener = longClickListener;
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

        switch (e.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN: {

                mDownFocusX = e.getX();
                mDownFocusY = e.getY();

                if (mIsLongpressEnabled) {
                    mHandler.removeMessages(LONG_PRESS);
                    mHandler.sendEmptyMessageDelayed(LONG_PRESS, LONGPRESS_TIMEOUT);
                }

                mInLongPress = false;
                mAlwaysInTapRegion = true;
                mAlwaysInBiggerTapRegion = true;

                boolean hasTap = mHandler.hasMessages(TAP);
                if (hasTap) {
                    mHandler.removeMessages(TAP);
                }
                if ((mCurrentDownEvent != null) && (mPreviousUpEvent != null) && hasTap &&
                        isConsideredDoubleTap(mCurrentDownEvent, mPreviousUpEvent, e)) {
                    mIsDoubleTapping = true;
                }
                if (mCurrentDownEvent != null) {
                    mCurrentDownEvent.recycle();
                }
                mCurrentDownEvent = MotionEvent.obtain(e);
            }
            break;

            case MotionEvent.ACTION_MOVE: {
                if (mInLongPress) {
                    break;
                }

                if (mAlwaysInTapRegion) {
                    final int deltaX = (int) (e.getX() - mDownFocusX);
                    final int deltaY = (int) (e.getY() - mDownFocusY);
                    int distance = (deltaX * deltaX) + (deltaY * deltaY);
                    if (distance > mTouchSlopSquare) {
                        mHandler.removeMessages(TAP);
                        mHandler.removeMessages(LONG_PRESS);
                        mAlwaysInTapRegion = false;
                    }
                    if (distance > mDoubleTapSlopSquare) {
                        mAlwaysInBiggerTapRegion = false;
                    }
                }
            }
            break;

            case MotionEvent.ACTION_UP: {
                if (mIsDoubleTapping) {
                    mHandler.sendEmptyMessage(DOUBLE_TAP);
                    mIsDoubleTapping = false;
                    mHandler.removeMessages(LONG_PRESS);
                } else {
                    if (mAlwaysInTapRegion) {
                        if (getListenerInfo().mOnItemDoubleClickListener == null) {
                            mHandler.sendEmptyMessage(TAP);
                        } else {
                            mHandler.sendEmptyMessageDelayed(TAP, DOUBLE_TAP_TIMEOUT);
                        }
                    }
                }

                if (mInLongPress) {
                    mInLongPress = false;
                    mHandler.removeMessages(TAP);
                    mHandler.removeMessages(LONG_PRESS);
                    break;
                }

                if (mPreviousUpEvent != null) {
                    mPreviousUpEvent.recycle();
                }
                mPreviousUpEvent = MotionEvent.obtain(e);

                mHandler.removeMessages(LONG_PRESS);
            }
            break;

            case MotionEvent.ACTION_CANCEL: {
                clearEvent();
            }
            break;
        }

        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    }

    /**
     * Inner click delegate
     *
     * @param event current MotionEvent
     */
    protected void onClick(MotionEvent event) {
        if (getListenerInfo().mOnItemClickListener != null) {
            View view = getChildViewUnder(event);
            if (view == null) {
                return;
            }
            int position = mRecyclerView.getChildAdapterPosition(view);
            //return if position is NO_POSITION
            if (position == RecyclerView.NO_POSITION) {
                return;
            }
            getListenerInfo().mOnItemClickListener.onItemClick(mRecyclerView, view, position);
        }
    }

    /**
     * Inner double click delegate
     *
     * @param event current MotionEvent
     */
    protected void onDoubleClick(MotionEvent event) {
        if (getListenerInfo().mOnItemDoubleClickListener != null) {
            View view = getChildViewUnder(event);
            if (view == null) {
                return;
            }
            int position = mRecyclerView.getChildAdapterPosition(view);
            getListenerInfo().mOnItemDoubleClickListener.onItemDoubleClick(mRecyclerView, view, position);
        }
    }

    /**
     * Inner long click delegate
     *
     * @param event current MotionEvent
     */
    protected void onLongClick(MotionEvent event) {
        if (getListenerInfo().mOnItemLongClickListener != null) {
            View view = getChildViewUnder(event);
            if (view == null) {
                return;
            }
            int position = mRecyclerView.getChildAdapterPosition(view);
            getListenerInfo().mOnItemLongClickListener.onItemLongClick(mRecyclerView, view, position);
        }
    }

    /**
     * 根据当前坐标获取 item view
     *
     * @param e MotionEvent
     * @return item view
     */
    @Nullable
    protected View getChildViewUnder(MotionEvent e) {
        return mRecyclerView.findChildViewUnder(e.getX(), e.getY());
    }

    private boolean isConsideredDoubleTap(MotionEvent firstDown, MotionEvent firstUp,
                                          MotionEvent secondDown) {
        if (!mAlwaysInBiggerTapRegion) {
            return false;
        }

        final long deltaTime = secondDown.getEventTime() - firstUp.getEventTime();
        if (deltaTime > DOUBLE_TAP_TIMEOUT || deltaTime < DOUBLE_TAP_MIN_TIME) {
            return false;
        }

        int deltaX = (int) firstDown.getX() - (int) secondDown.getX();
        int deltaY = (int) firstDown.getY() - (int) secondDown.getY();
        return (deltaX * deltaX + deltaY * deltaY < mDoubleTapSlopSquare);
    }

    /**
     * clear
     */
    private void clearEvent() {
        mHandler.removeMessages(DOUBLE_TAP);
        mHandler.removeMessages(TAP);
        mHandler.removeMessages(LONG_PRESS);
        mInLongPress = false;
        mAlwaysInTapRegion = false;
        mAlwaysInBiggerTapRegion = false;
        mIsDoubleTapping = false;
    }
}
