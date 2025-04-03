package elementosBasicos.casilla;

import elementosBasicos.casilla.Casilla;

final public class Especial extends Casilla {//final porque no hay ninguna clase que herede de esta
    //parking, carcel, salida, ir a la carcel
    private float valor;
    public Especial(String nombreCasilla, float valor,String codigoColor, int numcasilla) {
        super(nombreCasilla,codigoColor,numcasilla);
        this.valor=valor;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String toString(){
        if(this.getNombreCasilla().equals("Carcel")){
            String jugadores="[";
            int i;
            for (i=0;i<this.getJugadoresCasilla().size();i++) {
                jugadores+=this.getJugadoresCasilla().get(i).getNombre();
                if (this.getJugadoresCasilla().size()-1!=i)
                    jugadores+=" ,";
            }
            jugadores+="]";
            return"\tsalir: "+this.valor+",\n" +
                    "\tjugadores: "+jugadores;
        }
        else if(this.getNombreCasilla().equals("Parking")){
            String jugadores="[";
            int i;
            for (i=0;i<this.getJugadoresCasilla().size();i++) {
                jugadores+=this.getJugadoresCasilla().get(i).getNombre();
                if (this.getJugadoresCasilla().size()-1!=i)
                    jugadores+=" ,";
            }
            jugadores+="]";
            return "\tbote: "+this.valor+",\n" +
                    "\tjugadores: "+jugadores;
        }
        else
            return "No tiene sentido describir esta casilla\n";
    }

}
