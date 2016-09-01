package com.apptouch.binquanwang.shopmall;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Binquan Wang on 7/22/2016.
 */
public class MyAdapter extends SimpleAdapter{
    Context context;
    List<? extends Map<String, ?>> data;
    public MyAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();

        if(convertView !=null)
            viewHolder = (ViewHolder)convertView.getTag();
        else{
            convertView = LayoutInflater.from(context).inflate(R.layout.loot_treasure_tablayout_gridview_item, parent, false);
            viewHolder.img = (ImageView)convertView.findViewById(R.id.loot_treasure_second_tablayout_imageview);
            viewHolder.txt = (TextView)convertView.findViewById(R.id.loot_treasure_second_tablayout_textview);
            viewHolder.button = (Button)convertView.findViewById(R.id.loot_treasure_second_tablayout_button);
            convertView.setTag(viewHolder);

        }
        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, Object> map;
                map = (Map<String, Object>) data.get(position);
                int imgId = (int) map.get("image");
                String txt = (String) map.get("name");
                HomePage.DataMapPass = new HashMap<String, Object>();
                HomePage.DataMapPass.put("CheckBox",false);
                HomePage.DataMapPass.put("ImageGetter", imgId);
                HomePage.DataMapPass.put("TxtGetter",txt);
                HomePage.DataMapPass.put("ItemCount",1);
                HomePage.DataListPass.add(HomePage.DataMapPass);
            }
        });

        Map<String, Object> map;
        map = (Map<String, Object>) data.get(position);
        int imgId = (int) map.get("image");
        String txt = (String) map.get("name");
        viewHolder.img.setImageResource(imgId);
        viewHolder.txt.setText(txt);

        return convertView;

    }
}
