package com.sefricam.sefricam3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Pantalla_Mi_Cuadricula extends Activity implements View.OnClickListener{


    public String email;
    private double longitud, latitud;
    private Limites limites;
    private EditText etnd_LatitudCuadricula, etnd_LongitudCuadricula;
    private TextView tv_CuadriculaActual, tv_ResultadoCuadricula;
    private Button btn_CalcularCuadricula, btn_VolverCuadricula;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_menu_intermedio);

        //Inicio de los Elementos del layout
        iniciarFindView();
        iniciarOnClickListener();

        //Carga de datos recuperados de la BD
        Bundle datos = this.getIntent().getExtras();
        if (datos != null) {
            email = datos.getString("EMAIL");
            limites = (Limites) datos.getSerializable("LIMITES");
        }
    }



    private void iniciarFindView() {
        etnd_LatitudCuadricula =findViewById(R.id.etnd_LatitudCuadricula);
        etnd_LongitudCuadricula = findViewById(R.id.etnd_LongitudCuadricula);
        tv_CuadriculaActual = findViewById(R.id.tv_CuadriculaActual);
        tv_ResultadoCuadricula = findViewById(R.id.tv_ResultadoCuadricula);
        btn_CalcularCuadricula = findViewById(R.id.btn_CalcularCuadricula);
        btn_VolverCuadricula = findViewById(R.id.btn_VolverCuadricula);

    }

    private void iniciarOnClickListener() {
        btn_CalcularCuadricula.setOnClickListener(this);
        btn_VolverCuadricula.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
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

            longitud = Double.parseDouble(etnd_LongitudCuadricula.getText().toString());
            latitud = Double.parseDouble(etnd_LatitudCuadricula.getText().toString());

            tv_ResultadoCuadricula.setText(cuadricula());
            tv_ResultadoCuadricula.setVisibility(View.VISIBLE);
            tv_CuadriculaActual.setVisibility(View.VISIBLE);
        }
    }

    /**
     * Asignacion de cuadrícula
     * @return código de cuadricula según coordenadas
     */
    private String cuadricula(){
        //Primer valor
        String codCuadricula = "";
        double x = (longitud - 3.123);
        double x1 = x/0.1159;
        double x2 = 12-x1;
        if(x2<0) x2=0.0;
        double x3 = Math.ceil(x2);

        //Segundo valor
        double y = (latitud - 39.937133);
        double y1 = y/0.08878954;
        double y2 = 14-y1;
        if(y2<0) y2=0.0;
        double y3 = Math.ceil(y2);

        //Juntar los dos numeros
        int ix3 = (int) x3;
        int iy3 = (int) y3;

        String sValor1 = String.valueOf(ix3);
        String sValor2= String.valueOf(iy3);

        String svalorDef = sValor1.concat(sValor2);
        int numCuadricula = Integer.parseInt(svalorDef);

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
