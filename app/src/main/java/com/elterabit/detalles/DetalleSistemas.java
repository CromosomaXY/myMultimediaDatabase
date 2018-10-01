package com.elterabit.detalles;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.elterabit.beans.Sistema;
import com.elterabit.mymultimediadatabase.R;

public class DetalleSistemas extends AppCompatActivity {

    TextView campoIdsistema, campoNombreSistema;
    EditText campoCompania;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_sistemas);


        campoIdsistema = findViewById(R.id.campoIdsistema);
        campoNombreSistema = findViewById(R.id.campoNombreSistema);
        campoCompania =  findViewById(R.id.campoCompania);

        Bundle sistemaEnviado = getIntent().getExtras();
        Sistema sistema = null;

        if(sistemaEnviado !=null){
            sistema = (Sistema) sistemaEnviado.getSerializable("sistema");
            campoIdsistema.setText(sistema.getId().toString());
            campoNombreSistema.setText(sistema.getNombre().toString());
            campoCompania.setText(sistema.getCompania().toString());
        }
    }

}
