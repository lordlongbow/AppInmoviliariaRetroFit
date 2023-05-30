package com.example.inmobiliariaac.menu.ui.perfil;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliariaac.modelos.Propietario;
import com.example.inmobiliariaac.request.ApiClient;
import com.example.inmobiliariaac.request.ApiRest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilViewModel extends AndroidViewModel {

    private Context contexto;
    private MutableLiveData<Propietario> propietarioData;
    private MutableLiveData<Boolean> estados;
    private MutableLiveData<String> txtBoton;
   // private  ApiClient apiClient;
    private ApiRest apiRest;
    public LiveData<Propietario> getPropietarioData() {

        if(propietarioData == null){
            propietarioData = new MutableLiveData<>();
        }
        return propietarioData;
    }
        public LiveData<Boolean> getEstados() {
        if (estados == null) {
            estados = new MutableLiveData<>();
        }
        return estados;
        }

        public LiveData<String> getTxtBoton() {
        if (txtBoton == null) {
            txtBoton = new MutableLiveData<>();
        }
        return txtBoton;
        }

    public PerfilViewModel(@NonNull Application application) {
        super(application);
        contexto = application.getApplicationContext();

    }
/*
public void leerPropietario(){
    propietarioData.setValue(apiClient.obtenerUsuarioActual());
}
*/
    public void leerPropietario(){
        SharedPreferences sp = contexto.getSharedPreferences("token.xml", 0);
        String token = sp.getString("token", "");
        ApiRest.EndPointsApi endPointsApi = ApiRest.getEndPointApi();

        Call<Propietario> llamadaAPerfil = endPointsApi.perfil(token);
        llamadaAPerfil.enqueue(new Callback<Propietario>() {

            @Override
            public void onResponse(Call<Propietario> call, Response<Propietario> response) {
                if(response.isSuccessful()){
                    if(response.body()!=null){
                        propietarioData.setValue(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<Propietario> call, Throwable t) {
                Toast.makeText(contexto, "Error al mostrar los Datos", Toast.LENGTH_SHORT).show();
            }
        });
    }




public void cambioEstadoBoton(String txBoton, Propietario p){

        if(txBoton.equals("Editar")){
            txtBoton.setValue("Guardar");
            estados.setValue(true);

        }else{
            txtBoton.setValue("Editar");
            estados.setValue(false);
            SharedPreferences sp = contexto.getSharedPreferences("token.xml", 0);
            String token = sp.getString("token", "");
            int id = p.getId();
            ApiRest.EndPointsApi endPointsApi = ApiRest.getEndPointApi();
            Call<Propietario> llamadaAActualizar = endPointsApi.actualizar(token, id, p);
            llamadaAActualizar.enqueue(new Callback<Propietario>() {

                @Override
                public void onResponse(Call<Propietario> call, Response<Propietario> response) {
                    if(response.isSuccessful()){
                        if(response.body()!=null){
                            propietarioData.setValue(response.body());
                        }
                    }
                }

                @Override
                public void onFailure(Call<Propietario> call, Throwable t) {
                    Toast.makeText(contexto, "Error al actualizar los Datos", Toast.LENGTH_SHORT).show();
                }
            });

        }
}

}