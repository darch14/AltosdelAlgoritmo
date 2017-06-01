package com.example.david.altosdelalgoritmo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by david on 31/05/2017.
 */

public class DatosApartamentos {
    public static ArrayList<Apartamento> traerApartamentos(Context conexto){
        ArrayList<Apartamento> apartamentos=new ArrayList<>();

        SQLiteDatabase db;
        String sql,foto,nomenclatura,piso,metros,precio,balcon,sombra;
        Apartamento a;

        ApartamentoSQLiteOpenHelper aux=new ApartamentoSQLiteOpenHelper(conexto,"DBApartamentos",null,1);
        db=aux.getReadableDatabase();

        sql ="select * from Apartamentos";
        Cursor c = db.rawQuery(sql,null);

        if (c.moveToFirst()){
            do {
                foto=c.getString(0);
                nomenclatura=c.getString(1);
                piso=c.getString(2);
                metros=c.getString(3);
                precio=c.getString(4);
                balcon=c.getString(5);
                sombra=c.getString(6);
                a=new Apartamento(foto,nomenclatura,piso,metros,precio,balcon,sombra);
                apartamentos.add(a);

            }while (c.moveToNext());
        }

        db.close();
        return apartamentos;
    }
}
