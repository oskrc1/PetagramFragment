package com.oscarcruz.petagramfragment;

public class Michi {


    private int count;
    private int foto;


    public Michi(int foto, int count) {
        this.foto = foto;

        this.count = count;

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