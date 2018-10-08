package com.elterabit.detalles;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.elterabit.beans.Videojuego;
import com.elterabit.mymultimediadatabase.R;

public class DetalleVideojuegos extends AppCompatActivity{

    TextView campoIdVideojuego, nombreVideojuego, nombrePlataforma, numeroJugadores, nombreGenero, nombreDesarrollador, formatoVideojuego;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_videojuegos);

        campoIdVideojuego = findViewById(R.id.campoIdVideojuego);
        nombreVideojuego = findViewById(R.id.campoNombreVideojuego);
        nombrePlataforma = findViewById(R.id.campoPlataforma);
        numeroJugadores = findViewById(R.id.numeroJugadores);
        nombreGenero = findViewById(R.id.campoGenero);
        nombreDesarrollador = findViewById(R.id.campoDesarrolladora);
        formatoVideojuego = findViewById(R.id.campoFormato);


        Bundle videojuegoEnviado = getIntent().getExtras();
        Videojuego videojuego = null;

        if(videojuegoEnviado!=null){
            videojuego = (Videojuego) videojuegoEnviado.getSerializable("videojuego");
            campoIdVideojuego.setText(videojuego.getId().toString());
            nombreVideojuego.setText(videojuego.getNombre().toString());
            nombrePlataforma.setText(videojuego.getPlataforma().toString());
            numeroJugadores.setText(videojuego.getJugadores().toString());
            nombreGenero.setText(videojuego.getGenero().toString());
            nombreDesarrollador.setText(videojuego.getDesarrollador().toString());
            formatoVideojuego.setText(videojuego.getFormato().toString());
        }
    }
}
