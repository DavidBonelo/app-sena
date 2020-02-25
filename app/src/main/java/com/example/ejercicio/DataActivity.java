package com.example.ejercicio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DataActivity extends AppCompatActivity {
    TextView tvdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        tvdata = findViewById(R.id.tvdata);

        String dataname = getIntent().getStringExtra("name"),
                datalname = getIntent().getStringExtra("lname"),
                datamail = getIntent().getStringExtra("mail"),
                dataphone = getIntent().getStringExtra("phone"),
                datapass = getIntent().getStringExtra("pass");

        tvdata.setText(dataname + "\n" + datalname + "\n" + datamail + "\n" + dataphone + "\n" + datapass);
    }
}