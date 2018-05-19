package gameModel.Factory;

import gameModel.Parts.*;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/17
 */
public class Ranger3Factory implements HeroFactory{

    @Override
    public PartsAttack addPartsAttack() {
        return new RangerAttack();
    }

    @Override
    public PartsMove addPartsMove() {
        return new RangerMove();
    }

    @Override
    public PartsSkills addPartsSkills() {
        return new SkillForDodge();
    }
}
