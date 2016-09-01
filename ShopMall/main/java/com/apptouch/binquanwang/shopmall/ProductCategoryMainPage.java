package com.apptouch.binquanwang.shopmall;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

/**
 * Created by Binquan Wang on 7/20/2016.
 */
public class ProductCategoryMainPage extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.product_category_main_page,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView rightArrow = (ImageView)view.findViewById(R.id.all_product_arrow);
        rightArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //    View viewpage = LayoutInflater.from(getContext()).inflate(R.layout.product_category,null);
            //    FrameLayout fl = (FrameLayout)viewpage.findViewById(R.id.fragment_container);
            //    ProductCategory PC = new ProductCategory();
            //    PC.transaction = getChildFragmentManager().beginTransaction();
            //    PC.allProductDisplay();
                ProductCategory.allProductDisplay();
            }
        });
    }

}
