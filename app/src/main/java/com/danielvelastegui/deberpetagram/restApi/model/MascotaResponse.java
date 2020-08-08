package com.danielvelastegui.deberpetagram.restApi.model;

import com.danielvelastegui.deberpetagram.contenedor.Mascota;

import java.util.ArrayList;

public class MascotaResponse {
    ArrayList<Mascota> mascotas;

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}
