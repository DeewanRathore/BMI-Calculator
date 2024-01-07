package com.rathoreraja.bmiexample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtResult;
        EditText edtWeight,edtHeightFt,edtHeightInc;
        Button btnCalculateBMI ;


        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFt = findViewById(R.id.edtHeightFt);
        btnCalculateBMI = findViewById(R.id.btncalculateBMI);
        edtHeightInc = findViewById(R.id.edtHeightInc);
        txtResult = findViewById(R.id.txtResult);



        btnCalculateBMI.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                int wt= Integer.parseInt(edtWeight.getText().toString());
                int hft= Integer.parseInt(edtHeightFt.getText().toString());
                int hinc= Integer.parseInt(edtHeightInc.getText().toString());

                int totalinc = (hft*12)+hinc;
                double totalCM = (totalinc*2.53);
                double totalM = (totalCM/100);
                
                double bmi = wt/(totalM*totalM);
                
                if(bmi>25) {
                    txtResult.setText("You Are OverWeight");
                } else if (bmi<18) {
                    txtResult.setText("You Are UnderWeight");
                } else{
                    txtResult.setText("You Are Healthy");
                }

            }
        });

    }
}