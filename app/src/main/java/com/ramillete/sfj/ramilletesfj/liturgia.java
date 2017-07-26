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
import android.webkit.WebView;

import java.util.Calendar;

public class liturgia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liturgia);

        Calendar calendarNow = Calendar.getInstance();
        int monthDay =calendarNow.get(Calendar.DAY_OF_MONTH);
        int month = calendarNow.get(Calendar.MONTH);
        month = month+1;
        String month2 = null;
        int year = calendarNow.get(Calendar.YEAR);
        String rezo = null;

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
        /**
         * con esto verifico si jalo el url
         *
        if(true) {
            Log.d("Fecha", "" + year);
            Log.d("Fecha2", "" + month);
            Log.d("Fecha3", "" + monthDay);
            Log.d("url","http://liturgiadelashoras.com.ar/sync/"+year+"/"+month2+"/"+monthDay+"/laudes.htm");
        }
        */

        liturgia_menu liturgiaClass = new liturgia_menu();
        SharedPreferences misPreferencias = getSharedPreferences("RamilleteUsuario", Context.MODE_PRIVATE);
        String valorRezo1 = misPreferencias.getString("rezoLiturgia", "0");
        int valorRezo=(Integer.valueOf(valorRezo1));

        Log.d("valorRezo",""+valorRezo);

        switch (valorRezo){
            case 1:rezo="oficio";
                break;
            case 2:rezo="laudes";
                break;
            case 3:rezo="tercia";
                break;
            case 4:rezo="sexta";
                break;
            case 5:rezo="nona";
                break;
            case 6:rezo="visperas";
                break;
            case 7:rezo="completas";
                break;
        }

        String url="http://liturgiadelashoras.com.ar/sync/"+year+"/"+month2+"/"+monthDay+"/"+rezo+".htm";
        WebView view = (WebView) findViewById(R.id.webLiturgy);
        view.getSettings().setJavaScriptEnabled(true);
        view.getSettings().setBuiltInZoomControls(true);
        view.loadUrl(url);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.return_liturgia);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                regresar();
            }
        });

        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.return_home);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                regresar2();
            }
        });
    }

    /**
     * Opcion para regresar al menu liturgia
     */
    private void regresar() {
        Intent ListSong = new Intent(getApplicationContext(), liturgia_menu.class);
        startActivity(ListSong);
        finish();
    }

    /**
     * Opcion para regresar a la pantalla principal
     */
    private void regresar2() {
        Intent ListSong = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(ListSong);
        finish();
    }

}

