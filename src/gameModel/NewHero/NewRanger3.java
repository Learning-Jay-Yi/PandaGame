package gameModel.NewHero;

import gameModel.Factory.Ranger1Factory;
import gameModel.Factory.Ranger3Factory;
import gameModel.Parts.AbilityAttack;
import gameModel.Parts.AbilityMove;
import gameModel.Parts.AbilitySkills;
import gameModel.Player;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/17
 */
public class NewRanger3 extends NewHero {


    private int width;
    private int height;
    Player player;
    Ranger3Factory ranger3Factory;
    HeroType heroType = HeroType.RANGER;

//    WarriorsBuilding warriorsBuilding;

    // for the new warrior, all of them have the same body
    public NewRanger3(int width, int height, Player player, Ranger3Factory ranger3Factory){
        this.height = height;
        this.width = width;
        this.player = player;
        this.ranger3Factory = ranger3Factory;
    }


    private AbilityAttack abilityAttack;
    private AbilityMove abilityMove;
    private AbilitySkills abilitySkills;


    @Override
    public void MakeHero() {
        abilityMove = ranger3Factory.addAbilityMove();
        abilityAttack = ranger3Factory.addAbilityAttack();
        abilitySkills = ranger3Factory.addAbilitySkills();
    }

}
