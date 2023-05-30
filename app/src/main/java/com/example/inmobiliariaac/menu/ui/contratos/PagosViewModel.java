package com.example.inmobiliariaac.menu.ui.contratos;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.inmobiliariaac.modelos.Contrato;
import com.example.inmobiliariaac.modelos.Pago;
import com.example.inmobiliariaac.request.ApiClient;
import com.example.inmobiliariaac.request.ApiRest;

import java.util.ArrayList;

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
        this.contexto = contexto;

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
        Contrato contratob = (Contrato) bundle.getSerializable("contrato");
        Call<ArrayList<Pago>> llamadaAGetPagos = endPointsApi.getPagos(token.getString("token", ""), contratob);
       llamadaAGetPagos.enqueue( new Callback<ArrayList<Pago>>() {
           @Override
           public void onResponse(Call<ArrayList<Pago>> call, Response<ArrayList<Pago>> response) {
               if(response.isSuccessful()){
                   listaPagos.setValue(response.body());
               }
           }

           @Override
           public void onFailure(Call<ArrayList<Pago>> call, Throwable t) {

           }
       });
    }

}