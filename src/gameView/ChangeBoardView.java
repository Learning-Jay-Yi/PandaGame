package gameView;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Yu Liu
 *
 */
public class ChangeBoardView {

	public static void display(int h, int w){
		Stage window = new Stage();

		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Setting Board Size");

		Button smallBtn = new Button("Small Size");
		Button normalBtn = new Button("Normal Size");
		Button bigBtn = new Button("Big Size");
		VBox root = new VBox();

		smallBtn.setOnAction(e->{
			//TODO
			window.close();
		});

		normalBtn.setOnAction(e->{
			//TODO
			window.close();
		});

		bigBtn.setOnAction(e->{
			//TODO
			window.close();
		});


		root.getChildren().addAll(smallBtn, normalBtn, bigBtn);

		Scene scene = new Scene(root);
		window.setScene(scene);
		window.showAndWait();
	}
}
