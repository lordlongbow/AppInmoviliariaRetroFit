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
import com.example.inmobiliariaac.modelos.Pago;
import com.example.inmobiliariaac.request.ApiClient;
import com.example.inmobiliariaac.request.ApiRest;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PagosViewModel extends AndroidViewModel {
        private Context contexto;
        private MutableLiveData<ArrayList<Pago>> listaPagos;
        private MutableLiveData<Contrato> contrato;

        private ApiClient ap;


    public PagosViewModel(@NonNull Application application) {
        super(application);
        this.contexto = application.getApplicationContext();

    }

    public LiveData<ArrayList<Pago>> getListaPagos(){
        if(listaPagos == null){
            listaPagos = new MutableLiveData<>();
        }
        return listaPagos;
    }

    public void recuperaPagos(Bundle bundle){
        SharedPreferences token = contexto.getSharedPreferences("token.xml", 0);
        ApiRest.EndPointsApi endPointsApi = ApiRest.getEndPointApi();
        Contrato contratob = (Contrato) bundle.getSerializable("contratopago");
        Log.d("pagosContrato", contratob + "");
        Log.d("idContrato", contratob.getContratoId() + "");
       // this.contrato.postValue(contratob);
        Call<List<Pago>> llamadaAGetPagos = endPointsApi.ObtenerPagos(token.getString("token", ""), contratob.getContratoId());
       llamadaAGetPagos.enqueue( new Callback<List<Pago>>() {
           @Override
           public void onResponse(Call<List<Pago>> call, Response<List<Pago>> response) {

                   listaPagos.postValue( (ArrayList<Pago>) response.body());
                   Log.d("listapagos" , listaPagos + "");

               Log.d("listapagos2" , listaPagos + "");

           }

           @Override
           public void onFailure(Call<List<Pago>> call, Throwable t) {
               Log.d("entro error" , t.toString());

           }


       });
    }

}