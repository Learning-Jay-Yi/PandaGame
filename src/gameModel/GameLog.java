package gameModel;

/**
 *
 * @author Vincent
 * @version 1.0
 * @since 04/05/2018
 *
 * Description:
 * GameLog defines a structure that will recording the process of running game.
 */
public class GameLog {
	private static int turnID; //recording turn's number for each move.

	private PlayerType player;
	private RoleType role;
	private int[] newCoordinate = new int[2];
	private int[] oldCoordinate = new int[2];

	private String action; // action player did, this data type will change later.

	public GameLog(PlayerType p, RoleType r, int oldX, int oldY, int newX, int newY){
		this.player = p;
		this.role = r;
		this.newCoordinate[0] = newX;
		this.newCoordinate[1] = newY;
		this.oldCoordinate[0] = oldX;
		this.oldCoordinate[1] = oldY;
		turnID++;
	}

	public static int getTurnID() {
		return turnID;
	}

	public PlayerType getPlayer() {
		return player;
	}

	public RoleType getRole() {
		return role;
	}

	public int[] getNewCoordinate() {
		return newCoordinate;
	}

	public int[] getOldCoordinate() {
		return oldCoordinate;
	}

}
