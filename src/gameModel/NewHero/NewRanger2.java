package gameModel.NewHero;

import gameModel.Factory.Ranger1Factory;
import gameModel.Factory.Ranger2Factory;
import gameModel.Parts.AbilityAttack;
import gameModel.Parts.AbilityMove;
import gameModel.Parts.AbilitySkills;
import gameModel.Player;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/17
 */
public class NewRanger2 extends NewHero {


    private int width;
    private int height;
    Player player;
    Ranger2Factory ranger2Factory;
    HeroType heroType = HeroType.RANGER;

//    WarriorsBuilding warriorsBuilding;

    // for the new warrior, all of them have the same body
    public NewRanger2(int width, int height, Player player, Ranger2Factory ranger2Factory){
        this.height = height;
        this.width = width;
        this.player = player;
        this.ranger2Factory = ranger2Factory;
    }


    private AbilityAttack abilityAttack;
    private AbilityMove abilityMove;
    private AbilitySkills abilitySkills;


    @Override
    public void MakeHero() {
        abilityMove = ranger2Factory.addAbilityMove();
        abilityAttack = ranger2Factory.addAbilityAttack();
        abilitySkills = ranger2Factory.addAbilitySkills();
    }

}
