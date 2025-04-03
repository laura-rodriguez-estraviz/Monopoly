package elementosBasicos.casilla;

import juego.Monopolio;

final public class Transporte extends Propiedad {//final porque no hay ninguna clase que herede de esta

    public Transporte(String propietario, float valor, float valorInicial, float alquiler, String nombreCasilla,String codigoColor, int numcasilla) {
        super(propietario, valor, valorInicial, alquiler, nombreCasilla, codigoColor,numcasilla);

    }

    public String toString() {
        return "{\n"+super.toString()+"\n}";

    }
    public float alquiler(){
        float aux=0;
        if (((Transporte)Monopolio.juego.getTablero().getTablero()[5]).getPropietario().equals(this.getPropietario())){
            aux+=0.25;
        }
        if (((Transporte)Monopolio.juego.getTablero().getTablero()[15]).getPropietario().equals(this.getPropietario())){
            aux+=0.25;
        }
        if (((Transporte)Monopolio.juego.getTablero().getTablero()[25]).getPropietario().equals(this.getPropietario())){
            aux+=0.25;
        }
        if (((Transporte)Monopolio.juego.getTablero().getTablero()[35]).getPropietario().equals(this.getPropietario())){
            aux+=0.25;
        }

        return this.getAlquiler()*aux;
    }
}
