package com.danielvelastegui.deberpetagram.restApi;

import retrofit2.Call;
import retrofit2.http.GET;

import com.danielvelastegui.deberpetagram.restApi.model.MascotaResponse;

public interface EndPointsApi {
    @GET(ConstantesRestApi.URL_GET_MEDIA_USER)
    Call<MascotaResponse> getRecentMedia();
}
