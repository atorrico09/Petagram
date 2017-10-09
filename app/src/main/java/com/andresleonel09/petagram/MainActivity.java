package com.andresleonel09.petagram;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Se presionó el FAB", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

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

        mascotas.add(new Mascota(R.drawable.perro,"perro"));
        mascotas.add(new Mascota(R.drawable.buho,"buho"));
        mascotas.add(new Mascota(R.drawable.gallina,"gallina"));
        mascotas.add(new Mascota(R.drawable.loro,"loro"));
        mascotas.add(new Mascota(R.drawable.pez,"pez"));
    }

    private void setToolbar() {
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_favorite:
                Intent i = new Intent(this, FavoritosActivity.class);
                startActivity(i);
                return true;
            case R.id.action_settings:
                showSnackBar("Se abren los ajustes");
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
    /**
     * Proyecta una {@link Snackbar} con el string usado
     *
     * @param msg Mensaje
     */
    private void showSnackBar(String msg) {
        Snackbar
                .make(findViewById(R.id.main_layout), msg, Snackbar.LENGTH_LONG)
                .show();
    }


}
