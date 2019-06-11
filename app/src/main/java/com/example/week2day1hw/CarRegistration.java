package com.example.week2day1hw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CarRegistration extends AppCompatActivity {
    EditText etYear;
    EditText etMake;
    EditText etModel;
    EditText etColor;
    EditText etEngine;
    EditText etTransType;
    Intent passedIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //links edit texts
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_registration);
        etYear = findViewById(R.id.etYear);
        etMake = findViewById(R.id.etMake);
        etModel = findViewById(R.id.etModel);
        etColor = findViewById(R.id.etColor);
        etEngine = findViewById(R.id.etEngine);
        etTransType = findViewById(R.id.etTransType);
        passedIntent= getIntent(); // on create

    }


    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btnSubmit:
                String year = etYear.getText().toString();
                String make = etMake.getText().toString();
                String model = etModel.getText().toString();
                String color = etColor.getText().toString();
                String engine = etEngine.getText().toString();
                String transType = etTransType.getText().toString();
                Car passedCar = new Car(year,make,model,color,engine,transType); //passed car will be passed
                Bundle bundle = new Bundle(); // new bundle to handle passing
                bundle.putParcelable("car",passedCar); // puts passed car into the parcelable
                passedIntent.putExtras(bundle);
                break;
        }
        setResult(200, passedIntent ); //sets as result
        finish();
    }

}
