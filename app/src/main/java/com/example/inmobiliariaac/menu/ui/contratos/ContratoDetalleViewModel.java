package com.example.inmobiliariaac.menu.ui.contratos;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliariaac.modelos.Contrato;
import com.example.inmobiliariaac.modelos.Inmueble;
import com.example.inmobiliariaac.request.ApiRest;

import java.io.Closeable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContratoDetalleViewModel extends ViewModel {
    private Context contexto;
    private MutableLiveData<Inmueble> inmueble;
    private MutableLiveData<Contrato> contrato;

    public ContratoDetalleViewModel(Context contexto, @NonNull Closeable... closeables) {
        super(closeables);
        this.contexto = contexto;
    }

    public LiveData<Inmueble> getInmueble() {
        if (inmueble == null) {
            inmueble = new MutableLiveData<>();
        }
        return inmueble;
    }

    public LiveData<Contrato> getContrato() {
        if (contrato == null) {
            contrato = new MutableLiveData<>();
        }

        return contrato;
    }

    public void recuperaInmuebleYContrato(Bundle b){

       // Inmueble inmueble = (Inmueble) b.getSerializable("inmueble");
       // this.inmueble.setValue(inmueble);
        Inmueble inmueble = (Inmueble) b.getSerializable("inmueble");
        this.inmueble.setValue(inmueble);
        SharedPreferences token = contexto.getSharedPreferences("token.xml", 0);
        ApiRest.EndPointsApi endPointsApi = ApiRest.getEndPointApi();
        Call<Contrato> ObtenerContrato= endPointsApi.ObtenerContrato(token.getString("token", ""), inmueble.getInmuebleId());
        ObtenerContrato.enqueue(new Callback<Contrato>() {

            @Override
            public void onResponse(Call<Contrato> call, Response<Contrato> response) {
                contrato.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Contrato> call, Throwable t) {
                Toast.makeText(contexto, "Error al  conseguir el contrato", Toast.LENGTH_SHORT).show();
            }
        });
    }
}