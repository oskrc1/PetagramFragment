package com.oscarcruz.petagramfragment;

public class Gatos {

    private String nombre;
    private int count;
    private int foto;


    public Gatos(int foto, String nombre, int count) {
        this.foto = foto;
        this.nombre = nombre;
        this.count = count;

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}