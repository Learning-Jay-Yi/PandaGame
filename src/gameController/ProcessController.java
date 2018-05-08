package gameController;

import java.util.ArrayList;

import gameModel.*;

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


	public ProcessController(){

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

	}
}
