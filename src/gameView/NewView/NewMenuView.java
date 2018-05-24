package gameView.NewView;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 *
 * @author Vincent
 * @version 1.0
 * @since 07/05/2018
 *
 * Description:
 * MenuView class shows
 * 1) the control button (such as 'undo', 'save')
 * 2) turns No.
 * 3) who's turn
 * 4) time limitation for each move
 */
public class NewMenuView {
	Button undoBtn = new Button("Undo");
	//Button saveBtn = new Button("Save");

	Button bAbility = new Button("Ability");
	Button bAttack = new Button("activityAttack");
	Button bMove = new Button("activityMove");
	HBox menuBar = new HBox();
	HBox actionBar = new HBox();

	public NewMenuView(){
		menuBar.getChildren().add(undoBtn);
		//menuBar.getChildren().add(saveBtn);
		actionBar.getChildren().add(bAbility);
		actionBar.getChildren().add(bAttack);
		actionBar.getChildren().add(bMove);

	}




	public Button getbAbility() {
		return bAbility;
	}

	public Button getbAttack() {
		return bAttack;
	}

	public Button getbMove() {
		return bMove;
	}

	public HBox getActionBar() {
		return actionBar;
	}

	public Button getUndoBtn(){
		return undoBtn;
	}

	public HBox getMenuBar(){
		return menuBar;
	}

}
