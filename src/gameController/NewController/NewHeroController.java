package gameController.NewController;

import gameController.ProcessController;
import gameController.TurnChecker;
import gameModel.*;
import gameView.HeroView;
import gameView.TileView;
import gameView.TurnCheckerAlarm;
import javafx.scene.Group;

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
	private int width, height, tilesize;
	private ProcessController processController;

	public NewHeroController(int width, int height, int tilesize, ProcessController process)
	{
		this.width = width;
		this.height = height;
		this.tilesize = tilesize;
		this.processController = process;
	}

	/**
	 * initial hero group
	 * @Ensures ("Group hero !=null")
	 */
	public Group createHeros(ArrayList<HeroView> heroArray,TileView[][] tileArray){
		Group group = new Group();
		ArrayList<Hero> r = new ArrayList<Hero>();

		/**
		 * list add new warrior that with plyaerType
		 * @Invariant("r.length <= 9") the maximum number of heroes in the hero pool is 9
		 * @Invariant("warrior.length && support.length && ranger.length == 2")
		 */

		r.add(new Warrior(width, height, PlayerType.BLUE));
		r.add(new Warrior(width, height, PlayerType.RED));

		r.add(new Support(width, height, PlayerType.BLUE));
		r.add(new Support(width, height, PlayerType.RED));

		r.add(new Ranger(width, height, PlayerType.BLUE));
		r.add(new Ranger(width, height, PlayerType.RED));

		/**
		 * Adding Hero View
		 * @Requires("r.contains(a)")
		 * @Requires("r.contains(OLD a)")
		 */
		for(Hero a : r)
		{
			HeroView heroView = new HeroView(a.getStartX(), a.getStartY(),a.getPlayerType(), a.getRoleType(), tilesize);
			heroArray.add(heroView);

			// ******* for future developing ----- maybe there will is some function need this
			tileArray[a.getStartX()][a.getStartY()].setHero(heroView);

			heroView.setOnMouseClicked(e ->
			{
				//************************* for future developing ------ refractory (too many if statements)
				boolean selected = false;
				for(HeroView i : heroArray)
				{
					if(i.isSelected())
						selected = true;
				}

				//move only if the tile selected is valid
				if(!selected && TurnChecker.getInstance().isTurn() && a.getPlayerType() == PlayerType.RED)
				{
					heroView.selecetedChanges();
					a.move(heroView.getLocX(), heroView.getLocY());

					for(int i = 0; i < a.getValidX().length; i++)
					{
						showValidTiles(tileArray, a.getValidX()[i], a.getValidY()[i]);
					}
				}

				//move only if the tile selected is valid
				if(!selected && !TurnChecker.getInstance().isTurn() && a.getPlayerType() == PlayerType.BLUE)
				{
					heroView.selecetedChanges();
					a.move(heroView.getLocX(), heroView.getLocY());


					for(int i = 0; i < a.getValidX().length; i++)
					{
						// find all the valid tiles of the selected piece
						showValidTiles(tileArray, a.getValidX()[i], a.getValidY()[i]);
					}
				}

				if(TurnChecker.getInstance().isTurn() && a.getPlayerType() == PlayerType.BLUE
						|| !TurnChecker.getInstance().isTurn() && a.getPlayerType() == PlayerType.RED)
					TurnCheckerAlarm.display();
				else
					processController.createNewLog(heroView.getPlayerType(), heroView.getRoleType(),
							heroView.getLocX(), heroView.getLocY());
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
