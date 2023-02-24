package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvresult,tvop;
        EditText etheighti,etheightf,etweight;
        Button button;
        LinearLayout llMain;

        etheighti = findViewById(R.id.etheighti);
        etheightf = findViewById(R.id.etheightf);
        etweight = findViewById(R.id.etweight);
        tvresult = findViewById(R.id.tvresult);
        button = findViewById(R.id.button);
        llMain = findViewById(R.id.llMain);
        tvop = findViewById(R.id.tvop);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



              int w = Integer.parseInt(etweight.getText().toString());
              int hf = Integer.parseInt(etheightf.getText().toString());
              int hi = Integer.parseInt(etheighti.getText().toString());

              int totalinch = hf*12 + hi;
              double totalcm = totalinch*2.53;
              double totalmtr = totalcm/100;
              double bmi = w/(totalmtr*totalmtr);
              tvop.setText("BMI : "+bmi);

              if (bmi<18.5){
                  tvresult.setText("UNDERWEIGHT");
                  llMain.setBackgroundColor(getResources().getColor(R.color.a));
              } else if(bmi>=18.5 && bmi<=24.9){
                  tvresult.setText("HEALTHY WEIGHT");
                  llMain.setBackgroundColor(getResources().getColor(R.color.b));
              } else if(bmi>=25.0 && bmi<=29.9){
                  tvresult.setText("OVERWEIGHT");
                  llMain.setBackgroundColor(getResources().getColor(R.color.c));
              } else{
                  tvresult.setText("OBESITY");
                  llMain.setBackgroundColor(getResources().getColor(R.color.d));
              }

            }
        });



    }
}