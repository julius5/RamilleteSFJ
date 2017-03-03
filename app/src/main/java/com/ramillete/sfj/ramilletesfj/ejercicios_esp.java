package com.ramillete.sfj.ramilletesfj;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Date;

public class ejercicios_esp extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
    Spinner spSemana, spDia;
    TextView ejercicios;
    int semananum=0;
    int diaInicio=0, mesInicio=0,diaCont=0,semanaCont=0,diaIni2=0;
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


    public void onIniciarEjer(View v){
        Date d = new Date();
        CharSequence diaDate  = DateFormat.format("d", d.getTime());
        CharSequence mesDate  = DateFormat.format("M", d.getTime());
        Log.d("Dia", ""+ diaDate);
        Log.d("Mes", ""+ mesDate);

        diaInicio= Integer.parseInt(""+diaDate);
        mesInicio=Integer.parseInt(""+mesDate);
        diaCont=1;
        semanaCont=1;

    }
    public void contadorDeEjercicios(){
        Date d = new Date();
        CharSequence diaDate  = DateFormat.format("d", d.getTime());
        int di=Integer.parseInt(""+diaDate);
        CharSequence mesDate  = DateFormat.format("M", d.getTime());
        int mes=Integer.parseInt(""+mesDate);
        if(diaCont!=0){
            if(mes==mesInicio){
               diaCont=(di-diaInicio)+1;
               diaIni2=(di-diaInicio)+1;
            }else{
                diaCont=diaIni2+di;
            }

            semanaCont=(diaCont/7)+1;



        }

        /*
        * Esto fue una idea pero creo que jala meojor lo de arriba
        *
        if (diaInicio==di){
            if(semanaInicio!=sem){
                diaCont++;
            }
        }else if(diaInicio!=di){
            diaCont++;
        }

        if(diaCont>=1 && diaCont<=7){
            semanaCont=1;
        }else if(diaCont>=8 && diaCont<=14){
            semanaCont=2;
        }else if(diaCont>=15 && diaCont<=21){
            semanaCont=3;
        }else if(diaCont>=22 && diaCont<=28){
            semanaCont=4;
        }else if(diaCont>=29 && diaCont<=35){
            semanaCont=5;
        }else if(diaCont>=36 && diaCont<=42){
            semanaCont=6;
        }else if(diaCont>=43 && diaCont<=49){
            semanaCont=7;
        }else if(diaCont>=50 && diaCont<56){
            semanaCont=8;
        }else if(diaCont==56){
            semanaCont=0;
            diaCont=0;
        }
       */

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
        }else if(id == R.id.menu_Mes1) {
            //return true;
            ejercicios.setText(R.string.introduccion1);
        }else if(id == R.id.menu_Mes2) {
            //return true;
            ejercicios.setText(R.string.introduccion2);
        }else if(id == R.id.tutoEjer){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(" 1- Selecciona la semana correspondiente a los ejercicios." +
                    "\n\n 2- Selecciona el día correspondiente a los ejercicios" +
                    "\n\n 3- Realiza tu ejercicio espiritual diario" +
                    "\n\n 4- Selecciona del menú la opción regresar para regresar al menú " +
                    "principal, o da clic en el botón de la parte inferior derecha.")
                    .setCancelable(false)
                    .setNeutralButton("Aceptar",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();
        }

        return super.onOptionsItemSelected(item);
    }
}
