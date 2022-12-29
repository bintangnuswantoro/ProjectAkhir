package com.example.projectakhir;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

Button informasi,sewa,profile, exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        informasi = findViewById(R.id.btn_info_buku);
        sewa = findViewById(R.id.btn_sewa);
        profile = findViewById(R.id.profile);
        exit = findViewById(R.id.btn_logout);

        informasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DaftarBukuActivity.class);
                startActivity(intent);
            }
        });
        sewa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PenyewaActivity.class);
                startActivity(intent);
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }


}