package gameView;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 *
 * @author
 *
 */
public class ActionSelectWindow {


	private Button abilityBtn = new Button("Ability");
	private Button attackBtn = new Button("Attack");
	private Button moveBtn = new Button("Move");


	public ActionSelectWindow(){
		// try to figure out useful parameters
		//TODO
	}

	public void display(){
		//TODO
		//see TurnCheckerAlarm
	}

	private VBox getActionWindow(){
		setAbilityBtn();
		setAttackBtn();
		setMoveBtn();

		//TODO
	}

	/******* at end of button, need to close ActionWindow: see TurnCheckerAlarm***********/
	private void setAbilityBtn(){
		abilityBtn.setOnAction(e->{
			//TODO
		});
	}

	private void setAttackBtn(){
		attackBtn.setOnAction(e->{
			//TODO
		});
	}

	private void setMoveBtn(){
		moveBtn.setOnAction(e->{
			//TODO
		});
	}
}
