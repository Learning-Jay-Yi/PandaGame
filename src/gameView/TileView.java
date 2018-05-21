package gameView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


/**
 *
 * @author Jie Yi
 *
 */
public class TileView extends Rectangle{

	private HeroView hero;
	private boolean readyForMove;
	private boolean readyForAttack;
	private int x;
	private int y;
	/**
	 * constructor for initial the tile view with 3 parameters x, y, tileSize
	 * @Requires ("x == 13")
	 * @Requires ("y == 14")
	 * @Requires ("tileSize == 50")
	 */
	public TileView(int x, int y, int tileSize){
		super(tileSize, tileSize);
		this.x = x;
		this.y = y;
		this.readyForMove = false;
		this.relocate(x * tileSize, y * tileSize);
		this.setFill(Color.valueOf("#feb"));
		this.setStroke(Color.BLACK);
	}

	/**
	 * set the hero to the view
	 * @Requires ("hero != null")
	 */
	public void setHero(HeroView hero){
		this.hero = hero;

	}

	public boolean hasHero(){
		return hero != null;
	}
	/**
	 * return the hero in the view
	 * @Ensures ("hero ! = null")
	 */
	public HeroView getHero(){
		return hero;
	}
	/**
	 * set the tile view to a different color
	 * @Requires ("readyForMove == true || readyForMove == false")
	 */
	public void setReadyForMove(boolean readyForMove){
		this.readyForMove = readyForMove;
	}
	/**
	 * return the tile is readyForMove or not
	 * @Ensures ("readyForMove == true || readyForMove == false")
	 */
	public boolean isReadyToMove(){
		return readyForMove;
	}
	/**
	 * return the current location
	 * @Ensures ("x>=0","x<=14")
	 */
	public int getLocX(){
		return x;
	}
	/**
	 * return the current location
	 * @Ensures ("y>=0","y<=13")
	 */
	public int getLocY(){
		return y;
	}
	/**
	 * void method to change the color
	 */
	public void canMove() {
		this.setFill(Color.GREEN);
		this.readyForMove = true;
	}
	/**
	 * void method to set default color
	 */
	public void setDefault(){
		this.setFill(Color.valueOf("#feb"));
		this.readyForMove = false;
		this.readyForAttack = true;
	}

	public void canAttack(){
		this.setFill(Color.YELLOW);
		this.readyForAttack = true;
	}

	public boolean isReadyForAttack() {
		return readyForAttack;
	}
}
