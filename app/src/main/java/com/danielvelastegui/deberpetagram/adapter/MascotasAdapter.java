package com.danielvelastegui.deberpetagram.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.danielvelastegui.deberpetagram.contenedor.Mascota;
import com.danielvelastegui.deberpetagram.R;
import com.danielvelastegui.deberpetagram.db.ConstructorMascotas;

import java.util.ArrayList;

public class MascotasAdapter extends RecyclerView.Adapter<MascotasAdapter.MascotasViewHolder>{

    ArrayList<Mascota> misMascotas;
    int meGustas;
    Activity activity;

    public MascotasAdapter(ArrayList<Mascota> misMascotas, Activity activity){
        this.misMascotas = misMascotas;
        this.activity = activity;
        this.meGustas = 0;
    }

    @NonNull
    @Override
    public MascotasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_mascota_cv, parent, false);

        return new MascotasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotasViewHolder holder, int position) {
        final Mascota miMascota = misMascotas.get(position);

        holder.imgMascotaCV.setImageResource(miMascota.getFoto());
        holder.tvNombreCV.setText(miMascota.getNombre());
        holder.tvMeGustasCV.setText(String.valueOf(miMascota.getMeGustas()));

        holder.imgHuesoVacioCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(meGustas == 0){
                    String mensajeToastLike = "Se agrego a favoritos a " + miMascota.getNombre();
                    Toast.makeText(activity, mensajeToastLike, Toast.LENGTH_SHORT).show();
                    meGustas = 1;
                    ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                    constructorMascotas.darLikeMascota(miMascota);
                    holder.tvMeGustasCV.setText(String.valueOf(constructorMascotas.obtenerLike(miMascota)));
                }else if(meGustas == 1){
                    String mensajeToastDisike = "Se elimino de favoritos a " + miMascota.getNombre();
                    Toast.makeText(activity, mensajeToastDisike, Toast.LENGTH_SHORT).show();
                    meGustas = 0;
                    ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                    constructorMascotas.eliminarMascotaFavorita(miMascota);
                    holder.tvMeGustasCV.setText(String.valueOf(constructorMascotas.obtenerLike(miMascota)));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return misMascotas.size();
    }

    public class MascotasViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgMascotaCV;
        private ImageButton imgHuesoVacioCV;
        private TextView tvNombreCV;
        private TextView tvMeGustasCV;
        private ImageView imgHuesoLlenoCV;

        public MascotasViewHolder(@NonNull View itemView) {
            super(itemView);

            imgMascotaCV = itemView.findViewById(R.id.imgMascotaCV);
            imgHuesoVacioCV= itemView.findViewById(R.id.imgHuesoVacioCV);
            tvNombreCV = itemView.findViewById(R.id.tvNombreCV);
            imgHuesoLlenoCV = itemView.findViewById(R.id.imgHuesoLlenoCV);
            tvMeGustasCV = itemView.findViewById(R.id.tvMeGustasCV);

        }
    }
}
