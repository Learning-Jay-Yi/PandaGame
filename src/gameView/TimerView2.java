package gameView;

import gameModel.Observable;
import gameModel.TimerCount;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class TimerView2 implements Observer{
	private Label label = new Label("Time Spent: ");
	private Label mmLabel = new Label();
	private Label middle = new Label(" : ");
	private Label ssLabel = new Label();
	private Observable timer;
	private HBox timerPane = new HBox();

	private static Observer Instance = null;

	public static synchronized Observer getInstance(){
		if(Instance == null)
			Instance = new TimerView2();
		return Instance;
	}

	public TimerView2(){
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
		int mt = 0;
		int st = 60 - ((TimerCount) timer).getSt();
		System.out.println(mt + " "+ st);
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
