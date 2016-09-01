package com.apptouch.binquanwang.shopmall;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Binquan Wang on 7/13/2016.
 */
public class RankListFragment extends Fragment {
    private View view;
    public static RankListFragment createInstance(String data){


        Bundle args = new Bundle();
        args.putString("Position", data);
        RankListFragment fragment = new RankListFragment();
        fragment.setArguments(args);
        return fragment;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //    return super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.rank_list, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        BotToolbarClickAction botToolbarClickActionRankList = new BotToolbarClickAction(view, getActivity(),getContext());
        botToolbarClickActionRankList.clickAction();
    }
}
