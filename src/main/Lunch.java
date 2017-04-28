package main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author hp
 */
public class Lunch extends Application {
    public Stage stage;
    @Override
    public void start(Stage stage) throws Exception {
       stage= new Stage();
       //StageStyle.UNDECORATED
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/Vue.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMaxHeight(800);
        stage.setMaxWidth(1080);
        stage.setResizable(false);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}

