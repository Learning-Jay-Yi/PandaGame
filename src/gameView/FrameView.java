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
	private HBox timer1, timer2;

	public FrameView(Pane gameBoard, HBox menu){
		this.timer1 = ((TimerView) TimerView.getInstance()).getTimer();
		this.timer2 = ((TimerView2) TimerView2.getInstance()).getTimer();
		this.setFrame(gameBoard, menu);

	}

	public void setFrame(Pane gameBoard, HBox menu){

		this.framePane.setCenter(gameBoard);
		this.framePane.setTop(getTimerPane());
		this.framePane.setBottom(menu);

	}

	public HBox getTimerPane(){
		HBox h = new HBox();
		h.getChildren().addAll(timer1, timer2);
		return h;
	}
	public BorderPane displayFrame(){
		return framePane;
	}


}
