package gameController;

/**
 *
 * @author 		Jie Yi
 * @version		1.2
 * @since		1.0
 *
 * Description:
 *	this class is designed as singleton pattern, in order to ensure there is only one instance of TurnChecker
 */

public class TurnChecker {

	private static TurnChecker INSTANCE = null;
	private int turnNum;

	public TurnChecker(){
	}
	/**
	 * return the integer when called this method
	 * @Ensrure ("turnNum >=0")
	 */
	public void incount(){
		turnNum += 1;
	}
	/**
	 * return the boolean when called this method
	 * @Ensrure ("return boolean")
	 */
	public boolean isTurn(){
		if(turnNum % 2 == 0)
			return true;
		return false;
	}

	public void decount(){
		turnNum -= 1;
	}

	public static synchronized TurnChecker getInstance(){
		if(INSTANCE == null)
			INSTANCE = new TurnChecker();
		return INSTANCE;
	}
}
