package com.example.lemonteekstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class user_home extends AppCompatActivity {

    //Deklarasi variabel untuk button
    Button btalbum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        btalbum = findViewById(R.id.btnalbum);


        btalbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent data = new Intent(user_home.this, list_album.class);
                startActivity(data);
            }
        });

    }
}