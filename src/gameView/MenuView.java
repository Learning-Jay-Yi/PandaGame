package gameView;

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
public class MenuView {
	Button undoBtn = new Button("Undo");
	Button saveBtn = new Button("Save");
	HBox menuBar = new HBox();

	public MenuView(){
		menuBar.getChildren().add(undoBtn);
		menuBar.getChildren().add(saveBtn);
	}

	public Button getUndoBtn(){
		return undoBtn;
	}

	public HBox getMenuBar(){
		return menuBar;
	}

}
