package elementosBasicos.casilla;

import elementosBasicos.edificios.*;
import juego.Juego;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

final public class Solar extends Propiedad {//final porque no hay ninguna clase que herede de esta

    private float valorHotel;
    private float valorCasa;
    private float valorPiscina;
    private float valorPistaDeporte;
    final private float alquiler1Casa=5;
    final private float alquiler2Casas=15;
    final private float alquiler3Casas=35;
    final private float alquiler4Casas=50;
    final private float alquilerHotel=70;
    final private float alquilerPiscina=25;
    final private float alquilerPistaDeporte=25;
    private List<Edificio> edificios;
    private int casas;
    private int hoteles;
    private int piscinas;
    private int pistasDeporte;
    private Grupo grupo;
    static int idEdificio;
    public float getValorHotel() {
        return valorHotel;
    }

    public void setValorHotel(float valorHotel) {
        this.valorHotel = valorHotel;
    }

    public float getValorCasa() {
        return valorCasa;
    }

    public void setValorCasa(float valorCasa) {
        this.valorCasa = valorCasa;
    }

    public float getValorPiscina() {
        return valorPiscina;
    }

    public void setValorPiscina(float valorPiscina) {
        this.valorPiscina = valorPiscina;
    }

    public float getValorPistaDeporte() {
        return valorPistaDeporte;
    }

    public void setValorPistaDeporte(float valorPistaDeporte) {
        this.valorPistaDeporte = valorPistaDeporte;
    }

    public float getAlquiler1Casa() {
        return alquiler1Casa;
    }


    public float getAlquiler2Casas() {
        return alquiler2Casas;
    }


    public float getAlquiler3Casas() {
        return alquiler3Casas;
    }


    public float getAlquiler4Casas() {
        return alquiler4Casas;
    }


    public float getAlquilerHotel() {
        return alquilerHotel;
    }


    public float getAlquilerPiscina() {
        return alquilerPiscina;
    }


    public float getAlquilerPistaDeporte() {
        return alquilerPistaDeporte;
    }



    public List<Edificio> getEdificios() {
        return edificios;
    }

    public void setEdificios(List<Edificio> edificios) {
        this.edificios = edificios;
    }

    public int getCasas() {
        return casas;
    }

    public void setCasas(int casas) {
        this.casas = casas;
    }

    public int getHoteles() {
        return hoteles;
    }

    public void setHoteles(int hoteles) {
        this.hoteles = hoteles;
    }

    public int getPiscinas() {
        return piscinas;
    }

    public void setPiscinas(int piscinas) {
        this.piscinas = piscinas;
    }

    public int getPistasDeporte() {
        return pistasDeporte;
    }

    public void setPistasDeporte(int pistasDeporte) {
        this.pistasDeporte = pistasDeporte;
    }



    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Solar(String nombreCasilla,String codigoColor, String propietario, float valor, float valorInicial,float alquiler,
                 float valorHotel, float valorCasa, float valorPiscina, float valorPistaDeporte, int numcasilla,Grupo grupo) {
        super (propietario, valor,valorInicial,alquiler,nombreCasilla,codigoColor,numcasilla);
        this.valorHotel = valorHotel;
        this.valorCasa = valorCasa;
        this.valorPiscina = valorPiscina;
        this.valorPistaDeporte = valorPistaDeporte;
        this.edificios = new ArrayList<>();
        this.casas = 0;
        this.hoteles = 0;
        this.piscinas = 0;
        this.pistasDeporte = 0;
        this.grupo=grupo;
    }

