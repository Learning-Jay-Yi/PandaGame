package gameModel.FactoryModel;

import com.google.java.contract.Invariant;

import gameModel.Parts.*;

/**
 * @author Jay
 * @version 1.2
 * @since 2018/5/17
 */

@Invariant("factoryNumber != null")
public class Warrior1Factory implements HeroFactory{
    private int factoryNumber =1;

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
        return new SkillForAttack();
    }

    public int getFactoryNumber() {
        return factoryNumber;
    }
}
