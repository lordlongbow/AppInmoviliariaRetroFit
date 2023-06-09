package com.example.inmobiliariaac.login;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.inmobiliariaac.menu.MenuActivity;
import com.example.inmobiliariaac.modelos.Propietario;
import com.example.inmobiliariaac.modelos.Usuario;
import com.example.inmobiliariaac.request.ApiClient;
import com.example.inmobiliariaac.request.ApiRest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends AndroidViewModel {
    private Context contexto;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        contexto = application.getApplicationContext();
    }


    /*
public void login (String mail, String password){
    ApiClient apiClient = ApiClient.getApi();
    Propietario propietario = apiClient.login(mail, password);
    if(propietario!=null){
        propietario= apiClient.obtenerUsuarioActual();
        Intent intent = new Intent(contexto, MenuActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("login", true);
        contexto.startActivity(intent);
    }
}*/

    public void login(String mail, String password){
        Usuario propietarioLogueado = new Usuario(mail,password);

        ApiRest.EndPointsApi endPointsApi = ApiRest.getEndPointApi();
        Call<String> llamadaALoguin = endPointsApi.login(propietarioLogueado);
        llamadaALoguin.enqueue(new Callback<String>() {

            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("salida ","yendo "+response.raw() );
                if(response.isSuccessful()){
                    if(response.body()!=null){
                        Log.d("salida ","yendo "+response.body());
                        SharedPreferences sp = contexto.getSharedPreferences("token.xml", 0);
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("token", "Bearer " + response.body());
                        editor.commit();
                        Intent intent = new Intent(contexto, MenuActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("login", true);
                        contexto.startActivity(intent);
                    }

                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("salida ",t.getMessage());
                Toast.makeText(contexto, "Error al Iniciar Sesion", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
