package com.example.projectakhir;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DetailBukuActivity extends AppCompatActivity {

    protected Cursor cursor;
    String aMerk, aHarga, aGambar;
    DataHelper dbHelper;

    @SuppressLint("SettextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_buku);

        Bundle terima = getIntent().getExtras();

        dbHelper = new DataHelper(this);
        Intent intent = getIntent();

        String merk = terima.getString("merk");

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("select * from buku where merk = '" + merk + "'", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            aMerk = cursor.getString(0);
            aHarga = cursor.getString(1);
        }

        if (aMerk.equals("Manga")) {
            aGambar = "manga";
        } else if (aMerk.equals("Novel")) {
            aGambar = "novel";
        } else if (aMerk.equals("Pemrograman")) {
            aGambar = "pemrograman";
        } else if (aMerk.equals("Antologi")) {
            aGambar = "antologi";
        } else if (aMerk.equals("Biografi")) {
            aGambar = "biografi";
        } else if (aMerk.equals("Dongeng")) {
            aGambar = "dongeng";
        } else if (aMerk.equals("Ensiklopedia")) {
            aGambar = "ensiklopedia";
        } else if (aMerk.equals("History")) {
            aGambar = "history";
        } else if (aMerk.equals("Komik")) {
            aGambar = "komik";
        }

        ImageView ivGambar = findViewById(R.id.fotoBuku);
        TextView tvMerk = findViewById(R.id.JnsBuku);
        TextView tvHarga = findViewById(R.id.hargaBuku);

        tvMerk.setText(aMerk);
        ivGambar.setImageResource(getResources().getIdentifier(aGambar, "drawable", getPackageName()));
        tvHarga.setText("Rp. " + aHarga);

        setupToolbar();
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.tbDetailBuku);
        toolbar.setTitle("Detail buku");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void telepon(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone=6281393995328"));
        startActivity(intent);
    }
}
