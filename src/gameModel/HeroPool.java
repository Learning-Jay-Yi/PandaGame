package gameModel;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Yu Liu
 * @version 1.3
 * @since 16/05/2018
 *
 * hero pool is model to show available heros
 */
public class HeroPool {
	 private String heroType;
     private int ability;
     private boolean select;
     private boolean redAdd = false;
     private boolean blueAdd = false;

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

     public void setSelect(boolean s){
    	 this.select = s;
     }
     public boolean isSelected(){
    	 return select;
     }

	public boolean isRedAdd() {
		return redAdd;

	}

	public void setRedAdd(boolean redAdd) {
		this.redAdd = redAdd;
	}

	public boolean isBlueAdd() {
		return blueAdd;
	}

	public void setBlueAdd(boolean blueAdd) {
		this.blueAdd = blueAdd;
	}


}
