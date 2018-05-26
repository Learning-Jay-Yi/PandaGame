package gameModel.FactoryModel;

import gameModel.Parts.*;

/**
 * @author Jay
 * @version 1.0
 * @since 2018/5/17
 */
public class Warrior2Factory implements HeroFactory{
    private int factoryNumber =2;

    @Override
    public PartsBody addPartsBody() {
        return new WarriorBody();
    }

    @Override
    public PartsAttack addPartsAttack() {
        return new WarriorAttack();
    }

    @Override
    public PartsMove addPartsMove() {
        return new WarriorMove();
    }

    @Override
    public PartsSkills addPartsSkills() {
        return new SkillForMove();
    }

    public int getFactoryNumber() {
        return factoryNumber;
    }
}
