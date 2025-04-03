package elementosBasicos.casilla;

import elementosBasicos.Jugador;

import java.util.ArrayList;
import java.util.List;

abstract public class Casilla {//es una clase abstracta ya que nunca instancio una casilla, siempre instancio sus derivadas

    //Atributos
    private List<Jugador> jugadoresCasilla;
    private String nombreCasilla;
    private int[] caerCasilla;
    private String codigoColor;
    private float dineroObtenido;
    private int numcasilla;


    //getters


    public List<Jugador> getJugadoresCasilla() {
        return jugadoresCasilla;
    }
    public String getNombreCasilla() { return nombreCasilla; }
    public String getCodigoColor() { return codigoColor; }
    public float getDineroObtenido() {
        return dineroObtenido;
    }
    public int getNumcasilla() {
        return numcasilla;
    }

    //setters

    public void setJugadoresCasilla(List<Jugador> jugadoresCasilla) {
        this.jugadoresCasilla = jugadoresCasilla;
    }
    public void setNombreCasilla(String nombreCasilla) {
        this.nombreCasilla = nombreCasilla;
    }
    public void setDineroObtenido(float dineroObtenido) {
        this.dineroObtenido = dineroObtenido;
    }

    public int[] getCaerCasilla() {
        return caerCasilla;
    }

    public void setCaerCasilla(int[] caerCasilla) {
        this.caerCasilla = caerCasilla;
    }

    public void setCodigoColor(String codigoColor) {
        this.codigoColor = codigoColor;
    }

    public void setNumcasilla(int numcasilla) {
        this.numcasilla = numcasilla;
    }

    //constructor
    public Casilla(String nombreCasilla, String codigoColor, int numcasilla) {
        this.jugadoresCasilla = new ArrayList<>();
        this.nombreCasilla = nombreCasilla;
        this.caerCasilla = new int[6];
        this.codigoColor=codigoColor;
        this.dineroObtenido=0;
        this.numcasilla=numcasilla;
    }

    public boolean estaAvatar(char avatar){
        int i;
        for (i=0;i<this.jugadoresCasilla.size();i++){
            if (jugadoresCasilla.get(i).getAvatar().getAvatar()==avatar)
                return true;
        }
        return false;
    }

    public int frecuenciaVisita(int turno){
        return caerCasilla[turno];
    }



}
