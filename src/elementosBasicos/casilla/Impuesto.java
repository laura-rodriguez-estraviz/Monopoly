package elementosBasicos.casilla;

import elementosBasicos.casilla.Casilla;

final public class Impuesto extends Casilla {//final porque no hay ninguna clase que herede de esta
    private float valor;

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Impuesto(String nombreCasilla, int numcasilla,float valor) {
        super(nombreCasilla,"\u001B[0m",numcasilla);
        this.valor=valor;
    }
    public String toString(){
        return "{\n\ttipo: impuesto,\n" +
                "\ta pagar: " + this.valor + "\n}";
    }
}
