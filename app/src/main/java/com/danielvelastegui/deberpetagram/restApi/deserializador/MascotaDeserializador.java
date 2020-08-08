package com.danielvelastegui.deberpetagram.restApi.deserializador;

import com.danielvelastegui.deberpetagram.contenedor.Mascota;
import com.danielvelastegui.deberpetagram.restApi.JsonKeys;
import com.danielvelastegui.deberpetagram.restApi.model.MascotaResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

import retrofit2.converter.gson.GsonConverterFactory;

public class MascotaDeserializador implements JsonDeserializer<MascotaResponse> {
    @Override
    public MascotaResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        MascotaResponse mascotaResponse = gson.fromJson(json, MascotaResponse.class);
        JsonArray mascotaData = json.getAsJsonObject().getAsJsonArray(JsonKeys.RESPONSE_ARRAY_MEDIA);

        mascotaResponse.setMascotas(deserializarJson(mascotaData));
        return mascotaResponse;
    }

    private ArrayList<Mascota> deserializarJson(JsonArray mascotaData){
        ArrayList<Mascota>  mascotas = new ArrayList<>();

        for(int i = 0; i < mascotaData.size(); i++){
            Mascota mascotaActual = new Mascota();
            JsonObject mascotaUser = mascotaData.get(i).getAsJsonObject();
            String id = mascotaUser.get(JsonKeys.DATA_USER).getAsString();
            String foto = mascotaUser.get(JsonKeys.DATA_MEDIA_URL).getAsString();
            int likes = Integer.parseInt(mascotaUser.get(JsonKeys.DATA_LIKES).getAsString().substring(6,7));

            mascotaActual.setId(id);
            mascotaActual.setNombre(id);
            mascotaActual.setFoto(foto);
            mascotaActual.setMeGustas(likes);

            mascotas.add(mascotaActual);
        }

        return mascotas;
    }
}
