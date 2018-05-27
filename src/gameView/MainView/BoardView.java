package gameView.MainView;

import gameModel.Board;
import javafx.scene.Group;
import javafx.scene.layout.Pane;

/**
 *
 * @author Dario
 * @version 1.3
 *
 */

// This class should be in Model not View.
public class BoardView {

	private Group tileGroup;
	private Group heroGroup;
	private int size;
	private int width;
	private int height;
	/**
	 * Constructor for initial Board View with 5 parameters x, h, size, tileGroup, heroGroup
	 * @Requires ("x == 13")
	 * @Requires ("h == 14")
	 * @Requires ("size == 50")
	 * @Requires ("tileGroup != null")
	 * @Requires ("heroGroup != null")
	 */
	public BoardView(int w, int h, int size, Group tileGroup, Group heroGroup){
		this.width = w;
		this.height = h;
		this.size = size;
		this.tileGroup = tileGroup;
		this.heroGroup = heroGroup;
	}
	/**
	 * return the board
	 * @Ensure ("gameBoard" ! = null)
	 */
	public Pane displayBoard(){ //This method should be moved into a new 'BoardView' class in View package
		Pane gameBoard = new Pane();
		gameBoard.setPrefSize(size * width, size * height);

		gameBoard.getChildren().addAll(tileGroup, heroGroup);
		return gameBoard;
	}
}
