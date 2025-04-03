package Excepciones;

import juego.Juego;

public final class Eleccion extends AccionInvalida{
    public Eleccion(String message, Juego juego) {
        super("Esa opción no esta disponible. "+message, juego);
    }
}
