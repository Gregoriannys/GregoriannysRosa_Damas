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

        dibujarTablero();
    }

    private void dibujarTablero() {
        gridTablero.getChildren().clear();

        for (int f = 0; f < 8; f++) {
            for (int c = 0; c < 8; c++) {

                Rectangle rect = new Rectangle(SIZE, SIZE);

                boolean oscura = (f + c) % 2 != 0;
                rect.setFill(oscura ? Color.web("#2e7d32") : Color.web("#a5d6a7"));

                StackPane celda = new StackPane(rect);

                gridTablero.add(celda, c, f);

            }
        }
    }

    private void actualizarUI(){
        lblTurno.setText("Turno:  jugador 1 ");
    }

    @FXML
    private void reiniciarJuego() {
       lblGanador.setText("Ganador:");
       lblTurno.setText("Turno : jugador 1" );

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
