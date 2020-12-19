package com.example.gsce;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

public class choseAdapter extends BaseAdapter {


    private Context context;
    private int layout;
    private List<chose> choseList;

    public choseAdapter(Context context, int layout, List<chose> choseList) {
        this.context = context;
        this.layout = layout;
        this.choseList = choseList;
    }

    public int getCount() {
        return choseList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout,null);

        TextView txtName=(TextView) convertView.findViewById(R.id.txtTenChuDe);
        TextView txtNumber= (TextView) convertView.findViewById(R.id.txtSoDiem);
        ProgressBar progressBar = (ProgressBar) convertView.findViewById(R.id.progressBar);

        chose chose=choseList.get(i);

        txtName.setText(chose.getName());
        txtNumber.setText(chose.getNumber());
        progressBar.setProgress(Integer.parseInt (chose.getNumber()));

        return convertView;
    }
}
