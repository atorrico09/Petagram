package com.andresleonel09.petagram.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.andresleonel09.petagram.db.InteractorMascotas;
import com.andresleonel09.petagram.model.Mascota;
import com.andresleonel09.petagram.R;

import java.util.ArrayList;

/**
 * Created by Andres-PC on 2017-10-08.
 */

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder> {

    private ArrayList<Mascota> mascotas;

    public MascotaAdapter(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);

        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);

        holder.tvNombreCV.setText(mascota.getNombre());
        holder.imgFoto.setImageResource(mascota.getFoto());

        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext().getApplicationContext(), "Diste LIKE a "+ mascota.getNombre(),
                        Toast.LENGTH_SHORT).show();

                InteractorMascotas interactorMascotas = new InteractorMascotas(v.getContext().getApplicationContext());
                interactorMascotas.darLikeMascota(mascota);

                holder.tvRate.setText(String.valueOf(interactorMascotas.obtenerLikesMascota(mascota)));
            }
        });
        holder.tvRate.setText(String.valueOf(mascota.getLikes()));
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvRate;
        private ImageButton btnLike;
        private ImageButton btnRate;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombre);
            tvRate = (TextView) itemView.findViewById(R.id.tvRate);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
            btnRate = (ImageButton) itemView.findViewById(R.id.btnRate);
        }
    }
}
