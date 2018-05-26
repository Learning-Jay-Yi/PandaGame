package gameView;

import gameModel.Observable;
import gameModel.TimerCount;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class TimerView2 implements Observer{
	private Text text = new Text("Time Remaining:\t");
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
		timerPane.setVisible(false);
		return timerPane;
	}

	private void setCountPane(){
		timerPane.getChildren().addAll(text, mmLabel, middle, ssLabel);
	}
	private void timeSetting(){
		int mt = 0;
		int st = 0;
		int time = ((TimerCount) timer).getTime();
		int count = ((TimerCount) timer).getCount();

		if(time % 2 == 0)
			text.setFill(Color.RED);
		else
			text.setFill(Color.BLACK);
		if(count == 30){
			timerPane.setVisible(true);
			mt = time / 60 % 60;
			st = time % 60;
			mmLabel.setText(Integer.toString(mt));
			ssLabel.setText(Integer.toString(st));
		}

	}

	@Override
	public void update() {
		Platform.runLater(()->{
			timeSetting();
		});
	}
}
