package com.andresleonel09.petagram.presentador;

import android.content.Context;

import com.andresleonel09.petagram.db.InteractorMascotas;
import com.andresleonel09.petagram.fragment.IMascotasFragmentView;
import com.andresleonel09.petagram.model.Mascota;

import java.util.ArrayList;

/**
 * Created by Andres-PC on 2017-11-05.
 */

public class MascotasFragmentPresenter implements IMascotasFragmentPresenter {
    private IMascotasFragmentView iMascotasFragmentView;
    private Context context;
    private InteractorMascotas interactorMascotas;
    private ArrayList<Mascota> mascotas;

    public MascotasFragmentPresenter(IMascotasFragmentView iMascotasFragmentView, Context context) {
        this.iMascotasFragmentView = iMascotasFragmentView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        interactorMascotas = new InteractorMascotas(context);
        mascotas = interactorMascotas.obtenerDatos();
        mostrarMascotas();
    }

    @Override
    public void mostrarMascotas() {
        iMascotasFragmentView.inicializarAdaptador(iMascotasFragmentView.crearAdaptador(mascotas));
        iMascotasFragmentView.generarLayoutVertical();
    }
}
