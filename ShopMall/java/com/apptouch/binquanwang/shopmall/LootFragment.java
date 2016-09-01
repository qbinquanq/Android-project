package com.apptouch.binquanwang.shopmall;

import android.content.Intent;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Binquan Wang on 7/13/2016.
 */
public class LootFragment extends Fragment {
    private View viewImage;
    private ViewPager viewImageSlide;
    private GridView gridView;
    Handler handler;
    Handler handlerOfGridView;
    private CustomGridView secondGridView;
    MySimpleAdapter MAdapter;
    MyAdapter secondGridViewAdapter;
    TextView display_all;
    List<Map<String,Object>> items;
    List<Map<String,Object>> secondGridViewItems;

    int[] secondGridViewImages={R.drawable.hundred_dollar_card,
            R.drawable.thirty_dollar_card,R.drawable.hundred_dollar_card};

    String[] secondGridViewTxt = {"$100 Charge card","$30 Charge card","$100 Charge card"};


    List<Map<String, Object>> data;
    Map<String, Object> itemMap;

    //  private Context context;


    public static LootFragment createInstance(String data){

        Bundle args = new Bundle();
        args.putString("Position", data);
        LootFragment fragment = new LootFragment();
        fragment.setArguments(args);
        return fragment;

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        viewImage = inflater.inflate(R.layout.loot_treasure,container,false);

        return viewImage;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {


        BotToolbarClickAction botToolbarClickAction = new BotToolbarClickAction(view, getActivity(),getContext());
        botToolbarClickAction.clickAction();

        final EditText searchBar = (EditText) view.findViewById(R.id.search);
        searchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SearchPage.class);
                startActivity(intent);
            }
        });
        viewImageSlide = (ViewPager) view.findViewById(R.id.viewpager_image_slider);
        gridView = (GridView) view.findViewById(R.id.gridview_five_icons);
        secondGridView = (CustomGridView) view.findViewById(R.id.second_gridview);

        // image is automatically sliding
        viewImageSlide.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {

            int Count = Integer.MAX_VALUE;
            ImageSlideFragment fragment = null;
            @Override
            public Fragment getItem(int position) {
                switch (position%4) {
                    case 0:
                        fragment = ImageSlideFragment.createInstance("image0");
                        break;
                    case 1:
                        fragment = ImageSlideFragment.createInstance("image1");
                        break;
                    case 2:
                        fragment = ImageSlideFragment.createInstance("image2");
                        break;
                    case 3:
                        fragment = ImageSlideFragment.createInstance("image3");
                        break;
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return Count;
            }

        });
        viewImageSlide.setOffscreenPageLimit(3);
    //    int num = Integer.MAX_VALUE/2;
    //    viewImageSlide.setCurrentItem(num - num%4);
        handler = new Handler();
        handler.postDelayed(imageSlider,6000);

        // handle gridview for five icons
        handlerOfGridView = new Handler();
        handlerOfGridView.post(setGridView);

        ImageView lotteryview = (ImageView) view.findViewById(R.id.draw_lottery);
        lotteryview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),DrawLottery.class);
                startActivity(intent);
            }
        });
        TextView product_category = (TextView) view.findViewById(R.id.product_category);
        product_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),ProductCategory.class);
                startActivity(intent);
            }
        });

        handlerOfGridView = new Handler();
        handlerOfGridView.post(setSecondGridView);

        display_all = (TextView)view.findViewById(R.id.display_all);
        display_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(display_all.getText().toString().equals("Display All")){
                    handlerOfGridView = new Handler();
                    handlerOfGridView.post(rebuildGridView);}
                else{
                    handlerOfGridView = new Handler();
                    handlerOfGridView.post(shrinkGridView);
                }
            }
        });

        final TabLayout home_page_tablayout = (TabLayout)view.findViewById(R.id.home_page_tablayout);

