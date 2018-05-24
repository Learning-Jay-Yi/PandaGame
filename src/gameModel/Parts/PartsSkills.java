package gameModel.Parts;

import gameModel.PlayerType;
import gameModel.RoleType;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/13
 */
public interface PartsSkills {
//    PartsSkills addPartsSkills();

    void activitySkill(int width, int height, PlayerType playerType, RoleType roleType);
    boolean usedSkill();
    void setUsedSkill(boolean useSkill);
    // 1 == attack, 2 == move, 3 == invincible
    int getSkillType();

    void skill(int curX, int curY,RoleType roleType);

    int[] getValidX();
    int[] getValidY();

}
