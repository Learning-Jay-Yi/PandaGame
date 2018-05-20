package gameController.NewController;

import gameController.Builder.HeroBuilding;
import gameController.TurnChecker;
import gameModel.*;
import gameModel.NewHero.NewHero;
import gameView.ActionSelectWindow;
import gameView.HeroView;
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
		String hero2 = "Warrior 1 BLUE";
		String hero3 = "Ranger 2 RED";
		String hero4 = "Ranger 2 BLUE";
		String hero5 = "Support 3 RED";
		String hero6 = "Support 3 BLUE";


		testData.add(hero1);
		testData.add(hero2);
		testData.add(hero3);
		testData.add(hero4);
		testData.add(hero5);
		testData.add(hero6);

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
//			hero.SpawnBody();


//			hero.CanMove();
			heroes.add(hero);
		}

		/**
		 * Adding Hero View
		 * @Requires("r.contains(a)")
		 * @Requires("r.contains(OLD a)")
		 */
		for(NewHero newHero : heroes) {
			//spawn each hero and put it into heroView
			newHero.SpawnBody();
			// initial hero move board
			newHero.Move();
			int startX = newHero.getPartsBody().getSpawnX();
			int startY = newHero.getPartsBody().getSpawnY();
			PlayerType playerType = newHero.getPartsBody().getPlayerType();
			RoleType roleType = newHero.getPartsBody().getRoleType();
			HeroView heroView = new HeroView(startX, startY, playerType, roleType, tileSize);
			heroArray.add(heroView);



			 //******* for future developing ----- maybe there will is some function need this
			tileArray[startX][startY].setHero(heroView);

			heroView.setOnMouseClicked((MouseEvent e) ->
			{

				// need to know which hero selected
				// before the move, attack button need to disable, but skill button can use.

				ActionSelectWindow actionWindow = new ActionSelectWindow(newHero,heroView,heroArray);



				actionWindow.display();
				//TODO
			});
			group.getChildren().add(heroView);
		}
		return group;
	}






	private void ClickHero(NewHero newHero, HeroView heroView, ArrayList<HeroView> heroArray) {
		boolean bSelected = false;
		heroView.selecetedChanges();
		newHero.getPartsMove().CanMove(heroView.getLocX(),heroView.getLocY());

		if (bSelected){
			heroView.selecetedChanges();
		}

	}

	/**
	 * private method to show all the valid tiles in the view
	 * @Requires ("tile[][] !== null","x,y>=0","x<=13,y<=14")
	 * @Requires ("x>=0","x<=13")
	 * @Requires ("y>=0","y<=14")
	 */
	private void showMoveValidTiles(TileView[][] tile, int x, int y){
		tile[x][y].changeColor(); // call the method that change the special tiles.
	}
}
