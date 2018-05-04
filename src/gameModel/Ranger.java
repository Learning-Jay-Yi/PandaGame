package gameModel;

/**
 *
 * @author Tengku Ummil Syazwina Zainab Tengku Shamsulbhari
 * @version 1.4
 */

public class Ranger extends Hero implements Capture{

	private int move = 1;
	private int width;
	private int height;

	public Ranger(int w, int h, PlayerType p) {
		super.setStartX((p == PlayerType.BLUE ? 0 : w - 1));
		super.setStartY(9);
		super.setRoleType(RoleType.RANGER);
		super.setPlayerType(p);

		this.width = w;
		this.height = h;
	}

	@Override

	public void move(int curX, int curY) {
		super.validX = new int[4];
		super.validY = new int[4];

		validX[0] = (curX + move < width ? curX + move : curX);
		validY[0] = (curY + move < height ? curY + move : curY);

		validX[1] = (curX - move >= 0 ? curX - move : curX);
		validY[1] = (curY + move < height ? curY + move : curY);

		validX[2] = (curX - move >= 0 ? curX - move : curX);
		validY[2] = (curY - move >= 0 ? curY - move : curY);

		validX[3] = (curX + move < width ? curX + move : curX);
		validY[3] = (curY - move >= 0 ? curY - move : curY);

	}

	@Override
	public void capture() {
		// TODO Auto-generated method stub

	}


}
