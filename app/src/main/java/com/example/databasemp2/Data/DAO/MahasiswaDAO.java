package com.example.databasemp2.Data.DAO;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.databasemp2.Data.Mahasiswa;

import java.util.List;

public interface MahasiswaDAO {

    @Query("SELECT * FROM mahasiswa")
    List<Mahasiswa> getAll();

    @Insert
    void insertData(Mahasiswa mahasiswa);

    @Query("SELECT * FROM mahasiswa WHERE id LIKE :mahasiswaId LIMIT 1")
    Mahasiswa findById(int mahasiswaId);

    @Update
    void update(Mahasiswa mahasiswa);

    @Delete
    void delete(Mahasiswa mahasiswa);

}
