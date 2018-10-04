package com.elterabit.mymultimediadatabase;

import java.util.UUID;

public class Util {
    public String Util(String prefijo){return prefijo + UUID.randomUUID().toString();}
}
