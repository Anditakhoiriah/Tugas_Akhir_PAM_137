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

public class DataAlbum extends AppCompatActivity {
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
        setContentView(R.layout.activity_data_album2); //mengeset layout activity_user_produk

        //menghubungkan recyclerView dengan recyclerView pada layout
        recyclerView = findViewById(R.id.recyclerView);
        //menghubungkan buttonadd dengan floatingBtn pada layout
        buttonadd = findViewById(R.id.floatingBtn);

        //memanggil method getData
        getData();
        //membuat objek adapter berupa arraylist
        adapter = new Adapter(albumArrayList);
        //membuat objek layoutmanager berupa linearlayout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DataAlbum.this);
        //mengeset layoutmanager
        recyclerView.setLayoutManager(layoutManager);
        //mengeset adapter
        recyclerView.setAdapter(adapter);
        //apabila button add di click
        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //membuat objek intent untuk berpindah ke class admin add
                Intent intent = new Intent(DataAlbum.this, Admin_Add.class);
                //memulai berpindah
                startActivity(intent);
            }
        });
    }

    private void getData() {
        //membuat objek daftarPengeluaran dari class DatabaseHelper
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
            album.setHarga(daftaralbum.get(i).get("album").toString());
            //memindahkan semua yang ada pada pengeluaran ke albumArrayList
            albumArrayList.add(album);
        }
    }

    //membuat option menu delete
    public boolean onCreateOptionsMenu(Menu menu) {
        //membuat objek inflater
        MenuInflater inflater = getMenuInflater();
        //method untuk menampilkan menu
        inflater.inflate(R.menu.itemdelete, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //apabila menu di klik
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //apabila menu delete di klik
        if (item.getItemId() == R.id.deleteic) {
            //memanggil method confirmAlert
            confirmAlert();
        }
        return super.onOptionsItemSelected(item);
    }

    void confirmAlert() {
        //membuat alertdialog dengan nama builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //membuat judul pada alert
        builder.setTitle("HAPUS SEMUA DATA ALBUM");
        //membuat isi dari alert
        builder.setMessage("Anda yakin ingin menghapus semua data album?");
        //apabila klik Ya pada alert
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //memanggil class DatabaseHelper
                DatabaseHelper dbhelp = new DatabaseHelper(DataAlbum.this);
                //memanggil method deleteall pada DatabaseHelper
                dbhelp.deleteall();
                //membuat objek intent untuk berpindah ke class DataPengeluaran
                Intent intent = new Intent(DataAlbum.this, DataAlbum.class);
                //memulai berpindah
                startActivity(intent);
                //mengakhiri activity
                finish();
            }
        });
        //apabila klik Tidak pada alert
        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //menutup alert dialog dan tidak terjadi apa-apa
            }
        });
        builder.create().show(); //membuat dan menampilkan alert
    }
}