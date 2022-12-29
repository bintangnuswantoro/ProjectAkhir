package com.example.projectakhir;

import android.R.layout;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class DaftarBukuActivity extends AppCompatActivity implements ListBukuAdapter.OnBukuListener {


    String[] daftar;
    RecyclerView RecyclerView1;
    protected Cursor cursor;
    DataHelper dbcenter;
    public static DaftarBukuActivity m;

    private RecyclerView rvBuku;
    private ArrayList<Buku> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buku);
        m = this;
        dbcenter = new DataHelper(this);

        rvBuku = findViewById(R.id.recyclerView_buku);
        rvBuku.setHasFixedSize(true);

        list.addAll(BukuData.getListData());
        showRecyclerList();
        setupToolbar();
        RefreshList();
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.tbInfoBku);
        toolbar.setTitle("Informasi Daftar Buku");
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

    private void showRecyclerList() {
        rvBuku.setLayoutManager(new LinearLayoutManager(this));
        ListBukuAdapter listBukuAdapter = new ListBukuAdapter(list,this);
        rvBuku.setAdapter(listBukuAdapter);
    }

    public void RefreshList() {
        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM Buku" ,null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            daftar[i] = cursor.getString(0);
        }
        RecyclerView1 = findViewById(R.id.recyclerView_buku);
    }


    @Override
    public void onBukuClick(int position) {
        final String selection = daftar[position];
        Intent intent = new Intent(this, DetailBukuActivity.class);
        intent.putExtra("merk",selection);
        startActivity(intent);
    }
}
