package gameController.Controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author 		Dario
 * @version 	1.0
 *
 * GameFrame extends application which is this game start from.
 * GameFrame instantiate a object of MainController and get board from the object into its scene
 */

public class GameFrame extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {

		MainController con = new MainController();

		Scene scene = new Scene(con.getGameFrame().displayFrame());
		primaryStage.setTitle("Panda Game");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main (String[] args){
		launch();
	}
}
