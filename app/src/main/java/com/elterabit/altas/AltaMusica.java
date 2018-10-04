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

public class AltaMusica extends AppCompatActivity {

    EditText nombreDisco, nombreAutor, formatoDisco, annioDisco;
    String errorString;
    Util util = new Util();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_musica);

        nombreDisco = findViewById(R.id.nombre_disco);
        nombreAutor = findViewById(R.id.nombre_autor);
        formatoDisco = findViewById(R.id.formato_musica);
        annioDisco = findViewById(R.id.annio_musica);
    }

    public void onClick(View view){
        registroMusica();
    }

    private void registroMusica() {
        this.errorString="";
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(getApplicationContext(), "my_mini_database", null, 2);
        SQLiteDatabase db = conn.getWritableDatabase();

        try{
            ContentValues cValuesMusica = new ContentValues();
            cValuesMusica.put(Constantes.CAMPO_ID_MUSICA, util.Util("MS-"));
            cValuesMusica.put(Constantes.CAMPO_NOMBRE_DISCO, nombreDisco.getText().toString());
            cValuesMusica.put(Constantes.CAMPO_NOMBRE_AUTOR, nombreAutor.getText().toString());
            cValuesMusica.put(Constantes.CAMPO_FORMATO_MUSICA, formatoDisco.getText().toString());
            cValuesMusica.put(Constantes.CAMPO_ANNO_DISCO, annioDisco.getText().toString());

            db.insertOrThrow(Constantes.TABLA_MUSICA, null, cValuesMusica);

            /* TODO enviar de vuelta a la pantalla de musica con el adapter actualizado*/
        }catch (Exception eX){
            this.errorString = "Error al insertar la pelicula " + eX.getMessage();
            Log.e("Error INSERT", this.errorString);
        }
    }
}
