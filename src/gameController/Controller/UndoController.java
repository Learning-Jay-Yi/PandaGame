package gameController.Controller;

import java.util.ArrayList;

import com.google.java.contract.Invariant;

import gameModel.PlayerType;
import gameView.HeroView.HeroView;
import gameView.MainView.MenuView;
import gameView.MainView.TileView;

/**
 *
 * @author Dario
 * @version 1.5
 * @since 22/05/2018
 *
 * undo function
 */

@Invariant("bUndoNUm == 0 && rUndoNum == 0")
public class UndoController {

	//private ArrayList<GameLog> logList;
	private int bUndoNum = 0, rUndoNum = 0;
	private boolean bBlueUndo, bRedUndo;
	private PlayerType curUndo;
	//private boolean flag;
	private MenuView menu;
	private Caretaker p;

	public UndoController(MenuView menu, Caretaker p){
		this.menu = menu;
		this.p = p;
	}

	public void undo(TileView[][] tileArray, ArrayList<HeroView> heroArray){
		menu.getUndoBtn().setOnAction(e ->{
			if(p.getMemento().size() > 0){
				// if player play move
				int i = p.getMemento().size() - 1;
				if(curUndo == null && !p.getFlag()){   //curUndo is who press undo button, flag checks does the undo turn finished by one player
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
					p.setFlag(true); //flag true is to make sure current game is under one undo session
				}

				if(rUndoNum < 3 && curUndo == PlayerType.RED && !bBlueUndo){ //bBlueUndo is to make sure that current undo button is pressed by Red
					undoAction(i,tileArray);
					System.out.println("Red");
					rUndoNum++;
					p.setFlag(true);
				}

				if(bUndoNum == 3 && TurnChecker.getInstance().isTurn() && bBlueUndo){ // make sure this only trigger in blue undo session
					curUndo = null;
					bBlueUndo = false; // blue undo session is done
				}

				if(rUndoNum == 3 && !TurnChecker.getInstance().isTurn() && bRedUndo){ // make sure this only trigger in red undo session
					curUndo = null;
					bRedUndo = false; // red undo session is done
				}

			}
		});
	}

	private void undoAction(int i, TileView[][] tileArray) {
		int removeX = p.getMemento().get(i).getNewCoordinate()[0];
		int removeY = p.getMemento().get(i).getNewCoordinate()[1];

		int relocateX = p.getMemento().get(i).getOldCoordinate()[0];
		int relocateY = p.getMemento().get(i).getOldCoordinate()[1];

		TileView undoTile = tileArray[removeX][removeY];
		HeroView hero = undoTile.getHeroView();

		hero.move(relocateX, relocateY);
		tileArray[relocateX][relocateY].setHeroView(hero);
		tileArray[removeX][removeY].setHeroView(null);

		p.getMemento().remove(i);
		TurnChecker.getInstance().deCount();
	}

}
