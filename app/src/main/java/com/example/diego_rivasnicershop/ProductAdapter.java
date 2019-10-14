package com.example.diego_rivasnicershop;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.diego_rivasnicershop.model.GemModel;

import java.util.LinkedList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

        class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            public final TextView titleView;
            public final TextView priceView;
            public final ImageView imageView;
            public final TextView descriptionView;
            public final TextView quantityView;
            public final TextView subtotalView;
            final ProductAdapter adapter;
            private int id = R.id.gem;
            Button addButton;
            Button removeButton;

            public ProductViewHolder(View itemView, ProductAdapter adapter) {
                super(itemView);
                titleView = itemView.findViewById(R.id.gem);
                priceView = itemView.findViewById(R.id.price);
                imageView = itemView.findViewById(R.id.image);
                descriptionView = itemView.findViewById(R.id.description);
                quantityView = itemView.findViewById(R.id.amount);
                subtotalView = itemView.findViewById(R.id.subtotal);
                this.adapter = adapter;

                addButton = itemView.findViewById(R.id.add_button);
                addButton.setOnClickListener(this);

                removeButton = itemView.findViewById(R.id.remove_button);
                removeButton.setOnClickListener(this);
            }


            @Override
            public void onClick(View v) {
                int position = getLayoutPosition();
                Log.d("Position", position + "");
                GemModel element = gemList.get(position);
                int quantity;
                String subtotal = itemView.getResources().getString(R.string.gem_subtotal)+ " ";
                double price = element.getPrice();

               // if (addButton.callOnClick())
                    switch (position) {
                        case 1:
                            quantity = element.getQuantity() + 1;
                            element.setQuantity(quantity);
                            subtotal += Double.toString(price * quantity);
                            quantityView.setText(Integer.toString(quantity));
                            subtotalView.setText(subtotal);
                            break;
                        case 2:
                            quantity = element.getQuantity() + 1;
                            element.setQuantity(quantity);
                            subtotal += Double.toString(price * quantity);
                            quantityView.setText(Integer.toString(quantity));
                            subtotalView.setText(subtotal);
                            break;
                        case 3:
                            quantity = element.getQuantity() + 1;
                            element.setQuantity(quantity);
                            subtotal += Double.toString(price * quantity);
                            quantityView.setText(Integer.toString(quantity));
                            subtotalView.setText(subtotal);
                            break;
                        case 4:
                            quantity = element.getQuantity() + 1;
                            element.setQuantity(quantity);
                            subtotal += Double.toString(price * quantity);
                            quantityView.setText(Integer.toString(quantity));
                            subtotalView.setText(subtotal);
                            break;
                        case 5:
                            quantity = element.getQuantity() + 1;
                            element.setQuantity(quantity);
                            subtotal += Double.toString(price * quantity);
                            quantityView.setText(Integer.toString(quantity));
                            subtotalView.setText(subtotal);
                            break;

                            default:
                            quantity = element.getQuantity() + 1;
                            gemList.get(position).setQuantity(quantity);
                            subtotal += Double.toString(price * quantity);
                            quantityView.setText(Integer.toString(quantity));
                            subtotalView.setText(subtotal);
                            break;
                    }

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
        holder.priceView.setText(Double.toString(current.getPrice()));
        holder.imageView.setImageResource(current.getImage());
        holder.descriptionView.setText(current.getDescription());
        holder.quantityView.setText(Integer.toString(current.getQuantity()));
}

    @Override
    public int getItemCount() {
        return gemList.size();
    }
}
