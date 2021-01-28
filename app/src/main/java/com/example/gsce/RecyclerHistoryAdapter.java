package com.example.gsce;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerHistoryAdapter extends  RecyclerView.Adapter<RecyclerHistoryAdapter.Adapter> {
    private Context context;
    private LayoutInflater layoutInflater;
    private List<String> listText;
    private List<String> listMean;
    public RecyclerHistoryAdapter(List<String> listText, Context context, List<String> listMean) {
        this.listText = listText;
        this.context = context;
        this.listMean = listMean;
    }
    @NonNull
    @Override
    public Adapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);
        return new Adapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter holder, int position) {
        holder.meanView.setText(listMean.get(position));
        holder.textView.setText(listText.get(position));
    }

    @Override
    public int getItemCount() {
        return listMean.size();
    }

    public class Adapter extends RecyclerView.ViewHolder {
        TextView textView;
        TextView meanView;
        public Adapter(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text);
            meanView = itemView.findViewById(R.id.mean);
        }
    }
}
