package com.andresleonel09.petagram.activity;

import com.andresleonel09.petagram.R;
import com.andresleonel09.petagram.adapter.MascotaAdapter;
import com.andresleonel09.petagram.model.Mascota;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class FavoritosActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);
        setToolbar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotasFav);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();
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

    private void setToolbar() {
        Toolbar miActionBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(miActionBar);
    }

}