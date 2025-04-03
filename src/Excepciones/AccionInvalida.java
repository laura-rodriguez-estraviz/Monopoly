package Excepciones;
import juego.*;
public class AccionInvalida extends Exception{
    public AccionInvalida(String message, Juego juego) {
        super(message);
        this.juego = juego;
    }

    Juego juego;

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }
}