/*        ViewPager home_page_tablayout_viewpager = (ViewPager)view.findViewById(R.id.home_page_tablayout_viewpager);

        home_page_tablayout_viewpager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return 4;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = LayoutInflater.from(getContext()).inflate(R.layout.home_page_tablayout_newest,null);
                container.addView(view);


                return view;
            }

            @Override
            public int getItemPosition(Object object) {
                return PagerAdapter.POSITION_NONE;
            }
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View)object);
            }
        }); */


        // home_page_tablayout.setupWithViewPager(home_page_tablayout_viewpager);

        // initialize the bottom gridview
        int[] image = {R.drawable.yellow_car, R.drawable.silver_car, R.drawable.yellow_car, R.drawable.silver_car,
                R.drawable.yellow_car, R.drawable.silver_car, R.drawable.yellow_car, R.drawable.silver_car};
        String[] imageName = {"2016 Land Rover SE", "2016 Land Rover SE", "2016 Land Rover SE",
                "2016 Land Rover SE", "2016 Land Rover SE", "2016 Land Rover SE",
                "2016 Land Rover SE", "2016 Land Rover SE"
        };

        data = new ArrayList<>();

        for (int j = 0; j<image.length; j++){
            itemMap = new HashMap<>();
            itemMap.put("image",image[j]);
            itemMap.put("name", imageName[j]);
            data.add(itemMap);
        }

        String[] from = {"image", "name"};
        int[] to = {R.id.loot_treasure_second_tablayout_imageview, R.id.loot_treasure_second_tablayout_textview};
        CustomGridView grid_view = (CustomGridView) view.findViewById(R.id.home_page_tablayout_gridview);

        secondGridViewAdapter = new MyAdapter(getContext(),
                data,
                R.layout.loot_treasure_tablayout_gridview_item,
                from, to);
        grid_view.setAdapter(secondGridViewAdapter);

        // end of initialization of bottom gridview

        for(int i = 0; i< 4; i++){

            View home_page_tab_view = LayoutInflater.from(getContext()).inflate(R.layout.home_page_tab_item_view,null);
            TextView tabname = (TextView)home_page_tab_view.findViewById(R.id.home_page_tablayout_textview);
        //    tabname.setTextSize(TypedValue.COMPLEX_UNIT_SP,10);

            switch(i){
                case 0:
                    tabname.setTextColor(Color.parseColor("#f75151"));
                    tabname.setBackgroundResource(R.drawable.home_page_tab_item_view_background_selected);
                    tabname.setText(getResources().getString(R.string.newest));
                    break;
                case 1:
                    tabname.setText(getResources().getString(R.string.popularity));
                    break;
                case 2:
                    tabname.setText(getResources().getString(R.string.requirement));
                    break;
                case 3:
                    tabname.setText(getResources().getString(R.string.overplus));
                    break;

            }
            TabLayout.Tab tab = home_page_tablayout.newTab();
            tab.setCustomView(home_page_tab_view);
            home_page_tablayout.addTab(tab);
         //   home_page_tablayout.getTabAt(i).setCustomView(home_page_tab_view);

        }
        home_page_tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int[] imageChange;
                String[] imageNameChange;
                View changeView;
                TextView tabname;

                switch (tab.getPosition()) {
                    case 0:
                        changeView = home_page_tablayout.getTabAt(0).getCustomView();
                        tabname = (TextView)changeView.findViewById(R.id.home_page_tablayout_textview);
                        tabname.setTextColor(Color.parseColor("#f75151"));
                        tabname.setBackgroundResource(R.drawable.home_page_tab_item_view_background_selected);

                        home_page_tablayout.getTabAt(0).setCustomView(changeView);

                        // changing the gridview in the bottom
                        imageChange = new int[]{R.drawable.yellow_car, R.drawable.silver_car, R.drawable.yellow_car, R.drawable.silver_car,
                                R.drawable.yellow_car, R.drawable.silver_car, R.drawable.yellow_car, R.drawable.silver_car
                        };
                        imageNameChange = new String[]{"2016 Land Rover SE", "2016 Land Rover SE", "2016 Land Rover SE",
                                "2016 Land Rover SE", "2016 Land Rover SE", "2016 Land Rover SE",
                                "2016 Land Rover SE", "2016 Land Rover SE"
                        };
                        data.clear();
                    //    data = new ArrayList<>();

                        for(int k = 0; k < imageChange.length; k++){
                            itemMap = new HashMap<>();
                            itemMap.put("image",imageChange[k]);
                            itemMap.put("name", imageNameChange[k]);
                            data.add(itemMap);
                        }

                        secondGridViewAdapter.notifyDataSetChanged();
                        // end of changing the gridview in the bottom

                        break;
                    case 1:
                        changeView = home_page_tablayout.getTabAt(1).getCustomView();
                        tabname = (TextView)changeView.findViewById(R.id.home_page_tablayout_textview);
                        tabname.setTextColor(Color.parseColor("#f75151"));
                        tabname.setBackgroundResource(R.drawable.home_page_tab_item_view_background_selected);

                        home_page_tablayout.getTabAt(1).setCustomView(changeView);
                        // changing the gridview in the bottom
                        imageChange = new int[]{R.drawable.yellow_car, R.drawable.yellow_car, R.drawable.yellow_car, R.drawable.yellow_car,
                                R.drawable.yellow_car, R.drawable.silver_car, R.drawable.yellow_car, R.drawable.silver_car
                        };
                        imageNameChange = new String[]{"2016 Land Rover SE", "2016 Land Rover SE", "2016 Land Rover SE",
                                "2016 Land Rover SE", "2016 Land Rover SE", "2016 Land Rover SE",
                                "2016 Land Rover SE", "2016 Land Rover SE"
                        };
                        data.clear();
                        //  data = new ArrayList<>();

                        for(int k = 0; k < imageChange.length; k++){
                            itemMap = new HashMap<>();
                            itemMap.put("image",imageChange[k]);
                            itemMap.put("name", imageNameChange[k]);
                            data.add(itemMap);
                        }

                        secondGridViewAdapter.notifyDataSetChanged();
                        // end of changing the gridview in the bottom

                        break;
                    case 2:
                        changeView = home_page_tablayout.getTabAt(2).getCustomView();
                        tabname = (TextView)changeView.findViewById(R.id.home_page_tablayout_textview);
                        tabname.setTextColor(Color.parseColor("#f75151"));
                        tabname.setBackgroundResource(R.drawable.home_page_tab_item_view_background_selected);

                        home_page_tablayout.getTabAt(2).setCustomView(changeView);

                        // changing the gridview in the bottom

                        imageChange = new int[]{R.drawable.silver_car, R.drawable.silver_car, R.drawable.yellow_car, R.drawable.yellow_car,
                                R.drawable.yellow_car, R.drawable.silver_car, R.drawable.yellow_car, R.drawable.silver_car
                        };
                        imageNameChange = new String[]{"2016 Land Rover SE", "2016 Land Rover SE", "2016 Land Rover SE",
                                "2016 Land Rover SE", "2016 Land Rover SE", "2016 Land Rover SE",
                                "2016 Land Rover SE", "2016 Land Rover SE"
                        };
                        data.clear();
                     //   data = new ArrayList<Map<String, Object>>();

                        for(int k = 0; k < imageChange.length; k++){
                            itemMap = new HashMap<>();
                            itemMap.put("image",imageChange[k]);
                            itemMap.put("name", imageNameChange[k]);
                            data.add(itemMap);
                        }

                        secondGridViewAdapter.notifyDataSetChanged();
                        // end of changing the gridview in the bottom
                        break;
                    case 3:
                        changeView = home_page_tablayout.getTabAt(3).getCustomView();
                        tabname = (TextView)changeView.findViewById(R.id.home_page_tablayout_textview);
                        tabname.setTextColor(Color.parseColor("#f75151"));
                        tabname.setBackgroundResource(R.drawable.home_page_tab_item_view_background_selected);

                        home_page_tablayout.getTabAt(3).setCustomView(changeView);

                        // changing the gridview in the bottom
                        imageChange = new int[]{R.drawable.silver_car, R.drawable.silver_car, R.drawable.silver_car, R.drawable.silver_car,
                                R.drawable.silver_car, R.drawable.silver_car, R.drawable.silver_car, R.drawable.silver_car
                        };
                        imageNameChange = new String[]{"2016 Land Rover SE", "2016 Land Rover SE", "2016 Land Rover SE",
                                "2016 Land Rover SE", "2016 Land Rover SE", "2016 Land Rover SE",
                                "2016 Land Rover SE", "2016 Land Rover SE"
                        };
                        data.clear();

                     //   data = new ArrayList<Map<String, Object>>();

                        for(int k = 0; k < imageChange.length; k++){
                            itemMap = new HashMap<>();
                            itemMap.put("image",imageChange[k]);
                            itemMap.put("name", imageNameChange[k]);
                            data.add(itemMap);
                        }

                        secondGridViewAdapter.notifyDataSetChanged();
                        // end of changing the gridview in the bottom
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

                View changeView;
                TextView tabname;
                switch(tab.getPosition()) {
                    case 0:
                        changeView = home_page_tablayout.getTabAt(0).getCustomView();
                        tabname = (TextView)changeView.findViewById(R.id.home_page_tablayout_textview);
                        tabname.setTextColor(Color.parseColor("#757474"));
                        tabname.setBackgroundResource(R.drawable.home_page_tab_item_view_background);
                     //   tabname.setText(getResources().getString(R.string.newest));
                        home_page_tablayout.getTabAt(0).setCustomView(changeView);
                        break;
                    case 1:
                        changeView = home_page_tablayout.getTabAt(1).getCustomView();
                        tabname = (TextView)changeView.findViewById(R.id.home_page_tablayout_textview);
                        tabname.setTextColor(Color.parseColor("#757474"));
                        tabname.setBackgroundResource(R.drawable.home_page_tab_item_view_background);
                    //    tabname.setText(getResources().getString(R.string.popularity));
                        home_page_tablayout.getTabAt(1).setCustomView(changeView);
                        break;
                    case 2:
                        changeView = home_page_tablayout.getTabAt(2).getCustomView();
                        tabname = (TextView)changeView.findViewById(R.id.home_page_tablayout_textview);
                        tabname.setTextColor(Color.parseColor("#757474"));
                        tabname.setBackgroundResource(R.drawable.home_page_tab_item_view_background);
                        //   tabname.setText(getResources().getString(R.string.newest));
                        home_page_tablayout.getTabAt(2).setCustomView(changeView);
                        break;
                    case 3:
                        changeView = home_page_tablayout.getTabAt(3).getCustomView();
                        tabname = (TextView)changeView.findViewById(R.id.home_page_tablayout_textview);
                        tabname.setTextColor(Color.parseColor("#757474"));
                        tabname.setBackgroundResource(R.drawable.home_page_tab_item_view_background);
                        //   tabname.setText(getResources().getString(R.string.newest));
                        home_page_tablayout.getTabAt(3).setCustomView(changeView);
                        break;
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });


    } // end of onViewCreated method

    private Runnable imageSlider = new Runnable() {

        @Override
        public void run() {

            viewImageSlide.setCurrentItem(viewImageSlide.getCurrentItem()+1, true);
            handler.postDelayed(imageSlider, 6000);
        }
    };
    private Runnable setGridView = new Runnable() {
        @Override
        public void run() {
            int[] images ={R.drawable.fire, R.drawable.one_dollar, R.drawable.ten_dollar, R.drawable.race_against_time, R.drawable.attendance};

            String[] imgText= {"Hot Sale","$1","$10","Time Racing","Daily SignIn"};
            items = new ArrayList<>();
            for(int i=0; i< imgText.length; i++){
                Map<String, Object> oneItem = new HashMap<>();
                oneItem.put("image",images[i]);
                oneItem.put("imgText", imgText[i]);
                items.add(oneItem);
            }
            gridView.setAdapter(new SimpleAdapter(getContext(),
                    items,
                    R.layout.loot_treasure_gridview_item_layout,
                    new String[]{"image","imgText"},
                    new int[]{R.id.gridview_img, R.id.gridview_imgtext} ));
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent;
                    switch(i){
                        case 0:
                            intent = new Intent(getActivity(),HotSale.class);
                            startActivity(intent);
                            break;
                        case 2:

                            intent = new Intent(getActivity(),TenDollar.class);
                            startActivity(intent);
                            break;
                        case 3:

                            intent = new Intent(getActivity(),TimeDash.class);
                            startActivity(intent);
                            break;
                        case 4:

                            intent = new Intent(getActivity(),Attendance.class);
                            startActivity(intent);
                            break;
                    }
                }
            });
        }
    };
    private Runnable setSecondGridView = new Runnable() {
        @Override
        public void run() {

            secondGridViewItems = new ArrayList<>();
            for(int i= 0;i<secondGridViewImages.length; i++){
                Map<String, Object> secondGridViewMap = new HashMap<>();
                secondGridViewMap.put("Image", secondGridViewImages[i]);
                secondGridViewMap.put("Text",secondGridViewTxt[i]);
                secondGridViewItems.add(secondGridViewMap);
            }
            MAdapter = new MySimpleAdapter(getContext(),secondGridViewItems,
                    R.layout.loot_treasure_second_gridview_item_layout,new String[]{"Image","Text"},new int[]{R.id.gridview_img,R.id.gridview_imgtext});
            secondGridView.setAdapter(MAdapter);

        }
    };
    private Runnable rebuildGridView = new Runnable() {
        @Override
        public void run() { // display all items in gridview
            for(int i = 0; i<3;i++){
                Map<String, Object> secondGridViewMap = new HashMap<>();
                secondGridViewMap.put("Image", R.drawable.hundred_dollar_card);
                secondGridViewMap.put("Text","$100 Charge card");
                secondGridViewItems.add(secondGridViewMap);
            }
            MAdapter.notifyDataSetChanged();
            display_all.setText("Collapse");
         //   display_all.setClickable(false);
        }
    };
    private Runnable shrinkGridView = new Runnable() {
        @Override
        public void run() {
            int t = secondGridViewItems.size();

            for(int i = secondGridViewItems.size(); i>3;i--)
                secondGridViewItems.remove(i-1);

            MAdapter.notifyDataSetChanged();
            display_all.setText("Display All");
        }
    };
    private Runnable changeGridView = new Runnable() {
        @Override
        public void run() {
            // changing the gridview in the bottom
            int[] imageChange = new int[]{R.drawable.yellow_car, R.drawable.yellow_car, R.drawable.yellow_car, R.drawable.yellow_car,
                    R.drawable.yellow_car, R.drawable.silver_car, R.drawable.yellow_car, R.drawable.silver_car
            };
            String[] imageNameChange = new String[]{"2016 Land Rover SE", "2016 Land Rover SE", "2016 Land Rover SE",
                    "2016 Land Rover SE", "2016 Land Rover SE", "2016 Land Rover SE",
                    "2016 Land Rover SE", "2016 Land Rover SE"
            };
            data.clear();
         //  data = new ArrayList<>();

            for(int k = 0; k < imageChange.length; k++){
                itemMap = new HashMap<>();
                itemMap.put("image",imageChange[k]);
                itemMap.put("name", imageNameChange[k]);
                data.add(itemMap);
            }

            secondGridViewAdapter.notifyDataSetChanged();
            // end of changing the gridview in the bottom
        }
    };

}
