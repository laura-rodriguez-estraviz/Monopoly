package elementosBasicos.edificios;

import elementosBasicos.casilla.Casilla;
import elementosBasicos.casilla.Propiedad;
import elementosBasicos.casilla.Solar;

abstract public class Edificio {//es una clase abstracta ya que nunca instancio un edificio directamente, sino que intsancio una casa etc
    private String id;
    private Propiedad propiedad;

    public Edificio(String id, Propiedad propiedad) {
        this.id = id;
        this.propiedad=propiedad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Casilla getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;
    }

}

