package gameModel.Parts;

import gameModel.HeroModel.HeroType;
import gameModel.PlayerType;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/17
 */
public class WarriorAttack implements PartsAttack {

    private int attackRange = 1;
    private int[]validX,validY;

    private int boardW, boardH;
    private PlayerType playerType;
    private HeroType heroType;

    @Override
    public void activityAttack(int boardW, int boardH, PlayerType playerType, HeroType heroType) {
        this.boardW = boardW;
        this.boardH = boardH;
        this.playerType = playerType;
        this.heroType = heroType;
    }

    @Override
    public void CanAttack(int curX, int curY) {
        validX = new int[3];
        validY = new int[3];

        /**
         * follow diagram shows Warrior can attack
         *   *          *
         *   *  H or H  *
         *   *          *
         */
        // Blue left, red right
        if (playerType == PlayerType.BLUE){
            // Y, X+1
            validX[0] = curX + attackRange;
            validY[0] = curY;
            // Y+1, X+1
            validX[1] = curX + attackRange;
            validY[1] = (curY + 1 > boardH ? validY[0] : curY+1);
            // Y-1, X+1
            validX[2] = curX + attackRange;
            validY[2] = (curY-1 < 0 ? validY[0] : curY-1);
        }else {
            // Y, X-1
            validX[0] = curX - attackRange;
            validY[0] = curY;
            // Y+1, X-1
            validX[1] = curX - attackRange;
            validY[1] = (curY+1 >boardH ? validY[0] : curY + 1);
            // Y-1, X-2
            validX[2] = curX - attackRange;
            validY[2] = (curY-1 < 0 ? validY[0] : curY - 1);
        }
    }

    @Override
    public int[] getValidX() {
        return validX;
    }

    @Override
    public int[] getValidY() {
        return validY;
    }

    @Override
    public HeroType getHeroType() {
        return heroType;
    }

    @Override
    public void attack() {

    }

    

}
