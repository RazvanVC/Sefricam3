package com.sefricam.sefricam3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import static java.lang.Math.*;

public class Pantalla_Mi_Cuadricula extends Activity implements View.OnClickListener{

    // UI Parameters
    private EditText etnd_LatitudCuadricula, etnd_LongitudCuadricula, etnd_LongitudAnterior, etnd_LatitudAnterior;
    private TextView tv_CuadriculaActual;
    private TextView tv_ResultadoCuadricula;
    private TextView tv_DatosLongitudDistancia;
    private TextView tv_Distancia;
    private TextView tv_ResultadoDistancia;
    private Button btn_CalcularCuadricula, btn_VolverCuadricula, btn_CalcularDistancia;

    //Class Parameters
    public String email;
    private Limites limites;

    /**
     * Initialize the screen and all its components
     * @param savedInstanceState bundle of data that receives when it starts the screen
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_mi_cuadricula);

        //Starting the elements from the UI
        startFindView();
        setOnClickListener();

        //Extracts the data from the bundle
        Bundle datos = this.getIntent().getExtras();
        if (datos != null) {
            email = datos.getString("EMAIL");
            limites = (Limites) datos.getSerializable("LIMITES");
        }
    }


    /**
     * Init the UI elements into the code
     */
    private void startFindView() {
        etnd_LatitudCuadricula = findViewById(R.id.etnd_LatitudCuadricula);
        etnd_LongitudCuadricula = findViewById(R.id.etnd_LongitudCuadricula);
        etnd_LongitudAnterior=findViewById(R.id.etnd_LongitudAnterior);
        etnd_LatitudAnterior=findViewById(R.id.etnd_LatitudAnterior);
        tv_CuadriculaActual = findViewById(R.id.tv_CuadriculaActual);
        tv_ResultadoCuadricula = findViewById(R.id.tv_ResultadoCuadricula);
        tv_Distancia= findViewById(R.id.tv_Distancia);
        tv_ResultadoDistancia = findViewById(R.id.tv_ResultadoDistancia);
        btn_CalcularCuadricula = findViewById(R.id.btn_CalcularCuadricula);
        btn_VolverCuadricula = findViewById(R.id.btn_VolverCuadricula);
        btn_CalcularDistancia = findViewById(R.id.btn_CalcularDistancia);
    }

    /**
     * Sets all the click listener for the UI elements
     */
    private void setOnClickListener() {
        btn_CalcularCuadricula.setOnClickListener(this);
        btn_VolverCuadricula.setOnClickListener(this);
        btn_CalcularDistancia.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if (v == btn_VolverCuadricula){
            Intent activity = new Intent(Pantalla_Mi_Cuadricula.this,Pantalla_Menu_Intermedio.class);
            activity.putExtra("EMAIL",email);
            activity.putExtra("LIMITES", limites);
            startActivity(activity);
        }
        if (v == btn_CalcularCuadricula) {
            try {
                Double.parseDouble(etnd_LongitudCuadricula.getText().toString());
                Double.parseDouble(etnd_LatitudCuadricula.getText().toString());
            } catch (Exception e) {
                tv_CuadriculaActual.setVisibility(View.INVISIBLE);
                tv_ResultadoCuadricula.setVisibility(View.INVISIBLE);
                Toast.makeText(this, "Hay un error con las coordenadas introducidas", Toast.LENGTH_SHORT).show();
                return;
            }

            double longitud = Double.parseDouble(etnd_LongitudCuadricula.getText().toString());
            double latitud = Double.parseDouble(etnd_LatitudCuadricula.getText().toString());

            tv_ResultadoCuadricula.setText(setCuadricula(longitud, latitud));
            tv_ResultadoCuadricula.setVisibility(View.VISIBLE);
            tv_CuadriculaActual.setVisibility(View.VISIBLE);
        }
        if (v == btn_CalcularDistancia){
            try {
                Double.parseDouble(etnd_LongitudCuadricula.getText().toString());
                Double.parseDouble(etnd_LatitudCuadricula.getText().toString());
                Double.parseDouble(etnd_LongitudAnterior.getText().toString());
                Double.parseDouble(etnd_LatitudAnterior.getText().toString());
            } catch (Exception e) {
                tv_Distancia.setVisibility(View.INVISIBLE);
                tv_ResultadoDistancia.setVisibility(View.INVISIBLE);
                Toast.makeText(this, "Hay un error con las coordenadas introducidas", Toast.LENGTH_SHORT).show();
                return;
            }
            double longitud1 = Double.parseDouble(etnd_LongitudCuadricula.getText().toString());
            double latitud1 = Double.parseDouble(etnd_LatitudCuadricula.getText().toString());
            double longitud2 = Double.parseDouble(etnd_LongitudAnterior.getText().toString());
            double latitud2 = Double.parseDouble(etnd_LatitudAnterior.getText().toString());


            tv_ResultadoDistancia.setText(setDistancia(longitud1,latitud1,longitud2,latitud2));
            tv_Distancia.setVisibility(View.VISIBLE);
            tv_ResultadoDistancia.setVisibility(View.VISIBLE);

        }
    }

