package com.example.preguntasyrespuestas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText respuesta;
    private Button botonresponder;
    private TextView vista;
    private TextView tiempo;
    private ArrayList<Pregunta> question;
    private TextView prueba;
    int nm1;
    int nm2;
    int simbolo;
    private int i;
    String convertir;
    String calculo;
    int validacion;
    int segs = 30;
    int contador = 0;
    Boolean validador;


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
        prueba = findViewById(R.id.prueba);
        Log.e("hola", "aqui");
        question = new ArrayList<>();
        generarPregunta();
        time();
        //para iniciar un boton
        botonresponder.setOnClickListener(
                (view) -> {

                    //para extraer el texto
                    convertir = respuesta.getText().toString();
                    //validacion = Integer.parseInt(convertir);
                    /*for(i = 0; i < question.size(); i++){
                        if(validacion == question.get(i).getResultado()){
                            generarPregunta();
                            segs = 30;
                        }*/
                    for(i = 0; i < question.size();i++){

                        if(convertir.equals(Integer.toString(question.get(i).getResultado()))){
                            generarPregunta();
                            segs = 30;
                            contador++;
                            //prueba.setText(contador);
                        }

                    }




                    //validacion = Integer.parseInt(convertir);
                    //validar();
                    Toast.makeText(this, convertir + " ", Toast.LENGTH_LONG).show();
                    //vista.setText(calculo);

                }
        );

    }


    public void generarPregunta(){

        nm1 = (int) (Math.random()*30);
        nm2 = (int) (Math.random()*30);
        simbolo = (int) (Math.random()*3);
        question.add(new Pregunta(nm1,nm2,simbolo));
        for(i = 0; i < question.size(); i++){
            question.get(i).hacerPregunta();
            vista.setText(""+ question.get(i).retorno());

        }

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
                                }
                        );
                    }
                }


        ).start();

    }


}