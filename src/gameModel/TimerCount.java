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

	private int time = 60;
	private int mm = 0;
	private int ss = 0;
	//private static boolean running = false;
	public TimerCount(){

	}

//	public static synchronized Observable getInstance(){
//		if(singleTimer == null)
//			singleTimer = new TimerCount();
//		return singleTimer;
//	}

//	public static void setInstance(){
//		singleTimer = new TimerCount();
//	}

//	public static boolean isRun(){
//		return running;
//	}

	@Override
	public void run() {
		//running = true;
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
