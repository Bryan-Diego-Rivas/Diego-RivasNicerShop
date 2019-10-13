package com.example.diego_rivasnicershop;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.LinkedList;

public class MenuActivity extends AppCompatActivity {

    private final LinkedList<String> gemList = new LinkedList<>();
    private RecyclerView recyclerView;
    private CardListAdapter adapter;

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

        gemList.addLast("Amethyst");
        gemList.addLast("Ruby");
        gemList.addLast("Yellow Diamond");
        gemList.addLast("Sapphire");
        gemList.addLast("Phosphophyllite");

        recyclerView = findViewById(R.id.recyclerview);
        adapter = new CardListAdapter(this, gemList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void launchCheckoutActivity(View view) {
        Intent intent = new Intent(this, CheckoutActivity.class);
        startActivity(intent);
    }
}
