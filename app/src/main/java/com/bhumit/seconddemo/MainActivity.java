package com.bhumit.seconddemo;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView img_sum, img_newData;

    String value1, value2;
    String sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        img_sum = findViewById(R.id.img_sum);
        img_newData = findViewById(R.id.img_newData);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value1 = extras.getString("result1");
            value2 = extras.getString("result2");
            int no1 = Integer.parseInt(value1);
            int no2 = Integer.parseInt(value2);
            int res = no1 + no2;
            sum = String.valueOf(res);
        }


        img_newData.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        });

        img_sum.setOnClickListener(v -> {
            if (!(sum == null)) {
                Toast.makeText(MainActivity.this, "No1: " + value1 + " No2: " + value2 + " Sum: " + sum, Toast.LENGTH_LONG).show();
            }

        });


    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }

}