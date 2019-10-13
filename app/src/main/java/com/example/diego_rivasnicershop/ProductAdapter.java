package com.example.diego_rivasnicershop;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.diego_rivasnicershop.model.GemModel;

import java.util.LinkedList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

        class ProductViewHolder extends RecyclerView.ViewHolder {
            public final TextView titleView;
            public final TextView priceView;
            public final ImageView imageView;
            public final TextView descriptionView;
            public final TextView quantityView;
            final ProductAdapter adapter;
            private int id = R.id.gem;

            public ProductViewHolder(View itemView, ProductAdapter adapter) {
                super(itemView);
                titleView = itemView.findViewById(R.id.gem);
                priceView = itemView.findViewById(R.id.price);
                imageView = itemView.findViewById(R.id.image);
                descriptionView = itemView.findViewById(R.id.description);
                quantityView = itemView.findViewById(R.id.amount);
                this.adapter = adapter;
            }
    }

    private LinkedList<GemModel> gemList;
    private LayoutInflater inflater;

    public ProductAdapter(Context context, LinkedList<GemModel> gemList){
        inflater = LayoutInflater.from(context);
        this.gemList = gemList;
    }

    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.cardlist_item, parent, false);

        return new ProductViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {
        GemModel current = gemList.get(position);
        holder.titleView.setText(current.getTitle());
        holder.priceView.setText(current.getPrice());
        holder.imageView.setImageResource(current.getImage());
        holder.descriptionView.setText(current.getDescription());
        holder.quantityView.setText(current.getQuantity());
    }

    @Override
    public int getItemCount() {
        return gemList.size();
    }
}
