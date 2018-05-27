package gameController.Controller;

import java.util.Timer;
import java.util.TimerTask;

import gameModel.Observable;
import gameModel.TimerCount;
import gameView.MainView.TimerView;
import gameView.MainView.TimerView2;
import gameView.MainView.TurnView;

/**
 *
 * @author 		Jie Yi
 * @version		1.4
 * @since		1.0
 *
 * Description:
 *	this class is designed as singleton pattern, in order to ensure there is only one instance of TurnChecker
 */

public class TurnChecker {

	private static TurnChecker INSTANCE = null;
	private int turnNum;
	private String who;

	public TurnChecker(){
	}
	/**
	 * return the integer when called this method
	 * @Ensrure ("turnNum >=0")
	 */
	public void inCount(){
		turnNum += 1;
		TurnView.getInstance().updateText(isWho());

		TimerTask timerTask = (TimerTask)new TimerCount();
		((TimerView) TimerView.getInstance()).setObservee((Observable) timerTask);
		((TimerView2) TimerView2.getInstance()).setObservee((Observable) timerTask);
		Timer timer = new Timer(false);
		timer.scheduleAtFixedRate(timerTask, 0, 1000);
	}
	/**
	 * return the boolean when called this method
	 * @Ensrure ("return boolean")
	 */
	public boolean isTurn(){
		if(turnNum % 2 == 0)
			return true; // true means red turn
		return false; // false means blue turn
	}

	public void deCount(){
		turnNum -= 1; // used in undo function
		TimerTask timerTask = (TimerTask)new TimerCount();
		((TimerView) TimerView.getInstance()).setObservee((Observable) timerTask);
		((TimerView2) TimerView2.getInstance()).setObservee((Observable) timerTask);
		Timer timer = new Timer(false);
		timer.scheduleAtFixedRate(timerTask, 0, 1000);
	}

	public static synchronized TurnChecker getInstance(){
		if(INSTANCE == null)
			INSTANCE = new TurnChecker();
		return INSTANCE;
	}

	public String isWho(){
		if(isTurn()){
			return who = "RED";
		}else
			return who = "BLUE";
	}
}
