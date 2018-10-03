package com.elterabit.mymultimediadatabase;

import java.util.UUID;

public class Util {

    public String generadorPkVideojuegos(){
        return "VJ-" + UUID.randomUUID().toString();
    }

}
