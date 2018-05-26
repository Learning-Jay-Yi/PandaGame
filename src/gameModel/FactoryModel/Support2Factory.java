package gameModel.FactoryModel;

import gameModel.Parts.*;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/17
 */
public class Support2Factory implements HeroFactory{
    private int factoryNumber =2;

    @Override
    public PartsBody addPartsBody() {
        return new SupportBody();
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
        return new SkillForMove();
    }

    public int getFactoryNumber() {
        return factoryNumber;
    }
}