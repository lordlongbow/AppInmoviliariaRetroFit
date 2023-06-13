package com.example.inmobiliariaac.menu.ui.inmuebles;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.inmobiliariaac.R;
import com.example.inmobiliariaac.modelos.Inmueble;

import java.util.List;

public class InmuebleAdapter extends RecyclerView.Adapter<InmuebleAdapter.ViewHolder> {
    private Context contexto;
    private List<Inmueble> inmuebles;
    private LayoutInflater li;
    public InmuebleAdapter(Context contexto, List<Inmueble> inmuebles, LayoutInflater li) {
        this.contexto = contexto.getApplicationContext();
        this.inmuebles = inmuebles;
        this.li = li;
    }
    //Aca se pone el item que va a inflar en el recyclerview
    @NonNull
    @Override
    public InmuebleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = li.inflate(R.layout.inmueble_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InmuebleAdapter.ViewHolder holder, int position) {
       holder.tvDireccion.setText(inmuebles.get(position).getDireccion());
       holder.tvPrecio.setText(String.valueOf("$ " + inmuebles.get(position).getPrecio()));
       Glide.with(contexto).load("http://192.168.0.142:5000" + inmuebles.get(position).getFoto()).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.ivInmueble);
        //Glide.with(contexto).load(inmuebles.get(position).getFoto()).into(holder.ivInmueble);


    }

    @Override
    public int getItemCount() {
        return inmuebles.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDireccion, tvPrecio;
        Button btnDetalles;
        ImageView ivInmueble;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDireccion = itemView.findViewById(R.id.tvDireccion);
            tvPrecio = itemView.findViewById(R.id.tvPrecio);
            ivInmueble = itemView.findViewById(R.id.ivImagenInmueble);
            btnDetalles = itemView.findViewById(R.id.btnDetalleInmueble);
            btnDetalles.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
               Bundle bundle = new Bundle();
               Inmueble i = inmuebles.get(getAdapterPosition());
               bundle.putSerializable("inmueble", i);
                    NavController nc = Navigation.findNavController(v);
                    nc.navigate(R.id.inmuebleDetalleFragment, bundle);
               //Navigation.findNavController((Activity) contexto, R.id.action_inmueblesFragment_to_inmuebleDetalleFragment).navigate(R.id.inmuebleDetalleFragment, buendle);
                    Log.d("inmuebleadapter", inmuebles.toString());
                }
            });
        }
    }
}
