package com.andresleonel09.petagram.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andresleonel09.petagram.R;
import com.andresleonel09.petagram.adapter.PerfilAdapter;
import com.andresleonel09.petagram.model.Mascota;

import java.util.ArrayList;

public class PerfilFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        glm.setOrientation(GridLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(glm);

        inicializarListaMascotas();
        inicializarAdaptador();

        return v;
    }

    private void inicializarAdaptador() {
        PerfilAdapter mAdapter = new PerfilAdapter(mascotas);
        listaMascotas.setAdapter(mAdapter);
    }

    private void inicializarListaMascotas() {
        mascotas = new ArrayList<>();

        mascotas.add(new Mascota(R.drawable.perro,1));
        mascotas.add(new Mascota(R.drawable.perro,2));
        mascotas.add(new Mascota(R.drawable.perro,6));
        mascotas.add(new Mascota(R.drawable.perro,5));
        mascotas.add(new Mascota(R.drawable.perro,9));
        mascotas.add(new Mascota(R.drawable.perro,10));
        mascotas.add(new Mascota(R.drawable.perro,0));
    }
}
