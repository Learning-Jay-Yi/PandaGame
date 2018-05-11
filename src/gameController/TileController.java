package gameController;

import java.util.ArrayList;

import gameModel.Tile;
import gameView.HeroView;
import gameView.TileView;
import javafx.scene.Group;


/**
 *
 * @author 		Jie Yi
 * @version		1.3
 * @since		1.0
 *
 * Description:
 *
 */
public class TileController {
	private int boardWidth;
	private int boardHeight;
	private int tileSize;
	private ProcessController processController;

	/**
	 * constructor that to store new object with width, height, size three parameters
	 * @Requires ("width == 13")
	 * @Requires ("height == 14")
	 * @Requires ("size == 50")
	 */
	public TileController(int width, int height, int size, ProcessController process){
		this.boardWidth = width;
		this.boardHeight = height;
		this.tileSize = size;
		this.processController = process;
	}

	/**
	 * create the tiles group when receive the heroArray, tileArray two parameters
	 * @Requires ("heroArray != null")
	 * @Requires ("tileArray != null")
	 * @Ensure ("group !=null")
	 */
	public Group createTiles(ArrayList<HeroView> heroArray, TileView[][] tileArray){
		Group group = new Group();
		for(int x = 0; x < boardWidth; x++){
			for(int y = 0; y < boardHeight; y++){
				TileView tileView = new TileView(x, y, new Tile(tileSize).getSideSize());

				tileView.setOnMouseClicked(e ->{
					if(tileView.isReady()){
						for(int i = 0; i < heroArray.size(); i++){
							if(heroArray.get(i).isSelected()){
								// get hero previous x and y in order to make previous tile's setHero to null
								int oldX = heroArray.get(i).getLocX();
								int oldY = heroArray.get(i).getLocY();

								heroArray.get(i).move(tileView.getLocX(), tileView.getLocY());
								TurnChecker.getInstance().incount();
								processController.updateNewLog(tileView.getLocX(), tileView.getLocY());

								tileArray[oldX][oldY].setHero(null);
								tileView.setHero(heroArray.get(i));
							}
						}
					}
					clean(heroArray, tileArray);
				});

				tileArray[x][y] = tileView;

				group.getChildren().add(tileView);
			}
		}
		return group;
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
	}
}
