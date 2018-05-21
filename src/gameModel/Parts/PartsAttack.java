package gameModel.Parts;

import gameModel.PlayerType;
import gameModel.RoleType;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/13
 */
public interface PartsAttack {
//    PartsAttack addPartAttack();

    void PartsAttack(int boardW, int boardH, PlayerType playerType, RoleType roleType);
    void CanAttack(int curX, int curY);
    int[] getValidX();
    int[] getValidY();
    RoleType getRoleType();
    void attack();

}


