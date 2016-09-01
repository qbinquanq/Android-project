package com.apptouch.binquanwang.shopmall;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Binquan Wang on 7/20/2016.
 */
public class ProductCategory extends AppCompatActivity {
    static FragmentTransaction transaction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_category);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Back");
        setSupportActionBar(toolbar);

        TextView view_title = (TextView) findViewById(R.id.toolbar_title);
        view_title.setText("Category");


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
                        intent = new Intent(ProductCategory.this, HomePage.class);
                        bundle = new Bundle();
                        bundle.putInt("hint",1);
                        intent.putExtra("getTab",bundle);
                        startActivity(intent);
                        break;
                    case 2:

                        intent = new Intent(ProductCategory.this, HomePage.class);
                        bundle = new Bundle();
                        bundle.putInt("hint",2);
                        intent.putExtra("getTab",bundle);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(ProductCategory.this, HomePage.class);
                        bundle = new Bundle();
                        bundle.putInt("hint",3);
                        intent.putExtra("getTab",bundle);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(ProductCategory.this, HomePage.class);
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
                Intent intent = new Intent(ProductCategory.this, HomePage.class);
                startActivity(intent);
            }

        });

        ProductCategoryMainPage pCMP = new ProductCategoryMainPage();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, pCMP).commit();

    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        transaction = getSupportFragmentManager().beginTransaction();
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        transaction = getSupportFragmentManager().beginTransaction();
    }

    @Override
    public void onResume(){
        super.onResume();

    }
    public static void allProductDisplay() {
        ProductCategoryItems newPage = new ProductCategoryItems();


        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.fragment_container, newPage);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }
}
