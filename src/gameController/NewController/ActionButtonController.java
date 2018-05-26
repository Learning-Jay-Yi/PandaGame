package gameController.NewController;

import java.util.ArrayList;

import gameModel.NewHero.NewHero;
import gameView.HeroView;
import gameView.TileView;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author Yu Liu
 * @version 1.0
 * @since 20/05/208
 *
 */
public class ActionButtonController {

	private Button moveBtn;
	private Button attackBtn;
	private Button abilityBtn;
	private Stage action;

	public ActionButtonController(Button movebtn, Button attackbtn, Button abilitybtn, Stage action){
		this.moveBtn = movebtn;
		this.abilityBtn = abilitybtn;
		this.attackBtn = attackbtn;
		this.action = action;
	}

	private void setMoveBtn(NewHero newHero, HeroView heroView, ArrayList<HeroView> heroViews, TileView[][] tileArray, NewProcessController processController) {
		moveBtn.setOnAction(e -> {
			newHero.getPartsMove().CanMove(heroView.getLocX(), heroView.getLocY());

			int[] validX = newHero.getPartsMove().getValidX();
			int[] validY = newHero.getPartsMove().getValidY();
			int length = validX.length;


			checkMoveEffect(validX, validY, tileArray, heroView);

			for (int i = 0; i < length; i++) {
				int x = validX[i];
				int y = validY[i];
				tileArray[x][y].canMove();
			}

			processController.createNewLog(heroView.getPlayerType(),heroView.getRoleType(),
					heroView.getLocX(),heroView.getLocY());

			action.close();
		});
	}

	private void checkMoveEffect(int[] validX, int[] validY, TileView[][] tileArray, HeroView heroView){
		int oldX = heroView.getLocX();
		int oldY = heroView.getLocY();

		for(int i = 0; i < validX.length; i++){
			if(oldX == validX[i]){
				if(oldY - validY[i] > 0){
					for(int y = oldY - 1; y > validY[i]; y--){
						if(tileArray[oldX][y].getEffectValue() == 1){
							validY[i] = y;
						}
					}
				}else{
					for(int y = oldY + 1; y < validY[i]; y++){
						if(tileArray[oldX][y].getEffectValue() == 1){
							validY[i] = y;
						}
					}
				}
			}else if(oldY == validY[i]){
				if(oldX - validX[i] > 0){
					for(int x = oldX - 1; x > validX[i]; x--){
						if(tileArray[x][oldY].getEffectValue() == 1){
							validX[i] = x;
						}
					}
				}else{
					for(int x = oldX + 1; x < validX[i]; x++){
						if(tileArray[x][oldY].getEffectValue() == 1){
							validX[i] = x;
						}
					}
				}
			}else{
				if(oldX - validX[i] > 0){
					if(oldY - validY[i] > 0){
						for(int x = oldX - 1, y = oldY - 1; x > validX[i]; x--, y--){
							if(tileArray[x][y].getEffectValue() == 1){
								validX[i] = x;
								validY[i] = y;
							}
						}
					}else{
						for(int x = oldX - 1, y = oldY + 1; x > validX[i]; x--, y++){
							if(tileArray[x][y].getEffectValue() == 1){
								validX[i] = x;
								validY[i] = y;
							}
						}
					}
				}else{
					if(oldY - validY[i] > 0){
						if(oldY - validY[i] > 0){
							for(int x = oldX + 1, y = oldY - 1; x < validX[i]; x++, y--){
								if(tileArray[x][y].getEffectValue() == 1){
									validX[i] = x;
									validY[i] = y;
								}
							}
						}
					}else{
						for(int x = oldX + 1, y = oldY + 1; x < validX[i]; x++, y++){
							if(tileArray[x][y].getEffectValue() == 1){
								validX[i] = x;
								validY[i] = y;
							}
						}
					}
				}
			}
		}
	}

}
