package gameView;

import gameController.Controller.TurnChecker;
import gameModel.Observable;
import gameModel.TimerCount;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 *
 * @author Yu Liu
 * @version 1.0
 * @since 16/05/2018
 *
 */

public class TimerView implements Observer{
	private Label label = new Label("Time:\t");
	private Label mmLabel = new Label();
	private Label middle = new Label(" : ");
	private Label ssLabel = new Label();
	private Observable timer;
	private HBox timerPane = new HBox();

	private static Observer Instance = null;

	public static synchronized Observer getInstance(){
		if(Instance == null)
			Instance = new TimerView();
		return Instance;
	}

	public TimerView(){
		setCountPane();
	}

	public void setObservee(Observable o){
		this.timer = o;
		timer.addObserver(this);
	}

	public HBox getTimer(){
		return timerPane;
	}

	private void setCountPane(){
		timerPane.getChildren().addAll(label, mmLabel, middle, ssLabel);
	}
	private void timeSetting(){
		int mt = ((TimerCount) timer).getMt();
		int st = ((TimerCount) timer).getSt();

		if(((TimerCount) timer).getTime() == 0){
			TurnChecker.getInstance().inCount();
		}

		if(mt > 0 || st > 0){
			mmLabel.setText(Integer.toString(mt));
			ssLabel.setText(Integer.toString(st));
		}
		else {
			mmLabel.setText("00");
			ssLabel.setText("00");
		}
	}

	@Override
	public void update() {
		Platform.runLater(()->{
			timeSetting();
		});
	}
}
