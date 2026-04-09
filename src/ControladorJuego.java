import java.util.List;

public class ControladorJuego {

    // Controlara la logica del juego

    private Tablero tablero;
    private Ficha.ColorFicha turnoActual;

    private int filaSeleccionada = -1;
    private int colSeleccionada = -1;

    public ControladorJuego() {
        tablero = new Tablero();
        turnoActual = Ficha.ColorFicha.BLANCA;

    }

    public void reiniciar() {
        tablero.inicializar();
        turnoActual = Ficha.ColorFicha.BLANCA;
        filaSeleccionada = colSeleccionada = -1;
    }

    public void seleccionar(int fila, int col) {

        //if (tablero.esFinDeJuego())
           // return;

        Ficha ficha = tablero.getFicha(fila, col);

        if (filaSeleccionada != -1) {

            List<Tablero.Movimiento> movd = tablero.obtenerMovimientosValidosDesde(filaSeleccionada, colSeleccionada);

            for (Tablero.Movimiento m : movd) {
                if (m.filaDestino == fila && m.colDestino == col) {
                    tablero.aplicarMovimiento(m);
                    filaSeleccionada = colSeleccionada = -1;
                    cambiarTurno();
                    return;
                }
            }

        }

        if (ficha != null && ficha.getColor() == turnoActual) {
            filaSeleccionada = fila;
            colSeleccionada = col;
        }
    }

    private void cambiarTurno(){
        turnoActual = (turnoActual == Ficha.ColorFicha.BLANCA) ? Ficha.ColorFicha.NEGRA : Ficha.ColorFicha.BLANCA;
    }

    public List<Tablero.Movimiento> getMovimientosSeleccionados() {
        if (filaSeleccionada == -1) return List.of();
        return tablero.obtenerMovimientosValidosDesde(filaSeleccionada, colSeleccionada);
    }

    public int getFilaSeleccionada(){
        return filaSeleccionada;
    }

    public int getColSeleccionada(){
        return colSeleccionada;
    }

    public Tablero getTablero(){
        return tablero;
    }

    public Ficha.ColorFicha getTurnoActual(){
        return turnoActual;
    }

}
