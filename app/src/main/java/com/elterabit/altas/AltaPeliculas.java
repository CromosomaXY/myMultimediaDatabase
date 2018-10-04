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

public class AltaPeliculas extends AppCompatActivity{

    EditText nombrePelicula, nombreProductora, annioPelicula, formatoPelicula;
    String errorString;
    Util util = new Util();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_peliculas);

        nombrePelicula = findViewById(R.id.nombre_pelicula);
        nombreProductora = findViewById(R.id.nombre_productora);
        annioPelicula  = findViewById(R.id.annio_pelicula);
        formatoPelicula = findViewById(R.id.formato_pelicula);
    }

    public void onClick(View view){
        registroPeliculas();
    }

    private void registroPeliculas() {
        this.errorString="";
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(getApplicationContext(), "my_mini_database", null, 2);
        SQLiteDatabase db = conn.getWritableDatabase();

        try{
            ContentValues cValuesMovies = new ContentValues();
            cValuesMovies.put(Constantes.CAMPO_ID_PELICULAS, util.Util("MV-"));
            cValuesMovies.put(Constantes.CAMPO_NOMBRE_PELICULA, nombrePelicula.getText().toString());
            cValuesMovies.put(Constantes.CAMPO_PRODUCTORA_PELICULA, nombreProductora.getText().toString());
            cValuesMovies.put(Constantes.CAMPO_ANNO_PELICULA, annioPelicula.getText().toString());
            cValuesMovies.put(Constantes.CAMPO_FORMATO_PELICULA, formatoPelicula.getText().toString());

            db.insertOrThrow(Constantes.TABLA_PELICULAS, null, cValuesMovies);
        } catch(Exception eX){
            this.errorString = "Error al insertar una nueva pelicula " + eX.getMessage();
            Log.e("Error INSERT", this.errorString);
        }
    }
}
