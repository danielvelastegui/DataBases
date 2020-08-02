package com.danielvelastegui.deberpetagram.db;

import android.content.ContentValues;
import android.content.Context;

import com.danielvelastegui.deberpetagram.R;
import com.danielvelastegui.deberpetagram.contenedor.Mascota;

import java.util.ArrayList;

public class ConstructorMascotas {
    private static final int LIKE = 1;
    private Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatosMascotas(){
        BaseDatos db = new BaseDatos(context);
        if(db.seDebeActualizar()){
            insertarMascotas(db);
        }
        return db.obtenerMascotas();
    }

    public void insertarMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Bruno");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO, R.drawable.ic_mascota01);
        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Jack");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO, R.drawable.ic_mascota02);
        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Paco");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO, R.drawable.ic_mascota3);
        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Hercules");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO, R.drawable.ic_mascota4);
        db.insertarMascotas(contentValues);
    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos bd = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_LIKES_ID_PETS_FK, mascota.getId());
        contentValues.put(ConstantesBD.TABLE_LIKES_NUMERO, LIKE);
        bd.insertarMascotasFavoritas(contentValues);
    }

    public int obtenerLike(Mascota mascota){
        BaseDatos bd = new BaseDatos(context);
        return bd.obtenerLikes(mascota);
    }

    public void eliminarMascotaFavorita(Mascota mascota){
        BaseDatos bd = new BaseDatos(context);
        bd.eliminarMascotaFavorita(mascota);
    }
}
