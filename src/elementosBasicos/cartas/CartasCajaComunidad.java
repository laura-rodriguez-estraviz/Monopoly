package elementosBasicos.cartas;

import Excepciones.AccionInvalida;
import Excepciones.Eleccion;
import elementosBasicos.cartas.Cartas;
import juego.Juego;

final public class CartasCajaComunidad extends Cartas {//final porque no hay ninguna clase que herede de esta

    //private int[] numeros = {1, 2, 3, 4, 5, 6};
    public void cajaComunidad(Juego juego) throws Exception{
        barajar();
        int n;

        n = Integer.parseInt(Juego.consola.leer("Las cartas de la comunidad han sido barajadas, elija una carta del 1 al 6:"))-1;
        do {
            if(n<0||n>5){
                n = Integer.parseInt(Juego.consola.leer("Opcion incorrecta, seleccione un numero entre 1 y 6"))-1;
            }
            if(!(n<0||n>5)){
                switch (getNumeros()[n]) {
                    case 1:
                        pagar_3(juego);
                        break;
                    case 2:
                        pagar_4(juego);
                        break;
                    case 3:
                        cobrar_3(juego);
                        break;
                    case 4:
                        cobrar_4(juego);
                        break;
                    case 5:
                        cobrar_5(juego);
                        break;
                    case 6:
                        pagarGlobal_2(juego);
                        break;
                    default:
                        Juego.consola.imprimir("Opcion incorrecta");
                        break;
                }
            }

        } while (!(n <= 5 && n >= 0));
    }

    public void pagar_3(Juego juego) throws Exception{
        Juego.consola.imprimir("Acción: Ups, han raptado a tu tío Juan, paga su rescate de 18000€");
        if(juego.getListaJugadores().get(juego.getTurno()).getDinero()<18000)
        {
            juego.sinDinero(18000);
            return;
        }
        juego.getListaJugadores().get(juego.getTurno()).setDinero(juego.getListaJugadores().get(juego.getTurno()).getDinero() - (float) 18000);
        juego.getListaJugadores().get(juego.getTurno()).setPagoTasas(juego.getListaJugadores().get(juego.getTurno()).getPagoTasas() - (float) 18000);

    }

    public void pagar_4(Juego juego) throws Exception{
        Juego.consola.imprimir("Acción: Vaya, te has caido por las escaleras, paga la factura medica de 8000€");
        if(juego.getListaJugadores().get(juego.getTurno()).getDinero()<8000)
        {
            juego.sinDinero(8000);
            return;
        }
        juego.getListaJugadores().get(juego.getTurno()).setDinero(juego.getListaJugadores().get(juego.getTurno()).getDinero() - (float) 8000);
        juego.getListaJugadores().get(juego.getTurno()).setPagoTasas(juego.getListaJugadores().get(juego.getTurno()).getPagoTasas() - (float) 8000);

    }



    public void cobrar_3(Juego juego) {
        Juego.consola.imprimir("Acción: Has ido a casa de tu abuela y te ha dado la paga! Recibes 8000€");
        juego.getListaJugadores().get(juego.getTurno()).setDinero(juego.getListaJugadores().get(juego.getTurno()).getDinero() + (float) 8000);
        juego.getListaJugadores().get(juego.getTurno()).setPremiosBote(juego.getListaJugadores().get(juego.getTurno()).getPremiosBote() + (float) 8000);

    }

    public void cobrar_4(Juego juego) {
        Juego.consola.imprimir("Acción: Enhorabuena! Hacienda te ha devuelto 12000€.");
        juego.getListaJugadores().get(juego.getTurno()).setDinero(juego.getListaJugadores().get(juego.getTurno()).getDinero() + (float) 12000);
        juego.getListaJugadores().get(juego.getTurno()).setPremiosBote(juego.getListaJugadores().get(juego.getTurno()).getPremiosBote() + (float) 12000);

    }

    public void cobrar_5(Juego juego) {
        Juego.consola.imprimir("Acción: Lamenteblemente su abuela ha fallecido. Reciba 20000€ de herencia");
        juego.getListaJugadores().get(juego.getTurno()).setDinero(juego.getListaJugadores().get(juego.getTurno()).getDinero() + (float) 20000);
        juego.getListaJugadores().get(juego.getTurno()).setPremiosBote(juego.getListaJugadores().get(juego.getTurno()).getPremiosBote() + (float) 20000);

    }



    public void pagarGlobal_2(Juego juego) throws Exception{
        Juego.consola.imprimir("Acción: Tus predicciones para la velada de Ibai han sido todas erroneas! Paga a cada jugador los 3000€ apostados");
        if(juego.getListaJugadores().get(juego.getTurno()).getDinero()<3000* juego.getListaJugadores().size())
        {
            juego.sinDinero(3000*juego.getListaJugadores().size());
            return;
        }
        for (int i = 0; i < juego.getListaJugadores().size(); i++) {
            if (juego.getListaJugadores().get(i) != juego.getListaJugadores().get(juego.getTurno())) {
                juego.getListaJugadores().get(juego.getTurno()).setDinero(juego.getListaJugadores().get(juego.getTurno()).getDinero() - (float) 3000);
                juego.getListaJugadores().get(juego.getTurno()).setPagoTasas(juego.getListaJugadores().get(juego.getTurno()).getPagoTasas() + (float) 3000);

                juego.getListaJugadores().get(i).setDinero(juego.getListaJugadores().get(i).getDinero() + (float) 3000);
                juego.getListaJugadores().get(i).setPremiosBote(juego.getListaJugadores().get(i).getPremiosBote() + (float) 3000);

            }
        }
    }
}
