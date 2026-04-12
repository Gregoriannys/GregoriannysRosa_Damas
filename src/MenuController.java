import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class MenuController {

    @FXML
    private VBox contenedor;

    @FXML
    public void initialize(){
        contenedor.setOpacity(0);

    FadeTransition fade = new FadeTransition(Duration.seconds(1), contenedor);
    fade.setToValue(1);
    fade.play();
    }

    @FXML
    private void iniciarJuego(){
        try{
            Main.mostarJuego();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void salir(){
        System.exit(0);
    }
    
}
