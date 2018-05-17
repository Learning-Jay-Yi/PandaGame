package gameModel.Factory;

import gameModel.Parts.*;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/17
 */
public class Ranger2Factory implements HeroFactory{

    @Override
    public AbilityAttack addAbilityAttack() {
        return new RangerAttack();
    }

    @Override
    public AbilityMove addAbilityMove() {
        return new RangerMove();
    }

    @Override
    public AbilitySkills addAbilitySkills() {
        return new RangerSkills();
    }
}
