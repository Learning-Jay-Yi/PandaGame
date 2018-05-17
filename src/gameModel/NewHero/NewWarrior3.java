package gameModel.NewHero;

import gameModel.Factory.Warrior1Factory;
import gameModel.Factory.Warrior3Factory;
import gameModel.Parts.AbilityAttack;
import gameModel.Parts.AbilityMove;
import gameModel.Parts.AbilitySkills;
import gameModel.Player;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/17
 */
public class NewWarrior3 extends NewHero {


    private int width;
    private int height;
    Player player;
    Warrior3Factory warrior3Factory;
    HeroType heroType = HeroType.WARRIOR;

//    WarriorsBuilding warriorsBuilding;

    // for the new warrior, all of them have the same body
    public NewWarrior3(int width, int height, Player player, Warrior3Factory warrior3Factory){
        this.height = height;
        this.width = width;
        this.player = player;
        this.warrior3Factory = warrior3Factory;
    }


    private AbilityAttack abilityAttack;
    private AbilityMove abilityMove;
    private AbilitySkills abilitySkills;


    @Override
    public void MakeHero() {
        abilityMove = warrior3Factory.addAbilityMove();
        abilityAttack = warrior3Factory.addAbilityAttack();
        abilitySkills = warrior3Factory.addAbilitySkills();
    }

}
