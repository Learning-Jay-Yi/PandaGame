package gameController.NewController;

import gameController.TurnChecker;
import gameModel.*;
import gameView.HeroView;
import gameView.TileView;
import javafx.scene.Group;

import java.util.ArrayList;
import java.util.Random;


/**
 *
 * @author 		Jie Yi
 * @version		1.3
 * @since		1.0
 *
 * Description:
 *
 */
public class NewTileController {
	private int boardWidth;
	private int boardHeight;
	private int tileSize;
	private NewProcessController processController;

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
	public NewTileController(int width, int height, int size, NewProcessController process){
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
	public Group createTiles(ArrayList<HeroView> heroViewArrayList, TileView[][] tileViewsArrayList){
		Group group = new Group();

		getRandomNumber();

		for(int x = 0; x < boardWidth; x++){
			for(int y = 0; y < boardHeight; y++){
/*****************************************************************************************************************************/
				Tile tile = new DefaultTile(tileSize);

				boolean specialTile = false;

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


								NewTurnChecker.getInstance().incount();
								processController.updateNewLog(tileView.getLocX(), tileView.getLocY());

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
		n = random.nextInt(7) + 3;

		x = new int[n];
		y = new int[n];

		for(int i = 0; i < x.length; i++){
			int dx = random.nextInt(boardWidth - 2) + 2;
			boolean flag = true;
			for(int j = 0; j < x.length; j++){
				if(dx == x[j]){
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
			for(int j = 0; j < y.length; j++){
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
