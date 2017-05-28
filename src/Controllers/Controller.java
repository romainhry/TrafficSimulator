package Controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import main.Main;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


import static java.lang.Math.abs;

import java.awt.Button;


public class Controller implements Initializable {

    @FXML
    private Group group;

    @FXML
    private Pane PaneHome,PaneVid,PaneDesc;
    
    private Button btnStart;
    
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
    
        
    }
    
    public void start ( ActionEvent e ){
    	/*
    	 *Start spawn the boot agent or let this be the boo agent who's spawning the envAgent
    	 *the car agents    	
    	 */
    	
    	group.getChildren().clear();
        

        // River :
        Polyline river = new Polyline(
                150,600,
                150,450,
                500,450,
                500,330,
                530,300,
                700,300,
                800,370,
                900,300,
                1000,300,
                1000,420,
                1150,420,
                1150,300,
                1200,300
        );

        Color colorRiver = new Color((double)200/255,(double)230/255,(double)250/255,0.5);
        river.setStroke(colorRiver);
        river.setStrokeLineJoin(StrokeLineJoin.ROUND);
        river.setStrokeWidth(23);

        Polyline borderRiver = new Polyline(
                150,600,
                150,450,
                500,450,
                500,330,
                530,300,
                700,300,
                800,370,
                900,300,
                1000,300,
                1000,420,
                1150,420,
                1150,300,
                1200,300
        );

        Color colorBorder = new Color((double)100/255,(double)180/255,(double)220/255,0.5);
        borderRiver.setStroke(colorBorder);
        borderRiver.setStrokeLineJoin(StrokeLineJoin.ROUND);
        borderRiver.setStrokeWidth(31);

        group.getChildren().add(borderRiver);
      
        Main.stage.setWidth(1200);
        Main.stage.setX(-30);
        
    	
    }
    public void Desc ( ActionEvent e ){
    	PaneHome.setVisible(false);
    	PaneDesc.setVisible(true);    	
    }
    public void Video ( ActionEvent e ){
    	PaneHome.setVisible(false);
    	PaneVid.setVisible(true);
    }
    public void ReturnHome ( ActionEvent e ){
    	PaneHome.setVisible(true);
    	PaneVid.setVisible(false);
    	PaneDesc.setVisible(false);
    	group.getChildren().remove(drawingTrain);
    	group.getChildren().remove(drawingTrain);
    }
   
}