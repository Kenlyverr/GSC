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

public class customGameAdapter extends BaseAdapter {

    private List<customGame> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public customGameAdapter(Context aContext, int custom_gridview2, List<customGame> listData) {
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
            convertView = layoutInflater.inflate(R.layout.custom_gridview2, null);
            holder = new ViewHolder();
            holder.img = (ImageView) convertView.findViewById(R.id.imgView);
            holder.title = (TextView) convertView.findViewById(R.id.txtTitle);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        customGame customGame = this.listData.get(position);

        holder.title.setText(customGame.getTitle());
        holder.img.setImageResource(customGame.getImage());

        return convertView;
    }


    static class ViewHolder {
        ImageView img;
        TextView title;
    }
}
