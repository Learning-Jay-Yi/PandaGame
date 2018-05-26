package gameModel.Parts;

import gameModel.HeroModel.HeroType;
import gameModel.PlayerType;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/13
 */
public interface PartsSkills {
//    PartsSkills addPartsSkills();

    void activitySkill(int width, int height, PlayerType playerType, HeroType heroType);
    boolean usedSkill();
    void setUsedSkill(boolean useSkill);
    // 1 == attack, 2 == move, 3 == invincible
    int getSkillType();

    void skill(int curX, int curY, HeroType heroType);

    int[] getValidX();
    int[] getValidY();

}
