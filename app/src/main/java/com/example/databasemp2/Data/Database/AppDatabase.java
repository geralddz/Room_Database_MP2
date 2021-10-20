package com.example.databasemp2.Data.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.databasemp2.Data.DAO.MahasiswaDAO;
import com.example.databasemp2.Data.Mahasiswa;

@Database(entities = {Mahasiswa.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract MahasiswaDAO userDao();
}
