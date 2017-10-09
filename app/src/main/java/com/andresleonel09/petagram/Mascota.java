package com.andresleonel09.petagram;

/**
 * Created by Andres-PC on 2017-10-08.
 */

public class Mascota {
    private String nombre;
    private int foto;

    public Mascota(int foto, String nombre) {
        this.foto = foto;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
