package gameController.NewController;

import gameModel.*;
import gameView.HeroView;
import gameView.NewView.NewMenuView;
import gameView.TileView;
import gameView.TimerView;
import gameView.TimerView2;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
*
* @author Vincent
* @version 1.0
* @since 04/05/2018
*
* Description:
* ProcessController is to manipulate GameLog: create and save new GameLog, undo
* processController is part of Memento pattern
*/
public class NewProcessController {

	ArrayList<GameLog> logList = new ArrayList<>();
	GameLog log;

	NewMenuView menu;


	public NewProcessController(NewMenuView menu){
		this.menu = menu;

	}


	public void createNewLog(PlayerType p, RoleType r, int oldX, int oldY){
		log = new GameLog(p, r);
		log.setOldCoordinate(oldX, oldY);
	}

	public void updateNewLog(int newX, int newY){
		log.setNewCoordinate(newX, newY);
		logList.add(log);
		//TODO

		
	}

	public void undo(TileView[][] tileArray, ArrayList<HeroView> heroArray){
		menu.getUndoBtn().setOnAction(e ->{
			if(logList.size() > 0){
				int i = logList.size() - 1;
				int removeX = logList.get(i).getNewCoordinate()[0];
				int removeY = logList.get(i).getNewCoordinate()[1];

				int relocateX = logList.get(i).getOldCoordinate()[0];
				int relocateY = logList.get(i).getOldCoordinate()[1];

				TileView undoTile = tileArray[removeX][removeY];
				HeroView hero = undoTile.getHeroView();

				hero.move(relocateX, relocateY);
				tileArray[relocateX][relocateY].setHeroView(hero);
				tileArray[removeX][removeY].setHeroView(null);

				logList.remove(i);
				NewTurnChecker.getInstance().decount();
			}


		});
	}
}
