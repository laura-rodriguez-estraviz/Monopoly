package juego;

import Excepciones.AccionInvalida;
import Excepciones.Lectura;
import Excepciones.Victoria;
import elementosBasicos.*;
import elementosBasicos.avatar.*;
import elementosBasicos.casilla.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

final public class Juego implements Comando {//final porque no hay ninguna clase que herede de esta
    private ArrayList<Jugador> listaJugadores;
    private int turno;
    private boolean empezado;
    private int veces4vueltas;

    private int haComprado;
    private boolean modoAvanzado;
    private boolean blockModoAvanzado;
    private boolean wasModoAvanzado;
    private Jugador banca;
    private String nombre;
    private char nombre2;
    private Tablero tablero;
    private Dados dados;
    public static ConsolaNormal consola;
    private int n; //Valor entero arbitrario

    //geters


    public List<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public int getTurno() {
        return turno;
    }

    public boolean isEmpezado() {
        return empezado;
    }

    public int getHaComprado() {
        return haComprado;
    }

    public boolean isModoAvanzado() {
        return modoAvanzado;
    }

    public boolean isBlockModoAvanzado() {
        return blockModoAvanzado;
    }

    public boolean isWasModoAvanzado() {
        return wasModoAvanzado;
    }

    public Jugador getBanca() {
        return banca;
    }

    public int getVeces4vueltas() {
        return veces4vueltas;
    }

