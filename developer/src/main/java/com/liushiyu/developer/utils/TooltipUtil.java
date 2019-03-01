package com.liushiyu.developer.utils;

import android.annotation.SuppressLint;
import android.content.Context;

import com.liushiyu.tooltip.Tooltip;

public class TooltipUtil {

    @SuppressLint("StaticFieldLeak")
    private static Context context;

    private TooltipUtil() {
    }

    public static void init(Context context) {
        TooltipUtil.context = context;
    }

    public static void toast(String toastString) {
        Tooltip.toast().show(TooltipUtil.context, toastString);
    }
}
