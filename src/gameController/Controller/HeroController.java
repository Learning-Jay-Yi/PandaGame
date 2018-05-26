package gameController.Controller;

import gameController.Builder.HeroBuilder;
import gameController.NewController.ActionButtonController;
import gameModel.*;
import gameModel.HeroModel.Hero;
import gameModel.HeroModel.HeroType;
import gameView.PopUpView.ActionSelectWindow;
import gameView.HeroView.HeroView;
import gameView.MainView.TileView;
import gameView.PopUpView.TurnCheckerAlarm;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.util.ArrayList;

/**
 * Purpose: split out from main controller to suit for Single responsibility principle
 * @author 		Jie Yi
 * @version 	1.2
 * @since 		1.0
 * last update date: 11/04/2018
 */

public class HeroController
{
	private int width, height, tileSize;
	private ProcessController processController;

	public HeroController(int width, int height, int tileSize, ProcessController process)
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

		testData = receiveOrder();

		Group group = new Group();
		ArrayList<Hero> heroes = new ArrayList<>();



		/**
		 * list add new warrior that with plyaerType
		 * @Invariant("r.length <= 9") the maximum number of heroes in the hero pool is 9
		 * @Invariant("warrior.length && support.length && ranger.length == 2")
		 */


		for (int i = 0; i < testData.size(); i++) {
			HeroBuilder heroBuilder = new HeroBuilder();
			Hero hero;
//			hero.setBoardHeight(height);

			hero = heroBuilder.buildHero(testData.get(i),width,height);

			hero.MakeHero();
			heroes.add(hero);
		}

		/**
		 * Adding Hero View
		 * @Requires("r.contains(a)")
		 * @Requires("r.contains(OLD a)")
		 */
		for(Hero hero : heroes) {
			//spawn each hero and put it into heroView
			hero.SpawnBody();
			hero.activityMove();
			hero.activityAttack();
			hero.activitySkills();
			int startX = hero.getPartsBody().getSpawnX();
			int startY = hero.getPartsBody().getSpawnY();
			PlayerType playerType = hero.getPartsBody().getPlayerType();
			HeroType heroType = hero.getPartsBody().getRoleType();
			HeroView heroView = new HeroView(startX, startY, playerType, heroType, tileSize);
			heroArray.add(heroView);



			 //******* for future developing ----- maybe there will is some function need this
			tileArray[startX][startY].setHeroView(heroView);

			heroView.setOnMouseClicked((MouseEvent e) ->
			{

				// need to know which hero selected
				// before the move, attack button need to disable, but activitySkill button can use.

				boolean selected = false;
				boolean bWarning = false;
				boolean bAttackStatus = false;
				HeroView preHero = null;
				// only can select one hero for each time.
				// every time click here, to check if there any hero already select
				for(HeroView i : heroArray){
					if(i.isSelected())
						selected = true;
					if (i.getAttackStatus()){
						preHero = i;
						bAttackStatus = true;
					}
				}


				// if no hero view not select then go select this hero, else reject
				if (!selected){
					// work for move
					// if this hero belongs to Player red.
					if(hero.getPartsBody().getPlayerType() == PlayerType.RED){
						// if this turn belongs to Player RED
						if (TurnChecker.getInstance().isTurn()){
							heroView.selecetedChanges();
							//ActionSelectWindow actionWindow = new ActionSelectWindow(hero,heroView,heroArray,tileArray,processController);
							ActionSelectWindow actionWindow = new ActionSelectWindow();
							ActionButtonController action = new ActionButtonController(hero,heroView,heroArray,tileArray,processController, actionWindow);
							actionWindow.display();

						}else
							bWarning=true;
					}else{

						if (!TurnChecker.getInstance().isTurn()){
							heroView.selecetedChanges();
							//ActionSelectWindow actionWindow = new ActionSelectWindow(hero,heroView,heroArray,tileArray,processController);
							ActionSelectWindow actionWindow = new ActionSelectWindow();
							ActionButtonController action = new ActionButtonController(hero,heroView,heroArray,tileArray,processController, actionWindow);
							actionWindow.display();
						}else
							bWarning = true;
					}
				}else if(bAttackStatus){

					// sth to work for revive
					// TODO: 2018/5/23 attack can attack everyone no matter how far.

					if (hero.getPartsBody().getRoleType() == HeroType.SUPPORT && heroView.getAttackStatus()){
						// support attack
						int supportCurX = heroView.getLocX(), supportCurY = heroView.getLocY();
						HeroView canReviveHero = null;
						for (int i = 0; i < heroArray.size(); i++) {
							canReviveHero = heroArray.get(i);
							// search the same time hero
							if (!canReviveHero.isVisible()){
								if (hero.getPartsBody().getPlayerType() == canReviveHero.getPlayerType()){
									canReviveHero.setVisible(true);
									canReviveHero.move(supportCurX,supportCurY);
									heroView.setStatus(false);

									break;
								}
							}
						}

						// respawn the hero
//						int supportCurX = heroView.getLocX(), supportCurY = heroView.getLocY();
						// make the support die
						heroView.setVisible(false);
						// respawn this hero to support location
						tileArray[supportCurX][supportCurY].setHeroView(canReviveHero);

						processController.createNewLog(heroView.getPlayerType(),heroView.getRoleType(), hero,
								heroView.getLocX(),heroView.getLocY());

					}else {
						// other attack
						//  work for attack
						// if the picked hero's team is dif to the target hero
						if(!(heroView.getPlayerType() == preHero.getPlayerType())){
							heroView.setVisible(false);
							preHero.setStatus(false);
							tileArray[heroView.getLocX()][heroView.getLocY()].setHeroView(null);

							for(TileView[] t : tileArray){
								for(TileView a : t){
									a.setDefault();
								}
							}

							for(int i = 0; i < heroArray.size(); i++)
								heroArray.get(i).setDefault();
						}
						processController.createNewLog(heroView.getPlayerType(),heroView.getRoleType(), hero,
								heroView.getLocX(),heroView.getLocY());

					}

				}

				WinnerChecker.getInstance().checkWinner(heroArray);

				if (bWarning){
					TurnCheckerAlarm.display();
				}
			});
			group.getChildren().add(heroView);
		}
		return group;
	}

	private ArrayList<String> receiveOrder() {
		ArrayList<String> order = new ArrayList<>();
		try {
			File file = new File("HeroPoolData.txt");
			if (file == null)
				throw new FileNotFoundException("can not find "+file);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String heroDetails = bufferedReader.readLine();
			while (heroDetails!=null){
				order.add(heroDetails);
				heroDetails = bufferedReader.readLine();
			}
		}catch (IOException eIO){
			System.out.println(eIO.toString());

		}
		return order;
	}
}
