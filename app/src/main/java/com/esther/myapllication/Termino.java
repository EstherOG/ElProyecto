package com.esther.myapllication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Termino extends AppCompatActivity {
private Button Env;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_termino);
        Env = (Button) findViewById(R.id.salir3);
        Env.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent env = new Intent(getApplicationContext(),Mapa.class);
                startActivity(env);
            }
        });

    }
}
