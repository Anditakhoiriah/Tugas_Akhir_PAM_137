package com.example.lemonteekstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home_User extends AppCompatActivity {
    //Deklarasi variabel untuk button
    Button btdaftar;
    Button btorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btdaftar = findViewById(R.id.btndaftar);
        btorder = findViewById(R.id.btnorder);

        Bundle a = new Bundle();

        btdaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent data = new Intent(getApplicationContext(), DataAlbum.class);
                data.putExtras(a);
                startActivity(data);
            }
        });
        btorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent transaksi = new Intent(getApplicationContext(), User_Order.class);
                Intent a = null;
                transaksi.putExtras(a);
                startActivity(transaksi);
            }
        });
    }
}
