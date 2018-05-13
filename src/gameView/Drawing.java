package gameView;

import gameModel.PlayerType;

/**
 *
 * @author Vincent
 * @version 1.0
 * @since 14/05/2018
 *
 * Drawing interface is part of Bridge Pattern,
 *
 *
 */
public interface Drawing {
	public void drawShape(int size, PlayerType p);
}
