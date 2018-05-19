package gameModel.NewHero;

import gameModel.Factory.HeroFactory;
import gameModel.Parts.*;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/14
 */
public abstract class NewHero{

    public NewHero() {

    }

    public enum HeroType{
        WARRIOR, SUPPORT, RANGER
    }


//    protected int moveRange;
//    protected int attackRange;
//    protected int dodgeChance;

    HeroType heroType;

    public HeroType getHeroType() {
        return heroType;
    }

    public void setHeroType(HeroType heroType) {
        this.heroType = heroType;
    }

    // this is to spawn the hero on the board
    public abstract void MakeHero();


}
