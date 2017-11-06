package com.andresleonel09.petagram.fragment;

import com.andresleonel09.petagram.adapter.MascotaAdapter;
import com.andresleonel09.petagram.model.Mascota;

import java.util.ArrayList;

/**
 * Created by Andres-PC on 2017-11-05.
 */

public interface IMascotasFragmentView {
    void generarLayoutVertical ();

    MascotaAdapter crearAdaptador(ArrayList<Mascota> mascotas);

    void inicializarAdaptador(MascotaAdapter adaptador);



}
