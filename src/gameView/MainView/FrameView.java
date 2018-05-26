package gameView.MainView;

import javafx.scene.layout.*;

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

	public FrameView(Pane gameBoard, HBox menu, HBox timer){
		this.timer1 = ((TimerView) TimerView.getInstance()).getTimer();
		this.timer2 = ((TimerView2) TimerView2.getInstance()).getTimer();
		this.setFrame(gameBoard, menu);
	}

	public void setFrame(Pane gameBoard, HBox menu){

		this.framePane.setCenter(gameBoard);
		this.framePane.setTop(getTopPane());
		this.framePane.setBottom(menu);

	}

	private GridPane getTopPane(){
		GridPane top = new GridPane();
		top.add(timer1, 0, 0);
		top.add(TurnView.getInstance().display(), 1, 0);
		top.add(timer2, 0, 1 , 1, 1);
		return top;
	}

//	public HBox getTimerPane(){
//		HBox h = new HBox();
//
//		h.getChildren().addAll(timer1, TurnView.getInstance().display() ,timer2);
//		return h;
//	}
	public BorderPane displayFrame(){
		return framePane;
	}


}
