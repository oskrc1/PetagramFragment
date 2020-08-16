package com.oscarcruz.petagramfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Frag2 extends Fragment {
    public ArrayList<Michi> michi;
    private RecyclerView listamichi;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View vista = inflater.inflate(R.layout.frag2_layout, container,false);

        listamichi = vista.findViewById(R.id.rvContactos2);
        //contactos=new ArrayList<>();
        listamichi.setLayoutManager(new GridLayoutManager(getContext(), 3));


        inicializarlistaContactos();
        inicializarAdaptador();

        return vista;

    }

    public GatoAdaptadorMichi adaptador2;

    private void inicializarAdaptador(){
        adaptador2 = new GatoAdaptadorMichi(michi);
        listamichi.setAdapter(adaptador2);

    }

    public void inicializarlistaContactos() {
        michi = new ArrayList<Michi>();

        michi.add(new Michi(R.drawable.cat3, 2));
        michi.add(new Michi(R.drawable.cat3, 3));
        michi.add(new Michi(R.drawable.cat3, 2));
        michi.add(new Michi(R.drawable.cat3,  5));
        michi.add(new Michi(R.drawable.cat3,  2));
        michi.add(new Michi(R.drawable.cat3,  1));
        michi.add(new Michi(R.drawable.cat3,  5));
    }
}
