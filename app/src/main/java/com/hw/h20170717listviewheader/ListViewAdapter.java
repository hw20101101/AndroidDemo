package com.hw.h20170717listviewheader;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by HW on 18/07/2017.
 */

public class ListViewAdapter extends ArrayAdapter<String>{

    int groupId;
    String[] items_list;
    Context context;

    public ListViewAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull String[] objects) {
        super(context, resource, textViewResourceId, objects);
        this.context = context;
        this.items_list = objects;
        this.groupId = resource;
    }

    static class ViewHolder{
        public TextView tv_name;
        public TextView tv_price;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder viewHolder = null;
        View rowView = convertView;

        if (viewHolder == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(groupId, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.tv_name = rowView.findViewById(R.id.tv_name);
            viewHolder.tv_price = rowView.findViewById(R.id.tv_price);
            rowView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder)rowView.getTag();
        }

        String[] items = items_list[position].split("__");
        viewHolder.tv_name.setText(items[0]);
        viewHolder.tv_price.setText(items[1]);
        return rowView;
    }
}
