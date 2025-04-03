package juego;

import Excepciones.AccionInvalida;

public interface Comando {
    void anadirJugador() throws Exception;
    void indicarTurno() throws Exception;
    void listarJugadores();
    void listarAvatares();
    void lanzarDados() throws Exception;
    void acabarTurno() throws Exception;
    void salirCarcel() throws Exception;
    void describirCasilla() throws Exception;
    void describirJugador() throws Exception;
    void describirAvatar() throws Exception;
    void comprarPropiedad() throws Exception;
    void listarPropiedadesVenta();
    void verTablero();
    void construirEdificio() throws Exception;
    void listarEdificios();
    void listarEdificiosGrupo();
    void estadisticasJugadores();
    void estadisticasPartida();
    void venderEdificio() throws Exception;
    void hipotecar() throws Exception;
    void deshipotecar() throws Exception;
    void switchModoAvanzado() throws Exception;
    void declararseBancarrota()throws Exception;
    void lanzarDadosTrucados() throws Exception;
    void proponerTrato() throws Exception;
    void aceptarTrato() throws Exception;
    void listarTratos() throws Exception;
    void eliminarTrato() throws Exception;
}
