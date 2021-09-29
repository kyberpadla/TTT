package com.example.pr1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView txt;
    TextView txt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt = findViewById(R.id.textview);
        txt2= findViewById(R.id.textview2);
        Bundle argument = getIntent().getExtras();
        txt.setText(argument.get("Value").toString());
        txt2.setText("Ходов:" + argument.get("Turns").toString());

    }
}