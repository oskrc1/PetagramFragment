package com.oscarcruz.petagramfragment;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GatoAdaptador extends RecyclerView.Adapter<GatoAdaptador.ContactoViewHolder> {

    ArrayList<Gatos> contactos;
    Activity activity;

    public GatoAdaptador(ArrayList<Gatos> contactos){
        this.contactos = contactos;
        this.activity = activity;
    }




    // Inflar el layout y lo pasará al viewholder para que obtenga los views
    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_gato, parent, false);
        return new ContactoViewHolder(v);
    }
//Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(@NonNull final ContactoViewHolder contactoViewHolder, int position) {
        final Gatos contacto = contactos.get(position);
        contactoViewHolder.imgFoto.setImageResource(contacto.getFoto());
        contactoViewHolder.tvNombreCV.setText(contacto.getNombre());
        contactoViewHolder.tvCount.setText(""+contacto.getCount());

        ContactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                //Toast.makeText(activity, "Diste like a " + contacto.getNombre(), Toast.LENGTH_SHORT).show();


                int likes = contacto.getCount();
                if(likes == 0){
                    contactoViewHolder.tvCount.setText(""+1);
                    contacto.setCount(1);
                }
                else if(likes == 1){
                    contactoViewHolder.tvCount.setText(""+0);
                    contacto.setCount(0);
                }

            }
        });
    }


    @Override
    public int getItemCount() { //Cantidad de elementos que contiene mi lista
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{


        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvCount;
        private static ImageButton btnLike;



        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFoto         = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV      = (TextView)  itemView.findViewById(R.id.tvNombreCV);
            btnLike         = (ImageButton) itemView.findViewById(R.id.bntLikeBone);
            tvCount         = (TextView)  itemView.findViewById(R.id.tvCountNumber);


        }

        }
    }


