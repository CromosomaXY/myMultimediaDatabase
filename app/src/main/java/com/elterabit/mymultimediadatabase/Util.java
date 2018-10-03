package com.elterabit.mymultimediadatabase;

import java.util.UUID;

public class Util {

    public String generadorPkVideojuegos(){
        return "VJ-" + UUID.randomUUID().toString();
    }
    public String generadorPkSistemas() { return "SYS-" + UUID.randomUUID().toString();}
    public String generadorPkPeliculas() { return "MV-" + UUID.randomUUID().toString();}
    public String generadorPkMusica() { return "MS-" + UUID.randomUUID().toString();}
    public String generadorPkLibros() { return  "LB-" + UUID.randomUUID().toString();}
    public String generadorPkComics() { return "CM-" + UUID.randomUUID().toString();}

}
