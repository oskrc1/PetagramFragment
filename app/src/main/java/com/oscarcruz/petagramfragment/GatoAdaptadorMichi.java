package com.oscarcruz.petagramfragment;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GatoAdaptadorMichi extends RecyclerView.Adapter<GatoAdaptadorMichi.ContactoViewHolder> {

    ArrayList<Michi> michis;


    public GatoAdaptadorMichi(ArrayList<Michi> michi){
        this.michis = michi;

    }




    // Inflar el layout y lo pasará al viewholder para que obtenga los views
    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_michi, parent, false);
        return new ContactoViewHolder(v);
    }
//Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(@NonNull final ContactoViewHolder contactoViewHolder, int position) {
        final Michi michi = michis.get(position);
        contactoViewHolder.imgFoto.setImageResource(michi.getFoto());
                contactoViewHolder.tvCount.setText(""+michi.getCount());

            }


    @Override
    public int getItemCount() { //Cantidad de elementos que contiene mi lista
        return michis.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{


        private ImageView imgFoto;
               private TextView tvCount;




        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFoto         = (ImageView) itemView.findViewById(R.id.imgFoto);
                        tvCount         = (TextView)  itemView.findViewById(R.id.tvCountNumber);


        }

        }
    }


