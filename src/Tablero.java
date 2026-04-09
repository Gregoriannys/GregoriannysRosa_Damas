import java.util.ArrayList;
import java.util.List;

public class Tablero {

    // Representara el tablero del juego

    private Ficha[][] casillas;
    private boolean finDeJuego = false;

    public Tablero() {

        casillas = new Ficha[8][8];
        inicializar();

    }

    // Para inicializar el tablero con piezas
    public void inicializar() {
        finDeJuego = false;

        for (int f = 0; f < 8; f++) {
            for (int c = 0; c < 8; c++) {
                casillas[f][c] = null;
            }
        }

        // Las negras arriba
        for (int f = 0; f <= 2; f++) {
            for (int c = 0; c < 8; c++) {
                if ((f + c) % 2 != 0) {
                    casillas[f][c] = new Ficha(Ficha.ColorFicha.NEGRA);
                }
            }
        }

        // Las blancas debajo
        for (int f = 5; f <= 7; f++) {
            for (int c = 0; c < 8; c++) {
                if ((f + c) % 2 != 0) {
                    casillas[f][c] = new Ficha(Ficha.ColorFicha.BLANCA);
                }
            }
        }
    }

    public Ficha getFicha(int fila, int col) {
        if (!enRango(fila, col))
            return null;
        return casillas[fila][col];
    }

    public void setFicha(int fila, int col, Ficha ficha) {
        if (!enRango(fila, col))
            return;
        casillas[fila][col] = ficha;
    }

    private boolean enRango(int f, int c) {
        return f >= 0 && f < 8 && c >= 0 && c < 8;
    }

    // Para representar movimientos, esta clase interna
    public static class Movimiento {
        public int filaOrigen, colOrigen;
        public int filaDestino, colDestino;
        public boolean esCaptura;
        public int filaCapturada, colCapturada;

        public Movimiento(int fo, int co, int fd, int cd) {
            this.filaOrigen = fo;
            this.colOrigen = co;
            this.filaDestino = fd;
            this.colDestino = cd;
            this.esCaptura = false;
        }

        public Movimiento(int fo, int co, int fd, int cd, int fc, int cc) {
            this(fo, co, fd, cd);
            this.esCaptura = true;
            this.filaCapturada = fc;
            this.colCapturada = cc;

        }

    }

    // Para obtener los movimientos validos
    public List<Movimiento> obtenerMovimientosValidosDesde(int fila, int col) {
        List<Movimiento> lista = new ArrayList<>();

        Ficha ficha = getFicha(fila, col);
        if (ficha == null)
            return lista;

        int[][] direcciones;

        if (ficha.isDama()) {
            direcciones = new int[][] {
                    { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 }
            };
        } else if (ficha.getColor() == Ficha.ColorFicha.BLANCA) {
            direcciones = new int[][] {
                    { -1, 1 }, { -1, -1 }
            };
        }else {
            direcciones = new int[][]{
                {1,1},{1,-1}
            };
        }

        // Para movimiento simple
        for (int[] d : direcciones) {
            int fn = fila + d[0];
            int cn = col + d[1];

            if (enRango(fn, cn) && getFicha(fn, cn) == null) {
                lista.add(new Movimiento(fila, col, fn, cn));
            }
        }

        // Para captura
        for (int[] d : direcciones) {
            int fm = fila + d[0];
            int cm = col + d[1];
            int fd = fila + 2 * d[0];
            int cd = col + 2 * d[1];

            if (enRango(fd, cd) && enRango(fm, cm)) {
                Ficha medio = getFicha(fm, cm);

                if (medio != null &&
                        medio.getColor() != ficha.getColor() &&
                        getFicha(fd, cd) == null) {

                    lista.add(new Movimiento(fila, col, fd, cd, fm, cm));
                }
            }
        }

        return lista;
    }

    public void aplicarMovimiento(Movimiento m) {
        Ficha origen = getFicha(m.filaOrigen, m.colOrigen);

        setFicha(m.filaOrigen, m.colOrigen, null);
        setFicha(m.filaDestino, m.colDestino, origen);

        if (m.esCaptura) {
            setFicha(m.filaCapturada, m.colCapturada, null);
        }

        // Para convertir en dama
        if (origen != null && !origen.isDama()) {
            if (origen.getColor() == Ficha.ColorFicha.BLANCA && m.filaDestino == 0) {
                origen.setDama(true);
            }
            if (origen.getColor() == Ficha.ColorFicha.NEGRA && m.filaDestino == 7) {
                origen.setDama(true);
            }
        }
    }

}
