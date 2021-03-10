package com.sefricam.sefricam3;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class Pantalla_Datos_Avistamiento extends Activity implements AdapterView.OnItemSelectedListener, View.OnClickListener{

    private Spinner sp_HoraInicio, sp_HoraFin;
    private Button btn_Guardar, btn_Volver;
    private EditText etn_Camachuelo08,etn_Camachuelo09,etn_Camachuelo10,etn_Camachuelo11,etn_Camachuelo12,etn_Camachuelo13,etn_Camachuelo14;
    private EditText etn_Jilguero08,etn_Jilguero09,etn_Jilguero10,etn_Jilguero11,etn_Jilguero12,etn_Jilguero13,etn_Jilguero14;
    private EditText etn_Lugano08,etn_Lugano09,etn_Lugano10,etn_Lugano11,etn_Lugano12,etn_Lugano13,etn_Lugano14;
    private EditText etn_PardilloComun08,etn_PardilloComun09,etn_PardilloComun10,etn_PardilloComun11,etn_PardilloComun12,etn_PardilloComun13,etn_PardilloComun14;
    private EditText etn_Picogordo08,etn_Picogordo09,etn_Picogordo10,etn_Picogordo11,etn_Picogordo12,etn_Picogordo13,etn_Picogordo14;
    private EditText etn_PinzonComun08,etn_PinzonComun09,etn_PinzonComun10, etn_PinzonComun11,etn_PinzonComun12,etn_PinzonComun13,etn_PinzonComun14;
    private EditText etn_PinzonReal08, etn_PinzonReal09, etn_PinzonReal10,etn_PinzonReal11,etn_PinzonReal12,etn_PinzonReal13,etn_PinzonReal14;
    private EditText etn_Piquituerto08,etn_Piquituerto09,etn_Piquituerto10,etn_Piquituerto11,etn_Piquituerto12,etn_Piquituerto13,etn_Piquituerto14;
    private EditText etn_Verdecillo08,etn_Verdecillo09,etn_Verdecillo10,etn_Verdecillo11,etn_Verdecillo12,etn_Verdecillo13,etn_Verdecillo14;
    private EditText etn_VerdonComun08,etn_VerdonComun09,etn_VerdonComun10,etn_VerdonComun11,etn_VerdonComun12,etn_VerdonComun13,etn_VerdonComun14;
    private EditText etn_VerdonSerrano08,etn_VerdonSerrano09,etn_VerdonSerrano10,etn_VerdonSerrano11,etn_VerdonSerrano12,etn_VerdonSerrano13,etn_VerdonSerrano14;

    private ArrayList<Integer> hora08 = new ArrayList<>();
    private ArrayList<Integer> hora09 = new ArrayList<>();
    private ArrayList<Integer> hora10 = new ArrayList<>();
    private ArrayList<Integer> hora11 = new ArrayList<>();
    private ArrayList<Integer> hora12 = new ArrayList<>();
    private ArrayList<Integer> hora13 = new ArrayList<>();
    private ArrayList<Integer> hora14 = new ArrayList<>();

    //Parametros
    private boolean envioCompletado;
    private MetodosCaptura metodosCaptura;
    private DatosAvistamiento datosAvistamiento;
    private DatosEntorno datosEntorno;
    private Limites limites;
    private boolean mCapturasCompletado,avistamientoCompletado,entornoCompletado;
    private String email;
    private String DNI;
    private String fecha, latitud, longitud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_datos_avistamiento);

        Bundle datos = this.getIntent().getExtras();
        if (datos != null) {
            recuperarDatosRecibidos(datos);

            System.out.println("Datos Recibidos en Datos Avistamientos");
            imprimirDatosRecibidos();
        }
        iniciarFindView();
        iniciarSpinners();
        iniciarOnClickListeners();
        sp_HoraFin.setEnabled(false);
        sp_HoraFin.setBackgroundColor(Color.LTGRAY);
        if (avistamientoCompletado){
            cargarDatos();
        }
    }

    private void cargarDatos() {

        switch (datosAvistamiento.getHoraInicio()){
            case "07:00":
                sp_HoraInicio.setSelection(1);
                break;
            case "08:00":
                sp_HoraInicio.setSelection(2);
                break;
            case "09:00":
                sp_HoraInicio.setSelection(3);
                break;
            case "10:00":
                sp_HoraInicio.setSelection(4);
                break;
            case "11:00":
                sp_HoraInicio.setSelection(5);
                break;
            case "12:00":
                sp_HoraInicio.setSelection(6);
                break;
            case "13:00":
                sp_HoraInicio.setSelection(7);
                break;
        }
        switch (datosAvistamiento.getHoraFin()){
            case "08:00":
                sp_HoraFin.setSelection(1);
                break;
            case "09:00":
                sp_HoraFin.setSelection(2);
                break;
            case "10:00":
                sp_HoraFin.setSelection(3);
                break;
            case "11:00":
                sp_HoraFin.setSelection(4);
                break;
            case "12:00":
                sp_HoraFin.setSelection(5);
                break;
            case "13:00":
                sp_HoraFin.setSelection(6);
                break;
            case "14:00":
                sp_HoraFin.setSelection(7);
                break;
        }

        //Camichuelo
        etn_Camachuelo08.setText(String.valueOf(datosAvistamiento.getHora08().get(0)));
        etn_Camachuelo09.setText(String.valueOf(datosAvistamiento.getHora09().get(0)));
        etn_Camachuelo10.setText(String.valueOf(datosAvistamiento.getHora10().get(0)));
        etn_Camachuelo11.setText(String.valueOf(datosAvistamiento.getHora11().get(0)));
        etn_Camachuelo12.setText(String.valueOf(datosAvistamiento.getHora12().get(0)));
        etn_Camachuelo13.setText(String.valueOf(datosAvistamiento.getHora13().get(0)));
        etn_Camachuelo14.setText(String.valueOf(datosAvistamiento.getHora14().get(0)));

        //Jilguero
        etn_Jilguero08.setText(String.valueOf(datosAvistamiento.getHora08().get(1)));
        etn_Jilguero09.setText(String.valueOf(datosAvistamiento.getHora09().get(1)));
        etn_Jilguero10.setText(String.valueOf(datosAvistamiento.getHora10().get(1)));
        etn_Jilguero11.setText(String.valueOf(datosAvistamiento.getHora11().get(1)));
        etn_Jilguero12.setText(String.valueOf(datosAvistamiento.getHora12().get(1)));
        etn_Jilguero13.setText(String.valueOf(datosAvistamiento.getHora13().get(1)));
        etn_Jilguero14.setText(String.valueOf(datosAvistamiento.getHora14().get(1)));

        //Lugano
        etn_Lugano08.setText(String.valueOf(datosAvistamiento.getHora08().get(2)));
        etn_Lugano09.setText(String.valueOf(datosAvistamiento.getHora09().get(2)));
        etn_Lugano10.setText(String.valueOf(datosAvistamiento.getHora10().get(2)));
        etn_Lugano11.setText(String.valueOf(datosAvistamiento.getHora11().get(2)));
        etn_Lugano12.setText(String.valueOf(datosAvistamiento.getHora12().get(2)));
        etn_Lugano13.setText(String.valueOf(datosAvistamiento.getHora13().get(2)));
        etn_Lugano14.setText(String.valueOf(datosAvistamiento.getHora14().get(2)));

        //Pardillo Comun
        etn_PardilloComun08.setText(String.valueOf(datosAvistamiento.getHora08().get(3)));
        etn_PardilloComun09.setText(String.valueOf(datosAvistamiento.getHora09().get(3)));
        etn_PardilloComun10.setText(String.valueOf(datosAvistamiento.getHora10().get(3)));
        etn_PardilloComun11.setText(String.valueOf(datosAvistamiento.getHora11().get(3)));
        etn_PardilloComun12.setText(String.valueOf(datosAvistamiento.getHora12().get(3)));
        etn_PardilloComun13.setText(String.valueOf(datosAvistamiento.getHora13().get(3)));
        etn_PardilloComun14.setText(String.valueOf(datosAvistamiento.getHora14().get(3)));

        //Picogordo
        etn_Picogordo08.setText(String.valueOf(datosAvistamiento.getHora08().get(4)));
        etn_Picogordo09.setText(String.valueOf(datosAvistamiento.getHora09().get(4)));
        etn_Picogordo10.setText(String.valueOf(datosAvistamiento.getHora10().get(4)));
        etn_Picogordo10.setText(String.valueOf(datosAvistamiento.getHora11().get(4)));
        etn_Picogordo10.setText(String.valueOf(datosAvistamiento.getHora12().get(4)));
        etn_Picogordo10.setText(String.valueOf(datosAvistamiento.getHora13().get(4)));
        etn_Picogordo10.setText(String.valueOf(datosAvistamiento.getHora14().get(4)));

        //Pinzon Comun
        etn_PinzonComun08.setText(String.valueOf(datosAvistamiento.getHora08().get(5)));
        etn_PinzonComun09.setText(String.valueOf(datosAvistamiento.getHora09().get(5)));
        etn_PinzonComun10.setText(String.valueOf(datosAvistamiento.getHora10().get(5)));
        etn_PinzonComun11.setText(String.valueOf(datosAvistamiento.getHora11().get(5)));
        etn_PinzonComun12.setText(String.valueOf(datosAvistamiento.getHora12().get(5)));
        etn_PinzonComun13.setText(String.valueOf(datosAvistamiento.getHora13().get(5)));
        etn_PinzonComun14.setText(String.valueOf(datosAvistamiento.getHora14().get(5)));

        //Pinzon Real
        etn_PinzonReal08.setText(String.valueOf(datosAvistamiento.getHora08().get(6)));
        etn_PinzonReal09.setText(String.valueOf(datosAvistamiento.getHora09().get(6)));
        etn_PinzonReal10.setText(String.valueOf(datosAvistamiento.getHora10().get(6)));
        etn_PinzonReal11.setText(String.valueOf(datosAvistamiento.getHora11().get(6)));
        etn_PinzonReal12.setText(String.valueOf(datosAvistamiento.getHora12().get(6)));
        etn_PinzonReal13.setText(String.valueOf(datosAvistamiento.getHora13().get(6)));
        etn_PinzonReal14.setText(String.valueOf(datosAvistamiento.getHora14().get(6)));

        //Piquituerto
        etn_Piquituerto08.setText(String.valueOf(datosAvistamiento.getHora08().get(7)));
        etn_Piquituerto09.setText(String.valueOf(datosAvistamiento.getHora09().get(7)));
        etn_Piquituerto10.setText(String.valueOf(datosAvistamiento.getHora10().get(7)));
        etn_Piquituerto11.setText(String.valueOf(datosAvistamiento.getHora11().get(7)));
        etn_Piquituerto12.setText(String.valueOf(datosAvistamiento.getHora12().get(7)));
        etn_Piquituerto13.setText(String.valueOf(datosAvistamiento.getHora13().get(7)));
        etn_Piquituerto14.setText(String.valueOf(datosAvistamiento.getHora14().get(7)));

        //Verdecillo
        etn_Verdecillo08.setText(String.valueOf(datosAvistamiento.getHora08().get(8)));
        etn_Verdecillo09.setText(String.valueOf(datosAvistamiento.getHora09().get(8)));
        etn_Verdecillo10.setText(String.valueOf(datosAvistamiento.getHora10().get(8)));
        etn_Verdecillo11.setText(String.valueOf(datosAvistamiento.getHora11().get(8)));
        etn_Verdecillo12.setText(String.valueOf(datosAvistamiento.getHora12().get(8)));
        etn_Verdecillo13.setText(String.valueOf(datosAvistamiento.getHora13().get(8)));
        etn_Verdecillo14.setText(String.valueOf(datosAvistamiento.getHora14().get(8)));

        //Verderon Comun
        etn_VerdonComun08.setText(String.valueOf(datosAvistamiento.getHora08().get(9)));
        etn_VerdonComun09.setText(String.valueOf(datosAvistamiento.getHora09().get(9)));
        etn_VerdonComun10.setText(String.valueOf(datosAvistamiento.getHora10().get(9)));
        etn_VerdonComun11.setText(String.valueOf(datosAvistamiento.getHora11().get(9)));
        etn_VerdonComun12.setText(String.valueOf(datosAvistamiento.getHora12().get(9)));
        etn_VerdonComun13.setText(String.valueOf(datosAvistamiento.getHora13().get(9)));
        etn_VerdonComun14.setText(String.valueOf(datosAvistamiento.getHora14().get(9)));

        //Verderon Serrano
        etn_VerdonSerrano08.setText(String.valueOf(datosAvistamiento.getHora08().get(10)));
        etn_VerdonSerrano09.setText(String.valueOf(datosAvistamiento.getHora09().get(10)));
        etn_VerdonSerrano10.setText(String.valueOf(datosAvistamiento.getHora10().get(10)));
        etn_VerdonSerrano11.setText(String.valueOf(datosAvistamiento.getHora11().get(10)));
        etn_VerdonSerrano12.setText(String.valueOf(datosAvistamiento.getHora12().get(10)));
        etn_VerdonSerrano13.setText(String.valueOf(datosAvistamiento.getHora13().get(10)));
        etn_VerdonSerrano14.setText(String.valueOf(datosAvistamiento.getHora14().get(10)));
    }

    private void iniciarOnClickListeners() {
        btn_Guardar.setOnClickListener(this);
        btn_Volver.setOnClickListener(this);
    }


    private void iniciarFindView() {
        btn_Guardar = (Button) findViewById(R.id.btn_GuardarAvistamientos);
        btn_Volver = (Button) findViewById(R.id.btn_VolverAvistamientos);
        sp_HoraFin = (Spinner) findViewById(R.id.sp_HoraFin);
        sp_HoraInicio = (Spinner) findViewById(R.id.sp_HoraInicio);

        //Camachuelo
        etn_Camachuelo08 = findViewById(R.id.etn_Camachuelo08);
        etn_Camachuelo09 = findViewById(R.id.etn_Camachuelo09);
        etn_Camachuelo10 = findViewById(R.id.etn_Camachuelo10);
        etn_Camachuelo11 = findViewById(R.id.etn_Camachuelo11);
        etn_Camachuelo12 = findViewById(R.id.etn_Camachuelo12);
        etn_Camachuelo13 = findViewById(R.id.etn_Camachuelo13);
        etn_Camachuelo14 = findViewById(R.id.etn_Camachuelo14);
        //Jilguero
        etn_Jilguero08 = findViewById(R.id.etn_Jilguero08);
        etn_Jilguero09 = findViewById(R.id.etn_Jilguero09);
        etn_Jilguero10 = findViewById(R.id.etn_Jilguero10);
        etn_Jilguero11 = findViewById(R.id.etn_Jilguero11);
        etn_Jilguero12 = findViewById(R.id.etn_Jilguero12);
        etn_Jilguero13 = findViewById(R.id.etn_Jilguero13);
        etn_Jilguero14 = findViewById(R.id.etn_Jilguero14);
        //Lugano
        etn_Lugano08 = findViewById(R.id.etn_Lugano08);
        etn_Lugano09 = findViewById(R.id.etn_Lugano09);
        etn_Lugano10 = findViewById(R.id.etn_Lugano10);
        etn_Lugano11 = findViewById(R.id.etn_Lugano11);
        etn_Lugano12 = findViewById(R.id.etn_Lugano12);
        etn_Lugano13 = findViewById(R.id.etn_Lugano13);
        etn_Lugano14 = findViewById(R.id.etn_Lugano14);
        //Pardillo Común
        etn_PardilloComun08 = findViewById(R.id.etn_PardilloComun08);
        etn_PardilloComun09 = findViewById(R.id.etn_PardilloComun09);
        etn_PardilloComun10 = findViewById(R.id.etn_PardilloComun10);
        etn_PardilloComun11 = findViewById(R.id.etn_PardilloComun11);
        etn_PardilloComun12 = findViewById(R.id.etn_PardilloComun12);
        etn_PardilloComun13 = findViewById(R.id.etn_PardilloComun13);
        etn_PardilloComun14 = findViewById(R.id.etn_PardilloComun14);
        //Picogordo
        etn_Picogordo08 = findViewById(R.id.etn_Picogordo08);
        etn_Picogordo09 = findViewById(R.id.etn_Picogordo09);
        etn_Picogordo10 = findViewById(R.id.etn_Picogordo10);
        etn_Picogordo11 = findViewById(R.id.etn_Picogordo11);
        etn_Picogordo12 = findViewById(R.id.etn_Picogordo12);
        etn_Picogordo13 = findViewById(R.id.etn_Picogordo13);
        etn_Picogordo14 = findViewById(R.id.etn_Picogordo14);
        //Pinzon Comun
        etn_PinzonComun08 = findViewById(R.id.etn_PinzonComun08);
        etn_PinzonComun09 = findViewById(R.id.etn_PinzonComun09);
        etn_PinzonComun10 = findViewById(R.id.etn_PinzonComun10);
        etn_PinzonComun11 = findViewById(R.id.etn_PinzonComun11);
        etn_PinzonComun12 = findViewById(R.id.etn_PinzonComun12);
        etn_PinzonComun13 = findViewById(R.id.etn_PinzonComun13);
        etn_PinzonComun14 = findViewById(R.id.etn_PinzonComun14);
        //Pinzon Real
        etn_PinzonReal08 = findViewById(R.id.etn_PinzonReal08);
        etn_PinzonReal09 = findViewById(R.id.etn_PinzonReal09);
        etn_PinzonReal10 = findViewById(R.id.etn_PinzonReal10);
        etn_PinzonReal11 = findViewById(R.id.etn_PinzonReal11);
        etn_PinzonReal12 = findViewById(R.id.etn_PinzonReal12);
        etn_PinzonReal13 = findViewById(R.id.etn_PinzonReal13);
        etn_PinzonReal14 = findViewById(R.id.etn_PinzonReal14);
        //Piquituerto
        etn_Piquituerto08 = findViewById(R.id.etn_Piquituerto08);
        etn_Piquituerto09 = findViewById(R.id.etn_Piquituerto09);
        etn_Piquituerto10 = findViewById(R.id.etn_Piquituerto10);
        etn_Piquituerto11 = findViewById(R.id.etn_Piquituerto11);
        etn_Piquituerto12 = findViewById(R.id.etn_Piquituerto12);
        etn_Piquituerto13 = findViewById(R.id.etn_Piquituerto13);
        etn_Piquituerto14 = findViewById(R.id.etn_Piquituerto14);
        //Verdecillo
        etn_Verdecillo08 = findViewById(R.id.etn_Verdecillo08);
        etn_Verdecillo09 = findViewById(R.id.etn_Verdecillo09);
        etn_Verdecillo10 = findViewById(R.id.etn_Verdecillo10);
        etn_Verdecillo11 = findViewById(R.id.etn_Verdecillo11);
        etn_Verdecillo12 = findViewById(R.id.etn_Verdecillo12);
        etn_Verdecillo13 = findViewById(R.id.etn_Verdecillo13);
        etn_Verdecillo14 = findViewById(R.id.etn_Verdecillo14);
        //Verdon Comun
        etn_VerdonComun08 = findViewById(R.id.etn_VerdonComun08);
        etn_VerdonComun09 = findViewById(R.id.etn_VerdonComun09);
        etn_VerdonComun10 = findViewById(R.id.etn_VerdonComun10);
        etn_VerdonComun11 = findViewById(R.id.etn_VerdonComun11);
        etn_VerdonComun12 = findViewById(R.id.etn_VerdonComun12);
        etn_VerdonComun13 = findViewById(R.id.etn_VerdonComun13);
        etn_VerdonComun14 = findViewById(R.id.etn_VerdonComun14);
        //Verdon Serrano
        etn_VerdonSerrano08 = findViewById(R.id.etn_VerdonSerrano08);
        etn_VerdonSerrano09 = findViewById(R.id.etn_VerdonSerrano09);
        etn_VerdonSerrano10 = findViewById(R.id.etn_VerdonSerrano10);
        etn_VerdonSerrano11 = findViewById(R.id.etn_VerdonSerrano11);
        etn_VerdonSerrano12 = findViewById(R.id.etn_VerdonSerrano12);
        etn_VerdonSerrano13 = findViewById(R.id.etn_VerdonSerrano13);
        etn_VerdonSerrano14 = findViewById(R.id.etn_VerdonSerrano14);
    }

    private void iniciarSpinners() {
        String [] franjasHorariasInicio = {"Seleccione una hora","07:00","08:00", "09:00", "10:00","11:00","12:00","13:00"};
        String [] franjasHorariasFin = {"Seleccione una hora","08:00", "09:00", "10:00","11:00","12:00","13:00","14:00"};
        ArrayAdapter<String> adapterFranjasHorariasIncio = new ArrayAdapter<String>(this, R.layout.spinner,franjasHorariasInicio);
        ArrayAdapter<String> adapterFranjasHorariasFin = new ArrayAdapter<String>(this, R.layout.spinner,franjasHorariasFin);
        sp_HoraInicio.setAdapter(adapterFranjasHorariasIncio);
        sp_HoraInicio.setOnItemSelectedListener(this);
        sp_HoraFin.setAdapter(adapterFranjasHorariasFin);
        sp_HoraFin.setOnItemSelectedListener(this);
    }


    /**
     * <p>Callback method to be invoked when an item in this view has been
     * selected. This callback is invoked only when the newly selected
     * position is different from the previously selected position or if
     * there was no selected item.</p>
     * <p>
     * Implementers can call getItemAtPosition(position) if they need to access the
     * data associated with the selected item.
     *
     * @param parent   The AdapterView where the selection happened
     * @param view     The view within the AdapterView that was clicked
     * @param position The position of the view in the adapter
     * @param id       The row id of the item that is selected
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        System.out.println("ENTRO EN ITEM SELECTED");
        if (parent.getId()==R.id.sp_HoraInicio){
            System.out.println("ENTRO EN LA VISTA HORA INICIO");
            reiniciarTodo(); //Una vez que se toca un item se reinician a noneditable todas las variables, luego se habilitan. Tambien se ha de forzar al Spinner 2 a que se ponga a null
            if (parent.getSelectedItemPosition()==0) return;
            if (parent.getSelectedItemPosition()==1) {
                modificarFranja08(true);
                modificarFranja09(true);
                modificarFranja10(true);
                modificarFranja11(true);
                modificarFranja12(true);
                modificarFranja13(true);
                modificarFranja14(true);
            }
            if (parent.getSelectedItemPosition()==2) {
                modificarFranja09(true);
                modificarFranja10(true);
                modificarFranja11(true);
                modificarFranja12(true);
                modificarFranja13(true);
                modificarFranja14(true);
            }
            if (parent.getSelectedItemPosition()==3) {
                modificarFranja10(true);
                modificarFranja11(true);
                modificarFranja12(true);
                modificarFranja13(true);
                modificarFranja14(true);
            }
            if (parent.getSelectedItemPosition()==4){
                modificarFranja11(true);
                modificarFranja12(true);
                modificarFranja13(true);
                modificarFranja14(true);
            }
            if (parent.getSelectedItemPosition()==5){
                modificarFranja12(true);
                modificarFranja13(true);
                modificarFranja14(true);
            }
            if (parent.getSelectedItemPosition()==6){
                modificarFranja13(true);
                modificarFranja14(true);
            }
            if (parent.getSelectedItemPosition()==7){
                modificarFranja14(true);
            }
            sp_HoraFin.setEnabled(true);
            sp_HoraFin.setBackgroundColor(Color.WHITE);
        }
        if (parent.getId()==R.id.sp_HoraFin){
            System.out.println("ENTRO EN VISTA HORA FIN");
            if (parent.getSelectedItemPosition()==0) return;
            if (parent.getSelectedItemPosition()==1) {
                modificarFranja09(false);
                modificarFranja10(false);
                modificarFranja11(false);
                modificarFranja12(false);
                modificarFranja13(false);
                modificarFranja14(false);
                sp_HoraFin.setEnabled(false);
                sp_HoraFin.setBackgroundColor(Color.LTGRAY);
            }
            if (parent.getSelectedItemPosition()==2) {
                modificarFranja10(false);
                modificarFranja11(false);
                modificarFranja12(false);
                modificarFranja13(false);
                modificarFranja14(false);
                sp_HoraFin.setEnabled(false);
                sp_HoraFin.setBackgroundColor(Color.LTGRAY);
            }
            if (parent.getSelectedItemPosition()==3) {
                modificarFranja11(false);
                modificarFranja12(false);
                modificarFranja13(false);
                modificarFranja14(false);
                sp_HoraFin.setEnabled(false);
                sp_HoraFin.setBackgroundColor(Color.LTGRAY);
            }
            if (parent.getSelectedItemPosition()==4){
                modificarFranja12(false);
                modificarFranja13(false);
                modificarFranja14(false);
                sp_HoraFin.setEnabled(false);
                sp_HoraFin.setBackgroundColor(Color.LTGRAY);
            }
            if (parent.getSelectedItemPosition()==5){
                modificarFranja13(false);
                modificarFranja14(false);
                sp_HoraFin.setEnabled(false);
                sp_HoraFin.setBackgroundColor(Color.LTGRAY);
            }
            if (parent.getSelectedItemPosition()==6){
                modificarFranja14(false);
                sp_HoraFin.setEnabled(false);
                sp_HoraFin.setBackgroundColor(Color.LTGRAY);
            }
            if (parent.getSelectedItemPosition()==7){
                sp_HoraFin.setEnabled(false);
                sp_HoraFin.setBackgroundColor(Color.LTGRAY);
            }

        }
    }

    private void reiniciarTodo() {
        modificarFranja08(false);
        modificarFranja09(false);
        modificarFranja10(false);
        modificarFranja11(false);
        modificarFranja12(false);
        modificarFranja13(false);
        modificarFranja14(false);
        sp_HoraFin.setEnabled(false);
        sp_HoraFin.setBackgroundColor(Color.LTGRAY);
    }
    private void modificarFranja08(boolean estado){
        etn_Camachuelo08.setEnabled(estado);
        etn_Jilguero08.setEnabled(estado);
        etn_Lugano08.setEnabled(estado);
        etn_PardilloComun08.setEnabled(estado);
        etn_Picogordo08.setEnabled(estado);
        etn_PinzonComun08.setEnabled(estado);
        etn_PinzonReal08.setEnabled(estado);
        etn_Piquituerto08.setEnabled(estado);
        etn_Verdecillo08.setEnabled(estado);
        etn_VerdonComun08.setEnabled(estado);
        etn_VerdonSerrano08.setEnabled(estado);
    }
    private void modificarFranja09(boolean estado){
        etn_Camachuelo09.setEnabled(estado);
        etn_Jilguero09.setEnabled(estado);
        etn_Lugano09.setEnabled(estado);
        etn_PardilloComun09.setEnabled(estado);
        etn_Picogordo09.setEnabled(estado);
        etn_PinzonComun09.setEnabled(estado);
        etn_PinzonReal09.setEnabled(estado);
        etn_Piquituerto09.setEnabled(estado);
        etn_Verdecillo09.setEnabled(estado);
        etn_VerdonComun09.setEnabled(estado);
        etn_VerdonSerrano09.setEnabled(estado);
    }
    private void modificarFranja10(boolean estado){
        etn_Camachuelo10.setEnabled(estado);
        etn_Jilguero10.setEnabled(estado);
        etn_Lugano10.setEnabled(estado);
        etn_PardilloComun10.setEnabled(estado);
        etn_Picogordo10.setEnabled(estado);
        etn_PinzonComun10.setEnabled(estado);
        etn_PinzonReal10.setEnabled(estado);
        etn_Piquituerto10.setEnabled(estado);
        etn_Verdecillo10.setEnabled(estado);
        etn_VerdonComun10.setEnabled(estado);
        etn_VerdonSerrano10.setEnabled(estado);
    }
    private void modificarFranja11(boolean estado){
        etn_Camachuelo11.setEnabled(estado);
        etn_Jilguero11.setEnabled(estado);
        etn_Lugano11.setEnabled(estado);
        etn_PardilloComun11.setEnabled(estado);
        etn_Picogordo11.setEnabled(estado);
        etn_PinzonComun11.setEnabled(estado);
        etn_PinzonReal11.setEnabled(estado);
        etn_Piquituerto11.setEnabled(estado);
        etn_Verdecillo11.setEnabled(estado);
        etn_VerdonComun11.setEnabled(estado);
        etn_VerdonSerrano11.setEnabled(estado);
    }
    private void modificarFranja12(boolean estado){
        etn_Camachuelo12.setEnabled(estado);
        etn_Jilguero12.setEnabled(estado);
        etn_Lugano12.setEnabled(estado);
        etn_PardilloComun12.setEnabled(estado);
        etn_Picogordo12.setEnabled(estado);
        etn_PinzonComun12.setEnabled(estado);
        etn_PinzonReal12.setEnabled(estado);
        etn_Piquituerto12.setEnabled(estado);
        etn_Verdecillo12.setEnabled(estado);
        etn_VerdonComun12.setEnabled(estado);
        etn_VerdonSerrano12.setEnabled(estado);
    }
    private void modificarFranja13(boolean estado){
        etn_Camachuelo13.setEnabled(estado);
        etn_Jilguero13.setEnabled(estado);
        etn_Lugano13.setEnabled(estado);
        etn_PardilloComun13.setEnabled(estado);
        etn_Picogordo13.setEnabled(estado);
        etn_PinzonComun13.setEnabled(estado);
        etn_PinzonReal13.setEnabled(estado);
        etn_Piquituerto13.setEnabled(estado);
        etn_Verdecillo13.setEnabled(estado);
        etn_VerdonComun13.setEnabled(estado);
        etn_VerdonSerrano13.setEnabled(estado);
    }
    private void modificarFranja14(boolean estado){
        etn_Camachuelo14.setEnabled(estado);
        etn_Jilguero14.setEnabled(estado);
        etn_Lugano14.setEnabled(estado);
        etn_PardilloComun14.setEnabled(estado);
        etn_Picogordo14.setEnabled(estado);
        etn_PinzonComun14.setEnabled(estado);
        etn_PinzonReal14.setEnabled(estado);
        etn_Piquituerto14.setEnabled(estado);
        etn_Verdecillo14.setEnabled(estado);
        etn_VerdonComun14.setEnabled(estado);
        etn_VerdonSerrano14.setEnabled(estado);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        if (v == btn_Guardar){
            if (comprobarCampos()){
                //Cambio y actualizacion de valores
                asignacionValores();
                avistamientoCompletado = true;

                //Inicio de activity y guardado de datos en Bundle
                Intent activity = new Intent(this, Pantalla_Menu_Metodos_Y_Captura.class);
                guardarParametros(activity);

                startActivity(activity);
                finish();
            } else {
                Toast.makeText(this, "Rellene todos los campos", Toast.LENGTH_LONG).show();
            }
        }
        if (v == btn_Volver){
            Intent activity = new Intent(this, Pantalla_Menu_Metodos_Y_Captura.class);
            guardarParametros(activity);

            startActivity(activity);
            finish();
        }
    }

    private boolean comprobarCampos() {
        if (sp_HoraInicio.getSelectedItemPosition()==0) return false;
        if (sp_HoraFin.getSelectedItemPosition()==0) return false;
        //COMPROBACION DE TODOS LOS CAMPOS

        return true;
    }

    private void asignacionValores(){

        //Datos
        String horaInicio = sp_HoraInicio.getSelectedItem().toString();
        String horaFin = sp_HoraFin.getSelectedItem().toString();

        asignarHora08();
        asignarHora09();
        asignarHora10();
        asignarHora11();
        asignarHora12();
        asignarHora13();
        asignarHora14();

        datosAvistamiento = new DatosAvistamiento(horaInicio, horaFin,hora08,hora09,hora10,hora11,hora12,hora13,hora14);

    }

    private void asignarHora08() {
        if (etn_Camachuelo08.getText().toString().equals("")) hora08.add(0);
        else hora08.add(Integer.parseInt(etn_Camachuelo08.getText().toString()));

        if (etn_Jilguero08.getText().toString().equals("")) hora08.add(0);
        else hora08.add(Integer.parseInt(etn_Jilguero08.getText().toString()));

        if (etn_Lugano08.getText().toString().equals("")) hora08.add(0);
        else hora08.add(Integer.parseInt(etn_Lugano08.getText().toString()));

        if (etn_PardilloComun08.getText().toString().equals("")) hora08.add(0);
        else hora08.add(Integer.parseInt(etn_PardilloComun08.getText().toString()));

        if (etn_Picogordo08.getText().toString().equals("")) hora08.add(0);
        else hora08.add(Integer.parseInt(etn_Picogordo08.getText().toString()));

        if (etn_PinzonComun08.getText().toString().equals("")) hora08.add(0);
        else hora08.add(Integer.parseInt(etn_PinzonComun08.getText().toString()));

        if (etn_PinzonReal08.getText().toString().equals("")) hora08.add(0);
        else hora08.add(Integer.parseInt(etn_PinzonReal08.getText().toString()));

        if (etn_Piquituerto08.getText().toString().equals("")) hora08.add(0);
        else hora08.add(Integer.parseInt(etn_Piquituerto08.getText().toString()));

        if (etn_Verdecillo08.getText().toString().equals("")) hora08.add(0);
        else hora08.add(Integer.parseInt(etn_Verdecillo08.getText().toString()));

        if (etn_VerdonComun08.getText().toString().equals("")) hora08.add(0);
        else hora08.add(Integer.parseInt(etn_VerdonComun08.getText().toString()));

        if (etn_VerdonSerrano08.getText().toString().equals("")) hora08.add(0);
        else hora08.add(Integer.parseInt(etn_VerdonSerrano08.getText().toString()));
    }
    private void asignarHora09() {
        if (etn_Camachuelo09.getText().toString().equals("")) hora09.add(0);
        else hora09.add(Integer.parseInt(etn_Camachuelo09.getText().toString()));

        if (etn_Jilguero09.getText().toString().equals("")) hora09.add(0);
        else hora09.add(Integer.parseInt(etn_Jilguero09.getText().toString()));

        if (etn_Lugano09.getText().toString().equals("")) hora09.add(0);
        else hora09.add(Integer.parseInt(etn_Lugano09.getText().toString()));

        if (etn_PardilloComun09.getText().toString().equals("")) hora09.add(0);
        else hora09.add(Integer.parseInt(etn_PardilloComun09.getText().toString()));

        if (etn_Picogordo09.getText().toString().equals("")) hora09.add(0);
        else hora09.add(Integer.parseInt(etn_Picogordo09.getText().toString()));

        if (etn_PinzonComun09.getText().toString().equals("")) hora09.add(0);
        else hora09.add(Integer.parseInt(etn_PinzonComun09.getText().toString()));

        if (etn_PinzonReal09.getText().toString().equals("")) hora09.add(0);
        else hora09.add(Integer.parseInt(etn_PinzonReal09.getText().toString()));

        if (etn_Piquituerto09.getText().toString().equals("")) hora09.add(0);
        else hora09.add(Integer.parseInt(etn_Piquituerto09.getText().toString()));

        if (etn_Verdecillo09.getText().toString().equals("")) hora09.add(0);
        else hora09.add(Integer.parseInt(etn_Verdecillo09.getText().toString()));

        if (etn_VerdonComun09.getText().toString().equals("")) hora09.add(0);
        else hora09.add(Integer.parseInt(etn_VerdonComun09.getText().toString()));

        if (etn_VerdonSerrano09.getText().toString().equals("")) hora09.add(0);
        else hora09.add(Integer.parseInt(etn_VerdonSerrano09.getText().toString()));
    }
    private void asignarHora10() {
        if (etn_Camachuelo10.getText().toString().equals("")) hora10.add(0);
        else hora10.add(Integer.parseInt(etn_Camachuelo10.getText().toString()));

        if (etn_Jilguero10.getText().toString().equals("")) hora10.add(0);
        else hora10.add(Integer.parseInt(etn_Jilguero10.getText().toString()));

        if (etn_Lugano10.getText().toString().equals("")) hora10.add(0);
        else hora10.add(Integer.parseInt(etn_Lugano10.getText().toString()));

        if (etn_PardilloComun10.getText().toString().equals("")) hora10.add(0);
        else hora10.add(Integer.parseInt(etn_PardilloComun10.getText().toString()));

        if (etn_Picogordo10.getText().toString().equals("")) hora10.add(0);
        else hora10.add(Integer.parseInt(etn_Picogordo10.getText().toString()));

        if (etn_PinzonComun10.getText().toString().equals("")) hora10.add(0);
        else hora10.add(Integer.parseInt(etn_PinzonComun10.getText().toString()));

        if (etn_PinzonReal10.getText().toString().equals("")) hora10.add(0);
        else hora10.add(Integer.parseInt(etn_PinzonReal10.getText().toString()));

        if (etn_Piquituerto10.getText().toString().equals("")) hora10.add(0);
        else hora10.add(Integer.parseInt(etn_Piquituerto10.getText().toString()));

        if (etn_Verdecillo10.getText().toString().equals("")) hora10.add(0);
        else hora10.add(Integer.parseInt(etn_Verdecillo10.getText().toString()));

        if (etn_VerdonComun10.getText().toString().equals("")) hora10.add(0);
        else hora10.add(Integer.parseInt(etn_VerdonComun10.getText().toString()));

        if (etn_VerdonSerrano10.getText().toString().equals("")) hora10.add(0);
        else hora10.add(Integer.parseInt(etn_VerdonSerrano10.getText().toString()));
    }
    private void asignarHora11() {
        if (etn_Camachuelo11.getText().toString().equals("")) hora11.add(0);
        else hora11.add(Integer.parseInt(etn_Camachuelo11.getText().toString()));

        if (etn_Jilguero11.getText().toString().equals("")) hora11.add(0);
        else hora11.add(Integer.parseInt(etn_Jilguero11.getText().toString()));

        if (etn_Lugano11.getText().toString().equals("")) hora11.add(0);
        else hora11.add(Integer.parseInt(etn_Lugano11.getText().toString()));

        if (etn_PardilloComun11.getText().toString().equals("")) hora11.add(0);
        else hora11.add(Integer.parseInt(etn_PardilloComun11.getText().toString()));

        if (etn_Picogordo11.getText().toString().equals("")) hora11.add(0);
        else hora11.add(Integer.parseInt(etn_Picogordo11.getText().toString()));

        if (etn_PinzonComun11.getText().toString().equals("")) hora11.add(0);
        else hora11.add(Integer.parseInt(etn_PinzonComun11.getText().toString()));

        if (etn_PinzonReal11.getText().toString().equals("")) hora11.add(0);
        else hora11.add(Integer.parseInt(etn_PinzonReal11.getText().toString()));

        if (etn_Piquituerto11.getText().toString().equals("")) hora11.add(0);
        else hora11.add(Integer.parseInt(etn_Piquituerto11.getText().toString()));

        if (etn_Verdecillo11.getText().toString().equals("")) hora11.add(0);
        else hora11.add(Integer.parseInt(etn_Verdecillo11.getText().toString()));

        if (etn_VerdonComun11.getText().toString().equals("")) hora11.add(0);
        else hora11.add(Integer.parseInt(etn_VerdonComun11.getText().toString()));

        if (etn_VerdonSerrano11.getText().toString().equals("")) hora11.add(0);
        else hora11.add(Integer.parseInt(etn_VerdonSerrano11.getText().toString()));
    }
    private void asignarHora12() {
        if (etn_Camachuelo12.getText().toString().equals("")) hora12.add(0);
        else hora12.add(Integer.parseInt(etn_Camachuelo12.getText().toString()));

        if (etn_Jilguero12.getText().toString().equals("")) hora12.add(0);
        else hora12.add(Integer.parseInt(etn_Jilguero12.getText().toString()));

        if (etn_Lugano12.getText().toString().equals("")) hora12.add(0);
        else hora12.add(Integer.parseInt(etn_Lugano12.getText().toString()));

        if (etn_PardilloComun12.getText().toString().equals("")) hora12.add(0);
        else hora12.add(Integer.parseInt(etn_PardilloComun12.getText().toString()));

        if (etn_Picogordo12.getText().toString().equals("")) hora12.add(0);
        else hora12.add(Integer.parseInt(etn_Picogordo12.getText().toString()));

        if (etn_PinzonComun12.getText().toString().equals("")) hora12.add(0);
        else hora12.add(Integer.parseInt(etn_PinzonComun12.getText().toString()));

        if (etn_PinzonReal12.getText().toString().equals("")) hora12.add(0);
        else hora12.add(Integer.parseInt(etn_PinzonReal12.getText().toString()));

        if (etn_Piquituerto12.getText().toString().equals("")) hora12.add(0);
        else hora12.add(Integer.parseInt(etn_Piquituerto12.getText().toString()));

        if (etn_Verdecillo12.getText().toString().equals("")) hora12.add(0);
        else hora12.add(Integer.parseInt(etn_Verdecillo12.getText().toString()));

        if (etn_VerdonComun12.getText().toString().equals("")) hora12.add(0);
        else hora12.add(Integer.parseInt(etn_VerdonComun12.getText().toString()));

        if (etn_VerdonSerrano12.getText().toString().equals("")) hora12.add(0);
        else hora12.add(Integer.parseInt(etn_VerdonSerrano12.getText().toString()));
    }
    private void asignarHora13() {
        if (etn_Camachuelo13.getText().toString().equals("")) hora13.add(0);
        else hora13.add(Integer.parseInt(etn_Camachuelo13.getText().toString()));

        if (etn_Jilguero13.getText().toString().equals("")) hora13.add(0);
        else hora13.add(Integer.parseInt(etn_Jilguero13.getText().toString()));

        if (etn_Lugano13.getText().toString().equals("")) hora13.add(0);
        else hora13.add(Integer.parseInt(etn_Lugano13.getText().toString()));

        if (etn_PardilloComun13.getText().toString().equals("")) hora13.add(0);
        else hora13.add(Integer.parseInt(etn_PardilloComun13.getText().toString()));

        if (etn_Picogordo13.getText().toString().equals("")) hora13.add(0);
        else hora13.add(Integer.parseInt(etn_Picogordo13.getText().toString()));

        if (etn_PinzonComun13.getText().toString().equals("")) hora13.add(0);
        else hora13.add(Integer.parseInt(etn_PinzonComun13.getText().toString()));

        if (etn_PinzonReal13.getText().toString().equals("")) hora13.add(0);
        else hora13.add(Integer.parseInt(etn_PinzonReal13.getText().toString()));

        if (etn_Piquituerto13.getText().toString().equals("")) hora13.add(0);
        else hora13.add(Integer.parseInt(etn_Piquituerto13.getText().toString()));

        if (etn_Verdecillo13.getText().toString().equals("")) hora13.add(0);
        else hora13.add(Integer.parseInt(etn_Verdecillo13.getText().toString()));

        if (etn_VerdonComun13.getText().toString().equals("")) hora13.add(0);
        else hora13.add(Integer.parseInt(etn_VerdonComun13.getText().toString()));

        if (etn_VerdonSerrano13.getText().toString().equals("")) hora13.add(0);
        else hora13.add(Integer.parseInt(etn_VerdonSerrano13.getText().toString()));
    }
    private void asignarHora14() {
        if (etn_Camachuelo14.getText().toString().equals("")) hora14.add(0);
        else hora14.add(Integer.parseInt(etn_Camachuelo14.getText().toString()));

        if (etn_Jilguero14.getText().toString().equals("")) hora14.add(0);
        else hora14.add(Integer.parseInt(etn_Jilguero14.getText().toString()));

        if (etn_Lugano14.getText().toString().equals("")) hora14.add(0);
        else hora14.add(Integer.parseInt(etn_Lugano14.getText().toString()));

        if (etn_PardilloComun14.getText().toString().equals("")) hora14.add(0);
        else hora14.add(Integer.parseInt(etn_PardilloComun14.getText().toString()));

        if (etn_Picogordo14.getText().toString().equals("")) hora14.add(0);
        else hora14.add(Integer.parseInt(etn_Picogordo14.getText().toString()));

        if (etn_PinzonComun14.getText().toString().equals("")) hora14.add(0);
        else hora14.add(Integer.parseInt(etn_PinzonComun14.getText().toString()));

        if (etn_PinzonReal14.getText().toString().equals("")) hora14.add(0);
        else hora14.add(Integer.parseInt(etn_PinzonReal14.getText().toString()));

        if (etn_Piquituerto14.getText().toString().equals("")) hora14.add(0);
        else hora14.add(Integer.parseInt(etn_Piquituerto14.getText().toString()));

        if (etn_Verdecillo14.getText().toString().equals("")) hora14.add(0);
        else hora14.add(Integer.parseInt(etn_Verdecillo14.getText().toString()));

        if (etn_VerdonComun14.getText().toString().equals("")) hora14.add(0);
        else hora14.add(Integer.parseInt(etn_VerdonComun14.getText().toString()));

        if (etn_VerdonSerrano14.getText().toString().equals("")) hora14.add(0);
        else hora14.add(Integer.parseInt(etn_VerdonSerrano14.getText().toString()));
    }

    private void guardarParametros(Intent actividadDestino) {

        imprimirDatosRecibidos();

        actividadDestino.putExtra("EMAIL",email);
        actividadDestino.putExtra("DNI",DNI);
        actividadDestino.putExtra("ENVIO_COMPLETADO",envioCompletado);
        actividadDestino.putExtra("DATOS_AVISTAMIENTO", datosAvistamiento);
        actividadDestino.putExtra("DATOS_ENTORNO", datosEntorno);
        actividadDestino.putExtra("DATOS_CAPTURA", metodosCaptura);
        actividadDestino.putExtra("ENTORNO_COMPLETADO", entornoCompletado);
        actividadDestino.putExtra("MCAPTURAS_COMPLETADO", mCapturasCompletado);
        actividadDestino.putExtra("AVISTAMIENTO_COMPLETADO", avistamientoCompletado);
        actividadDestino.putExtra("LIMITES", limites);

        if (mCapturasCompletado && entornoCompletado && avistamientoCompletado){
            actividadDestino.putExtra("FECHA", fecha);
            actividadDestino.putExtra("LATITUD", latitud);
            actividadDestino.putExtra("LONGITUD", longitud);
        }

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
        limites = (Limites) datos.getSerializable("LIMITES");

        if (mCapturasCompletado && avistamientoCompletado && entornoCompletado){
            fecha = datos.getString("FECHA");
            latitud = datos.getString("LATITUD");
            longitud = datos.getString("LONGITUD");
        }
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
