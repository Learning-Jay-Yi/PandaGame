package gameView.HeroView;

import gameModel.PlayerType;
import gameView.Drawing;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;

/**
*
* @author Yu Liu
* @version 1.4
* @since 14/05/2018
*
*/
public class SupportShape implements Drawing {

	@Override
	public Shape drawShape(int size, PlayerType p) {

		Image red = new Image("file:redSupport.jpg");
		Image blue = new Image("file:BlueSupport.jpg");

		Shape shape = new Ellipse(size * 0.4, size * 0.4);

		shape.setFill(p == PlayerType.BLUE? new ImagePattern(blue):new ImagePattern(red));

		shape.setStrokeWidth(size * 0.05);
		shape.setStroke(Color.BLACK);

		shape.setTranslateX((size - size * 0.4 * 2 ) / 2);
		shape.setTranslateY((size - size * 0.4 * 2) / 2 + size * 0.07);



		return shape;
	}
}
