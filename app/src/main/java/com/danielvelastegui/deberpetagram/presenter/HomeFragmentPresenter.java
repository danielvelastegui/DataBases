package com.danielvelastegui.deberpetagram.presenter;

import android.content.Context;

import com.danielvelastegui.deberpetagram.contenedor.Mascota;
import com.danielvelastegui.deberpetagram.db.ConstructorMascotas;
import com.danielvelastegui.deberpetagram.fragment.IHomeFragmentView;

import java.util.ArrayList;

public class HomeFragmentPresenter implements IHomeFragmentPresenter {
    private IHomeFragmentView iHomeFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    ArrayList<Mascota> mascotas;

    public HomeFragmentPresenter(IHomeFragmentView iHomeFragmentView, Context context) {
        this.iHomeFragmentView = iHomeFragmentView;
        this.context = context;
        obtenerMascotasBD();
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
}
