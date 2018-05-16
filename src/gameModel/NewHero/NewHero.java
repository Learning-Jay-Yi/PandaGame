package gameModel.NewHero;

import gameModel.Factory.HeroFactory;
import gameModel.Parts.*;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/14
 */
public abstract class NewHero{

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
//    PartsAttack partsAttack;
//    PartsMove partsMove;
//    PartsSkills partsSkills;


//    public AbilityAttack abilityAttack;
//    public AbilityMove abilityMove;
//    public AbilitySkills abilitySkills;

    // this is to spawn the hero on the board
    public abstract void MakeHero(HeroFactory heroFactory);


}
