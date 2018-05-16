package gameView;

import gameModel.Observable;
import gameModel.Timer;
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
	private Label mmLabel = new Label();
	private Label middle = new Label(" : ");
	private Label ssLabel = new Label();
	private Observable timer;
	private HBox timerPane = new HBox();


	public TimerView(Observable o){
		this.timer = o;
		timer.addObserver(this);
		setTime();
		setNode();
	}


	@Override
	public void update() {
		setTime();

		System.out.print("lololo");
	}

	public void setNode(){
		timerPane.getChildren().addAll(mmLabel,middle,ssLabel);
	}

	public HBox getTimer(){
		return timerPane;
	}

	public void setTime(){

		int mt = ((Timer) timer).getMt();
		int st = ((Timer) timer).getSt();

		if(mt > 0 || st > 0){
			mmLabel.setText(Integer.toString(mt));
			ssLabel.setText(Integer.toString(st));
		}
		else {
			mmLabel.setText("00");
			ssLabel.setText("00");
		}

	}


}
