package com.danielvelastegui.deberpetagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.danielvelastegui.deberpetagram.adapter.MascotasFavoritasAdapter;
import com.danielvelastegui.deberpetagram.contenedor.Mascota;
import com.danielvelastegui.deberpetagram.presenter.IMascotasFavoritasPresenter;
import com.danielvelastegui.deberpetagram.presenter.MascotasFavoritasPresenter;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity implements IMascotasFavoritasView {
    private Toolbar favoriteToolBar;
    private RecyclerView rvMascotasFavoritas;
    private IMascotasFavoritasPresenter presenter;

    ArrayList<Mascota> mascotasFavoritas = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        favoriteToolBar = findViewById(R.id.favoriteToolBar);
        rvMascotasFavoritas = findViewById(R.id.rvMascotasFavoritas);
        setSupportActionBar(favoriteToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        createVerticalLinearLayout();
        presenter = new MascotasFavoritasPresenter(this, MascotasFavoritas.this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.favoritos_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.fmContacto:
                Intent intentContact = new Intent(MascotasFavoritas.this, Contact.class);
                startActivity(intentContact);
                break;
            case R.id.fmAcerca:
                Intent intentAbout = new Intent(MascotasFavoritas.this, About.class);
                startActivity(intentAbout);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void createVerticalLinearLayout() {
        LinearLayoutManager llm = new LinearLayoutManager(MascotasFavoritas.this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotasFavoritas.setLayoutManager(llm);
    }

    @Override
    public MascotasFavoritasAdapter iniciarAdaptador(ArrayList<Mascota> mascotas) {
        MascotasFavoritasAdapter adaptador;
        adaptador = new MascotasFavoritasAdapter(mascotas);
        return adaptador;
    }

    @Override
    public void iniciarRV(MascotasFavoritasAdapter adapter) {
        rvMascotasFavoritas.setAdapter(adapter);
    }
}