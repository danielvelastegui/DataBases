package com.danielvelastegui.deberpetagram.restApi.adapter;

import com.danielvelastegui.deberpetagram.restApi.ConstantesRestApi;
import com.danielvelastegui.deberpetagram.restApi.EndPointsApi;
import com.danielvelastegui.deberpetagram.restApi.deserializador.MascotaDeserializador;
import com.danielvelastegui.deberpetagram.restApi.model.MascotaResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiAdapter {
    public EndPointsApi establecerConexionApiInstagram(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(EndPointsApi.class);
    }

    public Gson buildDeserializerMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotaResponse.class, new MascotaDeserializador());
        return gsonBuilder.create();
    }
}
