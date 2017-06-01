package com.example.david.altosdelalgoritmo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by david on 31/05/2017.
 */

public class ApartamentoSQLiteOpenHelper  extends SQLiteOpenHelper{
    private String sql="CREATE TABLE Apartamentos(foto text,nomenclatura text,piso text,metros text,precio text,balcon text,sombra text)";

    public ApartamentoSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS Apartamentos");
        db.execSQL(sql);
    }
}
