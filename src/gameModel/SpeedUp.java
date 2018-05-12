package gameModel;

/**
 *
 * @author Vincent
 * @version 1.0
 * @since 12/05/2018
 *
 *
 *	SpeedUp is part of Decorator Pattern,
 *	it holds a 'speed' buff that makes hero move faster
 */
public class SpeedUp extends TileDecorator{

	public SpeedUp(Tile tile) {
		super(tile);
	}

	public String getEffect(){

		return null;
	}

}
