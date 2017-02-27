package com.ramillete.sfj.ramilletesfj;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.ramillete.sfj.ramilletesfj.MainActivity;
import com.ramillete.sfj.ramilletesfj.R;

public class ejercicios_esp extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
    Spinner spSemana, spDia;
    TextView ejercicios;
    int semananum=0;
    ArrayAdapter<String> aaSemana, aaDia;
    String [] opSemana = new String [] {"Semana 1", "Semana 2","Semana 3", "Semana 4","Semana 5", "Semana 6","Semana 7", "Semana 8"};
    String [] opDia = new String [] {"Día 1", "Día 2","Día 3", "Día 4","Día 5", "Día 6","Día 7"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicios_esp);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ejercicios = (TextView) findViewById(R.id.textViewEjercicios);


        spSemana = (Spinner) findViewById(R.id.spinnerSemana);
        spDia = (Spinner) findViewById(R.id.spinnerDia);

        spSemana.setOnItemSelectedListener(this);
        spDia.setOnItemSelectedListener(this);
//Estilos de Spinners
        //aaSemana = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opSemana);
        aaSemana = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,opSemana);
        aaDia = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opDia);


        spSemana.setAdapter(aaSemana);
       // spDia.setAdapter(aaDia);

   }
//ejercicios.setText("Hola Mundo desde 1");
    //spDia.setAdapter(aaDia);
    //int selecc = spSemana.getSelectedItemPosition();
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.spinnerSemana:
                int selecc = spSemana.getSelectedItemPosition();
                Log.d("SeleccSemana", spSemana.toString());
                switch (selecc) {
                    case 0:Log.d("Semana1", "Semana 1");

                        ejercicios.setText("Seleccionar dia");
                        spDia.setAdapter(aaDia);
                        semananum = 1;
                        Log.d("SeleccDia", spDia.toString());

                        break;
                    case 1:Log.d("Semana2", "Semana 2");
                        spDia.setAdapter(aaDia);
                        ejercicios.setText("Seleccionar dia");
                        semananum =2;
                        break;
                }
             break;
           case R.id.spinnerDia:
                int selcDia = spDia.getSelectedItemPosition();
               switch (semananum) {
                   case 1:
                       switch (selcDia) {
                       case 0:Log.d("Semana1", "Dia 1");
                           ejercicios.setText("@Ramillete/sem1Dia1");
                           break;
                       case 1:Log.d("Semana1", "Dia 2");
                           ejercicios.setText("@Ramillete/sem1Dia2");
                           break;

                        }
                   break;
                   case 2:
                       switch (selcDia) {
                           case 0:Log.d("Semana2", "Dia 1");
                               ejercicios.setText("Semana 2 Estas en el dia 1");
                               break;
                           case 1:Log.d("Semana2", "Dia 2");
                               ejercicios.setText("Semana 2 Estas en el dia 2");
                               break;


                       }
                       break;
               }

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
