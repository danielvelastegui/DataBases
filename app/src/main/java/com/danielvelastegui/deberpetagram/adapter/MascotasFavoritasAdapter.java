package com.danielvelastegui.deberpetagram.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.danielvelastegui.deberpetagram.contenedor.Mascota;
import com.danielvelastegui.deberpetagram.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MascotasFavoritasAdapter extends RecyclerView.Adapter<MascotasFavoritasAdapter.MascotasFavoritasViewHolder>{

    ArrayList<Mascota> mascotasFavoritas;

    public MascotasFavoritasAdapter(ArrayList<Mascota> mascotasFavoritas) {
        this.mascotasFavoritas = mascotasFavoritas;
    }

    @NonNull
    @Override
    public MascotasFavoritasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mascota_favorita_cv, parent, false);
        return new MascotasFavoritasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotasFavoritasViewHolder holder, int position) {
        Mascota mascotaFavorita = mascotasFavoritas.get(position);

        Picasso.get()
                .load(mascotaFavorita.getFoto())
                .placeholder(R.drawable.ic_profile_icon)
                .error(R.drawable.ic_profile_icon)
                .into(holder.imgFotoFavoritaCV);
        //holder.imgFotoFavoritaCV.setImageResource(mascotaFavorita.getFoto());
        holder.tvNombreFavoritaCV.setText(mascotaFavorita.getNombre());
        holder.tvMeGustasFavoritaCV.setText(String.valueOf(mascotaFavorita.getMeGustas()));
    }

    @Override
    public int getItemCount() {
        return mascotasFavoritas.size();
    }

    public class MascotasFavoritasViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFotoFavoritaCV;
        private TextView tvNombreFavoritaCV;
        private TextView tvMeGustasFavoritaCV;

        public MascotasFavoritasViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFotoFavoritaCV = itemView.findViewById(R.id.imgFotoFavoritaCV);
            tvNombreFavoritaCV = itemView.findViewById(R.id.tvNombreFavoritaCV);
            tvMeGustasFavoritaCV = itemView.findViewById(R.id.tvMeGustasFavoritaCV);
        }
    }
}
