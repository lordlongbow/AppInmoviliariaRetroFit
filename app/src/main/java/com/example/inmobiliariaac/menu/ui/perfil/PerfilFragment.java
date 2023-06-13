package com.example.inmobiliariaac.menu.ui.perfil;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.inmobiliariaac.R;
import com.example.inmobiliariaac.databinding.FragmentPerfilBinding;
import com.example.inmobiliariaac.modelos.Inmueble;
import com.example.inmobiliariaac.modelos.Propietario;

import java.io.Serializable;

public class PerfilFragment extends Fragment {

    private EditText etNombrePerfil, etApellidoPerfil, etTelefonoPerfil, etEmailPerfil, etDomicilio, etDniPerfil;
    private Button btnEditarPerfil;
    private ImageView ivPerfil;
    private PerfilViewModel vm;


    public static PerfilFragment newInstance() {
        return new PerfilFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        vm = new ViewModelProvider(this).get(PerfilViewModel.class);
        View root =  inflater.inflate(R.layout.fragment_perfil, container, false);
        vistaInit(root);
        vm.getPropietarioData().observe(getViewLifecycleOwner(), new Observer<Propietario>() {
            @Override
            public void onChanged(Propietario propietario) {
                etNombrePerfil.setText(propietario.getNombre());
                etApellidoPerfil.setText(propietario.getApellido());
                etTelefonoPerfil.setText(propietario.getTelefono());
                etEmailPerfil.setText(propietario.getEmail());
                etDniPerfil.setText(String.valueOf(propietario.getDni()));
                etDomicilio.setText(propietario.getDomicilio());
                Glide.with(getContext()).load("http://192.168.0.142:5000"+ propietario.getFoto()).diskCacheStrategy(DiskCacheStrategy.ALL).into(ivPerfil);


            }
        });
        vm.getEstados().observe(getViewLifecycleOwner(), new Observer<Boolean>() {

            @Override
            public void onChanged(Boolean estado) {
             etNombrePerfil.setEnabled(estado);
             etApellidoPerfil.setEnabled(estado);
             etTelefonoPerfil.setEnabled(estado);
             etEmailPerfil.setEnabled(estado);
             etDniPerfil.setEnabled(estado);
            etDomicilio.setEnabled(estado);
            }
        });

        vm.getTxtBoton().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String txtBoton) {
                btnEditarPerfil.setText(txtBoton);
            }
        });

        vm.leerPropietario();
        return root;
    }

    private void vistaInit(View root) {
        etNombrePerfil = root.findViewById(R.id.etNombrePerfil);
        etApellidoPerfil = root.findViewById(R.id.etApellidoPerfil);
        etTelefonoPerfil = root.findViewById(R.id.etTelefonoPerfil);
        etEmailPerfil = root.findViewById(R.id.etEmailPerfil);
        etDniPerfil = root.findViewById(R.id.etDniPerfil);
        etDomicilio = root.findViewById(R.id.etDomiciliPerfil);
        ivPerfil = root.findViewById(R.id.ivPerfil);
        btnEditarPerfil = root.findViewById(R.id.btnPerfil);

        btnEditarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Propietario p = new Propietario();
                p.setNombre(etNombrePerfil.getText().toString());
                p.setApellido(etApellidoPerfil.getText().toString());
                p.setTelefono(etTelefonoPerfil.getText().toString());
                p.setEmail(etEmailPerfil.getText().toString());
                p.setDni(Integer.parseInt(etDniPerfil.getText().toString()));
                p.setDomicilio(etDomicilio.getText().toString());
                String textoBoton = btnEditarPerfil.getText().toString();

                vm.cambioEstadoBoton(textoBoton, p);


            }
        });

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
   }

}