package gameModel;

import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;

import gameModel.HeroModel.Hero;
import gameModel.HeroModel.HeroType;

/**
 *
 * @author Vincent
 * @version 1.3
 * @since 04/05/2018
 *
 * Description:
 * GameLog defines a structure that will recording the process of running game.
 * GameLog is part of memento pattern
 */
@Invariant("turnID != null")
public class GameLog {
	private static int turnID; //recording turn's number for each move.

	private PlayerType player;
	private HeroType role;
	Hero hero;
	private int[] newCoordinate = new int[2];
	private int[] oldCoordinate = new int[2];

	private String action; // action player did, this data type will change later.


	public GameLog(PlayerType p, HeroType r, Hero hero){
		this.player = p;
		this.role = r;
		this.hero = hero;
		turnID++;
	}
	
	@Ensures("oldX != null, oldY != null")
	public void setOldCoordinate(int oldX, int oldY){
		this.oldCoordinate[0] = oldX;
		this.oldCoordinate[1] = oldY;
	}

	@Ensures("newX != null, newY != null")
	public void setNewCoordinate(int newX, int newY){
		this.newCoordinate[0] = newX;
		this.newCoordinate[1] = newY;
	}

	public static int getTurnID() {
		return turnID;
	}

	public PlayerType getPlayer() {
		return player;
	}

	public HeroType getRole() {
		return role;
	}

	public int[] getNewCoordinate() {
		return newCoordinate;
	}

	public int[] getOldCoordinate() {
		return oldCoordinate;
	}

}
