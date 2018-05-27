package gameModel.Parts;

import gameModel.HeroModel.HeroType;

import com.google.java.contract.Ensures;

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

    @Ensures("skillTyp == 3")
    @Override
    public int getSkillType() {
        return skillTyp;
    }

    @Override
    public void skill(int curX, int curY, HeroType heroType) {

    }

    @Ensures("validX != null")
    @Override
    public int[] getValidX() {
        return new int[0];
    }

    @Ensures("validX != null")
    @Override
    public int[] getValidY() {
        return new int[0];
    }
}
