package gameView;

import gameModel.PlayerType;
import gameModel.RoleType;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

/**
 *
 * @author Yu Liu
 *
 */
public class HeroShape {

	private Shape shape;
	private RoleType role;
	private PlayerType player;
	private int size;
	public HeroShape(int size, PlayerType p, RoleType r){
		this.role = r;
		this.size = size;
		this.player = p;
	}


	public Shape draw(){
		if(role == RoleType.WARRIOR)
			return WarriorShape();
		else if(role == RoleType.SUPPORT)
			return SupportShape();
		else if(role == RoleType.RANGER)
			return RangerShape();

		else
			return null;
	}

	/**
	 * draw the shape of hero for the player
	 * @Requires ("player == RED || player == BLUE")
	 */
	private Shape WarriorShape(){
		shape = new Ellipse(size * 0.3125, size * 0.26);

		shape.setFill(player == PlayerType.BLUE? Color.BLUE:Color.RED);

		shape.setStrokeWidth(size * 0.05);
		shape.setStroke(Color.BLACK);

		shape.setTranslateX((size - size * 0.3125 * 2 ) / 2);
		shape.setTranslateY((size - size * 0.26 * 2) / 2 + size * 0.07);

		return shape;
	}

	/**
	 * draw the shape of hero for the player
	 * @Requires ("player == RED || player == BLUE")
	 */
	private Shape SupportShape(){
		 shape = new Arc(10, 10, 20, 20, 0, 150);

		 shape.setFill(player == PlayerType.BLUE? Color.BLUE:Color.RED);

		 shape.setStrokeWidth(size * 0.05);
		 shape.setStroke(Color.BLACK);

		 shape.setTranslateX((size - size * 0.3125 * 2 ) / 2);
		 shape.setTranslateY((size - size * 0.26 * 2) / 2 + size * 0.05);

		return shape;
	}

	/**
	 * draw the shape of hero for the player
	 * @Requires ("player == RED || player == BLUE")
	 */
	private Shape RangerShape(){
		shape = new Polygon();
		((Polygon) shape).getPoints().addAll(0.0, 0.0, 0.0, 30.0, 21.0, 15.0);
		shape.setLayoutX(50);
		shape.setLayoutY(50);
		shape.setFill(player == PlayerType.BLUE? Color.BLUE:Color.RED);
		shape.setStroke(Color.BLACK);
		shape.setTranslateX((size - size * 0.3125 * 2 ) / 2);
		shape.setTranslateY((size - size * 0.26 * 2) / 2 + size * 0.05);

		return shape;
	}

}
