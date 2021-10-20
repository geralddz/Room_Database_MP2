package com.example.databasemp2.UI;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.databasemp2.Adapter.RecyclerViewAdapter;
import com.example.databasemp2.Data.Database.MyApp;
import com.example.databasemp2.Data.Mahasiswa;
import com.example.databasemp2.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class CrudActivity extends AppCompatActivity {
    private RecyclerViewAdapter adapter = new RecyclerViewAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);

        RecyclerView rvListMahasiswa = findViewById(R.id.rv_list_mahasiswa);
        FloatingActionButton fabTambah = findViewById(R.id.fab_tambah_data);

        rvListMahasiswa.setAdapter(adapter);

        adapter.setRemoveListener(mahasiswa -> adapter.removeData(mahasiswa));

        fabTambah.setOnClickListener(view -> startActivity(new Intent(CrudActivity.this, AddData.class)));

    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Mahasiswa> datas = MyApp.getInstance().getDatabase().userDao().getAll();
        adapter.setData(datas);
    }

}