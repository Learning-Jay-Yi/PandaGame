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
	private int[] coordinate = new int[2];

	public GameLog(PlayerType p, RoleType r, int x, int y){
		this.player = p;
		this.role = r;
		this.coordinate[0] = x;
		this.coordinate[1] = y;
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

	public int[] getCoordinate() {
		return coordinate;
	}


}
