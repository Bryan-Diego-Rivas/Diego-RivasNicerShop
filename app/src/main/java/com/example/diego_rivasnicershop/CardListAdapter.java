package com.example.diego_rivasnicershop;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.zip.Inflater;

public class CardListAdapter extends RecyclerView.Adapter<CardListAdapter.CardViewHolder> {

    class CardViewHolder extends RecyclerView.ViewHolder {
        public final TextView cardItemView;
        final CardListAdapter adapter;

        public CardViewHolder(View itemView, CardListAdapter adapter) {
            super(itemView);
            cardItemView = itemView.findViewById(R.id.gem);
            this.adapter = adapter;
        }
    }

    private LinkedList<String> worldList;
    private LayoutInflater inflater;

    public CardListAdapter(Context context, LinkedList<String> worldList){
        inflater = LayoutInflater.from(context);
        this.worldList = worldList;
    }

    @NonNull
    @Override
    public CardListAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.cardlist_item, parent, false);

        return new CardViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull CardListAdapter.CardViewHolder holder, int position) {
        String current = worldList.get(position);
        holder.cardItemView.setText(current);
    }

    @Override
    public int getItemCount() {
        return worldList.size();
    }
}
