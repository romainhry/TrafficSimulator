package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import main.Main;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.UUID;

import GUI.CarGUI;

import java.awt.Button;


public class Controller implements Initializable {

    @FXML
    private static Group group;

    @FXML
    private Pane PaneHome,PaneVid,PaneDesc;
    
    private Button btnStart;
    private ArrayList<ImageView> groupeFeux1;
    private ArrayList<ImageView> groupeFeux2;
    

    double x,y,middleX,middleY,x2,y2;
    int config,config2;
    Polyline drawing = new Polyline(0,0,0,0,0,0) , drawing2 = new Polyline(0,0,0,0,0,0,0,0,0,0) ;
    Polygon drawingTrain = new Polygon(0,0,0,0,0,0,0,0,0,0,0,0);
    Polygon drawingWagon = new Polygon(0,0,0,0,0,0,0,0,0,0);
    
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
    
        
    }
    
    public void start ( ActionEvent e ){
    	/*
    	 *Start spawn the boot agent or let this be the boo agent who's spawning the envAgent
    	 *the car agents    	
    	 */
    	
    	group.getChildren().clear();
    	group.getChildren().add(drawing);
        group.getChildren().add(drawingTrain);
        /*
         * And add the cars imgs
         */
        //group.getChildren().add(e);

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
        
        group.getChildren().add(river);
        //System.err.println(this.getClass().getClassLoader().getParent().getClass().getResource("").getPath());
        ImageView imageVille1 = new ImageView(new Image("file:"+this.getClass().getClassLoader().getResource("").getPath()+"../../Images/ville.png"));
        imageVille1.setPreserveRatio(true);
        imageVille1.setFitWidth(70);
        imageVille1.setX(250);
        imageVille1.setY(100);
        
        ImageView imageVille2 = new ImageView(new Image("file:"+this.getClass().getClassLoader().getResource("").getPath()+"../../Images/ville.png"));
        imageVille2.setPreserveRatio(true);
        imageVille2.setFitWidth(70);
        imageVille2.setX(1110);
        imageVille2.setY(230);
        group.getChildren().add(imageVille2);
        
        ImageView imageVille3 = new ImageView(new Image("file:"+this.getClass().getClassLoader().getResource("").getPath()+"../../Images/ville.png"));
        imageVille3.setPreserveRatio(true);
        imageVille3.setFitWidth(70);
        imageVille3.setX(785);
        imageVille3.setY(545);
        group.getChildren().add(imageVille3);
        
        groupeFeux2 = new ArrayList<>();
        
        ImageView imageFeux3 = new ImageView(new Image("file:"+this.getClass().getClassLoader().getResource("").getPath()+"../../Images/greenlight.png"));
        imageFeux3.setPreserveRatio(true);
        imageFeux3.setFitHeight(25);
        imageFeux3.setX(810);
        imageFeux3.setY(150);
        imageFeux3.setId("green");
        group.getChildren().add(imageFeux3);
        groupeFeux2.add(imageFeux3);
        
        ImageView imageFeux2 = new ImageView(new Image("file:"+this.getClass().getClassLoader().getResource("").getPath()+"../../Images/redlight.png"));
        imageFeux2.setPreserveRatio(true);
        imageFeux2.setFitHeight(25);
        imageFeux2.setX(840);
        imageFeux2.setId("red");
        imageFeux2.setY(150);
        group.getChildren().add(imageFeux2);
        groupeFeux2.add(imageFeux2);
        
        ImageView imageFeux1 = new ImageView(new Image("file:"+this.getClass().getClassLoader().getResource("").getPath()+"../../Images/greenlight.png"));
        imageFeux1.setPreserveRatio(true);
        imageFeux1.setFitHeight(25);
        imageFeux1.setX(840);
        imageFeux1.setId("green");
        imageFeux1.setY(180);
        group.getChildren().add(imageFeux1);
        groupeFeux2.add(imageFeux1);
        
        ImageView imageFeux4 = new ImageView(new Image("file:"+this.getClass().getClassLoader().getResource("").getPath()+"../../Images/redlight.png"));
        imageFeux4.setPreserveRatio(true);
        imageFeux4.setFitHeight(25);
        imageFeux4.setX(810);
        imageFeux4.setId("red");
        imageFeux4.setY(180);
        group.getChildren().add(imageFeux4);
        groupeFeux2.add(imageFeux4);
        
        groupeFeux1 = new ArrayList<>();
        ImageView imageFeux5 = new ImageView(new Image("file:"+this.getClass().getClassLoader().getResource("").getPath()+"../../Images/greenlight.png"));
        imageFeux5.setPreserveRatio(true);
        imageFeux5.setFitHeight(25);
        imageFeux5.setX(355);
        imageFeux5.setY(170);
        imageFeux5.setId("green");
        group.getChildren().add(imageFeux5);
        groupeFeux1.add(imageFeux5);
        
        ImageView imageFeux6 = new ImageView(new Image("file:"+this.getClass().getClassLoader().getResource("").getPath()+"../../Images/redlight.png"));
        imageFeux6.setPreserveRatio(true);
        imageFeux6.setFitHeight(25);
        imageFeux6.setX(385);
        imageFeux6.setId("red");
        imageFeux6.setY(170);
        group.getChildren().add(imageFeux6);
        groupeFeux1.add(imageFeux6);
        
        ImageView imageFeux7 = new ImageView(new Image("file:"+this.getClass().getClassLoader().getResource("").getPath()+"../../Images/greenlight.png"));
        imageFeux7.setPreserveRatio(true);
        imageFeux7.setFitHeight(25);
        imageFeux7.setId("green");
        imageFeux7.setX(385);
        imageFeux7.setY(200);
        group.getChildren().add(imageFeux7);
        groupeFeux1.add(imageFeux7);
        
        ImageView imageStop1 = new ImageView(new Image("file:"+this.getClass().getClassLoader().getResource("").getPath()+"../../Images/stop.png"));
        imageStop1.setPreserveRatio(true);
        imageStop1.setFitHeight(20);
        imageStop1.setX(80);
        imageStop1.setY(190);
        group.getChildren().add(imageStop1);
        
        
        ImageView imageForbidden1 = new ImageView(new Image("file:"+this.getClass().getClassLoader().getResource("").getPath()+"../../Images/forbidden-way.jpg"));
        imageForbidden1.setPreserveRatio(true);
        imageForbidden1.setFitHeight(20);
        imageForbidden1.setX(670);
        imageForbidden1.setY(395);
        group.getChildren().add(imageForbidden1);
        
        ImageView imageForbidden2 = new ImageView(new Image("file:"+this.getClass().getClassLoader().getResource("").getPath()+"../../Images/forbidden-way.jpg"));
        imageForbidden2.setPreserveRatio(true);
        imageForbidden2.setFitHeight(20);
        imageForbidden2.setX(670);
        imageForbidden2.setY(425);
        group.getChildren().add(imageForbidden2);
        
        ImageView imageOneWay = new ImageView(new Image("file:"+this.getClass().getClassLoader().getResource("").getPath()+"../../Images/one-way.png"));
        imageOneWay.setPreserveRatio(true);
        imageOneWay.setFitHeight(20);
        imageOneWay.setX(670);
        imageOneWay.setY(350);
        group.getChildren().add(imageOneWay);
        
        
        ImageView imageLetPrio = new ImageView(new Image("file:"+this.getClass().getClassLoader().getResource("").getPath()+"../../Images/letPrio.jpg"));
        imageLetPrio.setPreserveRatio(true);
        imageLetPrio.setFitHeight(20);
        imageLetPrio.setX(585);
        imageLetPrio.setY(560);
        group.getChildren().add(imageLetPrio);
        
        
        ImageView image901 = new ImageView(new Image("file:"+this.getClass().getClassLoader().getResource("").getPath()+"../../Images/90.png"));
        image901.setPreserveRatio(true);
        image901.setFitHeight(20);
        image901.setX(1050);
        image901.setY(460);
        group.getChildren().add(image901);
        
        ImageView image701 = new ImageView(new Image("file:"+this.getClass().getClassLoader().getResource("").getPath()+"../../Images/70.png"));
        image701.setPreserveRatio(true);
        image701.setFitHeight(20);
        image701.setX(1090);
        image701.setY(460);
        group.getChildren().add(image701);
        
        ImageView image301 = new ImageView(new Image("file:"+this.getClass().getClassLoader().getResource("").getPath()+"../../Images/30.png"));
        image301.setPreserveRatio(true);
        image301.setFitHeight(20);
        image301.setX(40);
        image301.setY(240);
        group.getChildren().add(image301);
        
        ImageView image1301 = new ImageView(new Image("file:"+this.getClass().getClassLoader().getResource("").getPath()+"../../Images/130.png"));
        image1301.setPreserveRatio(true);
        image1301.setFitHeight(20);
        image1301.setX(600);
        image1301.setY(10);
        group.getChildren().add(image1301);
        
        
        
        
        for(int i=0; i<25; i++)
        {
        	ImageView tree1;
        	if(Math.random()>0.5)
        		tree1 = new ImageView(new Image("file:"+this.getClass().getClassLoader().getResource("").getPath()+"../../Images/tree1.png"));
        	else {
        		tree1 = new ImageView(new Image("file:"+this.getClass().getClassLoader().getResource("").getPath()+"../../Images/tree2.png"));
			}
            tree1.setPreserveRatio(true);
            tree1.setFitHeight(60);
            double y;
            double x = (Math.random() * ( 270 - 100 ))+100;
            tree1.setX(x);
            if(x<180)
            	y=Math.random() * ( 250 - 175 ) +175;
            else {
            	y=Math.random() * ( 320 - 145 )+145;
			}
            tree1.setY(y);
              
            group.getChildren().add(tree1);
        }
        
        for(int i=0; i<4; i++)
        {
        	ImageView build1;
    		build1 = new ImageView(new Image("file:"+this.getClass().getClassLoader().getResource("").getPath()+"../../Images/building.png"));

            build1.setPreserveRatio(true);
            build1.setFitHeight(Math.random() * ( 65 - 40 )+40);
            double y=i>=2?320:280;
            double x = i==1 | i==3 ?150:100;
            build1.setX(x);
            build1.setY(y);
              
            group.getChildren().add(build1);
        }
        
        for(int i=0; i<2; i++)
        {
        	ImageView build1;
    		build1 = new ImageView(new Image("file:"+this.getClass().getClassLoader().getResource("").getPath()+"../../Images/building.png"));

            build1.setPreserveRatio(true);
            build1.setFitHeight(Math.random() * ( 65 - 40 )+40);
            double y= 280 + i*40;
            double x = 20;
            build1.setY(y);
            build1.setX(x);
            group.getChildren().add(build1);
        }
        
        for(int i=0; i<4; i++)
        {
        	ImageView build1;
    		build1 = new ImageView(new Image("file:"+this.getClass().getClassLoader().getResource("").getPath()+"../../Images/building.png"));

            build1.setPreserveRatio(true);
            build1.setFitHeight(45);
            double y= 380;
            double x = 20+i*40;
            build1.setY(y);
            build1.setX(x);
            group.getChildren().add(build1);
        }
        
        ImageView build1;
		build1 = new ImageView(new Image("file:"+this.getClass().getClassLoader().getResource("").getPath()+"../../Images/building.png"));

        build1.setPreserveRatio(true);
        build1.setFitHeight(45);
        double y= 420;
        double x = 20;
        build1.setY(y);
        build1.setX(x);
        group.getChildren().add(build1);
        
		build1 = new ImageView(new Image("file:"+this.getClass().getClassLoader().getResource("").getPath()+"../../Images/house.png"));

        build1.setPreserveRatio(true);
        build1.setFitHeight(30);
        build1.setY(450);
        build1.setX(785);
        group.getChildren().add(build1);
        
        for(int i=0;i< 5;++i){
        	ImageView house1;
    		house1 = new ImageView(new Image("file:"+this.getClass().getClassLoader().getResource("").getPath()+"../../Images/house.png"));

            house1.setPreserveRatio(true);
            house1.setFitHeight(30);
            house1.setY(315+i*20);
            house1.setX(665+i*30);
            group.getChildren().add(house1);
        }
        
        for(int i=0;i< 2;++i){
        	ImageView house1;
    		house1 = new ImageView(new Image("file:"+this.getClass().getClassLoader().getResource("").getPath()+"../../Images/house.png"));

            house1.setPreserveRatio(true);
            house1.setFitHeight(30);
            house1.setY(385+i*20);
            house1.setX(695+i*30);
            group.getChildren().add(house1);
        }
        
        for(int i=0;i< 3;++i){
        	ImageView house1;
    		house1 = new ImageView(new Image("file:"+this.getClass().getClassLoader().getResource("").getPath()+"../../Images/house.png"));

            house1.setPreserveRatio(true);
            house1.setFitHeight(30);
            house1.setY(430+i*20);
            house1.setX(665+i*30);
            group.getChildren().add(house1);
        }
        
        for(int i=0;i< 4;++i){
        	ImageView house1;
    		house1 = new ImageView(new Image("file:"+this.getClass().getClassLoader().getResource("").getPath()+"../../Images/house.png"));

            house1.setPreserveRatio(true);
            house1.setFitHeight(30);
            house1.setY(140);
            house1.setX(650+i*40);
            group.getChildren().add(house1);
        }
        
        for(int i=0;i< 5;++i){
        	ImageView house1;
    		house1 = new ImageView(new Image("file:"+this.getClass().getClassLoader().getResource("").getPath()+"../../Images/house.png"));

            house1.setPreserveRatio(true);
            house1.setFitHeight(30);
            house1.setY(180);
            house1.setX(650+i*30);
            group.getChildren().add(house1);
        }
        
        
        
        ImageView tennis = new ImageView(new Image("file:"+this.getClass().getClassLoader().getResource("").getPath()+"../../Images/tennis.png"));
        
        tennis.setPreserveRatio(true);
        tennis.setFitWidth(135);
        tennis.setX(15);
        tennis.setY(480);
        group.getChildren().add(tennis);
        
        ImageView pool = new ImageView(new Image("file:"+this.getClass().getClassLoader().getResource("").getPath()+"../../Images/pool.png"));
        
        pool.setPreserveRatio(true);
        pool.setFitWidth(220);
        pool.setX(185);
        pool.setY(540);
        group.getChildren().add(pool);
        
        ImageView sm = new ImageView(new Image("file:"+this.getClass().getClassLoader().getResource("").getPath()+"../../Images/supermarket.jpg"));       
        sm.setPreserveRatio(true);
        sm.setFitWidth(120);
        sm.setX(210);
        sm.setY(470);

        group.getChildren().add(sm);
        
        ImageView mcdo = new ImageView(new Image("file:"+this.getClass().getClassLoader().getResource("").getPath()+"../../Images/mcdo.png"));       
        mcdo.setPreserveRatio(true);
        mcdo.setFitWidth(100);
        mcdo.setX(380);
        mcdo.setY(465);
        group.getChildren().add(mcdo);
        
        ImageView mairie = new ImageView(new Image("file:"+this.getClass().getClassLoader().getResource("").getPath()+"../../Images/town-hall.png"));       
        mairie.setPreserveRatio(true);
        mairie.setFitWidth(70);
        mairie.setX(520);
        mairie.setY(320);
        group.getChildren().add(mairie);
        
        ImageView fountain = new ImageView(new Image("file:"+this.getClass().getClassLoader().getResource("").getPath()+"../../Images/fountain.png"));       
        fountain.setPreserveRatio(true);
        fountain.setFitWidth(38);
        fountain.setX(615);
        fountain.setY(370);
        group.getChildren().add(fountain);
        
        group.getChildren().add(imageVille1);
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
    
    public void changeCrossLight1(){
    	for(ImageView imageFeux : groupeFeux1) {
    		if(imageFeux.getId()=="green")
        	{
        		imageFeux.setImage(new Image("file:"+this.getClass().getClassLoader().getResource("").getPath()+"../../Images/redlight.png"));
        	}
        	if(imageFeux.getId()=="red")
        	{
        		imageFeux.setImage(new Image("file:"+this.getClass().getClassLoader().getResource("").getPath()+"../../Images/greenlight.png"));
        	}
    	}	
    }
    
    public void changeCrossLight2(){
    	for(ImageView imageFeux : groupeFeux2) {
    		if(imageFeux.getId()=="green")
        	{
        		imageFeux.setImage(new Image("file:"+this.getClass().getClassLoader().getResource("").getPath()+"../../Images/redlight.png"));
        	}
        	if(imageFeux.getId()=="red")
        	{
        		imageFeux.setImage(new Image("file:"+this.getClass().getClassLoader().getResource("").getPath()+"../../Images/greenlight.png"));
        	}
    	}	
    }
    
    public static void addtoroadgui ( String imgURL , UUID UID ){
    	CarGUI car = new  CarGUI(imgURL, UID);
    	group.getChildren().add(car);
    }
   
}