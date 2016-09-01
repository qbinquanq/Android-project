package com.apptouch.binquanwang.shopmall;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomePage extends AppCompatActivity {

 //   Handler handler;
    static ViewPager content;
    static List<Map<String, Object>> DataListPass = new ArrayList<>();
    static Map<String,Object> DataMapPass;
    static TextView view_title;
  //  static FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        view_title= (TextView) findViewById(R.id.toolbar_title); // title

        content = (ViewPager)findViewById(R.id.viewpager_center_content);
        TabLayout  tabLayout = (TabLayout)findViewById(R.id.tablayout);

        content.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            int[] tabNameList = {R.string.loot, R.string.new_announce,R.string.list, R.string.rank_list, R.string.me};

            @Override
            public Fragment getItem(int position) {
                Fragment newFragment = null;

                switch (position){
                    case 0:
                        newFragment = LootFragment.createInstance(getPageTitle(position).toString());
                        break;
                    case 1:
                        newFragment = NewAnnounceFragment.createInstance(getPageTitle(position).toString());
                        break;
                    case 2:
                        newFragment = ListFragment.createInstance(getPageTitle(position).toString());
                        break;
                    case 3:
                        newFragment = RankListFragment.createInstance(getPageTitle(position).toString());
                        break;
                    case 4:
                        newFragment = MeFragment.createInstance(getPageTitle(position).toString());
                        break;
                    default: return null;
                }

                return newFragment;
            }

            @Override
            public int getCount() {
                return tabNameList.length;
            }
            @Override
            public CharSequence getPageTitle(int position) {
                return HomePage.this.getResources().getString(tabNameList[position]) ;

            }

            @Override
            public int getItemPosition(Object object) {
                return POSITION_NONE;
            }
        });

        //when another activity nagigates back to homepage, check which page it is going to display
        if(this.getIntent().getBundleExtra("getTab")!= null){
            if(this.getIntent().getBundleExtra("getTab").getInt("hint") ==1)
                content.setCurrentItem(1);
            else if(this.getIntent().getBundleExtra("getTab").getInt("hint") ==2)
                content.setCurrentItem(2);
            else if(this.getIntent().getBundleExtra("getTab").getInt("hint") ==3)
                content.setCurrentItem(3);
            else content.setCurrentItem(4);
        }
        tabLayout.setupWithViewPager(content);

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
            tabLayout.getTabAt(i).setCustomView(view);
        }


    /*  viewpager = (ViewPager)findViewById(R.id.viewpager_image_slider);
        viewpager.setAdapter(new PagerAdapter() {
            int[] pictures ={R.drawable.car1, R.drawable.car2, R.drawable.car3,R.drawable.plane1};

            @Override
            public int getCount() {
                return Integer.MAX_VALUE;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View)object);
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView image = new ImageView(HomePage.this);
                image.setBackgroundResource(pictures[position%3]);

                ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                image.setLayoutParams(params);
                container.addView(image);
                return image;
            }
        });
        viewpager.setOffscreenPageLimit(3);
        final int num = Integer.MAX_VALUE/2;
        viewpager.setCurrentItem(num - num%3);

        */

        /* Frame anime code
        ImageView imageview = (ImageView)findViewById(R.id.slider_image);
        AnimationDrawable ad = (AnimationDrawable) imageview.getBackground();

        ad.start(); */
    }




/*    @Override
    public void onBackPressed() {
        super.onBackPressed();
        transaction = getSupportFragmentManager().beginTransaction();
    }
    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        transaction = getSupportFragmentManager().beginTransaction();
    }

    public static void allProductDisplay() {
        ProductCategoryItems newPage = new ProductCategoryItems();


        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.testframelayout, newPage);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }
    */

    @Override
    protected void onResume() {
        super.onResume();
    //    handler = new Handler();
    //    handler.postDelayed(imageSlider,3000);

        //    handler = new Handler();
    //   handler.postDelayed(imageSlider,3000);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
