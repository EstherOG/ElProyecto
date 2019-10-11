package com.esther.myapllication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {
    Button  btnPerfil, btnfiltro, btntienes, btnidioma, btncontacto, btntermino,btncomen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btnPerfil = (Button) findViewById(R.id.men2);
        btnPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent perfil = new Intent(getApplicationContext(),Login.class);
                startActivity(perfil);
            }
        });
btnfiltro = (Button) findViewById(R.id.men1);
btnfiltro.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent filtro = new Intent(getApplicationContext(),Filtro.class);
        startActivity(filtro);
    }
});
        btntienes = (Button) findViewById(R.id.men3);
        btntienes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tienes = new Intent(getApplicationContext(),TienesF.class);
                startActivity(tienes);
            }
        });

        btnidioma = (Button) findViewById(R.id.men4);
        btnidioma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent idioma = new Intent(getApplicationContext(),Idioma.class);
                startActivity(idioma);
            }
        });
        btncontacto = (Button) findViewById(R.id.men5);
        btncontacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contac = new Intent(getApplicationContext(),Contacto.class);
                startActivity(contac);
            }
        });
        btntermino = (Button) findViewById(R.id.men7);
        btnfiltro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent terminn = new Intent(getApplicationContext(),Termino.class);
                startActivity(terminn);
            }
        });
        btncomen= (Button) findViewById(R.id.men6);
        btncomen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent comen = new Intent(getApplicationContext(),Comentario.class);
                startActivity(comen);
            }
        });
    }

}
