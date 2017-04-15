package com.onepage.infohamil.custom_ui;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.onepage.infohamil.R;


public class CustomListViewAdapter extends ArrayAdapter {
    private final Activity context;
    private final int[] listIndex;
    private final String[] listTitle;

    public CustomListViewAdapter(Activity context, String[] listTitle) {
        super(context, R.layout.listview_menu);

        this.context = context;
        this.listTitle = listTitle;

        listIndex = new int[listTitle.length];
        for(int x=0 ; x < listTitle.length ; x++)
            listIndex[x] = x;
    }

    @Override
    public int getCount() {
        return listTitle.length;
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView == null) {
            LayoutInflater inflater;

            viewHolder = new ViewHolder();

            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_menu, null);

            viewHolder.tvListIndex = (TextView) convertView.findViewById(R.id.tvListIndex);
            viewHolder.tvListTitle = (TextView) convertView.findViewById(R.id.tvListTitle);

            convertView.setTag(viewHolder);
        } else
            viewHolder = (ViewHolder) convertView.getTag();

        viewHolder.tvListIndex.setText(listIndex[position]);
        viewHolder.tvListTitle.setText(listTitle[position]);

        return convertView;
    }

    private class ViewHolder {
        private TextView tvListIndex, tvListTitle;
    }
}
