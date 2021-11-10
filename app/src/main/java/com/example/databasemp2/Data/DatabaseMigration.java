package com.example.databasemp2.Data;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

public class DatabaseMigration {
        public static final Migration MIGRATION_1_TO_2 = new Migration(1, 2) {
            @Override
            public void migrate(SupportSQLiteDatabase database) {
                database.execSQL("ALTER TABLE Mahasiswa ADD COLUMN SKS int DEFAULT 0");
            }
        };
    public static final Migration MIGRATION_2_TO_3 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS Mahasiswa (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, nama TEXT,nim TEXT, kejuruan TEXT, SKS TEXT, alamat TEXT, gambar TEXT)");
        }
    };
}

