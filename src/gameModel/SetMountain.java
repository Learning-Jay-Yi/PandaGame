package gameModel;

/**
*
* @author Vincent
* @version 1.0
* @since 12/05/2018
*
*
*	setMountain is part of Decorator Pattern,
*	it make a mountain on the specific tile that will block hero move through
*/
public class SetMountain extends TileDecorator {

	public SetMountain(Tile tile) {
		super(tile);

	}

	public String getEffect(){

		return null;
	}

}
