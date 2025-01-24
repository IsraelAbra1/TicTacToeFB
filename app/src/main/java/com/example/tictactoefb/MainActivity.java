package com.example.tictactoefb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnPlaySameCellular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlaySameCellular = findViewById(R.id.btnPlaySameCellular);
        btnPlaySameCellular.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnPlaySameCellular)
        {
            Intent intent = new Intent(this, GameActivity.class);
            startActivity(intent);
        }
    }
}