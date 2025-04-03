package Excepciones;

import juego.Juego;

public class ErrorCritico extends AccionInvalida {
    public ErrorCritico(String message, Juego juego) {
        super("Error critico, el juego no debe continuar su curso. Causa: "+message, juego);
    }
}