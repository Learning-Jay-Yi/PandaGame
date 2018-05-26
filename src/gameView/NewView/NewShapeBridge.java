package gameView.NewView;

import gameModel.HeroModel.HeroType;
import gameModel.PlayerType;
import gameView.HeroShape;
import gameView.RangerShape;
import gameView.SupportShape;
import gameView.WarriorShape;
import javafx.scene.shape.Shape;

/**
 *
 * @author Yu Liu
 *
 */
public class NewShapeBridge {

	private Shape shape;
	private HeroType role;
	private PlayerType player;
	private int size;
	public NewShapeBridge(int size, PlayerType p, HeroType r){
		this.role = r;
		this.size = size;
		this.player = p;
	}


	public Shape draw(){
		if(role == HeroType.WARRIOR)
			return new HeroShape(size, player, new WarriorShape()).draw();
		else if(role == HeroType.SUPPORT)
			return new HeroShape(size, player, new SupportShape()).draw();
		else if(role == HeroType.RANGER)
			return new HeroShape(size, player, new RangerShape()).draw();
		else
			return null;
	}

//	/**
//	 * draw the shape of hero for the player
//	 * @Requires ("player == RED || player == BLUE")
//	 */
//	private Shape WarriorShape(){
//		shape = new Ellipse(size * 0.3125, size * 0.26);
//
//		shape.setFill(player == PlayerType.BLUE? Color.BLUE:Color.RED);
//
//		shape.setStrokeWidth(size * 0.05);
//		shape.setStroke(Color.BLACK);
//
//		shape.setTranslateX((size - size * 0.3125 * 2 ) / 2);
//		shape.setTranslateY((size - size * 0.26 * 2) / 2 + size * 0.07);
//
//		return shape;
//	}
//
//	/**
//	 * draw the shape of hero for the player
//	 * @Requires ("player == RED || player == BLUE")
//	 */
//	private Shape SupportShape(){
//		 shape = new Arc(10, 10, 20, 20, 0, 150);
//
//		 shape.setFill(player == PlayerType.BLUE? Color.BLUE:Color.RED);
//
//		 shape.setStrokeWidth(size * 0.05);
//		 shape.setStroke(Color.BLACK);
//
//		 shape.setTranslateX((size - size * 0.3125 * 2 ) / 2);
//		 shape.setTranslateY((size - size * 0.26 * 2) / 2 + size * 0.05);
//
//		return shape;
//	}
//
//	/**
//	 * draw the shape of hero for the player
//	 * @Requires ("player == RED || player == BLUE")
//	 */
//	private Shape RangerShape(){
//		shape = new Polygon();
//		((Polygon) shape).getPoints().addAll(0.0, 0.0, 0.0, 30.0, 21.0, 15.0);
//		shape.setLayoutX(50);
//		shape.setLayoutY(50);
//		shape.setFill(player == PlayerType.BLUE? Color.BLUE:Color.RED);
//		shape.setStroke(Color.BLACK);
//		shape.setTranslateX((size - size * 0.3125 * 2 ) / 2);
//		shape.setTranslateY((size - size * 0.26 * 2) / 2 + size * 0.05);
//
//		return shape;
//	}

}
