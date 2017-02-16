package com.ramillete.sfj.ramilletesfj;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener{

    public int cont=0;
    public TextView Misa,Comunion,ComuEsp,Rosa,Sacri,HrSanta,ExaConci,Confe,Biblia,HrsServicio,RosaMisio;
    public TextView Ayuno,BendicionMesa,ObrasEsp,ObrasCorp,Coronilla,Caridad,PadreNuestro,AveMaria;

    boolean cargar=false;
    int band;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                onGuardar(band=1);

                }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //PASAR a Otra clase

        Button sumarMisa = (Button) findViewById(R.id.sumarMisa);
        sumarMisa.setOnClickListener(this);
        Button restarMisa = (Button) findViewById(R.id.restaMisa);
        restarMisa.setOnClickListener(this);
        Button sumarComunion = (Button) findViewById(R.id.sumarComunion);
        sumarComunion.setOnClickListener(this);
        Button restarComunion = (Button) findViewById(R.id.restarComunion);
        restarComunion.setOnClickListener(this);
        Button sumarComuEsp =(Button) findViewById(R.id.sumarComuEsp);
        sumarComuEsp.setOnClickListener(this);
        Button restarComuEsp = (Button) findViewById(R.id.restarComuEsp);
        restarComuEsp.setOnClickListener(this);
        Button sumarRosa =(Button) findViewById(R.id.sumarRosa);
        sumarRosa.setOnClickListener(this);
        Button restarRosa = (Button) findViewById(R.id.restarRosa);
        restarRosa.setOnClickListener(this);
        Button sumarSacri =(Button) findViewById(R.id.sumarSacri);
        sumarSacri.setOnClickListener(this);
        Button restarSacri = (Button) findViewById(R.id.restarSacri);
        restarSacri.setOnClickListener(this);
        Button sumarHrSanta =(Button) findViewById(R.id.sumarHrSanta);
        sumarHrSanta.setOnClickListener(this);
        Button restarHrSanta = (Button) findViewById(R.id.restarHrSanta);
        restarHrSanta.setOnClickListener(this);
        Button sumarExaConci =(Button) findViewById(R.id.sumarExaConci);
        sumarExaConci.setOnClickListener(this);
        Button restarExaConci = (Button) findViewById(R.id.restarExaConci);
        restarExaConci.setOnClickListener(this);
        Button sumarConfe =(Button) findViewById(R.id.sumarConfe);
        sumarConfe.setOnClickListener(this);
        Button restarConfe = (Button) findViewById(R.id.restarConfe);
        restarConfe.setOnClickListener(this);
        Button sumarBiblia =(Button) findViewById(R.id.sumarBiblia);
        sumarBiblia.setOnClickListener(this);
        Button restarBiblia = (Button) findViewById(R.id.restarBiblia);
        restarBiblia.setOnClickListener(this);
        Button sumarHrsServi =(Button) findViewById(R.id.sumarHrsServi);
        sumarHrsServi.setOnClickListener(this);
        Button restarHrsServi = (Button) findViewById(R.id.restarHrsServi);
        restarHrsServi.setOnClickListener(this);
        Button sumarRosaMisio =(Button) findViewById(R.id.sumarRosaMisio);
        sumarRosaMisio.setOnClickListener(this);
        Button restarRosaMisio = (Button) findViewById(R.id.restarRosaMisio);
        restarRosaMisio.setOnClickListener(this);
        Button sumarAyuno =(Button) findViewById(R.id.sumarAyuno);
        sumarAyuno.setOnClickListener(this);
        Button restarAyuno = (Button) findViewById(R.id.restarAyuno);
        restarAyuno.setOnClickListener(this);
        Button sumarBendicionMesa =(Button) findViewById(R.id.sumarBendicionMesa);
        sumarBendicionMesa.setOnClickListener(this);
        Button restarBendicionMesa = (Button) findViewById(R.id.restarBendicionMesa);
        restarBendicionMesa.setOnClickListener(this);
        Button sumarObrasEsp =(Button) findViewById(R.id.sumarObrasEsp);
        sumarObrasEsp.setOnClickListener(this);
        Button restarObrasEsp = (Button) findViewById(R.id.restarObrasEsp);
        restarObrasEsp.setOnClickListener(this);
        Button sumarObrasCorp =(Button) findViewById(R.id.sumarObrasCorp);
        sumarObrasCorp.setOnClickListener(this);
        Button restarObrasCorp = (Button) findViewById(R.id.restarObrasCorp);
        restarObrasCorp.setOnClickListener(this);
        Button sumarCoronilla =(Button) findViewById(R.id.sumarCoronilla);
        sumarCoronilla.setOnClickListener(this);
        Button restarCoronilla = (Button) findViewById(R.id.restarCoronilla);
        restarCoronilla.setOnClickListener(this);
        Button sumarCaridad =(Button) findViewById(R.id.sumarCaridad);
        sumarCaridad.setOnClickListener(this);
        Button restarCaridad = (Button) findViewById(R.id.restarCaridad);
        restarCaridad.setOnClickListener(this);
        Button sumarPadreNuestro = (Button) findViewById(R.id.sumarPadreNuestro);
        sumarPadreNuestro.setOnClickListener(this);
        Button restarPadreNuestro = (Button) findViewById(R.id.restarPadreNuestro);
        restarPadreNuestro.setOnClickListener(this);
        Button sumarAveMaria = (Button) findViewById(R.id.sumarAveMaria);
        sumarAveMaria.setOnClickListener(this);
        Button restarAveMaria = (Button) findViewById(R.id.restarAveMaria);
        restarAveMaria.setOnClickListener(this);




        cargarPreferencias();




            //((TextView) findViewById(R.id.txtConMisa)).setText();


    }

    public void resTodo(){

        ((TextView) findViewById(R.id.txtContMisa)).setText("0");

        onGuardar(band=2);
    }

    private void cargarPreferencias( ) {

        Misa=(TextView) findViewById(R.id.txtContMisa);
        Comunion=(TextView) findViewById(R.id.txtContComunion);
        ComuEsp=(TextView) findViewById(R.id.txtContComuEsp);
        Rosa=(TextView) findViewById(R.id.txtContRosa);
        Sacri=(TextView) findViewById(R.id.txtContSacri);
        HrSanta=(TextView) findViewById(R.id.txtContHrSanta);
        ExaConci=(TextView) findViewById(R.id.txtContExaConci);
        Confe=(TextView) findViewById(R.id.txtContConfe);
        Biblia=(TextView) findViewById(R.id.txtContBiblia);
        HrsServicio=(TextView) findViewById(R.id.txtContHrsServi);
        RosaMisio=(TextView) findViewById(R.id.txtContRosaMisio);
        Ayuno=(TextView) findViewById(R.id.txtContAyuno);
        BendicionMesa=(TextView) findViewById(R.id.txtContBendicionMesa);
        ObrasEsp=(TextView) findViewById(R.id.txtContObrasEsp);
        ObrasCorp=(TextView) findViewById(R.id.txtContObrasCorp);
        Coronilla=(TextView) findViewById(R.id.txtContCoronilla);
        Caridad=(TextView) findViewById(R.id.txtContCaridad);
        PadreNuestro=(TextView) findViewById(R.id.txtContPadreNuestro);
        AveMaria=(TextView) findViewById(R.id.txtContAveMaria);

        SharedPreferences misPreferencias=getSharedPreferences("RamilleteUsuario",Context.MODE_PRIVATE);
        Misa.setText(misPreferencias.getString("Misa","0"));
        Comunion.setText(misPreferencias.getString("Comunion","0"));
        ComuEsp.setText(misPreferencias.getString("ComunionEsp","0"));
        Rosa.setText(misPreferencias.getString("Rosario","0"));
        Sacri.setText(misPreferencias.getString("Sacrificio","0"));
        HrSanta.setText(misPreferencias.getString("hrSanta","0"));
        ExaConci.setText(misPreferencias.getString("ExamenConci","0"));
        Confe.setText(misPreferencias.getString("Confesion","0"));
        Biblia.setText(misPreferencias.getString("Biblia","0"));
        HrsServicio.setText(misPreferencias.getString("HrServicio","0"));
        RosaMisio.setText(misPreferencias.getString("RosaMisio","0"));
        Ayuno.setText(misPreferencias.getString("Ayuno","0"));
        BendicionMesa.setText(misPreferencias.getString("BendicionMesa","0"));
        ObrasEsp.setText(misPreferencias.getString("ObrEspiritual","0"));
        ObrasCorp.setText(misPreferencias.getString("ObrCorporal","0"));
        Coronilla.setText(misPreferencias.getString("Coronilla","0"));
        Caridad.setText(misPreferencias.getString("Caridad","0"));
        PadreNuestro.setText(misPreferencias.getString("PadreNuestro","0"));
        AveMaria.setText(misPreferencias.getString("AveMaria","0"));

        Toast toast = Toast.makeText(this, "Cargado", Toast.LENGTH_SHORT);
        toast.show();


    }
    public void onGuardar(int f){

        SharedPreferences misPreferencias = getSharedPreferences("RamilleteUsuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = misPreferencias.edit();
        editor.putString("Misa",(String)((TextView) findViewById(R.id.txtContMisa)).getText());
        editor.putString("Comunion",(String)((TextView) findViewById(R.id.txtContComunion)).getText());
        editor.putString("ComunionEsp",(String)((TextView) findViewById(R.id.txtContComuEsp)).getText());
        editor.putString("Rosario",(String)((TextView) findViewById(R.id.txtContRosa)).getText());
        editor.putString("Sacrificio",(String)((TextView) findViewById(R.id.txtContSacri)).getText());
        editor.putString("hrSanta",(String)((TextView) findViewById(R.id.txtContHrSanta)).getText());
        editor.putString("ExamenConci",(String)((TextView) findViewById(R.id.txtContExaConci)).getText());
        editor.putString("Confesion",(String)((TextView) findViewById(R.id.txtContConfe)).getText());
        editor.putString("Biblia",(String)((TextView) findViewById(R.id.txtContBiblia)).getText());
        editor.putString("HrServicio",(String)((TextView) findViewById(R.id.txtContHrsServi)).getText());
        editor.putString("RosaMisio",(String)((TextView) findViewById(R.id.txtContRosaMisio)).getText());
        editor.putString("Ayuno",(String)((TextView) findViewById(R.id.txtContAyuno)).getText());
        editor.putString("BendicionMesa",(String)((TextView) findViewById(R.id.txtContBendicionMesa)).getText());
        editor.putString("ObrEspiritual",(String)((TextView) findViewById(R.id.txtContObrasEsp)).getText());
        editor.putString("ObrCorporal",(String)((TextView) findViewById(R.id.txtContObrasCorp)).getText());
        editor.putString("Coronilla",(String)((TextView) findViewById(R.id.txtContCoronilla)).getText());
        editor.putString("Caridad",(String)((TextView) findViewById(R.id.txtContCaridad)).getText());
        editor.putString("PadreNuestro",(String)((TextView) findViewById(R.id.txtContPadreNuestro)).getText());
        editor.putString("AveMaria",(String)((TextView) findViewById(R.id.txtContAveMaria)).getText());

        editor.commit();

        if(f==1) {
            Toast toast = Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT);
            toast.show();
        }else if(f==2){
            Toast toast = Toast.makeText(this, "Datos eliminados", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void onClick(View v) {
        switch (v.getId())
        {
            /*********** Restas ***********/
            case R.id.restaMisa:
                cont = Integer.parseInt((String)((TextView) findViewById(R.id.txtContMisa)).getText());
                cont--;
                ((TextView) findViewById(R.id.txtContMisa)).setText(""+cont);
                break;
            case R.id.restarComunion:
                cont = Integer.parseInt((String)((TextView) findViewById(R.id.txtContComunion)).getText());
                cont--;
                ((TextView) findViewById(R.id.txtContComunion)).setText(""+cont);
                break;
            case R.id.restarComuEsp:
                cont = Integer.parseInt((String)((TextView) findViewById(R.id.txtContComuEsp)).getText());
                cont--;
                ((TextView) findViewById(R.id.txtContComuEsp)).setText(""+cont);
                break;
            case R.id.restarRosa:
                cont = Integer.parseInt((String)((TextView) findViewById(R.id.txtContRosa)).getText());
                cont--;
                ((TextView) findViewById(R.id.txtContRosa)).setText(""+cont);
                break;
            case R.id.restarSacri:
                cont = Integer.parseInt((String)((TextView) findViewById(R.id.txtContSacri)).getText());
                cont--;
                ((TextView) findViewById(R.id.txtContSacri)).setText(""+cont);
                break;
            case R.id.restarHrSanta:
                cont = Integer.parseInt((String)((TextView) findViewById(R.id.txtContHrSanta)).getText());
                cont--;
                ((TextView) findViewById(R.id.txtContHrSanta)).setText(""+cont);
                break;
            case R.id.restarExaConci:
                cont = Integer.parseInt((String)((TextView) findViewById(R.id.txtContExaConci)).getText());
                cont--;
                ((TextView) findViewById(R.id.txtContExaConci)).setText(""+cont);
                break;
            case R.id.restarConfe:
                cont = Integer.parseInt((String)((TextView) findViewById(R.id.txtContConfe)).getText());
                cont--;
                ((TextView) findViewById(R.id.txtContConfe)).setText(""+cont);
                break;
            case R.id.restarBiblia:
                cont = Integer.parseInt((String)((TextView) findViewById(R.id.txtContBiblia)).getText());
                cont--;
                ((TextView) findViewById(R.id.txtContBiblia)).setText(""+cont);
                break;
            case R.id.restarHrsServi:
                cont = Integer.parseInt((String)((TextView) findViewById(R.id.txtContHrsServi)).getText());
                cont--;
                ((TextView) findViewById(R.id.txtContHrsServi)).setText(""+cont);
                break;
            case R.id.restarRosaMisio:
                cont = Integer.parseInt((String)((TextView) findViewById(R.id.txtContRosaMisio)).getText());
                cont--;
                ((TextView) findViewById(R.id.txtContRosaMisio)).setText(""+cont);
                break;
            case R.id.restarAyuno:
                cont = Integer.parseInt((String)((TextView) findViewById(R.id.txtContAyuno)).getText());
                cont--;
                ((TextView) findViewById(R.id.txtContAyuno)).setText(""+cont);
                break;
            case R.id.restarBendicionMesa:
                cont = Integer.parseInt((String)((TextView) findViewById(R.id.txtContBendicionMesa)).getText());
                cont--;
                ((TextView) findViewById(R.id.txtContBendicionMesa)).setText(""+cont);
                break;
            case R.id.restarObrasEsp:
                cont = Integer.parseInt((String)((TextView) findViewById(R.id.txtContObrasEsp)).getText());
                cont--;
                ((TextView) findViewById(R.id.txtContObrasEsp)).setText(""+cont);
                break;
            case R.id.restarObrasCorp:
                cont = Integer.parseInt((String)((TextView) findViewById(R.id.txtContObrasCorp)).getText());
                cont--;
                ((TextView) findViewById(R.id.txtContObrasCorp)).setText(""+cont);
                break;
            case R.id.restarCoronilla:
                cont = Integer.parseInt((String)((TextView) findViewById(R.id.txtContCoronilla)).getText());
                cont--;
                ((TextView) findViewById(R.id.txtContCoronilla)).setText(""+cont);
                break;
            case R.id.restarCaridad:
                cont = Integer.parseInt((String)((TextView) findViewById(R.id.txtContCaridad)).getText());
                cont--;
                ((TextView) findViewById(R.id.txtContCaridad)).setText(""+cont);
                break;
            case R.id.restarPadreNuestro:
                cont = Integer.parseInt((String)((TextView) findViewById(R.id.txtContPadreNuestro)).getText());
                cont--;
                ((TextView) findViewById(R.id.txtContPadreNuestro)).setText(""+cont);
                break;
            case R.id.restarAveMaria:
                cont = Integer.parseInt((String)((TextView) findViewById(R.id.txtContAveMaria)).getText());
                cont--;
                ((TextView) findViewById(R.id.txtContAveMaria)).setText(""+cont);
                break;

            /*********** Sumas ***********/
            case R.id.sumarMisa:
                cont = Integer.parseInt((String)((TextView) findViewById(R.id.txtContMisa)).getText());
                cont++;
                ((TextView) findViewById(R.id.txtContMisa)).setText(""+cont);
                break;
            case R.id.sumarComunion:
                cont = Integer.parseInt((String)((TextView) findViewById(R.id.txtContComunion)).getText());
                cont++;
                ((TextView) findViewById(R.id.txtContComunion)).setText(""+cont);
                break;
            case R.id.sumarComuEsp:
                cont = Integer.parseInt((String)((TextView) findViewById(R.id.txtContComuEsp)).getText());
                cont++;
                ((TextView) findViewById(R.id.txtContComuEsp)).setText(""+cont);
                break;
            case R.id.sumarRosa:
                cont = Integer.parseInt((String)((TextView) findViewById(R.id.txtContRosa)).getText());
                cont++;
                ((TextView) findViewById(R.id.txtContRosa)).setText(""+cont);
                break;
            case R.id.sumarSacri:
                cont = Integer.parseInt((String)((TextView) findViewById(R.id.txtContSacri)).getText());
                cont++;
                ((TextView) findViewById(R.id.txtContSacri)).setText(""+cont);
                break;
            case R.id.sumarHrSanta:
                cont = Integer.parseInt((String)((TextView) findViewById(R.id.txtContHrSanta)).getText());
                cont++;
                ((TextView) findViewById(R.id.txtContHrSanta)).setText(""+cont);
                break;
            case R.id.sumarExaConci:
                cont = Integer.parseInt((String)((TextView) findViewById(R.id.txtContExaConci)).getText());
                cont++;
                ((TextView) findViewById(R.id.txtContExaConci)).setText(""+cont);
                break;
            case R.id.sumarConfe:
                cont = Integer.parseInt((String)((TextView) findViewById(R.id.txtContConfe)).getText());
                cont++;
                ((TextView) findViewById(R.id.txtContConfe)).setText(""+cont);
                break;
            case R.id.sumarBiblia:
                cont = Integer.parseInt((String)((TextView) findViewById(R.id.txtContBiblia)).getText());
                cont++;
                ((TextView) findViewById(R.id.txtContBiblia)).setText(""+cont);
                break;
            case R.id.sumarHrsServi:
                cont = Integer.parseInt((String)((TextView) findViewById(R.id.txtContHrsServi)).getText());
                cont++;
                ((TextView) findViewById(R.id.txtContHrsServi)).setText(""+cont);
                break;
            case R.id.sumarRosaMisio:
                cont = Integer.parseInt((String)((TextView) findViewById(R.id.txtContRosaMisio)).getText());
                cont++;
                ((TextView) findViewById(R.id.txtContRosaMisio)).setText(""+cont);
                break;
            case R.id.sumarAyuno:
                cont = Integer.parseInt((String)((TextView) findViewById(R.id.txtContAyuno)).getText());
                cont++;
                ((TextView) findViewById(R.id.txtContAyuno)).setText(""+cont);
                break;
            case R.id.sumarBendicionMesa:
                cont = Integer.parseInt((String)((TextView) findViewById(R.id.txtContBendicionMesa)).getText());
                cont++;
                ((TextView) findViewById(R.id.txtContBendicionMesa)).setText(""+cont);
                break;
            case R.id.sumarObrasEsp:
                cont = Integer.parseInt((String)((TextView) findViewById(R.id.txtContObrasEsp)).getText());
                cont++;
                ((TextView) findViewById(R.id.txtContObrasEsp)).setText(""+cont);
                break;
            case R.id.sumarObrasCorp:
                cont = Integer.parseInt((String)((TextView) findViewById(R.id.txtContObrasCorp)).getText());
                cont++;
                ((TextView) findViewById(R.id.txtContObrasCorp)).setText(""+cont);
                break;
            case R.id.sumarCoronilla:
                cont = Integer.parseInt((String)((TextView) findViewById(R.id.txtContCoronilla)).getText());
                cont++;
                ((TextView) findViewById(R.id.txtContCoronilla)).setText(""+cont);
                break;
            case R.id.sumarCaridad:
                cont = Integer.parseInt((String)((TextView) findViewById(R.id.txtContCaridad)).getText());
                cont++;
                ((TextView) findViewById(R.id.txtContCaridad)).setText(""+cont);
                break;
            case R.id.sumarPadreNuestro:
                cont = Integer.parseInt((String)((TextView) findViewById(R.id.txtContPadreNuestro)).getText());
                cont++;
                ((TextView) findViewById(R.id.txtContPadreNuestro)).setText(""+cont);
                break;
            case R.id.sumarAveMaria:
                cont = Integer.parseInt((String)((TextView) findViewById(R.id.txtContAveMaria)).getText());
                cont++;
                ((TextView) findViewById(R.id.txtContAveMaria)).setText(""+cont);
                break;

            default:Log.d("error","la condicion callo aqui");
                break;
        }
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    /*public void onSum(View v) {
        switch (v.getId())
        {
            case R.id.sumarMisa:
                cont = Integer.parseInt((String)((TextView) findViewById(R.id.txtConMisa)).getText());
                cont++;
                ((TextView) findViewById(R.id.txtConMisa)).setText(""+cont);
                break;
            case R.id.restaMisa:
                cont = Integer.parseInt((String)((TextView) findViewById(R.id.txtConMisa)).getText());
                cont--;
                ((TextView) findViewById(R.id.txtConMisa)).setText(""+cont);
                break;
            default:Log.d("error","la condicion callo aqui");
                break;
        }
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
