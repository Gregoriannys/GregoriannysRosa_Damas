import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

public class JuegoController {

    @FXML
    private GridPane gridTablero;

    @FXML
    private Label lblTurno;
    @FXML
    private Label lblGanador;

    private final int SIZE = 70;

    private ControladorJuego controlador = new ControladorJuego();

    @FXML
    public void initialize() {

        // Esto para configurar las filas y las columnas
        gridTablero.getColumnConstraints().clear();
        gridTablero.getRowConstraints().clear();

        for (int i = 0; i < 8; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPrefWidth(SIZE);
            gridTablero.getColumnConstraints().add(col);

            RowConstraints row = new RowConstraints();
            row.setPrefHeight(SIZE);
            gridTablero.getRowConstraints().add(row);
        }

        actualizarUI();
    }

    private void dibujar() {
        gridTablero.getChildren().clear();

        Tablero t = controlador.getTablero();

        for (int f = 0; f < 8; f++) {
            for (int c = 0; c < 8; c++) {

                Rectangle rect = new Rectangle(SIZE, SIZE);
                boolean oscura = (f + c) % 2 != 0;
                rect.setFill(oscura ? Color.web("#2e7d32") : Color.web("#a5d6a7"));

                StackPane celda = new StackPane(rect);

                // Para resaltar la seleccion
                if (f == controlador.getFilaSeleccionada() &&
                        c == controlador.getColSeleccionada()) {
                    rect.setStroke(Color.RED);
                    rect.setStrokeWidth(3);
                }

                // Para los movimientos validos
                for (Tablero.Movimiento m : controlador.getMovimientosSeleccionados()) {
                    if (m.filaDestino == f && m.colDestino == c) {
                        rect.setFill(Color.LIGHTGREEN);
                    }
                }

                // Para dibujar las fichas
                Ficha ficha = t.getFicha(f, c);
                if (ficha != null) {
                    javafx.scene.shape.Circle pieza = new javafx.scene.shape.Circle(SIZE * 0.35);

                    if (ficha.getColor() == Ficha.ColorFicha.BLANCA)
                        pieza.setFill(Color.WHITE);
                    else
                        pieza.setFill(Color.BLACK);

                    pieza.setStroke(Color.GOLD);
                    pieza.setStrokeWidth(1.5);

                    // Si es dama (REINA)
                    if (ficha.isDama()) {

                        javafx.scene.shape.Circle corona = new javafx.scene.shape.Circle(SIZE * 0.18);
                        corona.setFill(Color.GOLD);

                        // Para el efecto brillo
                        pieza.setStrokeWidth(3);
                        pieza.setStroke(Color.GOLD);

                        celda.getChildren().addAll(pieza, corona);

                    }else{

                    celda.getChildren().add(pieza);}

                }

                int fila = f;
                int col = c;

                celda.setOnMouseClicked(e -> {

                    int filaOrigen = controlador.getFilaSeleccionada();
                    int colOrigen = controlador.getColSeleccionada();

                    // Intentar mover
                    controlador.seleccionar(fila, col);

                    // Si hubo movimiento valido
                    if (filaOrigen != -1 && controlador.getFilaSeleccionada() == -1) {

                        animarMovimiento(filaOrigen, colOrigen, fila, col);

                    } else {
                        actualizarUI();
                    }
                });

                gridTablero.add(celda, c, f);

            }
        }

    }

    private void actualizarUI() {
        lblTurno.setText("Turno: " + controlador.getTurnoActual());

        if (controlador.getTablero().finalDelJuego()) {
            String ganador = controlador.getTablero().obtenerGanador();
            lblGanador.setText("GANADOR: " + ganador);
            lblGanador.setTextFill(javafx.scene.paint.Color.GOLD);
            lblTurno.setText("JUEGO TERMINADO!");

        } else {
            lblGanador.setText("Ganador en curso...");
            lblGanador.setTextFill(javafx.scene.paint.Color.BLACK);
        }
        dibujar();

    }

    private void animarMovimiento(int filaOrigen, int colOrigen, int filaDestino, int colDestino) {

        StackPane celdaOrigen = null;

        for (javafx.scene.Node node : gridTablero.getChildren()) {
            if (GridPane.getRowIndex(node) == filaOrigen &&
                    GridPane.getColumnIndex(node) == colOrigen) {
                celdaOrigen = (StackPane) node;
                break;
            }
        }

        if (celdaOrigen == null || celdaOrigen.getChildren().size() < 2) {
            actualizarUI();
            return;
        }

        javafx.scene.Node ficha = celdaOrigen.getChildren().get(1);

        TranslateTransition tt = new TranslateTransition(Duration.millis(250), ficha);

        tt.setByX((colDestino - colOrigen) * SIZE);
        tt.setByY((filaDestino - filaOrigen) * SIZE);

        tt.setOnFinished(e -> {
            actualizarUI();
        });

        tt.play();
    }

    @FXML
    private void reiniciarJuego() {
        controlador.reiniciar();
        lblGanador.setText("Ganador:");
        actualizarUI();
    }

    @FXML
    private void volverMenu() {
        try {
            Main.mostarMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
