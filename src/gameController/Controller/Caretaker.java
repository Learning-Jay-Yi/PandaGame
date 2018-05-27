package gameController.Controller;

import gameModel.*;
import gameView.MainView.TimerView;
import gameView.MainView.TimerView2;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


/**
 *
 * @author Vincent
 * @version 1.5
 * @since 04/05/2018
 *
 * Description:
 * Caretaker is to manipulate GameLog: create and save new GameLog,
 * Caretaker is part of Memento pattern
 */


public class Caretaker {

	private ArrayList<GameLog> logList = new ArrayList<>();
	private boolean flag = false;


	public Caretaker(){
	}

	public ArrayList<GameLog> getMemento(){
		return logList;
	}

	public boolean getFlag(){
		return flag;
	}

	public void setFlag(boolean b){
		this.flag = b;
	}

	public void addMemento(GameLog log){
		flag = false; // make sure one undo session is done
		logList.add(log);
		TimerTask timerTask = (TimerTask)new TimerCount();
		((TimerView) TimerView.getInstance()).setObservee((Observable) timerTask);
		((TimerView2) TimerView2.getInstance()).setObservee((Observable) timerTask);
		Timer timer = new Timer(false);
		timer.scheduleAtFixedRate(timerTask, 0, 1000);

	}

}
