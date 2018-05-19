package gameModel;

/**
 *
 * @author Yu Liu
 *@version 1.4
 */

public class Warrior extends Hero implements Capture{
	private int move = 2;
	private int width;
	private int height;


	public Warrior(int w, int h, PlayerType p) {
		super.setStartX((p == PlayerType.BLUE ? 0 : w - 1));
		super.setStartY(3);
		super.setRoleType(RoleType.WARRIOR);
		super.setPlayerType(p);
		this.width = w;
		this.height = h;
	}

	@Override
	public void capture() {

	}

	@Override
	public void move(int curX, int curY) {
		super.validX = new int[4];
		super.validY = new int[4];

		validX[0] = (curX + move < width ? curX + move : curX);
		validY[0] = curY;

		validX[1] = curX;
		validY[1] = (curY + move < height ? curY + move : curY);

		validX[2] = (curX - move >= 0 ? curX - move : curX);
		validY[2] = curY;

		validX[3] = curX;
		validY[3] = (curY - move >= 0 ? curY - move : curY);
	}
}
