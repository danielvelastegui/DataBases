package com.danielvelastegui.deberpetagram;

import com.danielvelastegui.deberpetagram.adapter.MascotasFavoritasAdapter;
import com.danielvelastegui.deberpetagram.contenedor.Mascota;

import java.util.ArrayList;

public interface IMascotasFavoritasView {
    public void createVerticalLinearLayout();
    public MascotasFavoritasAdapter iniciarAdaptador(ArrayList<Mascota> mascotas);
    public void iniciarRV(MascotasFavoritasAdapter adapter);
}
