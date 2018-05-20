package gameController.NewController;

import gameController.Builder.HeroBuilding;
import gameController.TurnChecker;
import gameModel.*;
import gameModel.NewHero.NewHero;
import gameModel.NewHero.NewHeroType;
import gameView.ActionSelectWindow;
import gameView.HeroView;
import gameView.NewView.NewHeroView;
import gameView.TileView;
import gameView.TurnCheckerAlarm;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

/**
 * Purpose: split out from main controller to suit for Single responsibility principle
 * @author 		Jie Yi
 * @version 	1.2
 * @since 		1.0
 * last update date: 11/04/2018
 */

public class NewHeroController
{
	private int width, height, tileSize;
	private NewProcessController processController;

	public NewHeroController(int width, int height, int tileSize, NewProcessController process)
	{
		this.width = width;
		this.height = height;
		this.tileSize = tileSize;
		this.processController = process;
	}

	/**
	 * initial hero group
	 * @Ensures ("Group hero !=null")
	 */
	public Group createHeros(ArrayList<HeroView> heroArray,TileView[][] tileArray){

		ArrayList<String> testData = new ArrayList<>();
		String hero1 = "Warrior 1 RED";
		String hero2 = "Warrior 2 BLUE";

		testData.add(hero1);
		testData.add(hero2);

		Group group = new Group();
		ArrayList<NewHero> heroes = new ArrayList<>();



		/**
		 * list add new warrior that with plyaerType
		 * @Invariant("r.length <= 9") the maximum number of heroes in the hero pool is 9
		 * @Invariant("warrior.length && support.length && ranger.length == 2")
		 */


		for (int i = 0; i < testData.size(); i++) {
			HeroBuilding heroBuilding = new HeroBuilding();
			NewHero hero;
//			hero.setBoardHeight(height);

			hero = heroBuilding.buildHero(testData.get(i),width,height);
			hero.MakeHero();
			hero.SpawnBody();
			hero.Move();
			heroes.add(hero);
		}

//		r.add(new Warrior(width, height, PlayerType.BLUE));
//		r.add(new Warrior(width, height, PlayerType.RED));
//
//		r.add(new Support(width, height, PlayerType.BLUE));
//		r.add(new Support(width, height, PlayerType.RED));
//
//		r.add(new Ranger(width, height, PlayerType.BLUE));
//		r.add(new Ranger(width, height, PlayerType.RED));

		/**
		 * Adding Hero View
		 * @Requires("r.contains(a)")
		 * @Requires("r.contains(OLD a)")
		 */
		for(NewHero a : heroes)
		{

			int startX = a.getPartsBody().getSpawnX();
			int startY = a.getPartsBody().getSpawnY();
			PlayerType playerType = a.getPartsBody().getPlayerType();
			RoleType roleType = a.getPartsBody().getRoleType();
			HeroView heroView = new HeroView(startX, startY, playerType, roleType, tileSize);
			heroArray.add(heroView);

			tileArray[startX][startY].setHero(heroView);

			heroView.setOnMouseClicked((MouseEvent e) ->
			{
				ActionSelectWindow actionWindow = new ActionSelectWindow();
				actionWindow.display();
				//TODO
			});

			group.getChildren().add(heroView);
		}
		return group;
	}

	/**
	 * private method to show all the valid tiles in the view
	 * @Requires ("tile[][] !== null","x,y>=0","x<=13,y<=14")
	 * @Requires ("x>=0","x<=13")
	 * @Requires ("y>=0","y<=14")
	 */
	private void showValidTiles(TileView[][] tile, int x, int y){
		tile[x][y].changeColor(); // call the method that change the special tiles.
	}
}
