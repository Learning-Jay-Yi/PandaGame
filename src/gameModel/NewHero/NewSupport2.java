package gameModel.NewHero;

import gameModel.Factory.HeroFactory;
import gameModel.Factory.Support1Factory;
import gameModel.Factory.Support2Factory;
import gameModel.Parts.AbilityAttack;
import gameModel.Parts.AbilityMove;
import gameModel.Parts.AbilitySkills;
import gameModel.Player;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/17
 */
public class NewSupport2 extends NewHero {


    private int width;
    private int height;
    Player player;
    Support2Factory support2Factory;
    HeroType heroType = HeroType.SUPPORT;

//    WarriorsBuilding warriorsBuilding;

    // for the new warrior, all of them have the same body
    public NewSupport2(int width, int height, Player player, Support2Factory support2Factory){
        this.height = height;
        this.width = width;
        this.player = player;
        this.support2Factory = support2Factory;
    }


    private AbilityAttack abilityAttack;
    private AbilityMove abilityMove;
    private AbilitySkills abilitySkills;

    public NewSupport2(HeroFactory heroFactory) {

    }


    @Override
    public void MakeHero() {
        abilityMove = support2Factory.addAbilityMove();
        abilityAttack = support2Factory.addAbilityAttack();
        abilitySkills = support2Factory.addAbilitySkills();
    }

}
