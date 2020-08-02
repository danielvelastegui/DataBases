package com.danielvelastegui.deberpetagram.fragment;

import com.danielvelastegui.deberpetagram.adapter.MascotasAdapter;
import com.danielvelastegui.deberpetagram.contenedor.Mascota;

import java.util.ArrayList;

public interface IHomeFragmentView {
    public void createVerticalLinearLayout();
    public MascotasAdapter iniciarAdaptador(ArrayList<Mascota> mascotas);
    public void iniciarRV(MascotasAdapter adapter);
}
