import javafx.fxml.FXML;

public class MenuController {

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
