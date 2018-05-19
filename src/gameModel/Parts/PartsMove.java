package gameModel.Parts;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/13
 */
public interface PartsMove {
    void PartsMove(int boardW,int boardH);
    void Move(int curX, int curY);
    int[] getValidX();
    int[] getValidY();
}
