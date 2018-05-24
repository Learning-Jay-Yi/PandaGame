package gameModel.Parts;

import gameModel.PlayerType;
import gameModel.RoleType;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/17
 */
public class SkillForDodge implements PartsSkills {

    private int skillTyp = 3;

    @Override
    public void activitySkill(int width, int height, PlayerType playerType, RoleType roleType) {

    }

    @Override
    public boolean usedSkill() {
        return false;
    }

    @Override
    public void setUsedSkill(boolean useSkill) {

    }

    @Override
    public int getSkillType() {
        return skillTyp;
    }

    @Override
    public void skill(int curX, int curY, RoleType roleType) {

    }


    @Override
    public int[] getValidX() {
        return new int[0];
    }

    @Override
    public int[] getValidY() {
        return new int[0];
    }
}
