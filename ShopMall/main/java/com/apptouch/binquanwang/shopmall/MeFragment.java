package com.apptouch.binquanwang.shopmall;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Binquan Wang on 7/13/2016.
 */
public class MeFragment extends Fragment {
    private View view;
    public static MeFragment createInstance(String data){


        Bundle args = new Bundle();
        args.putString("Position", data);
        MeFragment fragment = new MeFragment();
        fragment.setArguments(args);
        return fragment;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //    return super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.me, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView firstRightArrow = (ImageView)view.findViewById(R.id.right_arrow_first);
        firstRightArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),WinningHistory.class);
                startActivity(intent);
            }
        });
    }
}
