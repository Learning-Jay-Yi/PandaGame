package gameModel;

/**
*
* @author Vincent
* @version 1.2
* @since 12/05/2018
*
*
*	setMountain is part of Decorator Pattern,
*	it make a mountain on the specific tile that will block hero move through
*/
public class SetMountainTile extends TileDecorator {

	public SetMountainTile(Tile tile) {
		super(tile);

	}

	public int getEffect(){

		return super.getEffect() + 1;
	}

}
