package com.example.preguntasyrespuestas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText respuesta;
    private Button botonresponder;
    private TextView vista;
    private TextView tiempo;
    private Pregunta question;
    private TextView prueba;
    private Button intentar;
    int i;
    String convertir;
    String calculo;
    int validacion;
    int segs = 30;
    int contador = 0;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //referenciar
        respuesta = findViewById(R.id.respuesta);
        botonresponder = findViewById(R.id.botonresponder);
        vista = findViewById(R.id.vista);
        tiempo = findViewById(R.id.tiempo);
        prueba = findViewById(R.id.puntos);
        intentar = findViewById(R.id.intentar);

        Log.e("hola", "aqui");
        time();
        hacerPregunta();
        prueba.setText(""+contador);
        //para iniciar un boton
        botonresponder.setOnClickListener(
                (view) -> {

                        if (Integer.parseInt(respuesta.getText().toString()) == question.getResultado()) {
                            //hacerPregunta();
                            contador += 10;
                            hacerPregunta();
                            respuesta.setText("");
                        }else{
                            contador -= 10;
                        }
                        prueba.setText(""+contador);

                }
        );

        intentar.setOnClickListener(

                (view )->{

                    segs = 30;
                    intentar.setVisibility(View.GONE);

                }

        );

    }

    public void hacerPregunta(){
        question = new Pregunta();
        question.hacerPregunta();
        vista.setText(""+ question.retorno());
    }

    public void time(){

        new Thread(

                () ->{
                    while(true){

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        segs = segs - 1;
                        runOnUiThread(
                                () -> {
                                    tiempo.setText(""+segs);
                                    if( segs <= 0){
                                        segs = 0;
                                        intentar.setVisibility(View.VISIBLE);
                                    }
                                }
                        );
                    }
                }


        ).start();

    }


}



