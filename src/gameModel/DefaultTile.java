package gameModel;


/**
 *
 * @author Tengku Ummil Syazwina Zainab Tengku Shamsulbhari
 *
 *
 */
public class DefaultTile implements Tile{

	private int sideSize;

	/**
	 * initial tile with the input size
	 * @Requires ("size == 50")
	 */
	public DefaultTile(int size){
		this.sideSize = size;
	}
	/**
	 * return the tile size when other needs
	 * @Ensures ("sideSize == 50")
	 */
	public int getSideSize(){
		return sideSize;
	}


	@Override
	public int getEffect() {
		return 0;
	}





}
