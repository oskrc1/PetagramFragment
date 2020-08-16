package com.oscarcruz.petagramfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Frag1 extends Fragment {

    public ArrayList<Gatos> contactos;
    private RecyclerView listaContactos;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View vista = inflater.inflate(R.layout.frag1_layout, container,false);

        listaContactos = vista.findViewById(R.id.rvContactos);
        //contactos=new ArrayList<>();
        listaContactos.setLayoutManager(new LinearLayoutManager(getContext()));


        inicializarlistaContactos();
        inicializarAdaptador();

        return vista;

    }

    public GatoAdaptador adaptador;

    private void inicializarAdaptador(){
        adaptador = new GatoAdaptador(contactos);
        listaContactos.setAdapter(adaptador);

    }

    public void inicializarlistaContactos() {
        contactos = new ArrayList<Gatos>();

        contactos.add(new Gatos(R.drawable.cat1,"Snow", 0));
        contactos.add(new Gatos(R.drawable.cat2,"Tiger", 0));
        contactos.add(new Gatos(R.drawable.cat3,"Copito", 0));
        contactos.add(new Gatos(R.drawable.cat4, "Sunny", 0));
        contactos.add(new Gatos(R.drawable.cat5, "Anubis", 0));
        contactos.add(new Gatos(R.drawable.cat6, "Tizón", 0));
        contactos.add(new Gatos(R.drawable.cat7, "Bonnie", 0));
    }

}
