import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

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

                    celda.getChildren().add(pieza);

                }

                int fila = f;
                int col = c;

                celda.setOnMouseClicked(e -> {
                    controlador.seleccionar(fila, col);
                    actualizarUI();
                });

                gridTablero.add(celda, c, f);

            }
        }

    }

    private void actualizarUI() {
        lblTurno.setText("Turno: " + controlador.getTurnoActual());
        dibujar();

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
