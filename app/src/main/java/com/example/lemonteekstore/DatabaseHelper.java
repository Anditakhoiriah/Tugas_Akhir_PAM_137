package com.example.lemonteekstore;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.util.ArrayList;
import java.util.HashMap;

//SQLiteOpenHelper untuk membantu mengelola database
public class DatabaseHelper extends SQLiteOpenHelper {

    //membuat database dengan nama album, factory null, versi 1
    public DatabaseHelper(Context context) {
        super(context, "Album", null, 1);
    }

    //method oncreate akan dipanggil apabila sebelumnya tidak terdapat database
    public void onCreate(SQLiteDatabase db) {
        //membuat tabel Album  Nama_Album sbg primary key, Harga, dan stok
        db.execSQL("create table album (nama_album text primary key, harga int, stok int)");
    }

    //jika SQlite akan diupgrade, maka tabel akan dihapus terlebih dahulu. Dan tabel akan dibuat lagi.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //eksekusi syntax
        db.execSQL("drop table if exists album");
        //tabel dibuat lagi
        onCreate(db);
    }

    //method insert untuk menambahkan data ke dalam database
    // dengan parameter hashmap (array berpasangan)
    //ada 2 parameter berjenis string yaitu kunci dan value(nilai)
    // queryvalues sebagai nama variabel
    public void insert(HashMap<String, String> queryValues) {
        //memanggil database agar dapat dimasuki data
        SQLiteDatabase sqld = this.getWritableDatabase();
        //membuat objek value berjenis contentvalues
        //ContentValues menyimpan data sebagai pasangan kunci dan nilai
        ContentValues value = new ContentValues();
        //menambahkan baris nama_album
        value.put("nama_album", queryValues.get("nama_album"));
        //menambahkan baris harga
        value.put("harga", queryValues.get("harga"));
        //menambahkan baris stok
        value.put("stok", queryValues.get("stok"));
        //insert value ke tabel album
        sqld.insert("album", null, value);
        //menutup database
        sqld.close();
    }

    //method update untuk memperbarui data
    // dengan parameter hashmap (array berpasangan)
    //ada 2 parameter berjenis string yaitu kunci dan value(nilai)
    // queryvalues sebagai nama variabel
    public void update(HashMap<String, String> queryValues) {
        //memanggil database agar dapat dimasuki data
        SQLiteDatabase sqld = this.getWritableDatabase();
        //membuat objek value berjenis contentvalues
        //ContentValues menyimpan data sebagai pasangan kunci dan nilai
        ContentValues value = new ContentValues();
        //menambahkan baris nama_album
        value.put("nama_album", queryValues.get("nama_album"));
        //menambahkan baris stok
        value.put("stok", queryValues.get("stok"));
        //menambahkan baris harga
        value.put("harga", queryValues.get("harga"));
        //update value ke tabel album berdasarkan nama_album
        sqld.update("album", value, "nama_album" + " =?", new String[]{queryValues.get("nama_album")});
        //menutup database
        sqld.close();
    }

    //method delete untuk menghapus data
    // dengan parameter hashmap (array berpasangan)
    //ada 2 parameter berjenis string yaitu kunci dan value(nilai)
    // queryvalues sebagai nama variabel
    public int delete(HashMap<String, String> queryValues) {
        //memanggil database agar dapat dimasuki data
        SQLiteDatabase sqld = this.getWritableDatabase();
        //menghapus data berdasarkan nama_album
        return sqld.delete("album", "nama_album" + " =?", new String[]{queryValues.get("nama_album")});
    }

    //method untuk menghapus semua data
    void deleteall(){
        //memanggil database agar dapat dimasuki data
        SQLiteDatabase sqld = this.getWritableDatabase();
        //eksekusi syntax hapus semua data pada tabel
        sqld.execSQL("DELETE FROM album" );
    }

    //method getAllPengeluaran tipe ArrayList
    public ArrayList<HashMap<String, String>> getAllalbum() {
        //membuat objek Listalbum berjenis ArrayList
        ArrayList<HashMap<String, String>> Listalbum;
        Listalbum = new ArrayList<HashMap<String, String>>();
        //query untuk menampilkan semua data dari tabel album
        String selectQuery = "Select * from album";
        //memanggil database agar dapat dilihat isi database-nya
        SQLiteDatabase sqld = this.getReadableDatabase();
        //rawQuery untuk mengirimkan perintah selectQuery kemudian disimpan dalam cursor
        Cursor cursor = sqld.rawQuery(selectQuery, null);
        //posisi cursor pada record pertama
        if (cursor.moveToFirst()) {
            do {
                //membuat objek map
                HashMap<String, String> map = new HashMap<>();
                //mengambil data nama_album ke indeks pertama
                map.put("nama_album", cursor.getString(0));
                //mengambil data harga ke indeks kedua
                map.put("harga", cursor.getString(1));
                //mengambil data stok ke indeks ketiga
                map.put("stok", cursor.getString(2));

                //menambahkan map ke Listalbum
                Listalbum.add(map);

            } while (cursor.moveToNext()); //cursor beralih ke record selanjutnya
        }
        //menutup database
        sqld.close();
        //mengembalikan Listalbum ke getAllalbum
        return Listalbum;
    }
}