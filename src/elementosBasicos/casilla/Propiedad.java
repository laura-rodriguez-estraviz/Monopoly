package elementosBasicos.casilla;

import Excepciones.AccionInvalida;
import elementosBasicos.Jugador;
import elementosBasicos.casilla.Casilla;
import juego.Juego;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract public class Propiedad extends Casilla {//es abstracta ya que siempre intsancio sus derivadas, nunca propiedad

    private String propietario;
    private float valor;
    private float valorInicial;
    private float alquiler;

    private float dineroObtenido;
    private boolean hipotecado;
    private List <Jugador> noPaga;
    private List <Integer> turnosNoPaga;


    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(float valorInicial) {
        this.valorInicial = valorInicial;
    }

    public float getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(float alquiler) {
        this.alquiler = alquiler;
    }

    public float getDineroObtenido() {
        return dineroObtenido;
    }

    public void setDineroObtenido(float dineroObtenido) {
        this.dineroObtenido = dineroObtenido;
    }

    public boolean isHipotecado() {
        return hipotecado;
    }

    public void setHipotecado(boolean hipotecado) {
        this.hipotecado = hipotecado;
    }

    public List<Jugador> getNoPaga() {
        return noPaga;
    }

    public void setNoPaga(List<Jugador> noPaga) {
        this.noPaga = noPaga;
    }

    public List<Integer> getTurnosNoPaga() {
        return turnosNoPaga;
    }

    public void setTurnosNoPaga(List<Integer> turnosNoPaga) {
        this.turnosNoPaga = turnosNoPaga;
    }

    public Propiedad(String propietario, float valor, float valorInicial, float alquiler, String nombreCasilla, String codigoColor, int numcasilla){
        super(nombreCasilla,codigoColor,numcasilla);
        this.propietario=propietario;
        this.valor=valor;
        this.valorInicial=valorInicial;
        this.alquiler=alquiler;
        this.dineroObtenido=0;
        this.hipotecado=false;
        this.noPaga= new ArrayList<>();
        this.turnosNoPaga=new ArrayList<>();

    }
    boolean perteneceAJugador(Jugador jugador){
        int i;
        if (propietario.equals(jugador.getNombre()))
            return true;
        return false;
    }

    public void comprarPropiedad(Juego juego) throws Exception{
        if (this.propietario.equals("Banca")) {
            Juego.consola.imprimir(this.toString());
            if((juego.isModoAvanzado()&&(juego.getListaJugadores().get(juego.getTurno()).getAvatar().getClass().getSimpleName().equals("Coche"))&&juego.getHaComprado()>0)||(juego.isWasModoAvanzado()&&(juego.getListaJugadores().get(juego.getTurno()).getAvatar().getClass().getSimpleName().equals("Coche")))){
                Juego.consola.imprimir("Ya ha comprado 1 vez, no podra hacerlo mas hasta que termine el turno");
                return;
            }
            int opt;

            do {
                opt = Integer.parseInt(Juego.consola.leer("Quiere comprarla? 1.Si  2.No"));
                if (opt == 1) {
                    if (juego.getListaJugadores().get(juego.getTurno()).getDinero() - this.getValor() > 0) {
                        juego.getListaJugadores().get(juego.getTurno()).setDinero(juego.getListaJugadores().get(juego.getTurno()).getDinero() - this.getValor());
                        juego.getListaJugadores().get(juego.getTurno()).setDineroInvertido(juego.getListaJugadores().get(juego.getTurno()).getDineroInvertido() + this.getValor());
                        Juego.consola.imprimir("Comprada correctamente");
                        juego.getListaJugadores().get(juego.getTurno()).getPropiedades().add(this);
                        juego.getListaJugadores().get(juego.getTurno()).setComprado(true);
                        this.propietario=juego.getListaJugadores().get(juego.getTurno()).getNombre();
                        juego.getBanca().getPropiedades().remove(this);
                        if (this.getClass().getSimpleName().equals("Solar")) {
                            ((Solar)this).getGrupo().tieneGrupoColor();
                        }
                        juego.setHaComprado(juego.getHaComprado()+1);


                    } else {
                        Juego.consola.imprimir("No tienes suficiente dinero");
                    }

                } else if (opt == 2) {
                    Juego.consola.imprimir("No sera comprada");
                } else {
                    Juego.consola.imprimir("Opcion no disponible");
                    }

            } while ((opt != 1) && (opt != 2));

        } else {
            Juego.consola.imprimir("Esta propiedad no está en venta");
        }
    }

    public String toString() {
        return "\ttipo: " + this.getClass().getSimpleName() + ",\n" +
                "\tvalor: " + this.getValor() + ",\n" +
                "\tpropietario: "+this.propietario;

    }


    public abstract float alquiler();
}
