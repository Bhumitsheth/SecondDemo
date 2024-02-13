package com.bhumit.seconddemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity3 extends AppCompatActivity {


    String value;
    EditText et_n1, et_n2;
    Button btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        et_n1 = findViewById(R.id.et_n1);
        et_n2 = findViewById(R.id.et_n2);
        btn_next = findViewById(R.id.btn_next_2);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = extras.getString("key");
            et_n1.setText(value);
        }


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result1 = et_n1.getText().toString();
                String result2 = et_n2.getText().toString();
                Intent resultIntent = new Intent(MainActivity3.this,MainActivity.class);
                resultIntent.putExtra("result1", result1);
                resultIntent.putExtra("result2", result2);
                startActivity(resultIntent);
                finish();
            }
        });


    }


}