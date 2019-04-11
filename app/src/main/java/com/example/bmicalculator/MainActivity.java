package com.example.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txt_weight, txt_height;
    TextView txt_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_height = (EditText) findViewById(R.id.txt_height);
        txt_weight = (EditText) findViewById(R.id.txt_weight);
        txt_result = (TextView) findViewById(R.id.txt_result);
    }

    public void calculateBMI(View view){
        Float height = Float.parseFloat(txt_height.getText().toString());
        Float weight =  Float.parseFloat(txt_weight.getText().toString());

        String result = "";

        double bmi = weight / Math.pow((height/100), 2);

        if (bmi < 18.5)
            result = "Under Weight";
        else if(bmi >= 18.5 && bmi <= 24.9)
            result = "Normal Weight";
        else if(bmi >= 25 && bmi <= 29.9)
            result = "Over Weight";
        else if(bmi >= 30)
            result = "Obesity";
        txt_result.setText(bmi+"");

        Toast.makeText(getApplicationContext(), result,Toast.LENGTH_SHORT).show();
    }
}
