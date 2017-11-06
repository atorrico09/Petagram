package com.andresleonel09.petagram.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.andresleonel09.petagram.model.Mascota;

import java.util.ArrayList;

/**
 * Created by Andres-PC on 2017-11-05.
 */

public class BaseDeDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDeDatos(Context context) {
        super(context, ConstantesBD.DATABASE_NAME, null, ConstantesBD.VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCreateTableMascota = "CREATE TABLE " + ConstantesBD.TABLE_MASCOTAS + "(" +
                                          ConstantesBD.TABLE_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                          ConstantesBD.TABLE_MASCOTAS_NOMBRE + " TEXT, " +
                                          ConstantesBD.TABLE_MASCOTAS_FOTO + " INTEGER, " +
                                          ConstantesBD.TABLE_MASCOTAS_LIKES + " INTEGER " +
                                         ")";
        String queryCreateTableLikesMascota = "CREATE TABLE " + ConstantesBD.TABLE_MASCOTAS_LIKES + "(" +
                                               ConstantesBD.TABLE_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                               ConstantesBD.TABLE_LIKES_MASCOTA_ID_MASCOTA + " INTEGER, " +
                                               ConstantesBD.TABLE_LIKES_MASCOTA_CANT + " INTEGER, " +
                                               "FOREIGN KEY ("+ConstantesBD.TABLE_LIKES_MASCOTA_ID_MASCOTA + ") " +
                                               "REFERENCES " + ConstantesBD.TABLE_MASCOTAS + "("+ConstantesBD.TABLE_MASCOTAS+") "+
                                               ")";
        db.execSQL(queryCreateTableMascota);
        db.execSQL(queryCreateTableLikesMascota);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST "+ConstantesBD.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXIST "+ConstantesBD.TABLE_LIKES_MASCOTA);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodasLasMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBD.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActual =  new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            mascotas.add(mascotaActual);
        }
        db.close();
        return mascotas;
    }

    public void insertarMascota(ContentValues cValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBD.TABLE_MASCOTAS, null, cValues);
        db.close();
    }
}