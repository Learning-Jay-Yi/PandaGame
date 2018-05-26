package gameController.Controller;


import gameModel.*;
import gameView.*;
import gameView.NewView.NewMenuView;
import gameView.Option.OptionWindow;
import javafx.scene.Group;

import java.util.ArrayList;

/**
 * @author 		Dario
 * @version		1.6
 * @since		28/04/2018
 *
 * Description:
 * MainController instantiate Board (Model) and BoardView for start the game
 * it is in order to make other controllers work together
 */


public class MainController {
	private BoardView gameBoard;
	private Board board;
	private FrameView gameFrame;

	//groups set each nodes on board
	private Group tileGroup;
	private Group heroGroup;

	private TileView[][] tileArray;
	private ArrayList<HeroView> heroArray; //Automatically adding hero view for further features.

	private int TILE_SIZE;
	private int WIDTH;
	private int HEIGHT;

	private TileController tileController;
	private HeroController heroController;
	private ProcessController processController;

	private NewMenuView menu;
	//private TimerView timer;
	//private Observable time;

	/**
	 * initial controller
	 * @Requires ("board")
	 * @Requires ("TILE_SIZE>0", "WIDTH>0", "HIGHT>0")
	 */
	public MainController(){
		board = new Board(); //instantiate board first in order to get value of tile size, board width and board height

		ChangeBoardView.display(board);
		TILE_SIZE = board.getTileSize();
		WIDTH = board.getWidth();
		HEIGHT = board.getHeight();


		OptionWindow game = new OptionWindow();
		game.displayOption();

		menu = new NewMenuView();
		//time = new Timer();
		//TODO
		//timer = new TimerView();

		processController = new ProcessController(menu);

		tileController = new TileController(WIDTH, HEIGHT, TILE_SIZE, processController);
		heroController = new HeroController(WIDTH, HEIGHT, TILE_SIZE, processController);

		tileArray = new TileView[WIDTH][HEIGHT];
		heroArray = new ArrayList<>();

		tileGroup = tileController.createTiles(heroArray, tileArray);
		heroGroup = heroController.createHeros(heroArray, tileArray);

		gameBoard = new BoardView(board.getWidth(), board.getHeight(), board.getTileSize(), tileGroup, heroGroup);

		gameFrame = new FrameView(gameBoard.displayBoard(), menu.getMenuBar(), ((TimerView) TimerView.getInstance()).getTimer());

		processController.undo(tileArray, heroArray);

	}

	/**
	 * return the gameFrame when the parameters changed
	 * @Ensures ("gameFrame != null")
	 */
	public FrameView getGameFrame(){
		return gameFrame;
	}
}
