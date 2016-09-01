package com.apptouch.binquanwang.shopmall;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Binquan Wang on 8/10/2016.
 */
public class WinningHistory extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.winninghistory_activity);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Back");
        setSupportActionBar(toolbar);

        TextView view_title = (TextView) findViewById(R.id.toolbar_title);
        view_title.setText("Winning History");

        View view = LayoutInflater.from(this).inflate(R.layout.winninghistory_activity,null);

        BotToolbarClickAction botToolbarClickAction = new BotToolbarClickAction(view,this,getBaseContext());
        botToolbarClickAction.clickAction();
    }
}
