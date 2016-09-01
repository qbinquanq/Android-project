package com.apptouch.binquanwang.shopmall;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.zip.Inflater;

/**
 * Created by Binquan Wang on 8/9/2016.
 * used for the orange color bar beneath the black toolbar.
 * add click action to this bar.
 */
public class BotToolbarClickAction {
    Activity activity;
    Context context;
    View view;

    public BotToolbarClickAction(View view, Activity activity, Context context){
        this.view = view;
        this.activity = activity;
        this.context = context;

    }

    public void clickAction(){

        Button charge = (Button)view.findViewById(R.id.charge);      // charge button
        charge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chargeActivity = new Intent(activity,ChargeActivity.class);
                context.startActivity(chargeActivity);
            }
        });

        ImageView shopping_cart = (ImageView)view.findViewById(R.id.shopping_cart); // Shopping Cart
        shopping_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ShoppingActivity = new Intent(activity, ShoppingCartActivity.class);
                context.startActivity(ShoppingActivity);
            }
        });

        ImageView messages = (ImageView)view.findViewById(R.id.messages); // Messages
        messages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent messagesActivity = new Intent(activity,MessageActivity.class);
                context.startActivity(messagesActivity);
            }
        });
    }
}
