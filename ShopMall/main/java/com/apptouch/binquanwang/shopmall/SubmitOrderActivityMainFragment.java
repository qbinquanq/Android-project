package com.apptouch.binquanwang.shopmall;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

/**
 * Created by Binquan Wang on 8/4/2016.
 */
public class SubmitOrderActivityMainFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.submit_order_activity_main_fragment,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final RadioButton weChatButton = (RadioButton)view.findViewById(R.id.radiobutton_wechat);
        final RadioButton aliPayButton = (RadioButton)view.findViewById(R.id.radiobutton_alipay);
        final RadioButton remainderButton = (RadioButton)view.findViewById(R.id.radiobutton_remainder);

        remainderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aliPayButton.setChecked(false);
                weChatButton.setChecked(false);
            }
        });
        weChatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aliPayButton.setChecked(false);
                remainderButton.setChecked(false);
            }
        });
        aliPayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weChatButton.setChecked(false);
                remainderButton.setChecked(false);
            }
        });

        Button submit_order = (Button)view.findViewById(R.id.submit_order);
        submit_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //    FragmentManager fragmentManager = getChildFragmentManager();
            //    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                SubmitOrderActivity.navigateBack();
            }
        });
    }
}
