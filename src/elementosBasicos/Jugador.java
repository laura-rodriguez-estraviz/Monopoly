package elementosBasicos;

import elementosBasicos.avatar.Avatar;
import elementosBasicos.casilla.*;
import juego.*;
import Excepciones.*;
import java.util.List;
import java.util.ArrayList;

final public class Jugador {//final porque no hay ninguna clase que herede de esta

    //Atributos
    private String nombre;
    private float dinero;
    private boolean estarCarcel;
    private List <Casilla> propiedades;
    private List <Casilla> hipotecas;
    //private String edificios;
    private Avatar avatar;
    private int contadorCarcel;
    private boolean comprado;
    private boolean turnoEmpezado;

    private float dineroInvertido;
    private float pagoTasas;
    private float pagoAlquileres;
    private float cobroAlquileres;
    private float pasoCasillaSalida;
    private float premiosBote;
    private int vecesCarcel;
    private int vueltas;
    private int vecesDados;
    private int noTurno;
    private List <List <String>> tratos;
    private int turnos;


    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDinero(float dinero) {
        this.dinero = dinero;
    }

    public void setEstarCarcel(boolean estarCarcel) {
        this.estarCarcel = estarCarcel;
    }

    public void setPropiedades(List<Casilla> propiedades) {
        this.propiedades = propiedades;
    } //MODIFIQUEINO (ALEX)

