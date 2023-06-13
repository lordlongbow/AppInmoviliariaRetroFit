package com.example.inmobiliariaac.menu.ui.contratos;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.inmobiliariaac.modelos.Inmueble;

import com.example.inmobiliariaac.modelos.Contrato;
import com.example.inmobiliariaac.request.ApiClient;
import com.example.inmobiliariaac.request.ApiRest;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContratosViewModel extends AndroidViewModel {

    private Context contexto;
    private ApiClient ap;
    private MutableLiveData<ArrayList<Inmueble>> inmuebles;
    private MutableLiveData<ArrayList<Contrato>> contratos;
    public ContratosViewModel(@NonNull Application application) {
        super(application);
       contexto = application.getApplicationContext();

    }

    public LiveData getInmuebles() {
        if (inmuebles == null) {
            inmuebles = new MutableLiveData<>();
        }
        return inmuebles;
    }

    public MutableLiveData<ArrayList<Contrato>> getContratos() {
        if (contratos == null) {
            contratos = new MutableLiveData<>();
        }
        return contratos;
    }

    /*public void obtenerPropiedadesAlquiladas(){
        ArrayList<Inmueble> propiedades = ap.obtenerPropiedadesAlquiladas();
        this.inmuebles.setValue(propiedades);
    }*/

    public void obternrPropiedadesAlquiladas(){
        SharedPreferences token = contexto.getSharedPreferences("token.xml", 0);
        ApiRest.EndPointsApi endPointsApi = ApiRest.getEndPointApi();
       /* Call<List<Inmueble>> llamadaAMisInmueblesAlquilados = endPointsApi.misInmuebles(token.getString("token", ""));
        llamadaAMisInmueblesAlquilados.enqueue(new Callback<List<Inmueble>>() {

            @Override
            public void onResponse(Call<List<Inmueble>> call, Response<List<Inmueble>> response) {
                if(response.isSuccessful()){
                    if(response.body()!=null){
                        inmuebles.setValue((ArrayList<Inmueble>) response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Inmueble>> call, Throwable t) {
                Toast.makeText(contexto, "Error al cargar los inmuebles", Toast.LENGTH_SHORT).show();
            }
        });*/
        Call <List<Contrato>>llamadaAMisContratos = endPointsApi.getMisContratos(token.getString("token", ""));
        llamadaAMisContratos.enqueue(new Callback<List<Contrato>>() {

            @Override
            public void onResponse(Call<List<Contrato>> call, Response<List<Contrato>> response) {
                contratos.postValue((ArrayList<Contrato>) response.body());
            }

            @Override
            public void onFailure(Call<List<Contrato>> call, Throwable t) {
                Toast.makeText(contexto, "Error al conseguir los contratos", Toast.LENGTH_SHORT).show();
            }
        });
    }
}