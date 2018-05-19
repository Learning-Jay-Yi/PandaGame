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
public class NewWarrior1 extends NewHero {


    private int width;
    private int height;
    Player player;
    Warrior1Factory warrior1Factory;
    HeroType heroType = HeroType.WARRIOR;

//    WarriorsBuilding warriorsBuilding;


    public NewWarrior1(Warrior2Factory warrior1Factory){

    }

    // for the new warrior, all of them have the same body
//    public NewWarrior1(int width, int height, Player player, Warrior1Factory warrior1Factory){
//        this.height = height;
//        this.width = width;
//        this.player = player;
//    }


    private AbilityAttack abilityAttack;
    private AbilityMove abilityMove;
    private AbilitySkills abilitySkills;

    public NewWarrior1(HeroFactory heroFactory) {

    }


    @Override
    public void MakeHero() {
        abilityMove = warrior1Factory.addAbilityMove();
        abilityAttack = warrior1Factory.addAbilityAttack();
        abilitySkills = warrior1Factory.addAbilitySkills();
    }

}
