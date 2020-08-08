package com.danielvelastegui.deberpetagram.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.danielvelastegui.deberpetagram.MascotasFavoritas;
import com.danielvelastegui.deberpetagram.R;
import com.danielvelastegui.deberpetagram.contenedor.Mascota;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder> {

    ArrayList<Mascota> miMascota;

    public ProfileAdapter(ArrayList<Mascota> miMascota) {
        this.miMascota = miMascota;
    }

    @NonNull
    @Override
    public ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mascota_profile_cv, parent, false);
        return new ProfileViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileViewHolder holder, int position) {
        Mascota publicacion = miMascota.get(position);

        //holder.imgPublicacionCV.setImageResource(publicacion.getFoto());
        Picasso.get()
                .load(publicacion.getFoto())
                .placeholder(R.drawable.ic_profile_icon)
                .error(R.drawable.ic_profile_icon)
                .into(holder.imgPublicacionCV);
        holder.tvMeGustasPublicacionCV.setText(String.valueOf(publicacion.getMeGustas()));
    }

    @Override
    public int getItemCount() {
        return miMascota.size();
    }

    public class ProfileViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgPublicacionCV;
        private TextView tvMeGustasPublicacionCV;

        public ProfileViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPublicacionCV = itemView.findViewById(R.id.imgPublicacionCV);
            tvMeGustasPublicacionCV = itemView.findViewById(R.id.tvMeGustasPublicacionCV);
        }
    }
}
