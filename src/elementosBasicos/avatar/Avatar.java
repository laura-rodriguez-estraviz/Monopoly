package elementosBasicos.avatar;
import Excepciones.AccionInvalida;
import Excepciones.Eleccion;
import Excepciones.ErrorCritico;
import elementosBasicos.cartas.CartasCajaComunidad;
import elementosBasicos.cartas.CartasSuerte;
import elementosBasicos.casilla.*;
import juego.*;

//import juego.juego.getDados();

import java.util.Random;

 public abstract class Avatar {//abstract porque solo se instanciara coche o pelota
    private char avatar;
    private int ncasilla;
    private Casilla casilla;
    private String jugador;
    public char getAvatar() {
        return avatar;
    }
    //Getters

    public int getNcasilla() {
        return ncasilla;
    }

    public Casilla getCasilla() {
        return casilla;
    }

    public String getJugador() {
        return jugador;
    }

    //Setters
    public void setAvatar(char avatar) {
        this.avatar = avatar;
    }

    public void setNcasilla(int ncasilla) {
        this.ncasilla = ncasilla;
    }

    public void setCasilla(Casilla casilla) {
        this.casilla = casilla;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public Avatar(int ncasilla, Casilla casilla, String jugador) {
        Random r = new Random();
        this.avatar = (char)(r.nextInt(26) + 'A');
        this.ncasilla = ncasilla;
        this.casilla=casilla;
        this.jugador = jugador;
    }


    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Avatar avatar = (Avatar) obj;
        return (this.avatar==avatar.getAvatar());
    }

    public String toString() {
        return "{\n" +
                "\tid= " + avatar +"\n"+
                "\tcasilla= " + this.casilla.getNombreCasilla() + "\n" +
                "\tjugador= " + jugador + "\n" +
                '}';
    }

    void mover(Juego juego) throws Exception{
        int aux, i = 0;
        aux = ncasilla + juego.getDados().getValorTotal();//aux sera la casilla donde cae el jugador
        if (aux > 39) {
            juego.getListaJugadores().get(juego.getTurno()).setDinero(juego.getListaJugadores().get(juego.getTurno()).getDinero() + juego.getTablero().getSalida());
            aux = aux - 40;
            juego.getListaJugadores().get(juego.getTurno()).setVueltas(juego.getListaJugadores().get(juego.getTurno()).getVueltas()+1);
            juego.getListaJugadores().get(juego.getTurno()).setPasoCasillaSalida(juego.getListaJugadores().get(juego.getTurno()).getPasoCasillaSalida() + juego.getTablero().getSalida());


            if (juego.getListaJugadores().get(juego.getTurno()).getVueltas()>=4) {
                while (i < juego.getListaJugadores().size() && juego.getListaJugadores().get(i).getVueltas() >= 4+4* juego.getVeces4vueltas()) {
                    i += 1;
                }
                if (i == juego.getListaJugadores().size()) {
                    juego.setVeces4vueltas(juego.getVeces4vueltas()+1);
                    juego.getTablero().cuatroVueltas();
                }
            }
        }
        if (aux < 0){
            aux=40+aux;
            juego.getListaJugadores().get(juego.getTurno()).setVueltas(juego.getListaJugadores().get(juego.getTurno()).getVueltas()-1);
            juego.getListaJugadores().get(juego.getTurno()).setDinero(juego.getListaJugadores().get(juego.getTurno()).getDinero() - juego.getTablero().getSalida());
            juego.getListaJugadores().get(juego.getTurno()).setPasoCasillaSalida(juego.getListaJugadores().get(juego.getTurno()).getPasoCasillaSalida() - juego.getTablero().getSalida());



        }

        juego.getTablero().getTablero()[ncasilla].getCaerCasilla()[juego.getTurno()] += 1;//añado 1 al contador de veces que un avatar callo en una casilla
        Juego.consola.imprimir("\nEl avatar " + avatar + " avanza " + juego.getDados().getValorTotal() + " posiciones, desde " +
                juego.getTablero().getTablero()[ncasilla].getNombreCasilla() + " hasta " +
                juego.getTablero().getTablero()[aux].getNombreCasilla() + ".");
        //Me da medo cambiar esta parte, se hai problema pode ser esto
        juego.getTablero().getTablero()[ncasilla].getJugadoresCasilla().remove(juego.getListaJugadores().get(juego.getTurno()));//elimino al jugador de la casilla en la que estaba
        juego.getTablero().getTablero()[aux].getJugadoresCasilla().add(juego.getListaJugadores().get(juego.getTurno()));//añado el jugador a su nueva casilla
        ncasilla=aux;//actualizo ncasilla en el avatar para saber en que numero de casilla esta el avatar
        casilla=juego.getTablero().getTablero()[aux];//añado la casilla donde esta el jugador a avatar

        //Para un solar alquilado ou no
        if (juego.getTablero().getTablero()[aux].getClass().getSimpleName().equals("Solar")) {
            if (!((Solar)juego.getTablero().getTablero()[aux]).getPropietario().equals("Banca")) {
                //comprarPropiedad(juego.getTablero(),aux);
                //} else {   //Hai que mirar ben o alquiler dependendo do numero de casas

                for (i=0;i<((Solar)juego.getTablero().getTablero()[aux]).getNoPaga().size();i++){
                    if (((Solar)juego.getTablero().getTablero()[aux]).getNoPaga().get(i).getTurnos() < ((Solar)juego.getTablero().getTablero()[aux]).getTurnosNoPaga().get(i)){

                        if (((Solar)juego.getTablero().getTablero()[aux]).getNoPaga().get(i).getNombre().equals(juego.getListaJugadores().get(juego.getTurno()).getNombre())) {
                            Juego.consola.imprimir("No pagara el alquiler de acuerdo con lo pactado, aún dispone de " + (((Solar) juego.getTablero().getTablero()[aux]).getTurnosNoPaga().get(i) - ((Solar) juego.getTablero().getTablero()[aux]).getNoPaga().get(i).getTurnos()) + " turnos sin pagar");
                            return;
                        }
                    }
                    else{
                        ((Solar)juego.getTablero().getTablero()[aux]).getNoPaga().remove(i);
                        ((Solar)juego.getTablero().getTablero()[aux]).getTurnosNoPaga().remove(i);
                    }
                }
                float alquiler = ((Solar)juego.getTablero().getTablero()[aux]).alquiler();
                if (!juego.getListaJugadores().get(juego.getTurno()).getNombre().equals(((Solar)juego.getTablero().getTablero()[aux]).getPropietario()))
                {
                    for (i = 0; i < juego.getListaJugadores().size(); i++) {
                        if (juego.getListaJugadores().get(i).getNombre().equals(((Solar)juego.getTablero().getTablero()[aux]).getPropietario())) {
                            if (alquiler > juego.getListaJugadores().get(juego.getTurno()).getDinero()) {
                                Juego.consola.imprimir("El jugador " + juego.getListaJugadores().get(juego.getTurno()).getNombre() + " debe pagar " + alquiler + " a " + juego.getListaJugadores().get(i).getNombre());
                                juego.sinDinero(alquiler);
                            } else {
                                juego.getListaJugadores().get(i).setDinero(juego.getListaJugadores().get(i).getDinero() + alquiler);
                                juego.getListaJugadores().get(i).setCobroAlquileres(juego.getListaJugadores().get(i).getCobroAlquileres() + alquiler);
                                juego.getListaJugadores().get(juego.getTurno()).setDinero(juego.getListaJugadores().get(juego.getTurno()).getDinero() - alquiler);
                                juego.getListaJugadores().get(juego.getTurno()).setPagoAlquileres(juego.getListaJugadores().get(juego.getTurno()).getPagoAlquileres() + alquiler);

                                juego.getTablero().getTablero()[aux].setDineroObtenido(juego.getTablero().getTablero()[aux].getDineroObtenido() + alquiler);


                                Juego.consola.imprimir("El jugador " + juego.getListaJugadores().get(juego.getTurno()).getNombre() + " ha pagado " + alquiler + " a " + juego.getListaJugadores().get(i).getNombre());
                            }
                            break;
                        }
                    }
                }
            }
        }
        //cando caes en ir a la carcel
        else if (juego.getTablero().getTablero()[aux].getNombreCasilla().equals("IrCarcel")) { //Vas a casilla carcel e cambia o teu estado a carcel
            juego.irCarcel();
        }
        //cando caes en impuestos
        else if (juego.getTablero().getTablero()[aux].getClass().getSimpleName().equals("Impuesto")) {    //poñer que o pago dos impuestos sea valor ou alquiler, e sumalos ao valor/alquiler de parking
            if (juego.getListaJugadores().get(juego.getTurno()).getDinero() > ((Impuesto)juego.getTablero().getTablero()[aux]).getValor()) {
                juego.getListaJugadores().get(juego.getTurno()).setDinero(juego.getListaJugadores().get(juego.getTurno()).getDinero() - ((Impuesto)juego.getTablero().getTablero()[aux]).getValor());
                ((Especial)juego.getTablero().getTablero()[20]).setValor(((Especial)juego.getTablero().getTablero()[20]).getValor() + ((Impuesto)juego.getTablero().getTablero()[aux]).getValor());
                juego.getListaJugadores().get(juego.getTurno()).setPagoTasas(juego.getListaJugadores().get(juego.getTurno()).getPagoTasas() + ((Impuesto)juego.getTablero().getTablero()[aux]).getValor());
                Juego.consola.imprimir("El jugador paga " + ((Impuesto)juego.getTablero().getTablero()[aux]).getValor());
            } else {
                Juego.consola.imprimir("El jugador debe pagar " + ((Impuesto)juego.getTablero().getTablero()[aux]).getValor());
                juego.sinDinero(((Impuesto)juego.getTablero().getTablero()[aux]).getValor());
            }
        }
        //cando caes en parking
        else if (juego.getTablero().getTablero()[aux].getNombreCasilla().equals("Parking")) {
            juego.getListaJugadores().get(juego.getTurno()).setDinero(juego.getListaJugadores().get(juego.getTurno()).getDinero() + ((Especial)juego.getTablero().getTablero()[aux]).getValor());
            juego.getListaJugadores().get(juego.getTurno()).setPremiosBote(juego.getListaJugadores().get(juego.getTurno()).getPremiosBote() + ((Especial)juego.getTablero().getTablero()[aux]).getValor());
            Juego.consola.imprimir("El jugador " + juego.getListaJugadores().get(juego.getTurno()).getNombre() + " recibe " + ((Especial)juego.getTablero().getTablero()[aux]).getValor() + "€, el bote de la banca.");
            ((Especial)juego.getTablero().getTablero()[aux]).setValor(0);

        }
        //cando caes en servicios
        else if (juego.getTablero().getTablero()[aux].getClass().getSimpleName().equals("Servicio")) {
            if (((Servicio)juego.getTablero().getTablero()[aux]).getPropietario().equals("Banca")) {
                //comprarPropiedad(juego.getTablero(),aux);
            } else {
                for (i=0;i<((Propiedad)juego.getTablero().getTablero()[aux]).getNoPaga().size();i++){
                    if (((Propiedad)juego.getTablero().getTablero()[aux]).getNoPaga().get(i).getTurnos() < ((Propiedad)juego.getTablero().getTablero()[aux]).getTurnosNoPaga().get(i)){
                        if (((Propiedad)juego.getTablero().getTablero()[aux]).getNoPaga().get(i).getNombre().equals(juego.getListaJugadores().get(juego.getTurno()).getNombre())){
                            Juego.consola.imprimir("No pagara el alquiler de acuerdo con lo pactado, aún dispone de "+(((Propiedad)juego.getTablero().getTablero()[aux]).getTurnosNoPaga().get(i)-((Propiedad)juego.getTablero().getTablero()[aux]).getNoPaga().get(i).getTurnos())+" turnos sin pagar");
                            return;}
                    }
                    else{
                        ((Propiedad)juego.getTablero().getTablero()[aux]).getNoPaga().remove(i);
                        ((Propiedad)juego.getTablero().getTablero()[aux]).getTurnosNoPaga().remove(i);
                    }
                }
                juego.pagoServicios(aux);
            }
        }

        //cando caes en transporte
        else if (juego.getTablero().getTablero()[aux].getClass().getSimpleName().equals("Transporte"))
            if (((Transporte)juego.getTablero().getTablero()[aux]).getPropietario().equals("Banca")) {
                //comprarPropiedad(juego.getTablero(),aux);
            } else {
                for (i=0;i<((Propiedad)juego.getTablero().getTablero()[aux]).getNoPaga().size();i++){
                    if (((Propiedad)juego.getTablero().getTablero()[aux]).getNoPaga().get(i).getTurnos() < ((Propiedad)juego.getTablero().getTablero()[aux]).getTurnosNoPaga().get(i)){
                        if (((Propiedad)juego.getTablero().getTablero()[aux]).getNoPaga().get(i).getNombre().equals(juego.getListaJugadores().get(juego.getTurno()).getNombre())){
                            Juego.consola.imprimir("No pagara el alquiler de acuerdo con lo pactado, aún dispone de "+(((Propiedad)juego.getTablero().getTablero()[aux]).getTurnosNoPaga().get(i)-((Propiedad)juego.getTablero().getTablero()[aux]).getNoPaga().get(i).getTurnos())+" turnos sin pagar");
                            return;
                        }
                    }
                    else{
                        ((Propiedad)juego.getTablero().getTablero()[aux]).getNoPaga().remove(i);
                        ((Propiedad)juego.getTablero().getTablero()[aux]).getTurnosNoPaga().remove(i);
                    }
                }
                juego.pagoTransporte(aux);
            }


            //cando caes en suerte
        else if (juego.getTablero().getTablero()[aux].getClass().getSimpleName().equals("AccionSuerte")) {   //To be continued... en Capitalismo el Juego pte.2
            CartasSuerte suerte= new CartasSuerte();
            suerte.casillaSuerte(juego);
        }
        //cando caes en caja de comunidad
        else if (juego.getTablero().getTablero()[aux].getClass().getSimpleName().equals("AccionCajaComunidad")) {    //To be continued... en Capitalismo el Juego pte.2
            CartasCajaComunidad comunidad= new CartasCajaComunidad();
            comunidad.cajaComunidad(juego);
        }
    }

    public void moverAvanzado(Juego juego) throws Exception{
        if(!juego.isModoAvanzado()){
            mover(juego);
            return;
        }
        switch (this.getClass().getSimpleName()) {
            case "Pelota":
                Juego.consola.imprimir("Has sacado un "+juego.getDados().getValorTotal());
                int n = 5, m = 0, d = 0;
                if (juego.getDados().getValorTotal() > 4) {
                    m = juego.getDados().getValorTotal();
                    d = juego.getDados().getDobles();
                    juego.getDados().setValorTotal(n);
                    while (m >= n) {
                        //juego.getDados().setDobles(d);
                        mover(juego);
                        if(juego.getListaJugadores().get(juego.getTurno()).isEstarCarcel()){
                            break;
                        }
                        if (juego.getTablero().getTablero()[juego.getListaJugadores().get(juego.getTurno()).getAvatar().getNcasilla()] instanceof Propiedad)
                            ((Propiedad) (juego.getTablero().getTablero()[juego.getListaJugadores().get(juego.getTurno()).getAvatar().getNcasilla()])).comprarPropiedad(juego);
                        else Juego.consola.imprimir("Esta casilla no es una propiedad");
                        n += 2;
                        juego.getDados().setValorTotal(2);
                    }
                    if(juego.getListaJugadores().get(juego.getTurno()).isEstarCarcel()){
                        break;
                    }
                    if(m%2==0){
                        juego.getDados().setValorTotal(1);
                        mover(juego);
                        if (juego.getTablero().getTablero()[juego.getListaJugadores().get(juego.getTurno()).getAvatar().getNcasilla()] instanceof Propiedad)
                            ((Propiedad) (juego.getTablero().getTablero()[juego.getListaJugadores().get(juego.getTurno()).getAvatar().getNcasilla()])).comprarPropiedad(juego);
                        else Juego.consola.imprimir("Esta casilla no es una propiedad");
                    }
                }
                else {
                    juego.getDados().setValorTotal(-juego.getDados().getValorTotal());
                    mover(juego);
                }

                break;

            case "Coche":
                n = 0; d=juego.getDados().getDobles();
                int e;
                juego.setHaComprado(0);
                do{
                    if (juego.getDados().getValorTotal() > 4) {
                        mover(juego);
                        if(juego.getListaJugadores().get(juego.getTurno()).isEstarCarcel()){
                            break;
                        }
                        n++;
                        if(n>=4){
                            break;
                        }
                        do{
                            Juego.consola.imprimir("1. Comprar la casilla ("+(1- juego.getHaComprado())+" usos restantes)");
                            Juego.consola.imprimir("2. Construir un edificio");
                            Juego.consola.imprimir("3. Volver a tirar. Te quedan "+ (4-n) +" tiradas extra");
                            e= Integer.parseInt(Juego.consola.leer(null));
                            switch(e){
                                case 1:
                                    if (juego.getTablero().getTablero()[juego.getListaJugadores().get(juego.getTurno()).getAvatar().getNcasilla()] instanceof Propiedad)
                                        ((Propiedad) (juego.getTablero().getTablero()[juego.getListaJugadores().get(juego.getTurno()).getAvatar().getNcasilla()])).comprarPropiedad(juego);
                                    else Juego.consola.imprimir("Esta casilla no es una propiedad");
                                    break;
                                case 2:
                                    if(juego.getTablero().getTablero()[juego.getListaJugadores().get(juego.getTurno()).getAvatar().getNcasilla()].getClass().getSimpleName().equals("Solar"))
                                        ((Solar) (juego.getTablero().getTablero()[juego.getListaJugadores().get(juego.getTurno()).getAvatar().getNcasilla()])).construirEdificio(juego);
                                    else System.out.println("Esta casilla no es un solar");
                                    break;
                                case 3:

                                    break;
                                default:
                                    Juego.consola.imprimir("Opcion incorrecta");
                                    //break;
                            }
                        }while(e!=3);
                    }
                    else {
                        juego.getDados().setValorTotal(-juego.getDados().getValorTotal());
                        mover(juego);
                        juego.getListaJugadores().get(juego.getTurno()).setNoTurno(3);
                        n=4;
                    }//Debemos cambiar esto para a entrega final pero por ahora asi e mais comodo para todos

                    if(n<4){
                        juego.getDados().setDobles(1);
                        juego.getDados().dadosTrucados();
                    }
                }while(n<4);
                break;
            default:
                throw new ErrorCritico("El avatar de este jugador es desconocido", juego);

        }

        if(juego.isModoAvanzado()){
            juego.setWasModoAvanzado(true);
            juego.setModoAvanzado(false);
        }
        juego.setBlockModoAvanzado(true);
    }
}