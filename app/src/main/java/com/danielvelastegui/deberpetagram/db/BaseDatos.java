package com.danielvelastegui.deberpetagram.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.danielvelastegui.deberpetagram.contenedor.Mascota;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {
    private Context context;

    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesBD.DATABASE_NAME, null, ConstantesBD.DATABASE_VERSION);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaContacto = "CREATE TABLE "    + ConstantesBD.TABLE_PETS +"("
                + ConstantesBD.TABLE_PETS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ConstantesBD.TABLE_PETS_NOMBRE + " TEXT, "
                + ConstantesBD.TABLE_PETS_FOTO + " INTEGER" + ")";

        String queryCrearTablaLikes = "CREATE TABLE "       + ConstantesBD.TABLE_LIKES + "("
                + ConstantesBD.TABLE_LIKES_ID               + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ConstantesBD.TABLE_LIKES_ID_PETS_FK       + " INTEGER, "
                + ConstantesBD.TABLE_LIKES_NUMERO           + " INTEGER, "
                + "FOREIGN KEY ("   + ConstantesBD.TABLE_LIKES_ID_PETS_FK + ") "
                + "REFERENCES "     + ConstantesBD.TABLE_PETS + "(" + ConstantesBD.TABLE_PETS_ID + ")"
                + ")";

        String queryCrearTablaUsuarios = "CREATE TABLE "    + ConstantesBD.TABLE_USERS + "("
                + ConstantesBD.TABLE_USERS_ID               + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ConstantesBD.TABLE_USERS_UPDATE           + " INTEGER " + ")";

        db.execSQL(queryCrearTablaUsuarios);
        db.execSQL(queryCrearTablaContacto);
        db.execSQL(queryCrearTablaLikes);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBD.TABLE_PETS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBD.TABLE_LIKES);
        onCreate(db);
    }

    public void agregarUsuario(){
        SQLiteDatabase db = getWritableDatabase();
        String query = "INSERT INTO " + ConstantesBD.TABLE_USERS
                + "(" + ConstantesBD.TABLE_USERS_UPDATE + ")"
                + " VALUES (" + 1 + ")";
        db.execSQL(query);
        db.close();
    }

    public boolean seDebeActualizar(){
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT COUNT (*) FROM " + ConstantesBD.TABLE_USERS;
        Cursor registros = db.rawQuery(query, null);
        if(registros.moveToNext()){
            return registros.getInt(0) == 0;
        }
        return true;
    }

    public ArrayList<Mascota> obtenerMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        agregarUsuario();

        String query = "SELECT * FROM " + ConstantesBD.TABLE_PETS;
        SQLiteDatabase db = getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

//        while(registros.moveToNext()){
//            Mascota mascotaActual = new Mascota();
//
//            mascotaActual.setId(registros.getInt(0));
//            mascotaActual.setNombre(registros.getString(1));
//            mascotaActual.setFoto(registros.getInt(2));
//
//            String queryLikes = "SELECT COUNT (" + ConstantesBD.TABLE_LIKES_NUMERO + ")"
//                                + " FROM " + ConstantesBD.TABLE_LIKES
//                                + " WHERE " + mascotaActual.getId() + " = " + ConstantesBD.TABLE_LIKES_ID_PETS_FK;
//            Cursor registrosLikes = db.rawQuery(queryLikes, null);
//            if(registrosLikes.moveToNext()){
//                mascotaActual.setMeGustas(registrosLikes.getInt(0));
//            }
//
//            mascotas.add(mascotaActual);
//        }
        db.close();
        return mascotas;
    }

    public ArrayList<Mascota> obtenerMascotasFavoritas(){
        ArrayList<Mascota> mascotasFavoritas = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + ConstantesBD.TABLE_LIKES + " L JOIN " + ConstantesBD.TABLE_PETS
                + " P ON L." + ConstantesBD.TABLE_LIKES_ID_PETS_FK + " = P." + ConstantesBD.TABLE_PETS_ID;
        Cursor registros = db.rawQuery(query, null);


//        while (registros.moveToNext()){
//            Mascota mascotaActual = new Mascota();
//
//            mascotaActual.setId(registros.getInt(1));
//            mascotaActual.setNombre(registros.getString(4));
//            mascotaActual.setFoto(registros.getInt(5));
//
//            String queryLikes = "SELECT COUNT (" + ConstantesBD.TABLE_LIKES_NUMERO + ")"
//                    + " FROM " + ConstantesBD.TABLE_LIKES
//                    + " WHERE " + mascotaActual.getId() + " = " + ConstantesBD.TABLE_LIKES_ID_PETS_FK;
//            Cursor registrosLikes = db.rawQuery(queryLikes, null);
//            if(registrosLikes.moveToNext()){
//                mascotaActual.setMeGustas(registrosLikes.getInt(0));
//            }
//
//            mascotasFavoritas.add(mascotaActual);
//        }

        db.close();
        return mascotasFavoritas;
    }

    public void insertarMascotas(ContentValues contentValues){
        SQLiteDatabase db = getWritableDatabase();
        db.insert(ConstantesBD.TABLE_PETS, null, contentValues);
        db.close();
    }

    public void insertarMascotasFavoritas(ContentValues contentValues){
        SQLiteDatabase db = getWritableDatabase();
        db.insert(ConstantesBD.TABLE_LIKES, null, contentValues);
        db.close();
    }

    public void eliminarMascotaFavorita(Mascota mascota){
        String query = "DELETE FROM " + ConstantesBD.TABLE_LIKES
                        + " WHERE " + ConstantesBD.TABLE_LIKES_ID_PETS_FK + " = " + mascota.getId();
        SQLiteDatabase db = getWritableDatabase();

        db.execSQL(query);
        db.close();
    }

    public int obtenerLikes(Mascota mascota){
        int likes = 0;
        String query = "SELECT COUNT (" + ConstantesBD.TABLE_LIKES_NUMERO + ") "
                        + " FROM " + ConstantesBD.TABLE_LIKES
                        + " WHERE " + ConstantesBD.TABLE_LIKES_ID_PETS_FK + " = " + mascota.getId();
        SQLiteDatabase db = getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if(registros.moveToNext()){
            likes = registros.getInt(0);
        }
        db.close();
        return likes;
    }
}
