package com.example.week2day1hw;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvDisplay;
    String carColor;
    String carYear;
    String carMake;
    String carModel;
    String carEngine;
    String carTrans;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDisplay = findViewById(R.id.tvDisplay);
    }

    public void goToRegistration() {
        Intent intent = new Intent(this, CarRegistration.class);
        startActivityForResult(intent, 100);

    }



    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnEnterCarInfo:
                goToRegistration();
                break;

            case R.id.btnDisplayCarInfo:
                tvDisplay.setText(carYear + " " +carMake + " " +carModel + " " + carColor + " " + carEngine + " "+ carTrans);



        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {

            case 100:
                //    Intent intent = getIntent();
                Bundle passedBundle = data.getExtras();  //gets the car object data from registration activity and saves it to pAssedbundle
                //
                Car car = passedBundle.getParcelable("car"); //saves passed bundle

                carColor = car.getColor();
                carMake = car.getMake();
                carModel = car.getModel();
                carYear = car.getYear();
                carEngine = car.getEngine();
                carTrans = car.getTransType();

                // tvDisplay.setText(carInfo);
        }

    }
}
