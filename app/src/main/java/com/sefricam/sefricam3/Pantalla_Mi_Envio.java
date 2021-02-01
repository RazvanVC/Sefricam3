package com.sefricam.sefricam3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class Pantalla_Mi_Envio extends Activity implements View.OnClickListener{

    //Datos Entorno
    ImageView iv_DatosCheckBoxEntorno;
    TextView tv_DatosTemperaturaInicio,tv_DatosTemperaturaFin,tv_DatosZonificacion,tv_DatosDireccionViento,tv_DatosViento,tv_DatosNubes,tv_DatosLluvia,tv_DatosPlantas;

    //Metodos de Captura
    ImageView iv_DatosCheckBoxCapturas;
    TextView tv_DatosNumeroMallas, tv_DatosLongitudRed, tv_DatosCoto, tv_DatosControlAgentes;
    TextView tv_DatosReclamosCamichuelo, tv_DatosCimbelesCamichuelo, tv_DatosCapturasCamichuelo;
    TextView tv_DatosReclamosJilguero, tv_DatosCimbelesJilguero, tv_DatosCapturasJilguero;
    TextView tv_DatosReclamosLugano, tv_DatosCimbelesLugano, tv_DatosCapturasLugano;
    TextView tv_DatosReclamosPardilloComun, tv_DatosCimbelesPardilloComun, tv_DatosCapturasPardilloComun;
    TextView tv_DatosReclamosPicogordo, tv_DatosCimbelesPicogordo, tv_DatosCapturasPicogordo;
    TextView tv_DatosReclamosPinzonComun, tv_DatosCimbelesPinzonComun, tv_DatosCapturasPinzonComun;
    TextView tv_DatosReclamosPinzonReal, tv_DatosCimbelesPinzonReal, tv_DatosCapturasPinzonReal;
    TextView tv_DatosReclamosPiquituerto, tv_DatosCimbelesPiquituerto, tv_DatosCapturasPiquituerto;
    TextView tv_DatosReclamosVerdecillo, tv_DatosCimbelesVerdecillo, tv_DatosCapturasVerdecillo;
    TextView tv_DatosReclamosVerderonComun, tv_DatosCimbelesVerderonComun, tv_DatosCapturasVerderonComun;
    TextView tv_DatosReclamosVerderonSerrano, tv_DatosCimbelesVerderonSerrano, tv_DatosCapturasVerderonSerrano;
    TextView tv_DatosObservaciones;

    //Datos Avistamiento
    ImageView iv_DatosCheckBoxAvistamiento;
    TextView tv_DatosHoraInicio, tv_DatosHoraFin;
    TextView tv_DatosEspecieCamachuelo08, tv_DatosEspecieJilguero08, tv_DatosEspecieLugano08, tv_DatosEspeciePardilloComun08, tv_DatosEspeciePicogordo08, tv_DatosEspeciePinzonComun08, tv_DatosEspeciePinzonReal08, tv_DatosEspeciePiquituerto08, tv_DatosEspecieVerdecillo08, tv_DatosEspecieVerdonComun08, tv_DatosEspecieVerdonSerrano08;
    TextView tv_DatosEspecieCamachuelo09, tv_DatosEspecieJilguero09, tv_DatosEspecieLugano09, tv_DatosEspeciePardilloComun09, tv_DatosEspeciePicogordo09, tv_DatosEspeciePinzonComun09, tv_DatosEspeciePinzonReal09, tv_DatosEspeciePiquituerto09, tv_DatosEspecieVerdecillo09, tv_DatosEspecieVerdonComun09, tv_DatosEspecieVerdonSerrano09;
    TextView tv_DatosEspecieCamachuelo10, tv_DatosEspecieJilguero10, tv_DatosEspecieLugano10, tv_DatosEspeciePardilloComun10, tv_DatosEspeciePicogordo10, tv_DatosEspeciePinzonComun10, tv_DatosEspeciePinzonReal10, tv_DatosEspeciePiquituerto10, tv_DatosEspecieVerdecillo10, tv_DatosEspecieVerdonComun10, tv_DatosEspecieVerdonSerrano10;
    TextView tv_DatosEspecieCamachuelo11, tv_DatosEspecieJilguero11, tv_DatosEspecieLugano11, tv_DatosEspeciePardilloComun11, tv_DatosEspeciePicogordo11, tv_DatosEspeciePinzonComun11, tv_DatosEspeciePinzonReal11, tv_DatosEspeciePiquituerto11, tv_DatosEspecieVerdecillo11, tv_DatosEspecieVerdonComun11, tv_DatosEspecieVerdonSerrano11;
    TextView tv_DatosEspecieCamachuelo12, tv_DatosEspecieJilguero12, tv_DatosEspecieLugano12, tv_DatosEspeciePardilloComun12, tv_DatosEspeciePicogordo12, tv_DatosEspeciePinzonComun12, tv_DatosEspeciePinzonReal12, tv_DatosEspeciePiquituerto12, tv_DatosEspecieVerdecillo12, tv_DatosEspecieVerdonComun12, tv_DatosEspecieVerdonSerrano12;
    TextView tv_DatosEspecieCamachuelo13, tv_DatosEspecieJilguero13, tv_DatosEspecieLugano13, tv_DatosEspeciePardilloComun13, tv_DatosEspeciePicogordo13, tv_DatosEspeciePinzonComun13, tv_DatosEspeciePinzonReal13, tv_DatosEspeciePiquituerto13, tv_DatosEspecieVerdecillo13, tv_DatosEspecieVerdonComun13, tv_DatosEspecieVerdonSerrano13;
    TextView tv_DatosEspecieCamachuelo14, tv_DatosEspecieJilguero14, tv_DatosEspecieLugano14, tv_DatosEspeciePardilloComun14, tv_DatosEspeciePicogordo14, tv_DatosEspeciePinzonComun14, tv_DatosEspeciePinzonReal14, tv_DatosEspeciePiquituerto14, tv_DatosEspecieVerdecillo14, tv_DatosEspecieVerdonComun14, tv_DatosEspecieVerdonSerrano14;

    //Buttons
    Button btn_VolverDatos;
    //Parametros
    private boolean envioCompletado;
    private MetodosCaptura metodosCaptura;
    private DatosAvistamiento datosAvistamiento;
    private DatosEntorno datosEntorno;
    private boolean mCapturasCompletado,avistamientoCompletado,entornoCompletado;
    private String email;
    private String DNI;
    //Solo usados una vez completado el envío
    private double latitud,longitud;
    private String fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle datos = this.getIntent().getExtras();
        if (datos != null) {
            recuperarDatosRecibidos(datos);

            //Datos Recibidos de Menu Metodos y Capturas
            latitud = datos.getDouble("LATITUD");
            longitud = datos.getDouble("LONGITUD");
            fecha = datos.getString("FECHA");

            System.out.println("Datos recibidos en Mi Envio");
            imprimirDatosRecibidos();
        }

        setContentView(R.layout.pantalla_mi_envio);
        iniciarComponentes();
        iniciarOnClickListener();

        if (entornoCompletado) cargarDatosEntorno();

        if (mCapturasCompletado) cargarDatosMCapturas();

        if (avistamientoCompletado) cargarDatosAvistamiento();

    }

    private void cargarDatosEntorno() {
        iv_DatosCheckBoxEntorno.setBackground(getDrawable(R.drawable.baseline_check_box_24));

        tv_DatosTemperaturaInicio.setText(String.valueOf(datosEntorno.gettInicio())+" ºC");
        tv_DatosTemperaturaFin.setText(String.valueOf(datosEntorno.gettFin())+" ºC");
        switch (datosEntorno.getZonificacion()){
            case 1:
                tv_DatosZonificacion.setText("Afloramientos Rocosos y Rasos");
                break;
            case 2:
                tv_DatosZonificacion.setText("Cultivos");
                break;
            case 3:
                tv_DatosZonificacion.setText("Láminas y Cursos de Agua");
                break;
            case 4:
                tv_DatosZonificacion.setText("Dehesa y zonas adehesadas");
                break;
            case 5:
                tv_DatosZonificacion.setText("Plantaciones de Frondosas y Coníferas");
                break;
            case 6:
                tv_DatosZonificacion.setText("Vegetación Arbórea de Coníferas");
                break;
            case 7:
                tv_DatosZonificacion.setText("Vegetación Arbórea de Frondosas");
                break;
            case 8:
                tv_DatosZonificacion.setText("Vegetación de Matorral");
                break;
            case 9:
                tv_DatosZonificacion.setText("Vegetación Herbácea");
                break;
            case 10:
                tv_DatosZonificacion.setText("Viñedos, Olivares y Otros Frutales");
                break;
            case 11:
                tv_DatosZonificacion.setText("Zonas Artificiales");
                break;
        }
        tv_DatosDireccionViento.setText(datosEntorno.getDireccionViento());
        switch (datosEntorno.getViento()){
            case 1:
                tv_DatosViento.setText("Calma");
                break;
            case 2:
                tv_DatosViento.setText("Ligero");
                break;
            case 3:
                tv_DatosViento.setText("Fuerte");
                break;
        }
        switch (datosEntorno.getNubes()){
            case 1:
                tv_DatosNubes.setText("Ausentes");
                break;
            case 2:
                tv_DatosNubes.setText("Nubes y claros");
                break;
            case 3:
                tv_DatosNubes.setText("Cubierto");
                break;
            case 4:
                tv_DatosNubes.setText("Muy Cubierto");
                break;
        }
        switch (datosEntorno.getLluvia()){
            case 1:
                tv_DatosLluvia.setText("Ausentes");
                break;
            case 2:
                tv_DatosLluvia.setText("Intermitente");
                break;
            case 3:
                tv_DatosLluvia.setText("Ligera");
                break;
            case 4:
                tv_DatosLluvia.setText("Fuerte");
                break;
            case 5:
                tv_DatosLluvia.setText("Muy fuerte");
                break;
        }
        int i = 0;
        while (i<datosEntorno.getPlantas().size()){
            String estado = "No encontrado";
            if (datosEntorno.getPlantas().get(i) == 1) estado = "Encontrado";
            if (datosEntorno.getPlantas().get(i) == 2) estado = "Abundante";
            if (i < 9) tv_DatosPlantas.append(("0" + (i + 1)) + ". " + estado + "\n");
            else tv_DatosPlantas.append((i + 1) + ". " + estado + "\n");
            i++;
        }

        if (datosEntorno.getEP37()!="")tv_DatosPlantas.append("37. "+datosEntorno.getEP37()+"\n");
        else tv_DatosPlantas.append("37. No encontrado\n");

        if (datosEntorno.getEP38()!="")tv_DatosPlantas.append("38. "+datosEntorno.getEP38());
        else tv_DatosPlantas.append("38. No encontrado");
    }

    private void cargarDatosMCapturas() {
        iv_DatosCheckBoxCapturas.setBackground(getDrawable(R.drawable.baseline_check_box_24));
        tv_DatosNumeroMallas.setText(String.valueOf(metodosCaptura.getNumeroMallas()));
        tv_DatosLongitudRed.setText(String.valueOf(metodosCaptura.getLongitudRed()));
        if (metodosCaptura.isCoto()){
           tv_DatosCoto.setText("Si");
        } else {
            tv_DatosCoto.setText("No");
        }
        int i = 0;
        /*while (i < metodosCaptura.getControlAgentes().size()){
            switch (metodosCaptura.getControlAgentes().get(i)){
                case 0:
                    tv_DatosControlAgentes.append("NO");
                    break;
                case 1:
                    tv_DatosControlAgentes.append("Seprona\n");
                    break;
                case 2:
                    tv_DatosControlAgentes.append("Agentes Forestales\n");
                    break;
                case 3:
                    tv_DatosControlAgentes.append("Policía Local\n");
                    break;
                case 4:
                    tv_DatosControlAgentes.append("Policía Nacional\n");
                    break;
                case 5:
                    tv_DatosControlAgentes.append("Otros");
                    break;
            }
            i++;
        }

        tv_DatosReclamosCamichuelo.setText(String.valueOf(metodosCaptura.getReclamosCamachuelo()));
        tv_DatosCimbelesCamichuelo.setText(String.valueOf(metodosCaptura.getCimbelesCamachuelo()));
        tv_DatosCapturasCamichuelo.setText(String.valueOf(metodosCaptura.getCapturasCamachueloM()));
        tv_DatosReclamosJilguero.setText(String.valueOf(metodosCaptura.getReclamosJilguero()));
        tv_DatosCimbelesJilguero.setText(String.valueOf(metodosCaptura.getCimbelesJilguero()));
        tv_DatosCapturasJilguero.setText(String.valueOf(metodosCaptura.getCapturasJilguero()));
        tv_DatosReclamosLugano.setText(String.valueOf(metodosCaptura.getReclamosLugano()));
        tv_DatosCimbelesLugano.setText(String.valueOf(metodosCaptura.getCimbelesLugano()));
        tv_DatosCapturasLugano.setText(String.valueOf(metodosCaptura.getCapturasLugano()));
        tv_DatosReclamosPardilloComun.setText(String.valueOf(metodosCaptura.getReclamosPardilloComun()));
        tv_DatosCimbelesPardilloComun.setText(String.valueOf(metodosCaptura.getCimbelesPardilloComun()));
        tv_DatosCapturasPardilloComun.setText(String.valueOf(metodosCaptura.getCapturasPardilloComun()));
        tv_DatosReclamosPicogordo.setText(String.valueOf(metodosCaptura.getReclamosPicogordo()));
        tv_DatosCimbelesPicogordo.setText(String.valueOf(metodosCaptura.getCimbelesPicogordo()));
        tv_DatosCapturasPicogordo.setText(String.valueOf(metodosCaptura.getCapturasPicogordo()));
        tv_DatosReclamosPinzonComun.setText(String.valueOf(metodosCaptura.getReclamosPinzonComun()));
        tv_DatosCimbelesPinzonComun.setText(String.valueOf(metodosCaptura.getCimbelesPinzonComun()));
        tv_DatosCapturasPinzonComun.setText(String.valueOf(metodosCaptura.getCapturasPinzonComun()));
        tv_DatosReclamosPinzonReal.setText(String.valueOf(metodosCaptura.getReclamosPinzonReal()));
        tv_DatosCimbelesPinzonReal.setText(String.valueOf(metodosCaptura.getCimbelesPinzonReal()));
        tv_DatosCapturasPinzonReal.setText(String.valueOf(metodosCaptura.getCapturasPinzonReal()));
        tv_DatosReclamosPiquituerto.setText(String.valueOf(metodosCaptura.getReclamosPiquituerto()));
        tv_DatosCimbelesPiquituerto.setText(String.valueOf(metodosCaptura.getCimbelesPiquituerto()));
        tv_DatosCapturasPiquituerto.setText(String.valueOf(metodosCaptura.getCapturasPiquituerto()));
        tv_DatosReclamosVerdecillo.setText(String.valueOf(metodosCaptura.getReclamosVerdecillo()));
        tv_DatosCimbelesVerdecillo.setText(String.valueOf(metodosCaptura.getCimbelesVerdecillo()));
        tv_DatosCapturasVerdecillo.setText(String.valueOf(metodosCaptura.getCapturasVerdecillo()));
        tv_DatosReclamosVerderonComun.setText(String.valueOf(metodosCaptura.getReclamosVerdonComun()));
        tv_DatosCimbelesVerderonComun.setText(String.valueOf(metodosCaptura.getCimbelesVerdonComun()));
        tv_DatosCapturasVerderonComun.setText(String.valueOf(metodosCaptura.getCapturasVerdonComun()));
        tv_DatosReclamosVerderonSerrano.setText(String.valueOf(metodosCaptura.getReclamosVerdonSerrano()));
        tv_DatosCimbelesVerderonSerrano.setText(String.valueOf(metodosCaptura.getCimbelesVerdonSerrano()));
        tv_DatosCapturasVerderonSerrano.setText(String.valueOf(metodosCaptura.getCapturasVerdonSerrano()));
        tv_DatosObservaciones.setText(String.valueOf(metodosCaptura.getObservaciones()));*/
    }

    private void cargarDatosAvistamiento() {
        iv_DatosCheckBoxAvistamiento.setBackground(getDrawable(R.drawable.baseline_check_box_24));

        tv_DatosHoraInicio.setText(datosAvistamiento.getHoraInicio());
        tv_DatosHoraFin.setText(datosAvistamiento.getHoraFin());

        int posicion = 0;
        while (posicion < datosAvistamiento.getHora08().size()){
            switch (posicion){
                case 0:
                    tv_DatosEspecieCamachuelo08.setText(String.valueOf(datosAvistamiento.getHora08().get(posicion)));
                    break;
                case 1:
                    tv_DatosEspecieJilguero08.setText(String.valueOf(datosAvistamiento.getHora08().get(posicion)));
                    break;
                case 2:
                    tv_DatosEspecieLugano08.setText(String.valueOf(datosAvistamiento.getHora08().get(posicion)));
                    break;
                case 3:
                    tv_DatosEspeciePardilloComun08.setText(String.valueOf(datosAvistamiento.getHora08().get(posicion)));
                    break;
                case 4:
                    tv_DatosEspeciePicogordo08.setText(String.valueOf(datosAvistamiento.getHora08().get(posicion)));
                    break;
                case 5:
                    tv_DatosEspeciePinzonComun08.setText(String.valueOf(datosAvistamiento.getHora08().get(posicion)));
                    break;
                case 6:
                    tv_DatosEspeciePinzonReal08.setText(String.valueOf(datosAvistamiento.getHora08().get(posicion)));
                    break;
                case 7:
                    tv_DatosEspeciePiquituerto08.setText(String.valueOf(datosAvistamiento.getHora08().get(posicion)));
                    break;
                case 8:
                    tv_DatosEspecieVerdecillo08.setText(String.valueOf(datosAvistamiento.getHora08().get(posicion)));
                    break;
                case 9:
                    tv_DatosEspecieVerdonComun08.setText(String.valueOf(datosAvistamiento.getHora08().get(posicion)));
                    break;
                case 10:
                    tv_DatosEspecieVerdonSerrano08.setText(String.valueOf(datosAvistamiento.getHora08().get(posicion)));
                    break;
            }
            posicion++;
        }

        posicion = 0;
        while (posicion < datosAvistamiento.getHora09().size()){
            switch (posicion){
                case 0:
                    tv_DatosEspecieCamachuelo09.setText(String.valueOf(datosAvistamiento.getHora09().get(posicion)));
                    break;
                case 1:
                    tv_DatosEspecieJilguero09.setText(String.valueOf(datosAvistamiento.getHora09().get(posicion)));
                    break;
                case 2:
                    tv_DatosEspecieLugano09.setText(String.valueOf(datosAvistamiento.getHora09().get(posicion)));
                    break;
                case 3:
                    tv_DatosEspeciePardilloComun09.setText(String.valueOf(datosAvistamiento.getHora09().get(posicion)));
                    break;
                case 4:
                    tv_DatosEspeciePicogordo09.setText(String.valueOf(datosAvistamiento.getHora09().get(posicion)));
                    break;
                case 5:
                    tv_DatosEspeciePinzonComun09.setText(String.valueOf(datosAvistamiento.getHora09().get(posicion)));
                    break;
                case 6:
                    tv_DatosEspeciePinzonReal09.setText(String.valueOf(datosAvistamiento.getHora09().get(posicion)));
                    break;
                case 7:
                    tv_DatosEspeciePiquituerto09.setText(String.valueOf(datosAvistamiento.getHora09().get(posicion)));
                    break;
                case 8:
                    tv_DatosEspecieVerdecillo09.setText(String.valueOf(datosAvistamiento.getHora09().get(posicion)));
                    break;
                case 9:
                    tv_DatosEspecieVerdonComun09.setText(String.valueOf(datosAvistamiento.getHora09().get(posicion)));
                    break;
                case 10:
                    tv_DatosEspecieVerdonSerrano09.setText(String.valueOf(datosAvistamiento.getHora09().get(posicion)));
                    break;
            }
            posicion++;
        }

        posicion = 0;
        while (posicion < datosAvistamiento.getHora10().size()){
            switch (posicion){
                case 0:
                    tv_DatosEspecieCamachuelo10.setText(String.valueOf(datosAvistamiento.getHora10().get(posicion)));
                    break;
                case 1:
                    tv_DatosEspecieJilguero10.setText(String.valueOf(datosAvistamiento.getHora10().get(posicion)));
                    break;
                case 2:
                    tv_DatosEspecieLugano10.setText(String.valueOf(datosAvistamiento.getHora10().get(posicion)));
                    break;
                case 3:
                    tv_DatosEspeciePardilloComun10.setText(String.valueOf(datosAvistamiento.getHora10().get(posicion)));
                    break;
                case 4:
                    tv_DatosEspeciePicogordo10.setText(String.valueOf(datosAvistamiento.getHora10().get(posicion)));
                    break;
                case 5:
                    tv_DatosEspeciePinzonComun10.setText(String.valueOf(datosAvistamiento.getHora10().get(posicion)));
                    break;
                case 6:
                    tv_DatosEspeciePinzonReal10.setText(String.valueOf(datosAvistamiento.getHora10().get(posicion)));
                    break;
                case 7:
                    tv_DatosEspeciePiquituerto10.setText(String.valueOf(datosAvistamiento.getHora10().get(posicion)));
                    break;
                case 8:
                    tv_DatosEspecieVerdecillo10.setText(String.valueOf(datosAvistamiento.getHora10().get(posicion)));
                    break;
                case 9:
                    tv_DatosEspecieVerdonComun10.setText(String.valueOf(datosAvistamiento.getHora10().get(posicion)));
                    break;
                case 10:
                    tv_DatosEspecieVerdonSerrano10.setText(String.valueOf(datosAvistamiento.getHora10().get(posicion)));
                    break;
            }
            posicion++;
        }

        posicion = 0;
        while (posicion < datosAvistamiento.getHora11().size()){
            switch (posicion){
                case 0:
                    tv_DatosEspecieCamachuelo11.setText(String.valueOf(datosAvistamiento.getHora11().get(posicion)));
                    break;
                case 1:
                    tv_DatosEspecieJilguero11.setText(String.valueOf(datosAvistamiento.getHora11().get(posicion)));
                    break;
                case 2:
                    tv_DatosEspecieLugano11.setText(String.valueOf(datosAvistamiento.getHora11().get(posicion)));
                    break;
                case 3:
                    tv_DatosEspeciePardilloComun11.setText(String.valueOf(datosAvistamiento.getHora11().get(posicion)));
                    break;
                case 4:
                    tv_DatosEspeciePicogordo11.setText(String.valueOf(datosAvistamiento.getHora11().get(posicion)));
                    break;
                case 5:
                    tv_DatosEspeciePinzonComun11.setText(String.valueOf(datosAvistamiento.getHora11().get(posicion)));
                    break;
                case 6:
                    tv_DatosEspeciePinzonReal11.setText(String.valueOf(datosAvistamiento.getHora11().get(posicion)));
                    break;
                case 7:
                    tv_DatosEspeciePiquituerto11.setText(String.valueOf(datosAvistamiento.getHora11().get(posicion)));
                    break;
                case 8:
                    tv_DatosEspecieVerdecillo11.setText(String.valueOf(datosAvistamiento.getHora11().get(posicion)));
                    break;
                case 9:
                    tv_DatosEspecieVerdonComun11.setText(String.valueOf(datosAvistamiento.getHora11().get(posicion)));
                    break;
                case 10:
                    tv_DatosEspecieVerdonSerrano11.setText(String.valueOf(datosAvistamiento.getHora11().get(posicion)));
                    break;
            }
            posicion++;
        }

        posicion = 0;
        while (posicion < datosAvistamiento.getHora12().size()){
            switch (posicion){
                case 0:
                    tv_DatosEspecieCamachuelo12.setText(String.valueOf(datosAvistamiento.getHora12().get(posicion)));
                    break;
                case 1:
                    tv_DatosEspecieJilguero12.setText(String.valueOf(datosAvistamiento.getHora12().get(posicion)));
                    break;
                case 2:
                    tv_DatosEspecieLugano12.setText(String.valueOf(datosAvistamiento.getHora12().get(posicion)));
                    break;
                case 3:
                    tv_DatosEspeciePardilloComun12.setText(String.valueOf(datosAvistamiento.getHora12().get(posicion)));
                    break;
                case 4:
                    tv_DatosEspeciePicogordo12.setText(String.valueOf(datosAvistamiento.getHora12().get(posicion)));
                    break;
                case 5:
                    tv_DatosEspeciePinzonComun12.setText(String.valueOf(datosAvistamiento.getHora12().get(posicion)));
                    break;
                case 6:
                    tv_DatosEspeciePinzonReal12.setText(String.valueOf(datosAvistamiento.getHora12().get(posicion)));
                    break;
                case 7:
                    tv_DatosEspeciePiquituerto12.setText(String.valueOf(datosAvistamiento.getHora12().get(posicion)));
                    break;
                case 8:
                    tv_DatosEspecieVerdecillo12.setText(String.valueOf(datosAvistamiento.getHora12().get(posicion)));
                    break;
                case 9:
                    tv_DatosEspecieVerdonComun12.setText(String.valueOf(datosAvistamiento.getHora12().get(posicion)));
                    break;
                case 10:
                    tv_DatosEspecieVerdonSerrano12.setText(String.valueOf(datosAvistamiento.getHora12().get(posicion)));
                    break;
            }
            posicion++;
        }

        posicion = 0;
        while (posicion < datosAvistamiento.getHora13().size()){
            switch (posicion){
                case 0:
                    tv_DatosEspecieCamachuelo13.setText(String.valueOf(datosAvistamiento.getHora13().get(posicion)));
                    break;
                case 1:
                    tv_DatosEspecieJilguero13.setText(String.valueOf(datosAvistamiento.getHora13().get(posicion)));
                    break;
                case 2:
                    tv_DatosEspecieLugano13.setText(String.valueOf(datosAvistamiento.getHora13().get(posicion)));
                    break;
                case 3:
                    tv_DatosEspeciePardilloComun13.setText(String.valueOf(datosAvistamiento.getHora13().get(posicion)));
                    break;
                case 4:
                    tv_DatosEspeciePicogordo13.setText(String.valueOf(datosAvistamiento.getHora13().get(posicion)));
                    break;
                case 5:
                    tv_DatosEspeciePinzonComun13.setText(String.valueOf(datosAvistamiento.getHora13().get(posicion)));
                    break;
                case 6:
                    tv_DatosEspeciePinzonReal13.setText(String.valueOf(datosAvistamiento.getHora13().get(posicion)));
                    break;
                case 7:
                    tv_DatosEspeciePiquituerto13.setText(String.valueOf(datosAvistamiento.getHora13().get(posicion)));
                    break;
                case 8:
                    tv_DatosEspecieVerdecillo13.setText(String.valueOf(datosAvistamiento.getHora13().get(posicion)));
                    break;
                case 9:
                    tv_DatosEspecieVerdonComun13.setText(String.valueOf(datosAvistamiento.getHora13().get(posicion)));
                    break;
                case 10:
                    tv_DatosEspecieVerdonSerrano13.setText(String.valueOf(datosAvistamiento.getHora13().get(posicion)));
                    break;
            }
            posicion++;
        }

        posicion = 0;
        while (posicion < datosAvistamiento.getHora14().size()){
            switch (posicion){
                case 0:
                    tv_DatosEspecieCamachuelo14.setText(String.valueOf(datosAvistamiento.getHora14().get(posicion)));
                    break;
                case 1:
                    tv_DatosEspecieJilguero14.setText(String.valueOf(datosAvistamiento.getHora14().get(posicion)));
                    break;
                case 2:
                    tv_DatosEspecieLugano14.setText(String.valueOf(datosAvistamiento.getHora14().get(posicion)));
                    break;
                case 3:
                    tv_DatosEspeciePardilloComun14.setText(String.valueOf(datosAvistamiento.getHora14().get(posicion)));
                    break;
                case 4:
                    tv_DatosEspeciePicogordo14.setText(String.valueOf(datosAvistamiento.getHora14().get(posicion)));
                    break;
                case 5:
                    tv_DatosEspeciePinzonComun14.setText(String.valueOf(datosAvistamiento.getHora14().get(posicion)));
                    break;
                case 6:
                    tv_DatosEspeciePinzonReal14.setText(String.valueOf(datosAvistamiento.getHora14().get(posicion)));
                    break;
                case 7:
                    tv_DatosEspeciePiquituerto14.setText(String.valueOf(datosAvistamiento.getHora14().get(posicion)));
                    break;
                case 8:
                    tv_DatosEspecieVerdecillo14.setText(String.valueOf(datosAvistamiento.getHora14().get(posicion)));
                    break;
                case 9:
                    tv_DatosEspecieVerdonComun14.setText(String.valueOf(datosAvistamiento.getHora14().get(posicion)));
                    break;
                case 10:
                    tv_DatosEspecieVerdonSerrano14.setText(String.valueOf(datosAvistamiento.getHora14().get(posicion)));
                    break;
            }
            posicion++;
        }

    }

    private void iniciarComponentes() {
        //Datos Entorno
        iv_DatosCheckBoxEntorno = (ImageView) findViewById(R.id.iv_DatosCheckBoxEntorno);
        tv_DatosTemperaturaInicio = (TextView) findViewById(R.id.tv_DatosTemperaturaInicio);
        tv_DatosTemperaturaFin = (TextView) findViewById(R.id.tv_DatosTemperaturaFin);
        tv_DatosZonificacion = findViewById(R.id.tv_DatosZonificacion);
        tv_DatosDireccionViento = (TextView) findViewById(R.id.tv_DatosDireccionViento);
        tv_DatosViento = (TextView) findViewById(R.id.tv_DatosViento);
        tv_DatosNubes = (TextView) findViewById(R.id.tv_DatosNubes);
        tv_DatosLluvia = (TextView) findViewById(R.id.tv_DatosLluvia);
        tv_DatosPlantas = (TextView) findViewById(R.id.tv_DatosPlantas);

        //Metodos de captura
        iv_DatosCheckBoxCapturas = findViewById(R.id.iv_DatosCheckBoxCapturas);
        tv_DatosNumeroMallas = findViewById(R.id.tv_DatosNumeroMallas);
        tv_DatosLongitudRed = findViewById(R.id.tv_DatosLongitudRed);
        tv_DatosCoto = findViewById(R.id.tv_DatosCoto);
        tv_DatosControlAgentes = findViewById(R.id.tv_DatosControlAgentes);
        tv_DatosReclamosCamichuelo =  findViewById(R.id.tv_DatosReclamosCamichuelo);
        tv_DatosCimbelesCamichuelo = findViewById(R.id.tv_DatosCimbelesCamichuelo);
        tv_DatosCapturasCamichuelo =  findViewById(R.id.tv_DatosCapturasCamichuelo);
        tv_DatosReclamosJilguero = findViewById(R.id.tv_DatosReclamosJilguero);
        tv_DatosCimbelesJilguero = findViewById(R.id.tv_DatosCimbelesJilguero);
        tv_DatosCapturasJilguero = findViewById(R.id.tv_DatosCapturasJilguero);
        tv_DatosReclamosLugano = findViewById(R.id.tv_DatosReclamosLugano);
        tv_DatosCimbelesLugano = findViewById(R.id.tv_DatosCimbelesLugano);
        tv_DatosCapturasLugano = findViewById(R.id.tv_DatosCapturasLugano);
        tv_DatosReclamosPardilloComun = findViewById(R.id.tv_DatosReclamosPardilloComun);
        tv_DatosCimbelesPardilloComun = findViewById(R.id.tv_DatosCimbelesPardilloComun);
        tv_DatosCapturasPardilloComun = findViewById(R.id.tv_DatosCapturasPardilloComun);
        tv_DatosReclamosPicogordo =  findViewById(R.id.tv_DatosReclamosPicogordo);
        tv_DatosCimbelesPicogordo = findViewById(R.id.tv_DatosCimbelesPicogordo);
        tv_DatosCapturasPicogordo = findViewById(R.id.tv_DatosCapturasPicogordo);
        tv_DatosReclamosPinzonComun = findViewById(R.id.tv_DatosReclamosPinzonComun);
        tv_DatosCimbelesPinzonComun = findViewById(R.id.tv_DatosCimbelesPinzonComun);
        tv_DatosCapturasPinzonComun = findViewById(R.id.tv_DatosCapturasPinzonComun);
        tv_DatosReclamosPinzonReal = findViewById(R.id.tv_DatosReclamosPinzonReal);
        tv_DatosCimbelesPinzonReal = findViewById(R.id.tv_DatosCimbelesPinzonReal);
        tv_DatosCapturasPinzonReal = findViewById(R.id.tv_DatosCapturasPinzonReal);
        tv_DatosReclamosPiquituerto = findViewById(R.id.tv_DatosReclamosPiquituerto);
        tv_DatosCimbelesPiquituerto = findViewById(R.id.tv_DatosCimbelesPiquituerto);
        tv_DatosCapturasPiquituerto = findViewById(R.id.tv_DatosCapturasPiquituerto);
        tv_DatosReclamosVerdecillo = findViewById(R.id.tv_DatosReclamosVerdecillo);
        tv_DatosCimbelesVerdecillo = findViewById(R.id.tv_DatosCimbelesVerdecillo);
        tv_DatosCapturasVerdecillo = findViewById(R.id.tv_DatosCapturasVerdecillo);
        tv_DatosReclamosVerderonComun = findViewById(R.id.tv_DatosReclamosVerderonComun);
        tv_DatosCimbelesVerderonComun = findViewById(R.id.tv_DatosCimbelesVerderonComun);
        tv_DatosCapturasVerderonComun = findViewById(R.id.tv_DatosCapturasVerderonComun);
        tv_DatosReclamosVerderonSerrano = findViewById(R.id.tv_DatosReclamosVerderonSerrano);
        tv_DatosCimbelesVerderonSerrano = findViewById(R.id.tv_DatosCimbelesVerderonSerrano);
        tv_DatosCapturasVerderonSerrano = findViewById(R.id.tv_DatosCapturasVerderonSerrano);
        tv_DatosObservaciones = findViewById(R.id.tv_DatosObservaciones);

        //Datos Avistamiento
        iv_DatosCheckBoxAvistamiento = findViewById(R.id.iv_DatosCheckBoxAvistamiento);
        tv_DatosHoraInicio = findViewById(R.id.tv_DatosHoraInicio);
        tv_DatosHoraFin = findViewById(R.id.tv_DatosHoraFin);
        //Hora 08:00
        tv_DatosEspecieCamachuelo08 = findViewById(R.id.tv_DatosEspecieCamachuelo08);
        tv_DatosEspecieJilguero08 = findViewById(R.id.tv_DatosEspecieJilguero08);
        tv_DatosEspecieLugano08 = findViewById(R.id.tv_DatosEspecieLugano08);
        tv_DatosEspeciePardilloComun08 = findViewById(R.id.tv_DatosEspeciePardilloComun08);
        tv_DatosEspeciePicogordo08 = findViewById(R.id.tv_DatosEspeciePicogordo08);
        tv_DatosEspeciePinzonComun08 = findViewById(R.id.tv_DatosEspeciePinzonComun08);
        tv_DatosEspeciePinzonReal08 = findViewById(R.id.tv_DatosEspeciePinzonReal08);
        tv_DatosEspeciePiquituerto08 =  findViewById(R.id.tv_DatosEspeciePiquituerto08);
        tv_DatosEspecieVerdecillo08 = findViewById(R.id.tv_DatosEspecieVerdecillo08);
        tv_DatosEspecieVerdonComun08 = findViewById(R.id.tv_DatosEspecieVerdonComun08);
        tv_DatosEspecieVerdonSerrano08 = findViewById(R.id.tv_DatosEspecieVerdonSerrano08);
        //Hora 09:00
        tv_DatosEspecieCamachuelo09 = findViewById(R.id.tv_DatosEspecieCamachuelo09);
        tv_DatosEspecieJilguero09 = findViewById(R.id.tv_DatosEspecieJilguero09);
        tv_DatosEspecieLugano09 = findViewById(R.id.tv_DatosEspecieLugano09);
        tv_DatosEspeciePardilloComun09 = findViewById(R.id.tv_DatosEspeciePardilloComun09);
        tv_DatosEspeciePicogordo09 = findViewById(R.id.tv_DatosEspeciePicogordo09);
        tv_DatosEspeciePinzonComun09 = findViewById(R.id.tv_DatosEspeciePinzonComun09);
        tv_DatosEspeciePinzonReal09 = findViewById(R.id.tv_DatosEspeciePinzonReal09);
        tv_DatosEspeciePiquituerto09 = findViewById(R.id.tv_DatosEspeciePiquituerto09);
        tv_DatosEspecieVerdecillo09 = findViewById(R.id.tv_DatosEspecieVerdecillo09);
        tv_DatosEspecieVerdonComun09 = findViewById(R.id.tv_DatosEspecieVerdonComun09);
        tv_DatosEspecieVerdonSerrano09 = findViewById(R.id.tv_DatosEspecieVerdonSerrano09);
        //Hora 10:00
        tv_DatosEspecieCamachuelo10 = findViewById(R.id.tv_DatosEspecieCamachuelo10);
        tv_DatosEspecieJilguero10 = findViewById(R.id.tv_DatosEspecieJilguero10);
        tv_DatosEspecieLugano10 = findViewById(R.id.tv_DatosEspecieLugano10);
        tv_DatosEspeciePardilloComun10 = findViewById(R.id.tv_DatosEspeciePardilloComun10);
        tv_DatosEspeciePicogordo10 = findViewById(R.id.tv_DatosEspeciePicogordo10);
        tv_DatosEspeciePinzonComun10 = findViewById(R.id.tv_DatosEspeciePinzonComun10);
        tv_DatosEspeciePinzonReal10 = findViewById(R.id.tv_DatosEspeciePinzonReal10);
        tv_DatosEspeciePiquituerto10 = findViewById(R.id.tv_DatosEspeciePiquituerto10);
        tv_DatosEspecieVerdecillo10 = findViewById(R.id.tv_DatosEspecieVerdecillo10);
        tv_DatosEspecieVerdonComun10 = findViewById(R.id.tv_DatosEspecieVerdonComun10);
        tv_DatosEspecieVerdonSerrano10 = findViewById(R.id.tv_DatosEspecieVerdonSerrano10);
        //Hora 11:00
        tv_DatosEspecieCamachuelo11 = findViewById(R.id.tv_DatosEspecieCamachuelo11);
        tv_DatosEspecieJilguero11 = findViewById(R.id.tv_DatosEspecieJilguero11);
        tv_DatosEspecieLugano11 = findViewById(R.id.tv_DatosEspecieLugano11);
        tv_DatosEspeciePardilloComun11 = findViewById(R.id.tv_DatosEspeciePardilloComun11);
        tv_DatosEspeciePicogordo11 = findViewById(R.id.tv_DatosEspeciePicogordo11);
        tv_DatosEspeciePinzonComun11 = findViewById(R.id.tv_DatosEspeciePinzonComun11);
        tv_DatosEspeciePinzonReal11 = findViewById(R.id.tv_DatosEspeciePinzonReal11);
        tv_DatosEspeciePiquituerto11 = findViewById(R.id.tv_DatosEspeciePiquituerto11);
        tv_DatosEspecieVerdecillo11 = findViewById(R.id.tv_DatosEspecieVerdecillo11);
        tv_DatosEspecieVerdonComun11 = findViewById(R.id.tv_DatosEspecieVerdonComun11);
        tv_DatosEspecieVerdonSerrano11 = findViewById(R.id.tv_DatosEspecieVerdonSerrano11);
        //Hora 12:00
        tv_DatosEspecieCamachuelo12 = findViewById(R.id.tv_DatosEspecieCamachuelo12);
        tv_DatosEspecieJilguero12 = findViewById(R.id.tv_DatosEspecieJilguero12);
        tv_DatosEspecieLugano12 = findViewById(R.id.tv_DatosEspecieLugano12);
        tv_DatosEspeciePardilloComun12 = findViewById(R.id.tv_DatosEspeciePardilloComun12);
        tv_DatosEspeciePicogordo12 = findViewById(R.id.tv_DatosEspeciePicogordo12);
        tv_DatosEspeciePinzonComun12 = findViewById(R.id.tv_DatosEspeciePinzonComun12);
        tv_DatosEspeciePinzonReal12 =  findViewById(R.id.tv_DatosEspeciePinzonReal12);
        tv_DatosEspeciePiquituerto12 = findViewById(R.id.tv_DatosEspeciePiquituerto12);
        tv_DatosEspecieVerdecillo12 = findViewById(R.id.tv_DatosEspecieVerdecillo12);
        tv_DatosEspecieVerdonComun12 = findViewById(R.id.tv_DatosEspecieVerdonComun12);
        tv_DatosEspecieVerdonSerrano12 = findViewById(R.id.tv_DatosEspecieVerdonSerrano12);
        //Hora 13:00
        tv_DatosEspecieCamachuelo13 = findViewById(R.id.tv_DatosEspecieCamachuelo13);
        tv_DatosEspecieJilguero13 = findViewById(R.id.tv_DatosEspecieJilguero13);
        tv_DatosEspecieLugano13 = findViewById(R.id.tv_DatosEspecieLugano13);
        tv_DatosEspeciePardilloComun13 = findViewById(R.id.tv_DatosEspeciePardilloComun13);
        tv_DatosEspeciePicogordo13 = findViewById(R.id.tv_DatosEspeciePicogordo13);
        tv_DatosEspeciePinzonComun13 = findViewById(R.id.tv_DatosEspeciePinzonComun13);
        tv_DatosEspeciePinzonReal13 = findViewById(R.id.tv_DatosEspeciePinzonReal13);
        tv_DatosEspeciePiquituerto13 = findViewById(R.id.tv_DatosEspeciePiquituerto13);
        tv_DatosEspecieVerdecillo13 = findViewById(R.id.tv_DatosEspecieVerdecillo13);
        tv_DatosEspecieVerdonComun13 = findViewById(R.id.tv_DatosEspecieVerdonComun13);
        tv_DatosEspecieVerdonSerrano13 = findViewById(R.id.tv_DatosEspecieVerdonSerrano13);
        //Hora 14
        tv_DatosEspecieCamachuelo14 = findViewById(R.id.tv_DatosEspecieCamachuelo14);
        tv_DatosEspecieJilguero14 = findViewById(R.id.tv_DatosEspecieJilguero14);
        tv_DatosEspecieLugano14 = findViewById(R.id.tv_DatosEspecieLugano14);
        tv_DatosEspeciePardilloComun14 = findViewById(R.id.tv_DatosEspeciePardilloComun14);
        tv_DatosEspeciePicogordo14 = findViewById(R.id.tv_DatosEspeciePicogordo14);
        tv_DatosEspeciePinzonComun14 = findViewById(R.id.tv_DatosEspeciePinzonComun14);
        tv_DatosEspeciePinzonReal14 = findViewById(R.id.tv_DatosEspeciePinzonReal14);
        tv_DatosEspeciePiquituerto14 = findViewById(R.id.tv_DatosEspeciePiquituerto14);
        tv_DatosEspecieVerdecillo14 = findViewById(R.id.tv_DatosEspecieVerdecillo14);
        tv_DatosEspecieVerdonComun14 = findViewById(R.id.tv_DatosEspecieVerdonComun14);
        tv_DatosEspecieVerdonSerrano14 = findViewById(R.id.tv_DatosEspecieVerdonSerrano14);

        //Buttons
        btn_VolverDatos = findViewById(R.id.btn_VolverMiEnvio);
    }

    private void iniciarOnClickListener() {
        btn_VolverDatos.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if (v == btn_VolverDatos){
            Intent activity = new Intent(this,Pantalla_Menu_Metodos_Y_Captura.class);
            guardarParametros(activity);

            activity.putExtra("FECHA",fecha);
            activity.putExtra("LATITUD", latitud);
            activity.putExtra("LONGITUD", longitud);

            startActivity(activity);
            finish();
        }
    }

    private void guardarParametros(Intent actividadDestino) {

        System.out.println("____________________________________________________");
        System.out.println("EMAIL                  => " + email);
        System.out.println("DNI                    => " + DNI);
        System.out.println("____________________________________________________");
        System.out.println("ESTADO ENTORNO         => " + entornoCompletado);
        System.out.println("DATOS ENTORNO          => " + datosEntorno);
        System.out.println("ESTADO METODOS CAPTURA => " + mCapturasCompletado);
        System.out.println("METODOS CAPTURA        => " + metodosCaptura);
        System.out.println("ESTADO AVISTAMIENTO    => " + avistamientoCompletado);
        System.out.println("DATOS AVISTAMIENTO     => " + datosAvistamiento);
        System.out.println("____________________________________________________");

        actividadDestino.putExtra("EMAIL",email);
        actividadDestino.putExtra("DNI",DNI);
        actividadDestino.putExtra("ENVIO_COMPLETADO",envioCompletado);
        actividadDestino.putExtra("DATOS_AVISTAMIENTO", (Serializable) datosAvistamiento);
        actividadDestino.putExtra("DATOS_ENTORNO", (Serializable) datosEntorno);
        actividadDestino.putExtra("DATOS_CAPTURA", (Serializable) metodosCaptura);
        actividadDestino.putExtra("ENTORNO_COMPLETADO", entornoCompletado);
        actividadDestino.putExtra("MCAPTURAS_COMPLETADO", mCapturasCompletado);
        actividadDestino.putExtra("AVISTAMIENTO_COMPLETADO", avistamientoCompletado);

    }

    private void recuperarDatosRecibidos(Bundle datos) {
        email = datos.getString("EMAIL");
        DNI = datos.getString("DNI");
        envioCompletado = datos.getBoolean("ENVIO_COMPLETADO");
        mCapturasCompletado = datos.getBoolean("MCAPTURAS_COMPLETADO");
        avistamientoCompletado = datos.getBoolean("AVISTAMIENTO_COMPLETADO");
        entornoCompletado = datos.getBoolean("ENTORNO_COMPLETADO");
        metodosCaptura = (MetodosCaptura) datos.getSerializable("DATOS_CAPTURA");
        datosAvistamiento = (DatosAvistamiento) datos.getSerializable("DATOS_AVISTAMIENTO");
        datosEntorno = (DatosEntorno) datos.getSerializable("DATOS_ENTORNO");
    }

    private void imprimirDatosRecibidos() {
        System.out.println("____________________________________________________");
        System.out.println("EMAIL                  => " + email);
        System.out.println("DNI                    => " + DNI);
        System.out.println("____________________________________________________");
        System.out.println("ESTADO ENTORNO         => " + entornoCompletado);
        System.out.println("DATOS ENTORNO          => " + datosEntorno);
        System.out.println("ESTADO METODOS CAPTURA => " + mCapturasCompletado);
        System.out.println("METODOS CAPTURA        => " + metodosCaptura);
        System.out.println("ESTADO AVISTAMIENTO    => " + avistamientoCompletado);
        System.out.println("DATOS AVISTAMIENTO     => " + datosAvistamiento);
        System.out.println("____________________________________________________");
    }
}
