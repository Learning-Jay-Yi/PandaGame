package gameController.Controller;

import gameModel.*;
import gameModel.HeroModel.Hero;
import gameModel.HeroModel.HeroType;
import gameView.HeroView.HeroView;
import gameView.MainView.MenuView;
import gameView.MainView.TileView;
import gameView.MainView.TimerView;
import gameView.MainView.TimerView2;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Vincent
 * @version 1.4
 * @since 04/05/2018
 *
 * Description:
 * ProcessController is to manipulate GameLog: create and save new GameLog, undo
 * processController is part of Memento pattern
 */
public class ProcessController {

	ArrayList<GameLog> logList = new ArrayList<>();
	GameLog log;

	int bUndoNum = 0, rUndoNum = 0;
	boolean bBlueUndo, bRedUndo;
	PlayerType curUndo;
	boolean flag = false;
	MenuView menu;




	public ProcessController(MenuView menu){
		this.menu = menu;

	}


	public void createNewLog(PlayerType p, HeroType r, Hero hero, int oldX, int oldY){

		log = new GameLog(p, r,hero);
		log.setOldCoordinate(oldX, oldY);
	}

	public void updateNewLog(int newX, int newY){
		log.setNewCoordinate(newX, newY);
		flag = false; // make sure one undo session is done
		logList.add(log);
		//TODO
		TimerTask timerTask = (TimerTask)new TimerCount();
		((TimerView) TimerView.getInstance()).setObservee((Observable) timerTask);
		((TimerView2) TimerView2.getInstance()).setObservee((Observable) timerTask);
		Timer timer = new Timer(false);
		timer.scheduleAtFixedRate(timerTask, 0, 1000);

	}

	public void undo(TileView[][] tileArray, ArrayList<HeroView> heroArray){
		menu.getUndoBtn().setOnAction(e ->{
			if(logList.size() > 0){
				// if player play move
				HeroType startfromWho;

				int i = logList.size() - 1;
				GameLog undoLog = logList.get(i);

				// the problem is every time pick a log froms tack, the player type would be changed.
//				PlayerType undoPlayer = ()



				if(curUndo == null && !flag){   //curUndo is who press undo button, flag checks does the undo turn finished by one player
					if(TurnChecker.getInstance().isTurn()){
						curUndo = PlayerType.RED;
						bRedUndo = true;
					}
					else{
						curUndo = PlayerType.BLUE;
						bBlueUndo = true;
					}
				}

				//if player Blue start to undo, and times of undo is under max time 3
				if(bUndoNum < 3 && curUndo == PlayerType.BLUE && !bRedUndo){  // bRedUndo is to make sure that current undo button is pressed by Blue
					undoAction(i,tileArray);
					System.out.println("Blue");
					bUndoNum++;
					flag = true; //flag true is to make sure current game is under one undo session
				}

				if(rUndoNum < 3 && curUndo == PlayerType.RED && !bBlueUndo){ //bBlueUndo is to make sure that current undo button is pressed by Red
					undoAction(i,tileArray);
					System.out.println("Red");
					rUndoNum++;
					flag = true;
				}

				if(bUndoNum == 3 && TurnChecker.getInstance().isTurn() && bBlueUndo){ // make sure this only trigger in blue undo session
					curUndo = null;
					bBlueUndo = false; // blue undo session is done
				}

				if(rUndoNum == 3 && !TurnChecker.getInstance().isTurn() && bRedUndo){ // make sure this only trigger in red undo session
					curUndo = null;
					bRedUndo = false; // red undo session is done
				}

//				if(!bBlueUndo || !bRedUndo){
//					// if red or blue didn't do undo before
//					if(bUndoNum<=2 ||rUndoNum <=2 ){
//						// if red or blue do undo but not greater than 3
//						if (undoLog.getPlayer() == PlayerType.BLUE){
//							undoAction(i,tileArray);
//							undoAction(i, tileArray);
//							bUndoNum++;
//						}else {
//							undoAction(i, tileArray);
//							undoAction(i, tileArray);
//							rUndoNum++;
//						}
//						if(bUndoNum == 2)
//							bBlueUndo = true;
//						if (rUndoNum == 2)
//							bRedUndo = true;
//
//					}else{
//						System.out.println(undoLog.getPlayer().toString()+" can not do undo again. Because the undo time is "
//								+(undoLog.getPlayer() == PlayerType.BLUE ? bUndoNum : rUndoNum));
//					}
//				}else {
//					System.out.println(undoLog.getPlayer().toString()+" can not do undo again. Because the undo "
//							+(undoLog.getPlayer() == PlayerType.BLUE ? bBlueUndo : bRedUndo));
//				}

			}
		});
	}

	private void undoAction(int i, TileView[][] tileArray) {
		int removeX = logList.get(i).getNewCoordinate()[0];
		int removeY = logList.get(i).getNewCoordinate()[1];

		int relocateX = logList.get(i).getOldCoordinate()[0];
		int relocateY = logList.get(i).getOldCoordinate()[1];

		TileView undoTile = tileArray[removeX][removeY];
		HeroView hero = undoTile.getHeroView();

		hero.move(relocateX, relocateY);
		tileArray[relocateX][relocateY].setHeroView(hero);
		tileArray[removeX][removeY].setHeroView(null);

		logList.remove(i);
		TurnChecker.getInstance().deCount();
	}
}
