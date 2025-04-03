package juego;

import java.util.Random;
import java.util.Scanner;
final public class Dados {//final porque no hay ninguna clase que herede de esta
    private int valorDado1;
    private int valorDado2;
    private int valorTotal;
    private int dobles;

    //getters
    //no hacen falta los getters de los dados por separado ya que nunca querremos los valores de los dados separados fuera de la clase
    public int getValorTotal() {
        return valorTotal;
    }
    public int getDobles() {
        return dobles;
    }

    //setters
    public void setDobles(int dobles) {
        this.dobles = dobles;
    }
    public void setValorTotal(int valorTotal) {this.valorTotal = valorTotal;
    }

    //los valores de los dados siempre se cambiaran desde esta clase, por lo que el resto de setters son innecesarios


    //constructor
    public Dados(){
        valorDado1=0;
        valorDado2=0;
        valorTotal=0;
        dobles=1;
    }


    public void lanzarDados(){
        Random random1 = new Random();
        Random random2 = new Random();
        Monopolio.juego.getListaJugadores().get(Monopolio.juego.getTurno()).setVecesDados(Monopolio.juego.getListaJugadores().get(Monopolio.juego.getTurno()).getVecesDados()+1);
        valorDado1=random1.nextInt(6)+1;
        valorDado2=random2.nextInt(6)+1;
        valorTotal=valorDado1+valorDado2;
        if(valorDado1==valorDado2){
            Juego.consola.imprimir("Has sacado dobles");
            dobles++;
        }
        else{
            dobles=0;
        }
    }
    public void dadosTrucados(){
        //Scanner scan = new Scanner(System.in);
        Juego.consola.imprimir("Dado1:");
        valorDado1= Integer.parseInt(Juego.consola.leer(null));
        Juego.consola.imprimir("Dado2:");
        valorDado2= Integer.parseInt(Juego.consola.leer(null));
        Monopolio.juego.getListaJugadores().get(Monopolio.juego.getTurno()).setVecesDados(Monopolio.juego.getListaJugadores().get(Monopolio.juego.getTurno()).getVecesDados()+1);
        valorTotal=valorDado1+valorDado2;
        if(valorDado1==valorDado2){
            dobles++;
        }
        else{
            dobles=0;
        }
    }
}


