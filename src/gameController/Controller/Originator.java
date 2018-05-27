package gameController.Controller;

import gameModel.GameLog;
import gameModel.PlayerType;
import gameModel.HeroModel.Hero;
import gameModel.HeroModel.HeroType;

/**
 *
 * @author Dario
 * @version 1.3
 * @since 12/05/2018
 *
 * Memento pattern and singleton pattern
 *
 */

public class Originator {
	private GameLog log;
	private static Originator instance = null;
	private static boolean done = false;
	private Originator(){

	}

	public static Originator getInstance(){
		if(done){
			instance = null;
			done = false;
		}
		if(instance == null){
			instance = new Originator();
		}
		return instance;
	}

	public void createNewLog(PlayerType p, HeroType r, Hero hero, int oldX, int oldY){
		log = new GameLog(p, r,hero);
		log.setOldCoordinate(oldX, oldY);
	}

	public void updateNewLog(int newX, int newY){
		log.setNewCoordinate(newX, newY);
	}

	public GameLog getMemento(){
		done = true;
		return log;
	}

}
