package gameController.Controller;

import java.util.ArrayList;

import gameModel.PlayerType;
import gameView.HeroView.HeroView;
import gameView.PopUpView.WinerView;

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

	public void checkWinner(ArrayList<HeroView> heroArray){
		boolean redWin = true;
		boolean blueWin = true;
		for(HeroView hero : heroArray){
			if(hero.getPlayerType() == PlayerType.BLUE){
				if(hero.isVisible())
					redWin = false;
			}else{
				if(hero.isVisible())
					blueWin = false;
			}
		}

		if(redWin){
			WinerView.display(redWin, blueWin);
		}else if(blueWin){
			WinerView.display(redWin, blueWin);
		}
	}




}
