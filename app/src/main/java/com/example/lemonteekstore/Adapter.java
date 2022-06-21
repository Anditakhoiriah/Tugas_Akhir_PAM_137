package com.example.lemonteekstore;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//class adapter untuk recyclerview yang memiliki MyViewHolder untuk menampilkan isinya
public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    //deklarasi variabel listpengeluaran dari class Pengeluaran
    private ArrayList<album> listalbum;
    //deklarasi variabel context
    private Context context;

    //membuat konstruktor pada class Adapter
    public Adapter(ArrayList<album> listalbum) {
        this.listalbum = listalbum;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //membuat objek viewholder
        //mendapatkan context dari parent
        context = parent.getContext();
        //membuat objek layoutInf berjenis LayoutInflater dari context
        LayoutInflater layoutInf = LayoutInflater.from(parent.getContext());
        //untuk memanggil tampilan dari layout row_pengeluaran
        View view = layoutInf.inflate(R.layout.row_album,parent,false);
        //pengembalian
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) { //menghubungkan data yang ada pada viewholder
        //deklarasi variabel string
        String nama_album, harga,stok;

        //mengambil data nama_album sesuai posisi yang telah ditentukan
        nama_album = listalbum.get(position).getNama_album();
        //mengambil data stok sesuai posisi yang telah ditentukan
        stok = listalbum.get(position).getstok();
        //mengambil data harga sesuai posisi yang telah ditentukan
        harga = listalbum.get(position).getHarga();
        DatabaseHelper dbhelp = new DatabaseHelper(context);

        //holder menampilkan teks nama_album
        holder.nama_album.setText(nama_album);
        //holder menampilkan teks keterangan
        holder.stok.setText(stok);
        //holder menampilkan teks harga
        holder.harga.setText(harga);

        //jika cardku diklik
        holder.cardku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //membuat objek intent untuk berpindah ke class Admin_Update
                Intent intent = new Intent(context, Admin_Update.class);
                //mengirimkan data nama_album ke class yang dituju
                intent.putExtra("nama_album", nama_album);
                //mengirimkan data stok ke class yang dituju
                intent.putExtra("stok", stok);
                //mengirimkan data harga ke class yang dituju
                intent.putExtra("harga", harga);
                //memulai berpindah
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() { //menentukan jumlah item yang akan ditampilkan
        //Jika listalbum tidak kosong, maka tampilkan jumlah datanya
        return (listalbum != null)?listalbum.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder { //item yang akan ditampilkan pada recyclerview
        //deklarasi cardview
        private CardView cardku;
        //deklarasi textview
        private TextView nama_album, stok, harga;
        public MyViewHolder(View view) {
            super(view);
            //menghubungkan cardview dari java class pada layout
            cardku = (CardView) view.findViewById(R.id.Kartu);
            //menghubungkan textview nama_album dari java class pada layout
            nama_album = (TextView) view.findViewById(R.id.tv_nama_album);
            //menghubungkan textview keterangan dari java class pada layout
            stok = (TextView) view.findViewById(R.id.tv_stok);
            //menghubungkan textview harga dari java class pada layout
            harga = (TextView) view.findViewById(R.id.tv_harga);
        }
    }
}