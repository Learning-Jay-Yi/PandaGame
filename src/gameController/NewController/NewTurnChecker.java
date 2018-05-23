package gameController.NewController;

import java.util.Timer;
import java.util.TimerTask;

import gameModel.Observable;
import gameModel.TimerCount;
import gameView.TimerView;
import gameView.TimerView2;
import gameView.TurnView;

/**
 *
 * @author 		Jie Yi
 * @version		1.2
 * @since		1.0
 *
 * Description:
 *	this class is designed as singleton pattern, in order to ensure there is only one instance of TurnChecker
 */

public class NewTurnChecker {

	private static NewTurnChecker INSTANCE = null;
	private int turnNum;
	private String who;

	public NewTurnChecker(){
	}
	/**
	 * return the integer when called this method
	 * @Ensrure ("turnNum >=0")
	 */
	public void incount(){
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

	public void decount(){
		turnNum -= 1; // used in undo function
	}

	public static synchronized NewTurnChecker getInstance(){
		if(INSTANCE == null)
			INSTANCE = new NewTurnChecker();
		return INSTANCE;
	}

	public String isWho(){
		if(isTurn()){
			return who = "RED";
		}else
			return who = "BLUE";
	}
}
