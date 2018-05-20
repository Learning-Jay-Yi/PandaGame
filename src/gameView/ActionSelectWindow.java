package gameView;

import gameModel.Hero;
import gameModel.NewHero.NewHero;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

/**
 *
 * @author
 *
 */
public class ActionSelectWindow {

	private boolean bAction = false;

	private NewHero newHero;
	private HeroView heroView;
	private ArrayList<HeroView> heroViews;

	private Button abilityBtn = new Button("Ability");
	private Button attackBtn = new Button("Attack");
	private Button moveBtn = new Button("Move");


	public ActionSelectWindow(NewHero newHero, HeroView heroView, ArrayList<HeroView> heroViews){
		// try to figure out useful parameters
		this.newHero = newHero;
		this.heroView = heroView;
		this.heroViews = heroViews;
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
		return null;
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
