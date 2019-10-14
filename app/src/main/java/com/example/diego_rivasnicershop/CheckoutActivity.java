package com.example.diego_rivasnicershop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.diego_rivasnicershop.model.GemModel;

import java.text.DecimalFormat;
import java.util.LinkedList;

public class CheckoutActivity extends AppCompatActivity {

    private double subtotal;
    private double tps;
    private double tvq;
    private double grandtotal;
    private final double TPS_PERCENTAGE = .05;
    private final double TVQ_PERCENTAGE = .09975;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        //Getting values from the MenuActivity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            subtotal = extras.getDouble("Gem_Subtotal");
        }

        calculatePrice();

        //Formatting strings
        DecimalFormat form = new DecimalFormat("0.00");
        String subtotalStr = form.format(subtotal);
        String tpsStr = form.format(tps);
        String tvqStr = form.format(tvq);
        String totalStr = form.format(grandtotal);

        //Adding values to the text views
        TextView subtotalView = findViewById(R.id.subtotal_text);
        subtotalView.setText(subtotalStr);

        TextView tpsView = findViewById(R.id.tps_text);
        tpsView.setText(tpsStr);

        TextView tvqView = findViewById(R.id.tvq_text);
        tvqView.setText(tvqStr);

        TextView totalView = findViewById(R.id.total_text);
        totalView.setText(totalStr);
    }

    public void calculatePrice() {
        tps = subtotal * TPS_PERCENTAGE;
        tvq = subtotal * TVQ_PERCENTAGE;
        grandtotal = subtotal + tps + tvq;
    }
}
