package elementosBasicos.edificios;

import elementosBasicos.casilla.Propiedad;
import elementosBasicos.casilla.Solar;
import elementosBasicos.edificios.Edificio;

final public class Hotel extends Edificio {//final porque no hay ninguna clase que herede de esta
    public Hotel(String id, Propiedad propiedad) {
        super(id, propiedad);
    }
    public String toString() {
        return "{\nid: " + this.getId() + "\n" +
                "propietario: " + ((Propiedad)this.getPropiedad()).getPropietario()+ "\n" +
                "casilla: " + this.getPropiedad().getNombreCasilla() + "\n" +
                "grupo: " + ((Solar)this.getPropiedad()).getGrupo() + "\n" +
                "coste: " + ((Solar)this.getPropiedad()).getValorHotel() + "\n}";
    }
}
