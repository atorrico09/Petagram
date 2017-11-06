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
import com.andresleonel09.petagram.presentador.IMascotasFragmentPresenter;
import com.andresleonel09.petagram.presentador.MascotasFragmentPresenter;

import java.util.ArrayList;

public class MascotasFragment extends Fragment implements IMascotasFragmentView {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IMascotasFragmentPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_mascotas, container, false);
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        presenter = new MascotasFragmentPresenter(this, getContext());

        return v;
    }

    @Override
    public void generarLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdapter crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdapter mAdapter = new MascotaAdapter(mascotas);
        return  mAdapter;
    }

    @Override
    public void inicializarAdaptador(MascotaAdapter mAdapter) {
        listaMascotas.setAdapter(mAdapter);
    }
}
