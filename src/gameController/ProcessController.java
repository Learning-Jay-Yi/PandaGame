package gameController;

import java.util.ArrayList;

import gameModel.*;
import gameView.MenuView;

/**
*
* @author Vincent
* @version 1.0
* @since 04/05/2018
*
* Description:
* ProcessController is to manipulate GameLog: create and save new GameLog, undo
*/
public class ProcessController {

	ArrayList<GameLog> logList = new ArrayList<>();
	GameLog log;

	MenuView menu;


	public ProcessController(MenuView menu){
		this.menu = menu;
		undo();
	}


	public void createNewLog(PlayerType p, RoleType r, int oldX, int oldY){
		log = new GameLog(p, r);
		log.setOldCoordinate(oldX, oldY);
	}

	public void updateNewLog(int newX, int newY){
		log.setNewCoordinate(newX, newY);
		logList.add(log);
	}

	public void undo(){
		menu.getUndoBtn().setOnAction(e ->{
			System.out.print("Let me undo");
		});
	}
}
