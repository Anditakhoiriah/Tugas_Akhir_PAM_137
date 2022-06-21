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
    public static Object ma;
    //Deklarasi variabel untuk button
    Button btnSignin;
    Button btnSignup;

    //Deklarasi variabel untuk EditText
    EditText edNama, edId;

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
        btnSignin = findViewById(R.id.btsignin);
        btnSignup = findViewById(R.id.btsignup);

        //Menghubungkan variabel edNama dengan componen button pada layout
        edNama = findViewById(R.id.editnama);

        //Menghubungkan variabel edid dengan componen button pada layout
        edId = findViewById(R.id.editid);

        //menghubungkan variabel adminlink dengan button di layout
        adminlink = findViewById(R.id.lgadmin);

        //membuat fungsi one klik pada button btnsignup
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(getApplicationContext(), Register.class);
                startActivity(login);
            }
        });

        //membuat fungsi one klik pada button adminlink
        adminlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnSignin.setText("Login Admin");
                btnSignup.setText("Signup Admin");
                adminlink.setVisibility(View.INVISIBLE);
            }
        });
        btnSignin.setOnClickListener(new View.OnClickListener() {
            private Intent b;

            @Override
            public void onClick(View view) {
                Intent loginb = new Intent(getApplicationContext(), Home.class);
                loginb.putExtras(b);
                startActivity(loginb);
            }
        });


        //membuat fungsi one klik pada button btnSignin
        btnSignin.setOnClickListener(new View.OnClickListener() {
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

                Intent login = new Intent(getApplicationContext(), Home_User.class);
                login.putExtras(b);
                startActivity(login);

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