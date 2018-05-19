package gameModel.NewHero;

import gameModel.Factory.HeroFactory;
import gameModel.Factory.Warrior1Factory;
import gameModel.Factory.Warrior2Factory;
import gameModel.Parts.AbilityAttack;
import gameModel.Parts.AbilityMove;
import gameModel.Parts.AbilitySkills;
import gameModel.Player;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/17
 */
public class NewWarrior2 extends NewHero {


    private int width;
    private int height;
    Player player;
    Warrior2Factory warrior2Factory;
    HeroType heroType = HeroType.WARRIOR;

//    WarriorsBuilding warriorsBuilding;

    // for the new warrior, all of them have the same body
    public NewWarrior2(int width, int height, Player player, Warrior2Factory warrior2Factory){
        this.height = height;
        this.width = width;
        this.player = player;
    }


    private AbilityAttack abilityAttack;
    private AbilityMove abilityMove;
    private AbilitySkills abilitySkills;

    public NewWarrior2(HeroFactory heroFactory) {
    }


    @Override
    public void MakeHero() {
        abilityMove = warrior2Factory.addAbilityMove();
        abilityAttack = warrior2Factory.addAbilityAttack();
        abilitySkills = warrior2Factory.addAbilitySkills();
    }

}
