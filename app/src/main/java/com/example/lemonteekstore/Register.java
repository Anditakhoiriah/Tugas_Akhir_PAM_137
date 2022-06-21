package com.example.lemonteekstore;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    //Deklarasi variabel untuk button
    Button btnregister;

    //Deklarasi variabel untuk EditText
    EditText edinama, ediid;

    //Deklarasi variabel untuk menyimpan nama dan id
    String nama, id;

    private ProgressDialog loading;
    private ActionBar t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        loading = new ProgressDialog(this);

        //Menghubungkan variabel edinama dengan componen button pada layout
        edinama = findViewById(R.id.enama);

        //Menghubungkan variabel ediid dengan componen button pada layout
        ediid = findViewById(R.id.eid);
        btnregister = findViewById(R.id.btregis);

        //membuat fungsi one klik pada button btnSignin
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Menyimpan input user di edittext nama kedalam variabel nama
                nama = edinama.getText().toString();

                //Menyimpan input user di edittext id kedalam variabel id
                id = ediid.getText().toString();

                //membuat variabel toast dan membuat toast dengan menambahkan variabel nama dan id
                Toast t = Toast.makeText(getApplicationContext(),
                        "Nama anda: " + nama + " dan ID anda: " + id + "", Toast.LENGTH_LONG);
                Bundle b = new Bundle();

                b.putString("a", nama.trim());

                Intent intent = new Intent(Register.this, DataAlbum.class);
                startActivity(intent);

                //memvalidasi inputan user dan menampilkan loading bar
                if (nama.isEmpty()) {
                    Toast.makeText(Register.this, "Login Gagal", Toast.LENGTH_LONG).show();
                } else if (id.isEmpty()) {
                    Toast.makeText(Register.this, "Login Sukses", Toast.LENGTH_SHORT).show();
                } else {
                    loading.setTitle("Please wait");
                    loading.setMessage("wait for a moment..");
                    loading.setCanceledOnTouchOutside(false);
                    loading.show();

                    //Menampilkan toast
                    t.show();
                }
                Intent intenta = new Intent(Register.this, DataAlbum.class);
                startActivity(intenta);
            }
        });
    }
}