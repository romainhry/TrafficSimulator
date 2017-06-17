package main;
import java.awt.AWTEvent;
import java.awt.Dimension;
import java.awt.Toolkit;
import javafx.scene.input.KeyEvent;

import javax.swing.JFrame;

import Controllers.KeyBoardInputs;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

/**
 *
 * @author hp
 */
public class Main extends Application {
    public static Stage stage;
    
    //@Override
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

