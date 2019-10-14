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
                removeButton = itemView.findViewById(R.id.remove_button);
                addButton.setOnClickListener(this);
                removeButton.setOnClickListener(this);
            }

            /**
             * Method that can add or remove a gem from the cart when said button is clicked
             * @param v Current view
             */
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.add_button: add();
                        break;
                    case R.id.remove_button: remove();
                }
            }

            /**
             * Method adds a gem to the cart. It updates the quantity and the subtotal of the gem
             */
            public void add() {
                int position = getLayoutPosition();

                GemModel element = gemList.get(position);
                int quantity;
                String subtotal = itemView.getResources().getString(R.string.gem_subtotal)+ " ";
                double price = element.getPrice();

                quantity = element.getQuantity() + 1;
                element.setQuantity(quantity);
                double total = price * quantity;
                subtotal += String.format("%.2f", total);
                quantityView.setText(Integer.toString(quantity));
                subtotalView.setText(subtotal);
                element.setTotal(total);
                Log.d("Item_Added", "Gem: " +
                        itemView.getResources().getString(element.getTitle()) + " was added. " +
                        "Price for the item is " + element.getPrice());
            }

            /**
             * Method Removes a gem from the cart. It updates the quantity in the shop and the
             * subtotal of the gem
             */
            public void remove() {
                int position = getLayoutPosition();

                GemModel element = gemList.get(position);
                int quantity = element.getQuantity();
                String subtotal = itemView.getResources().getString(R.string.gem_subtotal) + " ";
                double price = element.getPrice();

                if (quantity > 0 ){
                    quantity--;
                    element.setQuantity(quantity);
                    double total = price * quantity;
                    subtotal += String.format("%.2f",total);
                    quantityView.setText(Integer.toString(quantity));
                    subtotalView.setText(subtotal);
                    element.setTotal(total);
                    Log.d("Item_Remove", "Gem :" +
                            itemView.getResources().getString(element.getTitle()) + " was removed. " +
                            "Price for the item is " + element.getPrice());
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
        holder.subtotalView.setText("Gem subtotal is $ 0.00");
}

    @Override
    public int getItemCount() {
        return gemList.size();
    }
}
