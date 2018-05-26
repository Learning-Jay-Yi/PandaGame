package gameModel;

import gameView.HeroView.HeroView;
import gameView.MainView.TileView;

/**
 *
 * @author Dario
 * @version 1.3
 * @since 22/05/2018
 *
 * check is there a mountain block the move
 *
 */
public class MoveBlock {
	private int[] validX;
	private int[] validY;
	private TileView[][] tileArray;
	private HeroView heroView;

	public MoveBlock(int[] validX, int[] validY, TileView[][] tileArray, HeroView heroView){
		this.validX = validX;
		this.validY = validY;
		this.tileArray = tileArray;
		this.heroView = heroView;
		checkMoveEffect();
	}

	private void checkMoveEffect(){
		int oldX = heroView.getLocX();
		int oldY = heroView.getLocY();
		//check the valid coordinate, change the valid coordinate if there is a mountain tile
		for(int i = 0; i < validX.length; i++){
			if(oldX == validX[i]){
				if(oldY - validY[i] > 0){
					for(int y = oldY - 1; y >= validY[i]; y--){
						if(tileArray[oldX][y].getEffectValue() == 1){
							validY[i] = y + 1;
						}
					}
				}else{
					for(int y = oldY + 1; y <= validY[i]; y++){
						if(tileArray[oldX][y].getEffectValue() == 1){
							validY[i] = y - 1;
						}
					}
				}
			}else if(oldY == validY[i]){
				if(oldX - validX[i] > 0){
					for(int x = oldX - 1; x >= validX[i]; x--){
						if(tileArray[x][oldY].getEffectValue() == 1){
							validX[i] = x + 1;
						}
					}
				}else{
					for(int x = oldX + 1; x <= validX[i]; x++){
						if(tileArray[x][oldY].getEffectValue() == 1){
							validX[i] = x - 1;
						}
					}
				}
			}else{
				if(oldX - validX[i] > 0){
					if(oldY - validY[i] > 0){
						for(int x = oldX - 1, y = oldY - 1; x >= validX[i]; x--, y--){
							if(tileArray[x][y].getEffectValue() == 1){
								validX[i] = x + 1;
								validY[i] = y + 1;
							}
						}
					}else{
						for(int x = oldX - 1, y = oldY + 1; x >= validX[i]; x--, y++){
							if(tileArray[x][y].getEffectValue() == 1){
								validX[i] = x + 1;
								validY[i] = y - 1;
							}
						}
					}
				}else{
					if(oldY - validY[i] > 0){
						if(oldY - validY[i] > 0){
							for(int x = oldX + 1, y = oldY - 1; x <= validX[i]; x++, y--){
								if(tileArray[x][y].getEffectValue() == 1){
									validX[i] = x - 1;
									validY[i] = y + 1;
								}
							}
						}
					}else{
						for(int x = oldX + 1, y = oldY + 1; x <= validX[i]; x++, y++){
							if(tileArray[x][y].getEffectValue() == 1){
								validX[i] = x - 1;
								validY[i] = y - 1;
							}
						}
					}
				}
			}
		}
	}


	public int[] getValidX() {
		return validX;
	}

	public int[] getValidY() {
		return validY;
	}



}
