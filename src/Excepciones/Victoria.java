package Excepciones;

import juego.Juego;

public final class Victoria extends ErrorCritico{
    public Victoria(String message, Juego juego) {
        super(message, juego);
    }
}
