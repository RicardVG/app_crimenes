package com.androidpprog2.crimenes;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;

public class CrimeActivity extends AppCompatActivity {

    private ArrayList<Crime> crimeList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_crime_list);
        crimeList = new ArrayList<>();


        setCrimeInfo();
    }

    private void setCrimeInfo() {
        crimeList.add(new Crime("Sacar al Perro","PENDIENTE"));
        crimeList.add(new Crime("Comprar el Pan","PENDIENTE"));
        crimeList.add(new Crime("Revisar el correo de la Salle","PENDIENTE"));
        crimeList.add(new Crime("Preparar reuniones del dia","PENDIENTE"));
        crimeList.add(new Crime("Hacer ejercicio","PENDIENTE"));
    }


}
