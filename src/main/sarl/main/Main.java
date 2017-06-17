package main;
import Controllers.KeyBoardInputs;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 *
 * @author hp
 */
public class Main extends Application {
    public static Stage stage;
    @Override
    public void start(Stage stage) throws Exception {
       //StageStyle.UNDECORATED
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/Vue.fxml"));
        Scene scene = new Scene(root);
        scene.addEventHandler(KeyEvent.KEY_PRESSED,new KeyBoardInputs()); 
        stage.setScene(scene);
        //stage.setMaxHeight(800);
        //stage.setMaxWidth(1080);
        stage.sizeToScene();
        
        stage.setResizable(true);
        stage.show();
        Main.stage = stage;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}

