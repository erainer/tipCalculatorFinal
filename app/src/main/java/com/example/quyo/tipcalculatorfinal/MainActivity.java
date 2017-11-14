package com.example.quyo.tipcalculatorfinal;

import android.icu.text.NumberFormat;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double total;
    double tipAmount;
    double totalCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText totalBillAmount = (EditText) findViewById(R.id.billtxtField);
        final Spinner group = (Spinner) findViewById(R.id.tipChoices);
        Button calculateTotal = (Button) findViewById(R.id.calculateBtn);
        final TextView result = (TextView) findViewById(R.id.totalAMount);
        calculateTotal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                total = Integer.parseInt(totalBillAmount.getText().toString());
                DecimalFormat currency = new DecimalFormat("#.##");

                switch(group.getSelectedItem().toString()){
                    case "5%": tipAmount = .05; break;
                    case "10%": tipAmount = .1; break;
                    case "15%": tipAmount =.15; break;
                    case "20%": tipAmount = .2; break;
                    case "25%": tipAmount = .25; break;
                }

                totalCost = (tipAmount * total) + total;
                result.setText("Total cost with a " + group.getSelectedItem().toString() + " tip of $" + total + " is $" + totalCost);
            }
        });
    }
}
