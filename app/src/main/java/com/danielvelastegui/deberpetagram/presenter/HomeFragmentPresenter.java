package com.danielvelastegui.deberpetagram.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.danielvelastegui.deberpetagram.contenedor.Mascota;
import com.danielvelastegui.deberpetagram.db.ConstructorMascotas;
import com.danielvelastegui.deberpetagram.fragment.IHomeFragmentView;
import com.danielvelastegui.deberpetagram.restApi.EndPointsApi;
import com.danielvelastegui.deberpetagram.restApi.adapter.RestApiAdapter;
import com.danielvelastegui.deberpetagram.restApi.model.MascotaResponse;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragmentPresenter implements IHomeFragmentPresenter {
    private IHomeFragmentView iHomeFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    ArrayList<Mascota> mascotas;

    public HomeFragmentPresenter(IHomeFragmentView iHomeFragmentView, Context context) {
        this.iHomeFragmentView = iHomeFragmentView;
        this.context = context;
        //obtenerMascotasBD();
        getUserMedia();
    }

    @Override
    public void obtenerMascotasBD() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatosMascotas();
        mostrarMascotasBD();
    }

    @Override
    public void mostrarMascotasBD() {
        iHomeFragmentView.iniciarRV(iHomeFragmentView.iniciarAdaptador(mascotas));
        iHomeFragmentView.createVerticalLinearLayout();
    }

    @Override
    public void getUserMedia() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.buildDeserializerMediaRecent();
        EndPointsApi endPointsApi = restApiAdapter.establecerConexionApiInstagram(gsonMediaRecent);
        Call<MascotaResponse> mascotaResponseCall =  endPointsApi.getRecentMedia();

        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse mascotaResponse = response.body();
                mascotas = mascotaResponse.getMascotas();
                mostrarMascotasBD();
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Toast.makeText(context, "Ocurrio un error", Toast.LENGTH_SHORT).show();
                Log.e("FALLO LA CONEXION", t.toString());
            }
        });
    }
}
