package gameView;

import gameModel.PlayerType;
import javafx.scene.shape.Shape;

/**
 *
 * @author Yu Liu
 * @version 1.0
 * @since 14/05/2018
 *
 * Drawing interface is part of Bridge Pattern,
 *
 *
 */
public interface Drawing {
	public Shape drawShape(int size, PlayerType p);
}
