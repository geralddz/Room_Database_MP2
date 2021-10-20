package com.example.databasemp2.UI;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.databasemp2.R;

public class RoomData extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_data);

        Button btnTambah =  findViewById(R.id.btnTambah);
        Button btnLihat =  findViewById(R.id.btnlihat);

        btnTambah.setOnClickListener(v -> {
            Intent i = new Intent(RoomData.this, RoomData.class);
            startActivity(i);
        });

        btnLihat.setOnClickListener(v -> {
            Intent i = new Intent(RoomData.this, CrudActivity.class);
            startActivity(i);
        });
    }
}