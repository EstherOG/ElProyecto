package com.esther.myapllication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    private static final String TAG ="Antud" ;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private EditText TextEmail, TextPass;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextEmail = (EditText) findViewById(R.id.log1);
        TextPass = (EditText) findViewById(R.id.log2);
        mAuth = FirebaseAuth.getInstance();
        login = (Button) findViewById(R.id.log3);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usuario = TextEmail.getText().toString().trim();
                String password = TextPass.getText().toString().trim();
                if (TextUtils.isEmpty(usuario)) {
                    Toast.makeText(Login.this, "Se debe ingresar un usuario", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(Login.this, "Ingresar una contraseña", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.length() < 6) {
                    Toast.makeText(Login.this, "La contraseña es muy corta", Toast.LENGTH_LONG).show();
                }
                mAuth.signInWithEmailAndPassword(usuario, password).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {


                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(getApplicationContext(), Perfil.class));

                        } else {
                            Toast.makeText(Login.this, "El usuario no existe", Toast.LENGTH_LONG).show();
                        }
                    }


                });
                logearUsuario();
            }
        });
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser()!=null){
                    startActivity(new Intent(Login.this, Perfil.class));
                } else{
                    Toast.makeText(Login.this,"Datos incorrectos", Toast.LENGTH_LONG).show();
                }
            }

        };



        }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }
        private  void logearUsuario(){
        String email = TextEmail.getText().toString();
        String password = TextPass.getText().toString();
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            Log.d(TAG, "createUserWithEmail:success" + task.isSuccessful());
                            if (!task.isSuccessful()) {
                                Toast.makeText(Login.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();


                            }

                            // ...
                        }
                    });
        }
    }

