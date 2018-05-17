package gameModel;

import java.util.TimerTask;

import gameController.TurnChecker;
import gameView.Observer;
import gameView.TimerView;

/**
 *
 * @author Yu Liu
 * @version 1.1
 * @since 16/05/2018
 *
 * Timer is used to count down at each turn
 *
 */
public class TimerCount extends TimerTask implements Observable{

	private Observer timer;
	private static Observable singleTimer = null;

	int time = 120;
	int mm;
	int ss;

	public TimerCount(){

	}

	public static synchronized Observable getInstance(){
		if(singleTimer == null)
			singleTimer = new TimerCount();
		return singleTimer;
	}

	@Override
	public void run() {
		setTime(time / 60 % 60, time % 60);
		notifyObserver();
		time--;
		if(time == 0){
			((TimerTask) singleTimer).cancel();
		}

	}

	private void setTime(int mt, int st){
		mm = mt;
		ss = st;
	}

	public int getMt(){
		return mm;
	}

	public int getSt(){
		return ss;
	}

	@Override
	public void addObserver(Observer o) {
		timer = o;

	}

	@Override
	public void removeObserver(Observer o) {
		timer = null;

	}

	@Override
	public void notifyObserver() {
		timer.update();
	}




}
