package com.example.inmobiliariaac.menu.ui.contratos;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.inmobiliariaac.modelos.Contrato;
import com.example.inmobiliariaac.modelos.Inmueble;
import com.example.inmobiliariaac.modelos.Pago;
import com.example.inmobiliariaac.request.ApiRest;

import java.io.Serializable;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContratoDetalleViewModel extends AndroidViewModel {
    private Context contexto;
    private MutableLiveData<Inmueble> inmueble;
    private MutableLiveData<Contrato> contrato;

    private MutableLiveData<ArrayList<Pago>> pagos;

    public ContratoDetalleViewModel(@NonNull Application application) {
        super(application);
        contexto = application.getApplicationContext();
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

        Contrato contrato = (Contrato) b.getSerializable("contrato");
        this.contrato.postValue(contrato);
        Log.d("inquilino", contrato + "");
        SharedPreferences token = contexto.getSharedPreferences("token.xml", 0);
        ApiRest.EndPointsApi endPointsApi = ApiRest.getEndPointApi();


  /*    Call<ArrayList<Pago>> obtenerPagos = endPointsApi.getPagos(token.getString("token", ""), contrato.getContratoId());
        obtenerPagos.enqueue(new Callback<ArrayList<Pago>>() {
            @Override
            public void onResponse(Call<ArrayList<Pago>> call, Response<ArrayList<Pago>> response) {
                                pagos.postValue(response.body());


            }

            @Override
            public void onFailure(Call<ArrayList<Pago>> call, Throwable t) {

            }
        });
*/
        }

    }
