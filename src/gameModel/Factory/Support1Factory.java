package gameModel.Factory;

import gameModel.Parts.*;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/17
 */
public class Support1Factory implements HeroFactory{

    @Override
    public AbilityAttack addAbilityAttack() {
        return new SupportAttack();
    }

    @Override
    public AbilityMove addAbilityMove() {
        return new SupportMove();
    }

    @Override
    public AbilitySkills addAbilitySkills() {
        return new SkillForAttack();
    }
}
