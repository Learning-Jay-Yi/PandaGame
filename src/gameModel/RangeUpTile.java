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

public class RangeUpTile extends TileDecorator{
	public RangeUpTile(Tile tile) {
		super(tile);
	}

	public int getEffect(){

		return super.getEffect() + 3;
	}
}
