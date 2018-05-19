package gameModel.Parts;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/17
 */
public class WarriorMove implements PartsMove{

    private int moveRange = 2;
    private int[]validX,validY;

    public int[] getValidY() {
        return validY;
    }

    public void setMoveRange(int moveRange) {
        this.moveRange = moveRange;
    }

    public int[] getValidX() {
        return validX;
    }

    @Override
    public void PartsMove(int curX, int curY, int boardW, int boardH) {
        validX = new int[4];
        validY = new int[4];

        validX[0] = (curX + moveRange < boardW ? curX + moveRange : curX);
        validY[0] = curY;

        validX[1] = curX;
        validY[1] = (curY + moveRange < boardH ? curY + moveRange : curY);

        validX[2] = (curX - moveRange >= 0 ? curX - moveRange : curX);
        validY[2] = curY;

        validX[3] = curX;
        validY[3] = (curY - moveRange >= 0 ? curY - moveRange : curY);

    }
}
