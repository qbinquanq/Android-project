package com.apptouch.binquanwang.shopmall;

import android.content.Context;
import android.widget.SimpleAdapter;

import java.util.List;
import java.util.Map;

/**
 * Created by Binquan Wang on 7/26/2016.
 */
public class MySimpleAdapter extends SimpleAdapter {
    public MySimpleAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
    }
}
