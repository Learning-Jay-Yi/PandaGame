package gameView.MainView;
import gameView.HeroView.HeroView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


/**
 *
 * @author Jie Yi
 *
 */
public class TileView extends Rectangle{

	private HeroView heroView;
	private boolean readyForMove;
	private boolean readyForAttack;
	private int x;
	private int y;
	private int effect;

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
		this.setFill(Color.WHITE);
		this.setStroke(Color.BLACK);
	}

	/**
	 * set the heroView to the view
	 * @Requires ("heroView != null")
	 */
	public void setHeroView(HeroView heroView){
		this.heroView = heroView;

	}

	public boolean hasHeroView(){
		return heroView != null;
	}
	/**
	 * return the heroView in the view
	 * @Ensures ("heroView ! = null")
	 */
	public HeroView getHeroView(){
		return heroView;
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
		this.setStroke(Color.GREEN);
		this.setStrokeWidth(5);
		this.readyForMove = true;
	}
	/**
	 * void method to set default color
	 */
	public void setDefault(){
		this.setStroke(Color.BLACK);
		this.setStrokeWidth(1);
		this.readyForMove = false;
		this.readyForAttack = true;
	}

	public void canAttack(){
		this.setStroke(Color.RED);
		this.setStrokeWidth(5);
		this.readyForAttack = true;
	}

	public boolean isReadyForAttack() {
		return readyForAttack;
	}

	public void setEffect(int effect){
		this.effect = effect;

		switch(effect){
		case 1:
			this.setFill(Color.valueOf("#F4D03F"));
			break;
		case 2:
			this.setFill(Color.valueOf("#5DADE2"));
			break;
		case 3:
			this.setFill(Color.valueOf("#F1948A"));
			break;
		}
	}

	public int getEffectValue(){
		return effect;
	}

}
