package gameView.Option;

import javafx.scene.layout.BorderPane;

/**
 *
 * @author Yu Liu
 * @version 1.0
 * @since 13/05/2018
 *
 * OptionView is a GUI to let player select game type and pick heros
 *
 */
public class OptionWindow {

	private GameTypeOptionView typeOption = new GameTypeOptionView();
	private HeroPickView heroPick = new HeroPickView();

	public OptionWindow(){

	}

	public BorderPane displayOption(){
		BorderPane rootPane = new BorderPane();

		rootPane.setTop(typeOption.getGameTypeOption());
		rootPane.setCenter(heroPick.getHeroPick());
		return rootPane;
	}

}
