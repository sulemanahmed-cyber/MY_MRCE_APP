package com.test.mymrceapp;





import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Sets_Adapter extends BaseAdapter {
   private int numofsets;

    public Sets_Adapter(int numofsets) {
        this.numofsets = numofsets;
    }

    @Override
    public int getCount() {
        return numofsets;
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
        View view;
        if(convertView==null)
        {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.set_item,parent,false);
        }else {
            view = convertView;
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parent.getContext(),QuestionActivity.class);
                intent.putExtra("SETNO",position + 1);
                parent.getContext().startActivity(intent);
            }
        });
        ((TextView) view.findViewById(R.id.setnumber)).setText(String.valueOf(position+1));
        return view;
    }
}

