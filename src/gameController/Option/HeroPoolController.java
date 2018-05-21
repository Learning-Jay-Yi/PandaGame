package gameController.Option;

import gameModel.Option.HeroPool;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Dario
 *
 */
public class HeroPoolController {

	private ObservableList<HeroPool> data = FXCollections.observableArrayList(
			new HeroPool("Warrior", 1),
			new HeroPool("Warrior", 2),
			new HeroPool("Warrior", 3),
			new HeroPool("Support", 1),
			new HeroPool("Support", 2),
			new HeroPool("Support", 3),
			new HeroPool("Ranger", 1),
			new HeroPool("Ranger", 2),
			new HeroPool("Ranger", 3)
			);


	public HeroPoolController(){

	}

	public ObservableList<HeroPool> getHeroPoolData(){
		return data;
	}


}