    public void setHipotecas(List<Casilla> hipotecas) {
        this.hipotecas = hipotecas;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    //public void setEdificios(String edificios) {
        //this.edificios = edificios;
    //}

    public void setContadorCarcel(int contadorCarcel) {
        this.contadorCarcel = contadorCarcel;
    }


    public void setComprado(boolean comprado) {
        this.comprado = comprado;
    }

    public void setTurnoEmpezado(boolean turnoEmpezado) {
        this.turnoEmpezado = turnoEmpezado;
    }

    public void setDineroInvertido(float dineroInvertido) {
        this.dineroInvertido = dineroInvertido;
    }

    public void setPagoTasas(float pagoTasas) {
        this.pagoTasas = pagoTasas;
    }

    public void setPagoAlquileres(float pagoalquileres) {
        this.pagoAlquileres = pagoalquileres;
    }

    public void setCobroAlquileres(float cobroalquileres) {
        this.cobroAlquileres = cobroalquileres;
    }

    public void setPasoCasillaSalida(float pasoCasillaSalida) {
        this.pasoCasillaSalida = pasoCasillaSalida;
    }

    public void setPremiosBote(float premiosBote) {
        this.premiosBote = premiosBote;
    }

    public void setVecesCarcel(int vecesCarcel) {
        this.vecesCarcel = vecesCarcel;
    }

    public void setVueltas(int vueltas) {
        this.vueltas = vueltas;
    }

    public void setVecesDados(int vecesDados) {
        this.vecesDados = vecesDados;
    }

    public void setNoTurno(int noTurno) {
        this.noTurno = noTurno;
    }


    public void setTratos(List<List<String>> tratos) {
        this.tratos = tratos;
    }

    public void setTurnos(int turnos) {
        this.turnos = turnos;
    }

    public List<List<String>> getTratos() {
        return tratos;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public float getDinero() {
        return dinero;
    }

    public boolean isEstarCarcel() {
        return estarCarcel;
    }

    public List<Casilla> getPropiedades() {
        return propiedades;
    } //MODIFIQUEINO (ALEX)

    public List<Casilla> getHipotecas() {
        return hipotecas;
    }



    public Avatar getAvatar() {
        return avatar;
    }

    public int getContadorCarcel() {
        return contadorCarcel;
    }


    public boolean isComprado() {
        return comprado;
    }

    public boolean isTurnoEmpezado() {
        return turnoEmpezado;
    }

    public float getDineroInvertido() {
        return dineroInvertido;
    }

    public float getPagoTasas() {
        return pagoTasas;
    }

    public float getPagoAlquileres() {
        return pagoAlquileres;
    }

    public float getCobroAlquileres() {
        return cobroAlquileres;
    }

    public float getPasoCasillaSalida() {
        return pasoCasillaSalida;
    }

    public float getPremiosBote() {
        return premiosBote;
    }

    public int getVecesCarcel() {
        return vecesCarcel;
    }

    public int getVueltas() {
        return vueltas;
    }

    public int getVecesDados() {
        return vecesDados;
    }

    public int getNoTurno() {
        return noTurno;
    }

    public int getTurnos() {
        return turnos;
    }



    public Jugador(String nombre, float dinero, Avatar avatar) {
        this.nombre = nombre;
        this.dinero = dinero;
        //this.dinero = 12000;
        this.estarCarcel = false;
        this.propiedades = new ArrayList<>();
        this.hipotecas = new ArrayList<>();
        this.avatar = avatar;
        this.contadorCarcel=0;
        this.comprado=false;
        this.turnoEmpezado=false;
        this.dineroInvertido=0;
        this.pagoTasas=0;
        this.pagoAlquileres=0;
        this.cobroAlquileres=0;
        this.pasoCasillaSalida=0;
        this.premiosBote=0;
        this.vecesCarcel=0;
        this.vueltas=0;
        this.tratos=new ArrayList<>();
        this.turnos=0;
    }

    public Jugador(Tablero tablero){
        avatar=null;
        int i;
        this.nombre = "Banca";
        this.dinero = 0;
        this.estarCarcel = false;
        this.propiedades = new ArrayList<>();
        for (i=0;i<40;i++)
            if (tablero.getTablero()[i] instanceof Propiedad)
                this.propiedades.add(tablero.getTablero()[i]);
        this.hipotecas = null;
        this.avatar = avatar;
    }

/*
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Jugador jugador = (Jugador) obj;
        return (this.nombre==jugador.getNombre());
    }
*/

    public void listarPropiedadesVenta() {
        if (this.nombre.equals("Banca")) {

            int i;
            for (i = 0; i < this.propiedades.size(); i++) {
                if (this.getPropiedades().get(i).getClass().getSimpleName().equals("Solar")){
                    juego.Juego.consola.imprimir("{\n\ttipo: solar,\n" +
                            "\tgrupo: " + ((Solar)this.getPropiedades().get(i)).getGrupo().getGrupoCasilla() + ",\n" +
                            "\tvalor: " + ((Propiedad)this.getPropiedades().get(i)).getValor() + "\n}");
                } else
                    juego.Juego.consola.imprimir(this.getPropiedades().get(i).toString());

            }
        }
    }



    public String toString() {
        String propiedades="[";
        String edificios="[";
        String hipotecas="[";
        int i,j;
        for (i=0;i<this.propiedades.size();i++) {
            propiedades+=this.propiedades.get(i).getNombreCasilla();

            if (this.propiedades.get(i).getClass().getSimpleName().equals("Solar")) {
                for (j = 0; j < ((Solar) this.propiedades.get(i)).getEdificios().size(); j++) {
                    edificios += ((Solar) this.propiedades.get(i)).getEdificios().get(j).getId();
                    if (this.propiedades.size() - 1 != i || ((Solar) this.propiedades.get(i)).getEdificios().size() - 1 != j)
                        edificios += " ,";
                }
            }
            if (this.propiedades.size()-1!=i)
                propiedades+=" ,";
        }
        for (i=0;i<this.hipotecas.size();i++) {
            hipotecas+=this.hipotecas.get(i).getNombreCasilla();
            if (this.hipotecas.size()-1!=i)
                hipotecas+=" ,";
        }
        hipotecas+="]";
        propiedades+="]";
        edificios+="]";

        return  "{\n" +
                "\tnombre= " + nombre + '\n' +
                "\tfortuna= " + dinero +'\n' +
                "\tavatar= " + avatar.getAvatar() +'\n' +
                "\tpropiedades= " + propiedades +'\n' +
                "\thipotecas= " + hipotecas +'\n' +
                "\tedificios= " + edificios+'\n' +
                '}';
    }
    public void listarTratos() throws Exception{
        if (!Monopolio.juego.isEmpezado())
            throw new AccionInvalida("Aun no ha comenzado la partida\n", Monopolio.juego);//consola.imprimir("No puede jugar con menos de 2 jugadores.");



        for(int i=0; i<tratos.size();i++){
            switch(Integer.parseInt(tratos.get(i).get(1))){
                case 1:
                    Juego.consola.imprimir((i+1)+". Cambiar a "+tratos.get(i).get(0)+": dar "+tratos.get(i).get(3)+" por "+tratos.get(i).get(2));
                    break;
                case 2:
                    Juego.consola.imprimir((i+1)+". Cambiar a "+tratos.get(i).get(0)+": dar "+tratos.get(i).get(3)+" por "+tratos.get(i).get(2));
                    break;
                case 3:
                    Juego.consola.imprimir((i+1)+". Cambiar a "+tratos.get(i).get(0)+": dar "+tratos.get(i).get(3)+" por "+tratos.get(i).get(2));
                    break;
                case 4:
                    Juego.consola.imprimir((i+1)+". Cambiar a "+tratos.get(i).get(0)+": dar "+tratos.get(i).get(3)+" y "+tratos.get(i).get(4)+" por "+tratos.get(i).get(2));
                    break;
                case 5:
                    Juego.consola.imprimir((i+1)+". Cambiar a "+tratos.get(i).get(0)+": dar "+tratos.get(i).get(4)+" por "+tratos.get(i).get(2)+" y "+tratos.get(i).get(3));
                    break;
                case 6:
                    Juego.consola.imprimir((i+1)+". Cambiar a "+tratos.get(i).get(0)+": dar "+tratos.get(i).get(3)+" por "+tratos.get(i).get(2)+" y "+tratos.get(i).get(0)+" no paga el alquiler en "+tratos.get(i).get(4)+" por "+tratos.get(i).get(5)+" turnos");
                    break;
            }
        }
    }
}