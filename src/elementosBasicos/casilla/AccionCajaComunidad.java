package elementosBasicos.casilla;

import elementosBasicos.casilla.Accion;
import elementosBasicos.casilla.Especial;

final public class AccionCajaComunidad extends Accion {//final porque no hay ninguna clase que herede de esta
    public AccionCajaComunidad(String nombreCasilla, Especial parking, String codigoColor, int numcasilla) {
        super(nombreCasilla, parking,codigoColor,numcasilla);
    }
    public String toString(){
        return "No tiene sentido describir esta casilla\n";
    }
}
