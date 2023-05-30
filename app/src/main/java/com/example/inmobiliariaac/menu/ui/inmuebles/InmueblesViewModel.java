package com.example.inmobiliariaac.menu.ui.inmuebles;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.inmobiliariaac.modelos.Inmueble;
import com.example.inmobiliariaac.request.ApiClient;
import com.example.inmobiliariaac.request.ApiRest;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class InmueblesViewModel extends AndroidViewModel {

    private Context contexto;
    private ApiClient ap;
    private MutableLiveData<ArrayList<Inmueble>> inmuebles;

    public LiveData<ArrayList<Inmueble>> getInmuebles() {
        if(inmuebles==null){
            inmuebles=new MutableLiveData<>();
        }
        return inmuebles;
    }

    public InmueblesViewModel(@NonNull Application application) {
        super(application);
        contexto=application.getApplicationContext();
    }

    public void obtenerInmuebles(){
        SharedPreferences token = contexto.getSharedPreferences("token.xml", 0);
        ApiRest.EndPointsApi endPointsApi = ApiRest.getEndPointApi();
        Call<List<Inmueble>> llamadaAMisInmuebles = endPointsApi.misInmuebles(token.toString());
        llamadaAMisInmuebles.enqueue(new Callback<List<Inmueble>>() {

            @Override
            public void onResponse(Call<List<Inmueble>> call, Response<List<Inmueble>> response) {
                if(response.isSuccessful()){
                    if(response.body()!=null){
                        inmuebles.setValue((ArrayList<Inmueble>) response.body());

                        Log.d("Inmuebles", inmuebles.toString());

                    }
                }
            }

            @Override
            public void onFailure(Call<List<Inmueble>> call, Throwable t) {
                Toast.makeText(contexto, "Error al Cargar Inmuebles", Toast.LENGTH_SHORT).show();
            }
        });
    }
}