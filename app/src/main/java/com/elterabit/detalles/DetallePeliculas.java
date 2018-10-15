package com.elterabit.detalles;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.elterabit.mymultimediadatabase.R;

public class DetallePeliculas extends AppCompatActivity {

    TextView idPelicula, nombrePelicula, nombreProductora, annioPelicula, formatoPelicula;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_peliculas);

        idPelicula = findViewById(R.id.campoIdPelicula);
        nombrePelicula = findViewById(R.id.campoNombrePelicula);
        nombreProductora = findViewById(R.id.campoNombreProductora);
        annioPelicula = findViewById(R.id.campoAnnioPelicula);



    }
}
