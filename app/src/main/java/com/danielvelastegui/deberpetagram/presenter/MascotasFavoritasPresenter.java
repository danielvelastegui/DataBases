package com.danielvelastegui.deberpetagram.presenter;

import android.content.Context;

import com.danielvelastegui.deberpetagram.IMascotasFavoritasView;
import com.danielvelastegui.deberpetagram.MascotasFavoritas;
import com.danielvelastegui.deberpetagram.contenedor.Mascota;
import com.danielvelastegui.deberpetagram.db.ConstructorMascotasFavoritas;

import java.util.ArrayList;

public class MascotasFavoritasPresenter implements IMascotasFavoritasPresenter {
    private IMascotasFavoritasView iMascotasFavoritasView;
    private Context context;
    private ArrayList<Mascota> mascotasFavoritas;

    public MascotasFavoritasPresenter(IMascotasFavoritasView iMascotasFavoritasView, Context context) {
        this.iMascotasFavoritasView = iMascotasFavoritasView;
        this.context = context;
        obtenerMascotasFavoritasBD();
    }

    @Override
    public void obtenerMascotasFavoritasBD() {
        ConstructorMascotasFavoritas constructor = new ConstructorMascotasFavoritas(context);
        mascotasFavoritas = constructor.obtenerMascotasFavoritas();
        mostrarMascotasFavoritasBD();
    }

    @Override
    public void mostrarMascotasFavoritasBD() {
        iMascotasFavoritasView.iniciarRV(iMascotasFavoritasView.iniciarAdaptador(mascotasFavoritas));
        iMascotasFavoritasView.createVerticalLinearLayout();
    }
}
