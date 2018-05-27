package gameView.HeroView;

import gameModel.PlayerType;
import gameView.Drawing;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.metadata.IIOMetadata;
//import java.awt.image.BufferedImage;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 *
 * @author Yu Liu
 * @version 1.4
 * @since 14/05/2018
 *
 */
public class RangerShape implements Drawing {

	@Override
	public Shape drawShape(int size, PlayerType p) {

		Image red = new Image("file:redRanger.jpg");
		Image blue = new Image("file:BlueRanger.jpg");

		Shape shape = new Ellipse(size * 0.4, size * 0.4);

		shape.setFill(p == PlayerType.BLUE? new ImagePattern(blue):new ImagePattern(red));

		shape.setStrokeWidth(size * 0.05);
		shape.setStroke(Color.BLACK);

		shape.setTranslateX((size - size * 0.4 * 2 ) / 2);
		shape.setTranslateY((size - size * 0.4 * 2) / 2 + size * 0.07);

		return shape;
	}

}
