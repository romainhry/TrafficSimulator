package player;

import javax.lang.model.element.VariableElement;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.Car.CarObject;
import model.math.Point2f;
/*This class will let us to manage the Keyboards inputs and then determine
 * the corresponding action that the player car will execute*/
public class KeyBoardInputs implements EventHandler<KeyEvent>{
	CarObject playerCar;
	int  speed;
	public KeyBoardInputs(){
		playerCar = new CarObject(0);
		speed = 3;
	}
    @Override
    public void handle(KeyEvent e) {
    	try{
    	if (e.getCode() == KeyCode.UP) {
    		speed++;
    		this.playerCar.setInfluence(new Point2f(speed,0));
			System.out.println("up");
		}else if (e.getCode() == KeyCode.DOWN) {
			speed--;
			if(speed<0)
				speed=0;
			this.playerCar.setInfluence(new Point2f(speed,0));
			System.out.println("down");
		}else if (e.getCode() == KeyCode.LEFT) {
			if (playerCar.getDirection() > 1) {
				playerCar.setTurnTo(1);
			}
			System.out.println("left");
		}else if (e.getCode() == KeyCode.RIGHT) {
			if (playerCar.getDirection() > 2) {
				playerCar.setTurnTo(2);
			}
			System.out.println("right");
		}else if (e.getCode() == KeyCode.ENTER) {
			//claxon
			System.out.println("claxon");
		}
    	}catch(Exception exc){
    	System.out.println(exc);	
    	}
    }
    public CarObject getPlayerCar(){
    	return this.playerCar;
    }
    public void setPlayerCar(CarObject p){
    	this.playerCar = p;
    }
}