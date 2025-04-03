package elementosBasicos.casilla;
import elementosBasicos.casilla.Propiedad;
import juego.Juego;

import java.util.ArrayList;
final public class Grupo {//final porque no hay ninguna clase que herede de esta
    private String grupoCasilla;
    private ArrayList<Propiedad> propiedades;
    private boolean tieneGrupoColor;

    public String getGrupoCasilla() {
        return grupoCasilla;
    }

    public void setGrupoCasilla(String grupoCasilla) {
        this.grupoCasilla = grupoCasilla;
    }


    public ArrayList<Propiedad> getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(ArrayList<Propiedad> propiedades) {
        this.propiedades = propiedades;
    }

    public boolean isTieneGrupoColor(){
        return tieneGrupoColor;
    }

    public void setTieneGrupoColor(boolean tieneGrupoColor){
        this.tieneGrupoColor=tieneGrupoColor;
    }

    public Grupo(String grupoCasilla) {
        this.grupoCasilla = grupoCasilla;
        this.propiedades = new ArrayList<>();
        this.tieneGrupoColor=false;
    }


    public boolean grupoColorSinHipotecar(){
        int i;
        for (i=1;i< propiedades.size();i++) {
            if (propiedades.get(i).isHipotecado() == true)
                return false;
        }
        return true;
    }

    public void tieneGrupoColor(){
        int i;
        boolean isGrupoColor=true;
        for (i=1;i< propiedades.size();i++){
            if (!propiedades.get(0).getPropietario().equals(propiedades.get(i).getPropietario())){
                isGrupoColor=false;
            }
        }
        if (isGrupoColor){
            tieneGrupoColor=true;
        }
        else tieneGrupoColor=false;
    }

    public int edificiosGrupoColor(int vec[]){
        int i;
        vec[0]=0;
        vec[1]=0;
        vec[2]=0;
        vec[3]=0;
        for (i=0;i<propiedades.size();i++) {
            vec[0] += ((Solar)propiedades.get(i)).getCasas();
            vec[1] += ((Solar)propiedades.get(i)).getHoteles();
            vec[2] += ((Solar)propiedades.get(i)).getPiscinas();
            vec[3] += ((Solar)propiedades.get(i)).getPistasDeporte();
        }

        return propiedades.size();
    }


}
