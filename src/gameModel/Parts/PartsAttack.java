package gameModel.Parts;

import gameModel.PlayerType;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/13
 */
public interface PartsAttack {
//    PartsAttack addPartAttack();

    void PartsAttack(int boardW, int boardH, PlayerType playerType );
    void CanAttack(int curX, int curY);
    int[] getValidX();
    int[] getValidY();

    void attack();

}


