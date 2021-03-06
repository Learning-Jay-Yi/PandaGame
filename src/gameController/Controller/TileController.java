package gameController.Controller;

import gameModel.*;
import gameView.HeroView.HeroView;
import gameView.MainView.TileView;
import javafx.scene.Group;

import java.util.ArrayList;
import java.util.Random;

import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;


/**
 *
 * @author 		Jie Yi
 * @version		1.4
 * @since		1.0
 *
 * Description:
 *
 */
public class TileController {
	private int boardWidth;
	private int boardHeight;
	private int tileSize;
	private Caretaker processController;

	private Random random = new Random();
	private int[] x;
	private int[] y;
	private int n; // number of special tile
	/**
	 * constructor that to store new object with width, height, size three parameters
	 * @Requires ("width == 13")
	 * @Requires ("height == 14")
	 * @Requires ("size == 50")
	 */
	@Ensures("width != null, height != null, tileSize != null, processController != null")
	public TileController(int width, int height, int size, Caretaker process){
		this.boardWidth = width;
		this.boardHeight = height;
		this.tileSize = size;
		this.processController = process;
	}

	/**
	 * create the tiles group when receive the heroViewArrayList, tileViewsArrayList two parameters
	 * @Requires ("heroViewArrayList != null")
	 * @Requires ("tileViewsArrayList != null")
	 * @Ensure ("group !=null")
	 */
	@Requires("heroViewArrayList != null && tileViewsArrayList != null")
	@Ensures("group != null")
	public Group createTiles(ArrayList<HeroView> heroViewArrayList, TileView[][] tileViewsArrayList){
		Group group = new Group();

		getRandomNumber();

		for(int x = 0; x < boardWidth; x++){
			for(int y = 0; y < boardHeight; y++){
/*****************************************************************************************************************************/
				Tile tile = new DefaultTile(tileSize);

				boolean specialTile = false;
				//generate special tiles
				for(int i = 0; i < this.x.length; i++){
					if(x == this.x[i] && y == this.y[i]){
						tile = new SetMountainTile(new DefaultTile(tileSize));
						specialTile = true;
					}
				}

				TileView tileView = new TileView(x, y, tileSize);

				if(specialTile){
					tileView.setEffect(tile.getEffect());
				}

/******************************************************************************************************************************/

				tileView.setOnMouseClicked(e ->{
					int oldX ;//= heroViewArrayList.get(i).getLocX();
					int oldY ;//= heroViewArrayList.get(i).getLocY();
					if(tileView.isReadyToMove()){
						for(int i = 0; i < heroViewArrayList.size(); i++){
							if(heroViewArrayList.get(i).isSelected()){
								// get hero previous x and y in order to make previous tile's setHeroView to null
								oldX = heroViewArrayList.get(i).getLocX();
								oldY = heroViewArrayList.get(i).getLocY();

								heroViewArrayList.get(i).move(tileView.getLocX(), tileView.getLocY());


								TurnChecker.getInstance().inCount();
								Originator.getInstance().updateNewLog(tileView.getLocX(), tileView.getLocY());
								processController.addMemento(Originator.getInstance().getMemento());

								tileViewsArrayList[oldX][oldY].setHeroView(null);
								tileView.setHeroView(heroViewArrayList.get(i));

							}
						}
					}
					clean(heroViewArrayList, tileViewsArrayList);
				});

				tileViewsArrayList[x][y] = tileView;

				group.getChildren().add(tileView);
			}
		}
		return group;
	}


	private void getRandomNumber(){
		n = random.nextInt(12) + 6; //randomly get special mountain tiles number

		x = new int[n]; //new x of coordinate array
		y = new int[n]; //new y of coordinate array

		for(int i = 0; i < x.length; i++){
			int dx = random.nextInt(boardWidth - 2) + 2;
			boolean flag = true;
			for(int j = 0; j < x.length; j++){
				if(dx == x[j]){ //detect if the coordinate appeared
					flag = false;
					break;
				}
			}

			if(flag)
				x[i] = dx;
		}

		for(int i = 0; i < y.length; i++){
			int dy = random.nextInt(boardHeight - 2) + 2;
			boolean flag = true;
			for(int j = 0; j < y.length; j++){  //detect if the coordinate appeared
				if(dy == y[j]){
					flag = false;
					break;
				}
			}
			if(flag)
				y[i] = dy;
		}

	}

	/**
	 * private method that clean the highlight tiles when finish hero's action
	 * @Requires ("heroArray != null")
	 * @Requires ("tileArray != null")
	 */
	private void clean(ArrayList<HeroView> heroArray, TileView[][] tileArray){
		for(int x = 0; x < boardWidth; x++){
			for(int y = 0; y < boardHeight; y++){
				tileArray[x][y].setDefault();
			}
		}

		for(int i = 0; i < heroArray.size(); i++){
			heroArray.get(i).setDefault();
		}

		WinnerChecker.getInstance().checkWinner(heroArray);
	}
}