    //seter
    public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }


    public void setEmpezado(boolean empezado) {
        this.empezado = empezado;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public void setHaComprado(int haComprado) {
        this.haComprado = haComprado;
    }

    public void setModoAvanzado(boolean modoAvanzado) {
        this.modoAvanzado = modoAvanzado;
    }

    public void setBlockModoAvanzado(boolean blockModoAvanzado) {
        this.blockModoAvanzado = blockModoAvanzado;
    }

    public void setWasModoAvanzado(boolean wasModoAvanzado) {
        this.wasModoAvanzado = wasModoAvanzado;
    }

    public void setVeces4vueltas(int veces4vueltas) {
        this.veces4vueltas = veces4vueltas;
    }

    public void setBanca(Jugador banca) {
        this.banca = banca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getNombre2() {
        return nombre2;
    }

    public void setNombre2(char nombre2) {
        this.nombre2 = nombre2;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public Dados getDados() {
        return dados;
    }

    public void setDados(Dados dados) {
        this.dados = dados;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    //Constructor
    public Juego() {
        this.turno = 0;
        this.empezado = false;
        this.listaJugadores = new ArrayList<>();
        this.veces4vueltas = 0;
        this.banca = banca;
        this.tablero = new Tablero();
        this.dados = new Dados();
        this.banca = new Jugador(tablero);
        this.consola = new ConsolaNormal();
    }


    //funciones
    public void anadirJugador() throws Exception {


        if (empezado == false) {//compruebo si el juego ha empezado
            if (listaJugadores.size() < 6) {//compruebo que no sobrepaso el maximo de jugadores
                String j = "", t;
                int i;
                boolean aux = true;
                //while (aux) {
                aux = false;
                i = 0;
                j = consola.leer("Escriba el nombre del jugador: ");
                while (aux == false && i < this.listaJugadores.size()) {
                    if (this.listaJugadores.get(i).getNombre().equals(j)) {
                        aux = true;
                        throw new Lectura("Ya hay un jugador con ese nombre", this);//consola.imprimir("Ya hay un jugador con ese nombre, por favor introduzca otro:");
                    } else
                        i += 1;
                }
                //}

                //do{
                t = consola.leer("Escriba el tipo de avatar (Pelota/Coche): ");
                if (t.equals("Coche")) {
                    Coche avatar = new Coche(0, tablero.getTablero()[0], j);
                    aux = true;
                    while (aux) {
                        aux = false;
                        i = 0;
                        while (aux == false && i < this.listaJugadores.size()) {
                            if (this.listaJugadores.get(i).getAvatar().equals(avatar)) {
                                avatar = new Coche(0, tablero.getTablero()[0], j);
                                aux = true;
                            } else
                                i += 1;
                        }
                    }
                    Jugador jugador = new Jugador(j, (float) 95430.61, avatar);
                    this.listaJugadores.add(jugador);
                    tablero.getTablero()[0].getJugadoresCasilla().add(jugador);
                } else if (t.equals("Pelota")) {
                    Pelota avatar = new Pelota(0, tablero.getTablero()[0], j);
                    aux = true;
                    while (aux) {
                        aux = false;
                        i = 0;
                        while (aux == false && i < this.listaJugadores.size()) {
                            if (this.listaJugadores.get(i).getAvatar().equals(avatar)) {
                                avatar = new Pelota(0, tablero.getTablero()[0], j);
                                aux = true;
                            } else
                                i += 1;
                        }
                    }
                    Jugador jugador = new Jugador(j, (float) 95430.61, avatar);
                    this.listaJugadores.add(jugador);
                    tablero.getTablero()[0].getJugadoresCasilla().add(jugador);
                } else {
                    throw new Lectura("Debe elegir Coche o Pelota", this);//consola.imprimirSimple("Ese valor es incorrecto. ");
                }
                //}while ((!t.equals("Coche")) && (!t.equals("Pelota")));


            } else {
                //consola.imprimir("No puede añadir mas jugadores, ya hay 6 jugando\n");
                throw new AccionInvalida("No puede añadir mas jugadores, ya hay 6 jugando\n", this);
            }
        } else {
            //consola.imprimir("Ya ha empezado el juego, no puede añadir un jugador ahora.");
            throw new AccionInvalida("Ya ha empezado el juego, no puede añadir un jugador ahora.", this);
        }

    }

    public void indicarTurno() throws Exception {
        if (listaJugadores.size() < 2)
            throw new AccionInvalida("No puede jugar con menos de 2 jugadores\n", this);//consola.imprimir("No puede jugar con menos de 2 jugadores.");
        else {
            consola.imprimir("{\n\tNombre: " + listaJugadores.get(turno).getNombre());
            consola.imprimir("\tAvatar: " + listaJugadores.get(turno).getAvatar().getAvatar() + "\n}");
        }
    }

    public void listarJugadores() {
        consola.imprimir("Jugadores:\n");
        for (int i = 0; i < listaJugadores.size(); i++)
            consola.imprimir(listaJugadores.get(i).toString());
    }

    public void listarAvatares() {
        consola.imprimir("Avatares:\n");
        for (int i = 0; i < listaJugadores.size(); i++)
            consola.imprimir(listaJugadores.get(i).getAvatar().toString());
    }

    public void lanzarDados() throws Exception {
        if (listaJugadores.size() < 2)
            throw new AccionInvalida("No se puede jugar con menos de 2 jugadores", this);//consola.imprimir("No puede jugar con menos de 2 jugadores.");
        else {
            if (this.empezado == false)//si el juego acaba de empezar cambio el valor que indica que ahora si esta empezado
                this.empezado = true;
            if (listaJugadores.get(turno).isTurnoEmpezado() == false)
                listaJugadores.get(turno).setTurnoEmpezado(true);
            if (!listaJugadores.get(turno).isEstarCarcel()) {//si no esta en la carcel
                if (dados.getDobles() > 0) {
                    dados.lanzarDados();
                    if (dados.getDobles() == 4) {
                        this.irCarcel();
                    } else
                        listaJugadores.get(turno).getAvatar().moverAvanzado(this);
                } else {
                    //consola.imprimir("Ya no puedes usar mas los dados");
                    throw new AccionInvalida("Ya no puedes usar mas los dados", this);

                }
            } else if (listaJugadores.get(turno).getContadorCarcel() < 3) {//si estas en la carcel, compruebo cuantas veces has intentado salir
                if (this.getDados().getDobles() >= 1) {
                    this.getDados().lanzarDados();

                    if (this.getDados().getDobles() >= 1) {
                        listaJugadores.get(turno).getAvatar().moverAvanzado(this);
                        listaJugadores.get(this.turno).setEstarCarcel(false);
                        listaJugadores.get(this.turno).setContadorCarcel(0);
                        consola.imprimir("Ha salido de la carcel.");
                    } else {
                        listaJugadores.get(this.turno).setContadorCarcel(listaJugadores.get(this.turno).getContadorCarcel() + 1);
                        if (listaJugadores.get(this.turno).getContadorCarcel() < 3)
                            consola.imprimir("Lástima, no has sacado dobles, sigue intentandolo.");
                        else
                            consola.imprimir("Lástima, no has sacado dobles, has agotado tus oportunidades, en la proxima tirada deberas salir pagando.");
                    }

                }
                throw new AccionInvalida("No puedes tirar", this);//else consola.imprimir("No puedes tirar.");

            } else {
                //consola.imprimir("Debe pagar para salir de la carcel, ya ha gastado sus tres oportunidades de sacar dobles.");
                throw new AccionInvalida("Debe pagar para salir de la carcel, ya ha gastado sus tres oportunidades de sacar dobles.", this);
            }
        }
    }

    public void acabarTurno() throws Exception {
        if (listaJugadores.size() < 2) {
            //consola.imprimir("No puede jugar con menos de 2 jugadores.");
            throw new AccionInvalida("No puede jugar con menos de 2 jugadores.", this);
        } else {
            if (dados.getDobles() == 0) {
                listaJugadores.get(turno).setTurnoEmpezado(false);
                listaJugadores.get(turno).setTurnos(listaJugadores.get(turno).getTurnos()+1);
                if ((getTurno() + 1) >= listaJugadores.size()) {
                    setTurno(0);
                } else {
                    setTurno(getTurno() + 1);
                }
                listaJugadores.get(turno).setNoTurno(listaJugadores.get(turno).getNoTurno() - 1);
                modoAvanzado = false;
                blockModoAvanzado = false;
                wasModoAvanzado = false;
                dados.setDobles(1);
                consola.imprimir("El jugador actual es " + getListaJugadores().get(getTurno()).getNombre() + ".");

            } else {
                //consola.imprimir("Aún no ha tirado.");
                throw new AccionInvalida("Aún no ha tirado.", this);
            }

        }
    }

    public void salirCarcel() throws Exception {
        if (listaJugadores.size() < 2)
            //consola.imprimir("No puede jugar con menos de 2 jugadores.");
            throw new AccionInvalida("No puede jugar con menos de 2 jugadores.", this);

        else {
            if (listaJugadores.get(turno).isEstarCarcel()) {
                int opt;
                do {
                    opt = Integer.parseInt(consola.leer("Desea pagar " + ((Especial) tablero.getTablero()[10]).getValor() + " para salir de la carcel 1.Si 2.No?"));
                    switch (opt) {
                        case 1:
                            if (listaJugadores.get(turno).getDinero() >= ((Especial) tablero.getTablero()[10]).getValor()) {
                                listaJugadores.get(turno).setDinero(listaJugadores.get(getTurno()).getDinero() - (((Especial) tablero.getTablero()[10]).getValor()));
                                //tablero.getTablero()[20].setValor(tablero.getTablero()[20].getValor()+tablero.getTablero()[10].getValor());
                                listaJugadores.get(turno).setDineroInvertido(listaJugadores.get(getTurno()).getDineroInvertido() + ((Especial) tablero.getTablero()[10]).getValor());
                                listaJugadores.get(turno).setContadorCarcel(0);
                                listaJugadores.get(turno).setEstarCarcel(false);
                                tablero.getTablero()[20].setDineroObtenido(tablero.getTablero()[20].getDineroObtenido() + (((Especial) tablero.getTablero()[20]).getValor()));

                                consola.imprimir("Ha salido de la carcel.");
                            } else {
                                throw new AccionInvalida("No tienes suficiente dinero.", this);//consola.imprimir("No tienes suficiente dinero.");

                            }
                            break;
                        case 2:
                            consola.imprimir("No saldra de la carcel.");
                            break;
                        default:
                            Juego.consola.imprimir("Opcion no disponible");
                    }

                } while (opt != 1 && opt != 2);
            } else
                throw new AccionInvalida("No estás en la cárcel!", this);//consola.imprimir("No estas en la carcel!");
        }
    }

    public void describirCasilla() throws Exception {
        nombre = consola.leer("Que casilla desea describir?");
        tablero.describirCasilla(nombre);
    }


    public void describirJugador() throws Exception {

        if (listaJugadores.size() == 0)
            throw new AccionInvalida("No hay nadie jugando todavía", this);//consola.imprimir("No hay nadie jugando todavia.");
        else {
            nombre = consola.leer("Que jugador desea describir?");
            int i = 0;
            while (i < this.getListaJugadores().size() && !this.listaJugadores.get(i).getNombre().equals(nombre))
                i++;
            if (i < this.getListaJugadores().size() && this.listaJugadores.get(i).getNombre().equals(nombre))
                consola.imprimir(this.listaJugadores.get(i).toString());
            else
                throw new AccionInvalida("Ese jugador no existe.", this);//consola.imprimir("El jugador no existe");
        }
    }

    public void describirAvatar() throws Exception {
        if (listaJugadores.size() == 0)
            throw new AccionInvalida("No hay nadie jugando todavía.", this);//consola.imprimir("No hay nadie jugando todabia.");
        else {
            nombre2 = consola.leer("Que avatar desea describir?").toCharArray()[0];//cambiar para char
            int i = 0;
            while (i < this.getListaJugadores().size() && this.listaJugadores.get(i).getAvatar().getAvatar() != nombre2)
                i++;
            if (i < this.getListaJugadores().size() && this.listaJugadores.get(i).getAvatar().getAvatar() == nombre2)
                consola.imprimir(this.listaJugadores.get(i).getAvatar().toString());
            else
                throw new AccionInvalida("Ese avatar no existe.", this);//consola.imprimir("El avatar no existe");
        }
    }

    public void comprarPropiedad() throws Exception {
        if (listaJugadores.size() < 2)
            throw new AccionInvalida("No puede jugar con menos de 2 jugadores.", this);//consola.imprimir("No puede jugar con menos de 2 jugadores.");
        else {
            if (listaJugadores.get(turno).isTurnoEmpezado()) {
                if (tablero.getTablero()[listaJugadores.get(turno).getAvatar().getNcasilla()] instanceof Propiedad) {
                    if (!(listaJugadores.get(turno).getNoTurno() > 0)) {
                        ((Propiedad) (tablero.getTablero()[listaJugadores.get(turno).getAvatar().getNcasilla()])).comprarPropiedad(this);
                    }
                    } else
                        throw new AccionInvalida("Esta casilla no es una propiedad.", this);//consola.imprimir("Esta casilla no es una propiedad");
            } else
                throw new AccionInvalida("Aún no ha tirado.", this);//Juego.consola.imprimir("Aún no ha tirado.");
        }
    }

    public void listarPropiedadesVenta() {
        banca.listarPropiedadesVenta();
    }

    public void verTablero() {
        consola.imprimir(getTablero().toString());
    }


    public void construirEdificio() throws Exception {
        if (listaJugadores.size() < 2)
            throw new AccionInvalida("No puede jugar con menos de 2 jugadores.", this);//Juego.consola.imprimir("No puede jugar con menos de 2 jugadores.");
        else {
            if (listaJugadores.get(turno).isTurnoEmpezado()) {
                if (tablero.getTablero()[listaJugadores.get(turno).getAvatar().getNcasilla()].getClass().getSimpleName().equals("Solar")) {
                    ((Solar) (tablero.getTablero()[listaJugadores.get(turno).getAvatar().getNcasilla()])).construirEdificio(this);
                } else
                    throw new AccionInvalida("Esta casilla no es un solar.", this);//Juego.consola.imprimir("Esta casilla no es un solar! No puede construir aqui.");
            } else
                throw new AccionInvalida("Aun no ha tirado.", this);//Juego.consola.imprimir("Aún no ha tirado.");
        }
    }

    public void listarEdificios() {
        tablero.listar_edificios();
    }

    public void listarEdificiosGrupo() {
        nombre = Juego.consola.leer("De que grupo le gustaria listar los edificios?");
        tablero.listar_edificios_grupo(nombre);
    }

    public void estadisticasJugadores()   //pdte dinero invertido en edificios
    {
        for (int i = 0; i < listaJugadores.size(); i++) {
            consola.imprimir(listaJugadores.get(i).getNombre());
            consola.imprimir("{\n" +
                    "\tdineroInvertido= " + listaJugadores.get(i).getDineroInvertido() + '\n' +
                    "\tpagoTasas= " + listaJugadores.get(i).getPagoTasas() + '\n' +
                    "\tpagoAlquileres= " + listaJugadores.get(i).getPagoAlquileres() + '\n' +
                    "\tcobroAlquileres= " + listaJugadores.get(i).getCobroAlquileres() + '\n' +
                    "\tpasoCasillaSalida= " + listaJugadores.get(i).getPasoCasillaSalida() + '\n' +
                    "\tpremiosBote= " + listaJugadores.get(i).getPremiosBote() + '\n' +
                    "\tvecesCarcel= " + listaJugadores.get(i).getVecesCarcel() + '\n' +
                    '}');
        }
    }

    public void estadisticasPartida() {
        consola.imprimir("{");
        casillaMasRentable();
        grupoMasRentable();
        casillaMasFrecuentada();
        jugadorMasVueltas();
        jugadorMasVecesDados();
        jugadorEnCabeza();
        consola.imprimir("}\n");
    }

    public void venderEdificio() throws Exception {
        if (empezado == false) {
            throw new AccionInvalida("El juego aun no ha empezado.", this);//Juego.consola.imprimir("El juego aún no ha empezado");
        } else {
            tablero.venderEdificio(this);
        }
    }

    public void hipotecar() throws Exception {
        if (empezado == false) {
            consola.imprimir("El juego aún no ha empezado");
        } else {
            tablero.hipotecar(this);
        }
    }

    public void deshipotecar() throws Exception {
        if (empezado == false) {
            consola.imprimir("El juego aún no ha empezado");
        } else {
            tablero.deshipotecar(this);
        }
    }

    public void declararseBancarrota() throws Exception {
        if (empezado == false) {
            consola.imprimir("El juego aún no ha empezado");
        } else {
            bancarrota(true);
        }
    }

    public void switchModoAvanzado() throws Exception {

        if (listaJugadores.size() < 2)
            Juego.consola.imprimir("No puede jugar con menos de 2 jugadores.");
        else {
            if (!blockModoAvanzado) {
                if (modoAvanzado == false) {
                    modoAvanzado = true;
                    consola.imprimirSimple("Modo avanzado activado durante este turno\n");
                } else {
                    modoAvanzado = false;
                    consola.imprimirSimple("Modo avanzado desactivado\n");
                }
            } else
                throw new AccionInvalida("El modo avanzado está bloqueado.", this);//consola.imprimirSimple("El modo avanzado ha sido bloqueado\n");

        }
    }


    public void lanzarDadosTrucados() throws Exception {
        if (listaJugadores.size() < 2)
            throw new AccionInvalida("No puede jugar con menos de 2 jugadores.", this);//Juego.consola.imprimir("No puede jugar con menos de 2 jugadores.");
        else {
            if (this.isEmpezado() == false)//si el juego acaba de empezar cambio el valor que indica que ahora si esta empezado
                this.setEmpezado(true);
            if (this.getListaJugadores().get(this.getTurno()).isTurnoEmpezado() == false)
                this.getListaJugadores().get(this.getTurno()).setTurnoEmpezado(true);
            if (!this.getListaJugadores().get(this.getTurno()).isEstarCarcel()) {//si no esta en la carcel
                if (this.getDados().getDobles() > 0) {
                    this.getDados().dadosTrucados();
                    if (this.getDados().getDobles() == 4) {
                        this.irCarcel();
                    } else
                        this.getListaJugadores().get(this.getTurno()).getAvatar().moverAvanzado(this);
                } else {
                    throw new AccionInvalida("Ya no puedes lanzar los dados.", this);//Juego.consola.imprimir("Ya no puedes usar mas los dados");
                }
            } else if (this.getListaJugadores().get(this.getTurno()).getContadorCarcel() < 3) {//si estas en la carcel, compruebo cuantas veces has intentado salir
                if (this.getDados().getDobles() >= 1) {
                    this.getDados().dadosTrucados();
                    if (this.getDados().getDobles() >= 1) {
                        this.getListaJugadores().get(this.getTurno()).getAvatar().moverAvanzado(this);
                        this.getListaJugadores().get(this.getTurno()).setEstarCarcel(false);
                        this.getListaJugadores().get(this.getTurno()).setContadorCarcel(0);
                        Juego.consola.imprimir("Ha salido de la carcel.");
                    } else {
                        this.getListaJugadores().get(this.getTurno()).setContadorCarcel(this.getListaJugadores().get(this.getTurno()).getContadorCarcel() + 1);
                        if (this.getListaJugadores().get(this.getTurno()).getContadorCarcel() < 3)
                            Juego.consola.imprimir("Lástima, no has sacado dobles, sigue intentandolo.");
                        else
                            Juego.consola.imprimir("Lástima, no has sacado dobles, has agotado tus oportunidades, en la proxima tirada deberas salir pagando.");
                    }
                } else throw new AccionInvalida("No puedes tirar.", this);//Juego.consola.imprimir("No puedes tirar.");

            } else {
                throw new AccionInvalida("Debe pagar para salir de la carcel, ya ha gastado sus tres oportunidades de sacar dobles.", this);//Juego.consola.imprimir("Debe pagar para salir de la carcel, ya ha gastado sus tres oportunidades de sacar dobles.");
            }
        }
    }


    public void irCarcel() {
        listaJugadores.get(getTurno()).setEstarCarcel(true);
        listaJugadores.get(getTurno()).setVecesCarcel(listaJugadores.get(getTurno()).getVecesCarcel() + 1);
        tablero.getTablero()[listaJugadores.get(getTurno()).getAvatar().getNcasilla()].getJugadoresCasilla().remove(this.listaJugadores.get(this.getTurno()));//elimino al jugador de la casilla en la que estaba
        tablero.getTablero()[10].getJugadoresCasilla().add(this.listaJugadores.get(this.getTurno()));//añado el jugador a su nueva casilla
        listaJugadores.get(getTurno()).getAvatar().setNcasilla(10);//actualizo ncasilla en el avatar para saber en que numero de casilla esta el avatar
        listaJugadores.get(getTurno()).getAvatar().setCasilla(tablero.getTablero()[10]);//añado la casilla donde esta el jugador a avatar
        dados.setDobles(0);

        consola.imprimir("Mala suete!\nEl jugador " + listaJugadores.get(getTurno()).getNombre() + " se ha movido a la Carcel sin pasar por la casilla de salida.");
    }


    public void pagoServicios(int aux) throws Exception {
        float alquiler = ((Servicio) tablero.getTablero()[aux]).alquiler();
        for (int i = 0; i < listaJugadores.size(); i++) {
            if (listaJugadores.get(i).getNombre().equals(((Servicio) tablero.getTablero()[aux]).getPropietario())) {
                if (alquiler > listaJugadores.get(turno).getDinero()) {
                    consola.imprimir("El jugador " + listaJugadores.get(turno).getNombre() + " debe pagar " + alquiler + " a " + listaJugadores.get(i).getNombre());
                    sinDinero(alquiler);
                } else {
                    listaJugadores.get(i).setDinero(listaJugadores.get(i).getDinero() + alquiler);
                    listaJugadores.get(i).setCobroAlquileres(listaJugadores.get(i).getCobroAlquileres() + alquiler);
                    this.listaJugadores.get(aux).setDinero(listaJugadores.get(aux).getDinero() - alquiler);
                    this.listaJugadores.get(aux).setPagoAlquileres(listaJugadores.get(aux).getPagoAlquileres() + alquiler);

                    tablero.getTablero()[aux].setDineroObtenido(tablero.getTablero()[aux].getDineroObtenido() + alquiler);


                    consola.imprimir("El jugador " + listaJugadores.get(turno).getNombre() + " ha pagado " + alquiler + " a " + listaJugadores.get(i).getNombre());
                }
                break;
            }
        }
    }

    public void pagoTransporte(int aux) throws Exception {
        float alquiler = ((Transporte) tablero.getTablero()[aux]).alquiler();

        for (int i = 0; i < listaJugadores.size(); i++) {
            if (listaJugadores.get(i).getNombre().equals(((Transporte) tablero.getTablero()[aux]).getPropietario())) {
                if (alquiler > listaJugadores.get(turno).getDinero()) {
                    consola.imprimir("El jugador " + listaJugadores.get(turno).getNombre() + " debe pagar " + alquiler + " a " + listaJugadores.get(i).getNombre());
                    sinDinero(alquiler);
                } else {
                    listaJugadores.get(i).setDinero(listaJugadores.get(i).getDinero() + alquiler);
                    listaJugadores.get(i).setCobroAlquileres(listaJugadores.get(i).getCobroAlquileres() + alquiler);
                    this.listaJugadores.get(turno).setDinero(listaJugadores.get(turno).getDinero() - alquiler);
                    this.listaJugadores.get(turno).setPagoAlquileres(listaJugadores.get(turno).getPagoAlquileres() + alquiler);
                    tablero.getTablero()[aux].setDineroObtenido(tablero.getTablero()[aux].getDineroObtenido() + alquiler);

                    consola.imprimir("El jugador " + listaJugadores.get(turno).getNombre() + " ha pagado " + alquiler + " a " + listaJugadores.get(i).getNombre());
                }
                break;
            }


        }
    }


    public void casillaMasRentable() {
        float max = 0;
        int imax = 0;
        for (int i = 0; i < 40; i++) {
            if (max < tablero.getTablero()[i].getDineroObtenido()) {
                max = tablero.getTablero()[i].getDineroObtenido();
                imax = i;
            }
        }
        if (max > 0) {
            consola.imprimir("casillaMasRentable= " + tablero.getTablero()[imax].getNombreCasilla());
        } else consola.imprimir("casillaMasRentable= No hay todavia");

    }

    public void grupoMasRentable() {
        float max = 0, aux = 0;
        String grupo = "No hay todavia";
        if (max < tablero.getTablero()[1].getDineroObtenido() + tablero.getTablero()[3].getDineroObtenido()) {
            max = tablero.getTablero()[1].getDineroObtenido() + tablero.getTablero()[3].getDineroObtenido();
            grupo = "marron";
        }
        if (max < tablero.getTablero()[11].getDineroObtenido() + tablero.getTablero()[13].getDineroObtenido() + tablero.getTablero()[14].getDineroObtenido()) {
            max = tablero.getTablero()[11].getDineroObtenido() + tablero.getTablero()[13].getDineroObtenido() + tablero.getTablero()[14].getDineroObtenido();
            grupo = "rosa";
        }
        if (max < tablero.getTablero()[16].getDineroObtenido() + tablero.getTablero()[18].getDineroObtenido() + tablero.getTablero()[19].getDineroObtenido()) {
            max = tablero.getTablero()[16].getDineroObtenido() + tablero.getTablero()[18].getDineroObtenido() + tablero.getTablero()[19].getDineroObtenido();
            grupo = "naranja";
        }
        if (max < tablero.getTablero()[21].getDineroObtenido() + tablero.getTablero()[23].getDineroObtenido() + tablero.getTablero()[24].getDineroObtenido()) {
            max = tablero.getTablero()[21].getDineroObtenido() + tablero.getTablero()[23].getDineroObtenido() + tablero.getTablero()[24].getDineroObtenido();
            grupo = "rojo";
        }
        if (max < tablero.getTablero()[26].getDineroObtenido() + tablero.getTablero()[27].getDineroObtenido() + tablero.getTablero()[29].getDineroObtenido()) {
            max = tablero.getTablero()[26].getDineroObtenido() + tablero.getTablero()[27].getDineroObtenido() + tablero.getTablero()[29].getDineroObtenido();
            grupo = "amarillo";
        }
        if (max < tablero.getTablero()[31].getDineroObtenido() + tablero.getTablero()[32].getDineroObtenido() + tablero.getTablero()[34].getDineroObtenido()) {
            max = tablero.getTablero()[31].getDineroObtenido() + tablero.getTablero()[32].getDineroObtenido() + tablero.getTablero()[34].getDineroObtenido();
            grupo = "verde";
        }
        if (max < tablero.getTablero()[37].getDineroObtenido() + tablero.getTablero()[39].getDineroObtenido()) {
            max = tablero.getTablero()[37].getDineroObtenido() + tablero.getTablero()[39].getDineroObtenido();
            grupo = "azul oscuro";
        }
        consola.imprimir("grupoMasRentable= " + grupo);
    }

    public void casillaMasFrecuentada() {
        int max = 0, aux = 0;

        int imax = 0;
        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < listaJugadores.size(); j++) {
                aux += tablero.getTablero()[i].getCaerCasilla()[j];
            }
            if (max < aux) {
                max = aux;
                imax = i;
            }
        }
        if (max > 0) {
            consola.imprimir("casillaMasFrecuentada= " + tablero.getTablero()[imax].getNombreCasilla());
        } else consola.imprimir("casillaMasRentable= No hay todavia");
    }

    public void jugadorMasVueltas() {
        int max = 0;
        for (int i = 0; i < listaJugadores.size(); i++) {
            if (max < listaJugadores.get(i).getVueltas()) {
                max = listaJugadores.get(i).getVueltas();
            }
        }
        consola.imprimirSimple("jugadorMasVueltas= ");
        for (int i = 0; i < listaJugadores.size(); i++) {
            if (max == listaJugadores.get(i).getVueltas()) {
                consola.imprimirSimple(listaJugadores.get(i).getNombre() + " ");
            }
        }
        consola.imprimirSimple("\n");
    }

    public void jugadorMasVecesDados() {
        int max = 0;
        for (int i = 0; i < listaJugadores.size(); i++) {
            if (max < listaJugadores.get(i).getVecesDados()) {
                max = listaJugadores.get(i).getVecesDados();
            }
        }
        consola.imprimirSimple("jugadorMasVecesDados= ");
        for (int i = 0; i < listaJugadores.size(); i++) {
            if (max == listaJugadores.get(i).getVecesDados()) {
                consola.imprimirSimple(listaJugadores.get(i).getNombre() + " ");
            }
        }
        consola.imprimirSimple("\n");
    }


    public void jugadorEnCabeza() {
        float max = 0;
        for (int i = 0; i < listaJugadores.size(); i++) {
            if (max < listaJugadores.get(i).getDinero()) {
                max = listaJugadores.get(i).getDinero();
            }
        }
        consola.imprimirSimple("jugadorEnCabeza= ");
        for (int i = 0; i < listaJugadores.size(); i++) {
            if (max == listaJugadores.get(i).getDinero()) {
                consola.imprimirSimple(listaJugadores.get(i).getNombre() + " ");
            }
        }
        consola.imprimirSimple("\n");
    }


    public void bancarrota(boolean bancarrotaInducida) throws Exception {
        int i, j;
        if (!bancarrotaInducida && tablero.getTablero()[this.listaJugadores.get(turno).getAvatar().getNcasilla()] instanceof Propiedad) {
            //todo pasa a un jugador
            i = 0;
            while (!listaJugadores.get(i).getNombre().equals(((Propiedad) tablero.getTablero()[this.listaJugadores.get(turno).getAvatar().getNcasilla()]).getPropietario())) {
                i++;
            }
            for (j = 0; j < this.listaJugadores.get(turno).getPropiedades().size(); j++) {
                listaJugadores.get(i).getPropiedades().add(listaJugadores.get(getTurno()).getPropiedades().get(j));
                ((Propiedad) listaJugadores.get(getTurno()).getPropiedades().get(j)).setPropietario(listaJugadores.get(i).getNombre());
                if (listaJugadores.get(getTurno()).getPropiedades().get(j).getClass().getSimpleName().equals("Solar")) {
                    ((Solar) listaJugadores.get(getTurno()).getPropiedades().get(j)).getGrupo().tieneGrupoColor();
                }
            }
            for (j = 0; j < this.listaJugadores.get(turno).getHipotecas().size(); j++) {
                listaJugadores.get(i).getHipotecas().add(listaJugadores.get(getTurno()).getHipotecas().get(j));
                ((Propiedad) listaJugadores.get(getTurno()).getHipotecas().get(j)).setPropietario(listaJugadores.get(i).getNombre());
                if (listaJugadores.get(getTurno()).getHipotecas().get(j).getClass().getSimpleName().equals("Solar")) {
                    ((Solar) listaJugadores.get(getTurno()).getHipotecas().get(j)).getGrupo().tieneGrupoColor();
                }
            }
            consola.imprimir(listaJugadores.get(turno).getNombre() + " se retira de la partida, pasando todas sus propiedades a " + listaJugadores.get(i).getNombre());
            listaJugadores.get(i).setDinero(listaJugadores.get(i).getDinero() + listaJugadores.get(turno).getDinero());
            tablero.getTablero()[listaJugadores.get(turno).getAvatar().getNcasilla()].getJugadoresCasilla().remove(listaJugadores.get(turno));
            listaJugadores.remove(turno);
            if (turno == 0) {
                turno = listaJugadores.size() - 1;
            } else turno--;
            if (listaJugadores.size() == 1) {
                throw new Victoria(null, this);
            }
            dados.setDobles(1);
            acabarTurno();
        } else {
            //todo pasa para la banca
            for (j = 0; j < this.listaJugadores.get(turno).getPropiedades().size(); j++) {
                banca.getPropiedades().add(listaJugadores.get(getTurno()).getPropiedades().get(j));
                ((Propiedad) listaJugadores.get(getTurno()).getPropiedades().get(j)).setPropietario("Banca");
                if (listaJugadores.get(getTurno()).getPropiedades().get(j).getClass().getSimpleName().equals("Solar")) {
                    ((Solar) listaJugadores.get(getTurno()).getPropiedades().get(j)).setHoteles(0);
                    ((Solar) listaJugadores.get(getTurno()).getPropiedades().get(j)).setPistasDeporte(0);
                    ((Solar) listaJugadores.get(getTurno()).getPropiedades().get(j)).setPiscinas(0);
                    ((Solar) listaJugadores.get(getTurno()).getPropiedades().get(j)).setCasas(0);
                    ((Solar) listaJugadores.get(getTurno()).getPropiedades().get(j)).getEdificios().clear();
                    ((Solar) listaJugadores.get(getTurno()).getPropiedades().get(j)).getGrupo().setTieneGrupoColor(false);
                }
            }
            for (j = 0; j < this.listaJugadores.get(turno).getHipotecas().size(); j++) {
                ((Propiedad) listaJugadores.get(getTurno()).getHipotecas().get(j)).setHipotecado(false);
                ((Propiedad) listaJugadores.get(getTurno()).getHipotecas().get(j)).setPropietario("Banca");
                if (listaJugadores.get(getTurno()).getHipotecas().get(j).getClass().getSimpleName().equals("Solar")) {
                    ((Solar) listaJugadores.get(getTurno()).getHipotecas().get(j)).getGrupo().setTieneGrupoColor(false);
                }
                banca.getPropiedades().add(listaJugadores.get(getTurno()).getHipotecas().get(j));
            }
            consola.imprimir(listaJugadores.get(turno).getNombre() + " se retira de la partida, pasando todas sus propiedades a la banca, de manera que vuelven a estar a la venta.");
            tablero.getTablero()[listaJugadores.get(turno).getAvatar().getNcasilla()].getJugadoresCasilla().remove(listaJugadores.get(turno));
            listaJugadores.remove(turno);
            if (turno == 0) {
                turno = listaJugadores.size() - 1;
            } else turno--;
            if (listaJugadores.size() == 1) {
                throw new Victoria(null, this);
            }
            dados.setDobles(1);
            acabarTurno();
        }


    }

    public void sinDinero(float deuda) throws Exception {
        int a = 0;
        while (this.listaJugadores.get(this.getTurno()).getDinero() < deuda && a != 3) {
            a = Integer.parseInt(Juego.consola.leer("No tiene dinero suficiente para pagar, elija una de las siguientes opciones:\n" +
                    "1. Vender edificios.\n2. Hipotecar propiedades.\n3. Declararse en bancarrota.\n4. Mi informacion"));
            switch (a) {
                case 1://vender edificios
                    tablero.venderEdificio(this);
                    break;
                case 2://hipotecar
                    tablero.hipotecar(this);
                    break;
                case 3://declararse en bancarrota
                    bancarrota(false);
                    break;
                case 4://mi informacion
                    consola.imprimir(this.listaJugadores.get(turno).toString());
                    break;
                default:
                    break;
            }
        }
        if (a != 3) {
            this.listaJugadores.get(this.getTurno()).setDinero(this.listaJugadores.get(this.getTurno()).getDinero() - deuda);
            consola.imprimir(this.listaJugadores.get(this.getTurno()).getNombre() + " ha saldado su deuda de " + deuda + "€");
        }
    }
    public void listarTratos()throws Exception{
        listaJugadores.get(turno).listarTratos();

    }

    public void proponerTrato() throws Exception {
        if (!empezado)
            throw new AccionInvalida("Aun no ha comenzado la partida\n", this);//consola.imprimir("No puede jugar con menos de 2 jugadores.");

        String ntrato, aux;
        int turno2 = 0, j;
        boolean bool;
        List<String> trato = new ArrayList<>();

        aux = consola.leer("A qué jugador desea proponer el trato?");
        while (turno2 < listaJugadores.size() && !listaJugadores.get(turno2).getNombre().equals(aux)) {
            turno2++;
        }
        if (turno2 == listaJugadores.size()) {
            throw new AccionInvalida("Ese jugador no existe!", this);
        }
        if (turno==turno2)
            throw new AccionInvalida("No puede tratar consigo mismo!", this);

        ntrato = consola.leer("Que trato desea proponer?\n" +
                "1. Cambiar propiedad_1 por propiedad_2\n" +
                "2. Cambiar propiedad_1 por cantidad_dinero\n" +
                "3. Cambiar cantidad_dinero por propiedad_1\n" +
                "4. Cambiar propiedad_1 por propiedad_2 y cantidad_dinero\n" +
                "5. Cambiar propiedad_1 y cantidad_dinero por propiedad_2\n" +
                "6. Cambiar propiedad_1 por propiedad_2 y no pagar alquiler en propiedad_3 durante número_turnos)");
        switch (ntrato) {
            case "1":
                trato.add(listaJugadores.get(turno).getNombre());
                trato.add(ntrato);

                aux = consola.leer("Que propiedad desea dar?");
                bool = false;
                for (j = 0; j < listaJugadores.get(turno).getPropiedades().size(); j++) {

                    if ( listaJugadores.get(turno).getPropiedades().get(j).getNombreCasilla().equals(aux)) {
                        bool = true;

                    }
                }
                if (!bool)
                    throw new AccionInvalida("Trato no válido! La propiedad ofrecida no es suya o está hipotecada!", this);
                trato.add(aux);
                aux = consola.leer("Que propiedad desea recibir?");
                bool = false;
                for (j = 0; j < listaJugadores.get(turno2).getPropiedades().size(); j++) {
                    if (((Propiedad) listaJugadores.get(turno2).getPropiedades().get(j)).getNombreCasilla().equals(aux))
                        bool = true;
                }
                if (!bool)
                    throw new AccionInvalida("Trato no válido! La propiedad deseada no es del jugador con el que intenta tratar o esta hipotecada!", this);
                trato.add(aux);
                break;
            case "2":
                trato.add(listaJugadores.get(turno).getNombre());
                trato.add(ntrato);

                aux = consola.leer("Que propiedad desea dar?");
                bool = false;
                for (j = 0; j < listaJugadores.get(turno).getPropiedades().size(); j++) {
                    if (((Propiedad) listaJugadores.get(turno).getPropiedades().get(j)).getNombreCasilla().equals(aux))
                        bool = true;
                }
                if (!bool)
                    throw new AccionInvalida("Trato no válido! La propiedad ofrecida no es suya o está hipotecada!", this);
                trato.add(aux);
                aux = consola.leer("Cuanto dinero desea recibir?");

                if (!aux.chars().allMatch(Character::isDigit)) {
                    throw new AccionInvalida("Trato no válido! Lo que ha introducido no es una cantidad de dinero correcta", this);
                }
                trato.add(aux);

                break;
            case "3":
                trato.add(listaJugadores.get(turno).getNombre());
                trato.add(ntrato);

                aux = consola.leer("Cuanto dinero desea dar?");

                if (!aux.chars().allMatch(Character::isDigit)) {
                    throw new AccionInvalida("Trato no válido! Lo que ha introducido no es una cantidad de dinero correcta", this);
                }
                trato.add(aux);


                aux = consola.leer("Que propiedad desea recibir?");
                bool = false;
                for (j = 0; j < listaJugadores.get(turno2).getPropiedades().size(); j++) {
                    if (((Propiedad) listaJugadores.get(turno2).getPropiedades().get(j)).getNombreCasilla().equals(aux))
                        bool = true;
                }
                if (!bool)
                    throw new AccionInvalida("Trato no válido! La propiedad deseada no es del jugador con el que intenta tratar o esta hipotecada!", this);
                trato.add(aux);

                break;
            case "4":
                trato.add(listaJugadores.get(turno).getNombre());
                trato.add(ntrato);

                aux = consola.leer("Que propiedad desea dar?");
                bool = false;
                for (j = 0; j < listaJugadores.get(turno).getPropiedades().size(); j++) {
                    if (((Propiedad) listaJugadores.get(turno).getPropiedades().get(j)).getNombreCasilla().equals(aux))
                        bool = true;
                }
                if (!bool)
                    throw new AccionInvalida("Trato no válido! La propiedad ofrecida no es suya o está hipotecada!", this);
                trato.add(aux);

                aux = consola.leer("Que propiedad desea recibir?");
                bool = false;
                for (j = 0; j < listaJugadores.get(turno2).getPropiedades().size(); j++) {
                    if (((Propiedad) listaJugadores.get(turno2).getPropiedades().get(j)).getNombreCasilla().equals(aux))
                        bool = true;
                }
                if (!bool)
                    throw new AccionInvalida("Trato no válido! La propiedad deseada no es del jugador con el que intenta tratar o esta hipotecada!", this);
                trato.add(aux);


                aux = consola.leer("Cuanto dinero desea recibir?");

                if (!aux.chars().allMatch(Character::isDigit)) {
                    throw new AccionInvalida("Trato no válido! Lo que ha introducido no es una cantidad de dinero correcta", this);
                }
                trato.add(aux);

                break;
            case "5":
                trato.add(listaJugadores.get(turno).getNombre());
                trato.add(ntrato);

                aux = consola.leer("Que propiedad desea dar?");
                bool = false;
                for (j = 0; j < listaJugadores.get(turno).getPropiedades().size(); j++) {
                    if (((Propiedad) listaJugadores.get(turno).getPropiedades().get(j)).getNombreCasilla().equals(aux))
                        bool = true;
                }
                if (!bool)
                    throw new AccionInvalida("Trato no válido! La propiedad ofrecida no es suya o está hipotecada!", this);
                trato.add(aux);


                aux = consola.leer("Cuanto dinero desea dar?");

                if (!aux.chars().allMatch(Character::isDigit)) {
                    throw new AccionInvalida("Trato no válido! Lo que ha introducido no es una cantidad de dinero correcta", this);
                }
                trato.add(aux);


                aux = consola.leer("Que propiedad desea recibir?");
                bool = false;
                for (j = 0; j < listaJugadores.get(turno2).getPropiedades().size(); j++) {
                    if (((Propiedad) listaJugadores.get(turno2).getPropiedades().get(j)).getNombreCasilla().equals(aux))
                        bool = true;
                }
                if (!bool)
                    throw new AccionInvalida("Trato no válido! La propiedad deseada no es del jugador con el que intenta tratar o esta hipotecada!", this);
                trato.add(aux);

                break;
            case "6":
                trato.add(listaJugadores.get(turno).getNombre());
                trato.add(ntrato);

                aux = consola.leer("Que propiedad desea dar?");
                bool = false;
                for (j = 0; j < listaJugadores.get(turno).getPropiedades().size(); j++) {
                    if (((Propiedad) listaJugadores.get(turno).getPropiedades().get(j)).getNombreCasilla().equals(aux))
                        bool = true;
                }
                if (!bool)
                    throw new AccionInvalida("Trato no válido! La propiedad ofrecida no es suya o está hipotecada!", this);
                trato.add(aux);
                aux = consola.leer("Que propiedad desea recibir?");
                bool = false;
                for (j = 0; j < listaJugadores.get(turno2).getPropiedades().size(); j++) {
                    if (((Propiedad) listaJugadores.get(turno2).getPropiedades().get(j)).getNombreCasilla().equals(aux))
                        bool = true;
                }
                if (!bool)
                    throw new AccionInvalida("Trato no válido! La propiedad deseada no es del jugador con el que intenta tratar o esta hipotecada!", this);
                trato.add(aux);

                aux = consola.leer("En que propiedad desea no pagar el alquiler?");
                bool = false;
                for (j = 0; j < listaJugadores.get(turno2).getPropiedades().size(); j++) {
                    if (((Propiedad) listaJugadores.get(turno2).getPropiedades().get(j)).getNombreCasilla().equals(aux))
                        bool = true;
                }
                if (aux.equals(trato.get(2)))
                    bool=true;
                if (aux.equals(trato.get(3)))
                    throw new AccionInvalida("No pagar el alquiler en la propiedad que va a recibir no tiene sentido!", this);

                if (!bool)
                    throw new AccionInvalida("Trato no válido! La propiedad ofrecida no es del jugador con el que intenta tratar o esta hipotecada!", this);
                trato.add(aux);


                aux = consola.leer("Cuantos turnos?");

                if (!aux.chars().allMatch(Character::isDigit)) {
                    throw new AccionInvalida("Trato no válido! Lo que ha introducido no es una cantidad de turnos correcta", this);
                }
                trato.add(aux);
                break;
        }

        listaJugadores.get(turno2).getTratos().add(trato);
    }


    public void aceptarTrato() throws Exception {
        if (!empezado)
            throw new AccionInvalida("Aun no ha comenzado la partida\n", this);//consola.imprimir("No puede jugar con menos de 2 jugadores.");

        int n, i, j, aux = 0;
        n = Integer.parseInt(consola.leer("Que trato desea aceptar?"));
        n = n - 1;
        if (n>=listaJugadores.get(turno).getTratos().size()){
            throw new AccionInvalida("Ese trato no existe!\n", this);
        }
        switch (Integer.parseInt(listaJugadores.get(turno).getTratos().get(n).get(1))) {
            case 1:

                while (aux < listaJugadores.size() && !listaJugadores.get(aux).getNombre().equals(listaJugadores.get(turno).getTratos().get(n).get(0))) {
                    aux++;
                }
                if (aux == listaJugadores.size()) {
                    throw new AccionInvalida("No puede aceptar el trato ya que el jugador que lo propuso ya no se encuentra en la partida", this);
                }

                for (i = 0; i < listaJugadores.get(aux).getPropiedades().size(); i++) {
                    if (listaJugadores.get(turno).getTratos().get(n).get(2).equals(listaJugadores.get(aux).getPropiedades().get(i).getNombreCasilla())) {
                        for (j = 0; j < listaJugadores.get(turno).getPropiedades().size(); j++) {


                            if (listaJugadores.get(turno).getTratos().get(n).get(3).equals(listaJugadores.get(turno).getPropiedades().get(j).getNombreCasilla())) {
                                System.out.println("aux = "+aux+", propiedad aux = "+listaJugadores.get(aux).getPropiedades().get(i).getNombreCasilla());
                                System.out.println("turno = "+turno+", propiedad turno = "+listaJugadores.get(turno).getPropiedades().get(j).getNombreCasilla());

                                listaJugadores.get(aux).getPropiedades().add(listaJugadores.get(turno).getPropiedades().get(j));
                                ((Propiedad) listaJugadores.get(turno).getPropiedades().get(j)).setPropietario(listaJugadores.get(aux).getNombre());
                                if (listaJugadores.get(turno).getPropiedades().get(j).getClass().getSimpleName().equals("Solar")) {
                                    ((Solar) listaJugadores.get(turno).getPropiedades().get(j)).getGrupo().tieneGrupoColor();
                                }
                                listaJugadores.get(turno).getPropiedades().add(listaJugadores.get(aux).getPropiedades().get(i));
                                ((Propiedad) listaJugadores.get(aux).getPropiedades().get(i)).setPropietario(listaJugadores.get(turno).getNombre());
                                if (listaJugadores.get(aux).getPropiedades().get(i).getClass().getSimpleName().equals("Solar")) {
                                    ((Solar) listaJugadores.get(aux).getPropiedades().get(i)).getGrupo().tieneGrupoColor();
                                }
                                listaJugadores.get(turno).getPropiedades().remove(i);
                                listaJugadores.get(aux).getPropiedades().remove(j);
                            } else if (j == listaJugadores.get(aux).getPropiedades().size())
                                throw new AccionInvalida("No tienes esta propiedad, puede que estea hipotecada", this);
                        }
                    } else if (i == listaJugadores.get(aux).getPropiedades().size()) {
                        throw new AccionInvalida("El que propuso el trato no tiene esta propiedad, puede que estea hipotecada", this);
                    }
                }
                break;

            case 2:

                while (aux < listaJugadores.size() && !listaJugadores.get(aux).getNombre().equals(listaJugadores.get(turno).getTratos().get(n).get(0))) {
                    aux++;
                }
                if (aux == listaJugadores.size()) {
                    throw new AccionInvalida("No puede aceptar el trato ya que el jugador que lo propuso ya no se encuentra en la partida", this);
                }

                for (i = 0; i < listaJugadores.get(aux).getPropiedades().size(); i++) {
                    if (listaJugadores.get(turno).getTratos().get(n).get(2).equals(listaJugadores.get(aux).getPropiedades().get(i).getNombreCasilla())) {
                        if (Float.parseFloat(listaJugadores.get(turno).getTratos().get(n).get(3)) < listaJugadores.get(turno).getDinero()) {

                            listaJugadores.get(turno).getPropiedades().add(listaJugadores.get(aux).getPropiedades().get(i));
                            ((Propiedad) listaJugadores.get(aux).getPropiedades().get(i)).setPropietario(listaJugadores.get(turno).getNombre());
                            if (listaJugadores.get(aux).getPropiedades().get(i).getClass().getSimpleName().equals("Solar")) {
                                ((Solar) listaJugadores.get(aux).getPropiedades().get(i)).getGrupo().tieneGrupoColor();
                            }
                            listaJugadores.get(aux).getPropiedades().remove(i);
                            listaJugadores.get(turno).setDinero(listaJugadores.get(turno).getDinero()-Float.parseFloat(listaJugadores.get(turno).getTratos().get(n).get(3)));
                            listaJugadores.get(aux).setDinero(listaJugadores.get(aux).getDinero()+Float.parseFloat(listaJugadores.get(turno).getTratos().get(n).get(3)));


                        }else throw new AccionInvalida("No tienes suficiente dinero para intercambiar", this);
                    } else if (i == listaJugadores.get(aux).getPropiedades().size()) {
                        throw new AccionInvalida("El que propuso el trato no tiene esta propiedad, puede que estea hipotecada", this);
                    }
                }
                break;
            case 3:

                while (aux < listaJugadores.size() && !listaJugadores.get(aux).getNombre().equals(listaJugadores.get(turno).getTratos().get(n).get(0))) {
                    aux++;
                }
                if (aux == listaJugadores.size()) {
                    throw new AccionInvalida("No puede aceptar el trato ya que el jugador que lo propuso ya no se encuentra en la partida", this);
                }

                for (i = 0; i < listaJugadores.get(turno).getPropiedades().size(); i++) {
                    if (listaJugadores.get(turno).getTratos().get(n).get(2).equals(listaJugadores.get(aux).getPropiedades().get(i).getNombreCasilla())) {
                        if (Float.parseFloat(listaJugadores.get(turno).getTratos().get(n).get(3)) < listaJugadores.get(aux).getDinero()) {

                            listaJugadores.get(aux).getPropiedades().add(listaJugadores.get(turno).getPropiedades().get(i));
                            ((Propiedad) listaJugadores.get(turno).getPropiedades().get(i)).setPropietario(listaJugadores.get(aux).getNombre());
                            if (listaJugadores.get(turno).getPropiedades().get(i).getClass().getSimpleName().equals("Solar")) {
                                ((Solar) listaJugadores.get(turno).getPropiedades().get(i)).getGrupo().tieneGrupoColor();
                            }
                            listaJugadores.get(turno).getPropiedades().remove(i);

                            listaJugadores.get(aux).setDinero(listaJugadores.get(aux).getDinero()-Float.parseFloat(listaJugadores.get(turno).getTratos().get(n).get(3)));
                            listaJugadores.get(turno).setDinero(listaJugadores.get(turno).getDinero()+Float.parseFloat(listaJugadores.get(turno).getTratos().get(n).get(3)));

                        }else throw new AccionInvalida("El jugador que propuso el trato no tiene suficiente dinero para intercambiar", this);
                    } else if (i == listaJugadores.get(aux).getPropiedades().size()) {
                        throw new AccionInvalida("El jugador que propuso el trato no tiene esta propiedad, puede que estea hipotecada", this);
                    }
                }
                break;
            case 4:
                while (aux < listaJugadores.size() && !listaJugadores.get(aux).getNombre().equals(listaJugadores.get(turno).getTratos().get(n).get(0))) {
                    aux++;
                }
                if (aux == listaJugadores.size()) {
                    throw new AccionInvalida("No puede aceptar el trato ya que el jugador que lo propuso ya no se encuentra en la partida", this);
                }

                for (i = 0; i < listaJugadores.get(aux).getPropiedades().size(); i++) {
                    if (listaJugadores.get(turno).getTratos().get(n).get(2).equals(listaJugadores.get(aux).getPropiedades().get(i).getNombreCasilla())) {
                        for (j = 0; j < listaJugadores.get(turno).getPropiedades().size(); j++) {

                            if (listaJugadores.get(turno).getTratos().get(n).get(3).equals(listaJugadores.get(turno).getPropiedades().get(j).getNombreCasilla())) {
                                if (Float.parseFloat(listaJugadores.get(turno).getTratos().get(n).get(4)) < listaJugadores.get(turno).getDinero()) {


                                    listaJugadores.get(aux).getPropiedades().add(listaJugadores.get(turno).getPropiedades().get(j));
                                    ((Propiedad) listaJugadores.get(turno).getPropiedades().get(j)).setPropietario(listaJugadores.get(aux).getNombre());
                                    if (listaJugadores.get(turno).getPropiedades().get(j).getClass().getSimpleName().equals("Solar")) {
                                        ((Solar) listaJugadores.get(turno).getPropiedades().get(j)).getGrupo().tieneGrupoColor();
                                    }
                                    listaJugadores.get(turno).getPropiedades().add(listaJugadores.get(aux).getPropiedades().get(i));
                                    ((Propiedad) listaJugadores.get(aux).getPropiedades().get(i)).setPropietario(listaJugadores.get(turno).getNombre());
                                    if (listaJugadores.get(aux).getPropiedades().get(i).getClass().getSimpleName().equals("Solar")) {
                                        ((Solar) listaJugadores.get(aux).getPropiedades().get(i)).getGrupo().tieneGrupoColor();
                                    }
                                    listaJugadores.get(turno).getPropiedades().remove(i);
                                    listaJugadores.get(aux).getPropiedades().remove(j);

                                    listaJugadores.get(turno).setDinero(listaJugadores.get(turno).getDinero()-Float.parseFloat(listaJugadores.get(turno).getTratos().get(n).get(4)));
                                    listaJugadores.get(aux).setDinero(listaJugadores.get(aux).getDinero()+Float.parseFloat(listaJugadores.get(turno).getTratos().get(n).get(4)));

                                }else throw new AccionInvalida("No tienes suficiente dinero para intercambiar", this);

                            } else if (j == listaJugadores.get(aux).getPropiedades().size())
                                throw new AccionInvalida("No tienes esta propiedad, puede que estea hipotecada", this);
                        }
                    } else if (i == listaJugadores.get(aux).getPropiedades().size()) {
                        throw new AccionInvalida("El que propuso el trato no tiene esta propiedad, puede que estea hipotecada", this);
                    }
                }
                break;
            case 5:
                while (aux < listaJugadores.size() && !listaJugadores.get(aux).getNombre().equals(listaJugadores.get(turno).getTratos().get(n).get(0))) {
                    aux++;
                }
                if (aux == listaJugadores.size()) {
                    throw new AccionInvalida("No puede aceptar el trato ya que el jugador que lo propuso ya no se encuentra en la partida", this);
                }

                for (i = 0; i < listaJugadores.get(aux).getPropiedades().size(); i++) {
                    if (listaJugadores.get(turno).getTratos().get(n).get(2).equals(listaJugadores.get(aux).getPropiedades().get(i).getNombreCasilla())) {
                        for (j = 0; j < listaJugadores.get(turno).getPropiedades().size(); j++) {

                            if (listaJugadores.get(turno).getTratos().get(n).get(4).equals(listaJugadores.get(turno).getPropiedades().get(j).getNombreCasilla())) {
                                if (Float.parseFloat(listaJugadores.get(turno).getTratos().get(n).get(3)) < listaJugadores.get(aux).getDinero()) {


                                    listaJugadores.get(aux).getPropiedades().add(listaJugadores.get(turno).getPropiedades().get(j));
                                    ((Propiedad) listaJugadores.get(turno).getPropiedades().get(j)).setPropietario(listaJugadores.get(aux).getNombre());
                                    if (listaJugadores.get(turno).getPropiedades().get(j).getClass().getSimpleName().equals("Solar")) {
                                        ((Solar) listaJugadores.get(turno).getPropiedades().get(j)).getGrupo().tieneGrupoColor();
                                    }
                                    listaJugadores.get(turno).getPropiedades().add(listaJugadores.get(aux).getPropiedades().get(i));
                                    ((Propiedad) listaJugadores.get(aux).getPropiedades().get(i)).setPropietario(listaJugadores.get(turno).getNombre());
                                    if (listaJugadores.get(aux).getPropiedades().get(i).getClass().getSimpleName().equals("Solar")) {
                                        ((Solar) listaJugadores.get(aux).getPropiedades().get(i)).getGrupo().tieneGrupoColor();
                                    }
                                    listaJugadores.get(turno).getPropiedades().remove(i);
                                    listaJugadores.get(aux).getPropiedades().remove(j);

                                    listaJugadores.get(aux).setDinero(listaJugadores.get(aux).getDinero()-Float.parseFloat(listaJugadores.get(turno).getTratos().get(n).get(3)));
                                    listaJugadores.get(turno).setDinero(listaJugadores.get(turno).getDinero()+Float.parseFloat(listaJugadores.get(turno).getTratos().get(n).get(3)));

                                }else throw new AccionInvalida("El jugador que propuso el trato no tiene suficiente dinero para intercambiar", this);

                            } else if (j == listaJugadores.get(aux).getPropiedades().size())
                                throw new AccionInvalida("No tienes esta propiedad, puede que estea hipotecada", this);
                        }
                    } else if (i == listaJugadores.get(aux).getPropiedades().size()) {
                        throw new AccionInvalida("El que propuso el trato no tiene esta propiedad, puede que estea hipotecada", this);
                    }
                }
                break;

            case 6:


                while (aux < listaJugadores.size() && !listaJugadores.get(aux).getNombre().equals(listaJugadores.get(turno).getTratos().get(n).get(0))) {
                    aux++;
                }
                if (aux == listaJugadores.size()) {
                    throw new AccionInvalida("No puede aceptar el trato ya que el jugador que lo propuso ya no se encuentra en la partida", this);
                }

                boolean bool;
                bool = false;
                int k=0;
                while( k < listaJugadores.get(turno).getPropiedades().size()&&!bool) {
                    if (listaJugadores.get(turno).getPropiedades().get(k).getNombreCasilla().equals(listaJugadores.get(turno).getTratos().get(n).get(4)))
                        bool=true;
                    k++;
                }
                if (listaJugadores.get(turno).getTratos().get(n).get(4).equals(listaJugadores.get(turno).getTratos().get(n).get(2)))
                    bool=true;
                if (!bool)
                    throw new AccionInvalida("La propiedad en la que el otro tratante deseaba no pagar alquiler ya no es suya o está hipotecada!", this);

                for (i = 0; i < listaJugadores.get(aux).getPropiedades().size(); i++) {
                    if (listaJugadores.get(turno).getTratos().get(n).get(2).equals(listaJugadores.get(aux).getPropiedades().get(i).getNombreCasilla())) {
                        for (j = 0; j < listaJugadores.get(turno).getPropiedades().size(); j++) {


                            if (listaJugadores.get(turno).getTratos().get(n).get(3).equals(listaJugadores.get(turno).getPropiedades().get(j).getNombreCasilla())) {

                                listaJugadores.get(aux).getPropiedades().add(listaJugadores.get(turno).getPropiedades().get(j));
                                ((Propiedad) listaJugadores.get(turno).getPropiedades().get(j)).setPropietario(listaJugadores.get(aux).getNombre());
                                if (listaJugadores.get(turno).getPropiedades().get(j).getClass().getSimpleName().equals("Solar")) {
                                    ((Solar) listaJugadores.get(turno).getPropiedades().get(j)).getGrupo().tieneGrupoColor();
                                }
                                listaJugadores.get(turno).getPropiedades().add(listaJugadores.get(aux).getPropiedades().get(i));
                                ((Propiedad) listaJugadores.get(aux).getPropiedades().get(i)).setPropietario(listaJugadores.get(turno).getNombre());
                                if (listaJugadores.get(aux).getPropiedades().get(i).getClass().getSimpleName().equals("Solar")) {
                                    ((Solar) listaJugadores.get(aux).getPropiedades().get(i)).getGrupo().tieneGrupoColor();
                                }
                                ((Propiedad) listaJugadores.get(turno).getPropiedades().get(k)).getNoPaga().add(listaJugadores.get(aux));
                                ((Propiedad) listaJugadores.get(turno).getPropiedades().get(k)).getTurnosNoPaga().add(listaJugadores.get(aux).getTurnos()+Integer.parseInt(listaJugadores.get(turno).getTratos().get(n).get(5)));
                                listaJugadores.get(aux).getPropiedades().remove(i);
                                listaJugadores.get(turno).getPropiedades().remove(j);
                            } else if (j == listaJugadores.get(aux).getPropiedades().size())
                                throw new AccionInvalida("No tienes esta propiedad, puede que estea hipotecada", this);
                        }
                    } else if (i == listaJugadores.get(aux).getPropiedades().size()) {
                        throw new AccionInvalida("El que propuso el trato no tiene esta propiedad, puede que este hipotecada", this);
                    }
                }
                break;
        }
        listaJugadores.get(turno).getTratos().remove(n);

    }

    public void eliminarTrato() throws Exception {
        int i;
        String jugador = consola.leer("De que jugador es el trato que desea eliminar?");
        for(i=0;i<listaJugadores.size();i++){
            if(listaJugadores.get(i).getNombre().equals(jugador)){
                listaJugadores.get(i).listarTratos();
                int n=Integer.parseInt(consola.leer("Que trato desea eliminar?"))-1;
                if(listaJugadores.get(i).getTratos().get(n).get(0).equals(listaJugadores.get(turno).getNombre())){
                    listaJugadores.get(i).getTratos().remove(n);
                    return;
                }else throw new AccionInvalida("Ese trato no lo ha propuesto usted", this);
            }
        } throw new AccionInvalida("Jugador no encontrado", this);
    }
}