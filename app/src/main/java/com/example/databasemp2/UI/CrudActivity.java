package com.example.databasemp2.UI;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
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
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);

        RecyclerView rvListMahasiswa = findViewById(R.id.rv_list_mahasiswa);
        FloatingActionButton fabTambah = findViewById(R.id.fab_tambah_data);

        rvListMahasiswa.setAdapter(adapter);
        builder = new AlertDialog.Builder(this);
        adapter.setRemoveListener(view -> builder.setTitle("Alert..!!")
        .setMessage("Apakah anda yakin untuk menghapus data")
        .setCancelable(true)
        .setPositiveButton("Yes", (dialog, which) -> {
            Toast.makeText(builder.getContext(),"Berhasil Dihapus", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(CrudActivity.this, CrudActivity.class));
            finish();
        })
        .setNegativeButton("No", (dialog, which) -> dialog.cancel())
        .show());

        fabTambah.setOnClickListener(view -> startActivity(new Intent(CrudActivity.this, AddData.class)));

    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Mahasiswa> datas = MyApp.getInstance().getDatabase().userDao().getAll();
        adapter.setData(datas);
    }

}