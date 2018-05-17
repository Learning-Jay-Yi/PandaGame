package gameView;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

/**
 *
 * @author Vincent
 * @version 1.0
 * @since 08/05/2018
 *
 * place game board and menu on frame view.
 */
public class FrameView {

	private BorderPane framePane = new BorderPane();

	public FrameView(Pane gameBoard, HBox menu, HBox hBox){
		this.setFrame(gameBoard, menu, hBox);
	}

	public void setFrame(Pane gameBoard, HBox menu, HBox hBox){

		this.framePane.setCenter(gameBoard);
		this.framePane.setTop(hBox);
		this.framePane.setBottom(menu);

	}

	public BorderPane displayFrame(){
		return framePane;
	}


}
