package gameModel.Parts;

import gameModel.PlayerType;
import gameModel.RoleType;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/17
 */
public class RangerAttack implements PartsAttack {

    private int attackRange = 3;
    private int[]validX,validY;

    private int boardW, boardH;
    private PlayerType playerType;
    private RoleType roleType;

    @Override
    public void PartsAttack(int boardW, int boardH, PlayerType playerType, RoleType roleType) {
        this.boardW = boardW;
        this.boardH = boardH;
        this.playerType = playerType;
        this.roleType = roleType;
    }

    @Override
    public void CanAttack(int curX, int curY) {
        validX = new int[3];
        validY = new int[3];

        /**
         * follow diagram shows Warrior can attack
         *   ***H or H***
         */
        // Blue left, red right
        if (playerType == PlayerType.BLUE){
            // Y, X+1
            validX[0] = curX + attackRange;
            validY[0] = curY;
            // Y, X+2
            validX[1] = curX + (attackRange-1);
            validY[1] = curY;
            // Y, X+3
            validX[2] = curX + (attackRange-2);
            validY[2] = curY;
            // Y, X+4
//            validX[3] = curX + (attackRange-3);
//            validY[3] = curY;
        }else {
            // Y, range
            validX[0] = curX - attackRange;
            validY[0] = curY;
            // Y,range - 1
            validX[1] = curX - (attackRange-1);
            validY[1] = curY;
            // Y, range - 2
            validX[2] = curX - (attackRange-2);
            validY[2] = curY;
            // Y, range - 3
//            validX[3] = curX - (attackRange-3);
//            validY[3] = curY;
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
    public RoleType getRoleType() {
        return roleType;
    }

    @Override
    public void attack() {

    }
}
