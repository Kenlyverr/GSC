package com.example.gsce;

import java.util.List;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class customAdapter extends BaseAdapter {

    private List<custom> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public customAdapter(Context aContext, int custom_gridview, List<custom> listData) {
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
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.custom_gridview, null);
            holder = new ViewHolder();
            holder.img = (ImageView) convertView.findViewById(R.id.imgView);
            holder.spelling = (TextView) convertView.findViewById(R.id.txtSpell);
            holder.vocabulary = (TextView) convertView.findViewById(R.id.txtVocabulary);
            holder.mean = (TextView) convertView.findViewById(R.id.txtMean);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        custom custom = this.listData.get(position);

        holder.spelling.setText(custom.getSpelling());
        holder.vocabulary.setText(custom.getVocabulary());
        holder.mean.setText(custom.getMean());
        holder.img.setImageResource(custom.getImage());

//        Picasso.get()
//                .load(listData.get(position).getImage())
//                .into(holder.img);
//        holder.spelling.setText(listData.get(position).getSpelling());
//        holder.vocabulary.setText(listData.get(position).getVocabulary());
//        holder.mean.setText(listData.get(position).getMean());


        return convertView;
    }


    static class ViewHolder {
        ImageView img;
        TextView spelling;
        TextView vocabulary;
        TextView mean;
    }
}
