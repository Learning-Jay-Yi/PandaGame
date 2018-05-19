package gameModel.Factory;

import gameModel.Parts.*;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/17
 */
public class Support1Factory implements HeroFactory{

    @Override
    public PartsBody addPartsBody() {
        // TODO: 2018/5/19  
        return null;
    }

    @Override
    public PartsAttack addPartsAttack() {
        return new SupportAttack();
    }

    @Override
    public PartsMove addPartsMove() {
        return new SupportMove();
    }

    @Override
    public PartsSkills addPartsSkills() {
        return new SkillForAttack();
    }
}
