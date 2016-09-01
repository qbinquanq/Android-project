package com.apptouch.binquanwang.shopmall;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

/**
 * Created by Binquan Wang on 7/20/2016.
 */
public class TimeDash extends AppCompatActivity{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_dash);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Back");
        setSupportActionBar(toolbar);

        TextView view_title = (TextView) findViewById(R.id.toolbar_title);
        view_title.setText("TimeDash");
    }
}
