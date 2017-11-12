package com.andresleonel09.petagram.db;

/**
 * Created by Andres-PC on 2017-11-05.
 */

public final class ConstantesBD {
    public static final String DATABASE_NAME = "mascotas";
    public static final int VERSION          = 1;

    public static final String TABLE_MASCOTAS        = "mascota";
    public static final String TABLE_MASCOTAS_ID     = "id";
    public static final String TABLE_MASCOTAS_NOMBRE = "nombre";
    public static final String TABLE_MASCOTAS_FOTO   = "foto";
    public static final String TABLE_MASCOTAS_LIKES  = "likes";

    public static final String TABLE_LIKES_MASCOTA             = "mascota_likes";
    public static final String TABLE_LIKES_MASCOTA_ID          = "id";
    public static final String TABLE_LIKES_MASCOTA_CANT        = "cant_likes";
    public static final String TABLE_LIKES_MASCOTA_ID_MASCOTA  = "id_mascota";

}
