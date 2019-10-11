package com.esther.myapllication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TienesF extends AppCompatActivity {
    private Button btsalida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tienes_f);
 btsalida =(Button) findViewById(R.id.Se1);
 btsalida.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         Intent sa = new Intent(getApplicationContext(),Mapa.class);
         startActivity(sa);
     }
 });
    }
}
