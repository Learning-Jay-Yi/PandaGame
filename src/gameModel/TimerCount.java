package gameModel;

import java.util.ArrayList;
import java.util.TimerTask;

import gameController.TurnChecker;
import gameController.NewController.NewTurnChecker;
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

	private ArrayList<Observer> timer = new ArrayList<>();
	private static Observable singleTimer = new TimerCount();

	private int time = 90;
	private int timeSpent = 0;
	private int mm = 0;
	private int ss = 0;
	private int count;

	public TimerCount(){

	}

	@Override
	public void run() {
		setTime(time / 60 % 60, time % 60);
		notifyObserver();
		time--;
		count++;
		if(time == 0 ){
			((TimerTask) singleTimer).cancel();
		}
	}

	public int getCount(){
		if(count > 30)
			count = 0;
		return count;
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

	public int getTime(){
		return time;
	}

	@Override
	public void addObserver(Observer o) {
		timer.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		timer.remove(o);

	}

	@Override
	public void notifyObserver() {
		for(Observer o : timer)
			o.update();
	}




}
