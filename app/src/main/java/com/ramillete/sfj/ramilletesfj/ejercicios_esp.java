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
        //spDia.setOnItemClickListener((AdapterView.OnItemClickListener) this);
//Estilos de Spinners
        //aaSemana = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opSemana);
        aaSemana = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,opSemana);
        aaDia = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opDia);


        spSemana.setAdapter(aaSemana);
        //spDia.setAdapter(aaDia);

   }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            switch (parent.getId()){
            case R.id.spinnerSemana:
               int selecc = spSemana.getSelectedItemPosition();
                Log.d("SeleccDia",spSemana.toString());
                switch (selecc){
                    case 0: //spDia.setAdapter(aaDia);
                        int seleccDia = spDia.getSelectedItemPosition();
                        switch (seleccDia){
                            case 0: {
                                ejercicios.setText("Hola Mundo desde 1");
                                break;
                            }
                            case 1:{
                                ejercicios.setText("Hola Mundo desde 2");
                                break;
                            }
                        }

                        break;
                    case 1: spDia.setAdapter(aaDia);
                        int seleccDia2 = spSemana.getSelectedItemPosition();
                        switch (seleccDia2){
                            case 0: ejercicios.setText("CUARTO DIA\n" +
                                    "1.- Estamos salvados. Pertenecemos a Dios. Nunca estamos solos.\n" +
                                    "2.- Sentimiento es todo aquello que sentimos: lo que vemos, oímos, hablamos, tocamos. Todo lo que va quedando en nosotros. Luego se reproduce con frecuencia: son los sentimientos: así la antipatía o la simpatía; los sentimientos egoístas o de generosidad; la estima o el rechazo. La compasión.\n" +
                                    "¿Qué sentimientos negativos tengo en mí?\n" +
                                    "¿Qué sentimientos positivos tengo?\n" +
                                    "¿Qué es lo que prevalece?\n" +
                                    "Después de reflexionar con calma, escribe.\n" +
                                    "3.- Estamos hechos para gozar:  \n" +
                                    "¿Por  qué no gozo?\n" +
                                    "¿Qué me falta?\n" +
                                    "Piensa en lo que contestarías a estas preguntas. Si una persona te diera  esas contestaciones, tú, ¿qué le dirías? ESCRIBE.\n" +
                                    "4.- Lee despacio. Repite lo que mas te guste. Reza con alguno de estos tres salmos:\n" +
                                    "            Nº 8:                Bondad de Dios\n" +
                                    "            Nº 104:            Gloria de Dios.\n" +
                                    "            Nº 139:            “Tú me has examinado y me conoces”.\n" +
                                    " Quédate con el versículo que más te guste. Repítelo, SABORÉALO.\n" +
                                    "            Da gracias por esta hora\n" +
                                    "            Escribe alguna conclusión, lo que sientas AHORA.\n" +
                                    "5.- Ayúdame a tener como objetivos de mi vida:\n" +
                                    "-\tFidelidad a la oración, aunque no tenga consolación.\n" +
                                    "-\tHacer tu voluntad, aunque no sienta estima en los demás.\n" +
                                    "-\tTener una caridad sin fronteras.\n" +
                                    "\n" +
                                    "(Y termino como cada día.)");
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
