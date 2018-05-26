package gameView.PopUpView;

import com.sun.prism.paint.Color;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class WinerView {

	public static void display(boolean red, boolean blue){
		Stage windows = new Stage();

		windows.initModality(Modality.APPLICATION_MODAL);
		windows.setTitle("Congratulation!");

		Text t = new Text();
		if(red){
			t.setText(" The Winner Is RED ");
		}else if(blue){
			t.setText(" The Winner Is BLUE ");
		}

		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setPadding(new Insets(5, 5, 5, 5));
		gridPane.setVgap(20);

		//Button btn = new Button("Ok");
		//btn.setOnAction(e -> windows.close());


		gridPane.add(t, 0 , 0);
		//gridPane.add(btn, 1 ,1);


		Scene scene = new Scene(gridPane);
		windows.setScene(scene);
		windows.showAndWait();
	}
}
