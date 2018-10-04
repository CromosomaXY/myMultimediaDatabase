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

public class AltaVideojuegos extends AppCompatActivity{

    EditText nombreVideojuego, nombrePlataforma, numeroJugadores, nombreGenero, nombreDesarrollador, formatoVideojuego;
    Util util = new Util();
    String errorString;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_videojuegos);

        //guardamos los campos en sus variables
        nombreVideojuego = findViewById(R.id.nombre_videojuego);
        nombrePlataforma = findViewById(R.id.nombre_plataforma);
        numeroJugadores = findViewById(R.id.numero_jugadores);
        nombreGenero = findViewById(R.id.nombre_genero);
        nombreDesarrollador = findViewById(R.id.nombre_desarrolador);
        formatoVideojuego = findViewById(R.id.formato_videojuego);
    }

    public void onClick(View view){
        registroVideojuego();
    }

    private void registroVideojuego() {
        this.errorString = "";
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(getApplicationContext(), "my_mini_database", null, 2);
        SQLiteDatabase db = conn.getWritableDatabase();

        try{
            ContentValues cValuesVideojuegos = new ContentValues();
            cValuesVideojuegos.put(Constantes.CAMPO_ID_VIDEOJUEGO, util.Util("VJ-"));
            cValuesVideojuegos.put(Constantes.CAMPO_NOMBRE_VIDEOJUEGO, nombreVideojuego.getText().toString());
            cValuesVideojuegos.put(Constantes.CAMPO_NOMBRE_PLATAFORMA, nombrePlataforma.getText().toString());
            cValuesVideojuegos.put(Constantes.CAMPO_NUMERO_JUGADORES, numeroJugadores.getText().toString());
            cValuesVideojuegos.put(Constantes.CAMPO_GENERO, nombreGenero.getText().toString());
            cValuesVideojuegos.put(Constantes.CAMPO_DESARROLLADOR, nombreDesarrollador.getText().toString());
            cValuesVideojuegos.put(Constantes.CAMPO_FORMATO,  formatoVideojuego.getText().toString());

            db.insertOrThrow(Constantes.TABLA_VIDEOJUEGOS, null, cValuesVideojuegos);

            /* TODO. Al insertar el registro deberá irse al fragment de videojuegos y actualizar el listResultado*/

        }catch(Exception eX){
            this.errorString = "Error al insertar un nuevo videojuego " + eX.getMessage();
            Log.e("Error INSERT", this.errorString);
        }
    }
}