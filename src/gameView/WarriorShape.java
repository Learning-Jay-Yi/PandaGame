package gameView;

import gameModel.PlayerType;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;

/**
*
* @author Yu Liu
* @version 1.0
* @since 14/05/2018
*
*/
public class WarriorShape implements Drawing{

	@Override
	public Shape drawShape(int size, PlayerType p) {

		Shape shape = new Ellipse(size * 0.3125, size * 0.26);

		shape.setFill(p == PlayerType.BLUE? Color.BLUE:Color.RED);

		shape.setStrokeWidth(size * 0.05);
		shape.setStroke(Color.BLACK);

		shape.setTranslateX((size - size * 0.3125 * 2 ) / 2);
		shape.setTranslateY((size - size * 0.26 * 2) / 2 + size * 0.07);

		return shape;
	}

}