    @Override
    public String toString(){
        String edificios="[";
        int j;
        for (j=0;j<this.edificios.size();j++) {
            edificios += this.edificios.get(j).getId();
            if (this.edificios.size()-1!=j)
                edificios+=" ,";
        }
        edificios+="]";

        return "{\n"+super.toString()+",\n"+
                "\tgrupo: " +this.grupo.getGrupoCasilla()+",\n"+
                "\talquiler: "+alquiler() +",\n"+
                "\tvalor hotel: "+valorHotel+",\n" +
                "\tvalor casa: "+valorCasa+",\n" +
                "\tvalor piscina: "+valorPiscina+",\n" +
                "\tvalor pista de deporte: "+valorPistaDeporte+",\n" +
                "\talquiler una casa: "+alquiler1Casa+",\n" +
                "\talquiler dos casas: "+alquiler2Casas+",\n" +
                "\talquiler tres casas: "+alquiler3Casas+",\n" +
                "\talquiler cuatro casas: "+alquiler4Casas+",\n" +
                "\talquiler hotel: "+alquilerHotel+",\n" +
                "\talquiler piscina: "+alquilerPiscina+",\n" +
                "\talquiler pista de deporte: "+alquilerPistaDeporte+",\n"+
                "\tedificios: "+edificios+"\n}";
    }

    //@Override
    /*public String toString() {
        return "Solar{" +
                "valorHotel=" + valorHotel +
                ", valorCasa=" + valorCasa +
                ", valorPiscina=" + valorPiscina +
                ", valorPistaDeporte=" + valorPistaDeporte +
                ", alquiler1Casa=" + alquiler1Casa +
                ", alquiler2Casas=" + alquiler2Casas +
                ", alquiler3Casas=" + alquiler3Casas +
                ", alquiler4Casas=" + alquiler4Casas +
                ", alquilerHotel=" + alquilerHotel +
                ", alquilerPiscina=" + alquilerPiscina +
                ", alquilerPistaDeporte=" + alquilerPistaDeporte +
                ", edificios=" + edificios +
                ", casas=" + casas +
                ", hoteles=" + hoteles +
                ", piscinas=" + piscinas +
                ", pistasDeporte=" + pistasDeporte +
                ", grupo=" + grupo +
                '}';
    }*/

    public float alquiler(){
        float alquiler=0;
        if (grupo.isTieneGrupoColor()) {
            alquiler = 2 * this.getAlquiler();
        } else
            alquiler = this.getAlquiler();
        alquiler += alquilerHotel * hoteles+ alquilerPiscina * piscinas + alquilerPistaDeporte* pistasDeporte;
        switch (casas) {
            case 1:
                alquiler += alquiler1Casa;
                break;
            case 2:
                alquiler += alquiler2Casas;
                break;
            case 3:
                alquiler += alquiler3Casas;
                break;
            case 4:
                alquiler += alquiler4Casas;
                break;
            default:
                break;
        }
        return alquiler;
    }








