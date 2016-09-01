package com.apptouch.binquanwang.shopmall;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Binquan Wang on 7/28/2016.
 */
public class ShoppingCartActivity extends AppCompatActivity implements NumberChangeEvent{
    MyShoppingCartSimpleAdapter ShoppingCartGridViewAdapter;
    static Boolean ItemCheckDeterminant = false;
    static int totalItem = 0;
    LinearLayout linearLayout;
    TextView total_item_count;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_cart_activity);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Back");
        setSupportActionBar(toolbar);

        TextView view_title = (TextView) findViewById(R.id.toolbar_title);
        view_title.setText("Shopping Cart");


        Button chargeButton = (Button) findViewById(R.id.charge);  // Open Charge Activity
        chargeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShoppingCartActivity.this, ChargeActivity.class);
                startActivity(intent);
            }
        });

        ImageView messages = (ImageView)findViewById(R.id.messages); // Open Message Activity
        messages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShoppingCartActivity.this, MessageActivity.class);
                startActivity(intent);
            }
        });



        linearLayout = (LinearLayout)findViewById(R.id.all_select_linearlayout);
        total_item_count = (TextView)findViewById(R.id.total_item_count);
        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                int pos = (Integer) msg.obj;
                HomePage.DataListPass.remove(pos);
                ShoppingCartGridViewAdapter.notifyDataSetChanged();
                onChanged();
            }
        };


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
                        intent = new Intent(ShoppingCartActivity.this, HomePage.class);
                        bundle = new Bundle();
                        bundle.putInt("hint",1);
                        intent.putExtra("getTab",bundle);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(ShoppingCartActivity.this, HomePage.class);
                        bundle = new Bundle();
                        bundle.putInt("hint",2);
                        intent.putExtra("getTab",bundle);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(ShoppingCartActivity.this, HomePage.class);
                        bundle = new Bundle();
                        bundle.putInt("hint",3);
                        intent.putExtra("getTab",bundle);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(ShoppingCartActivity.this, HomePage.class);
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
                Intent intent = new Intent(ShoppingCartActivity.this, HomePage.class);
                startActivity(intent);
            }
        });

        final SwipeMenuListView shoppingCarGridView = (SwipeMenuListView)findViewById(R.id.shopping_cart_listview);


        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {

             /*   SwipeMenuItem openItem = new SwipeMenuItem(
                        getApplicationContext());
                openItem.setBackground(new ColorDrawable(Color.LTGRAY));
                openItem.setWidth(dp2px(60));
                openItem.setTitle("Top");
                openItem.setTitleSize(15);
                openItem.setTitleColor(Color.WHITE);
                menu.addMenuItem(openItem);

                SwipeMenuItem NoopenItem = new SwipeMenuItem(
                        getApplicationContext());
                NoopenItem.setBackground(new ColorDrawable(Color.CYAN));
                NoopenItem.setWidth(dp2px(90));
                NoopenItem.setTitle("Unread");
                NoopenItem.setTitleSize(15);
                NoopenItem.setTitleColor(Color.WHITE);
                menu.addMenuItem(NoopenItem); */

                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                deleteItem.setBackground(new ColorDrawable(Color.RED));
                deleteItem.setWidth(dp2px(60));
                deleteItem.setTitle("Delete");
                deleteItem.setTitleSize(15);
                deleteItem.setTitleColor(Color.WHITE);
                menu.addMenuItem(deleteItem);
            }
        };
        shoppingCarGridView.setMenuCreator(creator);
        shoppingCarGridView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {

                shoppingCarGridView.smoothCloseMenu();
                Message msg = handler.obtainMessage();
                msg.obj = position;
                handler.sendMessageDelayed(msg, 500);
                return false;
            }
        });



        //  int width = shoppingCarGridView.getRightViewWidth();
        ShoppingCartGridViewAdapter = new MyShoppingCartSimpleAdapter(this,
                HomePage.DataListPass,
              //  width,
                R.layout.shopping_cart_activity_gridview_item,
                new String[]{"ImageGetter","TxtGetter","ItemCount"},
                new int[]{R.id.shopping_cart_gridview_image,R.id.shopping_cart_gridview_text,R.id.count,
                }
        );
        shoppingCarGridView.setAdapter(ShoppingCartGridViewAdapter);





     //   final LinearLayout linearLayout = (LinearLayout)findViewById(R.id.all_select_linearlayout);

        if(HomePage.DataListPass.isEmpty())
            linearLayout.setVisibility(View.GONE);
        else linearLayout.setVisibility(View.VISIBLE);

        final CheckBox allCheck = (CheckBox)findViewById(R.id.all_check);
     //   final TextView total_item_count = (TextView)findViewById(R.id.total_item_count);

        if(ItemCheckDeterminant) {
            // check all_check button is selected or not when the activity is going back from previous activity
            allCheck.setChecked(true);
        }
        total_item_count.setText(String.valueOf(totalItem));

        allCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    ItemCheckDeterminant= true;
                    ShoppingCartGridViewAdapter.allChecked();
                }
                else{

                    ItemCheckDeterminant = false;
                    ShoppingCartGridViewAdapter.allUnchecked();

                }
            }
        });

        ShoppingCartGridViewAdapter.setListener(new NumberChangeEvent() {
            // when the item is checked, get it's item counts and add into R.id.total_item_count to display how many items are selected
            @Override
            public void onChanged() {
                int count = 0;
                Boolean bool = true;
                if(HomePage.DataListPass.isEmpty()){
                    linearLayout.setVisibility(View.GONE);
                }
                else{
                    for(int i = 0; i<HomePage.DataListPass.size();i++){
                        Map<String, Object> newMap = HomePage.DataListPass.get(i);
                        if(newMap.get("CheckBox")==bool){
                            int temp = Integer.parseInt(newMap.get("ItemCount").toString());
                            count = count+temp;
                        }
                    }
                total_item_count.setText(String.valueOf(count));
                totalItem = count;
                }
            }
        });

        LinearLayout relativeLayout = (LinearLayout)findViewById(R.id.imageview_empty);
    //    ImageView imageView = (ImageView)findViewById(R.id.imageview_empty);
        shoppingCarGridView.setEmptyView(relativeLayout);

        Button submit = (Button)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SubmitOrderActivity = new Intent(ShoppingCartActivity.this, SubmitOrderActivity.class);
                startActivity(SubmitOrderActivity);
            }
        });


    }


    @Override
    public void onChanged() {
        int count = 0;
        Boolean bool = true;
        if(HomePage.DataListPass.isEmpty()){
            linearLayout.setVisibility(View.GONE);
        }
        else {
            for (int i = 0; i < HomePage.DataListPass.size(); i++) {
                Map<String, Object> newMap = HomePage.DataListPass.get(i);
                if (newMap.get("CheckBox") == bool) {
                    int temp = Integer.parseInt(newMap.get("ItemCount").toString());
                    count = count + temp;
                }
            }
            total_item_count.setText(String.valueOf(count));
            totalItem = count;
        }
    }
    private int dp2px(float dipValue) {
        final float scale = this.getResources().getDisplayMetrics().density;

        return (int) (dipValue * scale + 0.5f);
    }
}
