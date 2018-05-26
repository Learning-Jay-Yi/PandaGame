package gameView.HeroView;

import gameModel.HeroModel.HeroType;
import gameModel.PlayerType;
import javafx.scene.shape.*;

/**
 *
 * @author Yu Liu
 * @version 1.3
 * @since 13/05/2018
 *
 *
 */
public class ShapeBridge {

	private Shape shape;
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
			return new HeroShape(size, player, new WarriorShape()).draw();
		else if(role == HeroType.SUPPORT)
			return new HeroShape(size, player, new SupportShape()).draw();
		else if(role == HeroType.RANGER)
			return new HeroShape(size, player, new RangerShape()).draw();
		else
			return null;
	}


}
