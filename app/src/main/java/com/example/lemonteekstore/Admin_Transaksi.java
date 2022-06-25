package com.example.lemonteekstore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lemonteekstore.R;

public class Admin_Transaksi extends AppCompatActivity {

    TextView Tnama,Tphone, Talbum, Tjumlah, Thome;

    String nama, phone, album, jumlah, home;

    Button menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_transaksi);

        Tnama = findViewById(R.id.tampilnama);
        Tphone = findViewById(R.id.tampilnohp);
        Talbum = findViewById(R.id.tampilalbum);
        Tjumlah = findViewById(R.id.tampiljumlah);
        Thome = findViewById(R.id.tampilalamat);
        menu = findViewById(R.id.button);

        Bundle bundle = getIntent().getExtras();

        nama = bundle.getString("parse_nama");
        phone = bundle.getString("parse_nohp");
        album = bundle.getString("parse_album");
        jumlah = bundle.getString("parse_jumlah");
        home = bundle.getString("parse_alamat");

        Tnama.setText(nama);
        Tphone.setText(phone);
        Talbum.setText(album);
        Tjumlah.setText(jumlah);
        Thome.setText(home);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menu = new Intent(Admin_Transaksi.this, user_home.class);
                startActivity(menu);
            }
        });
    }
}