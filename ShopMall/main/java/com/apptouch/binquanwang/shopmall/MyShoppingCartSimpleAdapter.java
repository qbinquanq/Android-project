package com.apptouch.binquanwang.shopmall;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import java.util.List;
import java.util.Map;

/**
 * Created by Binquan Wang on 7/29/2016.
 */
public class MyShoppingCartSimpleAdapter extends SimpleAdapter{

    Context context;
    List<? extends Map<String, ?>> data;
    private NumberChangeEvent event;
    Boolean bool = true;
  //  int rightWidth;
    public MyShoppingCartSimpleAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {

        super(context, data, resource, from, to);
        this.context = context;
        this.data = data;
    //    this.rightWidth = rightWidth;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolderForShoppingCart viewHolder = new ViewHolderForShoppingCart();

        if(convertView !=null)
            viewHolder = (ViewHolderForShoppingCart) convertView.getTag();
        else{
            convertView = LayoutInflater.from(context).inflate(R.layout.shopping_cart_activity_gridview_item, parent, false);
            viewHolder.checkBox = (CheckBox)convertView.findViewById(R.id.singleItem_checkbox);
            viewHolder.img = (ImageView)convertView.findViewById(R.id.shopping_cart_gridview_image);
            viewHolder.txt = (TextView)convertView.findViewById(R.id.shopping_cart_gridview_text);
            viewHolder.minusButton = (Button)convertView.findViewById(R.id.minus);
            viewHolder.count = (Button)convertView.findViewById(R.id.count);
            viewHolder.plusButton = (Button)convertView.findViewById(R.id.plus);
        //    viewHolder.Front_view = (View)convertView.findViewById(R.id.front_view);
        //    viewHolder.Back_view = (View)convertView.findViewById(R.id.back_view);
        //    viewHolder.delete = (TextView)convertView.findViewById(R.id.delete);
            convertView.setTag(viewHolder);
        }
        final Map<String, Object> map;
        map = (Map<String, Object>) data.get(position);

/*        LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        viewHolder.Front_view.setLayoutParams(layoutParams1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(rightWidth, LinearLayout.LayoutParams.MATCH_PARENT);
        viewHolder.Back_view.setLayoutParams(layoutParams2);

        viewHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.remove(map);
                notifyDataSetChanged();
                event.onChanged();
                if(!data.isEmpty()){

                }
            }
        }); */



        final boolean checkBox = (boolean) map.get("CheckBox");

        int imgId = (int) map.get("ImageGetter");
        String txt = (String) map.get("TxtGetter");
        final int itemCount = (int) map.get("ItemCount");
        viewHolder.checkBox.setChecked(checkBox);
        viewHolder.img.setImageResource(imgId);
        viewHolder.txt.setText(txt);
        viewHolder.count.setText(String.valueOf(itemCount));

        viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
            //    Map<String, Object> mapItem = (Map<String, Object>) data.get(position);
                if(!checkBox){
                    map.put("CheckBox",true);
                    notifyDataSetChanged();
                    event.onChanged();
                }
                else{
                    map.put("CheckBox",false);
                    notifyDataSetChanged();
                    event.onChanged();
                }
            }
        });
        viewHolder.minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp = itemCount;
                if(temp>0){
                temp--;
                map.put("ItemCount",temp);
                notifyDataSetChanged();
                if(map.get("CheckBox")==bool)
                    event.onChanged();
                }
            }
        });
        viewHolder.plusButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int temp = itemCount;
                temp++;
                map.put("ItemCount",temp);
                notifyDataSetChanged();
                if(map.get("CheckBox")==bool){
                    event.onChanged();
                }
            }
        });

        return convertView;
    }

    public void allChecked(){
        for(int i =0; i< data.size();i++) {
            Map<String, Object> map = (Map<String, Object>) data.get(i);
            map.put("CheckBox",true);
            notifyDataSetChanged();
            event.onChanged();
        }
    }
    public void allUnchecked(){
        for(int i =0; i< data.size();i++) {
            Map<String, Object> map = (Map<String, Object>) data.get(i);
            map.put("CheckBox",false);
            notifyDataSetChanged();
            event.onChanged();
        }
    }
    public void setListener(NumberChangeEvent event){
        this.event = event;
    }

}
