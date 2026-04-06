import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage ventana;

    @Override
    public void start(Stage primaryStage ) throws Exception {
        ventana = primaryStage;
        mostarMenu();
        ventana.setTitle("juego de Damas");
        ventana.show();
    }

    public static void mostarMenu() throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("menu.fxml"));
        Scene scene = new Scene(loader.load(), 800, 600);
        ventana.setScene(scene);
    }

    public static void mostarJuego() throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("juego.fxml"));
        Scene scene = new Scene(loader.load(), 1000, 700);
        ventana.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
