package com.ramillete.sfj.ramilletesfj;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                regresar();
            }
        });

        ejercicios = (TextView) findViewById(R.id.textViewEjercicios);
        spSemana = (Spinner) findViewById(R.id.spinnerSemana);
        spDia = (Spinner) findViewById(R.id.spinnerDia);
        spSemana.setOnItemSelectedListener(this);
        spDia.setOnItemSelectedListener(this);
        //Estilos de Spinners
        //aaSemana = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opSemana);
        aaSemana = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,opSemana);
        aaDia = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,opDia);
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

                        //ejercicios.setText("Estas en la semana 1");
                        spDia.setAdapter(aaDia);
                        semananum = 1;
                        Log.d("SeleccDia", spDia.toString());

                        break;
                    case 1:Log.d("Semana2", "Semana 2");
                        spDia.setAdapter(aaDia);
                        //ejercicios.setText(getText(R.string.error));
                        semananum =2;
                        break;
                    case 2:Log.d("Semana3", "Semana 3");

                        //ejercicios.setText("Estas en la semana 1");
                        spDia.setAdapter(aaDia);
                        semananum = 3;
                        Log.d("SeleccDia", spDia.toString());

                        break;
                    case 3:Log.d("Semana4", "Semana 4");
                        spDia.setAdapter(aaDia);
                        //ejercicios.setText(getText(R.string.error));
                        semananum =4;
                        break;
                    case 4:Log.d("Semana5", "Semana 5");

                        //ejercicios.setText("Estas en la semana 1");
                        spDia.setAdapter(aaDia);
                        semananum = 5;
                        Log.d("SeleccDia", spDia.toString());

                        break;
                    case 5:Log.d("Semana6", "Semana 6");
                        spDia.setAdapter(aaDia);
                        //ejercicios.setText(getText(R.string.error));
                        semananum =6;
                        break;
                    case 6:Log.d("Semana7", "Semana 7");
                        spDia.setAdapter(aaDia);
                        //ejercicios.setText(getText(R.string.error));
                        semananum =7;
                        break;
                    case 7:Log.d("Semana8", "Semana 8");
                        spDia.setAdapter(aaDia);
                        //ejercicios.setText(getText(R.string.error));
                        semananum =8;
                        break;
                }
             break;
           case R.id.spinnerDia:
                int selcDia = spDia.getSelectedItemPosition();
               switch (semananum) {
                   case 1://Primera Semana
                       switch (selcDia) {
                       case 0:Log.d("Semana1", "Dia 1");
                           ejercicios.setText(R.string.sem1Dia1);
                           break;
                       case 1:Log.d("Semana1", "Dia 2");
                           ejercicios.setText(R.string.sem1Dia2);
                           break;
                       case 2:Log.d("Semana1", "Dia 3");
                           ejercicios.setText(R.string.sem1Dia3);
                           break;
                       case 3:Log.d("Semana1", "Dia 4");
                           ejercicios.setText(R.string.sem1Dia4);
                           break;
                       case 4:Log.d("Semana1", "Dia 5");
                           ejercicios.setText(R.string.sem1Dia5);
                           break;
                       case 5:Log.d("Semana1", "Dia 6");
                           ejercicios.setText(R.string.sem1Dia6);
                           break;
                       case 6:Log.d("Semana1", "Dia 7");
                           ejercicios.setText(R.string.sem1Dia7);
                           break;

                        }
                   break;
                   case 2:
                       switch (selcDia) {
                           case 0:Log.d("Semana2", "Dia 1");
                               ejercicios.setText(R.string.sem2Dia1);
                               break;
                           case 1:Log.d("Semana2", "Dia 2");
                               ejercicios.setText(R.string.sem2Dia2);
                               break;
                           case 2:Log.d("Semana2", "Dia 3");
                               ejercicios.setText(R.string.sem2Dia3);
                               break;
                           case 3:Log.d("Semana2", "Dia 4");
                               ejercicios.setText(R.string.sem2Dia4);
                               break;
                           case 4:Log.d("Semana2", "Dia 5");
                               ejercicios.setText(R.string.sem2Dia5);
                               break;
                           case 5:Log.d("Semana2", "Dia 6");
                               ejercicios.setText(R.string.sem2Dia6);
                               break;
                           case 6:Log.d("Semana2", "Dia 7");
                               ejercicios.setText(R.string.sem2Dia7);
                               break;
                       }
                       break;
                   case 3:
                       switch (selcDia) {
                           case 0:Log.d("Semana3", "Dia 1");
                               ejercicios.setText(R.string.sem3Dia1);
                               break;
                           case 1:Log.d("Semana3", "Dia 2");
                               ejercicios.setText(R.string.sem3Dia2);
                               break;
                           case 2:Log.d("Semana3", "Dia 3");
                               ejercicios.setText(R.string.sem3Dia3);
                               break;
                           case 3:Log.d("Semana3", "Dia 4");
                               ejercicios.setText(R.string.sem3Dia4);
                               break;
                           case 4:Log.d("Semana3", "Dia 5");
                               ejercicios.setText(R.string.sem3Dia5);
                               break;
                           case 5:Log.d("Semana3", "Dia 6");
                               ejercicios.setText(R.string.sem3Dia6);
                               break;
                           case 6:Log.d("Semana3", "Dia 7");
                               ejercicios.setText(R.string.sem3Dia7);
                               break;
                       }
                       break;
                   case 4:
                       switch (selcDia) {
                           case 0:Log.d("Semana4", "Dia 1");
                               ejercicios.setText(R.string.sem4Dia1);
                               break;
                           case 1:Log.d("Semana4", "Dia 2");
                               ejercicios.setText(R.string.sem4Dia2);
                               break;
                           case 2:Log.d("Semana4", "Dia 3");
                               ejercicios.setText(R.string.sem4Dia3);
                               break;
                           case 3:Log.d("Semana4", "Dia 4");
                               ejercicios.setText(R.string.sem4Dia4);
                               break;
                           case 4:Log.d("Semana4", "Dia 5");
                               ejercicios.setText(R.string.sem4Dia5);
                               break;
                           case 5:Log.d("Semana4", "Dia 6");
                               ejercicios.setText(R.string.sem4Dia6);
                               break;
                           case 6:Log.d("Semana4", "Dia 7");
                               ejercicios.setText(R.string.sem4Dia7);
                               break;
                       }
                       break;
                   case 5:
                       switch (selcDia) {
                           case 0:Log.d("Semana5", "Dia 1");
                               ejercicios.setText(R.string.sem5Dia1);
                               break;
                           case 1:Log.d("Semana5", "Dia 2");
                               ejercicios.setText(R.string.sem5Dia2);
                               break;
                           case 2:Log.d("Semana5", "Dia 3");
                               ejercicios.setText(R.string.sem5Dia3);
                               break;
                           case 3:Log.d("Semana5", "Dia 4");
                               ejercicios.setText(R.string.sem5Dia4);
                               break;
                           case 4:Log.d("Semana5", "Dia 5");
                               ejercicios.setText(R.string.sem5Dia5);
                               break;
                           case 5:Log.d("Semana5", "Dia 6");
                               ejercicios.setText(R.string.sem5Dia6);
                               break;
                           case 6:Log.d("Semana5", "Dia 7");
                               ejercicios.setText(R.string.sem5Dia7);
                               break;
                       }
                       break;
                   case 6:
                       switch (selcDia) {
                           case 0:Log.d("Semana6", "Dia 1");
                               ejercicios.setText(R.string.sem6Dia1);
                               break;
                           case 1:Log.d("Semana6", "Dia 2");
                               ejercicios.setText(R.string.sem6Dia2);
                               break;
                           case 2:Log.d("Semana6", "Dia 3");
                               ejercicios.setText(R.string.sem6Dia3);
                               break;
                           case 3:Log.d("Semana6", "Dia 4");
                               ejercicios.setText(R.string.sem6Dia4);
                               break;
                           case 4:Log.d("Semana6", "Dia 5");
                               ejercicios.setText(R.string.sem6Dia5);
                               break;
                           case 5:Log.d("Semana6", "Dia 6");
                               ejercicios.setText(R.string.sem6Dia6);
                               break;
                           case 6:Log.d("Semana6", "Dia 7");
                               ejercicios.setText(R.string.sem6Dia7);
                               break;
                       }
                       break;
                   case 7:
                       switch (selcDia) {
                           case 0:Log.d("Semana7", "Dia 1");
                               ejercicios.setText(R.string.sem7Dia1);
                               break;
                           case 1:Log.d("Semana7", "Dia 2");
                               ejercicios.setText(R.string.sem7Dia2);
                               break;
                           case 2:Log.d("Semana7", "Dia 3");
                               ejercicios.setText(R.string.sem7Dia3);
                               break;
                           case 3:Log.d("Semana7", "Dia 4");
                               ejercicios.setText(R.string.sem7Dia4);
                               break;
                           case 4:Log.d("Semana7", "Dia 5");
                               ejercicios.setText(R.string.sem7Dia5);
                               break;
                           case 5:Log.d("Semana7", "Dia 6");
                               ejercicios.setText(R.string.sem7Dia6);
                               break;
                           case 6:Log.d("Semana7", "Dia 7");
                               ejercicios.setText(R.string.sem7Dia7);
                               break;
                       }
                       break;
                   case 8:
                       switch (selcDia) {
                           case 0:Log.d("Semana8", "Dia 1");
                               ejercicios.setText(R.string.sem8Dia1);
                               break;
                           case 1:Log.d("Semana8", "Dia 2");
                               ejercicios.setText(R.string.sem8Dia2);
                               break;
                           case 2:Log.d("Semana8", "Dia 3");
                               ejercicios.setText(R.string.sem8Dia3);
                               break;
                           case 3:Log.d("Semana8", "Dia 4");
                               ejercicios.setText(R.string.sem8Dia4);
                               break;
                           case 4:Log.d("Semana8", "Dia 5");
                               ejercicios.setText(R.string.sem8Dia5);
                               break;
                           case 5:Log.d("Semana8", "Dia 6");
                               ejercicios.setText(R.string.sem8Dia6);
                               break;
                           case 6:Log.d("Semana8", "Dia 7");
                               ejercicios.setText(R.string.sem8Dia7);
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

    /**
     * Opcion para regresar
     */
    private void regresar() {
        Intent ListSong = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(ListSong);
        finish();
    }

    /**
     * Este es el menu
     * @param menu este es donde configuramos el archivo .xml del menu que creamos
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ejercicios, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.menu_Regresar) {
            //return true;
            regresar();
        }else if(id == R.id.menu_Salir) {
            //return true;
            System.exit(0);
        }

        return super.onOptionsItemSelected(item);
    }
}
