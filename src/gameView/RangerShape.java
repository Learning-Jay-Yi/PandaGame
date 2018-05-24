package gameView;

import gameModel.PlayerType;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

/**
 *
 * @author Yu Liu
 * @version 1.0
 * @since 14/05/2018
 *
 */
public class RangerShape implements Drawing{

	@Override
	public Shape drawShape(int size, PlayerType p) {


		Image red = new Image("/redRanger.jpg");
		Image blue = new Image("/blueRanger.jpg");



		Shape shape = new Polygon();
		((Polygon) shape).getPoints().addAll(0.0, 0.0, 0.0, 30.0, 21.0, 15.0);
		shape.setLayoutX(50);
		shape.setLayoutY(50);
		shape.setFill(p == PlayerType.BLUE? new ImagePattern(blue):new ImagePattern(red));
		shape.setStroke(Color.BLACK);
		shape.setTranslateX((size - size * 0.3125 * 2 ) / 2);
		shape.setTranslateY((size - size * 0.26 * 2) / 2 + size * 0.05);

		return shape;
	}

}
