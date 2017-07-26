package com.ramillete.sfj.ramilletesfj;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class liturgia_menu extends AppCompatActivity implements View.OnClickListener {

    public TextView Titulo;
    public int valorRezoLitu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liturgia_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Calendar calendarNow = Calendar.getInstance();
        int monthDay =calendarNow.get(Calendar.DAY_OF_MONTH);
        int month = calendarNow.get(Calendar.MONTH);
        month=month+1;
        String month2 = null;
        int year = calendarNow.get(Calendar.YEAR);

        switch (month){
            case 1:month2="ene";
                break;
            case 2:month2="feb";
                break;
            case 3:month2="mar";
                break;
            case 4:month2="abr";
                break;
            case 5:month2="may";
                break;
            case 6:month2="jun";
                break;
            case 7:month2="jul";
                break;
            case 8:month2="ago";
                break;
            case 9:month2="sep";
                break;
            case 10:month2="oct";
                break;
            case 11:month2="nov";
                break;
            case 12:month2="dic";
                break;
        }

        Titulo=(TextView) findViewById(R.id.titulo_liturgiaMen);
        Titulo.setText("  Liturgia de las horas "+monthDay+", "+month2+", "+year);

        Button boton1 = (Button) findViewById(R.id.button1);
        boton1.setOnClickListener(this);
        Button boton2 = (Button) findViewById(R.id.button2);
        boton2.setOnClickListener(this);
        Button boton3 = (Button) findViewById(R.id.button3);
        boton3.setOnClickListener(this);
        Button boton4 = (Button) findViewById(R.id.button4);
        boton4.setOnClickListener(this);
        Button boton5 = (Button) findViewById(R.id.button5);
        boton5.setOnClickListener(this);
        Button boton6 = (Button) findViewById(R.id.button6);
        boton6.setOnClickListener(this);
        Button boton7 = (Button) findViewById(R.id.button7);
        boton7.setOnClickListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                regresar();
            }
        });
    }

    /**
     * Metodo para los Onclick de los botones
     * @param v
     */
    public void onClick (View v)
    {
        switch (v.getId()){
            case R.id.button1: {
                valorRezoLitu = 1;
                valorRezo();
                break;
            }
            case R.id.button2:{
                valorRezoLitu = 2;
                valorRezo();
                break;
            }
            case R.id.button3:{
                valorRezoLitu = 3;
                valorRezo();
                break;
            }
            case R.id.button4:{
                valorRezoLitu = 4;
                valorRezo();
                break;
            }
            case R.id.button5:{
                valorRezoLitu = 5;
                valorRezo();
                break;
            }
            case R.id.button6:{
                valorRezoLitu = 6;
                valorRezo();
                break;
            }
            case R.id.button7:{
                valorRezoLitu = 7;
                valorRezo();
                break;
            }
        }

        /**
         * metodo con if
         *
        if (v.getId() == R.id.button1) {
            valorRezoLitu=1;
        }
        */
    }

    /**
     * Configurar el valor del rezo
     */
    private void valorRezo(){
        SharedPreferences misPreferencias = getSharedPreferences("RamilleteUsuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = misPreferencias.edit();
        editor.putString("rezoLiturgia", ""+valorRezoLitu);
        editor.commit();
        RezarLiturgia();
    }
    /**
     * Opcion para regresar
     */
    private void regresar() {
        Intent ListSong = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(ListSong);
        finish();
    }

    /**
     * Opcion para ir al rezo de la liturgia
     */
    private void RezarLiturgia() {
        Intent ListSong = new Intent(getApplicationContext(), liturgia.class);
        startActivity(ListSong);
        finish();
    }
}
