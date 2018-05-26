package gameView.PickHeroView;

import java.io.IOException;

import gameController.Option.GameStart;
import gameModel.HeroPool;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
	private HeroPickView heroPick;

	private Button startBtn = new Button("Game Start");
	Stage window = new Stage();

	public OptionWindow(ObservableList<HeroPool> data){
		heroPick = new HeroPickView(data);
	}

	public void displayOption(){

		BorderPane rootPane = new BorderPane();

		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Pick Hero");

		rootPane.setTop(typeOption.getGameTypeOption());
		rootPane.setCenter(heroPick.getHeroPick());

		rootPane.setBottom(startBtn);

		startBtn.setOnAction(e->{
			try {
				GameStart start = new GameStart(heroPick.getRedData(), heroPick.getBlueData());
				start.heroPoolData();
				window.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		Scene scene = new Scene(rootPane);
		window.setScene(scene);
		window.showAndWait();

	}




}
