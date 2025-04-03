package elementosBasicos.casilla;

abstract public class Accion extends Casilla { //es abstracta ya que siempre instancio accionSuerte o accionCajaComunidad, no accion
    private Especial parking;
    public Accion(String nombreCasilla,Especial Parking,String codigoColor, int numcasilla) {
        super(nombreCasilla,codigoColor,numcasilla);
        this.parking=parking;
    }

}
