package gameModel;

/**
*
* @author Vincent
* @version 1.0
* @since 12/05/2018
*
*
*	RangeUp is part of Decorator Pattern,
*	it holds a 'range' buff that makes hero attack longer range
*/

public class RangeUp extends TileDecorator{
	public RangeUp(Tile tile) {
		super(tile);
	}

	public String getEffect(){

		return null;
	}
}
