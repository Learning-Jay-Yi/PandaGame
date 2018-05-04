package gameModel;

/**
 *
 * @author 		Yu Liu
 * @version 	1.3
 * @since 		1.0
 *
 * @purpose		an abstract class which implements move interface
 *
 * @return
 */
public abstract class Hero implements Move{
	private PlayerType pType;
	private RoleType rType;
	private int startX;
	private int startY;

	protected int[] validX; //store every number of x of valid tiles to this hero
	protected int[] validY; //store every number of y of valid tiles to this hero
	
	public Hero(){
	}
	/**
	 * return integer array
	 * @Ensure ("validX != null")
	 */
	public int[] getValidX(){
		return validX;
	}
	/**
	 * return integer array
	 * @Ensure ("validY != null")
	 */
	public int[] getValidY(){
		return validY;
	}
	/**
	 * set the Player type
	 * @Requires ("pType == RED || pType == BLUE")
	 */
	public void setPlayerType(PlayerType pType) {
		this.pType = pType;
	}
	/**
	 * set the Role type
	 * @Requires ("rType == WARRIOR || rType == RANGER || rType == SUPPOER")
	 */
	public void setRoleType(RoleType rType) {
		this.rType = rType;
	}
	/**
	 * set the start location in X
	 * @Requires ("startX>=0"，"startX<=0")
	 */
	public void setStartX(int startX) {
		this.startX = startX;
	}
	/**
	 * set the start location in Y
	 * @Requires ("startY>=0","startY<=0")
	 */
	public void setStartY(int startY) {
		this.startY = startY;
	}
	/**
	 * return Player type
	 * @Ensures (""pType == RED || pType == BLUE")
	 */
	public PlayerType getPlayerType(){
		return pType;
	}
	/**
	 * return the Role type
	 * @Ensures ("rType == WARRIOR || rType == RANGER || rType == SUPPOER")
	 */
	public RoleType getRoleType(){
		return rType;
	}
	/**
	 * return the start location in X
	 * @Ensures ("startX>=0", "startX<=0")
	 */
	public int getStartX(){
		return startX;
	}
	/**
	 * return the start location in Y
	 * @Ensures ("startY>=0","startY<=0")
	 */
	public int getStartY(){
		return startY;
	}
}
