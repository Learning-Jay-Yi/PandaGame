package gameView.HeroView;

import gameModel.PlayerType;
import gameView.DrawShape;
import gameView.Drawing;
import javafx.scene.shape.Shape;

/**
 *
 * @author Yu Liu
 * @version 1.3
 * @since 14/05/2018
 *
 */
public class HeroShape implements DrawShape {

	private Drawing drawing;
	private int size;
	private PlayerType player;

	public HeroShape(int size, PlayerType p, Drawing drawing){
		this.size = size;
		this.player = p;
		this.drawing = drawing;
	}

	@Override
	public Shape draw() {

		return drawing.drawShape(size, player);
	}

}
