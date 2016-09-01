package com.apptouch.binquanwang.shopmall;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Binquan Wang on 7/13/2016.
 */
public class NewAnnounceFragment extends Fragment {
    private View view;
    public static NewAnnounceFragment createInstance(String data){


        Bundle args = new Bundle();
        args.putString("Position", data);
        NewAnnounceFragment fragment = new NewAnnounceFragment();
        fragment.setArguments(args);
        return fragment;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    //    return super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.new_announce, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        BotToolbarClickAction botToolbarClickActionNew = new BotToolbarClickAction(view, getActivity(),getContext());
        botToolbarClickActionNew.clickAction();

        TextView tv = (TextView)view.findViewById(R.id.td1);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //    HomePage.allProductDisplay();
            }
        });
    }
}
