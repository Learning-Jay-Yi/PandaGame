package gameView;

import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

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




}
