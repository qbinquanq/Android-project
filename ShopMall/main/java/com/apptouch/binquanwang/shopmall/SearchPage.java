package com.apptouch.binquanwang.shopmall;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Binquan Wang on 7/18/2016.
 */
public class SearchPage extends AppCompatActivity{
    EditText searchBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_page);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Back");
        setSupportActionBar(toolbar);

        TextView view_title = (TextView) findViewById(R.id.toolbar_title);
        view_title.setText("Search");

      //  searchBar = (EditText) findViewById(R.id.search_bar);
        Button charge = (Button)findViewById(R.id.charge);      // charge button
        charge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chargeActivity = new Intent(SearchPage.this,ChargeActivity.class);
                startActivity(chargeActivity);
            }
        });

        ImageView shopping_cart = (ImageView)findViewById(R.id.shopping_cart); // Shopping Cart
        shopping_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ShoppingActivity = new Intent(SearchPage.this, ShoppingCartActivity.class);
                startActivity(ShoppingActivity);
            }
        });

        ImageView messages = (ImageView)findViewById(R.id.messages); // Messages
        messages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent messagesActivity = new Intent(SearchPage.this,MessageActivity.class);
                startActivity(messagesActivity);
            }
        });


        TabLayout tablayout = (TabLayout) findViewById(R.id.tablayout);

        for(int i = 0; i< 5; i++){
            View view = LayoutInflater.from(this).inflate(R.layout.tab_layout,null);
            ImageView tabicon = (ImageView) view.findViewById(R.id.tabicon);
            TextView tabname = (TextView)view.findViewById(R.id.tabname);

            switch(i){
                case 0:
                    tabicon.setImageResource(R.drawable.diamond);
                    tabname.setText(getResources().getString(R.string.loot));
                    break;
                case 1:
                    tabicon.setImageResource(R.drawable.bell);
                    tabname.setText(getResources().getString(R.string.new_announce));
                    break;
                case 2:
                    tabicon.setImageResource(R.drawable.list);
                    tabname.setText(getResources().getString(R.string.list));
                    break;
                case 3:
                    tabicon.setImageResource(R.drawable.rank);
                    tabname.setText(getResources().getString(R.string.rank_list));
                    break;
                case 4:
                    tabicon.setImageResource(R.drawable.me);
                    tabname.setText(getResources().getString(R.string.me));
                    break;
            }
            TabLayout.Tab tab = tablayout.newTab();
            tab.setCustomView(view);
            tablayout.addTab(tab);

        }
        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Intent intent;
                Bundle bundle;
                switch (tab.getPosition()) {
                    case 1:
                        intent = new Intent(SearchPage.this, HomePage.class);
                        bundle = new Bundle();
                        bundle.putInt("hint",1);
                        intent.putExtra("getTab",bundle);
                        startActivity(intent);
                        break;
                    case 2:

                        intent = new Intent(SearchPage.this, HomePage.class);
                        bundle = new Bundle();
                        bundle.putInt("hint",2);
                        intent.putExtra("getTab",bundle);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(SearchPage.this, HomePage.class);
                        bundle = new Bundle();
                        bundle.putInt("hint",3);
                        intent.putExtra("getTab",bundle);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(SearchPage.this, HomePage.class);
                        bundle = new Bundle();
                        bundle.putInt("hint",4);
                        intent.putExtra("getTab",bundle);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Intent intent = new Intent(SearchPage.this, HomePage.class);
                startActivity(intent);
            }

        });

       /* TabLayout.Tab tab1 = tablayout.newTab();
        tab1.setCustomView(view);
        tablayout.addTab(tab1);

        TabLayout.Tab tab2 = tablayout.newTab().setText(getResources().getString(R.string.new_announce));
        tab2.setIcon(R.drawable.bell);
        tablayout.addTab(tab2);

        TabLayout.Tab tab3 = tablayout.newTab().setText(getResources().getString(R.string.list));
        tab3.setIcon(R.drawable.list);
        tablayout.addTab(tab3);

        TabLayout.Tab tab4 = tablayout.newTab().setText(getResources().getString(R.string.rank_list));
        tab4.setIcon(R.drawable.rank);
        tablayout.addTab(tab4);

        TabLayout.Tab tab5 = tablayout.newTab().setText(getResources().getString(R.string.me));
        tab5.setIcon(R.drawable.me);
        tablayout.addTab(tab5);*/

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

}
