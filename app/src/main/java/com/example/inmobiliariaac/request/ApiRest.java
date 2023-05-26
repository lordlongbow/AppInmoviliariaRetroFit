package com.example.inmobiliariaac.request;

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
import com.example.inmobiliariaac.modelos.Inquilino;
import com.example.inmobiliariaac.modelos.Pago;
import com.example.inmobiliariaac.modelos.Propietario;

import java.util.List;

public class ApiRest {
    private static final String URL_BASE = "http://38.0.101.76:8080/inmobiliariaac/";
    //Intentar guardar ip en una variable tipo secret consultar
    private final String URL_BASE_LOCAL = "http://38.0.101.76:8080/inmobiliariaac/";
    private static EndPointsApi endPointsApi;

    private static EndPointsApi getEndPointApi() {
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        endPointsApi = retrofit.create(EndPointsApi.class);
        return endPointsApi;
    }

    private interface EndPointsApi {

        //Propietario

        @POST("api/propietario/login")
        Call<String> login(@Body Propietario propietario);

        @GET("api/propietario/perfil")
        Call<String> perfil(@Body Propietario propietario, @Header("Authorization") String token);

        @PUT("api/propietario/actualizar/{id}")
        Call<String> actualizar(@Header("Authorization") String token, @Path("id") int id, @Body Propietario propietario);
        /*
        encontrar equivalenete a iformfile o mandar foto como bitmap
        @PUT("api/propietario/actualizar/foto/{id}")
        Call<String> actualizarFoto(@Header("Authorization") String token, @Path("id") int id, @Body Propietario propietario);
        */

        @PUT("api/propietario/cambiocontraseña/{id}")
        Call<String> cambiocontraseña(@Header("Authorization") String token, @Body Propietario propietario);

        //Inmueble

        @GET("api/inmueble/misInmuebles")
        Call<List<Inmueble>> misInmuebles(@Header("Authorization") String token);

        @PUT("api/inmueble/cambioDisponibilidad/{id}")
        Call<Inmueble> cambioDisponibilidad(@Header("Authorization") String token, @Path("id") int id, @Body Inmueble inmueble);

        //Contrato

        @GET("api/contrato/")
        Call<List<Contrato>> getMisContratos(@Header("Authorization") String token, @Body Propietario propietario);

        @GET("api/contrato/{id}")
        Call<Contrato> ObtenerContrato(@Header("Authorization") String token, @Path("id") int id);

        //Pago
        @GET("api/pago/")
        Call<List<Pago>> Get(@Header("Authorization") String token, @Body Contrato contrato);

    }
}