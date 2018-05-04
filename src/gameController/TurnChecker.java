package gameController;

/**
 *
 * @author 		Jie Yi
 * @version		1.2
 * @since		1.0
 *
 * Description:
 *
 */

public class TurnChecker {
	private static int count;
	
	public TurnChecker(){

	}
	/**
	 * return the integer when called this method
	 * @Ensrure ("count >=0")
	 */
	public int count(){
		count += 1;
		return count;
	}
	/**
	 * return the boolean when called this method
	 * @Ensrure ("return boolean")
	 */
	public boolean isTurn(){
		if(count % 2 == 0)
			return true;
		return false;
	}
}
