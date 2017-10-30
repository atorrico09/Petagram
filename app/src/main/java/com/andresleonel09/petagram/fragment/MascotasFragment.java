package com.andresleonel09.petagram.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andresleonel09.petagram.R;
import com.andresleonel09.petagram.adapter.MascotaAdapter;
import com.andresleonel09.petagram.model.Mascota;

import java.util.ArrayList;

public class MascotasFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mascotas, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();

        return v;
    }

    private void inicializarAdaptador() {
        MascotaAdapter mAdapter = new MascotaAdapter(mascotas);
        listaMascotas.setAdapter(mAdapter);
    }

    private void inicializarListaMascotas() {
        mascotas = new ArrayList<>();

        mascotas.add(new Mascota(R.drawable.perro,"perro",1));
        mascotas.add(new Mascota(R.drawable.buho,"buho",2));
        mascotas.add(new Mascota(R.drawable.gallina,"gallina",6));
        mascotas.add(new Mascota(R.drawable.loro,"loro",5));
        mascotas.add(new Mascota(R.drawable.pez,"pez",9));
    }
}
