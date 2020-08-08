package com.danielvelastegui.deberpetagram.contenedor;

public class Mascota {
    private String id;
    private String foto;
    private String nombre;
    private int meGustas;

    public Mascota(String id, String foto, String nombre, int meGustas) {
        this.id = id;
        this.foto = foto;
        this.nombre = nombre;
        this.meGustas = meGustas;
    }

    public Mascota(String foto, String nombre) {
        this.foto = foto;
        this.nombre = nombre;
        this.meGustas = 0;
    }

    public Mascota() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMeGustas() {
        return meGustas;
    }

    public void setMeGustas(int meGustas) {
        this.meGustas = meGustas;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
