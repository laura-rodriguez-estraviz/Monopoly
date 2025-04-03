package elementosBasicos.cartas;

import elementosBasicos.casilla.Solar;
import juego.Juego;

final public class CartasSuerte extends Cartas {//final porque no hay ninguna clase que herede de esta



    //private int[] numeros = {1, 2, 3, 4, 5, 6};
    public void casillaSuerte(Juego juego) throws Exception{//VOLVELA A POÑER BENNNNNNNN
        barajar();
        int n;
        n = Integer.parseInt(Juego.consola.leer("Las cartas de suerte han sido barajadas, elija una carta del 1 al 6:"))-1;
        do{

            if(n<0||n>5){
                Juego.consola.imprimir("Opcion incorrecta, seleccione un numero entre 1 y 6");
                n = Integer.parseInt(Juego.consola.leer("Opcion incorrecta, seleccione un numero entre 1 y 6"))-1;
            }
            if(!(n<0||n>5)){
                switch (getNumeros()[n]) {
                    case 1:
                        pagar_1(juego);
                        break;
                    case 2:
                        pagar_2(juego);
                        break;
                    case 3:
                        cobrar_1(juego);
                        break;
                    case 4:
                        cobrar_2(juego);
                        break;
                    case 5:
                        pagarGlobal_1(juego);
                        break;
                    case 6:
                        pagar_por_edificios(juego);
                        break;
                }
            }
        }while(!(n>=0&&n<=5));


    }

    //Cartas instance = new Cartas();
    public void pagar_1(Juego juego) throws Exception{
        Juego.consola.imprimir("Acción: Tu abuela dice que te han echado un mal de ojo, paga 10000€ por un amuleto que te proteja.");
        if(juego.getListaJugadores().get(juego.getTurno()).getDinero()<10000)
        {
            juego.sinDinero(10000);
            return;
        }
        juego.getListaJugadores().get(juego.getTurno()).setDinero(juego.getListaJugadores().get(juego.getTurno()).getDinero() - (float) 10000);
        juego.getListaJugadores().get(juego.getTurno()).setPagoTasas(juego.getListaJugadores().get(juego.getTurno()).getPagoTasas() - (float) 10000);

    }

    public void pagar_2(Juego juego) throws Exception{
        Juego.consola.imprimir("Acción: Como eres rico te has comprado un tigre. Porque puedes supongo. Paga 15000€.");
        if(juego.getListaJugadores().get(juego.getTurno()).getDinero()<15000)
        {
            juego.sinDinero(15000);
            return;
        }
        juego.getListaJugadores().get(juego.getTurno()).setDinero(juego.getListaJugadores().get(juego.getTurno()).getDinero() - (float) 15000);
        juego.getListaJugadores().get(juego.getTurno()).setPagoTasas(juego.getListaJugadores().get(juego.getTurno()).getPagoTasas() - (float) 15000);

    }

    public void cobrar_1(Juego juego) {
        Juego.consola.imprimir("Acción: Que buena suerte! Has encontrado un anillo en el suelo y al parecer es muy valioso, lo vendes y recibes 10000€");
        juego.getListaJugadores().get(juego.getTurno()).setDinero(juego.getListaJugadores().get(juego.getTurno()).getDinero() + (float) 10000);
        juego.getListaJugadores().get(juego.getTurno()).setPremiosBote(juego.getListaJugadores().get(juego.getTurno()).getPremiosBote() + (float) 10000);
    }

    public void cobrar_2(Juego juego) {
        Juego.consola.imprimir("Acción: Se alinean los astros y se revalorizan las criptomonedas, cobra 15000€");
        juego.getListaJugadores().get(juego.getTurno()).setDinero(juego.getListaJugadores().get(juego.getTurno()).getDinero() + (float) 15000);
        juego.getListaJugadores().get(juego.getTurno()).setPremiosBote(juego.getListaJugadores().get(juego.getTurno()).getPremiosBote() + (float) 15000);

    }

    public void pagarGlobal_1(Juego juego) throws Exception{
        Juego.consola.imprimir("Acción: Como eres rico tus amigos te piden dinero para ir al casino y no puedes decirles que no porque entonces tu orgullo se vería dañado, dale a cada jugador 5000€");
        if(juego.getListaJugadores().get(juego.getTurno()).getDinero()<5000* juego.getListaJugadores().size())
        {
            juego.sinDinero(5000*juego.getListaJugadores().size());
            return;
        }
        for (int i = 0; i < juego.getListaJugadores().size(); i++) {
            if (juego.getListaJugadores().get(i) != juego.getListaJugadores().get(juego.getTurno())) {
                juego.getListaJugadores().get(juego.getTurno()).setDinero(juego.getListaJugadores().get(juego.getTurno()).getDinero() - (float) 5000);
                juego.getListaJugadores().get(juego.getTurno()).setPagoTasas(juego.getListaJugadores().get(juego.getTurno()).getPagoTasas() + (float) 5000);

                juego.getListaJugadores().get(i).setDinero(juego.getListaJugadores().get(i).getDinero() + (float) 5000);
                juego.getListaJugadores().get(i).setPremiosBote(juego.getListaJugadores().get(i).getPremiosBote() + (float) 5000);
            }
        }
    }

    public void pagar_por_edificios(Juego juego) throws Exception{
        int tam, ncasas=0, nhoteles=0, npistas=0, npiscinas=0;
        float pago=0;
        for (int i = 0; i < juego.getListaJugadores().get(juego.getTurno()).getPropiedades().size(); i++) {
            if(juego.getListaJugadores().get(juego.getTurno()).getPropiedades().get(i).getClass().getSimpleName().equals("Solar")){
                tam = ((Solar)juego.getListaJugadores().get(juego.getTurno()).getPropiedades().get(i)).getEdificios().size();
                if (tam != 0) {
                    for (int j = 0; j < tam; j++) {
                        switch(((Solar)juego.getTablero().getTablero()[i]).getEdificios().get(j).getClass().getSimpleName()){
                            case "Casa":
                                pago+=4000;
                                ncasas++;
                                break;
                            case "Hotel":
                                pago+=10000;
                                nhoteles++;
                                break;
                            case "PistaDeporte":
                                pago+=2000;
                                npistas++;
                                break;
                            case "Piscina":
                                pago+=7000;
                                npiscinas++;
                                break;
                        }
                    }
                }
            }

        }
        Juego.consola.imprimir("Diantres: Tienes que pagar IMPUESTOS por cada edificio que tienes.");
        Juego.consola.imprimir("Tienes "+ncasas+" casas,"+nhoteles+" hoteles,"+npistas+" pistas de deporte y "+npiscinas+" piscinas, lo que suma un total de "+pago+" €");
        if(juego.getListaJugadores().get(juego.getTurno()).getDinero()<pago)
        {
            juego.sinDinero(pago);
        }
        else{
            juego.getListaJugadores().get(juego.getTurno()).setDinero(juego.getListaJugadores().get(juego.getTurno()).getDinero() - pago);
        }
    }
}
