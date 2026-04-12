import java.util.ArrayList;
import java.util.List;

public class ControladorJuego {

    // Controlara la logica del juego

    private Tablero tablero;
    private Ficha.ColorFicha turnoActual;

    private int filaSeleccionada = -1;
    private int colSeleccionada = -1;
    
    //Esta es una nueva variable para controlar saltos consecutivos
    private boolean capturaMultipleEnProgreso = false;

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

        if (tablero.finalDelJuego())
            return;

        Ficha ficha = tablero.getFicha(fila, col);

        if (filaSeleccionada != -1) {


            List<Tablero.Movimiento> movd = getMovimientosSeleccionados();

            for (Tablero.Movimiento m : movd) {
                if (m.filaDestino == fila && m.colDestino == col) {
                    tablero.aplicarMovimiento(m);
                    
                    //Para captura multiple:
                    // Si capturo y puede seguir capturando con la misma ficha...
                    if (m.esCaptura && tieneMasCapturas(m.filaDestino, m.colDestino)) {
                        filaSeleccionada = m.filaDestino;
                        colSeleccionada = m.colDestino;
                        capturaMultipleEnProgreso = true; //Para bloquear cambio de turno
                    } else {
                        // Para movimiento normal o fin de capturas
                        filaSeleccionada = colSeleccionada = -1;
                        capturaMultipleEnProgreso = false;
                        cambiarTurno();
                    }
                    return;
                }
            }
            
            // Si el clic no fue un movimiento valido y no es obligatorio seguir capturando
            //para  permitir deseleccionar o cambiar de ficha.
            if (!capturaMultipleEnProgreso) {
                filaSeleccionada = colSeleccionada = -1;
            }
        }

        // Selección de ficha (Solo si no estamos en medio de un salto obligatorio)
        if (!capturaMultipleEnProgreso && ficha != null && ficha.getColor() == turnoActual) {
            filaSeleccionada = fila;
            colSeleccionada = col;
        }
    }

    // Metodo auxiliar para detectar si una ficha tiene saltos disponibles
    private boolean tieneMasCapturas(int f, int c) {
        List<Tablero.Movimiento> movs = tablero.obtenerMovimientosValidosDesde(f, c);
        for (Tablero.Movimiento m : movs) {
            if (m.esCaptura) return true;
        }
        return false;
    }

    private void cambiarTurno() {
        turnoActual = (turnoActual == Ficha.ColorFicha.BLANCA) ? Ficha.ColorFicha.NEGRA : Ficha.ColorFicha.BLANCA;
    }

    public List<Tablero.Movimiento> getMovimientosSeleccionados() {
        if (filaSeleccionada == -1) return List.of();
        
        List<Tablero.Movimiento> todos = tablero.obtenerMovimientosValidosDesde(filaSeleccionada, colSeleccionada);
        
        
        if (capturaMultipleEnProgreso) {
            List<Tablero.Movimiento> soloCapturas = new ArrayList<>();
            for (Tablero.Movimiento m : todos) {
                if (m.esCaptura) soloCapturas.add(m);
            }
            return soloCapturas;
        }
        
        return todos;
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
