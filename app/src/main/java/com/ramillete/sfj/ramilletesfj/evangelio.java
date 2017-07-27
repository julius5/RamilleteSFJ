package com.ramillete.sfj.ramilletesfj;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

import java.util.Calendar;

public class evangelio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evangelio);

        Calendar calendarNow = Calendar.getInstance();
        int monthDay =calendarNow.get(Calendar.DAY_OF_MONTH);
        int month = calendarNow.get(Calendar.MONTH);
        month = month+1;
        String month2 = null;
        int year = calendarNow.get(Calendar.YEAR);
        String rezo = null;

        switch (month){
            case 1:month2="0"+month;
                break;
            case 2:month2="0"+month;
                break;
            case 3:month2="0"+month;
                break;
            case 4:month2="0"+month;
                break;
            case 5:month2="0"+month;
                break;
            case 6:month2="0"+month;
                break;
            case 7:month2="0"+month;
                break;
            case 8:month2="0"+month;
                break;
            case 9:month2="0"+month;
                break;
            case 10:month2=""+month;
                break;
            case 11:month2=""+month;
                break;
            case 12:month2=""+month;
                break;
        }

        String url="http://mobile.evangelizo.org/gospel.php?day="+monthDay+"&month="+month2+"&year="+year;
        WebView view = (WebView) findViewById(R.id.webBiblia);
        view.getSettings().setJavaScriptEnabled(true);
        view.getSettings().setBuiltInZoomControls(true);
        view.getSettings().setUseWideViewPort(true);
        view.getSettings().setLoadWithOverviewMode(true);
        view.loadUrl(url);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.return_eva);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                regresar();
            }
        });
    }

    /**
     * Opcion para regresar al menu liturgia
     */
    private void regresar() {
        Intent ListSong = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(ListSong);
        finish();
    }

}
