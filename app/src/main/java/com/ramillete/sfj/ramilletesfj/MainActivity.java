package com.ramillete.sfj.ramilletesfj;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    public int cont = 0;
    public TextView Misa, Comunion, ComuEsp, Rosa, Sacri, HrSanta, ExaConci, Confe, Biblia, HrsServicio, RosaMisio, Cel;
    public TextView Ayuno, BendicionMesa, ObrasEsp, ObrasCorp, Coronilla, Caridad, PadreNuestro, AveMaria;
    public String datos;
    public String mCel,nombreUs, correo;

    boolean cargar = false;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                onGuardar(1);

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        declarbotones();


        //PASAR a Otra clase
        // Botones b = new Botones();
        //b.cargarPreferencias2();


        cargarPreferencias();
        SharedPreferences misDatos = getSharedPreferences("DatosUsuario", Context.MODE_PRIVATE);
        //Cel.setText(misDatos.getString("Telefono", "6142276865"));
        mCel=misDatos.getString("Telefono", "");
        nombreUs=misDatos.getString("Nombre", "");
        correo=misDatos.getString("email","");

        //((TextView) findViewById(R.id.txtConMisa)).setText();


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * Metodo que crea los botones
     */
    public void declarbotones() {
        Button sumarMisa = (Button) findViewById(R.id.sumarMisa);
        sumarMisa.setOnClickListener(this);
        Button restarMisa = (Button) findViewById(R.id.restaMisa);
        restarMisa.setOnClickListener(this);
        Button sumarComunion = (Button) findViewById(R.id.sumarComunion);
        sumarComunion.setOnClickListener(this);
        Button restarComunion = (Button) findViewById(R.id.restarComunion);
        restarComunion.setOnClickListener(this);
        Button sumarComuEsp = (Button) findViewById(R.id.sumarComuEsp);
        sumarComuEsp.setOnClickListener(this);
        Button restarComuEsp = (Button) findViewById(R.id.restarComuEsp);
        restarComuEsp.setOnClickListener(this);
        Button sumarRosa = (Button) findViewById(R.id.sumarRosa);
        sumarRosa.setOnClickListener(this);
        Button restarRosa = (Button) findViewById(R.id.restarRosa);
        restarRosa.setOnClickListener(this);
        Button sumarSacri = (Button) findViewById(R.id.sumarSacri);
        sumarSacri.setOnClickListener(this);
        Button restarSacri = (Button) findViewById(R.id.restarSacri);
        restarSacri.setOnClickListener(this);
        Button sumarHrSanta = (Button) findViewById(R.id.sumarHrSanta);
        sumarHrSanta.setOnClickListener(this);
        Button restarHrSanta = (Button) findViewById(R.id.restarHrSanta);
        restarHrSanta.setOnClickListener(this);
        Button sumarExaConci = (Button) findViewById(R.id.sumarExaConci);
        sumarExaConci.setOnClickListener(this);
        Button restarExaConci = (Button) findViewById(R.id.restarExaConci);
        restarExaConci.setOnClickListener(this);
        Button sumarConfe = (Button) findViewById(R.id.sumarConfe);
        sumarConfe.setOnClickListener(this);
        Button restarConfe = (Button) findViewById(R.id.restarConfe);
        restarConfe.setOnClickListener(this);
        Button sumarBiblia = (Button) findViewById(R.id.sumarBiblia);
        sumarBiblia.setOnClickListener(this);
        Button restarBiblia = (Button) findViewById(R.id.restarBiblia);
        restarBiblia.setOnClickListener(this);
        Button sumarHrsServi = (Button) findViewById(R.id.sumarHrsServi);
        sumarHrsServi.setOnClickListener(this);
        Button restarHrsServi = (Button) findViewById(R.id.restarHrsServi);
        restarHrsServi.setOnClickListener(this);
        Button sumarRosaMisio = (Button) findViewById(R.id.sumarRosaMisio);
        sumarRosaMisio.setOnClickListener(this);
        Button restarRosaMisio = (Button) findViewById(R.id.restarRosaMisio);
        restarRosaMisio.setOnClickListener(this);
        Button sumarAyuno = (Button) findViewById(R.id.sumarAyuno);
        sumarAyuno.setOnClickListener(this);
        Button restarAyuno = (Button) findViewById(R.id.restarAyuno);
        restarAyuno.setOnClickListener(this);
        Button sumarBendicionMesa = (Button) findViewById(R.id.sumarBendicionMesa);
        sumarBendicionMesa.setOnClickListener(this);
        Button restarBendicionMesa = (Button) findViewById(R.id.restarBendicionMesa);
        restarBendicionMesa.setOnClickListener(this);
        Button sumarObrasEsp = (Button) findViewById(R.id.sumarObrasEsp);
        sumarObrasEsp.setOnClickListener(this);
        Button restarObrasEsp = (Button) findViewById(R.id.restarObrasEsp);
        restarObrasEsp.setOnClickListener(this);
        Button sumarObrasCorp = (Button) findViewById(R.id.sumarObrasCorp);
        sumarObrasCorp.setOnClickListener(this);
        Button restarObrasCorp = (Button) findViewById(R.id.restarObrasCorp);
        restarObrasCorp.setOnClickListener(this);
        Button sumarCoronilla = (Button) findViewById(R.id.sumarCoronilla);
        sumarCoronilla.setOnClickListener(this);
        Button restarCoronilla = (Button) findViewById(R.id.restarCoronilla);
        restarCoronilla.setOnClickListener(this);
        Button sumarCaridad = (Button) findViewById(R.id.sumarCaridad);
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
    }

    /**
     * Metodo que asigna el onClick a los botones
     * @param v
     */
    public void onClick(View v) {
        switch (v.getId()) {
            /*********** Restas ***********/
            case R.id.restaMisa:
                cont = Integer.parseInt((String) ((TextView) findViewById(R.id.txtContMisa)).getText());
                cont--;
                ((TextView) findViewById(R.id.txtContMisa)).setText("" + cont);
                break;
            case R.id.restarComunion:
                cont = Integer.parseInt((String) ((TextView) findViewById(R.id.txtContComunion)).getText());
                cont--;
                ((TextView) findViewById(R.id.txtContComunion)).setText("" + cont);
                break;
            case R.id.restarComuEsp:
                cont = Integer.parseInt((String) ((TextView) findViewById(R.id.txtContComuEsp)).getText());
                cont--;
                ((TextView) findViewById(R.id.txtContComuEsp)).setText("" + cont);
                break;
            case R.id.restarRosa:
                cont = Integer.parseInt((String) ((TextView) findViewById(R.id.txtContRosa)).getText());
                cont--;
                ((TextView) findViewById(R.id.txtContRosa)).setText("" + cont);
                break;
            case R.id.restarSacri:
                cont = Integer.parseInt((String) ((TextView) findViewById(R.id.txtContSacri)).getText());
                cont--;
                ((TextView) findViewById(R.id.txtContSacri)).setText("" + cont);
                break;
            case R.id.restarHrSanta:
                cont = Integer.parseInt((String) ((TextView) findViewById(R.id.txtContHrSanta)).getText());
                cont--;
                ((TextView) findViewById(R.id.txtContHrSanta)).setText("" + cont);
                break;
            case R.id.restarExaConci:
                cont = Integer.parseInt((String) ((TextView) findViewById(R.id.txtContExaConci)).getText());
                cont--;
                ((TextView) findViewById(R.id.txtContExaConci)).setText("" + cont);
                break;
            case R.id.restarConfe:
                cont = Integer.parseInt((String) ((TextView) findViewById(R.id.txtContConfe)).getText());
                cont--;
                ((TextView) findViewById(R.id.txtContConfe)).setText("" + cont);
                break;
            case R.id.restarBiblia:
                cont = Integer.parseInt((String) ((TextView) findViewById(R.id.txtContBiblia)).getText());
                cont--;
                ((TextView) findViewById(R.id.txtContBiblia)).setText("" + cont);
                break;
            case R.id.restarHrsServi:
                cont = Integer.parseInt((String) ((TextView) findViewById(R.id.txtContHrsServi)).getText());
                cont--;
                ((TextView) findViewById(R.id.txtContHrsServi)).setText("" + cont);
                break;
            case R.id.restarRosaMisio:
                cont = Integer.parseInt((String) ((TextView) findViewById(R.id.txtContRosaMisio)).getText());
                cont--;
                ((TextView) findViewById(R.id.txtContRosaMisio)).setText("" + cont);
                break;
            case R.id.restarAyuno:
                cont = Integer.parseInt((String) ((TextView) findViewById(R.id.txtContAyuno)).getText());
                cont--;
                ((TextView) findViewById(R.id.txtContAyuno)).setText("" + cont);
                break;
            case R.id.restarBendicionMesa:
                cont = Integer.parseInt((String) ((TextView) findViewById(R.id.txtContBendicionMesa)).getText());
                cont--;
                ((TextView) findViewById(R.id.txtContBendicionMesa)).setText("" + cont);
                break;
            case R.id.restarObrasEsp:
                cont = Integer.parseInt((String) ((TextView) findViewById(R.id.txtContObrasEsp)).getText());
                cont--;
                ((TextView) findViewById(R.id.txtContObrasEsp)).setText("" + cont);
                break;
            case R.id.restarObrasCorp:
                cont = Integer.parseInt((String) ((TextView) findViewById(R.id.txtContObrasCorp)).getText());
                cont--;
                ((TextView) findViewById(R.id.txtContObrasCorp)).setText("" + cont);
                break;
            case R.id.restarCoronilla:
                cont = Integer.parseInt((String) ((TextView) findViewById(R.id.txtContCoronilla)).getText());
                cont--;
                ((TextView) findViewById(R.id.txtContCoronilla)).setText("" + cont);
                break;
            case R.id.restarCaridad:
                cont = Integer.parseInt((String) ((TextView) findViewById(R.id.txtContCaridad)).getText());
                cont--;
                ((TextView) findViewById(R.id.txtContCaridad)).setText("" + cont);
                break;
            case R.id.restarPadreNuestro:
                cont = Integer.parseInt((String) ((TextView) findViewById(R.id.txtContPadreNuestro)).getText());
                cont--;
                ((TextView) findViewById(R.id.txtContPadreNuestro)).setText("" + cont);
                break;
            case R.id.restarAveMaria:
                cont = Integer.parseInt((String) ((TextView) findViewById(R.id.txtContAveMaria)).getText());
                cont--;
                ((TextView) findViewById(R.id.txtContAveMaria)).setText("" + cont);
                break;

            /*********** Sumas ***********/
            case R.id.sumarMisa:
                cont = Integer.parseInt((String) ((TextView) findViewById(R.id.txtContMisa)).getText());
                cont++;
                ((TextView) findViewById(R.id.txtContMisa)).setText("" + cont);
                break;
            case R.id.sumarComunion:
                cont = Integer.parseInt((String) ((TextView) findViewById(R.id.txtContComunion)).getText());
                cont++;
                ((TextView) findViewById(R.id.txtContComunion)).setText("" + cont);
                break;
            case R.id.sumarComuEsp:
                cont = Integer.parseInt((String) ((TextView) findViewById(R.id.txtContComuEsp)).getText());
                cont++;
                ((TextView) findViewById(R.id.txtContComuEsp)).setText("" + cont);
                break;
            case R.id.sumarRosa:
                cont = Integer.parseInt((String) ((TextView) findViewById(R.id.txtContRosa)).getText());
                cont++;
                ((TextView) findViewById(R.id.txtContRosa)).setText("" + cont);
                break;
            case R.id.sumarSacri:
                cont = Integer.parseInt((String) ((TextView) findViewById(R.id.txtContSacri)).getText());
                cont++;
                ((TextView) findViewById(R.id.txtContSacri)).setText("" + cont);
                break;
            case R.id.sumarHrSanta:
                cont = Integer.parseInt((String) ((TextView) findViewById(R.id.txtContHrSanta)).getText());
                cont++;
                ((TextView) findViewById(R.id.txtContHrSanta)).setText("" + cont);
                break;
            case R.id.sumarExaConci:
                cont = Integer.parseInt((String) ((TextView) findViewById(R.id.txtContExaConci)).getText());
                cont++;
                ((TextView) findViewById(R.id.txtContExaConci)).setText("" + cont);
                break;
            case R.id.sumarConfe:
                cont = Integer.parseInt((String) ((TextView) findViewById(R.id.txtContConfe)).getText());
                cont++;
                ((TextView) findViewById(R.id.txtContConfe)).setText("" + cont);
                break;
            case R.id.sumarBiblia:
                cont = Integer.parseInt((String) ((TextView) findViewById(R.id.txtContBiblia)).getText());
                cont++;
                ((TextView) findViewById(R.id.txtContBiblia)).setText("" + cont);
                break;
            case R.id.sumarHrsServi:
                cont = Integer.parseInt((String) ((TextView) findViewById(R.id.txtContHrsServi)).getText());
                cont++;
                ((TextView) findViewById(R.id.txtContHrsServi)).setText("" + cont);
                break;
            case R.id.sumarRosaMisio:
                cont = Integer.parseInt((String) ((TextView) findViewById(R.id.txtContRosaMisio)).getText());
                cont++;
                ((TextView) findViewById(R.id.txtContRosaMisio)).setText("" + cont);
                break;
            case R.id.sumarAyuno:
                cont = Integer.parseInt((String) ((TextView) findViewById(R.id.txtContAyuno)).getText());
                cont++;
                ((TextView) findViewById(R.id.txtContAyuno)).setText("" + cont);
                break;
            case R.id.sumarBendicionMesa:
                cont = Integer.parseInt((String) ((TextView) findViewById(R.id.txtContBendicionMesa)).getText());
                cont++;
                ((TextView) findViewById(R.id.txtContBendicionMesa)).setText("" + cont);
                break;
            case R.id.sumarObrasEsp:
                cont = Integer.parseInt((String) ((TextView) findViewById(R.id.txtContObrasEsp)).getText());
                cont++;
                ((TextView) findViewById(R.id.txtContObrasEsp)).setText("" + cont);
                break;
            case R.id.sumarObrasCorp:
                cont = Integer.parseInt((String) ((TextView) findViewById(R.id.txtContObrasCorp)).getText());
                cont++;
                ((TextView) findViewById(R.id.txtContObrasCorp)).setText("" + cont);
                break;
            case R.id.sumarCoronilla:
                cont = Integer.parseInt((String) ((TextView) findViewById(R.id.txtContCoronilla)).getText());
                cont++;
                ((TextView) findViewById(R.id.txtContCoronilla)).setText("" + cont);
                break;
            case R.id.sumarCaridad:
                cont = Integer.parseInt((String) ((TextView) findViewById(R.id.txtContCaridad)).getText());
                cont++;
                ((TextView) findViewById(R.id.txtContCaridad)).setText("" + cont);
                break;
            case R.id.sumarPadreNuestro:
                cont = Integer.parseInt((String) ((TextView) findViewById(R.id.txtContPadreNuestro)).getText());
                cont++;
                ((TextView) findViewById(R.id.txtContPadreNuestro)).setText("" + cont);
                break;
            case R.id.sumarAveMaria:
                cont = Integer.parseInt((String) ((TextView) findViewById(R.id.txtContAveMaria)).getText());
                cont++;
                ((TextView) findViewById(R.id.txtContAveMaria)).setText("" + cont);
                break;

            default:
                Log.d("error", "la condicion callo aqui");
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        /**
         * noinspection SimplifiableIfStatement
         * Esto de aqui es el menu de la derecha
         */
        if (id == R.id.action_settings) {
            //return true;
            configuracion();
        }else if (id == R.id.menuContacto){
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto","pastoral.juvenil.sfj@gmail.com", null));
            startActivity(Intent.createChooser(emailIntent, "Selecciona Aplicación"));
        }else if (id == R.id.menuInfo){
            acercade();
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Esto de aquí es el menu ;)
     *
     * @param item seleccionado
     * @return la opcion que fue seleccionada del menu
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.itm_Reiniciar) {
            //Opcion de reiniciar
            resTodo();
        } else if (id == R.id.itm_Ejercicios) {
            //Opcion de Ejercicios Espirituales
            Intent ListSong = new Intent(getApplicationContext(), ejercicios_esp.class);
            startActivity(ListSong);
            finish();


        } else if (id == R.id.itm_Guardar) {
            //Opcion de guardar
            onGuardar(1);
        } else if (id == R.id.itm_AcercaDe) {
            acercade();
        }  else if (id == R.id.itm_instrucciones){
            instrucciones();
        } else if (id == R.id.itm_Configurar) {
            //Configuracion
           // Toast.makeText(MainActivity.this,"Opcion no implementada",Toast.LENGTH_SHORT).show();
            configuracion();
        } else if (id == R.id.itm_Compartir) {
            compartir();
        } else if (id == R.id.itm_Enviar) {
            enviar();
        } else if (id == R.id.itm_Salir) {
            System.exit(0);
            //finish();
            //finishAffinity();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /*********************************************************************************************
     *                                         METODOS
     ********************************************************************************************/

    /**
     * Metodo para enviar la informacion por whatsapp
     */
    private void enviar() {
          /*Uri uri = Uri.parse("smsto:" + "+5216142276865");
            Intent i = new Intent(Intent.ACTION_SENDTO, uri);
            i.putExtra("sms_body", "hola erick este es un mensaje desde el ramillete directo a usted ;)");
            i.putExtra(Intent.EXTRA_TEXT, "hola erick este es un mensaje desde el ramillete directo a usted ;)");
            i.setPackage("com.whatsapp");
            startActivity(i);*/

        String smsNumber = "521"+ mCel;
        Log.d("valor",smsNumber);
        // "5216142276865";//without '+'
        try {
            Intent sendIntent = new Intent("android.intent.action.MAIN");
            //sendIntent.setComponent(new ComponentName("com.whatsapp", "com.whatsapp.Conversation"));
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.setType("text/plain");
            //sendIntent.putExtra(Intent.EXTRA_TEXT, "Hola erick este es un mensaje desde el ramillete directo a usted ;)");

            cargarPreferencias();
            // Todo esto cambia el String "datos" para dejarlo entendible, borra espacios y cambia los nombres
            datos = datos.replaceAll("[^a-zA-Z0-9={} -]", "\n");
            datos = datos.replaceAll("[{|}]", " ");
            datos = datos.replaceAll("ComunionEsp", "Comunión Espiritual");
            datos = datos.replaceAll("Comunion", "Comunión");
            datos = datos.replaceAll("hrSanta", "Hora Santa");
            datos = datos.replaceAll("ExamenConci", "Examen de Conciencia");
            datos = datos.replaceAll("Confesion", "Confesión");
            datos = datos.replaceAll("HrServicio", "Hrs. de Servicio");
            datos = datos.replaceAll("RosaMisio", "Rosario Misionero");
            datos = datos.replaceAll("BendicionMesa", "Bendicion de Mesa");
            datos = datos.replaceAll("ObrCorporal", "Obrs de Misr Corporal");
            datos = datos.replaceAll("ObrEspiritual", "Obrs de Misr Espiritual");
            datos = datos.replaceAll("PadreNuestro", "Padres Nuestros");
            datos = datos.replaceAll("AveMaria", "Aves Marias");

            //sendIntent.putExtra(Intent.EXTRA_TEXT, "*Ramillete de "+username+": * \n"+datos);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "*Ramillete de " + nombreUs +"*: \n" +datos);
            sendIntent.putExtra("jid", smsNumber + "@s.whatsapp.net");//phone number without "+" prefix
            sendIntent.setPackage("com.whatsapp");
            startActivity(sendIntent);
        } catch(Exception e) {

            Toast.makeText(this, "Error/n" + e.toString(),
                    Toast.LENGTH_SHORT).show();

        }
    }

    /**
     * Metodo para enviar la informacion por correo
     */
    private void compartir() {
        //Intent intent = new Intent(Intent.ACTION_SEND);
        //intent.setType("text/plain");
        //intent.putExtra(Intent.EXTRA_TEXT, cargarPreferencias());
        //intent.setPackage("com.facebook.katana");
        //startActivity(Intent.createChooser(intent, "Share with"));
        //intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        cargarPreferencias();
        // Todo esto cambia el String "datos" para dejarlo entendible, borra espacios y cambia los nombres
        datos = datos.replaceAll("[^a-zA-Z0-9={} ]", "\n");
        datos = datos.replaceAll("[{|}]", " ");
        datos = datos.replaceAll("ComunionEsp", "Comunión Espiritual");
        datos = datos.replaceAll("Comunion", "Comunión");
        datos = datos.replaceAll("hrSanta", "Hora Santa");
        datos = datos.replaceAll("ExamenConci", "Examen de Conciencia");
        datos = datos.replaceAll("Confesion", "Confesión");
        datos = datos.replaceAll("HrServicio", "Hrs. de Servicio");
        datos = datos.replaceAll("RosaMisio", "Rosario Misionero");
        datos = datos.replaceAll("BendicionMesa", "Bendicion de Mesa");
        datos = datos.replaceAll("ObrCorporal", "Obrs de Misr Corporal");
        datos = datos.replaceAll("ObrEspiritual", "Obrs de Misr Espiritual");
        datos = datos.replaceAll("PadreNuestro", "Padres Nuestros");
        datos = datos.replaceAll("AveMaria", "Aves Marias");

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto",correo, null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Ramillete de "+nombreUs);
        emailIntent.putExtra(Intent.EXTRA_TEXT, ""+ datos);
        startActivity(Intent.createChooser(emailIntent, "Selecciona Aplicación"));

            /*
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setData(Uri.parse("mailto:"));
            //String[] to = direccionesEmail;
            //String[] cc = copias;
            emailIntent.putExtra(Intent.EXTRA_EMAIL, "kcirex@gmail.com");
            emailIntent.putExtra(Intent.EXTRA_CC, cc);
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Ramillete de "+ nombreUs);
            emailIntent.putExtra(Intent.EXTRA_TEXT, ""+ datos);
            emailIntent.setType("message/rfc822");
            startActivity(Intent.createChooser(emailIntent, "Selecciona Aplicacion"));
            */


           /* Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
            sendIntent.putExtra(Intent.EXTRA_PHONE_NUMBER, "+5216142276865");
            sendIntent.putExtra(Intent.EXTRA_USER, "+5216142276865");
            //sendIntent.setPackage("com.gmail");
            sendIntent.setType("message/rfc822");
            startActivity(Intent.createChooser(sendIntent, "manuelg.uk@gmail.com"));
            */

            //this.startActivity(Intent.createChooser(intent,  "Compartir en" ));
            //startActivity(intent);
    }

    /**
     * Metodo que te da las instrucciones de uso
     */
    private void instrucciones() {
        //Boton acerca de
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("1- Entra a la opción de configuración." +
                "\n\n 2- Ingresa tu nombre de usuario eje. Meny." +
                "\n\n 3- Ingresa el teléfono del contacto de WhatsApp al que vas a enviar" +
                " los datos del ramillete." +
                "\n\n 4- Ingresa el correo del contacto al que vas a enviar los datos del ramillete" +
                "\n\n 5- Agrega o quita tus actividades semanales en el ramillete." +
                "\n\n 6- Al finalizar la semana/mes envía los datos a tu contacto y resetea la app" +
                " con la opción de reiniciar.")
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

    /**
     * Metodo que te muestra la informacion de la aplicacion
     */
    private void acercade() {
        //Boton acerca de
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Ramillete para la pastoral juvenil de la parroquia de San Francisco Javier" +
                " Chihuahua, Mex. \n\n" +
                " - Ver. 1.0 \n" +
                " - Autores: \n     Erick Martínez" +
                " \n     Manuel García \n" +
                " \n -Contacto: \n    Pastoral.juvenil.sfj@gmail.com"+
                " \n\n ©2017 PastoralSFJ. All rights reserved")
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

    /**
     * Metodo para configurar la opcion de enviar
     * @userName nombre de usuario
     * @Phone telefono a enviar
     * @Correo correo a enviar
     */
    private void configuracion() {
        final AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        final View mView = getLayoutInflater().inflate(R.layout.configuracion,null);
        final EditText mUser = (EditText) mView.findViewById(R.id.userNombre);
        final EditText mPhone = (EditText) mView.findViewById(R.id.phone);
        final EditText mCorreo = (EditText) mView.findViewById(R.id.correo);
        mUser.setText(nombreUs);
        mPhone.setText(mCel);
        mCorreo.setText(correo);


        Button mSaveConfi = (Button) mView.findViewById(R.id.btnSaveConfig);

        mSaveConfi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCel= ""+((EditText) mView.findViewById(R.id.phone)).getText();
                nombreUs =""+((EditText) mView.findViewById(R.id.userNombre)).getText();
                correo = ""+((EditText) mView.findViewById(R.id.correo)).getText();
                SharedPreferences misPreferencias = getSharedPreferences("DatosUsuario", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = misPreferencias.edit();
                editor.putString("Telefono", mCel);
                editor.putString("Nombre", ""+nombreUs);
                editor.putString("email", ""+correo);
                editor.commit();
                Intent ListSong = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(ListSong);
                finish();

                if(!mUser.getText().toString().isEmpty()
                        && !mPhone.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Configuración Guardada con exito",
                            Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Porfavor Rellene los campos vacios",
                            Toast.LENGTH_SHORT).show();
                }
            }

        });
        mBuilder.setView(mView);
        AlertDialog dialog=mBuilder.create();
        dialog.show();
    }

    /**
     * Metodo para resetear el ramillete
     */
    public void resTodo() {
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("Importante");
        dialogo1.setMessage("¿ Desea reiniciar los avances ?");
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton("Simon", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                aceptar();
            }
        });
        dialogo1.setNegativeButton("No =O", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                cancelar();
            }
        });
        dialogo1.show();
    }

    public void aceptar() {
        Toast t=Toast.makeText(this,"Reseteando todo", Toast.LENGTH_SHORT);
        t.show();
        ((TextView) findViewById(R.id.txtContMisa)).setText("0");
        ((TextView) findViewById(R.id.txtContComunion)).setText("0");
        ((TextView) findViewById(R.id.txtContComuEsp)).setText("0");
        ((TextView) findViewById(R.id.txtContRosa)).setText("0");
        ((TextView) findViewById(R.id.txtContSacri)).setText("0");
        ((TextView) findViewById(R.id.txtContHrSanta)).setText("0");
        ((TextView) findViewById(R.id.txtContExaConci)).setText("0");
        ((TextView) findViewById(R.id.txtContConfe)).setText("0");
        ((TextView) findViewById(R.id.txtContBiblia)).setText("0");
        ((TextView) findViewById(R.id.txtContHrsServi)).setText("0");
        ((TextView) findViewById(R.id.txtContRosaMisio)).setText("0");
        ((TextView) findViewById(R.id.txtContAyuno)).setText("0");
        ((TextView) findViewById(R.id.txtContBendicionMesa)).setText("0");
        ((TextView) findViewById(R.id.txtContObrasEsp)).setText("0");
        ((TextView) findViewById(R.id.txtContObrasCorp)).setText("0");
        ((TextView) findViewById(R.id.txtContCoronilla)).setText("0");
        ((TextView) findViewById(R.id.txtContCaridad)).setText("0");
        ((TextView) findViewById(R.id.txtContPadreNuestro)).setText("0");
        ((TextView) findViewById(R.id.txtContAveMaria)).setText("0");
        onGuardar(2);
    }

    public void cancelar() {
        Toast t=Toast.makeText(this,"Bueno... =D", Toast.LENGTH_SHORT);
        t.show();
        //finish();
    }

    /**
     * Metodo Para cargar los datos guardados
     */
    private void cargarPreferencias() {

        Misa = (TextView) findViewById(R.id.txtContMisa);
        Comunion = (TextView) findViewById(R.id.txtContComunion);
        ComuEsp = (TextView) findViewById(R.id.txtContComuEsp);
        Rosa = (TextView) findViewById(R.id.txtContRosa);
        Sacri = (TextView) findViewById(R.id.txtContSacri);
        HrSanta = (TextView) findViewById(R.id.txtContHrSanta);
        ExaConci = (TextView) findViewById(R.id.txtContExaConci);
        Confe = (TextView) findViewById(R.id.txtContConfe);
        Biblia = (TextView) findViewById(R.id.txtContBiblia);
        HrsServicio = (TextView) findViewById(R.id.txtContHrsServi);
        RosaMisio = (TextView) findViewById(R.id.txtContRosaMisio);
        Ayuno = (TextView) findViewById(R.id.txtContAyuno);
        BendicionMesa = (TextView) findViewById(R.id.txtContBendicionMesa);
        ObrasEsp = (TextView) findViewById(R.id.txtContObrasEsp);
        ObrasCorp = (TextView) findViewById(R.id.txtContObrasCorp);
        Coronilla = (TextView) findViewById(R.id.txtContCoronilla);
        Caridad = (TextView) findViewById(R.id.txtContCaridad);
        PadreNuestro = (TextView) findViewById(R.id.txtContPadreNuestro);
        AveMaria = (TextView) findViewById(R.id.txtContAveMaria);

        SharedPreferences misPreferencias = getSharedPreferences("RamilleteUsuario", Context.MODE_PRIVATE);

        Misa.setText(misPreferencias.getString("Misa", "0"));
        Comunion.setText(misPreferencias.getString("Comunion", "0"));
        ComuEsp.setText(misPreferencias.getString("ComunionEsp", "0"));
        Rosa.setText(misPreferencias.getString("Rosario", "0"));
        Sacri.setText(misPreferencias.getString("Sacrificio", "0"));
        HrSanta.setText(misPreferencias.getString("hrSanta", "0"));
        ExaConci.setText(misPreferencias.getString("ExamenConci", "0"));
        Confe.setText(misPreferencias.getString("Confesion", "0"));
        Biblia.setText(misPreferencias.getString("Biblia", "0"));
        HrsServicio.setText(misPreferencias.getString("HrServicio", "0"));
        RosaMisio.setText(misPreferencias.getString("RosaMisio", "0"));
        Ayuno.setText(misPreferencias.getString("Ayuno", "0"));
        BendicionMesa.setText(misPreferencias.getString("BendicionMesa", "0"));
        ObrasEsp.setText(misPreferencias.getString("ObrEspiritual", "0"));
        ObrasCorp.setText(misPreferencias.getString("ObrCorporal", "0"));
        Coronilla.setText(misPreferencias.getString("Coronilla", "0"));
        Caridad.setText(misPreferencias.getString("Caridad", "0"));
        PadreNuestro.setText(misPreferencias.getString("PadreNuestro", "0"));
        AveMaria.setText(misPreferencias.getString("AveMaria", "0"));


        datos=misPreferencias.getAll().toString();

        Toast toast = Toast.makeText(this, "Cargado", Toast.LENGTH_SHORT);
        toast.show();

    }

    /**
     * Metodo para guardar
     * @param f
     */
    public void onGuardar(int f) {

        SharedPreferences misPreferencias = getSharedPreferences("RamilleteUsuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = misPreferencias.edit();
        editor.putString("Misa", (String) ((TextView) findViewById(R.id.txtContMisa)).getText());
        editor.putString("Comunion", (String) ((TextView) findViewById(R.id.txtContComunion)).getText());
        editor.putString("ComunionEsp", (String) ((TextView) findViewById(R.id.txtContComuEsp)).getText());
        editor.putString("Rosario", (String) ((TextView) findViewById(R.id.txtContRosa)).getText());
        editor.putString("Sacrificio", (String) ((TextView) findViewById(R.id.txtContSacri)).getText());
        editor.putString("hrSanta", (String) ((TextView) findViewById(R.id.txtContHrSanta)).getText());
        editor.putString("ExamenConci", (String) ((TextView) findViewById(R.id.txtContExaConci)).getText());
        editor.putString("Confesion", (String) ((TextView) findViewById(R.id.txtContConfe)).getText());
        editor.putString("Biblia", (String) ((TextView) findViewById(R.id.txtContBiblia)).getText());
        editor.putString("HrServicio", (String) ((TextView) findViewById(R.id.txtContHrsServi)).getText());
        editor.putString("RosaMisio", (String) ((TextView) findViewById(R.id.txtContRosaMisio)).getText());
        editor.putString("Ayuno", (String) ((TextView) findViewById(R.id.txtContAyuno)).getText());
        editor.putString("BendicionMesa", (String) ((TextView) findViewById(R.id.txtContBendicionMesa)).getText());
        editor.putString("ObrEspiritual", (String) ((TextView) findViewById(R.id.txtContObrasEsp)).getText());
        editor.putString("ObrCorporal", (String) ((TextView) findViewById(R.id.txtContObrasCorp)).getText());
        editor.putString("Coronilla", (String) ((TextView) findViewById(R.id.txtContCoronilla)).getText());
        editor.putString("Caridad", (String) ((TextView) findViewById(R.id.txtContCaridad)).getText());
        editor.putString("PadreNuestro", (String) ((TextView) findViewById(R.id.txtContPadreNuestro)).getText());
        editor.putString("AveMaria", (String) ((TextView) findViewById(R.id.txtContAveMaria)).getText());

        editor.commit();

        if (f == 1) {
            Toast toast = Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT);
            toast.show();
        } else if (f == 2) {
            Toast toast = Toast.makeText(this, "Datos eliminados", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    /************************************************************************
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
