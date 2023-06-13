package com.example.inmobiliariaac.menu.ui.contratos;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
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
import com.example.inmobiliariaac.modelos.Contrato;
import com.example.inmobiliariaac.modelos.Inmueble;

import java.util.ArrayList;

public class ContratosAdapter extends RecyclerView.Adapter<ContratosAdapter.ViewHolder>{
    private Context contexto;
    private ArrayList<Contrato> listaContrato;
    private LayoutInflater li;

    public ContratosAdapter(Context contexto, ArrayList<Contrato> listaContrato, LayoutInflater li) {
        this.contexto = contexto;
        this.listaContrato = listaContrato;
        this.li = li;
    }


    @NonNull
    @Override
    public ContratosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = li.inflate(R.layout.contrato_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContratosAdapter.ViewHolder holder, int position) {
        holder.tvDireccion.setText(listaContrato.get(position).getInmueble().getDireccion());
        Glide.with(contexto).load("http://192.168.0.142:5000"+listaContrato.get(position).getInmueble().getFoto()).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.ivImagenContrato);
    }

    @Override
    public int getItemCount() {
        return listaContrato.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDireccion;
        ImageView ivImagenContrato;
        Button btnDetallesContrato;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        tvDireccion = itemView.findViewById(R.id.tvDireccionContrato);
        ivImagenContrato = itemView.findViewById(R.id.ivImagenInmuebleContrato);
        btnDetallesContrato = itemView.findViewById(R.id.btnDetalleContrato);
        btnDetallesContrato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                Contrato i = listaContrato.get(getAdapterPosition());
                bundle.putSerializable("contrato", i);
                NavController nc = Navigation.findNavController(v);
                nc.navigate(R.id.contratoDetalleFragment, bundle);
                //Navigation.findNavController((Activity) contexto, R.id.nav_host_fragment_content_menu ).navigate(R.id.contratoDetalleFragment, bundle);           }
        }
        });
    }
}
}