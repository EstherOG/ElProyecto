package com.esther.myapllication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Filtro extends AppCompatActivity {
private Button btnLo ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtro);
        btnLo =(Button) findViewById(R.id.b1);
        btnLo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent local = new Intent(getApplicationContext(),Funda.class);
                startActivity(local);
            }
        });
    }
}
