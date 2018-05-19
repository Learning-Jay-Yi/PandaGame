package gameView.Option;

import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

/**
 *
 * @author Yu Liu
 * @version 1.0
 * @since 12/05/2018
 *
 * GameTypeOptionView has 2 radio buttons: Normal and Obstacles Game
 *
 */
public class GameTypeOptionView {

	private RadioButton btn1 = new RadioButton("Normal Game");
	private RadioButton btn2 = new RadioButton("Obstacles Game");
	private ToggleGroup btnGroup = new ToggleGroup();
	private Label typeLabel = new Label("Game Type");

	public GameTypeOptionView(){
		btn1.setSelected(true);
		btn1.setToggleGroup(btnGroup);
		btn2.setToggleGroup(btnGroup);
	}

	public HBox getGameTypeOption(){
		HBox root = new HBox();
		root.getChildren().addAll(typeLabel, btn1, btn2);
		return root;
	}
}