    private String setDistancia(double longitud1, double latitud1, double longitud2, double latitud2) {
        double distanciaGrados = acos(sin(latitud1)*sin(latitud2)+cos(latitud1)*cos(latitud2)*cos(longitud1-longitud2));
        double distanciaTotal = round(111.18*distanciaGrados*100.0)/100.0;
        return distanciaTotal+" KM";
    }

    /**
     * Set the code for the coordinates provided
     * @return code for the Quadrille
     */
    private String setCuadricula(double longitud, double latitud){
        //Primer valor
        double x = 12-((longitud - 3.123)/0.1159);
        if(x<0) x=0.0;
        x = Math.ceil(x);

        //Segundo valor
        double y = 14-((latitud - 39.937133)/0.08878954);
        if(y<0) y=0.0;
        y = Math.ceil(y);

        int numCuadricula = Integer.parseInt(String.valueOf((int) x).concat(String.valueOf((int) y)));

        String codCuadricula;
        switch (numCuadricula){
            case 37:
                codCuadricula = "01UKA10";
                break;
            case 38:
                codCuadricula = "02UKB10";
                break;
            case 29:
                codCuadricula = "03UKC09";
                break;
            case 39:
                codCuadricula = "04UKC10";
                break;
            case 110:
                codCuadricula = "05UKD08";
                break;
            case 210:
                codCuadricula = "06UKD09";
                break;
            case 310:
                codCuadricula = "07UKD10";
                break;
            case 111:
                codCuadricula = "08UKE08";
                break;
            case 211:
                codCuadricula = "09UKE09";
                break;
            case 91:
                codCuadricula = "10VLE06";
                break;
            case 82:
                codCuadricula = "11VLF05";
                break;
            case 92:
                codCuadricula = "12VLF06";
                break;
            case 102:
                codCuadricula = "13VLF07";
                break;
            case 63:
                codCuadricula = "14VLG03";
                break;
            case 73:
                codCuadricula = "15VLG04";
                break;
            case 83:
                codCuadricula = "16VLG05";
                break;
            case 93:
                codCuadricula = "17VLG06";
                break;
            case 103:
                codCuadricula = "18VLG07";
                break;
            case 64:
                codCuadricula = "19VLH03";
                break;
            case 74:
                codCuadricula = "20VLH04";
                break;
            case 84:
                codCuadricula = "21VLH05";
                break;
            case 94:
                codCuadricula = "22VLH06";
                break;
            case 55:
                codCuadricula = "23VLI02";
                break;
            case 65:
                codCuadricula = "24VLI03";
                break;
            case 75:
                codCuadricula = "25VLI04";
                break;
            case 85:
                codCuadricula = "26VLI05";
                break;
            case 95:
                codCuadricula = "27VLI06";
                break;
            case 46:
                codCuadricula = "28VLJ01";
                break;
            case 56:
                codCuadricula = "29VLJ02";
                break;
            case 66:
                codCuadricula = "30VLJ03";
                break;
            case 76:
                codCuadricula = "31VLJ04";
                break;
            case 86:
                codCuadricula = "32VLJ05";
                break;
            case 96:
                codCuadricula = "33VLJ06";
                break;
            case 47:
                codCuadricula = "34VKA01";
                break;
            case 57:
                codCuadricula = "35VKA02";
                break;
            case 67:
                codCuadricula = "36VKA03";
                break;
            case 77:
                codCuadricula = "37VKA04";
                break;
            case 87:
                codCuadricula = "38VKA05";
                break;
            case 97:
                codCuadricula = "39VKA06";
                break;
            case 107:
                codCuadricula = "40VKA07";
                break;
            case 48:
                codCuadricula = "41VKB01";
                break;
            case 58:
                codCuadricula = "42VKB02";
                break;
            case 68:
                codCuadricula = "43VKB03";
                break;
            case 78:
                codCuadricula = "44VKB04";
                break;
            case 88:
                codCuadricula = "45VKB05";
                break;
            case 98:
                codCuadricula = "46VKB06";
                break;
            case 108:
                codCuadricula = "47VKB07";
                break;
            case 118:
                codCuadricula = "48VKB08";
                break;
            case 49:
                codCuadricula = "49VKC01";
                break;
            case 59:
                codCuadricula = "50VKC02";
                break;
            case 69:
                codCuadricula = "51VKC03";
                break;
            case 79:
                codCuadricula = "52VKC04";
                break;
            case 89:
                codCuadricula = "53VKC05";
                break;
            case 99:
                codCuadricula = "54VKC06";
                break;
            case 109:
                codCuadricula = "55VKC07";
                break;
            case 119:
                codCuadricula = "56VKC08";
                break;
            case 129:
                codCuadricula = "57VKC09";
                break;
            case 410:
                codCuadricula = "58VKD01";
                break;
            case 510:
                codCuadricula = "59VKD02";
                break;
            case 610:
                codCuadricula = "60VKD03";
                break;
            case 710:
                codCuadricula = "61VKD04";
                break;
            case 810:
                codCuadricula = "62VKD05";
                break;
            case 910:
                codCuadricula = "63VKD06";
                break;
            case 1010:
                codCuadricula = "64VKD07";
                break;
            case 1110:
                codCuadricula = "65VKD08";
                break;
            case 1210:
                codCuadricula = "66VKD09";
                break;
            case 411:
                codCuadricula = "67VKE01";
                break;
            case 511:
                codCuadricula = "68VKE02";
                break;
            case 611:
                codCuadricula = "69VKE03";
                break;
            case 711:
                codCuadricula = "70VKE04";
                break;
            case 811:
                codCuadricula = "71VKE05";
                break;
            case 911:
                codCuadricula = "72VKE06";
                break;
            case 1011:
                codCuadricula = "73VKE07";
                break;
            case 1111:
                codCuadricula = "74VKE08";
                break;
            case 1211:
                codCuadricula = "75VKE09";
                break;
            case 712:
                codCuadricula = "76VKF04";
                break;
            case 812:
                codCuadricula = "77VKF05";
                break;
            case 912:
                codCuadricula = "78VKF06";
                break;
            case 1012:
                codCuadricula = "79VKF07";
                break;
            case 1112:
                codCuadricula = "80VKF08";
                break;
            case 1212:
                codCuadricula = "81VKF09";
                break;
            case 913:
                codCuadricula = "82VKG06";
                break;
            case 1013:
                codCuadricula = "83VKG07";
                break;
            case 1113:
                codCuadricula = "84VKG08";
                break;
            case 1213:
                codCuadricula = "85VKG09";
                break;
            case 814:
                codCuadricula = "86VKH05";
                break;
            default:
                codCuadricula = "ERROR";
                break;
        }

        return codCuadricula;
    }
}
