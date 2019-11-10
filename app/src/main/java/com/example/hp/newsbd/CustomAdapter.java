package com.example.hp.newsbd;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by HP on 22-Mar-18.
 */

public class CustomAdapter extends BaseAdapter {



    int[] logo;
    String[] webAddress,item;
    Context context;
    private LayoutInflater inflater;

    CustomAdapter (Context context,String[] webAddress, int[] logo){

        this.context=context;
        this.webAddress=webAddress;
        this.logo=logo;
    }
    CustomAdapter (Context context, String[] webAddress, int[] logo, String[] item){
        this.context=context;
        this.webAddress=webAddress;
        this.logo=logo;
        this.item=item;


    }


    @Override
    public int getCount() {

        return webAddress.length;

    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){

            inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView= inflater.inflate(R.layout.view,parent,false);

        }

        ImageView imageView= (ImageView) convertView.findViewById(R.id.imageId);

        TextView textView= (TextView) convertView.findViewById(R.id.textViewId);


        imageView.setImageResource(logo[position]);
        textView.setText(webAddress[position]);


        return convertView;
    }


}
