package gameView.Option;

import java.io.IOException;

import gameController.Option.GameStart;
import javafx.scene.control.Button;
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

	private Button startBtn = new Button("Game Start");

	public OptionWindow(){
		startBtn.setOnAction(e->{
			try {
				GameStart start = new GameStart(heroPick.getRedData(), heroPick.getBlueData());
				start.heroPoolData();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}

	public BorderPane displayOption(){
		BorderPane rootPane = new BorderPane();

		rootPane.setTop(typeOption.getGameTypeOption());
		rootPane.setCenter(heroPick.getHeroPick());

		rootPane.setBottom(startBtn);
		return rootPane;
	}




}
