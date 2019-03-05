package com.liushiyu.developer.core.common.view.recyclerview;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * created by liushuai on 2018/11/9
 */
public class Utils {
    public static int findLastVisibleItemPosition(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager != null) {

            if (layoutManager instanceof LinearLayoutManager) {
                return ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
            }

            if (layoutManager instanceof GridLayoutManager) {
                return ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
            }

        }
        return RecyclerView.NO_POSITION;
    }

    public static int findFirstCompletelyVisibleItemPosition(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager != null) {

            if (layoutManager instanceof LinearLayoutManager) {
                return ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
            }

            if (layoutManager instanceof GridLayoutManager) {
                return ((GridLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
            }

        }
        return RecyclerView.NO_POSITION;
    }

    public static int findFirstVisibleItemPosition(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager != null) {

            if (layoutManager instanceof LinearLayoutManager) {
                return ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
            }

            if (layoutManager instanceof GridLayoutManager) {
                return ((GridLayoutManager) layoutManager).findFirstVisibleItemPosition();
            }

        }
        return RecyclerView.NO_POSITION;
    }
}
