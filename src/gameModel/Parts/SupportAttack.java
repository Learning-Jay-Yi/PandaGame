package gameModel.Parts;

import gameModel.PlayerType;
import gameModel.RoleType;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/17
 */
public class SupportAttack implements PartsAttack {

    private int attackRange = 1;
    private int[]validX,validY;

    private int boardW, boardH;
    private PlayerType playerType;
    private RoleType roleType;
    
    @Override
    public void activityAttack(int boardW, int boardH, PlayerType playerType, RoleType roleType) {
        this.boardW = boardW;
        this.boardH = boardH;
        this.playerType = playerType;
        this.roleType = roleType;
    }

    @Override
    public void CanAttack(int curX, int curY) {
        validX = new int[1];
        validY = new int[1];

        /**
         * follow diagram shows Warrior can attack
         *   ***
         *   *H*
         *   ***
         */
        // Blue left, red right

        validX[0] = curX;
        validY[0] = curY;

//        validX[1] = (curX + attackRange < boardW ? curX + attackRange : curX);
//        validY[1] = (curY + attackRange < boardH ? curY + attackRange : curY);
//
//        validX[2] = curX;
//        validY[2] = (curY + attackRange < boardH ? curY + attackRange : curY);
//
//        validX[3] = (curX - attackRange >= 0 ? curX - attackRange : curX);
//        validY[3] = (curY + attackRange < boardH ? curY + attackRange : curY);
//
//        validX[4] = (curX - attackRange >= 0 ? curX - attackRange : curX);
//        validY[4] = curY;
//
//        validX[5] = (curX - attackRange >= 0 ? curX - attackRange : curX);
//        validY[5] = (curY - attackRange >= 0 ? curY - attackRange : curY);
//
//        validX[6] = curX;
//        validY[6] = (curY - attackRange >= 0 ? curY - attackRange : curY);
//
//        validX[7] = (curX + attackRange < boardW ? curX + attackRange : curX);
//        validY[7] = (curY - attackRange >= 0 ? curY - attackRange : curY);

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
