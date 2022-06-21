package com.example.lemonteekstore;

//sebagai wadah data aplikasi
public class album {
    //deklarasi string
    String nama_album;
    String stok;
    String harga;

    //konstruktor album tanpa parameter
    public album() {
    }

    //Konstruktoralbum dengan parameter
    public album(String nama_album, String stok, String harga) {
        this.nama_album = nama_album;
        this.stok = stok;
        this.harga = harga;
    }

    //Generate Getter and Setter
    //method get untuk mengembalikan nilai ke variabel string
    //method set untuk mengisi data ke variabel string
    public String getNama_album() {
        return nama_album;
    }

    public void setNama_album(String nama_album) {
        this.nama_album = nama_album;
    }

    public String getstok() {
        return stok;
    }

    public void setstok(String stok) {
        this.stok = stok;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

}