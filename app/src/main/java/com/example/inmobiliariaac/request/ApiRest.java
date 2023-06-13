package com.example.inmobiliariaac.request;

import com.example.inmobiliariaac.modelos.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

import com.example.inmobiliariaac.modelos.Contrato;
import com.example.inmobiliariaac.modelos.Inmueble;
import com.example.inmobiliariaac.modelos.Pago;
import com.example.inmobiliariaac.modelos.Propietario;

import java.util.List;

public class ApiRest {
    private static final String URL_BASE = "http://192.168.0.142:5000/";
    //Intentar guardar ip en una variable tipo secret consultar
    private final String URL_BASE_LOCAL = "http://38.0.101.76:8080/";

    private static EndPointsApi endPointsApi;

    public static EndPointsApi getEndPointApi() {
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        endPointsApi = retrofit.create(EndPointsApi.class);

        return endPointsApi;
    }

        public interface EndPointsApi {

            @GET()
        Call<EndPointsApi> getData();

        //Propietario

        @POST("api/propietario/login")
        Call<String> login(@Body Usuario propietario);

        @GET("api/propietario/perfil")
        Call<Propietario> perfil(@Header("Authorization") String token);

        @PUT("api/propietario/actualizar")
        Call<Propietario> ActualizarPerfil(@Header("Authorization") String token, @Body Propietario propietario);

        //Inmueble

        @GET("api/inmueble")
        Call<List<Inmueble>> misInmuebles(@Header("Authorization") String token);

        @PUT("api/inmueble/{id}")
        Call<Inmueble> cambioDisponibilidad(@Header("Authorization") String token, @Path("id") int id);

        //Contrato

        @GET("api/contrato/")
        Call<List<Contrato>> getMisContratos(@Header("Authorization") String token);

        @GET("api/contrato/{id}")
        Call<Contrato> ObtenerContrato(@Header("Authorization") String token, @Path("id") int id);

        //Pago
        @GET("api/pago/{id_contrato}")
        Call<List<Pago>> ObtenerPagos(@Header("Authorization") String token, @Path("id_contrato") int id);

    }
}