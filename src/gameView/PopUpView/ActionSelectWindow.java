package gameView.PopUpView;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Dario
 * @version 1.4
 * @since 13/05/2018
 *
 * ActionSelectWinow shows up option to do when player click on a hero.
 *
 */
public class ActionSelectWindow {


	private Stage action;


	private Button abilityBtn = new Button("Ability");
	private Button attackBtn = new Button("Action");
	private Button moveBtn = new Button("Move");

	public ActionSelectWindow(){

	}

	public void display(){
		action = new Stage();

		action.initModality(Modality.APPLICATION_MODAL);
		action.setTitle("Actions");

		Label label = new Label("which action do you want choose?");

		HBox hBox = getActionWindow();

		GridPane pane = new GridPane();

		pane.add(label,0,0);
		pane.add(hBox,0,1);
		Scene scene = new Scene(pane);
		action.setScene(scene);
		action.showAndWait();
	}

	public Stage getWindow(){
		return action;
	}

	private HBox getActionWindow(){

		HBox buttons = new HBox();

		buttons.getChildren().add(abilityBtn);
		buttons.getChildren().add(attackBtn);
		buttons.getChildren().add(moveBtn);
		return buttons;
	}

	public Button getMoveBtn(){
		return moveBtn;
	}

	public Button getAttackBtn(){
		return attackBtn;
	}

	public Button getAbilityBtn(){
		return abilityBtn;
	}
}
