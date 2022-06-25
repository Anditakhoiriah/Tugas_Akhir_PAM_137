package com.example.lemonteekstore;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signin_admin extends AppCompatActivity {
    //Deklarasi variabel untuk button
    Button btnSignina;
    Button btnSignupa;

    //Deklarasi variabel untuk EditText
    EditText edNama, edId;

    //Deklarasi variabel untuk menyimpan email dan password
    String nama, id;

    //deklarasi variabel untuk loading bar
    private ProgressDialog loading;

    //Andita Khoiriah 20200140137
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_admin);

        loading = new ProgressDialog(this);

        //Menghubungkan variabel btnSignin dan btnSignup dengan componen button pada layout
        btnSignina = findViewById(R.id.btsignina);
        btnSignupa = findViewById(R.id.btsignupa);

        //Menghubungkan variabel edNama dengan componen button pada layout
        edNama = findViewById(R.id.editnamaa);

        //Menghubungkan variabel edid dengan componen button pada layout
        edId = findViewById(R.id.editida);


        //membuat fungsi one klik pada button btnsignup
        btnSignupa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(getApplicationContext(), Register.class);
                startActivity(login);
            }
        });


        //membuat fungsi one klik pada button btnSignin
        btnSignina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Menyimpan input user di edittext nama kedalam variabel nama
                nama = edNama.getText().toString();

                //Menyimpan input user di edittext id kedalam variabel id
                id = edId.getText().toString();

                //membuat variabel toast dan membuat toast dengan menambahkan variabel nama dan id
                Toast t = Toast.makeText(getApplicationContext(),
                        "Nama anda: " + nama + " dan ID anda: " + id + "", Toast.LENGTH_LONG);
                Bundle b = new Bundle();

                b.putString("a", nama.trim());

                Intent login = new Intent(getApplicationContext(), Home.class);
                startActivity(login);

                //memvalidasi inputan user dan menampilkan loading bar
                if (nama.isEmpty()) {
                    Toast.makeText(signin_admin.this, "Login Gagal", Toast.LENGTH_LONG).show();
                } else if (id.isEmpty()) {
                    Toast.makeText(signin_admin.this, "Login Sukses", Toast.LENGTH_SHORT).show();
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