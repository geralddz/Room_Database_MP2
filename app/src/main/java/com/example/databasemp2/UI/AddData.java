package com.example.databasemp2.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.databasemp2.Data.DAO.MahasiswaDAO;
import com.example.databasemp2.Data.Database.MyApp;
import com.example.databasemp2.Data.Mahasiswa;
import com.example.databasemp2.R;

public class AddData extends AppCompatActivity implements View.OnClickListener {

    EditText etNama, etNim, etKejuruan, etAlamat;
    public final static String TAG_DATA_INTENT = "data_mahasiswa";
    private Mahasiswa mahasiswa;
    private MahasiswaDAO dao;
    private Button btnTambah;

    @SuppressLint({"setTextll8n", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        dao = MyApp.getInstance().getDatabase().userDao();

        if (getIntent() != null) {
            int id = getIntent().getIntExtra(TAG_DATA_INTENT, 0);
            mahasiswa = dao.findById(id);

        }

        btnTambah = findViewById(R.id.btInsert);
        etNama = findViewById(R.id.etNama);
        etNim = findViewById(R.id.etNim);
        etKejuruan = findViewById(R.id.etKejuruan);
        etAlamat = findViewById(R.id.etAlamat);

        if (mahasiswa != null) {
            etNama.setText(mahasiswa.getNama());
            etNim.setText(mahasiswa.getNim());
            etKejuruan.setText(mahasiswa.getKejuruan());
            etAlamat.setText(mahasiswa.getAlamat());

            btnTambah.setText("Ubah Data");
        }
        btnTambah.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        addOrUpdate();
        if (mahasiswa.getId() == 0) {
            dao.insertData(mahasiswa);
        } else {
            dao.update(mahasiswa);
        }
        Toast.makeText(this, btnTambah.getText().toString(), Toast.LENGTH_SHORT).show();
        finish();
    }

    private void addOrUpdate() {
        if (mahasiswa == null) {
            mahasiswa = new Mahasiswa();
        }
        mahasiswa.setNama(etNama.getText().toString());
        mahasiswa.setNim(etNim.getText().toString());
        mahasiswa.setAlamat(etAlamat.getText().toString());
        mahasiswa.setKejuruan(etKejuruan.getText().toString());
    }

//    private void tambahData() {
//        if (!etAlamat.getText().toString().isEmpty()&&!etKejuruan.getText().toString().isEmpty()&&
//                !etNama.getText().toString().isEmpty()&&!etNim.getText().toString().isEmpty()){
//
//            mahasiswa = new Mahasiswa();
//            mahasiswa.setAlamat(etAlamat.getText().toString());
//            mahasiswa.setKejuruan(etKejuruan.getText().toString());
//            mahasiswa.setNama(etNama.getText().toString());
//            mahasiswa.setNim(etNim.getText().toString());
//            //Insert data in database
//            db.userDao().insertAll(mahasiswa);
//            startActivity(new Intent(AddRoomDataActivity.this,RoomDataActivity.class));
//        }else {
//            Toast.makeText(this, "Mohon masukkan dengan benar", Toast.LENGTH_SHORT).show();
//        }
//    }
}
