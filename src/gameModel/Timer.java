package gameModel;

import gameController.TurnChecker;
import gameView.Observer;
import gameView.TimerView;

/**
 *
 * @author Yu Liu
 * @version 1.0
 * @since 16/05/2018
 *
 * Timer is used to count down at each turn
 *
 */
public class Timer implements Observable{

	private Observer timer;
	private static Observable singleTimer = null;

	int mm;
	int ss;

	boolean timeUp = true;

	public Timer(){

	}

	public static synchronized Observable getInstance(){
		if(singleTimer == null)
			singleTimer = new Timer();
		return singleTimer;
	}

	public void timeCount(int time){
		while(time > 0){
			time--;
			try{
				Thread.sleep(1000);
				setTime(time / 60 % 60, time % 60);
				notifyObserver();
			}
			catch (InterruptedException e){
				e.printStackTrace();
			}
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
