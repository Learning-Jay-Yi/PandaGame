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
    HeroFactory heroFactory;
    HeroType heroType = HeroType.WARRIOR;


    private AbilityAttack abilityAttack;
    private AbilityMove abilityMove;
    private AbilitySkills abilitySkills;


    public NewWarrior1(HeroFactory heroFactory) {
        this.heroFactory = heroFactory;
    }




    @Override
    public void MakeHero() {
        abilityMove = heroFactory.addAbilityMove();
        abilityAttack = heroFactory.addAbilityAttack();
        abilitySkills = heroFactory.addAbilitySkills();
    }

}
