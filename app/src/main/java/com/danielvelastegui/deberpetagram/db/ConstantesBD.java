package com.danielvelastegui.deberpetagram.db;

public class ConstantesBD {
    public  static final String DATABASE_NAME = "mascotas";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_USERS = "usuario";
    public static final String TABLE_USERS_ID = "usuario_id";
    public static final String TABLE_USERS_UPDATE = "datos_cargados";

    public static final String TABLE_PETS = "mascota";
    public static final String TABLE_PETS_ID = "mascota_id";
    public static final String TABLE_PETS_NOMBRE = "nombre";
    public static final String TABLE_PETS_FOTO = "foto";

    public static final String TABLE_LIKES = "likes";
    public static final String TABLE_LIKES_ID = "likes_id";
    public static final String TABLE_LIKES_ID_PETS_FK = "nombre_id";
    public static final String TABLE_LIKES_NUMERO = "numero_likes";
}
