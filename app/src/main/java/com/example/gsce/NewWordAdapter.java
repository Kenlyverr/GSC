package com.example.gsce;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewWordAdapter extends RecyclerView.Adapter<NewWordAdapter.newword> {
    private LayoutInflater layoutInflater;
    private List<String> listText;
    public NewWordAdapter(List<String> listText) {
        this.listText = listText;
    }
    @NonNull
    @Override
    public newword onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item2, parent, false);
        return new newword(view);
    }

    public void clearData() {
        // clear the data
        listText.clear();
    }

    @Override
    public void onBindViewHolder(@NonNull newword holder, int position) {
        holder.textView.setText(listText.get(position));
    }

    @Override
    public int getItemCount() {
        return listText.size();
    }

    class newword extends RecyclerView.ViewHolder{
        TextView textView;
        public newword(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text);
        }
    }
}
