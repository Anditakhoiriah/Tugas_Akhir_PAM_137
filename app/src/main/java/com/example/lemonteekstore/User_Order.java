package com.example.lemonteekstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class User_Order extends AppCompatActivity {
    //Deklarasi variabel untuk button
    Button btorder;

    //Deklarasi variabel untuk EditText
    EditText edNama, edphone, edalbum, edjumlah, edhome;


    //Deklarasi variabel untuk menyimpan nama, phone and home
    String nama, phone, album, jumlah, home;

    //Andita Khoiriah 20200140137
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_order);

        //Menghubungkan variabel btnconfirm dengan componen button pada layout
        btorder = findViewById(R.id.buttonorder);

        //Menghubungkan variabel edit text dengan componen button pada layout
        edNama = findViewById(R.id.nama_pembeli);
        edphone = findViewById(R.id.nohp_pembeli);
        edalbum = findViewById(R.id.nama_album);
        edjumlah = findViewById(R.id.jumlah_order);
        edhome = findViewById(R.id.alamat_pembeli);


        //membuat fungsi one klik pada button btnorder
        btorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Menyimpan input user di edittext nama kedalam variabel
                nama = edNama.getText().toString();
                phone = edphone.getText().toString();
                album = edalbum.getText().toString();
                jumlah = edjumlah.getText().toString();
                home = edhome.getText().toString();

                Intent i = null;
                i = new Intent(User_Order.this, Admin_Transaksi.class);
                Bundle bundle = new Bundle();
                bundle.putString("parse_nama",nama);
                bundle.putString("parse_nohp",phone);
                bundle.putString("parse_album",album);
                bundle.putString("parse_jumlah",jumlah);
                bundle.putString("parse_alamat",home);

                i.putExtras(bundle);
                startActivity(i);

            }
        });

    }
}