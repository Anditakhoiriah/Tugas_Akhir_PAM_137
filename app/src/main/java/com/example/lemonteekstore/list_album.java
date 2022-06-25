package com.example.lemonteekstore;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;

public class list_album extends AppCompatActivity {
    //deklarasi variabel recyclerview
    private RecyclerView recyclerView;
    //deklarasi adapter
    private Adapter adapter;
    //deklarasi arraylist dari class album
    private ArrayList<album> albumArrayList;
    //deklarasi dbhelp dari class DatabaseHelper
    DatabaseHelper dbhelp = new DatabaseHelper(this);
    //deklarasi floatingactionbutton
    private FloatingActionButton buttonadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_album2); //mengeset layout activity_data_album

        //menghubungkan recyclerView dengan recyclerView pada layout
        recyclerView = findViewById(R.id.recyclerView);
        //menghubungkan buttonadd dengan floatingBtn pada layout
        buttonadd = findViewById(R.id.floatingBtn);

        //memanggil method getData
        getData();
        //membuat objek adapter berupa arraylist
        adapter = new Adapter(albumArrayList);
        //membuat objek layoutmanager berupa linearlayout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(list_album.this);
        //mengeset layoutmanager
        recyclerView.setLayoutManager(layoutManager);
        //mengeset adapter
        recyclerView.setAdapter(adapter);
        //apabila button add di click
        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //membuat objek intent untuk berpindah ke class order
                Intent intent = new Intent(list_album.this, User_Order.class);
                //memulai berpindah
                startActivity(intent);
            }
        });
    }

    private void getData() {
        //membuat objek daftaralbum dari class DatabaseHelper
        ArrayList<HashMap<String, String>> daftaralbum = dbhelp.getAllalbum();
        albumArrayList = new ArrayList<>();
        //perulangan untuk membaca indeks dari daftaralbum
        for (int i = 0; i < daftaralbum.size(); i++) {
            //membuat objek album
            album album = new album();

            //mengisi dan mengambil data nama_album
            album.setNama_album(daftaralbum.get(i).get("nama_album").toString());
            //mengisi dan mengambil data stok
            album.setstok(daftaralbum.get(i).get("stok").toString());
            //mengisi dan mengambil data Harga
            album.setHarga(daftaralbum.get(i).get("harga").toString());
            //memindahkan semua yang ada pada pengeluaran ke albumArrayList
            albumArrayList.add(album);
        }
    }
}