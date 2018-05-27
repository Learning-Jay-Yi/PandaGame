package gameModel;


/**
 *
 * @author Vincent
 * @version 1.2
 * @since 12/05/2018
 *
 *
 *	SpeedUp is part of Decorator Pattern,
 *	it holds a 'speed' buff that makes hero move faster
 */
public class SpeedUpTile extends TileDecorator{

	public SpeedUpTile(Tile tile) {
		super(tile);
	}

	
	public int getEffect(){

		return super.getEffect() + 2;
	}

}
