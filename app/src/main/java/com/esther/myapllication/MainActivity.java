package com.esther.myapllication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btnIngreso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnIngreso = (Button) findViewById(R.id.Inicio);
        btnIngreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Ingreso = new Intent(getApplicationContext(),Mapa.class);
                startActivity(Ingreso);
            }
        });
    }
}
