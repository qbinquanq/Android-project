package com.apptouch.binquanwang.shopmall;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Binquan Wang on 7/14/2016.
 */
public class ImageSlideFragment extends Fragment{
    private String image;


    public static ImageSlideFragment createInstance(String data){


        Bundle args = new Bundle();
        args.putString("image", data);
        ImageSlideFragment fragment = new ImageSlideFragment();
        fragment.setArguments(args);
        return fragment;

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        image = getArguments().getString("image");
        View view = null;
        switch (image){
            case "image0":
                view= inflater.inflate(R.layout.image_slides_fragment_car0,container,false);
                break;
            case "image1":
                view= inflater.inflate(R.layout.image_slides_fragment_car1,container,false);
                break;
            case "image2":
                view= inflater.inflate(R.layout.image_slides_fragment_car2,container,false);
                break;
            case "image3":
                view= inflater.inflate(R.layout.image_slides_fragment_car3,container,false);
                break;

        }
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