    public void construirEdificio(Juego juego) {
            if (this.getPropietario().equals(juego.getListaJugadores().get(juego.getTurno()).getNombre())) {
                if (!this.isHipotecado()) {
                    if (this.grupo.isTieneGrupoColor()&& this.grupo.grupoColorSinHipotecar()|| this.getCaerCasilla()[juego.getTurno()] > 2) {
                        int opt, i;
                        int casillasGrupo;
                        int[] vec = new int[4];
                        casillasGrupo = this.grupo.edificiosGrupoColor(vec);
                        opt = Integer.parseInt(Juego.consola.leer("Que tipo de edificio desea construir? 1.Casa 2.Hotel 3.Piscina 4.Pista de deporte"));
                        switch (opt) {
                            case 1://casa
                                if ((vec[1] < casillasGrupo && this.getCasas() < 4) || (vec[1] == casillasGrupo && vec[0] < casillasGrupo)) {
                                    if (juego.getListaJugadores().get(juego.getTurno()).getDinero() > this.getValorCasa()) {
                                        juego.getListaJugadores().get(juego.getTurno()).setDinero(juego.getListaJugadores().get(juego.getTurno()).getDinero() - this.getValorCasa());
                                        Edificio e = new Casa("casa-" + idEdificio, this);
                                        idEdificio += 1;
                                        edificios.add(e);
                                        casas++;
                                        Juego.consola.imprimir("Se ha construido " + e.getId() + " en " + this.getNombreCasilla());
                                    } else Juego.consola.imprimir("No tiene suficiente dinero!");
                                }else
                                    Juego.consola.imprimir("Ya tiene el numero maximo de casas, no puede construir mas.");
                                break;
                            case 2://hotel
                                if (vec[1] < casillasGrupo) {
                                    if (casas== 4) {
                                        if (vec[0] < 4 + casillasGrupo) {
                                            if (juego.getListaJugadores().get(juego.getTurno()).getDinero() > this.getValorHotel()) {
                                                juego.getListaJugadores().get(juego.getTurno()).setDinero(juego.getListaJugadores().get(juego.getTurno()).getDinero() - this.getValorHotel());
                                                Edificio e = new Hotel( "hotel-" + idEdificio, this);
                                                idEdificio += 1;
                                                edificios.add(e);
                                                hoteles++;
                                                for (i = 0; i < this.getEdificios().size(); i++) {
                                                    if (this.getEdificios().get(i).getClass().getSimpleName().equals("Casa")) {
                                                        this.getEdificios().remove(i);
                                                        i -= 1;
                                                    }
                                                }
                                                casas=0;
                                                Juego.consola.imprimir("Se ha construido " + e.getId() + " en " + this.getNombreCasilla());
                                            } else Juego.consola.imprimir("No tiene suficiente dinero!");
                                        } else
                                            Juego.consola.imprimir("Al construir el hotel superaria el numero maximo de casas, debera vender alguna de otro solar si quiere continuar.");
                                    } else
                                        Juego.consola.imprimir("No puedes construir un hotel sin tener antes 4 casas en el solar.");
                                } else
                                    Juego.consola.imprimir("Ya se ha alcanzado el numero maximo de hoteles por grupo de color.");
                                break;
                            case 3://piscina
                                if (vec[2] < casillasGrupo) {
                                    if (casas > 1 && hoteles > 0) {
                                        if (juego.getListaJugadores().get(juego.getTurno()).getDinero() > this.getValorPiscina()) {
                                            juego.getListaJugadores().get(juego.getTurno()).setDinero(juego.getListaJugadores().get(juego.getTurno()).getDinero() - this.getValorPiscina());
                                            Edificio e = new Piscina( "piscina-" + idEdificio,this);
                                            idEdificio += 1;
                                            edificios.add(e);
                                            piscinas++;
                                            Juego.consola.imprimir("Se ha construido " + e.getId() + " en " + this.getNombreCasilla());
                                        } else Juego.consola.imprimir("No tiene suficiente dinero!");
                                    } else
                                        Juego.consola.imprimir("No puede construir una piscina sin haber construido antes un hotel y dos casas en el solar.");
                                } else
                                    Juego.consola.imprimir("Ya se ha alcanzado el numero maximo de piscinas por grupo de color.");
                                break;
                            case 4:
                                if (vec[3] < casillasGrupo) {
                                    if (casas > 1) {
                                        if (juego.getListaJugadores().get(juego.getTurno()).getDinero() > this.getValorPistaDeporte()) {
                                            juego.getListaJugadores().get(juego.getTurno()).setDinero(juego.getListaJugadores().get(juego.getTurno()).getDinero() - this.getValorPistaDeporte());
                                            Edificio e = new PistaDeporte("pista de deporte-" + idEdificio,this);
                                            idEdificio += 1;
                                            edificios.add(e);
                                            pistasDeporte++;
                                            Juego.consola.imprimir("Se ha construido " + e.getId() + " en " + this.getNombreCasilla());
                                        } else Juego.consola.imprimir("No tiene suficiente dinero!");
                                    } else
                                        Juego.consola.imprimir("No puede construir una pista de deporte sin haber construido antes dos hoteles en el solar.");
                                } else
                                    Juego.consola.imprimir("Ya se ha alcanzado el numero maximo de pistas de deporte por grupo de color.");
                                break;
                            default:
                                Juego.consola.imprimir("Opción desconocida");
                                break;
                        }

                    } else
                        Juego.consola.imprimir("No puede construir en este solar, no posee todo el grupo de color sin hipotecar y aun no ha caido mas de dos veces en ella.");
                } else Juego.consola.imprimir("Esta propiedad está hipotecada! No puede construir aqui.");
            } else Juego.consola.imprimir("Esta casilla no es suya! No puede construir aqui.");

    }

}
