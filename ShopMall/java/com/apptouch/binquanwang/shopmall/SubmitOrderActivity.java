package com.apptouch.binquanwang.shopmall;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by Binquan Wang on 8/4/2016.
 */
public class SubmitOrderActivity extends AppCompatActivity{
    static FragmentTransaction fragmentTrans;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submit_order_activity);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Back");
        setSupportActionBar(toolbar);

        TextView view_title = (TextView) findViewById(R.id.toolbar_title);
        view_title.setText("Submit Order");

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        SubmitOrderActivityMainFragment mainFragment = new SubmitOrderActivityMainFragment();
        fragmentTransaction.add(R.id.fragment_container,mainFragment).commit();


    }
    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        fragmentTrans = getSupportFragmentManager().beginTransaction();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent backIntent = new Intent(SubmitOrderActivity.this,HomePage.class);
        startActivity(backIntent);
    }
    public static void navigateBack() {
        SubmitOrderActivitySubFragment newPage = new SubmitOrderActivitySubFragment();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        fragmentTrans.replace(R.id.fragment_container, newPage);
    //    fragmentTrans.addToBackStack(null);

        // Commit the transaction
        fragmentTrans.commit();
    }

}
