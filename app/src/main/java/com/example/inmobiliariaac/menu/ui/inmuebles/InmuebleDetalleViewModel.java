package com.example.inmobiliariaac.menu.ui.inmuebles;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.inmobiliariaac.modelos.Inmueble;
import com.example.inmobiliariaac.request.ApiRest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Path;

public class InmuebleDetalleViewModel extends AndroidViewModel {
  private MutableLiveData<Inmueble> inmueble;
  private Context contexto;
  private MutableLiveData<CheckBox> checkbox;
    public InmuebleDetalleViewModel(@NonNull Application application) {

        super(application);
        this.contexto = getApplication().getApplicationContext();
    }

    public LiveData<Inmueble> getInmueble() {
        if (inmueble == null) {
            inmueble = new MutableLiveData<>();
        }
        return inmueble;
    }

    public LiveData<CheckBox> getCheckBox() {
        if (checkbox == null) {
            checkbox = new MutableLiveData<>();
        }
        return checkbox;
    }
    public void recuperaInmueble(Bundle b){
        Inmueble inmueble = (Inmueble) b.getSerializable("inmueble");
        this.inmueble.postValue(inmueble);
    }

    public void disponible(Inmueble i){
        SharedPreferences sp = contexto.getSharedPreferences("token.xml", 0);
        String token = sp.getString("token", "");
        ApiRest.EndPointsApi endPointsApi = ApiRest.getEndPointApi();
        int inmuebleId = i.getInmuebleId();
        Log.d("estamosDisponible", i + "i");
        Call<Inmueble> llamadaACambioDisponibilidad = endPointsApi.cambioDisponibilidad(token, inmuebleId);
        llamadaACambioDisponibilidad.enqueue(new Callback<Inmueble>() {

            @Override
            public void onResponse(Call<Inmueble> call, Response<Inmueble> response) {
                Log.d("EntroOnresponse", "Estoy en cambio de disponibilidad " + inmuebleId + " "+ i);
                Inmueble inmueble = (Inmueble) response.body();

                Log.d("EntroOnresponse2", "Estoy en cambio de disponibilidad " + inmuebleId + " "+ inmueble);
            }

            @Override
            public void onFailure(Call<Inmueble> call, Throwable t) {
                Log.d("Entroaca", t.getMessage());
                Toast.makeText(contexto, "Inmueble no actualizado", Toast.LENGTH_SHORT).show();
            }
        });
    }
}