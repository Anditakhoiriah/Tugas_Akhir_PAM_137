package com.example.lemonteekstore;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

public class Admin_Update extends AppCompatActivity {
    //deklarasi variabel textinputedittext
    private TextInputEditText ednama_album, edstok, edHarga;
    //deklarasi button
    private Button btnupdate, btndelete;
    //deklarasi variabel string nama_album, stok, harga
    String nama_album, stok, harga;
    //deklarasi dbhelp dari class DatabaseHelper
    DatabaseHelper dbhelp = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_update);

        //menghubungkan nama_album dengan nama_album pada layout
        ednama_album = findViewById(R.id.ednama_album);
        //menghubungkan edstok dengan edstok pada layout
        edstok = findViewById(R.id.edstok);
        //menghubungkan edHarga dengan edharga pada layout
        edHarga = findViewById(R.id.edharga);
        //menghubungkan btnupdate dengan btnupdate pada layout
        btnupdate = findViewById(R.id.btnupdate);
        //menghubungkan btndelete dengan btndelete pada layout
        btndelete = findViewById(R.id.btndelete);

        //menangkap dan mengambil nilai nama_album dari class pengirim
        nama_album = getIntent().getStringExtra("nama_album");
        //menangkap dan mengambil nilai stok dari class pengirim
        stok = getIntent().getStringExtra("stok");
        //menangkap dan mengambil nilai harga dari class pengirim
        harga = getIntent().getStringExtra("harga");

        //menampilkan teks sebelumnya pada ednama_album
        ednama_album.setText(nama_album);
        //menampilkan teks sebelumnya pada edstok
        edstok.setText(stok);
        //menampilkan teks sebelumnya pada edHarga
        edHarga.setText(harga);

        //jika btnupdate di click
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //jika textinputedittext nama_album dan harga kosong
                //maka akan menampilkan toast "Kolom nama_album dan Harga wajib diisi"
                if (ednama_album.getText().toString().equals("") || edHarga.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Kolom Nama Album dan Harga wajib diisi", Toast.LENGTH_SHORT).show();
                } else {
                    //membaca isi dari edittext nama album
                    nama_album = ednama_album.getText().toString();
                    //membaca isi dari edittext stok
                    stok = edstok.getText().toString();
                    //membaca isi dari edittext harga
                    harga = edHarga.getText().toString();

                    //membuat objek val berbentuk array hashmap
                    HashMap<String, String> val = new HashMap<>();
                    //memasukkan data pada kolom nama album
                    val.put("nama_album", nama_album);
                    //memasukkan data pada kolom judul
                    val.put("stok", stok);
                    //memasukkan data pada kolom harga
                    val.put("harga", harga);

                    //memanggil method update dari class DatabaseHelper
                    dbhelp.update(val);
                    //menampikkan toast bahwa data berhasil diperbarui
                    Toast.makeText(getApplicationContext(), "Data Berhasil Diperbarui",
                            Toast.LENGTH_LONG).show();
                    //membuat objek intent untuk berpindah ke class DataPengeluaran
                    Intent intent = new Intent(Admin_Update.this, DataAlbum.class);
                    //memulai berpindah
                    startActivity(intent);
                    //mengakhiri activity
                    finish();
                }
            }
        });

        //jika btndelete di click
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //membuat alertdialog dengan nama builder
                AlertDialog.Builder builder = new AlertDialog.Builder(Admin_Update.this);
                //membuat isi dari alert
                builder.setMessage("Anda yakin ingin menghapus data ini ?");
                //apabila klik Ya pada alert
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        //membuat objek val berbentuk array hashmap
                        HashMap<String, String> val = new HashMap<>();
                        //memasukkan data pada kolom nama_album
                        val.put("nama_album", nama_album);
                        //memanggil method delete dari class DatabaseHelper
                        dbhelp.delete(val);
                        //menampikkan toast bahwa data berhasil dihapus
                        Toast.makeText(getApplicationContext(), "Data Berhasil Dihapus", Toast.LENGTH_LONG).show();
                        //membuat objek intent untuk berpindah ke class DataPengeluaran
                        Intent intent = new Intent(Admin_Update.this, DataAlbum.class);
                        //memulai berpindah
                        startActivity(intent);
                        //mengakhiri activity
                        finish();
                    }
                });
                //apabila klik Tidak pada alert
                builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        //menutup alert dialog dan tidak terjadi apa-apa
                    }
                });
                builder.create().show(); //membuat dan menampilkan alert
            }
        });
    }
}