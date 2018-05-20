package gameView.Option;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Yu Liu
 * @version 1.0
 * @since 16/05/2018
 *
 */
public class HeroPool {
	 private String heroType;
     private int ability;
     private boolean select;

     public HeroPool(String t, int a){
    	 this.heroType = t;
    	 this.ability = a;
     }

     public String getHeroType(){
    	 return heroType;
     }

     public int getAbility(){
    	 return ability;
     }

     public boolean isSelected(){
    	 return select;
     }
}
