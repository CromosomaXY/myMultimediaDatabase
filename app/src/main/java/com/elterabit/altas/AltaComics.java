package com.elterabit.altas;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.elterabit.mymultimediadatabase.ConexionSQLiteHelper;
import com.elterabit.mymultimediadatabase.Constantes;
import com.elterabit.mymultimediadatabase.R;
import com.elterabit.mymultimediadatabase.Util;

public class AltaComics extends AppCompatActivity {

    EditText nombreComic, numeroComic, nombreAutor, nombreEditorial, formatoComic, annioComic, paginasComic;
    String errorString;
    Util util = new Util();
    

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_comics);

        nombreComic = findViewById(R.id.nombre_comic);
        numeroComic = findViewById(R.id.numero_comic);
        nombreAutor = findViewById(R.id.nombre_autor);
        nombreEditorial = findViewById(R.id.nombre_editorial_comic);
        formatoComic = findViewById(R.id.formato_comic);
        annioComic = findViewById(R.id.annio_comic);
        paginasComic = findViewById(R.id.num_paginas_comic);
    }

    public void onClick(View view){
        registroComic();
    }

    private void registroComic() {

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(getApplicationContext(), "my_mini_database", null, 2);
        SQLiteDatabase db = conn.getWritableDatabase();

        try{
            ContentValues cValuesComic = new ContentValues();
            cValuesComic.put(Constantes.CAMPO_ID_COMIC, util.Util("CM-"));
            cValuesComic.put(Constantes.CAMPO_NOMBRE_COMIC, nombreComic.getText().toString());
            cValuesComic.put(Constantes.CAMPO_NUMERO_COMIC, numeroComic.getText().toString());
            cValuesComic.put(Constantes.CAMPO_NOMBRE_AUTOR, nombreAutor.getText().toString());
            cValuesComic.put(Constantes.CAMPO_EDITORIAL_COMIC, nombreEditorial.getText().toString());
            cValuesComic.put(Constantes.CAMPO_FORMATO_COMIC, formatoComic.getText().toString());
            cValuesComic.put(Constantes.CAMPO_ANNO, annioComic.getText().toString());
            cValuesComic.put(Constantes.CAMPO_PAGINAS_COMIC, paginasComic.getText().toString());

            db.insertOrThrow(Constantes.TABLA_COMICS, null, cValuesComic);
            /* TODO. Al insertar el registro deberá irse al fragment de comics y actualizar el listResultado*/

        }catch (Exception eX){
            this.errorString = "Error al insertar un comic " + eX.getMessage();
            Log.e("Error INSERT", this.errorString);

        }




    }
}
