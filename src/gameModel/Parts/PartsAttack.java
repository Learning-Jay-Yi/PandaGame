package gameModel.Parts;

import gameModel.HeroModel.HeroType;
import gameModel.PlayerType;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/13
 */
public interface PartsAttack {
//    activityAttack addPartAttack();

    void activityAttack(int boardW, int boardH, PlayerType playerType, HeroType heroType);
    void CanAttack(int curX, int curY);
    int[] getValidX();
    int[] getValidY();
    HeroType getHeroType();
    void attack();

}


