package com.example.databasemp2.Data.Database;

import android.app.Application;

import androidx.room.Room;

import com.example.databasemp2.Data.DatabaseMigration;

public class MyApp extends Application {
    private static MyApp INSTANCE;
    public static AppDatabase db;
    private Object DatabaseMigrations;

    public static MyApp getInstance(){
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        db = Room.databaseBuilder(this,
                AppDatabase.class,"database_mahasiswa")
                .addMigrations(
                        DatabaseMigration.MIGRATION_1_TO_2,
                        DatabaseMigration.MIGRATION_2_TO_3
                )
                .fallbackToDestructiveMigrationOnDowngrade()
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
        INSTANCE = this;

    }
    public  AppDatabase getDatabase(){
        return db;
    }
}
