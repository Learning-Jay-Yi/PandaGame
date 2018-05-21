package gameModel.Parts;

import gameModel.PlayerType;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/17
 */
public class WarriorAttack implements PartsAttack {

    private int attackRange = 2;
    private int[]validX,validY;

    private int boardW, boardH;
    private PlayerType playerType;

    @Override
    public void PartsAttack(int boardW, int boardH, PlayerType playerType) {
        this.boardW = boardW;
        this.boardH = boardH;
    }

    @Override
    public void CanAttack(int curX, int curY) {
        validX = new int[3];
        validY = new int[3];

        /**
         * follow diagram shows Warrior can attack
         *   *     *
         *   *  H  *
         *   *     *
         */
        // Blue left, red right
        if (playerType == PlayerType.BLUE){
            // Y, X+2
            validX[0] = curX+attackRange;
            validY[0] = curY;
            // Y+1, X+2
            validX[1] = curX+attackRange;
            validY[1] = (curY+1 >boardH ? validY[0] : curY+1);
            // Y-1, X+2
            validX[1] = curX+attackRange;
            validY[1] = (curY-1 < 0 ? validY[0] : curY+1);
        }else {
            // Y, X-2
            validX[0] = curX-attackRange;
            validY[0] = curY;
            // Y+1, X+2
            validX[1] = curX-attackRange;
            validY[1] = (curY+1 >boardH ? validY[0] : curY+1);
            // Y-1, X+2
            validX[1] = curX-attackRange;
            validY[1] = (curY-1 < 0 ? validY[0] : curY+1);
        }
    }

    @Override
    public int[] getValidX() {
        return new int[0];
    }

    @Override
    public int[] getValidY() {
        return new int[0];
    }

    @Override
    public void attack() {

    }
}
