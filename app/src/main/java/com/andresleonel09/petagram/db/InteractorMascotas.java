package com.andresleonel09.petagram.db;

import android.content.ContentValues;
import android.content.Context;

import com.andresleonel09.petagram.R;
import com.andresleonel09.petagram.model.Mascota;

import java.util.ArrayList;

/**
 * Created by Andres-PC on 2017-11-05.
 */

public class InteractorMascotas {
    private static final Integer LIKE = 1;
    Context context;

    public InteractorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos (){
        BaseDeDatos db = new BaseDeDatos(context);
        insertarCincoMascotas(db);
        return db.obtenerTodasLasMascotas();
    }

    public void insertarCincoMascotas(BaseDeDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_NOMBRE, "perro");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_FOTO, R.drawable.perro);
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_LIKES, 1);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_NOMBRE, "buho");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_FOTO, R.drawable.buho);
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_LIKES, 2);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_NOMBRE, "gallina");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_FOTO, R.drawable.gallina);
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_LIKES, 6);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_NOMBRE, "loro");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_FOTO, R.drawable.loro);
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_LIKES, 5);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_NOMBRE, "pez");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_FOTO, R.drawable.pez);
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_LIKES, 9);
        db.insertarMascota(contentValues);
    }

    public void darLikeMascota (Mascota mascota){
        BaseDeDatos db = new BaseDeDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_LIKES_MASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBD.TABLE_LIKES_MASCOTA_CANT, LIKE);
        db.insertarLikesMascota(contentValues);
    }

    public int obtenerLikesMascota (Mascota mascota){
        BaseDeDatos db = new BaseDeDatos(context);
        return db.obtenerLikesMascotas(mascota);
    }
}
