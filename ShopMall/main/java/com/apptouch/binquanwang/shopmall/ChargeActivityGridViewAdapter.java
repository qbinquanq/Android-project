package com.apptouch.binquanwang.shopmall;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

/**
 * Created by Binquan Wang on 7/27/2016.
 */
public class ChargeActivityGridViewAdapter extends SimpleAdapter{

    int selectPosition = -1;
    Context context;
    List<? extends Map<String, ?>> data;
    public ChargeActivityGridViewAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
        this.context = context;
        this.data = data;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolderButton viewHolder = new ViewHolderButton();


        if(convertView !=null)
            viewHolder = (ViewHolderButton) convertView.getTag();
        else{
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.charge_activity_gridview_item_layout, parent, false);
            viewHolder.button = (Button)convertView.findViewById(R.id.charge_activity_gridview_button);
            convertView.setTag(viewHolder);
        }
      //  final ViewHolderButton finalViewHolder = viewHolder;
        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectItem(position);

               // finalViewHolder.button.setTextColor(Color.parseColor("#ffffff"));
               // finalViewHolder.button.setBackgroundColor(Color.parseColor("#fa440c"));
            }
        });
        Map<String, Object> map;
        map = (Map<String, Object>) data.get(position);
        String txt = (String) map.get("money");
        viewHolder.button.setText(txt);

        if(selectPosition == position){
            viewHolder.button.setTextColor(Color.parseColor("#ffffff"));
            viewHolder.button.setBackgroundColor(Color.parseColor("#fa440c"));
        }
        else{
            viewHolder.button.setTextColor(Color.parseColor("#414040"));
            viewHolder.button.setBackgroundColor(Color.parseColor("#ffffff"));
        }
        return convertView;
    }
    public void selectItem(int position) {
        this.selectPosition  = position;
        notifyDataSetChanged();

    }


}
