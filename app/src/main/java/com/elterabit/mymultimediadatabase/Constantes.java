package com.elterabit.mymultimediadatabase;

public class Constantes {


    // TABLA SISTEMAS
    public static final String TABLA_SISTEMAS="sistemas";
    public static final String CAMPO_ID_SISTEMAS="id";
    public static final String CAMPO_NOMBRE_SISTEMA="nombre";
    public static final String CAMPO_COMPANIA="compania";
    public static final String CREAR_TABLA_SISTEMAS="CREATE TABLE " +
            ""+TABLA_SISTEMAS+" ("+CAMPO_ID_SISTEMAS+" " +
            "INTEGER, "+CAMPO_NOMBRE_SISTEMA+" TEXT,"+CAMPO_COMPANIA+" TEXT)";


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
            "" +TABLA_VIDEOJUEGOS+" ("+CAMPO_ID_VIDEOJUEGO+" TEXT, " +
                                     ""+CAMPO_NOMBRE_VIDEOJUEGO+" TEXT, " +
                                     ""+CAMPO_NOMBRE_PLATAFORMA+" TEXT, " +
                                     ""+CAMPO_NUMERO_JUGADORES+" INTEGER, " +
                                     ""+CAMPO_GENERO+" TEXT, " +
                                     ""+CAMPO_DESARROLLADOR+" TEXT, " +
                                     ""+CAMPO_FORMATO+" TEXT)";

    //TABLA PELICULAS
    public static final String TABLA_PELICULAS="peliculas";
    public static final String CAMPO_ID_PELICULAS="id";
    public static final String CAMPO_NOMBRE_PELICULA="nombre";
    public static final String CAMPO_PRODUCTORA_PELICULA="productora";
    public static final String CAMPO_ANNO_PELICULA="anno";
    public static final String CAMPO_FORMATO_PELICULA="formato";
    public static final String CREAR_TABLA_PELICULAS="CREATE TABLE " +
            "" +TABLA_PELICULAS+" ("+CAMPO_ID_PELICULAS+" INTEGER, " +
            ""+CAMPO_NOMBRE_PELICULA+" TEXT, " +
            ""+CAMPO_PRODUCTORA_PELICULA+" TEXT, " +
            ""+CAMPO_ANNO_PELICULA+" INTEGER, " +
            ""+CAMPO_FORMATO_PELICULA+" TEXT) ";



    //TABLA MUSICA
    public static final String TABLA_MUSICA="musica";
    public static final String CAMPO_ID_MUSICA="id";
    public static final String CAMPO_NOMBRE_DISCO="nombre";
    public static final String CAMPO_NOMBRE_AUTOR="autor";
    public static final String CAMPO_FORMATO_MUSICA="formato";
    public static final String CAMPO_ANNO_DISCO="anno";
    public static final String CREAR_TABLA_MUSICA = "CREATE TABLE " +
            "" +TABLA_MUSICA+" ("+CAMPO_ID_MUSICA+" INTEGER, " +
            ""+CAMPO_NOMBRE_DISCO+" TEXT, " +
            ""+CAMPO_NOMBRE_AUTOR+" TEXT, " +
            ""+CAMPO_FORMATO_MUSICA+" TEXT, " +
            ""+CAMPO_ANNO_DISCO+" INTEGER) ";

    //TABLA LIBROS
    public static final String TABLA_LIBROS="libros";
    public static final String CAMPO_ID_LIBRO="id";
    public static final String CAMPO_NOMBRE_LIBRO="nombre";
    public static final String CAMPO_AUTOR_LIBRO="autor";
    public static final String CAMPO_EDITORIAL="editorial";
    public static final String CAMPO_PAGINAS="paginas";
    public static final String CAMPO_FORMATO_LIBRO="formato";
    public static final String CREAR_TABLA_LIBROS="CREATE TABLE " +
            "" +TABLA_LIBROS+" ("+CAMPO_ID_LIBRO+" INTEGER, " +
            ""+CAMPO_NOMBRE_LIBRO+" TEXT, " +
            ""+CAMPO_AUTOR_LIBRO+" TEXT, " +
            ""+CAMPO_EDITORIAL+" TEXT, " +
            ""+CAMPO_PAGINAS+" INTEGER, " +
            ""+CAMPO_FORMATO_LIBRO+" TEXT) ";

    //TABLA COMICS
    public static final String TABLA_COMICS="comics";
    public static final String CAMPO_ID_COMIC="id";
    public static final String CAMPO_NOMBRE_COMIC="nombre";
    public static final String CAMPO_AUTOR_COMIC="autor";
    public static final String CAMPO_EDITORIAL_COMIC="editorial";
    public static final String CAMPO_FORMATO_COMIC="formato";
    public static final String CAMPO_ANNO="anno";
    public static final String CAMPO_PAGINAS_COMIC="paginas";
    public static final String CAMPO_NUMERO_COMIC="numero";
    public static final String CREAR_TABLA_COMICS="CREATE TABLE " +
            "" +TABLA_COMICS+" ("+CAMPO_ID_COMIC+" INTEGER, " +
            ""+CAMPO_NOMBRE_COMIC+" TEXT, " +
            ""+CAMPO_AUTOR_COMIC+" TEXT, " +
            ""+CAMPO_EDITORIAL_COMIC+" TEXT, " +
            ""+CAMPO_FORMATO_COMIC+" TEXT, " +
            ""+CAMPO_ANNO+" INTEGER, " +
            ""+CAMPO_PAGINAS_COMIC+" INTEGER, " +
            ""+CAMPO_NUMERO_COMIC+" INTEGER)";
}