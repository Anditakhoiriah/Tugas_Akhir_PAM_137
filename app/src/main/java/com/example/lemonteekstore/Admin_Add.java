package com.example.lemonteekstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class Admin_Add extends AppCompatActivity {
    //deklarasi variabel textinputedittext
    private EditText edalbum, edharga, edstok;
    //deklarasi button
    private Button btnadd;
    //deklarasi variabel string nama_album, stok, harga
    String nama_album,stok,harga;
    //deklarasi dbhelp dari class DatabaseHelper
    DatabaseHelper dbhelp = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_add);

        //menghubungkan edalbum dengan editalbum pada layout
        edalbum = findViewById(R.id.editalbum);
        //menghubungkan edharga dengan editharga pada layout
        edharga = findViewById(R.id.editharga);
        //menghubungkan edstok dengan editstok pada layout
        edstok = findViewById(R.id.editstok);
        //menghubungkan btnadd dengan buttonnadd pada layout
        btnadd = findViewById(R.id.buttonadd);
        //apabila btnadd di click
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //jika textinputedittext nama_alabum dan harga kosong
                //maka akan menampilkan toast "Kolom nama_album dan Harga wajib diisi"
                if (edalbum.getText().toString().equals("")||edharga.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Kolom nama album dan harga wajib diisi",Toast.LENGTH_SHORT).show();
                } else {
                    //membaca isi dari edittext nama album
                    nama_album = edalbum.getText().toString();
                    //membaca isi dari edittext harga
                    harga = edharga.getText().toString();
                    //membaca isi dari edittext stok
                    stok = edstok.getText().toString();

                    //membuat objek val berbentuk array hashmap
                    HashMap<String, String> val = new HashMap<>();
                    //memasukkan data pada kolom nama_album
                    val.put("nama_album", nama_album);
                    //memasukkan data pada kolom harga
                    val.put("harga", harga);
                    //memasukkan data pada kolom stok
                    val.put("stok", stok);

                    //memanggil method insert dari class DatabaseHelper
                    dbhelp.insert(val);
                    //menampikkan toast bahwa data berhasil ditambahkan
                    Toast.makeText(getApplicationContext(), "Data Berhasil Ditambahkan", Toast.LENGTH_LONG).show();

                    //membuat objek intent untuk berpindah ke class dataalbum
                    Intent move = new Intent(Admin_Add.this, album.class);
                    //memulai berpindah
                    startActivity(move);
                    //mengakhiri activity
                    finish();
                }
            }
        });
    }
}