package com.elterabit.altas;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;

import com.elterabit.mymultimediadatabase.ConexionSQLiteHelper;
import com.elterabit.mymultimediadatabase.Constantes;
import com.elterabit.mymultimediadatabase.R;
import com.elterabit.mymultimediadatabase.Util;

public class AltaLibros extends AppCompatActivity{

    EditText nombreLibro, nombreAutor, nombreEditorial, numPaginasLibro, formatoLibro;
    String errorString;
    Util util = new Util();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_libros);

           nombreLibro = findViewById(R.id.nombre_libro);
           nombreAutor = findViewById(R.id.nombre_autor);
           nombreEditorial = findViewById(R.id.nombre_editorial);
           numPaginasLibro = findViewById(R.id.num_paginas_libro);
           formatoLibro = findViewById(R.id.formato_libro);
    }

    public void onClick(){
        registroLibros();
    }

    private void registroLibros() {
        this.errorString="";
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(getApplicationContext(), "my_mini_database", null, 2);
        SQLiteDatabase db = conn.getWritableDatabase();

        try{
            ContentValues cValuesLibros = new ContentValues();
            cValuesLibros.put(Constantes.CAMPO_ID_LIBRO, util.Util("BK-"));
            cValuesLibros.put(Constantes.CAMPO_NOMBRE_LIBRO, nombreLibro.getText().toString());
            cValuesLibros.put(Constantes.CAMPO_NOMBRE_AUTOR, nombreAutor.getText().toString());
            cValuesLibros.put(Constantes.CAMPO_EDITORIAL, nombreEditorial.getText().toString());
            cValuesLibros.put(Constantes.CAMPO_PAGINAS, numPaginasLibro.getText().toString());
            cValuesLibros.put(Constantes.CAMPO_FORMATO_LIBRO, formatoLibro.getText().toString());

            db.insertOrThrow(Constantes.TABLA_LIBROS, null, cValuesLibros);


        }catch(Exception eX){
            this.errorString = "Error al insertar un nuevo libro " + eX.getMessage();
            Log.e("Error INSERT", this.errorString);
        }

    }


}
