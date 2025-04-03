package elementosBasicos.avatar;
import elementosBasicos.avatar.Avatar;
import elementosBasicos.casilla.Casilla;

final public class Coche extends Avatar {//final porque no hay ninguna clase que herede de esta
    public Coche(int ncasilla, Casilla casilla, String jugador) {
        super(ncasilla, casilla, jugador);
    }
}
