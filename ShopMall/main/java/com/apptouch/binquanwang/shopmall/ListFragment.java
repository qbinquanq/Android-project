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
public class ListFragment extends Fragment {
    private View view;
    public static ListFragment createInstance(String data){


        Bundle args = new Bundle();
        args.putString("Position", data);
        ListFragment fragment = new ListFragment();
        fragment.setArguments(args);
        return fragment;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //    return super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.list, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        BotToolbarClickAction botToolbarClickActionList = new BotToolbarClickAction(view, getActivity(),getContext());
        botToolbarClickActionList.clickAction();
    }
}
