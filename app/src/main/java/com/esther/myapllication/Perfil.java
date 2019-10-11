package com.esther.myapllication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.Touch;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class Perfil extends AppCompatActivity {
    private Button mStorag;
    private StorageReference mStorage;
    private static final int GALlERY_INTENT =1;
    private ImageView mImageView;
    private ProgressDialog progres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);


        mStorage= FirebaseStorage.getInstance().getReference();
        mStorag = findViewById(R.id.Sf);
        mImageView = (ImageView) findViewById(R.id.subirI);
        progres = new ProgressDialog(this);

        mStorag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,GALlERY_INTENT);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== GALlERY_INTENT && resultCode == RESULT_OK){

            progres.setTitle("Subiendo...");
            progres.setMessage("Subiendo Foto ");
            progres.setCancelable(false);
            progres.show();

            final Uri uri = data.getData();
            StorageReference filePath = mStorage.child("Fotos").child(uri.getLastPathSegment());
            filePath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    progres.dismiss();
                    Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                    while (!uriTask.isSuccessful());
                    Uri downnloadUrl = uriTask.getResult();
                    Glide.with(Perfil.this)
                    .load(downnloadUrl).into(mImageView);
                    Toast.makeText(Perfil.this, "Se subió exitosamente la foto", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
