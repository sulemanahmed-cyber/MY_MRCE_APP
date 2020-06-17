package com.test.mymrceapp;




import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Random;


public class CategoryGridAdapter extends BaseAdapter {


    private List<String> catList;

    public CategoryGridAdapter(List<String> catList) {
        this.catList = catList;
    }

    @Override
    public int getCount() {
        return catList.size();
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
    public View getView(final int position, View convertView, final ViewGroup parent) {
        View view ;
        if(convertView == null){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item,parent,false);
        } else {
            view = convertView;
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(parent.getContext(),Sets_Activity.class);
                i.putExtra("CATEGORY",catList.get(position));

               i.putExtra("CATEGORY_ID",position+1);
                parent.getContext().startActivity(i);
            }
        });
        ((TextView) view.findViewById(R.id.cattext)).setText(catList.get(position));
        Random rnd = new Random();
        int color = Color.argb(255,rnd.nextInt(255),rnd.nextInt(255),rnd.nextInt(255));
        view.setBackgroundColor(color);
        return view;
    }
}
