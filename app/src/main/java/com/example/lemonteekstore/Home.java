package com.example.lemonteekstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {
    //Deklarasi variabel untuk button
    Button btdata;
    Button bttransaksi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btdata = findViewById(R.id.btnedit);
        bttransaksi = findViewById(R.id.btntransaksi);

        Bundle a = new Bundle();

        btdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent data = new Intent(Home.this, DataAlbum.class);
                startActivity(data);
            }
        });
        bttransaksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent transaksi = new Intent(getApplicationContext(), Admin_Transaksi.class);
                Intent a = null;
                transaksi.putExtras(a);
                startActivity(transaksi);
            }
        });
    }
}
