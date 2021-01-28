package com.example.gsce;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

public class customFindImageAdapter extends BaseAdapter {

    private List<customFindImage> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public customFindImageAdapter(Context aContext, int custom_gridview3, List<customFindImage> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        customFindImageAdapter.ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.custom_gridview3, null);
            holder = new customFindImageAdapter.ViewHolder();
            holder.img = (ImageView) convertView.findViewById(R.id.imgView);
            holder.mean = (TextView) convertView.findViewById(R.id.txtMean3);
            holder.vocabalary = (TextView) convertView.findViewById(R.id.txtVocalbulary3);

            convertView.setTag(holder);
        } else {
            holder = (customFindImageAdapter.ViewHolder) convertView.getTag();
        }

        customFindImage customFindImage = this.listData.get(position);

        holder.mean.setText(customFindImage.getMean());
        holder.vocabalary.setText(customFindImage.getVocabulary());
        holder.img.setImageResource(customFindImage.getImage());

        return convertView;
    }


    static class ViewHolder {
        ImageView img;
        TextView mean;
        TextView vocabalary;
    }

}
