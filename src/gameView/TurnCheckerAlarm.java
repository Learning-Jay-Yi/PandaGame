package gameView;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author 		Dario
 * @version		1.1
 * @since		1.0
 *
 * Description:
 *
 *
 */

public class TurnCheckerAlarm {

	/**
	 * create an alarm when the rules is triggered
	 */
	public static void display(){
		Stage windows = new Stage();

		windows.initModality(Modality.APPLICATION_MODAL);
		windows.setTitle("Warning");

		Label label = new Label();
		label.setText(" This is not your turn ");

		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setPadding(new Insets(5, 5, 5, 5));
		gridPane.setVgap(20);

		Button btn = new Button("Ok");
		btn.setOnAction(e -> windows.close());


		gridPane.add(label, 0 , 0);
		gridPane.add(btn, 1 ,1);


		Scene scene = new Scene(gridPane);
		windows.setScene(scene);
		windows.showAndWait();
	}
}
