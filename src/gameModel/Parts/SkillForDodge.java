package gameModel.Parts;

import gameModel.HeroModel.HeroType;
import gameModel.PlayerType;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/17
 */
public class SkillForDodge implements PartsSkills {

    private int skillTyp = 3;

    @Override
    public void activitySkill(int width, int height, PlayerType playerType, HeroType heroType) {

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
    public void skill(int curX, int curY, HeroType heroType) {

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
