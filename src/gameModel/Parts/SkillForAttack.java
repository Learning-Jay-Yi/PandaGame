package gameModel.Parts;

import gameModel.PlayerType;
import gameModel.RoleType;

import java.util.Currency;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/17
 */
public class SkillForAttack implements PartsSkills {
    private int skillType = 1;
//    private int attackRange = 2;
    private int boardW, boardH;
    private int[]validX,validY;
    private RoleType roleType;
    private PlayerType playerType;
    private boolean bUsed = false;

    @Override
    public void activitySkill(int boardW, int boardH, PlayerType playerType, RoleType roleType) {
        this.boardW = boardW;
        this.boardH = boardH;
        this.roleType = roleType;
        this.playerType = playerType;
    }


    @Override
    public void skill(int curX, int curY, RoleType roleType) {
        if (roleType == RoleType.WARRIOR)
            warriorAttack(curX, curY);
        else if(roleType == RoleType.RANGER)
            rangerAttack(curX,curY);
        else
            supportAttack(curX,curY);
    }

    private void supportAttack(int curX, int curY) {
        validX = new int[1];
        validY = new int[1];
        validX[0] = curX;
        validY[0] = curY;
    }


    private void rangerAttack(int curX, int curY) {
        int attackRange = 4;
        validX = new int[4];
        validY = new int[4];

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
            validX[3] = curX + (attackRange-3);
            validY[3] = curY;
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
            validX[3] = curX - (attackRange-3);
            validY[3] = curY;
        }

    }

    private void warriorAttack(int curX, int curY) {
        int attackRange = 1;
        validX = new int[6];
        validY = new int[6];
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

            // Y, X+2
            validX[3] = curX + (attackRange+1);
            validY[3] = curY;
            // Y+1, X+2
            validX[4] = curX + (attackRange+1);
            validY[4] = (curY + 1 > boardH ? validY[0] : curY+1);
            // Y-1, X+2
            validX[5] = curX + (attackRange+1);
            validY[5] = (curY-1 < 0 ? validY[0] : curY-1);
        }else {
            // Y, X-1
            validX[0] = curX - attackRange;
            validY[0] = curY;
            // Y+1, X-1
            validX[1] = curX - attackRange;
            validY[1] = (curY + 1 > boardH ? validY[0] : curY + 1);
            // Y-1, X-2
            validX[2] = curX - attackRange;
            validY[2] = (curY - 1 < 0 ? validY[0] : curY - 1);

            // Y, X+2
            validX[3] = curX - (attackRange+1);
            validY[3] = curY;
            // Y+1, X+2
            validX[4] = curX - (attackRange+1);
            validY[4] = (curY + 1 > boardH ? validY[0] : curY+1);
            // Y-1, X+2
            validX[5] = curX - (attackRange+1);
            validY[5] = (curY-1 < 0 ? validY[0] : curY-1);
        }
    }


    @Override
    public boolean usedSkill() {
        return bUsed;
    }

    @Override
    public void setUsedSkill(boolean useSkill) {
        this.bUsed = useSkill;
    }

    @Override
    public int getSkillType() {
        return skillType;
    }

    @Override
    public int[] getValidX() {
        return validX;
    }

    @Override
    public int[] getValidY() {
        return validY;
    }

//    @Override
//    public int[] getMoveValidX() {
//        return new int[0];
//    }
//
//    @Override
//    public int[] getMoveValidY() {
//        return new int[0];
//    }


}
