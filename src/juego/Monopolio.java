package juego;

import Excepciones.*;
import elementosBasicos.Jugador;
import elementosBasicos.Tablero;

import java.util.Scanner;
final public class Monopolio {//final porque no hay ninguna clase que herede de esta
    public static Juego juego;

    public Monopolio(){
        juego = new Juego();
    }
    public void bigSwitch() throws Exception{
        int e = 1;
        String nombre;
        char nombre2;

        while (e != 0) {
            try {
                if (juego.getListaJugadores().size() != 0) {
                    if (juego.getListaJugadores().get(juego.getTurno()).getNoTurno() > 0) {
                        Juego.consola.imprimir("\n" + juego.getListaJugadores().get(juego.getTurno()).getNombre() + ", no podras lanzar los dados este turno. Turnos perdidos restantes: " + juego.getListaJugadores().get(juego.getTurno()).getNoTurno());
                        juego.getDados().setDobles(0);
                    }
                }

                Juego.consola.imprimir("\nBienvenid@ al Monopoli: \n" +
                        "0.Salir\n" +
                        "1.Dar de alta un jugador \n" +
                        "2.Indicar jugador que tiene el turno \n" +
                        "3.Listar jugadores\n" +
                        "4.Listar avatares \n" +
                        "5.Lanzar los dados \n" +
                        "6.Acabar turno \n" +
                        "7.Salir de la carcel \n" +
                        "8.Describir una casilla \n" +
                        "9.Describir a un jugador\n" +
                        "10.Describir a un avatar\n" +
                        "11.Comprar una propiedad \n" +
                        "12.Listar propiedades en venta \n" +
                        "13.Ver tablero \n" +
                        "14.Construir un edificio\n" +
                        "15.Listar edificios construidos\n" +
                        "16.Listar edificios construidos en un grupo\n" +
                        "17.Estadisticas de los jugadores\n" +
                        "18.Estadisticas de la partida\n" +
                        "19.Vender Edificios\n" +
                        "20.Hipotecar propiedad\n" +
                        "21.Deshipotecar propiedad\n" +
                        "22.Switch modo avanzado\n" +
                        "23.Declararse en bancarrota\n" +
                        "24.Proponer trato\n"+
                        "25.Dados trucados\n" +
                        "26.Listar tratos\n"+
                        "27.Aceptar trato\n"+
                        "28.Eliminar trato\n"+
                        "Seleccione una opcion : ");
                e = Integer.parseInt(Juego.consola.leer(null));
                switch (e) {
                    case 1://añadir jugador
                        juego.anadirJugador();
                        break;
                    case 2://Indicar jugador que tiene el turno
                        juego.indicarTurno();
                        break;
                    case 3://listar jugadores
                        juego.listarJugadores();
                        break;
                    case 4://listar avatares
                        juego.listarAvatares();
                        break;
                    case 5://lanzar dados
                        juego.lanzarDados();
                        break;
                    case 6://acabar turno
                        juego.acabarTurno();
                        break;
                    case 7://salir de la carcel
                        juego.salirCarcel();
                        break;
                    case 8://describir casilla
                        juego.describirCasilla();
                        break;
                    case 9://describir jugador
                        juego.describirJugador();
                        break;
                    case 10://describir avatar
                        juego.describirAvatar();
                        break;
                    case 11://comprar una propiedad
                        juego.comprarPropiedad();
                        break;
                    case 12://listar propiedades venta
                        juego.listarPropiedadesVenta();
                        break;
                    case 13://ver tablero
                        juego.verTablero();
                        break;
                    case 14://construir edificio
                        juego.construirEdificio();
                        break;
                    case 15://listar edificios construidos
                        juego.listarEdificios();
                        break;
                    case 16://listar edificios construidos grupo
                        juego.listarEdificiosGrupo();
                        break;
                    case 17:
                        juego.estadisticasJugadores();
                        break;
                    case 18:
                        juego.estadisticasPartida();
                        break;
                    case 19://vender edificio
                        juego.venderEdificio();
                        break;
                    case 20://hipotecar
                        juego.hipotecar();
                        break;
                    case 21://deshipotecar
                        juego.deshipotecar();
                        break;
                    case 22://switch modo avanzado
                        juego.switchModoAvanzado();
                        break;
                    case 23://declararse en bancarrota
                        juego.declararseBancarrota();
                        break;
                    case 24://proponer trato
                        juego.proponerTrato();
                        break;
                    case 25://listar trato
                        juego.lanzarDadosTrucados();
                        break;
                    case 26://listar tratos
                        juego.listarTratos();
                        break;
                    case 27://aceptar tratos
                        juego.aceptarTrato();
                        break;
                    case 28://aceptar tratos
                        juego.eliminarTrato();
                        break;
                    case 0:
                        Juego.consola.getScanner().close();
                        break;
                    default:

                        throw new Eleccion("Error en BigSwitch.", juego);
                        //break;
                }
            }
            catch (Victoria vic){
                Juego.consola.imprimir("ENHORABUENA "+juego.getListaJugadores().get(0).getNombre()+", HAS GANADO LA PARTIDA!");
                Juego.consola.getScanner().close();
                System.exit(0);
            }
            catch (ErrorCritico error){
                Juego.consola.imprimir(error.getMessage());
                System.exit(0);
            }
            catch (Lectura lec){
                Juego.consola.imprimir(lec.getMessage());
            }
            catch (Eleccion elec){
                Juego.consola.imprimir(elec.getMessage());
            }
            catch (AccionInvalida ac){
                Juego.consola.imprimir(ac.getMessage());
            }
            catch (Exception ex){
                Juego.consola.imprimir(ex.getMessage());
            }
        }
    }
}
