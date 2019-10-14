package com.example.diego_rivasnicershop;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import com.example.diego_rivasnicershop.model.GemModel;
import java.util.LinkedList;

public class MenuActivity extends AppCompatActivity {

    private LinkedList<GemModel> gemList = new LinkedList<>();
    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private int shippingCost = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShippingAlert(view);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setGemModel();

        recyclerView = findViewById(R.id.recyclerview);
        adapter = new ProductAdapter(this, gemList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Restoring values
        if (savedInstanceState != null) {
            //Retrieving values
            Log.d("Inside", "Inside toRestore");
            gemList = (LinkedList<GemModel>) savedInstanceState.getSerializable("Gem_Data");
            Parcelable state = savedInstanceState.getParcelable("listState");
            recyclerView.getLayoutManager().onRestoreInstanceState(state);
            recyclerView.setAdapter(new ProductAdapter(this, gemList));
        }
    }

    /**
     * Method that saves the values when screen goes to landscape
     * @param outState the save state
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putSerializable("Gem_Data", gemList);
        Parcelable listState = recyclerView.getLayoutManager().onSaveInstanceState();
        outState.putParcelable("listState", listState);
    }

    /**
     * Method launches the CheckoutActivity
     * @param view Current view
     */
    public void launchCheckoutActivity(View view) {
        Intent intent = new Intent(this, CheckoutActivity.class);
        double subtotal = 0;

        for (GemModel gem: gemList) {
            subtotal += gem.getTotal();
        }
        subtotal += shippingCost;
        intent.putExtra("Gem_Subtotal", subtotal);
        startActivity(intent);
    }

    /**
     * Method Initializes the GemModels
     */
    public void setGemModel() {
        gemList.addLast(new GemModel(R.string.amethyst_title, R.string.amethyst_description,
                Double.parseDouble(getResources().getString(R.string.amethyst_price)),
                R.drawable.amethyst,
                Integer.parseInt(getResources().getString(R.string.amethyst_amount))));
        gemList.addLast(new GemModel(R.string.ruby_title, R.string.ruby_description,
                Double.parseDouble(getResources().getString(R.string.ruby_price)),
                R.drawable.ruby_stone,
                Integer.parseInt(getResources().getString(R.string.ruby_amount))));
        gemList.addLast(new GemModel(R.string.yellowDiamond_title, R.string.yellowDiamond_description,
                Double.parseDouble(getResources().getString(R.string.yellowDiamond_price)),
                R.drawable.yellow_diamond,
                Integer.parseInt(getResources().getString(R.string.yellowDiamond_amount))));
        gemList.addLast(new GemModel(R.string.sapphire_title, R.string.sapphire_description,
                Double.parseDouble(getResources().getString(R.string.sapphire_price)),
                R.drawable.blue_sapphire,
                Integer.parseInt(getResources().getString(R.string.sapphire_amount))));
        gemList.addLast(new GemModel(R.string.phosphophyllite_title, R.string.phosphophyllite_description,
                Double.parseDouble(getResources().getString(R.string.phosphophyllite_price)),
                R.drawable.phospho,
                Integer.parseInt(getResources().getString(R.string.phosphophyllite_amount))));
    }

    /**
     * Method that creates the AlertDialog with 3 different shipping methods
     * @param view Current view
     */
    public void ShippingAlert(final View view) {
        String[] listItems = getResources().getStringArray(R.array.shipping_item);
        AlertDialog.Builder alert = new AlertDialog.Builder(MenuActivity.this);
        alert.setTitle("Delivery methods");
        alert.setPositiveButton("Proceed", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                launchCheckoutActivity(view);
            }
        });
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        alert.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int position) {
                switch (position){
                    case 1: shippingCost += 20;
                        break;
                    case 2: shippingCost += 0;
                        break;
                    default: shippingCost += 50;
                        break;
                }
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }
}
