package gameModel.NewHero;

import gameModel.Factory.HeroFactory;
import gameModel.Parts.AbilityAttack;
import gameModel.Parts.AbilityMove;
import gameModel.Parts.AbilitySkills;
import gameModel.Player;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/17
 */
public class NewRanger extends NewHero {


    private int width;
    private int height;
    Player player;
    HeroType heroType = HeroType.RANGER;

//    WarriorsBuilding warriorsBuilding;

    // for the new warrior, all of them have the same body
    public NewRanger(int width, int height, Player player){
        this.height = height;
        this.width = width;
        this.player = player;
    }


    private AbilityAttack abilityAttack;
    private AbilityMove abilityMove;
    private AbilitySkills abilitySkills;


    @Override
    public void MakeHero(HeroFactory heroFactory) {
        abilityMove = heroFactory.addAbilityMove();
        abilityAttack = heroFactory.addAbilityAttack();
        abilitySkills = heroFactory.addAbilitySkills();
    }

//    @Override
//    public void MakeHero(WarriorFactory warriorFactory) {
//        // before spawn the hero to the board we need add parts for the hero
//        abilityMove = WarriorFactory
//
//    }
}
