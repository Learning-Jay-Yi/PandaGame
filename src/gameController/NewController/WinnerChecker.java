package gameController.NewController;

/**
 *
 * @author Dario
 *
 */
public class WinnerChecker {

	private static WinnerChecker Instance;
	public WinnerChecker(){

	}

	public static WinnerChecker getInstance(){
		if(Instance == null)
			Instance = new WinnerChecker();
		return Instance;
	}





}
