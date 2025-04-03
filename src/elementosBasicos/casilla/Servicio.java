package elementosBasicos.casilla;

import juego.*;

public final class Servicio extends Propiedad {//final porque no hay ninguna clase que herede de esta
    public Servicio(String propietario, float valor, float valorInicial, float alquiler, String nombreCasilla, String codigoColor, int numcasilla) {
        super(propietario, valor, valorInicial, alquiler, nombreCasilla, codigoColor,numcasilla);

    }

    public String toString() {
        return "{\n"+super.toString()+"\n}";

    }
    public float alquiler(){
        Dados dados = new Dados();
        dados.lanzarDados();
        float alquiler=0;

        if (((Servicio)Monopolio.juego.getTablero().getTablero()[12]).getPropietario().equals(((Servicio)Monopolio.juego.getTablero().getTablero()[28]).getPropietario())) {

            alquiler=this.getAlquiler() * dados.getValorTotal() * 10;

        } else
             alquiler=this.getAlquiler() * dados.getValorTotal() * 4;

        Juego.consola.imprimir("Lanza los dados para averiguar cuanto alquiler deberá pagar en la casilla de servicio.\n En los dados ha salido un " + dados.getValorTotal());

        return alquiler;
    }

}
