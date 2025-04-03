package Excepciones;

import juego.Juego;

public final class Lectura extends AccionInvalida{
    public Lectura(String message, Juego juego) {
        super("Error en la lectura. "+message, juego);
    }
}
