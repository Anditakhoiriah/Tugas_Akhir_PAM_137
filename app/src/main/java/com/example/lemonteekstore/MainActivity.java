package com.example.lemonteekstore;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Deklarasi variabel untuk button
    Button btnSigninb;
    Button btnSignupb;

    //Deklarasi variabel untuk EditText
    EditText edNamab, edIdb;

    //Deklarasi untuk textview
    TextView adminlink;

    //Deklarasi variabel untuk menyimpan email dan password
    String nama, id;

    //deklarasi variabel untuk loading bar
    private ProgressDialog loading;

    //Andita Khoiriah 20200140137
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loading = new ProgressDialog(this);

        //Menghubungkan variabel btnSignin dan btnSignup dengan componen button pada layout
        btnSigninb = findViewById(R.id.btsigninb);
        btnSignupb = findViewById(R.id.btsignupb);

        //Menghubungkan variabel edNama dengan componen button pada layout
        edNamab = findViewById(R.id.editnamab);

        //Menghubungkan variabel edid dengan componen button pada layout
        edIdb = findViewById(R.id.editidb);

        //menghubungkan variabel adminlink dengan button di layout
        adminlink = findViewById(R.id.lgadmin);

        //membuat fungsi one klik pada button adminlink
        adminlink.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View view) {
               Intent login = new Intent(getApplicationContext(), signin_admin.class);
               startActivity(login);
           }
        });

        //membuat fungsi one klik pada button btnsignup
        btnSignupb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(getApplicationContext(), Register.class);
                startActivity(login);
            }
        });

        //membuat fungsi one klik pada button btnSignin
        btnSigninb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Menyimpan input user di edittext nama kedalam variabel nama
                nama = edNamab.getText().toString();

                //Menyimpan input user di edittext id kedalam variabel id
                id = edIdb.getText().toString();

                //membuat variabel toast dan membuat toast dengan menambahkan variabel nama dan id
                Toast t = Toast.makeText(getApplicationContext(),
                        "Nama anda: " + nama + " dan ID anda: " + id + "", Toast.LENGTH_LONG);
                Bundle a = new Bundle();

                a.putString("a", nama.trim());

                Intent loginb = new Intent(getApplicationContext(), user_home.class);
                startActivity(loginb);

                //memvalidasi inputan user dan menampilkan loading bar
                if (nama.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Login Gagal", Toast.LENGTH_LONG).show();
                } else if (id.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Login Sukses", Toast.LENGTH_SHORT).show();
                } else {
                    loading.setTitle("Please wait");
                    loading.setMessage("wait for a moment..");
                    loading.setCanceledOnTouchOutside(false);
                    loading.show();

                    //Menampilkan toast
                    t.show();
                }
            }
        });
    }
}