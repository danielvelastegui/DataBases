package com.danielvelastegui.deberpetagram.db;

import android.content.Context;

import com.danielvelastegui.deberpetagram.contenedor.Mascota;

import java.util.ArrayList;

public class ConstructorMascotasFavoritas {
    private Context context;

    public ConstructorMascotasFavoritas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerMascotasFavoritas(){
        BaseDatos db = new BaseDatos(context);
        return  db.obtenerMascotasFavoritas();
    }

    public int obtenerLikes(Mascota mascotaFavorita){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikes(mascotaFavorita);
    }
}
