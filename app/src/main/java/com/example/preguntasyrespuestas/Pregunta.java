package com.example.preguntasyrespuestas;

public class Pregunta {

    int n1;
    int n2;
    int operacion;
    int resultado;
    String answer;

    public Pregunta(int n1, int n2, int operacion){
        this.n1 = n1;
        this.n2 = n2;
        this.operacion = operacion;
        this.resultado = resultado;
    }

    public void hacerPregunta(){

        switch (operacion){

            case 0:
                answer = n1 + "+" + n2;
                resultado = n1 + n2;
                break;

            case 1:
                answer = n1 + "-" + n2;
                resultado = n1 - n2;
                break;

            case 2:
                answer = n1 + "x" + n2;
                resultado = n1 * n2;
                break;

            case 3:
                answer = n1 + "/" + n2;
                resultado = n1 / n2;
                break;

        }

    }

    String retorno(){
        return answer;
    }

    public int getN1() {
        return n1;
    }

    public int getN2() {
        return n2;
    }

    public int getResultado() {
        return resultado;
    }


}
