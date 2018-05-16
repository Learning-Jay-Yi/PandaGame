package gameModel.NewHero;

import gameModel.Factory.HeroFactory;
import gameModel.Parts.PartsAttack;
import gameModel.Parts.PartsMove;
import gameModel.Parts.PartsSkills;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/14
 */
public abstract class NewHero implements HeroFactory {

    public enum HeroType{
        WARRIOR, SUPPORT, RANGER
    }

    HeroType heroType;

    public HeroType getHeroType() {
        return heroType;
    }

    public void setHeroType(HeroType heroType) {
        this.heroType = heroType;
    }

    // each hero have three parts
    PartsAttack partsAttack;
    PartsMove partsMove;
    PartsSkills partsSkills;

    // this is to spawn the hero on the board
    public abstract void MakeHero();


}
