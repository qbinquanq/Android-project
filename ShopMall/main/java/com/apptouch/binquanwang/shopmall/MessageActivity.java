package com.apptouch.binquanwang.shopmall;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Binquan Wang on 8/4/2016.
 */
public class MessageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messages_activity);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView view_title = (TextView) findViewById(R.id.toolbar_title);
        view_title.setText("Messages Center");

        LinearLayout first_linearLayout = (LinearLayout)findViewById(R.id.winning_messages_linearlayout);
        LinearLayout second_linearLayout = (LinearLayout)findViewById(R.id.sending_messages_linearlayout);
        LinearLayout third_linearLayout = (LinearLayout)findViewById(R.id.client_messages_linearlayout);
        LinearLayout fourth_linearLayout = (LinearLayout)findViewById(R.id.system_messages_linearlayout);
        first_linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),"get",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
