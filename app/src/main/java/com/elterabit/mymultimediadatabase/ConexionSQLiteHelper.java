package com.elterabit.mymultimediadatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConexionSQLiteHelper extends SQLiteOpenHelper{

    public ConexionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context,name,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constantes.CREAR_TABLA_SISTEMAS);
        db.execSQL(Constantes.CREAR_TABLA_VIDEOJUEGOS);
        db.execSQL(Constantes.CREAR_TABLA_PELICULAS);
        db.execSQL(Constantes.CREAR_TABLA_MUSICA);
        db.execSQL(Constantes.CREAR_TABLA_LIBROS);
        db.execSQL(Constantes.CREAR_TABLA_COMICS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Constantes.TABLA_SISTEMAS);
        db.execSQL("DROP TABLE IF EXISTS " + Constantes.TABLA_VIDEOJUEGOS);
        db.execSQL("DROP TABLE IF EXISTS " + Constantes.TABLA_PELICULAS);
        db.execSQL("DROP TABLE IF EXISTS " + Constantes.TABLA_MUSICA);
        db.execSQL("DROP TABLE IF EXISTS " + Constantes.TABLA_LIBROS);
        db.execSQL("DROP TABLE IF EXISTS " + Constantes.TABLA_COMICS);
        onCreate(db);
    }


}
