package com.example.diego_rivasnicershop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CheckoutActivity extends AppCompatActivity {

    private double subtotal;
    private double tps;
    private double tvq;
    private double total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        //Getting values from the MenuActivity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            subtotal = extras.getDouble("sub");
            tps = extras.getDouble("tps");
            tvq = extras.getDouble("tvq");
            total = extras.getDouble("total");
        }
        //Formatting strings
        DecimalFormat form = new DecimalFormat("0.00");
        String subtotalStr = form.format(subtotal);
        String tpsStr = form.format(tps);
        String tvqStr = form.format(tvq);
        String totalStr = form.format(total);

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
}
