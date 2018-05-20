package gameModel.Parts;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/17
 */
public class RangerMove implements PartsMove{

    private int moveRange = 1;
    private int[]validX,validY;

    private int boardW, boardH;

    public void setMoveRange(int moveRange) {
        this.moveRange = moveRange;
    }


    @Override
    public void PartsMove(int boardW, int boardH) {
       this.boardW = boardW;
       this.boardH = boardH;
    }

    @Override
    public void CanMove(int curX, int curY) {
        validX = new int[4];
        validY = new int[4];

        validX[0] = (curX + moveRange < boardW ? curX + moveRange : curX);
        validY[0] = (curY + moveRange < boardH ? curY + moveRange : curY);

        validX[1] = (curX - moveRange >= 0 ? curX - moveRange : curX);
        validY[1] = (curY + moveRange < boardH ? curY + moveRange : curY);

        validX[2] = (curX - moveRange >= 0 ? curX - moveRange : curX);
        validY[2] = (curY - moveRange >= 0 ? curY - moveRange : curY);

        validX[3] = (curX + moveRange < boardW ? curX + moveRange : curX);
        validY[3] = (curY - moveRange >= 0 ? curY - moveRange : curY);

    }

    @Override
    public int[] getValidX() {
        return validX;
    }
    @Override
    public int[] getValidY() {
        return validY;
    }
}
