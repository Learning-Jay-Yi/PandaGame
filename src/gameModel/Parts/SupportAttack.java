package gameModel.Parts;

import gameModel.PlayerType;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/17
 */
public class SupportAttack implements PartsAttack {
    @Override
    public void PartsAttack(int boardW, int boardH, PlayerType playerType) {

    }

    @Override
    public void CanAttack(int curX, int curY) {

    }

    @Override
    public int[] getValidX() {
        return new int[0];
    }

    @Override
    public int[] getValidY() {
        return new int[0];
    }

    @Override
    public void attack() {

    }
}
