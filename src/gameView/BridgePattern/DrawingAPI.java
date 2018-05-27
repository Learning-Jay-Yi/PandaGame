package gameView.BridgePattern;

import gameModel.PlayerType;
import javafx.scene.shape.Shape;

/**
 *
 * @author Yu Liu
 * @version 1.3
 * @since 14/05/2018
 *
 * DrawingAPI interface is part of Bridge Pattern,
 *
 *
 */
public interface DrawingAPI {
	public Shape drawShape(int size, PlayerType p);
}
