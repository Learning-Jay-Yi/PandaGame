package gameModel;

/**
 * @author 		Dario
 * @version		1.2
 * @since		1.0
 *
 * Description:
 * Board Class only store values for tile size, board width and board height;
 */
public class Board {
	private int tile_size;
	private int width;
	private int height;
	/**
	 * initial board with height =14, tileSize = 50, width = 13
	 */
	public Board(){
		this.height = 14;
		this.tile_size = 50;
		this.width = 13;
	}
	/**
	 * Return the integer of tile size
	 * @Ensures ("tile_size == 50")
	 */
	public int getTileSize(){
		return tile_size;
	}
	/**
	 * Return the integer of width
	 * @Ensures ("width == 13")
	 */
	public int getWidth(){
		return width;
	}
	/**
	 * Return the integer of height
	 * @Ensures ("height == 14")
	 */
	public int getHeight(){
		return height;
	}

}
