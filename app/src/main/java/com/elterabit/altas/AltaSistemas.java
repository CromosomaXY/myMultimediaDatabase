package com.elterabit.altas;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.elterabit.beans.Sistema;
import com.elterabit.mymultimediadatabase.ConexionSQLiteHelper;
import com.elterabit.mymultimediadatabase.Constantes;
import com.elterabit.mymultimediadatabase.R;

public class AltaSistemas extends AppCompatActivity{

    EditText nombreSistema, nombreCompania;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_sistemas);

        nombreSistema = findViewById(R.id.nombre_sistema);
        nombreCompania = findViewById(R.id.nombre_compania);
    }

    public void onClick(View view){
        registroSistema();
    }

    private void registroSistema() {
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "my_mini_database", null, 2);
        SQLiteDatabase db = conn.getReadableDatabase();
        Integer id;
        //comprobamos el id. Si existe algun sistema de inicio

        try{
            String consultaInicio = "SELECT MAX(ID) as id FROM " + Constantes.TABLA_SISTEMAS;
            Cursor cursor =  db.rawQuery(consultaInicio, null);

            // mejorar esto e intentar ponerle un sequence

            if (cursor.moveToNext()) {
                Sistema sis = new Sistema();
                sis.setId(cursor.getInt(0));
                Toast.makeText(getApplicationContext(), "ID: " + sis.getId().toString(), Toast.LENGTH_LONG).show();
                SQLiteDatabase dbW = conn.getWritableDatabase();
                ContentValues cValuesSistema = new ContentValues();
                //primer valor de la bbdd
                if(sis.getId().equals(0) || sis.getId() == '0'){
                    sis.setId(1);
                } else {
                    sis.setId(sis.getId()+1);
                }

                cValuesSistema.put(Constantes.CAMPO_ID_SISTEMAS, sis.getId());
                cValuesSistema.put(Constantes.CAMPO_NOMBRE_SISTEMA, nombreSistema.getText().toString());
                cValuesSistema.put(Constantes.CAMPO_COMPANIA, nombreCompania.getText().toString());
                dbW.insert(Constantes.TABLA_SISTEMAS, sis.getId().toString(), cValuesSistema);
                db.close();
                dbW.close();
            }

        }catch(Exception e){
            Toast.makeText(getApplicationContext(), "Error: " + e, Toast.LENGTH_LONG).show();
            limpiarCampos();
        }




    }

    private void limpiarCampos() {
    }


}
