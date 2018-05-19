package gameModel.NewHero;

import gameModel.Factory.HeroFactory;
import gameModel.Factory.Support1Factory;
import gameModel.Factory.Support3Factory;
import gameModel.Parts.AbilityAttack;
import gameModel.Parts.AbilityMove;
import gameModel.Parts.AbilitySkills;
import gameModel.Player;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/17
 */
public class NewSupport3 extends NewHero {


    private int width;
    private int height;
    Player player;
    Support3Factory support3Factory;
    HeroType heroType = HeroType.SUPPORT;

//    WarriorsBuilding warriorsBuilding;

    // for the new warrior, all of them have the same body
    public NewSupport3(int width, int height, Player player, Support3Factory support3Factory){
        this.height = height;
        this.width = width;
        this.player = player;
        this.support3Factory = support3Factory;
    }


    private AbilityAttack abilityAttack;
    private AbilityMove abilityMove;
    private AbilitySkills abilitySkills;

    public NewSupport3(HeroFactory heroFactory) {

    }


    @Override
    public void MakeHero() {
        abilityMove = support3Factory.addAbilityMove();
        abilityAttack = support3Factory.addAbilityAttack();
        abilitySkills = support3Factory.addAbilitySkills();
    }

}
