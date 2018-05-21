package gameModel;

/**
 *
 * @author Yu Liu
 * @version 1.0
 * @since 12/05/2018
 *
 * TileDecorator is part of Decorator Pattern
 *
 */
public class TileDecorator implements Tile{
	public Tile decoratedTile;

	public TileDecorator(Tile tile){
		this.decoratedTile = tile;
	}

	@Override
	public int getEffect() {
		return decoratedTile.getEffect();
	}

}
