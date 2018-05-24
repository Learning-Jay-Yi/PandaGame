package gameController.NewController;

import gameModel.*;
import gameModel.NewHero.NewHero;
import gameView.HeroView;
import gameView.NewView.NewMenuView;
import gameView.TileView;
import gameView.TimerView;
import gameView.TimerView2;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
*
* @author Vincent
* @version 1.0
* @since 04/05/2018
*
* Description:
* ProcessController is to manipulate GameLog: create and save new GameLog, undo
* processController is part of Memento pattern
*/
public class NewProcessController {

	ArrayList<GameLog> logList = new ArrayList<>();
	GameLog log;

	int bUndoNum = 0, rUndoNum = 0;
	boolean bBlueUndo, bRedUndo;

	NewMenuView menu;




	public NewProcessController(NewMenuView menu){
		this.menu = menu;

	}


	public void createNewLog(PlayerType p, RoleType r, NewHero hero, int oldX, int oldY){
		log = new GameLog(p, r,hero);
		log.setOldCoordinate(oldX, oldY);
	}

	public void updateNewLog(int newX, int newY){
		log.setNewCoordinate(newX, newY);
		logList.add(log);
		//TODO

		
	}

	public void undo(TileView[][] tileArray, ArrayList<HeroView> heroArray){
		menu.getUndoBtn().setOnAction(e ->{
			if(logList.size() > 0){
				// if player play move
				RoleType startfromWho;

				int i = logList.size() - 1;
				GameLog undoLog = logList.get(i);

				/**
				 * 1. 如何确定谁undo， 取出第一个log， 如果player是蓝色，那么就是红色在undo
				 * 2.
				 */
				// the problem is every time pick a log froms tack, the player type would be changed.
//				PlayerType undoPlayer = ()


				if(!bBlueUndo || !bRedUndo){
					// if red or blue didn't do undo before
					if(bUndoNum<=2 ||rUndoNum <=2 ){
						// if red or blue do undo but not greater than 3
						if (undoLog.getPlayer() == PlayerType.BLUE){
							undoAction(i,tileArray);
							undoAction(i, tileArray);
							bUndoNum++;
						}else {
							undoAction(i, tileArray);
							undoAction(i, tileArray);
							rUndoNum++;
						}
						if(bUndoNum == 2)
							bBlueUndo = true;
						if (rUndoNum == 2)
							bRedUndo = true;

					}else{
						System.out.println(undoLog.getPlayer().toString()+" can not do undo again. Because the undo time is "
								+(undoLog.getPlayer() == PlayerType.BLUE ? bUndoNum : rUndoNum));
					}
				}else {
					System.out.println(undoLog.getPlayer().toString()+" can not do undo again. Because the undo "
							+(undoLog.getPlayer() == PlayerType.BLUE ? bBlueUndo : bRedUndo));
				}

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
		NewTurnChecker.getInstance().decount();
	}
}
