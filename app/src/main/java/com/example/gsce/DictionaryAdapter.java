package com.example.gsce;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DictionaryAdapter extends RecyclerView.Adapter<DictionaryAdapter.DictionaryHolder> {
    private LayoutInflater layoutInflater;
    private List<String> listText;
    ItemClick itemClick;
    public void setOnClickListener(ItemClick itemClick){
        this.itemClick = itemClick;}
    public DictionaryAdapter(List<String> listText) {
        this.listText = listText;
    }
    @NonNull
    @Override
    public DictionaryAdapter.DictionaryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_dictionary, parent, false);
        return new DictionaryAdapter.DictionaryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DictionaryAdapter.DictionaryHolder holder, int position) {
        holder.textView.setText(listText.get(position));
    }

    @Override
    public int getItemCount() {
        return listText.size();
    }

    class DictionaryHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public DictionaryHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemClick != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                           itemClick.onClick(v, position);
                        }
                    }

                }
            });
        }
    }
}
