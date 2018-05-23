package gameModel.Parts;

import gameModel.PlayerType;
import gameModel.RoleType;

/**
 * this class use to change the default move range.
 * @author Jay
 * @version 1.0
 * @since 2018/5/17
 */
public class SkillForMove implements PartsSkills {
    private int skillType = 2;

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
    public void skill(int curX, int curY) {
        if (roleType == RoleType.WARRIOR)
            warriorMove(curX, curY);
        else if(roleType == RoleType.RANGER)
            rangerMove(curX,curY);
        else
            supportMove(curX,curY);
    }

    private void supportMove(int curX, int curY) {
        // TODO: 2018/5/23  bugs here
        
        validX = new int[8];
        validY = new int[8];
        int moveRange =3;
        validX[0] = (curX + moveRange < boardW ? curX + moveRange : curX);
        validY[0] = curY;

        validX[1] = (curX + moveRange < boardW ? curX + moveRange : curX);
        validY[1] = (curY + moveRange < boardH ? curY + moveRange : curY);

        validX[2] = curX;
        validY[2] = (curY + moveRange < boardH ? curY + moveRange : curY);

        validX[3] = (curX - moveRange >= 0 ? curX - moveRange : curX);
        validY[3] = (curY + moveRange < boardH ? curY + moveRange : curY);

        validX[4] = (curX - moveRange >= 0 ? curX - moveRange : curX);
        validY[4] = curY;

        validX[5] = (curX - moveRange >= 0 ? curX - moveRange : curX);
        validY[5] = (curY - moveRange >= 0 ? curY - moveRange : curY);

        validX[6] = curX;
        validY[6] = (curY - moveRange >= 0 ? curY - moveRange : curY);

        validX[7] = (curX + moveRange < boardW ? curX + moveRange : curX);
        validY[7] = (curY - moveRange >= 0 ? curY - moveRange : curY);
    }

    private void rangerMove(int curX, int curY) {
        validX = new int[4];
        validY = new int[4];
        int moveRange = 2;
        validX[0] = (curX + moveRange < boardW ? curX + moveRange : curX);
        validY[0] = (curY + moveRange < boardH ? curY + moveRange : curY);

        validX[1] = (curX - moveRange >= 0 ? curX - moveRange : curX);
        validY[1] = (curY + moveRange < boardH ? curY + moveRange : curY);

        validX[2] = (curX - moveRange >= 0 ? curX - moveRange : curX);
        validY[2] = (curY - moveRange >= 0 ? curY - moveRange : curY);

        validX[3] = (curX + moveRange < boardW ? curX + moveRange : curX);
        validY[3] = (curY - moveRange >= 0 ? curY - moveRange : curY);
    }

    private void warriorMove(int curX, int curY) {
        int moveRange = 3;
        validX = new int[4];
        validY = new int[4];
        // Y, X+2
        validX[0] = (curX + moveRange < boardW ? curX + moveRange : curX);
        validY[0] = curY;

        validX[1] = curX;
        validY[1] = (curY + moveRange < boardH ? curY + moveRange : curY);

        validX[2] = (curX - moveRange >= 0 ? curX - moveRange : curX);
        validY[2] = curY;

        validX[3] = curX;
        validY[3] = (curY - moveRange >= 0 ? curY - moveRange : curY);
    }

    @Override
    public int[] getValidX() {
        return validX;
    }

    @Override
    public int[] getValidY() {
        return validY;
    }
}
