package gameModel.NewHero;

import gameModel.Factory.Ranger1Factory;
import gameModel.Parts.AbilityAttack;
import gameModel.Parts.AbilityMove;
import gameModel.Parts.AbilitySkills;
import gameModel.Player;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/17
 */
public class NewRanger1 extends NewHero {


    private int width;
    private int height;
    Player player;
    Ranger1Factory ranger1Factory;
    HeroType heroType = HeroType.RANGER;

//    WarriorsBuilding warriorsBuilding;

    // for the new warrior, all of them have the same body
    public NewRanger1(int width, int height, Player player, Ranger1Factory ranger1Factory){
        this.height = height;
        this.width = width;
        this.player = player;
        this.ranger1Factory = ranger1Factory;
    }


    private AbilityAttack abilityAttack;
    private AbilityMove abilityMove;
    private AbilitySkills abilitySkills;


    @Override
    public void MakeHero() {
        abilityMove = ranger1Factory.addAbilityMove();
        abilityAttack = ranger1Factory.addAbilityAttack();
        abilitySkills = ranger1Factory.addAbilitySkills();
    }

}
