package gameModel.Factory;

import gameModel.Parts.*;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/17
 */
public class Warrior3Factory implements HeroFactory{

    @Override
    public AbilityAttack addAbilityAttack() {
        return new WarriorAttack();
    }

    @Override
    public AbilityMove addAbilityMove() {
        return new WarriorMove();
    }

    @Override
    public AbilitySkills addAbilitySkills() {
        return new Warrior1Skills();
    }
}
