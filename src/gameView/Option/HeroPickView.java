package gameView.Option;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Yu Liu
 * @version 1.0
 * @since 15/05/2018
 *
 * HeroPickView include all hero types, and 2 players' containers which are going to save the hero picked
 */
public class HeroPickView {

	private Label label1 = new Label("Hero Pool");
	private Label label2 = new Label("Player Red");
	private Label label3 = new Label("Player Blue");

	public HeroPickView(){

	}

	public GridPane getHeroPick(){
		GridPane root = new GridPane();

		root.add(label1, 0, 0);
		root.add(label2, 1, 0);
		root.add(label3, 2, 0);
		//TODO
		return root;
	}

	public VBox getHeroPool(){
		VBox pool = new VBox();
		//TODO
		return pool;
	}

	public VBox getRedContainer(){
		VBox container = new VBox();
		//TODO
		return container;
	}

	public VBox getBlueContainer(){
		VBox container = new VBox();
		//TODO
		return container;
	}

}
