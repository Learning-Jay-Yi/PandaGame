package gameModel;

/**
 *
 * @author Tengku Ummil Syazwina Zainab Tengku Shamsulbhari
 *
 */
public interface Move {
	/**
	 * interface for move hero
	 * @Ensures ("x>=0","x<=14")
	 * @Ensures ("y>=0","y<=13")
	 */
	abstract void move(int x, int y);
}
