package gameView.BridgePattern;

import gameModel.HeroModel.HeroType;
import gameModel.PlayerType;
import javafx.scene.shape.Shape;

/**
 *
 * @author Yu Liu
 * @version 1.4
 * @since 13/05/2018
 *
 *
 */
public class ShapeBridge {
	private HeroType role;
	private PlayerType player;
	private int size;
	public ShapeBridge(int size, PlayerType p, HeroType r){
		this.role = r;
		this.size = size;
		this.player = p;
	}

	public Shape draw(){
		if(role == HeroType.WARRIOR)
			return new WarriorShape(size, player, new DrawingWarriorAPI()).draw();
		else if(role == HeroType.SUPPORT)
			return new SupportShape(size, player, new DrawingSupportAPI()).draw();
		else if(role == HeroType.RANGER)
			return new RangerShape(size, player, new DrawingRangerAPI()).draw();
		else
			return null;
	}


}
