package com.elterabit.mymultimediadatabase;

public class Constantes {


    // TABLA SISTEMAS
    public static final String TABLA_SISTEMAS="sistemas";
    public static final String CAMPO_ID_SISTEMAS="id";
    public static final String CAMPO_NOMBRE_SISTEMA="nombre";
    public static final String CAMPO_CAMPANIA="compania";
    public static final String CREAR_TABLA_SISTEMAS="CREATE TABLE " +
            ""+TABLA_SISTEMAS+" ("+CAMPO_ID_SISTEMAS+" " +
            "INTEGER, "+CAMPO_NOMBRE_SISTEMA+" TEXT,"+CAMPO_CAMPANIA+" TEXT)";


    //TABLA VIDEOJUEGOS
    public static final String TABLA_VIDEOJUEGOS="videojuegos";
    public static final String CAMPO_ID_VIDEOJUEGO="id";
    public static final String CAMPO_NOMBRE_VIDEOJUEGO="nombre";
    public static final String CAMPO_NOMBRE_PLATAFORMA="plataforma";
    public static final String CAMPO_NUMERO_JUGADORES="jugadores";
    public static final String CAMPO_GENERO="genero";
    public static final String CAMPO_DESARROLLADOR="desarrollador";
    public static final String CAMPO_FORMATO="formato";
    public static final String CREAR_TABLA_VIDEOJUEGOS="CREATE TABLE " +
            "" +TABLA_VIDEOJUEGOS+" ("+CAMPO_ID_VIDEOJUEGO+" INTEGER, " +
                                     ""+CAMPO_NOMBRE_VIDEOJUEGO+" TEXT, " +
                                     ""+CAMPO_NOMBRE_PLATAFORMA+" TEXT, " +
                                     ""+CAMPO_NUMERO_JUGADORES+" TEXT, " +
                                     ""+CAMPO_GENERO+" TEXT, " +
                                     ""+CAMPO_DESARROLLADOR+" TEXT, " +
                                     ""+CAMPO_FORMATO+" TEXT)";

    //TABLA PELICULAS
    public static final String TABLA_PELICULAS="peliculas";


    //TABLA MUSICA
    public static final String TABLA_MUSICA="musica";

    //TABLA LIBROS
    public static final String TABLA_LIBROS="libros";

    //TABLA COMICS
    public static final String TABLA_COMICS="comics";
}



