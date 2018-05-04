package gameModel;


/**
 *
 * @author Yu Liu
 * @version 1.5
 */
public class Support extends Hero implements Revive{
	private int move = 1;
	private int width;
	private int height;

	public Support(int w, int h, PlayerType p) {
		super.setStartX((p == PlayerType.BLUE ? 0 : w - 1));
		super.setStartY(6);
		super.setRoleType(RoleType.SUPPORT);
		super.setPlayerType(p);

		this.width = w;
		this.height = h;
	}


	@Override
	public void revive() {
		// TODO Auto-generated method stub

	}


	@Override
	public void move(int curX, int curY) {
		super.validX = new int[8];
		super.validY = new int[8];

		validX[0] = (curX + move < width ? curX + move : curX);
		validY[0] = curY;

		validX[1] = (curX + move < width ? curX + move : curX);
		validY[1] = (curY + move < height ? curY + move : curY);

		validX[2] = curX;
		validY[2] = (curY + move < height ? curY + move : curY);

		validX[3] = (curX - move >= 0 ? curX - move : curX);
		validY[3] = (curY + move < height ? curY + move : curY);

		validX[4] = (curX - move >= 0 ? curX - move : curX);
		validY[4] = curY;

		validX[5] = (curX - move >= 0 ? curX - move : curX);
		validY[5] = (curY - move >= 0 ? curY - move : curY);

		validX[6] = curX;
		validY[6] = (curY - move >= 0 ? curY - move : curY);

		validX[7] = (curX + move < width ? curX + move : curX);
		validY[7] = (curY - move >= 0 ? curY - move : curY);

	}
}
