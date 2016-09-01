package com.apptouch.binquanwang.shopmall;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Binquan Wang on 7/26/2016.
 */
public class ChargeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.charge_activity);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Back");
        setSupportActionBar(toolbar);

        TextView view_title = (TextView) findViewById(R.id.toolbar_title);
        view_title.setText("Charge");

        GridView gridView = (GridView)findViewById(R.id.charge_activity_gridview);

        String[] txt = {"30","50","100","150","200","500","1000","other"};
        List<Map<String, String>> dataList = new ArrayList<>();
        for(int i = 0; i< txt.length;i++){
            Map<String, String> dataMap = new HashMap<>();
            dataMap.put("money",txt[i]);
            dataList.add(dataMap);
        }
        final ChargeActivityGridViewAdapter mySimpleAdapter = new ChargeActivityGridViewAdapter(getBaseContext(),
                dataList,R.layout.charge_activity_gridview_item_layout,
                new String[]{"money"},new int[]{R.id.charge_activity_gridview_button});
        gridView.setAdapter(mySimpleAdapter);

        final RadioButton weChatButton = (RadioButton)findViewById(R.id.radiobutton_wechat);
        final RadioButton aliPayButton = (RadioButton)findViewById(R.id.radiobutton_alipay);

        weChatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aliPayButton.setChecked(false);
            }
        });
        aliPayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weChatButton.setChecked(false);
            }
        });




        Button charge_immediately = (Button)findViewById(R.id.charge_activity_charge_immediately);
        charge_immediately.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mySimpleAdapter.selectPosition == -1 || !(weChatButton.isChecked() || aliPayButton.isChecked())){
                    Toast.makeText(ChargeActivity.this,"please choose amount or select way you want to pay",Toast.LENGTH_SHORT).show();

                }
                else Toast.makeText(ChargeActivity.this,String.valueOf(mySimpleAdapter.selectPosition),Toast.LENGTH_SHORT).show();
            }
        });


    }
}
