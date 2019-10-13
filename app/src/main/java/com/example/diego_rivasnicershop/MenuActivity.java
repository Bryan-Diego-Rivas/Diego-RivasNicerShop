package com.example.diego_rivasnicershop;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.diego_rivasnicershop.model.GemModel;

import java.util.LinkedList;

public class MenuActivity extends AppCompatActivity {

    private final LinkedList<GemModel> gemList = new LinkedList<>();
    private RecyclerView recyclerView;
    private ProductAdapter adapter;

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
                launchCheckoutActivity(view);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        setGemModel();

        recyclerView = findViewById(R.id.recyclerview);
        adapter = new ProductAdapter(this, gemList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void launchCheckoutActivity(View view) {
        Intent intent = new Intent(this, CheckoutActivity.class);
        startActivity(intent);
    }


    public void setGemModel() {
        gemList.addLast(new GemModel(R.string.amethyst_title, R.string.amethyst_description,
                R.string.amethyst_price, R.drawable.amethyst, R.string.amethyst_amount));
        gemList.addLast(new GemModel(R.string.ruby_title, R.string.ruby_description,
                R.string.ruby_price, R.drawable.ruby_stone, R.string.ruby_amount));
        gemList.addLast(new GemModel(R.string.yellowDiamond_title, R.string.yellowDiamond_description,
                R.string.yellowDiamond_price, R.drawable.yellow_diamond, R.string.yellowDiamond_amount));
        gemList.addLast(new GemModel(R.string.sapphire_title, R.string.sapphire_description,
                R.string.sapphire_price, R.drawable.blue_sapphire, R.string.sapphire_amount));
        gemList.addLast(new GemModel(R.string.phosphophyllite_title, R.string.phosphophyllite_description,
                R.string.phosphophyllite_price, R.drawable.phospho, R.string.phosphophyllite_amount));

    }
}
