package com.androidpprog2.crimenes;

import android.content.Context;

import java.util.ArrayList;

public class CrimeLab {

    private static CrimeLab crimeLab;
    private final ArrayList<Task> crimeList;

    public static CrimeLab getInstance(Context context) {
        if (crimeLab == null) {
            crimeLab = new CrimeLab(context);
        }
        return crimeLab;
    }

    public ArrayList<Task> getCrimeList() {
        return crimeList;
    }

    private CrimeLab(Context context) {
        crimeList = new ArrayList<>();
        crimeList.add(new Task("Sacar al Perro",false));
        crimeList.add(new Task("Comprar el Pan",false));
        crimeList.add(new Task("Revisar el correo de la Salle",false));
        crimeList.add(new Task("Preparar reuniones del dia",false));
        crimeList.add(new Task("Hacer ejercicio",false));

    }
}
