package com.apptouch.binquanwang.shopmall;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Binquan Wang on 7/23/2016.
 */
public class HomePageTabLayoutNewest extends Fragment {

    public static HomePageTabLayoutNewest createInstance(String data){

        Bundle args = new Bundle();
        args.putString("Position", data);
        HomePageTabLayoutNewest fragment = new HomePageTabLayoutNewest();
        fragment.setArguments(args);
        return fragment;

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_page_tablayout_newest,container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
